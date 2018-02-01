package com.model.action;

import com.entity.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.service.*;

@Entity
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<Userinfo> {
	@ManyToOne
	private Userinfo userinfo = new Userinfo();
	@ManyToOne
	private Company company = new Company();
	@ManyToOne
	@Resource
	private UserRegisterService registerService;
	@ManyToOne
	@Resource
	private UserLoginService loginService;
	@ManyToOne
	@Resource
	private CompanyService companyService;
	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	private String loginReturn = "";

	public void validate() {
		/*
		 * System.out.println("执行了validate"); if(this.hasFieldErrors()){
		 * hashmap.put("registstate", "数据格式不正确"); }
		 */
	}

	/**
	 * 验证用户名的唯一性
	 */
	public String validateUsername() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		if (registerService.validateUsername(username)) {
			hashmap.put("usernameState", "true");
		} else {
			hashmap.put("usernameState", "false");
		}
		return Action.SUCCESS;
	}

	/**
	 * 验证手机号码的唯一性
	 */
	public String validatePhone() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String phone = request.getParameter("phone");
		if (registerService.validatePhone(phone)) {
			hashmap.put("phoneState", "true");
		} else {
			hashmap.put("phoneState", "false");
		}
		return Action.SUCCESS;
	}

	/**
	 * 验证email的唯一性
	 */
	public String validateEmail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String email = request.getParameter("email");
		if (registerService.validateEmail(email)) {
			hashmap.put("emailState", "true");
		} else {
			hashmap.put("emailState", "false");
		}
		return Action.SUCCESS;
	}

	/**
	 * 电话注册前，前台需已完成唯一性验证。 电话注册
	 */
	public String registerByPhone() {
		System.out.println("username" + userinfo.getUsername() + "email"
				+ userinfo.getPhone() + "password" + userinfo.getPassword());
		try {
			userinfo.setMembertype(4);
			userinfo.setState(1);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			userinfo.setRegisterdatetime(date);
			registerService.saveUser(userinfo);
			hashmap.put("registerState", "success");
		} catch (Exception e) {
			hashmap.put("registerState", "timeout");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	/**
	 * 邮箱注册前，前台需已完成邮箱唯一性验证。 邮箱注册
	 */
	public String registerByEmail() {
		System.out.println("username: " + userinfo.getUsername() + " email:"
				+ userinfo.getEmail() + " password:" + userinfo.getPassword());
		try {
			userinfo.setMembertype(4);
			userinfo.setState(1);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			userinfo.setRegisterdatetime(date);
			registerService.saveUser(userinfo);
			hashmap.put("registerState", "success");
		} catch (Exception e) {
			hashmap.put("registerState", "timeout");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	/**
	 * 管理员登录
	 */
	public String adminLogin() {
		System.out.println("执行");
		String result = "";
		String userName = userinfo.getUsername();
		String password = userinfo.getPassword();
		System.out.println(userName + " " + password);
		if (userName != null) {
			result = loginService
					.loginValidateByUsername(1, userName, password);
		}
		hashmap.put("loginState", result);
		System.out.println("result: " + result);
		return Action.SUCCESS;
	}

	/**
	 * 管理员登录
	 */
	public String deliveryLogin() {
		String result = "";
		if (userinfo.getUsername() != null) {
			result = loginService.loginValidateByUsername(2,
					userinfo.getUsername(), userinfo.getPassword());
		}
		hashmap.put("loginState", result);
		return Action.SUCCESS;
	}

	/**
	 * 登陆前，需前台验证好用户名是否为空 用户登陆 用户名/邮箱/email
	 * 
	 * @return
	 */
	public String login() {
		System.out.println("in login() of UserAction up to today");
		String result = "";
		String result1 = "";
		String result2 = "";
		/*
		 * String x ="1234567890"; String y ="202cb962ac59075b964b07152d234b70";
		 */

		// 在客户端已经通过JavaScript转换为MD5，这里不用
		// String passwordMd5Hex = DigestUtils.md5Hex(userinfo.getPassword());
		String passwordMd5Hex = userinfo.getPassword();
		System.out.println(userinfo.getPassword() + " : " + passwordMd5Hex);

		if (userinfo.getUsername() != null) {
			// result =
			// loginService.loginValidateByUsername(3,userinfo.getUsername(),
			// userinfo.getPassword());
			result = loginService.loginValidateByUsername(3,
					userinfo.getUsername(), passwordMd5Hex);
			// result1 = loginService.loginValidateByPhone(userinfo.getPhone(),
			// userinfo.getPassword());
			result1 = loginService.loginValidateByPhone(userinfo.getPhone(),
					passwordMd5Hex);
			// result2 = loginService.loginValidateByEmail(userinfo.getPhone(),
			// userinfo.getPassword());
			result2 = loginService.loginValidateByEmail(userinfo.getPhone(),
					passwordMd5Hex);
			/*
			 * if(x != null){ result = loginService.loginValidateByUsername(3,x,
			 * y); result1 = loginService.loginValidateByPhone(x,y); result2 =
			 * loginService.loginValidateByEmail(x, y);
			 */
		} else {
			return Action.SUCCESS;
		}
		if (result.equals("success")) {
			hashmap.put("loginState", result);
		} else if (result1.equals("success")) {
			hashmap.put("loginState", result1);
		} else if (result2.equals("success")) {
			hashmap.put("loginState", result2);
		} else {
			hashmap.put("loginState", "用户名或密码错误");
		}
		
		System.out.println("login state " + result);
		System.out.println("login state " + result1);
		System.out.println("login state " + result2);
		return Action.SUCCESS;
	}

	/**
	 * 登陆前，需前台验证好用户名是否为空 用户登陆 用户名/邮箱/email
	 * 
	 * @return
	 */
	public String login2() {
		System.out.println("in login2() of UserAction up to today");
		String result = "";
		String result1 = "";
		String result2 = "";
		/*
		 * String x ="1234567890"; String y ="202cb962ac59075b964b07152d234b70";
		 */

		System.out.println(userinfo.getMembertype());
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getPassword());

		if (userinfo.getUsername() != null) {
			result = loginService.loginValidateByUsername(3,
					userinfo.getUsername(), userinfo.getPassword());
			result1 = loginService.loginValidateByPhone(userinfo.getPhone(),
					userinfo.getPassword());
			result2 = loginService.loginValidateByEmail(userinfo.getPhone(),
					userinfo.getPassword());
			/*
			 * if(x != null){ result = loginService.loginValidateByUsername(3,x,
			 * y); result1 = loginService.loginValidateByPhone(x,y); result2 =
			 * loginService.loginValidateByEmail(x, y);
			 */
		} else {
			return Action.SUCCESS;
		}

		if (userinfo.getUsername() == null)
			return "input2";
		if (result.equals("success")) {
			return "success2";
		} else if (result1.equals("success")) {
			hashmap.put("loginState", result1);
		} else if (result2.equals("success")) {
			hashmap.put("loginState", result2);
		} else {
			hashmap.put("loginState", "用户名或密码错误");
		}
		System.out.println("login state " + result);
		System.out.println("login state " + result1);
		System.out.println("login state " + result2);
		return Action.SUCCESS;
	}

	// 退出登陆
	public String exit() {
		ServletActionContext.getRequest().getSession().invalidate();
		hashmap.put("exit", "success");
		return Action.SUCCESS;
	}

	/**
	 * 更改密码 验证原密码是否正确
	 */
	public String isTruePassword() {
		Userinfo user = (Userinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("userinfo");
		Userinfo user2 = loginService.findById(user.getUserinfoid());
		System.out.println("数据库中密码：" + user2.getPassword());
		if (user.getPassword().equals(userinfo.getPassword())
				&& user2.getPassword().equals(userinfo.getPassword())) {
			hashmap.put("state", "yes");
		} else {
			hashmap.put("state", "no");
		}
		return Action.SUCCESS;
	}

	/**
	 * 更改用户密码
	 * 
	 * @return
	 */
	public String changePassword() {
		try {
			Userinfo user = (Userinfo) ServletActionContext.getRequest()
					.getSession().getAttribute("userinfo");
			user.setPassword(userinfo.getPassword());// 更改session中的密码
			/*
			 * System.out.println((Userinfo)ServletActionContext.getRequest().
			 * getSession().getAttribute("userinfo"));
			 */
			loginService.changePassword(user);// 更改数据库中的密码
			hashmap.put("state", "success");
		} catch (Exception e) {
			hashmap.put("state", "timeout");
		}
		return Action.SUCCESS;
	}

	/**
	 * @author wsp 无用 效率太低
	 */
	public String isPaypassword() {
		Userinfo user = (Userinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("userinfo");
		Company company = companyService.findById(user.getUserinfoid());// 从数据库获取
		HttpServletRequest request = ServletActionContext.getRequest();
		String paypassword = request.getParameter("paypassword");
		if (company.getPaypassword().equals(paypassword)) {
			hashmap.put("state", "yes");
		} else {
			hashmap.put("state", "no");
		}
		return Action.SUCCESS;
	}

	/**
	 * 更改
	 */
	public String updatePaypsw() {
		try {
			Userinfo user = (Userinfo) ServletActionContext.getRequest()
					.getSession().getAttribute("userinfo");
			Company company = companyService.findById(user.getUserinfoid());// 从数据库获取
			System.out.println(company.getCompanyid());
			HttpServletRequest request = ServletActionContext.getRequest();
			String paypassword = request.getParameter("paypassword");
			System.out.println(paypassword);
			company.setPaypassword(paypassword);
			companyService.updateCompanyInfo(company);
			hashmap.put("state", "success");
		} catch (Exception e) {
			System.out.println(e);
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	/**
	 * 添加物流中心
	 * 
	 * @return
	 */
	public String addLogisticsCenter() {
		System.out.println("username: " + userinfo.getUsername() + " password:"
				+ userinfo.getPassword());
		if (userinfo.getUsername() == null || userinfo.getPassword() == null
				|| userinfo.getUsername().equals("")
				|| userinfo.getPassword().equals("")) {
			hashmap.put("state", "paramError");// 参数不合法
			return Action.SUCCESS;
		}
		userinfo.setMembertype(2);// 设置成员类型为物流中心

		if (!registerService.validateUsername(userinfo.getUsername())) {
			hashmap.put("state", "nameRepeat");
			return Action.SUCCESS;
		}
		try {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			userinfo.setRegisterdatetime(time);// 注册时间
			userinfo.setState(1);// 状态
			registerService.saveUser(userinfo);// 添加用户
			hashmap.put("state", "success");
		} catch (Exception e) {
			hashmap.put("state", "fail");// 失败
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	/**
	 * 修改用户账号状态
	 * 
	 * @return
	 */
	public String changeUserState() {
		Integer id = userinfo.getUserinfoid();
		Integer state = userinfo.getState();
		if (id == null || state == null) {
			hashmap.put("state", "paramError");// 传递参数不能为空
			return Action.SUCCESS;
		}
		// 更改用户状态为可用或者不可用
		try {
			loginService.changeState(id, state);
			hashmap.put("state", "success");
		} catch (Exception re) {
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	/** test **/
	public void findbyid(String email) {
		System.out.println(loginService.findbyEmail(email));
	}

	public Userinfo getModel() {
		return userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	// 平台获取普通经销商
	public String getNormal() {
		try {
			List list = loginService.findNormal();
			hashmap.put("Normal", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	// 平台获取认证经销商
	public String getCertified() {
		try {
			List list = loginService.findCertified();
			hashmap.put("Certified", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

}
