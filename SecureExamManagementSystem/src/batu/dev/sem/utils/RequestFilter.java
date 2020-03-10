package batu.dev.sem.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public class RequestFilter implements Filter {
	public RequestFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Request Executed");

		HttpServletRequest lRequest = (HttpServletRequest) request;
		HttpServletResponse lResponse = (HttpServletResponse) response;
		String authHead = lRequest.getHeader("Authorization");
		
		System.out.println("auth ="+authHead);
		System.out.println(Base64.getDecoder().decode(authHead.replace("Basic ", "")));
		
		HttpSession lHttpSession = lRequest.getSession();
		UserEntity lUserEntity = (UserEntity) lHttpSession.getAttribute("USER_ENTITY");
		PrintWriter out = null;

		if (authHead != null) {
			String lUser = Util.getAuth(authHead.replace("Basic ", ""))[0];
			String lToken = Util.getAuth(authHead.replace("Basic ", ""))[1];
			
			System.out.println(lToken+"auth ="+lUser);
			Long lLastRequest = CacheLoader.getInstance().lastRequest().get(lUser);
//			
//			System.out.println("lUserEntity");
//			System.out.println(lUserEntity);
//			if(lUserEntity != null)
//			{

			final long lMinTime = Long.parseLong(Util.getProperty("Config", "request.sessiontimeout"));

//				System.out.println("null  loader "+CacheLoader.getInstance().lastRequest().get(lUser));

			if (lLastRequest != null) {
				long requestDiff = System.currentTimeMillis() - lLastRequest;

				if (requestDiff > lMinTime) {
					Util.logout(lRequest, lUser);
					out = lResponse.getWriter();
					lResponse.setStatus(401);
					out.print("REQUEST SESSION VIOLATION");
				} else {

					if (CacheLoader.getInstance().userMap().get("" + lUser) != null) {
						if (CacheLoader.getInstance().userMap().get(lUser).equalsIgnoreCase(lToken.trim())) {
							CacheLoader.getInstance().lastRequest().put(lUser, System.currentTimeMillis());
							chain.doFilter(request, response);
						} else {
							out = lResponse.getWriter();
							lResponse.setStatus(401);
							out.print("REQUEST_UNAUTHORIZED");
						}

					} else {
						out = lResponse.getWriter();
						lResponse.setStatus(401);
						out.print("REQUEST_ANONYMOUS_DETECTED");
					}
				}
			} else {
				out = lResponse.getWriter();
				lResponse.setStatus(401);
				out.print("SESSION TIMED OUT");
			}
//			}else
//			{
//				out = lResponse.getWriter();
//				lResponse.setStatus(401);
//				out.print("INVALID SESSION");
//			}

		} else {
			out = lResponse.getWriter();
			lResponse.setStatus(401);
			out.print("SECURITY VOILATION");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
