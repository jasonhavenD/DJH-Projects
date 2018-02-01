package cn.edu.nwsuaf.comAction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import cn.edu.nwsuaf.Service.Impl.SysuserinfoService;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.exception.ServiceException;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailAction extends ActionSupport {

	private SysuserinfoService sysuserinfoService;// 用户基本信息表

	private String email;
	private String username;// 账户
	private boolean flag = false;

	/**
	 * 发邮件
	 * 
	 * @return
	 */
	public String sendMail() {
		System.out.println("LOG : MailAction-sendMail");

		if (username == null) {
			flag = false;
			return "success";
		}
		Sysuserinfo userinfo = new Sysuserinfo();
		userinfo = sysuserinfoService.findById(Sysuserinfo.class, username);
		
		if (userinfo == null) {
			flag = false;
			return "success";
		}
		
		//创建新密码
		String newPWD=createPassWord(10);
		userinfo.setPassword(newPWD);
		try {
			sysuserinfoService.update(userinfo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		System.out.println("LOG　：pwd = "+userinfo.getPassword());
		
		// 设置邮件内容
		String content = "尊敬的用户:" + userinfo.getUserName()
				+ "\n西北农林科技大学专业评估系统给您发送的密码是：" + userinfo.getPassword()
				+ "\n请注意自己的帐号安全，不要外泄密码！！";

		email = userinfo.getMail();// 从数据库读出

		if (email == null) {
			flag = false;
			return "success";
		}
		flag = sendEmail(email, content);

		if (!flag) {
			flag = false;
			return "success";
		}

		return "success";
	}

	/**
	 * 账户：cn_edu_nwsuaf_mas@163.com 密码：cn.edu.nwsuaf 授权密码：cnedunwsuaf2017
	 * 
	 * @param email
	 * @param content
	 * @return
	 */
	public boolean sendEmail(String email, String content) {
		SimpleEmail mailUtil = new SimpleEmail();

		/**
		 * 根据发送方设置服务器
		 * 
		 */
		mailUtil.setHostName("smtp.163.com");
		if (mailUtil.getHostName() == null) {
			System.out.println("LOG : can not deal with the type of email!");
			return false;
		}
		mailUtil.setAuthentication("cn_edu_nwsuaf_mas@163.com",
				"cnedunwsuaf2017");
		mailUtil.setCharset("utf-8");
		try {
			mailUtil.addTo(email);
			mailUtil.setFrom("cn_edu_nwsuaf_mas@163.com");
			mailUtil.setSubject("西北农林科技大学专业评估系统邮件找回密码");
			mailUtil.setMsg(content);
			mailUtil.send();
		} catch (EmailException e) {
			System.out.println("LOG : 邮件发送过程中找不到家了！");
			return false;
		}
		return true;
	}

	/**
	 * 获得密码
	 * 
	 * @param len
	 *            密码长度
	 * @return
	 */
	public String createPassWord(int len) {
		int random = this.createRandomInt();
		return this.createPassWord(random, len);
	}

	public String createPassWord(int random, int len) {
		Random rd = new Random(random);
		final int maxNum = 62;
		StringBuffer sb = new StringBuffer();
		int rdGet;// 取得随机数
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9' };

		int count = 0;
		while (count < len) {
			rdGet = Math.abs(rd.nextInt(maxNum));// 生成的数最大为62-1
			if (rdGet >= 0 && rdGet < str.length) {
				sb.append(str[rdGet]);
				count++;
			}
		}
		return sb.toString();
	}

	public int createRandomInt() {
		// 得到0.0到1.0之间的数字，并扩大100000倍
		double temp = Math.random() * 100000;
		// 如果数据等于100000，则减少1
		if (temp >= 100000) {
			temp = 99999;
		}
		int tempint = (int) Math.ceil(temp);
		return tempint;
	}

	public SysuserinfoService getSysuserinfoService() {
		return sysuserinfoService;
	}

	public void setSysuserinfoService(SysuserinfoService sysuserinfoService) {
		this.sysuserinfoService = sysuserinfoService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
