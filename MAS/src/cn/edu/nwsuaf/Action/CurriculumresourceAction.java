package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.CurriculumresourceModel;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.CurriculumresourceService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class CurriculumresourceAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;

	// Service
	private CurriculumresourceService curService;// 课程资源	
	private DepartmentService departmentService;// 学院
	private MajorService majorService;// 专业
	private CourseService courseService;// 课程

	// 传到前台下拉列表从数据库中读取显示
	private List<Curriculumresource> curList;// 课程资源	
	private List<Department> departmentList;// 学院	
	private List<Major> majorList;// 专业	
	private List<String> yearList;// 年份
	private List<Course> courseList;// 课程

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;		
	private Curriculumresource cur;
	private CurriculumresourceModel curmodel=new CurriculumresourceModel();		
	private int sourNumer;
	private int rol;
	
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (sourNumer == 0) {
			cur=null;
		} else {
			cur = curService.findById(Curriculumresource.class, sourNumer);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiCurriculumresource(){
		try {
			List<Curriculumresource> s;
			s=curService.findByHQL("from Curriculumresource as c where c.sourNumer="+cur.getSourNumer());
			if(s.size()==0){
				cur.setMajor(majorService.findMajorById(cur.getMajor().getMno()));
				cur.setCourse(courseService.findById(Course.class,cur.getCourse().getCno()));
				curService.save(cur);
			}else{
				cur.setMajor(majorService.findMajorById(cur.getMajor().getMno()));
				cur.setCourse(courseService.findById(Course.class,cur.getCourse().getCno()));
				curService.update(cur);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//删除
	public String deleteCurriculumresource(){
		try {
			Curriculumresource delcur=curService.findById(Curriculumresource.class, sourNumer);
			curService.delete(delcur);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	//清空数据
	public String clearCurriculumresource(){
		try {
			List<Curriculumresource> clearList=new ArrayList<Curriculumresource>();
			clearList=curService.findAll(Curriculumresource.class);
			for(Curriculumresource cur:clearList){
				curService.delete(cur);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
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
			page = 1;
			rows = 10;
			curmodel=null;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = curService.findYearList();
			courseList=courseService.findAll(Course.class);
			curList = curService.findallCurriculumresourceList(page,rows,mno,dno);	
			totalRows =  curService.count(mno, dno);
			System.out.println("init"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";

	}
	//查找
	public String find() {
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
			yearList = curService.findYearList();
			courseList=courseService.findAll(Course.class);
			if(!mno.equals("000000")){
				curmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				curmodel.setDepartmentId(dno);
			}
			if(curmodel==null){
				curmodel=new CurriculumresourceModel();
				curmodel.setDepartmentId(null);
				curmodel.setMajorId(null);
				curmodel.setId("");
				curmodel.setIsExcellent(null);
				curmodel.setIsOpen(null);
				curmodel.setYear("");
			}

			curList = curService.findCurriculumresourceList(curmodel, page, rows);
			totalRows = curService.countFindCurriculumresource(curmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	public CurriculumresourceService getCurService() {
		return curService;
	}

	public void setCurService(CurriculumresourceService curService) {
		this.curService = curService;
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

	public List<Curriculumresource> getCurList() {
		return curList;
	}

	public void setCurList(List<Curriculumresource> curList) {
		this.curList = curList;
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

	public Curriculumresource getCur() {
		return cur;
	}

	public void setCur(Curriculumresource cur) {
		this.cur = cur;
	}

	public CurriculumresourceModel getCurmodel() {
		return curmodel;
	}

	public void setCurmodel(CurriculumresourceModel curmodel) {
		this.curmodel = curmodel;
	}

	public int getSourNumer() {
		return sourNumer;
	}

	public void setSourNumer(int sourNumer) {
		this.sourNumer = sourNumer;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

}
