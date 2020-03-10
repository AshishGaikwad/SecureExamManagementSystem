package batu.dev.sem.bundles.examination.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sun.jmx.snmp.Timestamp;

import batu.dev.sem.bundles.UserManagement.dao.UserDao;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserRoleMappingDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.Mailer;
import batu.dev.sem.utils.SMSSender;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private UserDao lUserDao = new UserDaoImpl();
	private UserRoleMappingDaoImpl lUserRoleMappingDaoImpl = new UserRoleMappingDaoImpl();
	Gson gson = new Gson();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String FormType = request.getParameter("FormType");

		switch (FormType) {
		case "SendMobileOTP":
			sendMobileOTP(request, response);
			break;
		case "ValidateMobileOTP":
			validateMobileOTP(request, response);
			break;

		case "SendEmailOTP":
			sendEmailOTP(request, response);
			break;
		case "ValidateEmailOTP":
			validateEmailOTP(request, response);
			break;
		case "RegisterStudent":
			registerStudent(request, response);
			break;

		default:
			break;
		}

	}

	private void validateMobileOTP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String MobileNo = request.getParameter("MobileNo");
		String OTP = request.getParameter("OTP");
		String SessionOTP = request.getSession().getAttribute("MobileLastOTP").toString();
		boolean BypassOTPFlag = Boolean.parseBoolean(Util.getProperty("Config", "BYPASS_OTP_FLAG"));

		System.out.println("SESS  " + SessionOTP);
		System.out.println("MobileNo+\"~\"+OTP  " + MobileNo + "~" + OTP);

		if ((MobileNo + "~" + OTP).equals(SessionOTP)) {
			response.getWriter().print("VALIDATED");
			return;
		} else if (BypassOTPFlag) {
			String BypassOTP = Util.getProperty("Config", "BYPASS_OTP");
			if (OTP.equals(BypassOTP)) {
				response.getWriter().print("VALIDATED");
				return;
			} else {
				response.getWriter().print("INVALID");
				return;
			}

		}

		else {
			response.getWriter().print("INVALID");
			return;
		}

	}

	private void sendMobileOTP(HttpServletRequest request, HttpServletResponse response) {

		try {
			String MobileNo = request.getParameter("MobileNo");
			int OTP = SMSSender.getOTP();
			request.getSession().setAttribute("MobileLastOTP", MobileNo + "~" + OTP);

			System.out.println("DERING SEND  " + MobileNo + "~" + OTP);

			String OTPMessage = "Your One Time Password is : " + OTP;
			try {
				int s = SMSSender.sendSMS(MobileNo, OTPMessage);
				response.getWriter().print("" + s);
			} catch (Exception e1) {
				response.getWriter().print("" + -2);
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void sendEmailOTP(HttpServletRequest request, HttpServletResponse response) {

		try {
			String lEmail = request.getParameter("EmailId");
			int OTP = SMSSender.getOTP();
			UserEntity lUserEntity = lUserDao.getUser(lEmail);

			if (lUserEntity == null) {
				request.getSession().setAttribute("EmailLastOTP", OTP);

				System.out.println("DERING SEND  " + OTP);

				String OTPMessage = "Your One Time Password is : " + OTP;

				boolean s = Mailer.sendMail("" + lEmail, "", "Validation For BATU online examination portal",
						"" + OTPMessage);

				if (s)
					response.getWriter().print("" + 200);
				else
					response.getWriter().print("" + -1);
			} else
				response.getWriter().print("" + -2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void validateEmailOTP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String EmailId = request.getParameter("EmailId");
		String OTP = request.getParameter("OTP");
		String SessionOTP = request.getSession().getAttribute("EmailLastOTP").toString();
		boolean BypassOTPFlag = Boolean.parseBoolean(Util.getProperty("Config", "BYPASS_OTP_FLAG"));

		System.out.println("SESS  " + SessionOTP);
		System.out.println("MobileNo+\"~\"+OTP  " + EmailId + "~" + OTP);

		if ((OTP).equals(SessionOTP)) {
			response.getWriter().print("VALIDATED");
			return;
		} else if (BypassOTPFlag) {
			String BypassOTP = Util.getProperty("Config", "BYPASS_OTP");
			if (OTP.equals(BypassOTP)) {
				response.getWriter().print("VALIDATED");
				return;
			} else {
				response.getWriter().print("INVALID");
				return;
			}

		}

		else {
			response.getWriter().print("INVALID");
			return;
		}

	}

	private void registerStudent(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		
		try {
			HttpSession lHttpSession = request.getSession();
			UserEntity lEntity = (UserEntity) lHttpSession.getAttribute("USER_ENTITY");
			out = response.getWriter();
			String body = request.getParameter("Body");
			
			UserEntity lUserEntity = gson.fromJson(body, UserEntity.class);
			lUserEntity.setStatus(1);
			lUserEntity.setCreatedAt("" + new Timestamp(System.currentTimeMillis()).getDateTime());
			lUserEntity.setCreatedBy(1);
			lUserEntity.setUpdatedAt("" + new Timestamp(System.currentTimeMillis()).getDateTime());
			lUserEntity.setUpdatedBy(1);
			
			long resp = lUserDao.createUserWithReponse(lUserEntity);
			
			
			if (resp == 0 || resp == 2) {
				
				
				if(resp == 0)
					
					out.print(Util.nofity(Util.getProperty("responses", 0 + ""),"error"));
				else
					out.print(Util.nofity(Util.getProperty("responses", 2 + ""),"error"));
				
			}
			else
				out.print(Util.nofity(Util.getProperty("responses", 1 + ""),"success"));
			String[] lRoles = Util.getProperty("Config", "STUDENT_ROLE_ID").split(",");

			for (String string : lRoles) {
				MappingEntity lMappingEntity = new MappingEntity();
				lMappingEntity.setUserId(resp);
				lMappingEntity.setRoleId(new Long(string));
				lMappingEntity.setRowstate(1);
				lUserRoleMappingDaoImpl.create(lMappingEntity);
			}
			
			Mailer.sendMail(lUserEntity.getEmail(), "", "User Creation Reminder | BATU-SEMS", creationMessage(lUserEntity, "Created"));
			SMSSender.sendSMS(lUserEntity.getMobile(), "Dear "+lUserEntity.getFullName()+"We have created your user in our System. Find more details in your e-mail");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print(Util.nofity("Something went wrong ","error"));
			
		}
	}
	
	
	private String creationMessage(UserEntity lEntity, String status) {
		return "<p>Dear "+lEntity.getFullName()+",</p>\r\n" + 
				"<p>\r\n" + 
				"  <br>\r\n" + 
				"</p>\r\n" + 
				"<p>We have "+status+" your user in our SYSTEM.</p>\r\n" + 
				"<p>Your credentials are below:</p>\r\n" + 
				"<table style=\"width: 96%; margin-left: calc(4%);\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"width: 50%; background-color: rgb(209, 213, 216);\">USERNAME</td>\r\n" + 
				"      <td style=\"width: 50.0000%;\">"+lEntity.getEmail()+"</td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"width: 50%; background-color: rgb(209, 213, 216);\">PASSWORD</td>\r\n" + 
				"      <td style=\"width: 50.0000%;\">"+lEntity.getPassword()+"</td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td style=\"width: 50%; background-color: rgb(209, 213, 216);\">URL</td>\r\n" + 
				"      <td style=\"width: 50.0000%;\">"+Util.getProperty("Config","PROJECT_URL")+"</td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"<p>Please change password after login for your security.</p>\r\n" + 
				"<p>Thank You.</p>\r\n" + 
				"<p><span style=\"color: rgb(84, 172, 210);\"><strong>Regards ,</strong></span></p>\r\n" + 
				"<p><strong><span style=\"color: rgb(84, 172, 210);\">Admin&nbsp;</span></strong></p>\r\n" + 
				"<p><strong><span style=\"color: rgb(84, 172, 210);\">BATU&nbsp;</span></strong></p>\r\n" + 
				"<p><span style=\"color: rgb(84, 172, 210);\"><strong>Secure Exam Managment System.</strong></span></p>\r\n" + 
				"<p>\r\n" + 
				"  <br>\r\n" + 
				"</p>";
	}
}
