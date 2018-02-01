package cn.edu.nwsuaf.ajax;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.AchievementService;


public class TA_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AchievementService achievementService=new AchievementService();
	
	public TA_uniqueness() {
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
		String certificateNo = request.getParameter("certificateNo");
		int count = achievementService.isExist(certificateNo);
		String xml_start = "<achievementss>";
		String xml_end = "</achievementss>";
		String xml = "";
		if(count==0) {
			xml += "<achievements><value>false</value></achievements>";
		}
		else{
			xml += "<achievements><value>true</value></achievements>";
		}
		String last_xml = xml_start + xml + xml_end;
		//System.out.println(last_xml);
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public AchievementService getAchievementService() {
		return achievementService;
	}
}
