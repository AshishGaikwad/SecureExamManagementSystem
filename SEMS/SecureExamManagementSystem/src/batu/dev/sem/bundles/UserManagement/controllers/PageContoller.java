package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;

/**
 * Servlet implementation class PageContoller
 */
//@WebServlet({ "/PageContoller", "/page_loader" })
public class PageContoller extends HttpServlet {
	Gson gson =  new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("token").toString());
		
		String lData = new String(Base64.getDecoder().decode(request.getParameter("token").replace(" ", "+")));
//		System.out.println("lData=="+lData);
		
		ScreenEntity lScreenEntity = (ScreenEntity) gson.fromJson(lData, ScreenEntity.class);
		RequestDispatcher lRequestDispatcher = request.getRequestDispatcher("/view/"+lScreenEntity.getScreenUrl());
		lRequestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
