package batu.dev.sem.bundles.examination.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.instamojo.wrapper.model.PaymentOrder;

import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.bundles.examination.dao.PaymentDao;
import batu.dev.sem.bundles.examination.daoimpl.ExamRegistrationDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.ExaminationDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.PaymentDaoImpl;
import batu.dev.sem.bundles.examination.entity.ExamRegistrationEntity;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.utils.Mailer;
import batu.dev.sem.utils.Payment;

/**
 * Servlet implementation class PaymentRedirect
 */
@WebServlet("/PaymentRedirect")
public class PaymentRedirect extends HttpServlet {
	private PaymentDao lPaymentDao = new PaymentDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String transactionId = request.getParameter("transaction_id").toString();
		PaymentOrder paymentOrder = Payment.getPaymentDetails(transactionId);
		boolean result = lPaymentDao.update(paymentOrder);

		String payStatus = paymentOrder.getPayments().get(0).getStatus();

		System.out.println("payStatus == " + payStatus);
		System.out.println("payment reponse : " + result);

		if (payStatus.equalsIgnoreCase("successful")) {

			ExamRegistrationEntity lExamRegistrationEntity = new ExamRegistrationDaoImpl().getByPid(paymentOrder.getTransactionId());
			
			//System.out.println("lExamRegistrationEntity.getUId() == "+lExamRegistrationEntity.getUId());
			UserEntity lUserEntity = new UserDaoImpl().getUser(lExamRegistrationEntity.getUId());
			
		//	System.out.println("lExamRegistrationEntity.getEId() == "+lExamRegistrationEntity.getEId());
			ExaminationEntity lExaminationEntity = new ExaminationDaoImpl().get(lExamRegistrationEntity.getEId());
			
			
//			System.out.println("lExamRegistrationEntity == "+lExamRegistrationEntity);
//			System.out.println("lUserEntity == "+lUserEntity);
//			System.out.println("lExaminationEntity == "+lExaminationEntity);

			Mailer.sendMail(lUserEntity.getEmail(), "", "Exam Reminder with Hall Ticket",
					getHallticket(lUserEntity.getFullName(), lExamRegistrationEntity.getId() + "",
							"" + lExamRegistrationEntity.getPasscode(), "" + lExaminationEntity.geteDate()));
			
			
			
			response.getWriter().println("Payment Successful. ");
			response.getWriter().println("Redirecting to Home Page please wait ...");
			
			
		}else
		{
			response.getWriter().println("Payment Failed. ");
			response.getWriter().println("Redirecting to Home Page please wait ...");
		}

		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/SecureExamManagementSystem/Home");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String getHallticket(String pUserName, String pExamId, String pExamPin, String pExamDate) {
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
