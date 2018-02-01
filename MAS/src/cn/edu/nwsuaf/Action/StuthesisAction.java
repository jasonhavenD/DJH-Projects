package cn.edu.nwsuaf.Action;

import java.util.List;
import cn.edu.nwsuaf.Model.StuthesisModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.StuthesisService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Stuthesis;

import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class StuthesisAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	// Service
	private StuthesisService stuthesisService;
	
	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Stuthesis> stuthesisList;// 学生论文
	
	private List<Department> departmentList;// 学院
	
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> journalList;// 年份

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;		
	private Stuthesis stuthesis;
	private StuthesisModel stutmodel=new StuthesisModel();		
	private int thesisNumber;//论文编号
	private int rol;
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
		
		if (thesisNumber == 0) {
			stuthesis=null;
		} else {
			
			try {
				stuthesis = stuthesisService.findById(Stuthesis.class, thesisNumber);
			} catch (Exception e) {
				return "error";
			}
		}	
		return "success";
	}
	
	//修改
	public String modifiStuthesis(){
		try {
			//List<Stuthesis> s;
			//s=stuthesisService.findBySQL("select * from stuthesis where thesisNumber="+thesisNumber);
			if(thesisNumber==0){
				stuthesisService.save(stuthesis);
			}else{
				stuthesisService.update(stuthesis);
			}
		} catch (Exception e) {
		
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertStuthesis(){
		try {
			stuthesisService.save(stuthesis);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteStuthesis(){
		try {
			Stuthesis stuthesiss=stuthesisService.findById(Stuthesis.class, thesisNumber);
			stuthesisService.delete(stuthesiss);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			String mno="";
			String dno="";
			try{
				mno=QueryUtil.getUserMno().getMajor().getInMno();
	    		dno=QueryUtil.getUserMno().getDepartment().getDno();
	        }catch(Exception e){
	        	errstring="登录超时！请安全退出再重新登录！";
	        	return "errorstring";
	        }
			page=1;
			rows=10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = stuthesisService.findYearList();	
			journalList=stuthesisService.findJournalList();
			stuthesisList = stuthesisService.findallStuthesisList(page, rows,mno,dno);
			totalRows = stuthesisService.count(mno, dno);
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

	
	public String findStuthesis() {
		try {
			String mno="";
			String dno="";
			try{
				mno=QueryUtil.getUserMno().getMajor().getInMno();
	    		dno=QueryUtil.getUserMno().getDepartment().getDno();
	        }catch(Exception e){
	        	errstring="登录超时！请安全退出再重新登录！";
	        	return "errorstring";
	        }
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = stuthesisService.findYearList();	
			journalList=stuthesisService.findJournalList();
			
			if(!mno.equals("000000")){
				stutmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				stutmodel.setDepartmentId(dno);
			}
			if(stutmodel==null){
				stutmodel=new StuthesisModel();
				stutmodel.setComName("");
				stutmodel.setName("");
				stutmodel.setDepartmentId(null);
				stutmodel.setId(null);
				stutmodel.setJournal(null);
				stutmodel.setJournalType(null);
				stutmodel.setYear(null);
			}else if(stutmodel.getComName()!=null&&stutmodel.getName()!=null&&stutmodel.getJournal()!=null&&stutmodel.getJournalType()!=null){
				stutmodel.setComName(java.net.URLDecoder.decode(stutmodel.getComName()
					, "UTF-8"));
				stutmodel.setName(java.net.URLDecoder.decode(stutmodel.getName()
						, "UTF-8"));
				stutmodel.setJournal(java.net.URLDecoder.decode(stutmodel.getJournal()
						, "UTF-8"));
				stutmodel.setJournalType(java.net.URLDecoder.decode(stutmodel.getJournalType()
						, "UTF-8"));
				
			}
			stuthesisList = stuthesisService.findStuthesisList(stutmodel, page, rows);
			totalRows = stuthesisService.countFindStuthesis(stutmodel);
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
	public List<String> getJournalList() {
		return journalList;
	}
	public void setJournalList(List<String> journalList) {
		this.journalList = journalList;
	}
	public StuthesisService getStuthesisService() {
		return stuthesisService;
	}
	public void setStuthesisService(StuthesisService stuthesisService) {
		this.stuthesisService = stuthesisService;
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
	public List<Stuthesis> getStuthesisList() {
		return stuthesisList;
	}
	public void setStuthesisList(List<Stuthesis> stuthesisList) {
		this.stuthesisList = stuthesisList;
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
	public Stuthesis getStuthesis() {
		return stuthesis;
	}
	public void setStuthesis(Stuthesis stuthesis) {
		this.stuthesis = stuthesis;
	}
	public StuthesisModel getStutmodel() {
		return stutmodel;
	}
	public void setStutmodel(StuthesisModel stutmodel) {
		this.stutmodel = stutmodel;
	}
	public int getThesisNumber() {
		return thesisNumber;
	}
	public void setThesisNumber(int thesisNumber) {
		this.thesisNumber = thesisNumber;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
}
