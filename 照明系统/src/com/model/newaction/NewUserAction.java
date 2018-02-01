package com.model.newaction;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    	String result = "";
    	if(userinfo.getUsername() != null){
    		result = loginService.loginValidateByUsername(userinfo.getState(), userinfo.getUsername(), userinfo.getPassword());
    		System.out.println(userinfo.getState());
    		System.out.println(userinfo.getUsername());
    		System.out.println(userinfo.getPassword());
    	}else{
    		return Action.SUCCESS;
    	}
    	if(result.equals("success")){
    		hashmap.put("loginState",result);
    	}else{
    		hashmap.put("loginState","用户名或密码错误");
    	}
    	System.out.println("login state "+result);
    	
    	return Action.SUCCESS;
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
