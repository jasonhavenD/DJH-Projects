package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.StudentService;

public class Stunumber extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentService();
	
	public Stunumber() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LOG：Stunumber-doGet()");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String stuNumber = request.getParameter("stuNumber");
		int count = studentService.isExist(stuNumber);
		String stuname=studentService.findByStuno(stuNumber);
		String xml_start = "<students>";
		String xml_end = "</students>";
		String xml = "";
		if(count==0) {
			System.out.println(stuname);
			xml += "<student><value>false</value><text>"+stuname+"</text></student>";
		}
		else{
			xml += "<student><value>true</value><text>"+stuname+"</text></student>";
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
