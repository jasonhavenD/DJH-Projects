package cn.edu.nwsuaf.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**   
 * 用于检测用户是否登陆的过滤器，如果未登录或超时，则重定向到指的登录页面<p>     
 */
public class CheckLoginFilter extends HttpServlet implements Filter {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 8901227923125575736L;

	 	@Override
		public void destroy() {  
		  
	    }

	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
	        HttpServletRequest httpReq=(HttpServletRequest)req;  
	        HttpServletResponse httpRes=(HttpServletResponse)res;
	        HttpSession httpSession=httpReq.getSession();
	        String reqURL = httpReq.getRequestURL().toString();
	        if(reqURL.contains("userlogin.action") || reqURL.contains("userexit.action") || reqURL.contains("randomCode.action")){
	        	chain.doFilter(req, res);
	        }
	        else{
	        	if(httpSession.getAttribute((String)httpSession.getAttribute("sessionName"))==null){
	        		httpRes.setContentType("text/html;charset=UTF-8");
	                PrintWriter out = httpRes.getWriter();
	                out.println("<html>");  
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('很长时间没有操作，请重新登录！')");
	                out.println("window.open ('/SubContest/login.jsp','_parent')");  
	                out.println("</script>");
	                out.println("</html>");
	            }else{  
	                chain.doFilter(req, res);
	            }
	        }
	    }  

	    public void init(FilterConfig arg0) throws ServletException {  
	  
	    }  
}
