package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueUsingService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Teachingplanchange;
import cn.edu.nwsuaf.bean.Trainingvenue;
import cn.edu.nwsuaf.bean.Trainingvenueuse;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class TrainingvenueUsingAction extends ActionSupport{

	/**
	 * 
	 */
	//实验实训场地使用情况
	private static final long serialVersionUID = 1L;

	// Service
	private TrainingvenueUsingService trainingvenueuseService;
	private TrainingvenueService trainingvenueService;
	private DepartmentService departmentService;
	private MajorService majorService;
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Trainingvenueuse> trainingvenueuseList;// 实验室使用情况
	private List<Trainingvenue> trainingvenueList;// 实验室
	private List<String> yearList;// 年份
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
    
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	//页面属性
	private int useNumber;		
	private Trainingvenueuse trainingvenueuse;
	private BaseModel trausemodel = new BaseModel();
	private int rol;
	private Exception err;	
	private String errstring;	
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (useNumber == 0) {
				trainingvenueuse = null;
			} else {
				trainingvenueuse=trainingvenueuseService.findById(Trainingvenueuse.class, useNumber);
				
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	
	
	
	// 修改实验室使用情况
	public String modifiTrainingvenueuse() {
		try {

			List<Trainingvenueuse> s;
			s = trainingvenueuseService
			.findByHQL("from Trainingvenueuse as tr where tr.useNumber="
					+ trainingvenueuse.getUseNumber());
			if (s.size() == 0) {
				trainingvenueuseService.save(trainingvenueuse);
			} else {

				trainingvenueuseService.update(trainingvenueuse);
			}
		} catch (ServiceException e) {
			err=e;
			StackTraceElement[] st = err.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String exclass = stackTraceElement.getClassName();
				String method = stackTraceElement.getMethodName();
				System.out.println(new Date() + ":" + "[类:" + exclass + "]调用"
				+ method + "时在第" + stackTraceElement.getLineNumber()
				+ "行代码处发生异常!异常类型:" + err.getClass().getName());
			}
			return "error";
		}

		return "success";
	}

	// 删除实验室使用情况
	public String deleteTrainingvenueuse() {
		try {
			Trainingvenueuse fs = trainingvenueuseService.findById(Trainingvenueuse.class,
					useNumber);
			trainingvenueuseService.delete(fs);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	//清空数据
	public String clearTrainingvenueuse(){
		try {
			List<Trainingvenueuse> clearList=new ArrayList<Trainingvenueuse>();
			clearList=trainingvenueuseService.findAll(Trainingvenueuse.class);
			for(Trainingvenueuse truse:clearList){
				trainingvenueuseService.delete(truse);
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
		trausemodel=null;
		try {	
			page=1;
			rows=10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			trainingvenueList=trainingvenueService.findAll(Trainingvenue.class);
			yearList = trainingvenueuseService.findYearList();
			trainingvenueuseList = trainingvenueuseService.findallTrainingvenueuseList(page, rows,mno,dno);
			totalRows = trainingvenueuseService.count(mno, dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {
			err=e;
			StackTraceElement[] st = err.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String exclass = stackTraceElement.getClassName();
				String method = stackTraceElement.getMethodName();
				System.out.println(new Date() + ":" + "[类:" + exclass + "]调用"
				+ method + "时在第" + stackTraceElement.getLineNumber()
				+ "行代码处发生异常!异常类型:" + err.getClass().getName());
			}
			return "error";
		}
		return "success";
	}
	
	
	//多条件查询信息
	public String findTrainingvenueuse() {
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
			System.out.println("当前页数是=="+page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = trainingvenueuseService.findYearList();
			if(trausemodel==null){
				trausemodel=new BaseModel();
				trausemodel.setDepartmentId(null);
				trausemodel.setYear(null);
				trausemodel.setMajorId(null);
				trausemodel.setId("");
				trausemodel.setName("");
			}else if(trausemodel.getId()!=null&trausemodel.getName()!=null){
				trausemodel.setId(java.net.URLDecoder.decode(trausemodel.getId(),"UTF-8"));
				trausemodel.setName(java.net.URLDecoder.decode(trausemodel.getName(),"UTF-8"));
			}
			if(!mno.equals("000000")){
				trausemodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				trausemodel.setDepartmentId(dno);
			}
			trainingvenueuseList = trainingvenueuseService.findTrainingvenueuseList(trausemodel, page,
					rows);
			totalRows = trainingvenueuseService.countFindTrainingvenueuse(trausemodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			//System.out.println(totalPage);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	public TrainingvenueUsingService getTrainingvenueuseService() {
		return trainingvenueuseService;
	}
	public void setTrainingvenueuseService(
			TrainingvenueUsingService trainingvenueuseService) {
		this.trainingvenueuseService = trainingvenueuseService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public List<Trainingvenueuse> getTrainingvenueuseList() {
		return trainingvenueuseList;
	}
	public void setTrainingvenueuseList(List<Trainingvenueuse> trainingvenueuseList) {
		this.trainingvenueuseList = trainingvenueuseList;
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
	public int getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(int useNumber) {
		this.useNumber = useNumber;
	}
	public Trainingvenueuse getTrainingvenueuse() {
		return trainingvenueuse;
	}
	public void setTrainingvenueuse(Trainingvenueuse trainingvenueuse) {
		this.trainingvenueuse = trainingvenueuse;
	}
	public BaseModel getTrausemodel() {
		return trausemodel;
	}
	public void setTrausemodel(BaseModel trausemodel) {
		this.trausemodel = trausemodel;
	}
	public void setTrainingvenueList(List<Trainingvenue> trainingvenueList) {
		this.trainingvenueList = trainingvenueList;
	}
	public List<Trainingvenue> getTrainingvenueList() {
		return trainingvenueList;
	}
	public void setTrainingvenueService(TrainingvenueService trainingvenueService) {
		this.trainingvenueService = trainingvenueService;
	}
	public TrainingvenueService getTrainingvenueService() {
		return trainingvenueService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	public String getErrstring() {
		return errstring;
	}
	public Exception getErr() {
		return err;
	}
	public void setErr(Exception err) {
		this.err = err;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
	
	
}
