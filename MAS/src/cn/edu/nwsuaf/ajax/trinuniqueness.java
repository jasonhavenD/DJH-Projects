package cn.edu.nwsuaf.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.nwsuaf.Service.Impl.TeachResultBaseService;


public class trinuniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TeachResultBaseService teachResultBaseService =new TeachResultBaseService();
	
	public trinuniqueness() {
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
		int tresultBaseNo = Integer.parseInt(request.getParameter("tresultBaseNo"));
		int count = teachResultBaseService.isExist(tresultBaseNo);
		String xml_start = "<teachresultbaseinfos>";
		String xml_end = "</teachresultbaseinfos>";
		String xml = "";
		if(count==0) {
			xml += "<teachresultbaseinfo><value>false</value></teachresultbaseinfo>";
		}
		else{
			xml += "<teachresultbaseinfo><value>true</value></teachresultbaseinfo>";
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


	

	public void setTeachResultBaseService(TeachResultBaseService teachResultBaseService) {
		this.teachResultBaseService = teachResultBaseService;
	}

	public TeachResultBaseService getTeachResultBaseService() {
		return teachResultBaseService;
	}
}
