package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.MajorcourseModel;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MajorcourseService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorcourse;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class MajorcourseAction extends ActionSupport{
	
	//专业开课情况
	private static final long serialVersionUID = 1L;

	// Service
	private MajorcourseService mcourseService;
	
	private DepartmentService departmentService;
	private MajorService majorService;
	private CourseService courseService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Majorcourse> mcourseList;// 专业开课
	
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<Course> courseList;// 专业
	private List<String> yearList;// 年份
	private List<String> ptitleList;// 职称
	private List<String> openSemesterList;//学期

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;		
	private Majorcourse mcourse;
	private MajorcourseModel mcoursemodel=new MajorcourseModel();		
	private int openCourseNo;//开课编号
	private int rol;
	//错误提示
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	public String list() {

		return "list";
	}
	//初始化修改页面
	public String initEdit(){
		
		if (openCourseNo == 0) {
			mcourse=null;
		} else {
			
			try {
				mcourse = mcourseService.findById(Majorcourse.class, openCourseNo);
			} catch (Exception e) {
				return "error";
			}
		}	
		return "success";
	}
	
	//修改
	public String modifiMcourse(){
		try {
			if(openCourseNo==0){
				mcourseService.save(mcourse);
			}else{
				mcourseService.update(mcourse);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertMcourse(){
		try {
			mcourseService.save(mcourse);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteMcourse(){
		try {
			Majorcourse tp=mcourseService.findById(Majorcourse.class, openCourseNo);
			mcourseService.delete(tp);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			mcoursemodel=null;
			String mno="";
			String dno="";
			try{
				mno=QueryUtil.getUserMno().getMajor().getInMno();
	    		dno=QueryUtil.getUserMno().getDepartment().getDno();
	        }catch(Exception e){
	        	setErrstring("登录超时！请安全退出再重新登录！");
	        	return "errorstring";
	        }
			page=1;
			rows=10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			courseList=courseService.findAll(Course.class);
			yearList = mcourseService.findYearList();	
			ptitleList=mcourseService.findPtitleList();// 职称
			openSemesterList=mcourseService.findOpenSemesterList();
			mcourseList = mcourseService. findallMcourseList(page, rows,mno,dno);
			totalRows = mcourseService.count(mno, dno);
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

	
	public String findMcourse() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = mcourseService.findYearList();	
			courseList=courseService.findAll(Course.class);
			ptitleList=mcourseService.findPtitleList();// 职称
			openSemesterList=mcourseService.findOpenSemesterList();
			if(!mno.equals("000000")){
				mcoursemodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				mcoursemodel.setDepartmentId(dno);
			}
			if(mcoursemodel==null){
				mcoursemodel=new MajorcourseModel();
				mcoursemodel.setCtype("");
				mcoursemodel.setId("");
				mcoursemodel.setName("");
				mcoursemodel.setTname("");
				mcoursemodel.setYear("");
				mcoursemodel.setTno("");
				mcoursemodel.setProfessionalTitleName("");
				mcoursemodel.setOpenSemester("");
			}
			mcourseList = mcourseService.findMcourseList(mcoursemodel, page, rows);
			totalRows = mcourseService.countFindMajorcourse(mcoursemodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public MajorcourseService getMcourseService() {
		return mcourseService;
	}
	public void setMcourseService(MajorcourseService mcourseService) {
		this.mcourseService = mcourseService;
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
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public List<Majorcourse> getMcourseList() {
		return mcourseList;
	}
	public void setMcourseList(List<Majorcourse> mcourseList) {
		this.mcourseList = mcourseList;
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
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<String> getYearList() {
		return yearList;
	}
	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}
	public List<String> getPtitleList() {
		return ptitleList;
	}
	public void setPtitleList(List<String> ptitleList) {
		this.ptitleList = ptitleList;
	}
	public List<String> getOpenSemesterList() {
		return openSemesterList;
	}
	public void setOpenSemesterList(List<String> openSemesterList) {
		this.openSemesterList = openSemesterList;
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
	public Majorcourse getMcourse() {
		return mcourse;
	}
	public void setMcourse(Majorcourse mcourse) {
		this.mcourse = mcourse;
	}
	public MajorcourseModel getMcoursemodel() {
		return mcoursemodel;
	}
	public void setMcoursemodel(MajorcourseModel mcoursemodel) {
		this.mcoursemodel = mcoursemodel;
	}
	public int getOpenCourseNo() {
		return openCourseNo;
	}
	public void setOpenCourseNo(int openCourseNo) {
		this.openCourseNo = openCourseNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

}
