package com.model.filter;

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

import org.apache.struts2.ServletActionContext;

import com.entity.Userinfo;

@Entity
public class LoginValidate implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) response;
		Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
		String path = req.getServletPath();
		
		System.out.println("doFilter path: " + path);
		
		if (path.contains("/login.html") || path.contains("/error.html")
				|| path.contains("/logorreg.html"))
			chain.doFilter(request, response);
		else if (userinfo == null) {
			if (path.contains("company"))
				res.sendRedirect(req.getContextPath()
						+ "/company/logorreg.html");
			else if (path.contains("admin")) {
				if (path.contains("login.html"))
						res.sendRedirect(req.getContextPath() + "/admin/login.html");
				else if (path.contains("signup.html"))
						res.sendRedirect(req.getContextPath() + "/admin/signup.html");
				else if (path.contains("index.html"))
					res.sendRedirect(req.getContextPath() + "/admin/index.html");
			}	
			else if (path.contains("delivery"))
				res.sendRedirect(req.getContextPath() + "/delivery/login.html");
			else if (path.contains("newpages")) {
				if(path.contains("4.jsp"))
					res.sendRedirect(req.getContextPath() + "/newpages/4.jsp");
				else if(path.contains("5.jsp"))
					res.sendRedirect(req.getContextPath() + "/newpages/5.jsp");
			}	
		} else if (userinfo != null) {
			/**
			 * 页面访问权限
			 */
			int membertype = userinfo.getMembertype();// 用户类型
			if (path.contains("company"))
				chain.doFilter(request, response);
			else if (path.contains("admin") && membertype == 1)
				chain.doFilter(request, response);
			else if (path.contains("delivery") && membertype == 2)
				chain.doFilter(request, response);
			else if (path.contains("newpages"))
				chain.doFilter(request, response);
			else
				res.sendRedirect(req.getContextPath() + "/html/error.html");

		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
