package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import batu.dev.sem.bundles.UserManagement.dao.UserDao;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserRoleMappingDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.CacheLoader;
import batu.dev.sem.utils.Util;

//@WebServlet({ "/LoginController", "/Login" })
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String lFormId = request.getParameter("lFormId").toString();
		UserDao lUserDao = new UserDaoImpl();
		UserRoleMappingDaoImpl role = new UserRoleMappingDaoImpl();
		HttpSession lHttpSession = request.getSession();
		UserEntity lUserEntity = null;
		switch (lFormId) {
		case "LoginRequest":
			try {
				String lEmail = request.getParameter("lEmail").toString();
				String lPassword = request.getParameter("lPassword").toString();
				
				int result = lUserDao.validateUser(lEmail, lPassword);
				if (result == 9) {
					lUserEntity = lUserDao.getUser(lEmail);
					lUserEntity.setPassword(("HASHING789"+lUserEntity.getPassword()+"H-"+new Random().nextLong()).hashCode()+"");
					lHttpSession.setAttribute("USER_ENTITY", lUserEntity);
					lHttpSession.setAttribute("USER_ROLES", role.getUserRolesCSV(lUserEntity.getUserId()));
					
					CacheLoader.getInstance().lastRequest().put(""+lUserEntity.getEmail(), System.currentTimeMillis());
					CacheLoader.getInstance().userMap().put(""+lUserEntity.getEmail(), lUserEntity.getPassword());
					
//					System.out.println("UserCache Now  =="+CacheLoader.getInstance().userMap().toString());
					lHttpSession.setAttribute("ACTIVATED", true);
					out.print("ACTIVATED");
					
				} else {
					out.print("" + Util.getProperty("responses", String.valueOf(result)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			out.print("Invalid Request Id");
			break;
		}

	}

}
