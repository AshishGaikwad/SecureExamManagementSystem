package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class HomeController
 */
//@WebServlet({ "/HomeController", "/Home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.loadPage(request,response,"Home.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		HttpSession lSession = request.getSession();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson(); 
		UserEntity lEntity = (UserEntity)lSession.getAttribute("USER_ENTITY");
		
		String pRequestType = request.getParameter("RequestType").toString().trim();
		
		
		
		switch (pRequestType) {
		case "GetMenus":
			try {		
				out.print(gson.toJson(lScreenDaoImpl.getScreenForUser(lEntity.getUserId())));
			} catch (Exception e) {
				e.printStackTrace();
				out.print("");
			}
			break;

		default:
			break;
		}
		
	}

}
