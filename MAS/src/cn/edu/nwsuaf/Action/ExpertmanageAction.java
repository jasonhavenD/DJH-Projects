package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.ExpertModel;
import cn.edu.nwsuaf.Model.SysuserinfoModel;
import cn.edu.nwsuaf.Service.Impl.ExpertService;
import cn.edu.nwsuaf.Service.Impl.SysuserinfoService;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ExpertmanageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	// Service
	private ExpertService expertService;//专家
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Expert> expertList;// 专家	

	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	
	private Expert expert;
	private ExpertModel expertModel=new ExpertModel();		
	private String expertId;
	
	private String returnPage;
	
	private String newPwd;
	//错误提示
	private String errstring;
	

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (expertId == "0") {
			expert=null;
		} else {
			expert = expertService.findById(Expert.class, expertId);
		}	
		return "success";
	}
	
	//修改or  添加
	public String modifiExpertmanage(){
		try {
			System.out.println(" execute modifi");
			List<Expert> s;
			s=expertService.findBySQL("select * from expert where expertId='"+expert.getExpertId()+"'");
			if(s.size()==0){  
				expertService.save(expert);
			}else{
				expertService.update(expert);
			}
			expert = null;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	//删除
	public String deleteExpert(){
		try{
			Expert expert = expertService.findById(Expert.class, ""+expertId);
			expertService.delete(expert);
		} catch(Exception e){
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
		expertModel=null;
		try {
			page = 1;
			rows = 10;
			expertList = expertService.findallExpertmanageList(page,rows);	
			totalRows =  expertService.countExpertmanage();
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
			if(!mno.equals("000000")){
				expertModel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){				
				expertModel.setDepartmentId(dno);
			}
			expertList = expertService.findExpertmanageList(expertModel, page, rows);
			totalRows = expertService.countFindExpertmanage(expertModel);
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


	public List<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Expert> expertList) {
		this.expertList = expertList;
	}

	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
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

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public ExpertModel getExpertModel() {
		return expertModel;
	}

	public void setExpertModel(ExpertModel expertModel) {
		this.expertModel = expertModel;
	}


	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getReturnPage() {
		return returnPage;
	}
	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
}
