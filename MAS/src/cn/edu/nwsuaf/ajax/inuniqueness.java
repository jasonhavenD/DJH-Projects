package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.CompetitionService;

public class inuniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CompetitionService competitionService =new CompetitionService();
	
	public inuniqueness() {
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
		
		int count = competitionService.isExist(comNumber);
		String xml_start = "<competitions>";
		String xml_end = "</competitions>";
		String xml = "";
		if(count==0) {
			xml += "<competition><value>false</value></competition>";
		}
		else{
			xml += "<competition><value>true</value></competition>";
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


	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public CompetitionService getCompetitionService() {
		return competitionService;
	}
}
