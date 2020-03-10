package batu.dev.sem.utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class StartupServlet
 */
public class StartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("******************** Initializing Startuo Servlet ************************");
		
		CacheLoader lCacheLoader = CacheLoader.getInstance();
	}

}
