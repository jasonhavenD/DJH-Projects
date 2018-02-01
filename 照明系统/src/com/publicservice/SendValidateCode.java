package com.publicservice;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.code.validate.SimpleMailSend;
import javax.persistence.Entity;

@Entity
public class SendValidateCode {
	
	public static synchronized boolean sendtext(String tel, String text){
		//待编写	
		return true;
	}
	/**
	 * @param code//验证码
	 * @param email//收件人邮箱
	 * @param subject
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static synchronized boolean sendEmail(String code,String email, String subject) throws AddressException, MessagingException{
		String content = "感谢您注册照明系统网站，您的验证码为："+code+"，请您在120秒内完成注册，否则验证码失效";
		String username = "18220525830@163.com";//发送人邮箱
		String password="qyydwnrxgajdgchx";//发送人密码
		com.code.validate.SimpleMailSend sms = new com.code.validate.SimpleMailSend(username,password);
		sms.sendMail(email, subject, content);
		return true;
	}
}
