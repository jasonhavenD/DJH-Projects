package com.code.validate;

import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 * 简单邮件发送，可单发群发
 * @author 范晓媛
 *
 */
@Entity
public class SimpleMailSend {
	/**
	 * 发送邮件的properties文件
	 */
	private final transient Properties props = System.getProperties();
	/**
	 * 邮箱验证
	 */
	@ManyToOne
	private transient MailAuthenticator authenticator;
    /**
     * 	
     */
	private transient Session session;
	  protected SimpleMailSend() {
	}
	/**
     * @param username
     *               发送邮件的用户名
     * @param password
     *                发送邮件的密码
     * @param smtpHostName
     *                 SMTP主机地址
     */
	public SimpleMailSend(final String smtpHostName,final String username, final String password){
		init(username,password,smtpHostName);
		
	}
	/**
     * @param username
     *               发送邮件的用户名
     * @param password
     *                发送邮件的密码
     * smtpHostName
     *               根据发送者用户名解析出smtp服务器地址
     */
	public SimpleMailSend(final String username, final String password){
		final String smtpHostName = "smtp."+username.split("@")[1];
		init(username,password,smtpHostName);
	}
	/**
	 * 指定端口的邮件服务器
	 */
	public SimpleMailSend(final String username, final String password,final String smtpHostName, final int port){
		init(username, password,smtpHostName,port);
	}
	
	 /**
     * @param username
     *               发送邮件的用户名
     * @param password
     *                发送邮件的密码
     * @param smtpHostName
     *                 SMTP主机地址
     */
	private void init(String username,String password,String smtpHostName){
		/**
		 * 初始化props
		 */
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.host", smtpHostName);
		
		authenticator = new MailAuthenticator(username, password);
		
		session = Session.getInstance(props,authenticator);
	}
	private void init(final String username, final String password, final String smtpHostName, final int port){
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.host", smtpHostName);
		props.put("mail.smtp.port", port);
		 // 验证
        authenticator = new MailAuthenticator(username, password);
        // 创建session
        session = Session.getInstance(props, authenticator);
	}
   
	/**
	 * 发送邮件
	 * @param receive收件人
	 * @param subject邮件主题
	 * @param content邮件内容
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendMail(String receive, String subject, Object content) throws AddressException, MessagingException{
		/**
		 * 创建mime类型邮件
		 */
		final MimeMessage message = new MimeMessage(session);
		/**
		 * 设置发件人
		 */
		message.setFrom(new InternetAddress(authenticator.getUsername()));
		/**
		 * 设置收件人
		 */
		message.setRecipient(RecipientType.TO, new InternetAddress(receive));
	    /**
	     * 设置主题
	     */
		message.setSubject(subject);
		/**
		 * 设置邮件内容
		 */
		message.setContent(content.toString(),"text/html;charset=utf-8");
		Transport.send(message);
	}
	/**
	 * 群发 
	 * @param receive收件人
	 * @param subject
	 * @param content
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendMail(List<String>  receive, String subject, Object content) throws AddressException, MessagingException{
		/**
		 * 创建mime类型邮件
		 */
		final MimeMessage message = new MimeMessage(session);
		/**
		 * 设置发件人
		 */
		message.setFrom(new InternetAddress(authenticator.getUsername()));
		/**
		 * 设置收件人s
		 */
		final int num = receive.size();
		InternetAddress[] addresses = new InternetAddress[num];
		for(int i = 0 ; i < num ; i++){
			addresses[i] = new InternetAddress(receive.get(i));
		}
		message.setRecipients(RecipientType.TO, addresses);
	    /**
	     * 设置主题
	     */
		message.setSubject(subject);
		/**
		 * 设置邮件内容
		 */
		message.setContent(content.toString(),"text/html;charset=utf-8");
		Transport.send(message);
	}
	
}
