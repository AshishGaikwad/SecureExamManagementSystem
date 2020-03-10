<%@page import="java.util.Date"%>
<%@page
	import="batu.dev.sem.bundles.examination.entity.ExamRegistrationEntity"%>
<%@page
	import="batu.dev.sem.bundles.examination.daoimpl.ExamRegistrationDaoImpl"%>
<%@page
	import="batu.dev.sem.bundles.examination.dao.ExamRegistrationDao"%>
<%@page import="batu.dev.sem.bundles.examination.entity.QuestionEntity"%>
<%@page
	import="batu.dev.sem.bundles.examination.daoimpl.QuestionDaoImpl"%>
<%@page import="batu.dev.sem.bundles.examination.dao.QuestionDao"%>
<%@page
	import="batu.dev.sem.bundles.examination.entity.ExaminationEntity"%>
<%@page
	import="batu.dev.sem.bundles.examination.daoimpl.ExaminationDaoImpl"%>
<%@page import="batu.dev.sem.bundles.examination.dao.ExaminationDao"%>
<%@page import="batu.dev.sem.bundles.examination.entity.AnswerEntity"%>
<%@page import="java.util.List"%>
<%@page import="batu.dev.sem.bundles.examination.daoimpl.AnswerDaoImpl"%>
<%@page import="batu.dev.sem.bundles.examination.dao.AnswerDao"%>
<%@page import="batu.dev.sem.bundles.UserManagement.entity.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/view/impl/_header.jsp"%>


<%
	long eid = Long.parseLong(request.getAttribute("EID").toString());
	UserEntity lUserEntity = ((UserEntity) session.getAttribute("USER_ENTITY"));
	long uid = lUserEntity.getUserId();

	AnswerDao lAnswerDao = new AnswerDaoImpl();
	ExaminationDao lExaminationDao = new ExaminationDaoImpl();
	QuestionDao lQuestionDao = new QuestionDaoImpl();
	ExamRegistrationDao lExamRegistrationDao = new ExamRegistrationDaoImpl();

	List<AnswerEntity> lAnswerEntities = lAnswerDao.get(eid, uid);
	ExaminationEntity lExaminationEntity = lExaminationDao.get(eid);
	ExamRegistrationEntity lExamRegistrationEntity = lExamRegistrationDao.getByEidAndUid(eid, uid);
	
	
	String lStatus = 	lExamRegistrationEntity.getStatus();
	long time =0;
	if(!lStatus.equalsIgnoreCase("NA"))
	{
		
		time = Long.parseLong(lStatus.split("~")[1]);	
	}
	
	String examTimestamp = new Date(time).toString();
	int attendedQuestion = 0;
	long totalQuestion = lExaminationEntity.geteTotalQue();
	long marks = 0;
	long passingMarks = lExaminationEntity.getePassingMarks();
	long totalMarks = lExaminationEntity.geteTotalMarks();

	String status = "undefined";

	String lResponse = "";

	if (marks >= passingMarks) {
		status = "PASS";
	} else {
		status = "FAILED";
	}

	if (request.getParameter("estatus") != null) {
		if (request.getParameter("estatus").equalsIgnoreCase("301")) {
			//ExamRegistrationEntity lExamRegistrationEntity = lExamRegistrationDao.getByEidAndUid(eid, uid);
			lExamRegistrationEntity.setStatus("C~" + System.currentTimeMillis());
			lExamRegistrationDao.update(lExamRegistrationEntity);
			lResponse = "Exam is completed";

		} else if (request.getParameter("estatus").equalsIgnoreCase("302")) {
			//ExamRegistrationEntity lExamRegistrationEntity = lExamRegistrationDao.getByEidAndUid(eid, uid);
			lExamRegistrationEntity.setStatus("T~" + System.currentTimeMillis());
			lExamRegistrationDao.update(lExamRegistrationEntity);

			lResponse = "Exam is completed by your termination";

		} else if (request.getParameter("estatus").equalsIgnoreCase("303")) {
			
			lExamRegistrationEntity.setStatus("D~" + System.currentTimeMillis());
			lExamRegistrationDao.update(lExamRegistrationEntity);
			lResponse = "You have disqualified due to invalid activities.<br> You have failed this exam";
			status = "FAILED";

		}
	}

	for (AnswerEntity lAnswerEntity : lAnswerEntities) {

		if (lAnswerEntity.getSelctedOption() != 0) {
			attendedQuestion++;
			QuestionEntity lQuestionEntity = lQuestionDao.get(lAnswerEntity.getQId()).get(0);

			if (lAnswerEntity.getSelctedOption() == lQuestionEntity.getCorrectAnswer()) {
				marks = marks + lQuestionEntity.getMarks();
			}

		}
	}
	
	String pas = lUserEntity.getPas();
	
	//System.out.println("pas== "+pas);
	String ps[] = null;
	String photo = "";
	if(pas != null)
	{
		ps = pas.split(",");
	}

	
	if(ps != null)
	{
		photo = "/SecureExamManagementSystem/FILES/"+ps[0];
	}else
	{
		photo = "assets/images/!logged-user.jpg";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>



	<h1 style="text-align: center;">
		<strong>BATU EXAM REPORT CARD</strong>
	</h1>
	<table
		style="height: 38px; border-color: black; margin-left: auto; margin-right: auto;"
		border="solid" width="100%">
		<tbody>
			<tr style="height: 93.5px;">
				<td style="width: 18%; height: 93.5px;"><img
					src="http://localhost:8080/SecureExamManagementSystem/assets/images/logo.png" alt="" width="100%"
					height="100%" /></td>
				<td style="width: 55.5075%; height: 93.5px; text-align: center;">
					<p>
						<strong>BABASAHEB AMBEDKAR TECHNICAL UNIVERSITY</strong>
					</p>
					<p>Vidyavihar, Lonere, Mahar</p>
					<p>ashtra 402103</p>
				</td>
				<td style="width: 17.4925%; height: 93.5px;"><img
					src="<%=photo%>" alt="" width="100%"
					height="100%" /></td>
			</tr>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<table style="height: 32px; width: 594px;">
		<tbody>
			<tr>
				<td style="width: 94px;">Name of the student :&nbsp;</td>
				<td style="width: 239px;">&nbsp; <%=lUserEntity.getFullName()%></td>
			</tr>
			<tr>
				<td style="width: 94px;">DATE OF BIRTH :&nbsp;</td>
				<td style="width: 239px;">&nbsp;<%=lUserEntity.getDateOfBirth()%></td>
			</tr>
			<tr>
				<td style="width: 94px;">Examination Name :&nbsp;</td>
				<td style="width: 239px;">&nbsp;<%=lExaminationEntity.geteId()%>-<%=lExaminationEntity.geteTitle()%></td>
			</tr>
			<tr>
				<td style="width: 94px;">Exam Time :&nbsp;</td>
				<td style="width: 239px;">&nbsp;<%=examTimestamp %></td>
			</tr>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<p>REPORT :&nbsp;</p>
	<table
		style="height: 81px; width: 580px; border-color: black; margin-left: auto; margin-right: auto;"
		border="solid">
		<tbody>
			<tr style="height: 24.5px;">
				<td style="background-color: skyblue;">Total Questions :&nbsp;</td>
				<td style="width: 369px; height: 24.5px;">&nbsp;<%=totalQuestion%></td>
			</tr>
			<tr style="height: 26px;">
				<td style="background-color: skyblue;">Attended Questions :</td>
				<td style="width: 369px; height: 26px;">&nbsp;<%=attendedQuestion%></td>
			</tr>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<table
		style="height: 81px; width: 580px; border-color: black; margin-left: auto; margin-right: auto;"
		border="solid">
		<tbody>
			<tr style="height: 24.5px;">
				<td style="background-color: skyblue;">Total Marks:&nbsp;</td>
				<td style="width: 369px; height: 24.5px;">&nbsp;<%=totalMarks%></td>
			</tr>
			<tr style="height: 26px;">
				<td style="background-color: skyblue;">Obtained Marks:</td>
				<td style="width: 369px; height: 26px;">&nbsp;<%=marks%></td>
			</tr>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<table
		style="height: 81px; width: 580px; border-color: black; margin-left: auto; margin-right: auto;"
		border="solid">
		<tbody>
			<tr style="height: 24.5px;">
				<td style="background-color: skyblue;">Passing Marks&nbsp;</td>
				<td style="width: 369px; height: 24.5px;">&nbsp;<%=passingMarks%></td>
			</tr>
			<tr style="height: 26px;">
				<td style="background-color: skyblue;">STATUS</td>
				<td style="width: 369px; height: 26px;">&nbsp;<%=status%></td>
			</tr>
			<tr style="height: 26px;">
				<td style="background-color: skyblue;">Remark</td>
				<td style="width: 369px; height: 26px;">&nbsp;<%=lResponse%></td>
			</tr>
		</tbody>
	</table>
	<p>&nbsp;</p>
	<br><br>
	<p style="text-align: right;">&nbsp;PRINCIPAL</p>


	
	<%@ include file="/view/impl/_vendor.jsp"%>
	<script type="text/javascript">

	var email = '<%=lUserEntity.getEmail()%>';

		$(window).load(
				function() {
					sendMail($("body").html(), email,
							"Thank you for attending examination");
				})

		$(document).ready(
				function() {

					sendMail($("body").html(), email,
							"Thank you for attending examination");
				})

		function sendMail(pMailBody, pEmail, pSubject) {
			let urlParams = new URLSearchParams();
			urlParams.append("FormType", "SendMail")
			urlParams.append("MailBody", pMailBody)
			urlParams.append("Email", pEmail)
			urlParams.append("Subject", pSubject)
			fetch("/SecureExamManagementSystem/ExaminationController", {
				method : 'POST',
				body : urlParams
			}).then(function(response) {
				return response.text()
			}).then(function(text) {
				$("#QuestionDiv").html(text);
			})
		}
	</script>
</body>
</html>