package batu.dev.sem.bundles.examination.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.instamojo.wrapper.model.PaymentOrder;

import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.bundles.examination.dao.AnswerDao;
import batu.dev.sem.bundles.examination.dao.ExamRegistrationDao;
import batu.dev.sem.bundles.examination.dao.ExaminationDao;
import batu.dev.sem.bundles.examination.dao.PaymentDao;
import batu.dev.sem.bundles.examination.dao.QuestionDao;
import batu.dev.sem.bundles.examination.daoimpl.AnswerDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.ExamRegistrationDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.ExaminationDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.PaymentDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.QuestionDaoImpl;
import batu.dev.sem.bundles.examination.entity.AnswerEntity;
import batu.dev.sem.bundles.examination.entity.ExamRegistrationEntity;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.bundles.examination.entity.QuestionEntity;
import batu.dev.sem.utils.Mailer;
import batu.dev.sem.utils.Payment;
import batu.dev.sem.utils.SMSSender;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class ExaminationController
 */
@WebServlet("/ExaminationController")
public class ExaminationController extends HttpServlet {
	private Gson gson = new Gson();
	ExaminationDao lExaminationDao = new ExaminationDaoImpl();
	PaymentDao lPaymentDao = new PaymentDaoImpl();
	ExamRegistrationDao lExamRegistrationDao = new ExamRegistrationDaoImpl();
	QuestionDao lQuestionDao = new QuestionDaoImpl();
	AnswerDao lAnswerDao = new AnswerDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FormType = request.getParameter("FormType");

		switch (FormType) {
		case "SaveExamination":
			save(request, response);
			break;
		case "UpdateExamination":
			update(request, response);
			break;
		case "GetExaminationListBySubject":
			getExaminationListBySubject(request, response);
			break;
		case "GetExaminationData":
			getExaminationData(request, response);
			break;
		case "GetExaminations":
			getExaminations(request, response);
			break;

		case "ExaminationsDetailsTable":
			examinationsDetailsTable(request, response);
			break;

		case "PaymentLink":
			paymentLink(request, response);
			break;

		case "AppliedExaminationsTable":
			appliedExaminationsTable(request, response);
			break;

		case "SendHT":
			sendHT(request, response);
			break;

		case "StartExaminationPin":
			startExaminationPin(request, response);
			break;
		case "GetCurrQueDetail":
			getCurrQueDetail(request, response);
			break;
		case "SubmitAnswer":
			submitAnswer(request, response);
			break;
		case "SendMail":
			sendMail(request, response);
			break;

		default:
			break;
		}
	}

	private void sendMail(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			System.err.println("Sedn Mail Called");
			
			String lMailBody = request.getParameter("MailBody");
			String lEmail = request.getParameter("Email");
			String lSubject = request.getParameter("Subject");
			
			
			Mailer.sendMail(lEmail, "", lSubject,  lMailBody);
			//Mailer.sendMail(lEmail, "", lSubject,  lMailBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void submitAnswer(HttpServletRequest request, HttpServletResponse response) {
		try {
			long QID = Long.parseLong(request.getParameter("QID"));
			long EID = Long.parseLong(request.getParameter("EID"));
			long UID = Long.parseLong(request.getParameter("UID"));
			long SeletedOption = Long.parseLong(request.getParameter("SelectedOption"));
			AnswerEntity lCurrQueAns = lAnswerDao.get(QID, EID, UID).get(0);
			lCurrQueAns.setSelctedOption(SeletedOption);

			boolean res = lAnswerDao.update(lCurrQueAns);

			if (res)
				response.getWriter().print("1");
			else
				response.getWriter().print("2");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getCurrQueDetail(HttpServletRequest request, HttpServletResponse response) {

		try {
			long QID = Long.parseLong(request.getParameter("QID"));
			long EID = Long.parseLong(request.getParameter("EID"));
			long UID = Long.parseLong(request.getParameter("UID"));

			QuestionEntity lCurrQueDetail = lQuestionDao.get(QID).get(0);
			AnswerEntity lCurrQueAns = lAnswerDao.get(QID, EID, UID).get(0);

			long corOpt = lCurrQueAns.getSelctedOption();

			StringBuilder lBuilder = new StringBuilder();

			lBuilder.append("<div class=\"row\">");
			lBuilder.append("<input type=\"hidden\" id=\"currQID\" value=\"" + QID + "\">");
			lBuilder.append("<input type=\"hidden\" id=\"currEID\" value=\"" + EID + "\">");
			lBuilder.append("<input type=\"hidden\" id=\"currUID\" value=\"" + UID + "\">");

			lBuilder.append("<h1 id=\"currQ\">" + lCurrQueDetail.getQuestion() + "</h1>");

			JSONArray lArray = new JSONArray(lCurrQueDetail.getOptions());

			lBuilder.append("<div id=\"optDiv\">");
			lBuilder.append("<table class=\"table table-bordered\">");

			for (int i = 0; i < lArray.length(); i++) {

				JSONObject lObject = lArray.getJSONObject(i);

				String checked = "";
				if (corOpt == 0) {
					checked = "";
				} else {
					if (lObject.getLong("id") == corOpt) {
						checked = "checked";
					} else {
						checked = "";
					}
				}

				lBuilder.append("<tr>").append("<td>").append(lObject.getLong("id") + ")  ")
						.append("<input type=\"radio\" name=\"option\" id=\"opt-" + lObject.getLong("id")
								+ "\" value=\"" + lObject.getLong("id") + "\"  " + checked + ">")
						.append("</td>").append("<td>").append(lObject.getString("value")).append("</td>")
						.append("</tr>");
			}

			lBuilder.append("</table>");
			lBuilder.append("</div>");

			lBuilder.append("<span style=\"color:orange\">*This is " + lCurrQueDetail.getMarks() + " marks question\r\n"
					+ "</span>");

			// pQId,pEID,pUID
			lBuilder.append("<div><button class=\"btn btn-primary btn-block\" onclick=\"submitAnswer('" + QID + "','"
					+ EID + "','" + UID + "')\">Submit Answer</button></div>");
			lBuilder.append("</div>");

			response.getWriter().print(lBuilder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void startExaminationPin(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");
			long eid = Long.parseLong(request.getParameter("eid").trim());
			String epin = request.getParameter("epin").trim();

			ExamRegistrationEntity lExamRegistrationEntity = lExamRegistrationDao.getByEidAndUid(eid,
					lUserEntity.getUserId());

			if (lExamRegistrationEntity.getPasscode().equalsIgnoreCase("")) {
				request.setAttribute("Error", "Invalid Examination Passcode");
				request.getRequestDispatcher("/exam?action=SE").forward(request, response);
			} else {
				if (lExamRegistrationEntity.getPasscode().equalsIgnoreCase(epin)) {

					System.out.println("pass=code ="+lExamRegistrationEntity.getPasscode());
					
					if (lExamRegistrationEntity.getStatus().equalsIgnoreCase("NA")) {
						lExamRegistrationEntity.setStatus("P~"+System.currentTimeMillis());
						lExamRegistrationEntity.setPasscode("");
						boolean result = lExamRegistrationDao.update(lExamRegistrationEntity);

						if (result) {

							long eCount = lAnswerDao.count(eid, lUserEntity.getUserId());
							// System.out.println(eCount+"==count");
							if (eCount == 0) {
								boolean res = lQuestionDao.insertGenreatedUsersQuestions(lUserEntity.getUserId(), eid,
										lExamRegistrationEntity.getId());
							}

							request.getRequestDispatcher("/exam?action=ED&EID=" + eid).forward(request, response);
						} else {
							request.setAttribute("Error", "Something went rong please try again");
							request.getRequestDispatcher("/exam?action=SE").forward(request, response);
						}

					} else {
						request.setAttribute("Error", "You have already attend this exam");
						request.getRequestDispatcher("/exam?action=SE").forward(request, response);

					}
				} else {
					request.setAttribute("Error", "Invalid Examination PIN");
					request.getRequestDispatcher("/exam?action=SE").forward(request, response);
//			response.sendRedirect("/SecureExamManagementSystem/exam?action=SE");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void sendHT(HttpServletRequest request, HttpServletResponse response) {
		long HallTicketId = Long.parseLong(request.getParameter("HallTicket"));
		UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");
		ExamRegistrationEntity lExamRegistrationEntity = new ExamRegistrationDaoImpl().getByEidAndUid(HallTicketId,
				lUserEntity.getUserId());
		ExaminationEntity lExaminationEntity = new ExaminationDaoImpl().get(lExamRegistrationEntity.getEId());
		Mailer.sendMail(lUserEntity.getEmail(), "", "Exam Reminder with Hall Ticket",
				getHallticket(lUserEntity.getFullName(), lExamRegistrationEntity.getId() + "",
						"" + lExamRegistrationEntity.getPasscode(), "" + lExaminationEntity.geteDate()));

		try {
			response.getWriter()
					.println("Hall Ticket Sent Successfully. Please check your email id : " + lUserEntity.getEmail());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void appliedExaminationsTable(HttpServletRequest request, HttpServletResponse response) {
		UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");
		List<ExaminationEntity> lExaminationEntities = lExamRegistrationDao
				.getAppliedExamination(lUserEntity.getUserId());
		StringBuilder lBuilder = new StringBuilder().append("<table class=\"table table-bordered mb-none\">")
				.append("<thead>" + "                                        <tr>"
						+ "                                            <th>Name</th>"
						+ "                                            <th>Hall Ticket</th>"
						+ "                                            <th>Start Exam</th>"
						+ "                                        </tr>")
				.append("<tbody>");
		for (ExaminationEntity e : lExaminationEntities) {

			lBuilder.append("<tr>");
			lBuilder.append("<td>").append("" + e.geteTitle()).append("</td>");

//				System.out.println("Util.getCurrentDate() =="+Util.getCurrentDate());
//				System.out.println("e.geteHallTicketDate() =="+e.geteHallTicketDate());
//				System.out.println("e.geteDate() =="+e.geteDate());

//				if( Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteHallTicketDate()) == 0 || Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteDate()) == 0 || Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteHallTicketDate()) <= 0 && Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteDate()) >= 0  )
//				System.out.println("Util.compareDates(\"dd/MM/yyyy\", Util.getCurrentDate(),  e.geteHallTicketDate())"+Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteHallTicketDate()));
//				System.out.println("Util.compareDates(\"dd/MM/yyyy\", Util.getCurrentDate(),  e.geteDate())"+Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(),  e.geteDate()));
			if (Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(), e.geteHallTicketDate()) >= 0
					&& Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(), e.geteDate()) <= 0) {
				lBuilder.append("<td>").append("<a  class='send_ht' onclick='sendHT(\"" + e.geteId() + "\")'>"
						+ "Click to Send Hall Ticket" + "</a>").append("</td>");
			} else {
				lBuilder.append("<td>").append("" + e.geteHallTicketDate()).append("</td>");
			}

			if (Util.compareDates("dd/MM/yyyy", Util.getCurrentDate(), e.geteDate()) == 0) {
				lBuilder.append("<td>").append("<button class=\"btn btn-primary\" onclick=\"startExamination('"
						+ e.geteId() + "')\">Start Exam</button>").append("</td>");
			} else {
				lBuilder.append("<td>").append("" + e.geteDate()).append("</td>");
			}

			lBuilder.append("</tr>");

		}

		lBuilder.append("</tbody>").append("</table>");

		try {
			response.getWriter().print(lBuilder.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void paymentLink(HttpServletRequest request, HttpServletResponse response) {
		try {
			ExaminationEntity lExaminationEntity = lExaminationDao
					.get(Long.parseLong(request.getParameter("CurrentExaminationDetails")));
			UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");

			if (lExamRegistrationDao.getByEidAndUid(lExaminationEntity.geteId(), lUserEntity.getUserId()) == null) {
				PaymentOrder order = new PaymentOrder();
				order.setName(lUserEntity.getFullName());
				order.setEmail(lUserEntity.getEmail());
				order.setPhone(lUserEntity.getMobile());
				order.setCurrency("INR");
				order.setAmount(lExaminationEntity.geteFee());
				order.setDescription("Examination fee for " + lExaminationEntity.geteId() + " and for user "
						+ lUserEntity.getUserId());
				order.setRedirectUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")
						+ Util.getProperty("Config", "CURRENT_BASEPACKAGE")
						+ Util.getProperty("Config", "PAYMENT_GATEWAY_REDIRECT"));
				order.setWebhookUrl(Util.getProperty("Config", "CURRENT_HOSTNAME")
						+ Util.getProperty("Config", "CURRENT_BASEPACKAGE")
						+ Util.getProperty("Config", "PAYMENT_GATEWAY_WEBHOOK"));
				order.setTransactionId("BATU-" + lUserEntity.getUserId() + "-" + System.currentTimeMillis());

				PaymentOrder lCreateOrder = Payment.createPayment(order);

				if (lCreateOrder != null) {
					response.getWriter().print(paymentLink(lCreateOrder.getId()));
					boolean ord = lPaymentDao.save(lCreateOrder);
					ExamRegistrationEntity lExamRegistrationEntity = new ExamRegistrationEntity();
					lExamRegistrationEntity.setEId(lExaminationEntity.geteId());
					lExamRegistrationEntity.setUId(lUserEntity.getUserId());
					lExamRegistrationEntity.setPId(lCreateOrder.getTransactionId());
					lExamRegistrationEntity.setPasscode("" + SMSSender.getOTP());
					lExamRegistrationEntity.setStatus("NA");

					lExamRegistrationDao.save(lExamRegistrationEntity);

					// ExamRegistrationEntity lReponseEntity =
					// lExamRegistrationDao.getByEidAndUid(lExaminationEntity.geteId(),
					// lUserEntity.getUserId());
//					Mailer.sendMail(lUserEntity.getEmail(), "", "Exam Reminder with Hall Ticket", getHallticket(lUserEntity.getFullName(),lReponseEntity.getId()+"",""+lReponseEntity.getPasscode(),""+lExaminationEntity.geteDate()) );

				} else {
					response.getWriter().print("400");
				}
			} else {
				response.getWriter().print("998");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String paymentLink(String pOid) {
		return Util.getProperty("Config", "PAYMENT_GATEWAY_LINK") + "@"
				+ Util.getProperty("Config", "PAYMENT_GATEWAY_USERNAME") + "/" + pOid + "?embed=form";
	}

	private void examinationsDetailsTable(HttpServletRequest request, HttpServletResponse response) {
		try {
			ExaminationEntity lExaminationEntity = lExaminationDao
					.get(Long.parseLong(request.getParameter("ExaminationId").trim()));

			StringBuilder lBuilder = new StringBuilder().append("<table class=\"table table-bordered mb-none\">")
					.append("<tbody>");
			lBuilder.append("<tr><td>Examination Id</td>").append("<td>").append(lExaminationEntity.geteId())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Examination Title</td>").append("<td>").append(lExaminationEntity.geteTitle())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Total Questions </td>").append("<td>").append(lExaminationEntity.geteTotalQue())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Total Marks </td>").append("<td>").append(lExaminationEntity.geteTotalMarks())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Passing Marks </td>").append("<td>").append(lExaminationEntity.getePassingMarks())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Examination Duration </td>").append("<td>")
					.append(lExaminationEntity.geteDuration()).append("</td></tr>");
			lBuilder.append("<tr><td>Examination Description</td>").append("<td>")
					.append(lExaminationEntity.geteDescription()).append("</td></tr>");
			lBuilder.append("<tr><td>Admission Start Date </td>").append("<td>")
					.append(lExaminationEntity.geteAdmissionStartDate()).append("</td></tr>");
			lBuilder.append("<tr><td>Admission Start Date </td>").append("<td>")
					.append(lExaminationEntity.geteAdmissionLastDate()).append("</td></tr>");
			lBuilder.append("<tr><td>Hall Ticket  Date </td>").append("<td>")
					.append(lExaminationEntity.geteHallTicketDate()).append("</td></tr>");
			lBuilder.append("<tr><td>Examination Date </td>").append("<td>").append(lExaminationEntity.geteDate())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Result Date </td>").append("<td>").append(lExaminationEntity.geteResultDate())
					.append("</td></tr>");
			lBuilder.append("<tr><td>Examination Fee</td>").append("<td>").append(lExaminationEntity.geteFee())
					.append("</td></tr>");
			lBuilder.append("</tbody>").append("</table>");

			response.getWriter().print(lBuilder.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getExaminations(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().print(gson.toJson(lExaminationDao.get()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject body = new JSONObject(request.getParameter("Body"));

			ExaminationEntity lExaminationEntity = new ExaminationEntity();
			lExaminationEntity.seteId(Long.parseLong(request.getParameter("ExaminationId")));
			lExaminationEntity.seteTitle(body.getString("eTitle"));
			lExaminationEntity.seteSubjectId(body.getLong("SubjectList"));
			lExaminationEntity.seteTotalQue(body.getLong("TotalQuestions"));
			lExaminationEntity.seteMarkQueDetails(body.getString("MarkQueDetails"));
			lExaminationEntity.seteTotalMarks(body.getLong("TotalMarks"));
			lExaminationEntity.setePassingMarks(body.getLong("PassingMarks"));
			lExaminationEntity.seteDuration(body.getLong("ExamDuration"));
			lExaminationEntity.seteDescription(body.getString("Description"));
			lExaminationEntity.seteAdmissionStartDate(body.getString("AdmissionStartDate"));
			lExaminationEntity.seteAdmissionLastDate(body.getString("AdmissionEndDate"));
			lExaminationEntity.seteHallTicketDate(body.getString("HallTicketDate"));
			lExaminationEntity.seteDate(body.getString("ExaminationDate"));
			lExaminationEntity.seteResultDate(body.getString("ResultDate"));
			lExaminationEntity.seteDate(body.getString("ExaminationDate"));
			lExaminationEntity.seteFee(body.getDouble("ExaminationFee"));
			lExaminationEntity.seteIsActive(body.getInt("IsActive"));
			response.getWriter().print(lExaminationDao.update(lExaminationEntity));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Something went wrong please try again.", "error"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void getExaminationData(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().print(
					gson.toJson(lExaminationDao.get(Long.parseLong(request.getParameter("ExaminationId").trim()))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void getExaminationListBySubject(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().print(
					gson.toJson(lExaminationDao.getOnSubjectId(Long.parseLong(request.getParameter("SubjectId")))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject body = new JSONObject(request.getParameter("Body"));

			ExaminationEntity lExaminationEntity = new ExaminationEntity();
			lExaminationEntity.seteTitle(body.getString("eTitle"));
			lExaminationEntity.seteSubjectId(body.getLong("SubjectList"));
			lExaminationEntity.seteTotalQue(body.getLong("TotalQuestions"));
			lExaminationEntity.seteMarkQueDetails(body.getString("MarkQueDetails"));
			lExaminationEntity.seteTotalMarks(body.getLong("TotalMarks"));
			lExaminationEntity.setePassingMarks(body.getLong("PassingMarks"));
			lExaminationEntity.seteDuration(body.getLong("ExamDuration"));
			lExaminationEntity.seteDescription(body.getString("Description"));
			lExaminationEntity.seteAdmissionStartDate(body.getString("AdmissionStartDate"));
			lExaminationEntity.seteAdmissionLastDate(body.getString("AdmissionEndDate"));
			lExaminationEntity.seteHallTicketDate(body.getString("HallTicketDate"));
			lExaminationEntity.seteDate(body.getString("ExaminationDate"));
			lExaminationEntity.seteResultDate(body.getString("ResultDate"));
			lExaminationEntity.seteDate(body.getString("ExaminationDate"));
			lExaminationEntity.seteFee(body.getDouble("ExaminationFee"));
			lExaminationEntity.seteIsActive(body.getInt("IsActive"));
			response.getWriter().print(lExaminationDao.create(lExaminationEntity));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Something went wrong please try again.", "error"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public String getHallticket(String pUserName, String pExamId, String pExamPin, String pExamDate) {
		return "<p><strong>Dear " + pUserName + ",</strong></p>\r\n" + "<p><em>Thank You For Application. </em></p>\r\n"
				+ "<p><em>You have successfully registered for the examination.</em></p>\r\n" + "<p>&nbsp;</p>\r\n"
				+ "<p>Please Note the below Details during examination :</p>\r\n"
				+ "<table style=\"height: 274px; width: 370px;\" border=\"black\">\r\n" + "<tbody>\r\n"
				+ "<tr style=\"height: 15px;\">\r\n"
				+ "<td style=\"background-color: #a9cce3; height: 15px;\">Examination Id&nbsp;</td>\r\n"
				+ "<td style=\"width: 230px; height: 15px;\">" + pExamId + "</td>\r\n" + "</tr>\r\n"
				+ "<tr style=\"height: 16px;\">\r\n"
				+ "<td style=\"background-color: #a9cce3; height: 16px;\">Examination Pin&nbsp;&nbsp;</td>\r\n"
				+ "<td style=\"width: 230px; height: 16px;\">" + pExamPin + "</td>\r\n" + "</tr>\r\n"
				+ "<tr style=\"height: 4px;\">\r\n"
				+ "<td style=\"background-color: #a9cce3; height: 4px;\">Exam Date&nbsp;</td>\r\n"
				+ "<td style=\"width: 230px; height: 4px;\">" + pExamDate + "</td>\r\n" + "</tr>\r\n" + "</tbody>\r\n"
				+ "</table>\r\n" + "<p>&nbsp;</p>\r\n" + "<p><strong>NOTE:</strong></p>\r\n" + "<ul>\r\n"
				+ "<li>Please attend between 00:00 PM TO 23:00 On the date of examination.</li>\r\n"
				+ "<li>If exam is not conducted on date result will not displayed.</li>\r\n"
				+ "<li>If any copy case candidate will dissqualified.</li>\r\n"
				+ "<li>Exam ammount will not be refunded.</li>\r\n" + "</ul>\r\n"
				+ "<p style=\"text-align: center;\"><strong>ALL THE BEST<img src=\"https://html5-editor.net/tinymce/plugins/emoticons/img/smiley-laughing.gif\" alt=\"laughing\" /></strong></p>\r\n"
				+ "<p><span style=\"color: #0000ff;\"><strong>Regard,</strong></span></p>\r\n"
				+ "<p><span style=\"color: #0000ff;\"><strong>Babasaheb Ambedkar&nbsp;</strong></span></p>\r\n"
				+ "<p><span style=\"color: #0000ff;\"><strong>Technical University</strong></span></p>";
	}

}
