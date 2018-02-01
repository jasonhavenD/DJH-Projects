package com.code.validate;

import java.io.IOException;

import javax.persistence.Entity;
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

@Entity
public class DeliveryLoginValidate implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) response;
		Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
		StringBuffer fileURL = req.getRequestURL();
		
		System.out.println("wwwwww");
		if(userinfo == null && (fileURL.lastIndexOf(".html"))>0 && !req.getServletPath().equals("/delivery/login.html")){
			res.sendRedirect(req.getContextPath()+"/delivery/login.html");
		}else
		{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
