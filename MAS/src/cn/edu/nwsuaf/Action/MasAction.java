package cn.edu.nwsuaf.Action;

import java.util.Iterator;
import java.util.List;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.AppraisalSystemService;
import cn.edu.nwsuaf.Service.Impl.AssessingneedtargetService;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.bean.Appraisalsystem;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.bean.Assessingproject;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Mas;

import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class MasAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Service
	private MasService masService;
	private AppraisalSystemService appService;
	private AssessingneedtargetService assessingneedtargetService;
	private AssessingprojectService aprojectService;
	private DepartmentService departmentService;
	private MajorService majorService;
	// 传到前台下拉列表从数据库中读取显示
	private List<Mas> masList;// 专业评估指标列表
	private List<Appraisalsystem> appList;// 指标列表
	private List<Assessingneedtarget>assessingneedtargetsList;//所需指标列表
	private List<Assessingneedtarget>firstassessingneedtargetsList;//所需一级指标列表
	private List<Assessingneedtarget>secondassessingneedtargetsList;//所需二级指标列表
	private List<Assessingneedtarget>thirdassessingneedtargetsList;//所需三级指标列表
	private List<Assessingproject> aprojectList;// 评估项目列表
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	private Mas mas;
	private int  masCode;//编号
	private BaseModel basemodel=new BaseModel();
	private int rol;
	//错误提示
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改页面
	public String initEdit(){
		
		if ( masCode == 0) {
			mas=null;
		} else {
			
			try {
				mas = masService.findById(Mas.class,  masCode);
			} catch (Exception e) {
				return "error";
			}
		}	
		return "success";
	}
	
	//修改
	public String modifiMas(){
		try {
			if( masCode==0){
				masService.save(mas);
			}else{
				masService.update(mas);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertMas(){
		try {
			masService.save(mas);
		} catch (Exception e) {
		
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteMas(){
		try {
			Mas mass=masService.findById(Mas.class,  masCode);
			masService.delete(mass);
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
			page=1;
			rows=10;
			basemodel=null;
			aprojectList = aprojectService.findProjectDesc();
			appList=appService.findAll(Appraisalsystem.class);
			//aprojectList=aprojectService.findAll( Assessingproject.class);
			//包括一二三级指标
			assessingneedtargetsList=assessingneedtargetService.findallAssNeedTargetList(0);
			firstassessingneedtargetsList=assessingneedtargetService.findallAssNeedTargetList(1);
			secondassessingneedtargetsList=assessingneedtargetService.findallAssNeedTargetList(2);
			thirdassessingneedtargetsList=assessingneedtargetService.findallAssNeedTargetList(3);
			
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			masList = masService.findallMasList(page, rows,mno,dno);
			totalRows =  masService.count(mno, dno);
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
	public String findMas() {
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
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			basemodel.setId(java.net.URLDecoder.decode(basemodel.getId(),"UTF-8"));
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			if(!mno.equals("000000")){
				basemodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				basemodel.setDepartmentId(dno);
			}
			masList =masService.findMasList(basemodel, page, rows);
			totalRows = masService.countFindMas(basemodel);
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

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
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

	public MasService getMasService() {
		return masService;
	}

	public void setMasService(MasService masService) {
		this.masService = masService;
	}

	public AppraisalSystemService getAppService() {
		return appService;
	}

	public void setAppService(AppraisalSystemService appService) {
		this.appService = appService;
	}

	public AssessingprojectService getAprojectService() {
		return aprojectService;
	}

	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
	}

	public List<Mas> getMasList() {
		return masList;
	}

	public void setMasList(List<Mas> masList) {
		this.masList = masList;
	}

	public List<Appraisalsystem> getAppList() {
		return appList;
	}

	public void setAppList(List<Appraisalsystem> appList) {
		this.appList = appList;
	}

	public List<Assessingproject> getAprojectList() {
		return aprojectList;
	}

	public void setAprojectList(List<Assessingproject> aprojectList) {
		this.aprojectList = aprojectList;
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

	public Mas getMas() {
		return mas;
	}

	public void setMas(Mas mas) {
		this.mas = mas;
	}

	public int getMasCode() {
		return masCode;
	}

	public void setMasCode(int masCode) {
		this.masCode = masCode;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}

	public void setAssessingneedtargetsList(List<Assessingneedtarget> assessingneedtargetsList) {
		this.assessingneedtargetsList = assessingneedtargetsList;
	}

	public List<Assessingneedtarget> getAssessingneedtargetsList() {
		return assessingneedtargetsList;
	}
	public AssessingneedtargetService getAssessingneedtargetService() {
		return assessingneedtargetService;
	}

	public void setAssessingneedtargetService(
			AssessingneedtargetService assessingneedtargetService) {
		this.assessingneedtargetService = assessingneedtargetService;
	}

	public List<Assessingneedtarget> getFirstassessingneedtargetsList() {
		return firstassessingneedtargetsList;
	}

	public void setFirstassessingneedtargetsList(
			List<Assessingneedtarget> firstassessingneedtargetsList) {
		this.firstassessingneedtargetsList = firstassessingneedtargetsList;
	}

	public List<Assessingneedtarget> getSecondassessingneedtargetsList() {
		return secondassessingneedtargetsList;
	}

	public void setSecondassessingneedtargetsList(
			List<Assessingneedtarget> secondassessingneedtargetsList) {
		this.secondassessingneedtargetsList = secondassessingneedtargetsList;
	}

	public List<Assessingneedtarget> getThirdassessingneedtargetsList() {
		return thirdassessingneedtargetsList;
	}

	public void setThirdassessingneedtargetsList(
			List<Assessingneedtarget> thirdassessingneedtargetsList) {
		this.thirdassessingneedtargetsList = thirdassessingneedtargetsList;
	}
	
}
