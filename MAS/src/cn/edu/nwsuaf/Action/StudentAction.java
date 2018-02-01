package cn.edu.nwsuaf.Action;

import java.util.List;
import cn.edu.nwsuaf.Model.StudentModel;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.Service.Impl.NationalService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.National;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class StudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Service
	private StudentService studentService;
	private NationalService nationalService;
	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	// 专利
	private List<Student> studentList;// 
	private List<National> nationalList;// 
	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> gradeList;// 年级

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int number;
	private String majorId;
	private String departmentId;
	private Student student;
	private StudentModel studentmodel = new StudentModel();
	private String stuNumber;
	private boolean flag;
	private HttpServletRequest request;
	private int rol;
	private String result;
	private String errstring;
	
	
	// 初始化修改页面
	public String initEdit() {

		try {
			// System.out.println("修改");
			student = studentService.findById(Student.class, stuNumber);
			majorList = majorService
					.findByHQL("from Major as m where m.department.dno='"
							+ student.getMajor().getDepartment().getDno() + "'");
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// 初始化修改页面
	public String initAdd() {

		if (number == 0) {
			System.out.println("添加");
			student = null;
		}

		return "success";
	}

	// 修改
	public String modifiStudent() {
		try {

			List<Student> s;
			s = studentService
					.findByHQL("from Student as s where s.stuNumber='"
							+ student.getStuNumber() + "'");
			if (s.size() == 0) {
				studentService.save(student);
			} else {
				// System.out.print("Studnet修改");
				studentService.update(student);
			}
		} catch (ServiceException e) {

			return "error";
		}

		return "success";
	}

	// 添加
	public String insertStudent() {
		try {
			studentService.save(student);
		} catch (ServiceException e) {

			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteStudent() {
		System.out.println("LOG : StudentAction-deleteStudent");
		try {
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			String stuNumber = request.getParameter("stuNumber");
			Student students = studentService
					.findById(Student.class, stuNumber);
			studentService.delete(students);
		} catch (ServiceException e) {
			return "error";
		}

		return "success";
	}

	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		studentmodel = null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			nationalList = nationalService.findAll(National.class);
			System.out.println(nationalList.size());
			yearList = studentService.findYearList();
			gradeList = studentService.findGradeList();
			studentList = studentService.findallStudentList(page, rows, mno,
					dno);

			totalRows = studentService.count(mno, dno);
			System.out.println("init" + totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "success";

	}

	// 多条件查询信息
	public String findStudent() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			if (studentmodel == null) {
				studentmodel = new StudentModel();
				studentmodel.setId("");
				studentmodel.setName("");
				studentmodel.setYear(null);
				studentmodel.setNational(null);
				studentmodel.setMajor(null);
				studentmodel.setDepartmentId(null);
				studentmodel.setIsInSchool(null);
				studentmodel.setIsRoll(null);
			} else if (studentmodel.getName() != null
					&& studentmodel.getIsInSchool() != null
					&& studentmodel.getIsRoll() != null) {
				studentmodel.setIsInSchool(java.net.URLDecoder.decode(
						studentmodel.getIsInSchool(), "UTF-8"));
				studentmodel.setIsRoll(java.net.URLDecoder.decode(studentmodel
						.getIsRoll(), "UTF-8"));
				studentmodel.setName(java.net.URLDecoder.decode(studentmodel
						.getName(), "UTF-8"));
			}
			System.out.println("当前页数是==" + page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			nationalList = nationalService.findAll(National.class);
			yearList = studentService.findYearList();
			gradeList = studentService.findGradeList();
			if (!mno.equals("000000")) {
				studentmodel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				studentmodel.setDepartmentId(dno);
			}

			// 测试
			// System.out.println("学生查找年份:"+studentmodel.getYear());

			studentList = studentService.findStudentList(studentmodel, page,
					rows);
			totalRows = studentService.countFindStudent(studentmodel);
			System.out.println("totalRows" + totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// get-----set方法

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public List<String> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<String> gradeList) {
		this.gradeList = gradeList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentModel getStudentmodel() {
		return studentmodel;
	}

	public void setStudentmodel(StudentModel studentmodel) {
		this.studentmodel = studentmodel;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public NationalService getNationalService() {
		return nationalService;
	}

	public void setNationalService(NationalService nationalService) {
		this.nationalService = nationalService;
	}

	public List<National> getNationalList() {
		return nationalList;
	}

	public void setNationalList(List<National> nationalList) {
		this.nationalList = nationalList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}


}
