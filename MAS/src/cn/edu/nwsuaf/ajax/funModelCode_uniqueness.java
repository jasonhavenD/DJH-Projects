package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.SysFunmodleService;

public class funModelCode_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysFunmodleService funcService=new SysFunmodleService();//功能
	
	public funModelCode_uniqueness() {
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
		String funModleCode = request.getParameter("funModleCode");
		int count = funcService.isExist(funModleCode);
		String xml_start = "<funModleCodes>";
		String xml_end = "</funModleCodes>";
		String xml = "";
		if(count==0) {
			xml += "<funModleCode><value>false</value></funModleCode>";
		}
		else{
			xml += "<funModleCode><value>true</value></funModleCode>";
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
