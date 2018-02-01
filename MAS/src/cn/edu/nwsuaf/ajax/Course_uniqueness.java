package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.CourseService;

public class Course_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CourseService courseService = new CourseService();

	public Course_uniqueness() {
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
		String courseNo = request.getParameter("courseNo");
		int count = courseService.isExist(courseNo);
		String xml_start = "<courses>";
		String xml_end = "</courses>";
		String xml = "";
		if (count == 0) {
			xml += "<course><value>false</value></course>";
		} else {
			xml += "<course><value>true</value></course>";
		}
		String last_xml = xml_start + xml + xml_end;
		//System.out.println("xml====" + last_xml);
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
