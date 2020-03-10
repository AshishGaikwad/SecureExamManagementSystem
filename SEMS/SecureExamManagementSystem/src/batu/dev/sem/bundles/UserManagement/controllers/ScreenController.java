package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class ScreenController
 */
//@WebServlet({ "/ScreenController", "/screen" })
public class ScreenController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession lHttpSession =request.getSession();
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		PrintWriter out = response.getWriter();
//		ResourceBundle lResponseBundle = Util.ResourceBundle.getBundle("responses");
		
		String lRequestType = request.getParameter("RequestType");
		Gson gson = new Gson();
		
		
		switch (lRequestType) {
		case "GetScreenParentList":
			List<ScreenEntity> pScreenList = lScreenDaoImpl.getScreenAll("WHERE screens.screen_url = '#'");
//			System.out.println("pScreenList =="+pScreenList);
			out.print(gson.toJson(pScreenList));
			break;
			
		case "CreateScreen":
			ScreenEntity lPutScreenEntity = new ScreenEntity();
			lPutScreenEntity.setScreenName(request.getParameter("ScreenName").toString());
			lPutScreenEntity.setScreenParentId(new Long(request.getParameter("ScreenParent").toString()));
			lPutScreenEntity.setScreenUrl(request.getParameter("ScreenUrl").toString());
			lPutScreenEntity.setScreenMenuIcon(request.getParameter("ScreenIcon").toString());
			lPutScreenEntity.setScreenMenuLevel("0");
			lPutScreenEntity.setRowstate(1);
			int lPutScreenResult = lScreenDaoImpl.create(lPutScreenEntity);
			out.print(lPutScreenResult+"~"+Util.getProperty("responses",String.valueOf(lPutScreenResult)));
			break;	
			
		case "GetAllScreens":
			List<ScreenEntity> pScreenList1 = lScreenDaoImpl.getScreenAll("");
//			System.out.println("pScreenList =="+pScreenList1);
			out.print(gson.toJson(pScreenList1));
			break;	

		default:
			break;
		}
		
		
		
		
	}

}
