package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession lHttpSession = request.getSession();
		UserEntity lUserEntity = (UserEntity) lHttpSession.getAttribute("USER_ENTITY");
		Util.logout(request,response, lUserEntity.getEmail());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
