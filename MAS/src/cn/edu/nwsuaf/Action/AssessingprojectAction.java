package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.AssessingprojectService;
import cn.edu.nwsuaf.bean.Assessingproject;

import com.opensymphony.xwork2.ActionSupport;

public class AssessingprojectAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Service
	private AssessingprojectService aprojectService;
	// 传到前台下拉列表从数据库中读取显示
	private List<Assessingproject> aprojectList;// 指标列表
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	private Assessingproject aproject;
	private int  masprojectNo;//指标编号
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
		
		if ( masprojectNo == 0) {
			aproject=null;
		} else {
				aproject = aprojectService.findById(Assessingproject.class,  masprojectNo);
			
		}	
		return "success";
	}
	
	//修改
	public String modifiAproject(){
		try {
			if( masprojectNo==0){
				int tag = 1;
				aproject.setTag(tag);
				aprojectService.save(aproject);
			}else{
				aprojectService.update(aproject);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//添加
	public String insertAproject(){
		try {
			aprojectService.save(aproject);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//开启评估计算
	public String openAproject(){
		try {
			aproject = aprojectService.findById(Assessingproject.class,masprojectNo);
			aproject.setTag(1);
			aprojectService.update(aproject);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//关闭评估计算
	public String closeAproject(){
		try {
			aproject = aprojectService.findById(Assessingproject.class,masprojectNo);
			aproject.setTag(0);
			aprojectService.update(aproject);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//删除
	public String deleteAproject(){
		try {
			Assessingproject aps=aprojectService.findById(Assessingproject.class,  masprojectNo);
			aprojectService.delete(aps);
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
			aprojectList = aprojectService.findallAprojectList(page, rows);
			totalRows =  aprojectService.findAll(Assessingproject.class).size();
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
	public String findAproject() {
		try {
			basemodel.setName(java.net.URLDecoder.decode(basemodel.getName(),"UTF-8"));
			aprojectList =aprojectService.findAprojectList(basemodel, page, rows);
			totalRows = aprojectService.countFindAproject(basemodel);
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

	public AssessingprojectService getAprojectService() {
		return aprojectService;
	}

	public void setAprojectService(AssessingprojectService aprojectService) {
		this.aprojectService = aprojectService;
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

	public Assessingproject getAproject() {
		return aproject;
	}

	public void setAproject(Assessingproject aproject) {
		this.aproject = aproject;
	}

	public int getMasprojectNo() {
		return masprojectNo;
	}

	public void setMasprojectNo(int masprojectNo) {
		this.masprojectNo = masprojectNo;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}

}
