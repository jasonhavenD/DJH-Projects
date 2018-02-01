package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.AppraisalSystemService;
import cn.edu.nwsuaf.bean.Appraisalsystem;
import com.opensymphony.xwork2.ActionSupport;

public class AppraisalsystemAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Service
	private AppraisalSystemService appService;
	// 传到前台下拉列表从数据库中读取显示
	private List<Appraisalsystem> appList;// 指标列表
	private List<Appraisalsystem> pidList;//父节点列表
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	private Appraisalsystem app;
	private String indicatorId;//指标编号
	private BaseModel basemodel=new BaseModel();
	private int rol;
	

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改页面
	public String initEdit(){
		
		if (indicatorId == "0") {
			app=null;
		} else {
			
				app= appService.findById(Appraisalsystem.class, indicatorId);
			
		}	
		return "success";
	}
	
	//修改
	public String modifiTarget(){
		try {
			if(indicatorId.equals("0")){
				appService.save(app);
			}else{
				appService.update(app);
			}
		} catch (Exception e) {
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertTarget(){
		try {
			appService.save(app);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteTarget(){
		try {
			Appraisalsystem targets=appService.findById(Appraisalsystem.class, indicatorId);
			appService.delete(targets);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			page=1;
			rows=10;
			basemodel=null;
			appList = appService.findallTargetList(page, rows);
			pidList=appService.findAll(Appraisalsystem.class);
			totalRows =  appService.findAll(Appraisalsystem.class).size();
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
	public String findTarget() {
		try {
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			appList = appService.findTargetList(basemodel, page, rows);
			pidList=appService.findAll(Appraisalsystem.class);
			totalRows = appService.countFindTarget(basemodel);
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



	public List<Appraisalsystem> getPidList() {
		return pidList;
	}

	public void setPidList(List<Appraisalsystem> pidList) {
		this.pidList = pidList;
	}

	public AppraisalSystemService getAppService() {
		return appService;
	}

	public void setAppService(AppraisalSystemService appService) {
		this.appService = appService;
	}

	public List<Appraisalsystem> getAppList() {
		return appList;
	}

	public void setAppList(List<Appraisalsystem> appList) {
		this.appList = appList;
	}

	public Appraisalsystem getApp() {
		return app;
	}

	public void setApp(Appraisalsystem app) {
		this.app = app;
	}

	public String getIndicatorId() {
		return indicatorId;
	}

	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
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

}
