package com.code.validate;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.persistence.Entity;

/**
 * 公司邮箱登陆验证
 * @author 范晓媛
 *
 */
@Entity
public class MailAuthenticator extends Authenticator{
	/**
	 * 用户名（登录邮箱）
	 */
	private String username;
	/**
	 * 邮箱密码
	 */
	private String password;
	protected MailAuthenticator() {
	}
	public MailAuthenticator(String username,String password){
		this.username = username;
		this.password = password;
	}
	protected  PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username, password);
	}
	/**
	 * getter setter
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
