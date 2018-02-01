package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.bean.Teacher;

public class ajaxTnoToTname extends HttpServlet {

	private static final long serialVersionUID = 7078254784406906185L;
	 
	private List<Teacher> teacherList;		//教师信息
	private TeacherService teacherService=new TeacherService();
	/**
	 * Constructor of the object.
	 */
	public ajaxTnoToTname() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String tno = request.getParameter("tno");
        teacherList = teacherService.findTnameListByTno(tno);
        String xml_start = "<teachers>";
        String xml_end = "</teachers>";
        String xml = "";
        for (int i = 0; i < teacherList.size(); i++) {
            xml += "<teacher><value>" + teacherList.get(i).getTname() + "</value></teacher>";
        }
        String last_xml = xml_start + xml + xml_end;
        response.getWriter().write(last_xml);
        System.out.println(last_xml);
        response.getWriter().flush();
        response.getWriter().close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
