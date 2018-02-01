package com.code.validate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Userinfo;

public class AdminLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) response;
		Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
		StringBuffer fileURL = req.getRequestURL();

		System.out.println();
		if (userinfo == null && req.getServletPath().endsWith(".html")
				&& !req.getServletPath().endsWith("login.html")) {
			res.sendRedirect(req.getContextPath() + "/admin/login.html");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
