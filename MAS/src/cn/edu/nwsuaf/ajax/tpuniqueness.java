package cn.edu.nwsuaf.ajax;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.nwsuaf.Service.Impl.TeachprojectService;


public class tpuniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TeachprojectService teachprojectService=new TeachprojectService();
	
	public tpuniqueness() {
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
		String tprojectNo = request.getParameter("tprojectNo");
		int count = teachprojectService.isExist(tprojectNo);
		String xml_start = "<teachprojects>";
		String xml_end = "</teachprojects>";
		String xml = "";
		if(count==0) {
			xml += "<teachproject><value>false</value></teachproject>";
		}
		else{
			xml += "<teachproject><value>true</value></teachproject>";
		}
		
		String last_xml = xml_start + xml + xml_end;
		System.out.print(xml);
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	
	public void setTeachprojectService(TeachprojectService teachprojectService) {
		this.teachprojectService = teachprojectService;
	}

	public TeachprojectService getTeachprojectService() {
		return teachprojectService;
	}
}
