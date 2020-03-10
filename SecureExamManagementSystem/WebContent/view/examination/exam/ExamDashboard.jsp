<!doctype html>
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
<html class="fixed">

<%@ include file="/view/impl/_header.jsp"%>
<%
	long eid = Long.parseLong(request.getParameter("EID"));
	UserEntity lUserEntity = ((UserEntity) session.getAttribute("USER_ENTITY"));
	long uid = lUserEntity.getUserId();

	ExaminationDao lExaminationDao = new ExaminationDaoImpl();

	ExaminationEntity lExaminationEntity = lExaminationDao.get(eid);
	AnswerDao lAnswerDao = new AnswerDaoImpl();
	List<AnswerEntity> lAnswerEntities = lAnswerDao.get(eid, uid);
%>
<style>
div.lds-dual-ring .startup-count {
	text-align: center;
	font-size: 36px;
	padding-top: 30px;
}

div.lds-dual-ring {
	background: rgba(0, 0, 0);
}
</style>
<body>


	<section class="body">
	<input type="hidden" id="exam" value="<%=eid%>">
	<input type="hidden" id="user" value="<%=uid%>">

		<div class="lds-dual-ring"></div>
		<!-- start: header -->
		<header class="header">
			<div class="logo-container">
				<%-- <div style="font-size: 12px; text-decoration: blink; font-weight: bold;">
					 <span >User Name :<%=lUserEntity.getFullName()%></span>
				</div> --%>
			</div>
			<div class="header-right">

				<span class="separator"></span>

				<div id="userbox" class="userbox">
					<div
						style="font-size: 16px; text-decoration: blink; font-weight: bold;">
						<span>User Name :<%=lUserEntity.getFullName()%></span>
					</div>
				</div>

				<span class="separator"></span>

				<div id="userbox" class="userbox">
					<div
						style="font-size: 21px; text-decoration: blink; font-weight: bold;">
						Total Marks : <span><%=lExaminationEntity.geteTotalMarks()%></span>
					</div>
				</div>



				<span class="separator"></span>

				<div id="userbox" class="userbox">
					<div
						style="font-size: 21px; text-decoration: blink; font-weight: bold; color: red">
						Time left : <span id="tlm"><%=lExaminationEntity.geteDuration()%></span>:<span
							id="tls">00</span>
					</div>
				</div>
			</div>
		</header>
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<aside id="sidebar-left" class="sidebar-left">

				<div class="sidebar-header">
					<div class="sidebar-title" style="color: white">Questions</div>
					<!-- <div class="sidebar-toggle hidden-xs"
						data-toggle-class="sidebar-left-collapsed" data-target="html"
						data-fire-event="sidebar-left-toggle">
						<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
					</div> -->
				</div>

				<div class="nano">
					<div class="nano-content">
						<nav id="menu" class="nav-main" role="navigation">
							<ul class="nav nav-main">
								<%
									try {
										int i = 0;
										for (AnswerEntity lEntity : lAnswerEntities) {
											i++;
								%>
								<li class="nav-active"><a href="#" id="Q-<%=i%>"
									onclick="getCurrQuestion('<%=lEntity.getQId()%>','<%=eid%>','<%=uid%>')">
										<i class="" aria-hidden="true"></i> <span>Question <%=i%></span>
								</a></li>
								<%
									}
									} catch (Exception e) {
										System.out.println("Ex== " + e.getMessage());

									}
								%>





							</ul>

						</nav>
					</div>

				</div>

			</aside>
			<!-- end: sidebar -->

			<section role="main" class="content-body">
				<header class="page-header">
					<h2>
						<span id="ETitle"><%=lExaminationEntity.geteTitle()%></span>
					</h2>

					<div class="right-wrapper pull-right">
						<span class="breadcrumbs">
							<button class="btn btn-warning" id="EndExam">End Exam</button>
							<button class="btn btn-warning invisible">C</button>
						</span>
					</div>

				</header>
				<h3 id="temQue"></h3>
				<div id="QuestionDiv">
					<!-- <input type="hidden" id="currQID" value=""> -->
					<!-- <div class="row">
						<input type="hidden" id="currQID" value="">
						<input type="hidden" id="currEID" value="">
						<input type="hidden" id="currUID" value="">
						
						<h1 id="currQ">Q1. What is xmcxx,,xxxxxxxxxxxxxxxxxxx?</h1>
						<div id="optDiv">
							<table class="table table-bordered">
								<tr>
									<td>
										1) <input type="radio" name="option" id="opt-" value="1">
									</td>
									<td>
										Optiisn fjksahfasfjklnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
										asfkljjjjjjjjjjjj
										asfiahsflii
									
									</td>
								</tr>							
							</table>
						</div>
						<div>
							<button class="btn btn-primary btn-block" onclick="submitAnswer()">Submit Answer</button>
						</div>

					</div> -->

				</div>
			</section>
		</div>
	</section>

	<%@ include file="/view/impl/_vendor.jsp"%>
	<script src="/SecureExamManagementSystem/res/js/exam-dashboard.js"></script>

</body>
</html>