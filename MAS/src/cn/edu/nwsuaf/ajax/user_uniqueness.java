package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.SysuserinfoService;

public class user_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysuserinfoService userService=new SysuserinfoService();//功能
	
	public user_uniqueness() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userCode = request.getParameter("userCode");
		int count = userService.isExist(userCode);
		String xml_start = "<users>";
		String xml_end = "</users>";
		String xml = "";
		if(count==0) {
			xml += "<user><value>false</value></user>";
		}
		else{
			xml += "<user><value>true</value></user>";
		}
		String last_xml = xml_start + xml + xml_end;
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
