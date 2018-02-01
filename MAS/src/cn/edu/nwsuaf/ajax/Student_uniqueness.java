package cn.edu.nwsuaf.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.bean.Student;


public class Student_uniqueness extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentService();
	private List<Student>studentList;
	
	

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Student_uniqueness() {
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
		String stuNumber = request.getParameter("stuNumber");
		/*int count = studentService.isExist(stuNumber);
		String stuname=studentService.findByStuno(stuNumber);
		String xml_start = "<students>";
		String xml_end = "</students>";
		String xml = "";
		if(count==0) {
			xml += "<student><value>false</value><text>"+stuname+"</text></student>";
		}
		else{
			xml += "<student><value>true</value><text>"+stuname+"</text></student>";
			//xml += "<student><value>true</value></student>";
		}
		if(count==0) {
			xml += "<student><value>"+stuname+"</value></student>";
		}
		else{
			xml += "<student><value>"+stuname+"</value></student>";
			//xml += "<student><value>true</value></student>";
		}*/
		studentList = studentService.findSnameListBySno(stuNumber);
        String xml_start = "<students>";
        String xml_end = "</students>";
        String xml = "";
        for (int i = 0; i < studentList.size(); i++) {
            xml += "<student><value>" + studentList.get(i).getStuName() + "</value></student>";
        }
		String last_xml = xml_start + xml + xml_end;
		System.out.println(last_xml);
		response.getWriter().write(last_xml);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentService getStudentService() {
		return studentService;
	}
}
