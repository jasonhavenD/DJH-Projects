package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;
import cn.edu.nwsuaf.Model.TeachingplanchangeModel;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.TeachingplanchangeService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Teachingplanchange;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class TeachingplanchangeAction extends ActionSupport{
	
	//教学计划变更
	private static final long serialVersionUID = 1L;

	// Service
	private TeachingplanchangeService tplanService;
	
	private DepartmentService departmentService;
	private MajorService majorService;
	private CourseService courseService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Teachingplanchange> tplanList;// 学生论文
	
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<Course> courseList;// 专业
	private List<String> yearList;// 年份
	private List<String> gradeList;// 年级

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;		
	private Teachingplanchange tplan;
	private TeachingplanchangeModel tplanmodel=new TeachingplanchangeModel();		
	private int teachPlanChaneId;//论文编号
	private int rol;
	private String errstring;

	//初始化修改页面
	public String initEdit(){
		
		if (teachPlanChaneId == 0) {
			tplan=null;
		} else {
			
			try {
				tplan = tplanService.findById(Teachingplanchange.class, teachPlanChaneId);
			} catch (Exception e) {
				return "error";
			}
		}	
		return "success";
	}
	
	//修改
	public String modifiTplan(){
		try {
			//List<Teachingplanchange> t;
			//t=tplanService.findBySQL("select * from Teachingplanchange where teachPlanChaneId="+teachPlanChaneId);
			if(teachPlanChaneId==0){
				tplanService.save(tplan);
			}else{
				tplanService.update(tplan);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertTplan(){
		try {
			tplanService.save(tplan);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteTplan(){
		try {
			Teachingplanchange tp=tplanService.findById(Teachingplanchange.class, teachPlanChaneId);
			tplanService.delete(tp);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	//清空数据
	public String clearTplan(){
		try {
			List<Teachingplanchange> clearList=new ArrayList<Teachingplanchange>();
			clearList=tplanService.findAll(Teachingplanchange.class);
			for(Teachingplanchange tplan:clearList){
				tplanService.delete(tplan);
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
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		try {
			tplanmodel=null;
			page=1;
			rows=10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			courseList=courseService.findAll(Course.class);
			yearList = tplanService.findYearList();	
			gradeList=tplanService.findGradeList();
			tplanList = tplanService. findallTplanchangeList(page, rows,mno,dno);
			totalRows = tplanService.count(mno, dno);
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

	
	public String findTplan() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		System.out.println("rol=="+rol);
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = tplanService.findYearList();	
			courseList=courseService.findAll(Course.class);
			gradeList=tplanService.findGradeList();
			if(!mno.equals("000000")){
				tplanmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				tplanmodel.setDepartmentId(dno);
			}
			if(tplanmodel==null){
				tplanmodel=new TeachingplanchangeModel();
                tplanmodel.setAdjustNature(null);
                tplanmodel.setChangeMode("");
                tplanmodel.setChangeType("");
                tplanmodel.setGrade("");
                tplanmodel.setId("");
                tplanmodel.setName("");
                tplanmodel.setYear("");
			}
			tplanList = tplanService.findTplanchangeList(tplanmodel, page, rows);
			totalRows = tplanService.countFindTplan(tplanmodel);
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
	public TeachingplanchangeService getTplanService() {
		return tplanService;
	}
	public void setTplanService(TeachingplanchangeService tplanService) {
		this.tplanService = tplanService;
	}
	public List<Teachingplanchange> getTplanList() {
		return tplanList;
	}
	public void setTplanList(List<Teachingplanchange> tplanList) {
		this.tplanList = tplanList;
	}
	public List<String> getGradeList() {
		return gradeList;
	}
	public void setGradeList(List<String> gradeList) {
		this.gradeList = gradeList;
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
	public Teachingplanchange getTplan() {
		return tplan;
	}
	public void setTplan(Teachingplanchange tplan) {
		this.tplan = tplan;
	}
	public TeachingplanchangeModel getTplanmodel() {
		return tplanmodel;
	}
	public void setTplanmodel(TeachingplanchangeModel tplanmodel) {
		this.tplanmodel = tplanmodel;
	}
	public int getTeachPlanChaneId() {
		return teachPlanChaneId;
	}
	public void setTeachPlanChaneId(int teachPlanChaneId) {
		this.teachPlanChaneId = teachPlanChaneId;
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
	
	public String list() {

		return "list";
	}
}
