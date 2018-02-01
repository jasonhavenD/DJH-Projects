package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.edu.nwsuaf.Model.CourseModel;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	//Service
	private CourseService courseService;
	private DepartmentService departmentService;
	private MajorService majorService;
	

	//List
	private List<Course> courseList;
	private List<Department> departmentList;
	private List<Major> majorList;
	private List<String> ctList;
	private List<String> isDouList;
	private List<String> testModeList;

	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String courseId;

	
	private Course course;
	private CourseModel cmodel = new CourseModel();
	private int rol;
	private String errstring;

	
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (courseId == "0") {
				course = null;
			} else {

				course = courseService.findById(Course.class, courseId);
			}
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
	
	//修改
	public String modifiCourse(){

		try {
			List<Course> s;
			s = courseService
					.findByHQL("from Course where cno='"
							+ course.getCno()+ "'");
			if (s.size() == 0) {
				courseService.save(course);
			} else {
				courseService.update(course);
			}
		} catch (Exception e) {
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertCourse(){
		try {
			courseService.save(course);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
	
	// 删除
	public String deleteCourse() {
		try {
			course = courseService.findById(Course.class, courseId);
			courseService.delete(course);
		} catch (Exception e) {
			
			return "error";
		}

		return "success";
	}
	
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			String dno="";
			if(rol!=1){
				dno=QueryUtil.getUserMno().getDepartment().getDno();
				System.out.println("dno:"+dno);
			}
			page=1;
			rows=10;
			cmodel=new CourseModel();
			cmodel.setId("");
			cmodel.setName("");
			cmodel.setCtype(null);
			cmodel.setDepartmentId(dno);
			cmodel.setIsDoubleLanguageTeach(null);
			cmodel.setTestMode(null);
			courseList = courseService.findCourseList(cmodel,page, rows);			
			departmentList = departmentService.findAll(Department.class);
			ctList = courseService.findCtype();
			isDouList = courseService.findIsDouble();
			testModeList = courseService.findTestMode();
			majorList = majorService.findAll(Major.class);
			totalRows = courseService.countFindCourse(cmodel);
			page = 1;
			rows = 10;
			if (totalRows % rows == 0){
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0?1:(totalRows/rows+1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}

	//多条件查询信息
	public String findCourse() throws UnsupportedEncodingException {

		try {
			String dno="";
			dno=QueryUtil.getUserMno().getDepartment().getDno();
			System.out.println("dno:"+dno);
			//departmentList = departmentService.findAll(Department.class);
			//departmentList.
			ctList = courseService.findCtype();
			isDouList = courseService.findIsDouble();
			//majorList = majorService.findAll(Major.class);
			majorList = null;
			testModeList = courseService.findTestMode();
			if(cmodel==null){
				cmodel=new CourseModel();
				cmodel.setId("");
				cmodel.setName("");
				cmodel.setCtype(null);
				cmodel.setDepartmentId(dno);
				cmodel.setIsDoubleLanguageTeach(null);
				cmodel.setTestMode(null);
			}else if(cmodel.getName()!=null&&cmodel.getCtype()!=null&&cmodel.getIsDoubleLanguageTeach()!=null&&cmodel.getTestMode()!=null){
				cmodel.setName(java.net.URLDecoder.decode(cmodel.getName(),"UTF-8"));
				cmodel.setCtype(java.net.URLDecoder.decode(cmodel.getCtype(),"UTF-8"));
				cmodel.setIsDoubleLanguageTeach(java.net.URLDecoder.decode(cmodel.getIsDoubleLanguageTeach(),"UTF-8"));
				cmodel.setTestMode(java.net.URLDecoder.decode(cmodel.getTestMode(),"UTF-8"));
			}
			courseList = courseService.findCourseList(cmodel, page, rows);
			
			totalRows = courseService.countFindCourse(cmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page:"+page + "\n rows:" + rows);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	
	/***************     GETTERS & SETTERS      ****************/
	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}


	public DepartmentService getDepartmentService() {
		return departmentService;
	}


	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	public List<Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}


	public List<Department> getDepartmentList() {
		return departmentList;
	}


	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
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


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public CourseModel getCmodel() {
		return cmodel;
	}


	public void setCmodel(CourseModel cmodel) {
		this.cmodel = cmodel;
	}


	public void setCtList(List<String> ctList) {
		this.ctList = ctList;
	}


	public List<String> getCtList() {
		return ctList;
	}


	public List<String> getIsDouList() {
		return isDouList;
	}


	public void setIsDouList(List<String> isDouList) {
		this.isDouList = isDouList;
	}


	public List<String> getTestModeList() {
		return testModeList;
	}


	public void setTestModeList(List<String> testModeList) {
		this.testModeList = testModeList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	public String list() {

		return "list";
	}
}
