package com.model.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import javax.persistence.Entity;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;


import com.publicservice.*;
@Entity
@Service
public class CheckCodeService {
	public void sendText(String tel,String code){
		String text = "尊敬的会员,请您60秒之内完成注册,否则验证码失效,验证码："+code;
		System.out.println(text);
		SendValidateCode.sendtext(tel, text);
	}
	/**
	 * @param code//待发送的代码
	 * @param email//被发送方的邮箱
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendEmail(String code,String email) throws AddressException, MessagingException{
		String subject = "O(∩_∩)O~照明系统网站注册验证码";
		SendValidateCode.sendEmail(code, email, subject);
	}
}
