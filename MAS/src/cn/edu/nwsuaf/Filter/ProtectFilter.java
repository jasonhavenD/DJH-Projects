package cn.edu.nwsuaf.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class ProtectFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("LOG:ProtectFilter-deFilter()");
		javax.servlet.http.HttpServletRequest req = (javax.servlet.http.HttpServletRequest) arg0;
		Object loginName = req.getSession().getAttribute("userInfo");
		if (loginName == null) {
			req.getSession().setAttribute("message", "你尚未登录，请登录...");
			javax.servlet.http.HttpServletResponse res = (javax.servlet.http.HttpServletResponse) arg1;
			res.sendRedirect(req.getContextPath()+"/user_init.action");
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
