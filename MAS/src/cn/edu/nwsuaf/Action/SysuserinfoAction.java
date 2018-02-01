package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.nwsuaf.Model.SysuserinfoModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertService;
import cn.edu.nwsuaf.Service.Impl.ExpertmajorService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.SysroleService;
import cn.edu.nwsuaf.Service.Impl.SysuserinfoService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Sysrole;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class SysuserinfoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	// Service
	private SysuserinfoService userService;//就业情况
	private DepartmentService departmentService;// 学院
	private MajorService majorService;// 专业
	private SysroleService roleService;//角色
	private ExpertmajorService expertmajorService;//专家专业
	private ExpertService expertService;
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Sysuserinfo> userList;// 就业情况	
	private List<Department> departmentList;// 学院	
	private List<Major> majorList;// 专业	
	private List<Sysrole> roleList;//角色
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;		
	
	private Sysuserinfo user;
	private SysuserinfoModel usermodel=new SysuserinfoModel();		
	private int userCode;
	private int rol;
	
	private String returnPage;
	
	private String newPwd;
	
	//错误提示
	private Exception err;
	private String errstring;

	
	
	public Exception getErr() {
		return err;
	}
	public void setErr(Exception err) {
		this.err = err;
	}
	
	public String getErrstring() {
		return errstring;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	/**
	 * 修改密码
	 * @return
	 */
	public String modifyUserPassword(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		user =(Sysuserinfo) session.getAttribute("userInfo");
		System.out.println("user.getMail() "+user.getMail());
		return "success";
	}
	
	
	
	public String updateMail() {
		System.out.println(user.getMail());
		try {
			userService.update(user);
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//给更新
	public String updateysuserinfo(){
		try {
			System.out.println("新密码是："+newPwd);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String roleCode = (String) session.getAttribute("rol");
			System.out.println(roleCode);
			if(!roleCode.equals("5")){
			user.setPassword(newPwd);
			userService.update(user);
			if(user.getSysrole().getRoleName().equals("系统管理员")){
				returnPage = "/index.jsp";
			}else if(user.getSysrole().getRoleName().equals("专业负责人")){
				returnPage = "/Mindex.jsp";
			}else if(user.getSysrole().getRoleName().equals("学院负责人")){
				returnPage = "/Dindex.jsp";
			}else if(user.getSysrole().getRoleName().equals("教务处负责人")){
				returnPage = "/Tindex.jsp";
			}
			}
			else{
				//处理专家密码的修改
				expertService.updatePassword(user.getUserCode(), newPwd);
				returnPage = "/page/sys/main-t.jsp";
			}
			
		} catch (Exception e) {
			
			return "error";
		}
		
		return "success";
	}


	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (userCode == 0) {
			user=null;
		} else {
			user = userService.findById(Sysuserinfo.class, ""+userCode);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiSysuserinfo(){
		try {
			List<Sysuserinfo> s=new ArrayList<Sysuserinfo>();
			s=userService.findByHQL("from Sysuserinfo where userCode='"+user.getUserCode()+"'");
//
//			if("其他".equals(user.getMajor().getMname())){
//				user.getMajor().setMno("000000");
//			}
			if(s.size()==0){
				user.setMajor(majorService.findMajorById(user.getMajor().getMno()));
				userService.save(user);
			}else{
				user.setMajor(majorService.findMajorById(user.getMajor().getMno()));
				userService.update(user);
			}
		} catch (Exception e) {
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
	
	//删除
	public String deleteSysuserinfo(){
		try {
			Sysuserinfo deluser=userService.findById(Sysuserinfo.class,  ""+userCode);			
			System.out.println("RoleCode"+deluser.getSysrole().getRoleCode());
			if(deluser.getSysrole().getRoleCode().equals("5"))
			{
				int a=expertmajorService.findByHQL("from Expertmajor where sysuserinfo.userCode='"+userCode+"'").size();
				if(a!=0){
					errstring="你所删除的专家已被分配专业评分任务，不能删除！";
					return "errorstring";
				}
			}
			userService.delete(deluser);
		} catch (Exception e) {
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
		usermodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findByHQL("from Major as m where m.mname<>'其他' or m.mno='000000'");
			roleList = roleService.findAll(Sysrole.class);		
			userList = userService.findallSysuserinfoList(page,rows,mno,dno);	
			totalRows =  userService.count(mno, dno);
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
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			roleList = roleService.findAll(Sysrole.class);
			if(!mno.equals("000000")){
				usermodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				usermodel.setDepartmentId(dno);
			}
			userList = userService.findSysuserinfoList(usermodel, page, rows);
			totalRows = userService.countFindSysuserinfo(usermodel);
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

	public SysuserinfoService getUserService() {
		return userService;
	}

	public void setUserService(SysuserinfoService userService) {
		this.userService = userService;
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

	public SysroleService getRoleService() {
		return roleService;
	}

	public void setRoleService(SysroleService roleService) {
		this.roleService = roleService;
	}

	public List<Sysuserinfo> getUserList() {
		return userList;
	}

	public void setUserList(List<Sysuserinfo> userList) {
		this.userList = userList;
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

	public Sysuserinfo getUser() {
		return user;
	}

	public void setUser(Sysuserinfo user) {
		this.user = user;
	}

	public SysuserinfoModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(SysuserinfoModel usermodel) {
		this.usermodel = usermodel;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
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
	public ExpertmajorService getExpertmajorService() {
		return expertmajorService;
	}
	public void setExpertmajorService(ExpertmajorService expertmajorService) {
		this.expertmajorService = expertmajorService;
	}
	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}
}
