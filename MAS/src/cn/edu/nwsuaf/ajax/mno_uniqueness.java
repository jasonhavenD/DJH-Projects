package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.MajorService;

public class mno_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MajorService majorService=new MajorService();
	
	public mno_uniqueness() {
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
		String mno = request.getParameter("mno");
		int count = majorService.isExist(mno);
		String xml_start = "<majors>";
		String xml_end = "</majors>";
		String xml = "";
		if(count==0) {
			
			xml += "<major><value>false</value></major>";
		}
		else{
			System.out.println("有");
			xml += "<major><value>true</value></major>";
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
