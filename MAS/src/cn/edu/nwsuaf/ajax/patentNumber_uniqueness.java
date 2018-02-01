package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.StupatentService;

public class patentNumber_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StupatentService stupatentService=new StupatentService();
	
	public patentNumber_uniqueness() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LOG：patentNumber_uniqueness-doGet()");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String patentNumber = request.getParameter("patentNumber");
		int count = stupatentService.isExist(patentNumber);
		String xml_start = "<stupatents>";
		String xml_end = "</stupatents>";
		String xml = "";
		if(count==0) {
			xml += "<stupatent><value>false</value></stupatent>";
		}
		else{
			xml += "<stupatent><value>true</value></stupatent>";
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
