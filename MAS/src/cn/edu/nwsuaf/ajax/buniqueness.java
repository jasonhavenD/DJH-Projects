package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.InnovationprojectService;

public class buniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InnovationprojectService innovationprojectService=new InnovationprojectService();
	
	public buniqueness() {
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
		String innoNumber = request.getParameter("innoNumber");
		int count = innovationprojectService.isExist(innoNumber);
		String xml_start = "<innovationprojects>";
		String xml_end = "</innovationprojects>";
		String xml = "";
		if(count==0) {
			xml += "<innovationproject><value>false</value></innovationproject>";
		}
		else{
			xml += "<innovationproject><value>true</value></innovationproject>";
		}
		String last_xml = xml_start + xml + xml_end;
		//System.out.print(last_xml);
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void setInnovationprojectService(InnovationprojectService innovationprojectService) {
		this.innovationprojectService = innovationprojectService;
	}

	public InnovationprojectService getInnovationprojectService() {
		return innovationprojectService;
	}
}
