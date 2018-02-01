package cn.edu.nwsuaf.ajax;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.nwsuaf.Service.Impl.CommunicationsituService;

public class Communicationsitu_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CommunicationsituService communicationsituService=new CommunicationsituService();
	
	public Communicationsitu_uniqueness() {
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
		String comNumber = request.getParameter("comNumber");
		int count = 1;
		String xml_start = "<communicationsitus>";
		String xml_end = "</communicationsitus>";
		String xml = "";
		try{
			 count = communicationsituService.isExist(Integer.parseInt(comNumber));

		}catch(Exception e)
		{
		}
		if(count==0) {
			xml += "<communicationsitu><value>false</value></communicationsitu>";
		}
		else{
			xml += "<communicationsitu><value>true</value></communicationsitu>";
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
