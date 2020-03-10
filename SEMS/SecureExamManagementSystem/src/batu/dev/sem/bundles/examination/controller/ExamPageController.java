package batu.dev.sem.bundles.examination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExamPageController
 */
@WebServlet("/exam")
public class ExamPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lPageName = request.getParameter("action");

		RequestDispatcher lDispatch = null;
		if (lPageName != null) {

			if (lPageName.equalsIgnoreCase("SE")) {
				lDispatch = request.getRequestDispatcher("/view/examination/exam/StartExam.jsp");
				request.setAttribute("EID", request.getParameter("eid"));
			} 
			else if (lPageName.equalsIgnoreCase("ED")) {
				lDispatch = request.getRequestDispatcher("/view/examination/exam/ExamDashboard.jsp");
				request.setAttribute("EID", request.getParameter("eid"));
			} else if (lPageName.equalsIgnoreCase("EE")) {
				lDispatch = request.getRequestDispatcher("/view/examination/exam/EndExam.jsp");
				request.setAttribute("EID", request.getParameter("eid"));
				request.setAttribute("ESTATUS", request.getParameter("estatus"));
			} 
			else {
				lDispatch = request.getRequestDispatcher("/view/examination/exam/Error.jsp");
			}
		} else
			lDispatch = request.getRequestDispatcher("/view/examination/exam/Error.jsp");

		lDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
