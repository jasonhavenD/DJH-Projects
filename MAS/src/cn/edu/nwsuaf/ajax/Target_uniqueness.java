package cn.edu.nwsuaf.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.AppraisalSystemService;


public class Target_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AppraisalSystemService appService=new AppraisalSystemService();
	
	public Target_uniqueness() {
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
		String indicatorId = request.getParameter("indicatorId");
		System.out.println(indicatorId);
		int count = appService.isExist(indicatorId);
		String tname=appService.findByTno(indicatorId);
		System.out.println(tname);
		String xml_start = "<targets>";
		String xml_end = "</targets>";
		String xml = "";
		if(count==0) {
			xml += "<target><value>false</value><text>"+tname+"</text></target>";
		}
		else{
			xml += "<target><value>true</value><text>"+tname+"</text></target>";
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
