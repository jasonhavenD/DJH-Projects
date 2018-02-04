package cn.edu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.entity.json.OnlinetrainJson;
import cn.edu.entity.json.TeacherinfoJson;
import cn.edu.hib.dao.TeacherinfoDAO;
import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.hib.service.TeacherinfoService;
import cn.edu.model.LoginStatus;
import cn.edu.model.Pager;
import cn.edu.model.UserType;

public class TeacherInfoAction {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherinfoDAO.class);

	@Resource
	private TeacherinfoService teacherinfoService;
	private Teacherinfo teacherinfo;
	private TeacherinfoJson teacherinfoJson;
	private String message;
	private String status;
	private String userType;
	private Boolean isPass;

	private Pager pager;
	private List<Object> rows = new ArrayList();
	private List<Teacherinfo> teacherinfos;
	private List<TeacherinfoJson> teacherinfoJsons;
	private Map<String, Object> results = new HashMap<String, Object>();

	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	private String tnos;// ids
	private TeacherinfoJson addJson;
	private TeacherinfoJson editJson;

	
	public String look() {
		log.error("TeacherInfoAction-login()");
		return "look";
	}

	public String lookAll() {
		log.error("TeacherInfoAction-lookAll()");
		return "lookAll";
	}

	public String getLoginUser() {
		Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("loginedUser");
		if (u == null)
			System.out.println("user==null");
		teacherinfo = teacherinfoService.findByTno(u);
		teacherinfoJson = new TeacherinfoJson(teacherinfo);
		return "getLoginUser";
	}

	public String delRows() {
		log.error("TeacherInfoAction-delRows");
		if (tnos == null) {
			System.out.println("tnos==null");
		} else {
			List<String> idList = convertToString(tnos.split(","));
			System.out.println(idList);
			// System.out.println("暂时关闭删除功能！");
			teacherinfoService.delTeacherInfos(idList);
		}
		return "delRows";
	}

	public String addRow() {
		log.error("OnlinetrainAction-addRow");
		if (addJson == null) {
			System.out.println("addJson== null");
		} else {
			System.out.println(addJson);
			// System.out.println("暂时关闭添加！");
			teacherinfoService.addTeacherInfo(addJson);
		}
		return "addRow";
	}

	public String editRow() {
		log.error("OnlinetrainAction-editRow");
		if (editJson == null) {
			System.out.println("editJson== null");
		} else {
			System.out.println(editJson);
			teacherinfoService.editOnlineTrain(editJson);
		}
		return "editRow";
	}

	public String getOne() {
		log.error("TeacherInfoAction_getOne");
		if (tnos == null) {
			System.out.println("tnos== null");
		} else {
			teacherinfo = teacherinfoService.findByTno(new Teacherinfo(tnos));
			if (teacherinfo != null) {
				editJson = new TeacherinfoJson(teacherinfo);
			} else {
				editJson = new TeacherinfoJson();
			}
			System.out.println(editJson);
		}
		return "getOne";
	}

	private List<String> convertToString(String[] ids) {
		List<String> result = new ArrayList<String>();
		if (ids == null || ids.length < 1) {
			return null;
		}
		for (String id : ids) {
			result.add(String.valueOf(id));
		}
		return result;
	}

	public String login() {
		log.error("login()");
		Integer loginSuccess = LoginStatus.NAMENOEXIST;
		try {
			if (teacherinfo != null) {
				System.out.println(teacherinfo);
				loginSuccess = this.teacherinfoService.login(teacherinfo);
			} else
				System.out.println("teacherinfo == null");
		} catch (Exception e) {
			loginSuccess = LoginStatus.NAMENOEXIST;
		}
		if (loginSuccess.equals(1)) {
			teacherinfo = this.teacherinfoService.getUser(teacherinfo);
			if ("普通用户".equals(teacherinfo.getType())) {
				userType = UserType.COMMON;
			} else if ("管理员".equals(teacherinfo.getType())) {
				userType = UserType.MANAGER;
			}
			ServletActionContext.getRequest().getSession()
					.setAttribute("loginedUser", teacherinfo);
			//修改teacherinfo表登录状态
			teacherinfoService.ChangeloginStatus(teacherinfo);
			
			status = "true";
			message = "登陆成功！";
			isPass = true;
		} else if (loginSuccess.equals(LoginStatus.NAMENOEXIST)) {
			status = "false";
			message = "用户名不存在！";
			isPass = false;
		} else {
			status = "false";
			message = "密码错误！";
			isPass = false;
		}
		return "login";
	}

	public String logout() {
		log.error("logout()");
		teacherinfo=(Teacherinfo) ServletActionContext.getRequest().getSession()
		.getAttribute("loginedUser");
		
		//修改teacherinfo表登录状态
		teacherinfoService.ChangeloginStatus(teacherinfo);
		
		ServletActionContext.getRequest().getSession()
				.removeAttribute("loginedUser");
		
		ServletActionContext.getRequest().getSession()
				.removeAttribute("isLockScreen");
		
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "logout";
	}

	public String lockScreen() {
		ServletActionContext.getRequest().getSession()
				.setAttribute("isLockScreen", true);
		return null;
	}

	public String unlockScreen() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("isLockScreen", true);
		String password = "";
		if (teacherinfo != null) {
			password = teacherinfo.getPassword();
		}
		password = password == null ? "" : password;
		Teacherinfo user = (Teacherinfo) request.getSession().getAttribute(
				"loginedUser");
		if (user == null) {
			isPass = false;
		} else {
			if (password.equals(user.getPassword())) {
				request.getSession().removeAttribute("isLockScreen");
				isPass = true;
			} else {
				isPass = false;
			}
		}
		return "unlockScreen";
	}

	public String getUser() {
		log.error("TeacherinfoAction-getUser");
		teacherinfos = teacherinfoService.findAll();
		if (pager == null) {
			pager = new Pager();
			pager.setTotalPages(teacherinfos.size() / pager.getPageSize() + 1);
		}
		pager.setTotalRows(teacherinfos.size());
		teacherinfos = teacherinfoService.getUsers(pager);
		rows.clear();
		for (Teacherinfo iter : teacherinfos) {
			rows.add(new TeacherinfoJson(iter));
		}

		System.out.println(rows);

		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);
		return "getUser";
	}

	/**
	 * 根据页面获取数据，并且返回results
	 * 
	 * @return
	 */
	public String getUsersOfPager() {
		log.error("TeacherinfoAction-getUsersOfPager");
		teacherinfos = teacherinfoService.getUsers(pager);
		pager.setTotalRows(teacherinfoService.getTotalRows());
		rows.clear();
		for (Teacherinfo iter : teacherinfos) {
			rows.add(new TeacherinfoJson(iter));
		}
		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);
		return "getUsersOfPager";
	}

	public TeacherinfoService getTeacherinfoService() {
		return teacherinfoService;
	}

	public void setTeacherinfoService(TeacherinfoService teacherinfoService) {
		this.teacherinfoService = teacherinfoService;
	}

	public Teacherinfo getTeacherinfo() {
		return teacherinfo;
	}

	public void setTeacherinfo(Teacherinfo teacherinfo) {
		this.teacherinfo = teacherinfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsPass() {
		return isPass;
	}

	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public TeacherinfoJson getTeacherinfoJson() {
		return teacherinfoJson;
	}

	public void setTeacherinfoJson(TeacherinfoJson teacherinfoJson) {
		this.teacherinfoJson = teacherinfoJson;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<TeacherinfoJson> getTeacherinfoJsons() {
		return teacherinfoJsons;
	}

	public void setTeacherinfoJsons(List<TeacherinfoJson> teacherinfoJsons) {
		this.teacherinfoJsons = teacherinfoJsons;
	}

	public List<Teacherinfo> getTeacherinfos() {
		return teacherinfos;
	}

	public void setTeacherinfos(List<Teacherinfo> teacherinfos) {
		this.teacherinfos = teacherinfos;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public String getTnos() {
		return tnos;
	}

	public void setTnos(String tnos) {
		this.tnos = tnos;
	}

	public TeacherinfoJson getAddJson() {
		return addJson;
	}

	public void setAddJson(TeacherinfoJson addJson) {
		this.addJson = addJson;
	}

	public TeacherinfoJson getEditJson() {
		return editJson;
	}

	public void setEditJson(TeacherinfoJson editJson) {
		this.editJson = editJson;
	}
}
