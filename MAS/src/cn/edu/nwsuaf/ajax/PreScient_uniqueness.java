package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.PresidedScientificService;

public class PreScient_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PresidedScientificService presService = new PresidedScientificService();

	public PreScient_uniqueness() {
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
		String projectNo = request.getParameter("projectNo");
		int count = presService.isExist(projectNo);
		String xml_start = "<pres>";
		String xml_end = "</pres>";
		String xml = "";
		if (count == 0) {
			xml += "<pre><value>false</value></pre>";
		} else {
			xml += "<pre><value>true</value></pre>";
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
