package cn.edu.nwsuaf.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.TeacherService;

public class tno_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService=new TeacherService();
	
	public tno_uniqueness() {
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
		
		String tno = request.getParameter("tno");
		
		
		int count = teacherService.isExist(tno);
		
		String xml_start = "<teachers>";
		String xml_end = "</teachers>";
		String xml = "";
		if(count==0) {
			xml += "<teacher><value>false</value></teacher>";
		}
		else{
			xml += "<teacher><value>true</value></teacher>";
			//xml += "<student><value>true</value></student>";
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
