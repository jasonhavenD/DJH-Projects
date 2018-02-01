package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.EmploymentModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.EmploymentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Employment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class EmploymentAction   extends ActionSupport{
	
	//就业情况
	private static final long serialVersionUID = 1L;
	
	// Service
	private EmploymentService empService;//就业情况
	private DepartmentService departmentService;// 学院
	private MajorService majorService;// 专业
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Employment> empList;// 就业情况	
	private List<Department> departmentList;// 学院	
	private List<Major> majorList;// 专业	
	private List<String> yearList;// 年份
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;		
	private Employment emp;
	private EmploymentModel empmodel=new EmploymentModel();		
	private int empNumber;
	private int rol;
	//错误提示
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (empNumber == 0) {
			emp=null;
		} else {
			emp = empService.findById(Employment.class, empNumber);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiEmployment(){
		try {
			List<Employment> s;
			s=empService.findByHQL("from Employment as em where em.empNumber="+emp.getEmpNumber());
			if(s.size()==0){
				emp.setMajor(majorService.findMajorById(emp.getMajor().getMno()));
				empService.save(emp);
			}else{
				emp.setMajor(majorService.findMajorById(emp.getMajor().getMno()));
				empService.update(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	//删除
	public String deleteEmployment(){
		try {
			Employment delemp=empService.findById(Employment.class, empNumber);
			empService.delete(delemp);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	//清空数据
	public String clearEmployment(){
		try {
			List<Employment> clearList=new ArrayList<Employment>();
			clearList=empService.findAll(Employment.class);
			for(Employment emp:clearList){
				empService.delete(emp);
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
		empmodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = empService.findYearList();							
			empList = empService.findallEmploymentList(page,rows,mno,dno);	
			totalRows =  empService.count(mno, dno);
			System.out.println("init"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			yearList = empService.findYearList();
			if(!mno.equals("000000")){
				empmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				empmodel.setDepartmentId(dno);
			}if(empmodel==null){
				empmodel=new EmploymentModel();
				empmodel.setYear("");
				empmodel.setBigempCount(null);
				empmodel.setBigfempCount(null);
				empmodel.setBiggraduCount(null);
				empmodel.setDepartmentId(null);
				empmodel.setMajorId(null);
				empmodel.setLittleempCount(null);
				empmodel.setLittlefempCount(null);
				empmodel.setLittlegraduCount(null);
				
			}
			empList = empService.findEmploymentList(empmodel, page, rows);
			totalRows = empService.countFindEmployment(empmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	
	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public EmploymentService getEmpService() {
		return empService;
	}
	public void setEmpService(EmploymentService empService) {
		this.empService = empService;
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
	public List<Employment> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employment> empList) {
		this.empList = empList;
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
	public Employment getEmp() {
		return emp;
	}
	public void setEmp(Employment emp) {
		this.emp = emp;
	}
	public EmploymentModel getEmpmodel() {
		return empmodel;
	}
	public void setEmpmodel(EmploymentModel empmodel) {
		this.empmodel = empmodel;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
}
