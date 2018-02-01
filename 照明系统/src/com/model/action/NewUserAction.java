package com.model.action;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Userinfo;
import com.model.service.UserLoginService;
import com.model.service.UserRegisterService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewUserAction extends ActionSupport implements ModelDriven<Userinfo> {
	
	private Userinfo userinfo = new Userinfo();
	@Resource
	private UserLoginService loginService;
	@Resource
	private UserRegisterService registerService;
	private HashMap<String, Object> hashmap = new HashMap<String,Object>();

	/**
	 * 用户登录
	 */
	public String login(){
		System.out.println("in login() of UserAction up to today");
    	String result = "";
    	String result1 = "";
    	String result2 = "";
    	/*String x ="1234567890";
    	String y ="202cb962ac59075b964b07152d234b70";*/
    	
    	System.out.println(userinfo.getMembertype());
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getPassword());
		String passwordMd5Hex = DigestUtils.md5Hex(userinfo.getPassword());
		System.out.println(userinfo.getPassword() + " : " + passwordMd5Hex);
		
		if(userinfo.getUsername() == null)
			return Action.INPUT;
    	//result = loginService.loginValidateByUsername(3,userinfo.getUsername(), userinfo.getPassword());
    		result = loginService.loginValidateByUsername(3,userinfo.getUsername(), passwordMd5Hex);
    		//result1 = loginService.loginValidateByPhone(userinfo.getPhone(), userinfo.getPassword());
    		result1 = loginService.loginValidateByPhone(userinfo.getPhone(), passwordMd5Hex);
    		//result2 = loginService.loginValidateByEmail(userinfo.getPhone(), userinfo.getPassword());
    		result2 = loginService.loginValidateByEmail(userinfo.getPhone(), passwordMd5Hex);
    	/*if(x != null){
    		result = loginService.loginValidateByUsername(3,x, y);
    		result1 = loginService.loginValidateByPhone(x,y);
    		result2 = loginService.loginValidateByEmail(x, y);*/
    	if(result.equals("success"))
    		return Action.SUCCESS;
    	else
    		return Action.INPUT;
    }
	
	/**
	 * 用户登录
	 */
	public String loginoff(){
		System.out.println("in loginoff() of UserAction up to today");
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Object userinfo = httpSession.getAttribute("userinfo");
    	if(userinfo != null) {
    		httpSession.removeAttribute("userinfo");
    		return Action.SUCCESS;
    	} else {
    		return Action.INPUT;
    	}
    }
	
	/**
	 * 用户登录
	 */
	public String loginNew() {
    	String result = "";
    	if(userinfo.getUsername() != null){
    		//result = loginService.loginValidateByUsername(userinfo.getState(), userinfo.getUsername(), userinfo.getPassword());
    		result = loginService.loginValidateByUsername(userinfo.getMembertype(), userinfo.getUsername(), userinfo.getPassword());
    		System.out.println(userinfo.getMembertype());
    		System.out.println(userinfo.getUsername());
    		System.out.println(userinfo.getPassword());
	    	if(result.equals("success")) {
	    		System.out.println("success");
	    		return Action.SUCCESS;
	    	}
    	}
    	return Action.INPUT;
    }

	/**
	 * 验证用户名的唯一性
	 */
	public String validateUsername(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		if(registerService.validateUsername(username)){
			hashmap.put("usernameState", "true");
		}else
		{
			hashmap.put("usernameState", "false");
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 验证手机号码的唯一性
	 */
	public String validatePhone(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String phone = request.getParameter("phone");
		if(registerService.validatePhone(phone)){
			hashmap.put("phoneState", "true");
		}else
		{
			hashmap.put("phoneState", "false");
		}
		return Action.SUCCESS;
	}
	
	/**
	 *电话注册前，前台需已完成唯一性验证。
	 *电话注册 
	 */
    public String registerByPhone(){
    	System.out.println("username:"+userinfo.getUsername()+"phone:"+userinfo.getPhone()
    			+"password:"+userinfo.getPassword());
    	try{
			userinfo.setMembertype(4);
			userinfo.setState(1);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			userinfo.setRegisterdatetime(date);
			registerService.saveUser(userinfo);
			hashmap.put("registerState", "success");
		}catch (Exception e){
			hashmap.put("registerState","timeout");
			e.printStackTrace();
		}
    	return Action.SUCCESS;
	}
    
    /**
	 *电话注册前，前台需已完成唯一性验证。
	 *电话注册 
	 */
    public String registerByPhoneNew(){
    	System.out.println("username:"+userinfo.getUsername()+"phone:"+userinfo.getPhone()
    			+"password:"+userinfo.getPassword());
    	try{
			userinfo.setMembertype(4);
			userinfo.setState(1);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			userinfo.setRegisterdatetime(date);
			registerService.saveUser(userinfo);
			return Action.SUCCESS;
		}catch (Exception e){
			hashmap.put("registerState","timeout");
			e.printStackTrace();
			return Action.INPUT;
		}
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public Userinfo getModel() {
		return userinfo;
	}
	
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	
	public UserRegisterService getRegisterService() {
		return registerService;
	}
}
