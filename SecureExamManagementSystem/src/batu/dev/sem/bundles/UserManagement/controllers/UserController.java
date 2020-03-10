package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.jmx.snmp.Timestamp;

import batu.dev.sem.bundles.UserManagement.daoimpl.RoleScreenMappingDaoImpl;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserRoleMappingDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.Mailer;
import batu.dev.sem.utils.SMSSender;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class RoleController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession lHttpSession = request.getSession();
		UserEntity lEntity = (UserEntity) lHttpSession.getAttribute("USER_ENTITY");
		UserDaoImpl lUserDaoImpl = new UserDaoImpl();
		UserRoleMappingDaoImpl lUserRoleMappingDaoImpl = new UserRoleMappingDaoImpl();
		PrintWriter out = response.getWriter();
//		ResourceBundle lResponseBundle = Util.ResourceBundle.getBundle("responses");
//		System.out.println("Got Hit");
		String lRequestType = request.getParameter("RequestType");
		Gson gson = new Gson();

		switch (lRequestType) {

		case "AddNewUser":
			try {
//				System.out.println(request.getParameter("RolesData") + " request.getParameter(\"Roles\")");
				UserEntity lUserEntity = new UserEntity();
				lUserEntity.setFullName(request.getParameter("FullName"));
				lUserEntity.setEmail(request.getParameter("EmailId"));
				lUserEntity.setDateOfBirth(request.getParameter("DateOfBirth"));
				lUserEntity.setMobile(request.getParameter("MobileNo"));
				lUserEntity.setStatus(Integer.parseInt(request.getParameter("Status")));
				lUserEntity.setPassword(request.getParameter("Password"));
				lUserEntity.setCreatedAt("" + new Timestamp(System.currentTimeMillis()).getDateTime());
				lUserEntity.setCreatedBy(lEntity.getUserId());
				lUserEntity.setUpdatedAt("" + new Timestamp(System.currentTimeMillis()).getDateTime());
				lUserEntity.setUpdatedBy(lEntity.getUserId());
				long resp = lUserDaoImpl.createUserWithReponse(lUserEntity);
//				System.out.println("resp == " + resp);

				if (resp == 0 || resp == 2) {
					
					
					if(resp == 0)
						out.print(Util.getProperty("responses", 1 + ""));
					else
						out.print(Util.getProperty("responses", 1 + ""));
					
				}
				else
					out.print(Util.getProperty("responses", 1));
				String[] lRoles = request.getParameter("RolesData").trim().split(",");

				for (String string : lRoles) {
					MappingEntity lMappingEntity = new MappingEntity();
					lMappingEntity.setUserId(resp);
					lMappingEntity.setRoleId(new Long(string));
					lMappingEntity.setRowstate(1);
					lUserRoleMappingDaoImpl.create(lMappingEntity);
				}
				
				Mailer.sendMail(lUserEntity.getEmail(), "", "User Creation Reminder | BATU-SEMS", creationMessage(lUserEntity, "Created"));
				SMSSender.sendSMS(lUserEntity.getMobile(), "Dear "+lUserEntity.getFullName()+"We have created your user in our System. Find more details in your e-mail");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			break;
			
			
			
		case "EditNewUser":
			
			try {
				UserEntity lEditUserEntity = new UserEntity();
				lEditUserEntity.setFullName(request.getParameter("FullName"));
				lEditUserEntity.setEmail(request.getParameter("EmailId"));
				lEditUserEntity.setDateOfBirth(request.getParameter("DateOfBirth"));
				lEditUserEntity.setMobile(request.getParameter("MobileNo"));
				lEditUserEntity.setStatus(Integer.parseInt(request.getParameter("Status")));
				lEditUserEntity.setPassword(request.getParameter("Password"));
				lEditUserEntity.setUpdatedAt("" + new Timestamp(System.currentTimeMillis()).getDateTime());
				lEditUserEntity.setUpdatedBy(lEntity.getUserId());
				lEditUserEntity.setUserId(Long.parseLong(request.getParameter("UserId")));
				long respEdit = lUserDaoImpl.updateUser(lEditUserEntity);
				if (respEdit == 0 || respEdit == 2)
					out.print(Util.getProperty("responses", respEdit + ""));
				else
					out.print(Util.getProperty("responses", 13));
				String[] lRolesEdit = request.getParameter("RolesData").trim().split(",");

				if(lUserRoleMappingDaoImpl.delete(lEntity.getUserId()) == 13)
				{
					for (String string : lRolesEdit) {
						MappingEntity lMappingEntity = new MappingEntity();
						lMappingEntity.setUserId(lEditUserEntity.getUserId());
						lMappingEntity.setRoleId(new Long(string));
						lMappingEntity.setRowstate(1);
						lUserRoleMappingDaoImpl.create(lMappingEntity);
					}
				}
				


				Mailer.sendMail(lEditUserEntity.getEmail(), "", "User Update Reminder | BATU", creationMessage(lEditUserEntity, "Updated"));
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(Util.getProperty("responses", 12+""));
			}

			break;	
			

		case "GetAllUser":
			out.print(gson.toJson(lUserDaoImpl.getUser()));

			break;

		case "GetUser":
//			System.out.println("user   " + request.getParameter("UserId"));
			out.print(new JSONObject(
					gson.toJson(lUserDaoImpl.getUser(Long.parseLong(request.getParameter("UserId").toString()))))
							.append("Roles", lUserRoleMappingDaoImpl
									.getUserRolesCSV(Long.parseLong(request.getParameter("UserId").toString()))));

			break;

		default:
			break;
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
