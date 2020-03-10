package batu.dev.sem.bundles.UserManagement.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import batu.dev.sem.utils.Util;

/**
 * Servlet Filter implementation class AccessFilter
 */

public class AccessFilter implements Filter {

    public AccessFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest lRequest = (HttpServletRequest) request;
		HttpServletResponse lResponse = (HttpServletResponse) response;
		HttpSession lHttpSession = lRequest.getSession();
		String URI = lRequest.getRequestURI().replace(lRequest.getContextPath()+"","");

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
