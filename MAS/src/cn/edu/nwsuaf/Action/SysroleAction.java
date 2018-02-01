package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Service.Impl.SysFunmodleService;
import cn.edu.nwsuaf.Service.Impl.SysroleService;
import cn.edu.nwsuaf.Service.Impl.SysrolejuriService;
import cn.edu.nwsuaf.bean.Sysfunmodle;
import cn.edu.nwsuaf.bean.Sysrole;
import cn.edu.nwsuaf.bean.Sysrolejuri;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

import com.opensymphony.xwork2.ActionSupport;

public class SysroleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8735034622954711087L;
	
	// Service
	private SysroleService roleService;//角色
	private SysrolejuriService rolejuriService;//角色功能
	private SysFunmodleService funcService;//功能
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Sysrole> roleList;// 角色列表
	private List<BaseModel> rolejuriList ;//功能角色列表
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;

	private Sysrole role;
	private Sysrolejuri rolejuri;
	private Sysfunmodle fun;
	private int roleCode;
	private String funModleCode;
	private int roleMenuCode;
	private int ro=0;
	private int rol;
	

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (roleCode == 0) {
			role=null;
		} else {
			role = roleService.findById(Sysrole.class, ""+roleCode);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiSysrole(){
		try {
			page = 1;
			rows = 10;
			List<Sysrole> s;
			s=roleService.findBySQL("select * from Sysrole where roleCode='"+role.getRoleCode()+"'");
			if(s.size()==0){
				roleService.save(role);
			}else{
				roleService.update(role);
			}
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//删除
	public String deleteSysrole(){
		try {
			page = 1;
			rows = 10;
			Sysrole delrole=roleService.findById(Sysrole.class, ""+roleCode);
			roleService.delete(delrole);
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			roleList = roleService.findallSysroleList(page,rows);	
			System.out.println("rolelist"+roleList.size());
			totalRows =  roleService.findAll(Sysrole.class).size();
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
	//分配功能权限
    @SuppressWarnings("unchecked")
	public String addFun(){
    	try{
    		rolejuriList=new ArrayList<BaseModel>(); 
    		String hqlString="from Sysrolejuri as rj where rj.sysrole.roleCode='"+roleCode+"'";
    		List<Sysrolejuri> rj=rolejuriService.findByHQL(hqlString);
    		List<Sysfunmodle> fun=(List<Sysfunmodle>) QueryUtilDaoImpl
			.executeQueryByPage("from Sysfunmodle", null, page, rows);
    		for(Sysfunmodle f :fun){
    			BaseModel base=new BaseModel();
    			base.setId(f.getFunModleCode());
				base.setName(f.getFunModleName());
				System.out.println(base.getId());
    			for(Sysrolejuri r :rj){
    				
    				if(r.getSysfunmodle().getFunModleCode().equals(f.getFunModleCode())){
    					base.setMajorId(r.getRoleMenuCode()+"");//用baseModel中majorId表示角色功能关系主键
    					base.setYear("0");//用baseModel中year表示功能是否存在
    					break;
    				}
    				else{
    					base.setYear("1");
    				}    				
    			}
    			rolejuriList.add(base);
    		}
    		totalRows =  funcService.findAll(Sysfunmodle.class).size();
			System.out.println("init"+totalRows);	
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
    	}catch (Exception e) {
			
			return "error";
		}
		return "success";  	
}
  //添加功能
	public String modifiSysrolejuri(){
		try {
			fun=new Sysfunmodle();
			fun.setFunModleCode(funModleCode);
			rolejuri=new Sysrolejuri();
			rolejuri.setSysfunmodle(fun);
			role=new Sysrole();
			role.setRoleCode(""+roleCode);
			rolejuri.setSysrole(role);
			rolejuriService.save(rolejuri);	
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}
	
	//删除功能
	public String deleteSysrolejuri(){
		try {
			System.out.println("roleMenuCode"+roleMenuCode);
			Sysrolejuri rj=rolejuriService.findById(Sysrolejuri.class, roleMenuCode);
			rolejuriService.delete(rj);
		} catch (Exception e) {
			
			return "error";
		}	
		return "success";
	}
	public SysroleService getRoleService() {
		return roleService;
	}

	public void setRoleService(SysroleService roleService) {
		this.roleService = roleService;
	}

	public List<Sysrole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Sysrole> roleList) {
		this.roleList = roleList;
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

	public Sysrole getRole() {
		return role;
	}

	public void setRole(Sysrole role) {
		this.role = role;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public SysrolejuriService getRolejuriService() {
		return rolejuriService;
	}

	public void setRolejuriService(SysrolejuriService rolejuriService) {
		this.rolejuriService = rolejuriService;
	}

	public SysFunmodleService getFuncService() {
		return funcService;
	}

	public void setFuncService(SysFunmodleService funcService) {
		this.funcService = funcService;
	}

	public List<BaseModel> getRolejuriList() {
		return rolejuriList;
	}

	public void setRolejuriList(List<BaseModel> rolejuriList) {
		this.rolejuriList = rolejuriList;
	}

	public Sysrolejuri getRolejuri() {
		return rolejuri;
	}

	public void setRolejuri(Sysrolejuri rolejuri) {
		this.rolejuri = rolejuri;
	}

	public Sysfunmodle getFun() {
		return fun;
	}

	public void setFun(Sysfunmodle fun) {
		this.fun = fun;
	}

	public String getFunModleCode() {
		return funModleCode;
	}

	public void setFunModleCode(String funModleCode) {
		this.funModleCode = funModleCode;
	}

	public int getRoleMenuCode() {
		return roleMenuCode;
	}

	public void setRoleMenuCode(int roleMenuCode) {
		this.roleMenuCode = roleMenuCode;
	}

	public int getRo() {
		return ro;
	}

	public void setRo(int ro) {
		this.ro = ro;
	}
	
}
