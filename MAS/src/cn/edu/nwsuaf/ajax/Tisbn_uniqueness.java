package cn.edu.nwsuaf.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.TeachBooksService;

public class Tisbn_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeachBooksService teachBooksService = new TeachBooksService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String isbn = request.getParameter("isbn");
		int count = teachBooksService.isExist(isbn);
		boolean isIsbn=teachBooksService.isISBN(isbn);
		String xml_start = "<teachBooks>";
		String xml_end = "</teachBooks>";
		String xml = "";
		if (count == 0) {
			xml += "<teachBook><value>false</value><text>"+isIsbn+"</text></teachBook>";
		} else {
			xml += "<teachBook><value>true</value><text>"+isIsbn+"</text></teachBook>";
			// xml += "<student><value>true</value></student>";
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
