package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Major;

public class ajaxtestUser extends HttpServlet {
	private static final long serialVersionUID = 7078254784406906185L;
	 
	private List<Major> majorList;// 专业
	private MajorService majorService=new MajorService();
	
	public ajaxtestUser() {
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
        String coll = request.getParameter("coll");
        majorList = majorService.findMajorListByDepat(coll);
        String xml_start = "<majors>";
        String xml_end = "</majors>";
        String xml = "";
        xml += "<major><value>对应专业</value><text>null</text></major>";
        for (int i = 0; i < majorList.size(); i++) {
            xml += "<major><value>" + majorList.get(i).getMname() + "</value><text>"
                    + majorList.get(i).getMno() + "</text></major>";
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
 
    public void init() throws ServletException {
 
    }
}
