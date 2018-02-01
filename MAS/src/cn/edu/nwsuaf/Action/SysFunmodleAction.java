package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.SysfunmodleModel;
import cn.edu.nwsuaf.Service.Impl.SysFunmodleService;
import cn.edu.nwsuaf.bean.Sysfunmodle;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class SysFunmodleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8735034622954711087L;
	
	// Service
	private SysFunmodleService funcService;//功能
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Sysfunmodle> firstpList;// 一级目录	
	private List<Sysfunmodle> secondpList;// 二级目录	
	private List<Sysfunmodle> thirdpList;// 功能目录
	private List<Sysfunmodle> funcList;// 功能列表
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;

	private Sysfunmodle func;
	private SysfunmodleModel funcmodel=new SysfunmodleModel();		
	private int funModleCode;
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
		
		if (funModleCode == 0) {
			func=null;
		} else {
			func = funcService.findById(Sysfunmodle.class, ""+funModleCode);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiSysfunmodle(){
		try {
			List<Sysfunmodle> s;
			s=funcService.findBySQL("select * from Sysfunmodle where funModleCode='"+func.getFunModleCode()+"'");
			if(s.size()==0){
				funcService.save(func);
			}else{
				funcService.update(func);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//删除
	public String deleteSysfunmodle(){
		try {
			Sysfunmodle delfunc=funcService.findById(Sysfunmodle.class, ""+funModleCode);
			funcService.delete(delfunc);
		} catch (Exception e) {
		
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			page = 1;
			rows = 10;
			funcmodel=null;
			firstpList=funcService.findByHQL("from Sysfunmodle where funParentCode=0");	
			secondpList=funcService.findByHQL("from Sysfunmodle where funParentCode>=1 and funParentCode<=5");
			thirdpList=funcService.findByHQL("from Sysfunmodle where funParentCode>5");
			funcList = funcService.findallSysfunmodleList(page,rows);	
			totalRows =  funcService.findAll(Sysfunmodle.class).size();
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
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		try {
			firstpList=funcService.findByHQL("from Sysfunmodle where funParentCode=0");	
			secondpList=funcService.findByHQL("from Sysfunmodle where funParentCode>=1 and funParentCode<=5");
			thirdpList=funcService.findByHQL("from Sysfunmodle where funParentCode>5");
			if(!mno.equals("000000")){
				funcmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				funcmodel.setDepartmentId(dno);
			}
			funcList = funcService.findSysfunmodleList(funcmodel, page, rows);
			totalRows = funcService.countFindSysfunmodle(funcmodel);
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

	public SysFunmodleService getFuncService() {
		return funcService;
	}

	public void setFuncService(SysFunmodleService funcService) {
		this.funcService = funcService;
	}

	public List<Sysfunmodle> getFirstpList() {
		return firstpList;
	}

	public void setFirstpList(List<Sysfunmodle> firstpList) {
		this.firstpList = firstpList;
	}

	public List<Sysfunmodle> getSecondpList() {
		return secondpList;
	}

	public void setSecondpList(List<Sysfunmodle> secondpList) {
		this.secondpList = secondpList;
	}

	public List<Sysfunmodle> getThirdpList() {
		return thirdpList;
	}

	public void setThirdpList(List<Sysfunmodle> thirdpList) {
		this.thirdpList = thirdpList;
	}

	public List<Sysfunmodle> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<Sysfunmodle> funcList) {
		this.funcList = funcList;
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

	public Sysfunmodle getFunc() {
		return func;
	}

	public void setFunc(Sysfunmodle func) {
		this.func = func;
	}

	public SysfunmodleModel getFuncmodel() {
		return funcmodel;
	}

	public void setFuncmodel(SysfunmodleModel funcmodel) {
		this.funcmodel = funcmodel;
	}

	public int getFunModleCode() {
		return funModleCode;
	}

	public void setFunModleCode(int funModleCode) {
		this.funModleCode = funModleCode;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
	
	
}
