package com.model.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Userinfo;
import com.model.newservice.HttpSender;
import com.model.service.CheckCodeService;
import com.model.service.UserRegisterService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.publicservice.CheckCode;
import com.publicservice.ValidateCode;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 验证码
 */
@Entity
@Controller
@Scope("prototype")
public class IdentifyingCodeAction extends ActionSupport implements ModelDriven<Userinfo>{
	@ManyToOne
	@Resource
	private CheckCodeService checkcode;
	@ManyToOne
	@Resource
	private UserRegisterService registerService;
	@ManyToOne
	private Userinfo userinfo = new Userinfo();
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	//图片的宽度
	@Id
	@GeneratedValue
	private static int WIDTH = 100;
	//图片的高度
	private static int HEIGHT = 40;
	//验证码上字符数
	private static int NUM = 5;
	//随机数字
	private static char[]seq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		   'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		   'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
		   '9' };
	private InputStream is;
	public void validate(){
		
	}
	/**
	 * 图片验证码
	 * @return
	 */
	public String getPictureCode(){
		byte [] data = producePictureCode();
		is = new ByteArrayInputStream(data);
		return Action.SUCCESS;
	}
	public byte[] producePictureCode(){
		Random r = new Random();
		//图片的内容映像
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		//获取画布对象
		Graphics g = image.getGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0,0,0));
		StringBuffer num = new StringBuffer();
		for(int i = 0 ; i < NUM; i++){
			g.setColor(randomColor(r));
			int h = (int)((HEIGHT*50/100*r.nextDouble())+(HEIGHT*40/100));
			g.setFont(new Font(null,Font.BOLD|Font.ITALIC,h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			num.append(ch);
			g.drawString(ch, i*WIDTH/NUM*90/100, h);
		}
		System.out.println("图片验证码："+num.toString());
		ServletActionContext.getRequest().getSession().setAttribute("pictureValidate", num.toString());//将图片验证码放在session中
		for(int i = 0 ; i <= 3; i++){
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r.nextInt(HEIGHT));
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();//捕获内存缓存区的数据，转换成字节数组
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		try{
			encoder.encode(image);
			return os.toByteArray();//获取内存缓存中的数据
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//产生随机色
	private Color randomColor(Random r){
		return new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
	}
	/**
	 * 验证码发送
	 * @return
	 */
	public String getCodeByPhone() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String phone = request.getParameter("phone");
		String code = CheckCode.getValidateCode(6);//生成验证码
		
		String url = "http://222.73.117.169:80/msg/HttpBatchSendSM";// 应用地址
		String account = "N9381757";// 账号
		String pswd = "OqlAxND6aWe2fd";// 密码
		String mobile = phone;// 手机号码，多个号码使用","分割
		String msg = "【光服科技】您的验证码是"+code+"，5分钟有效，清注意保管！";// 短信内容
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String extno = "706779";// 扩展码
        
		try {
			if(registerService.validatePhone(phone))
			{
				String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, extno);//发送验证码
				System.out.println(returnString);
			}
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
		
		System.out.println(mobile);
		HttpSession session = request.getSession();//获得session
		long timeOut = (System.currentTimeMillis()+60*1000);//获得系统当前时间，毫秒，子1970年开始至今多长时间
		ValidateCode validateCode = new ValidateCode(timeOut,code);
		session.setAttribute("validateCode", validateCode);//将验证码存放在session当中
		validateCode = (ValidateCode) session.getAttribute("validateCode");
		System.out.println("验证码为："+validateCode.getCode());
		return Action.SUCCESS;
	}
	/**
	 * 注册时邮箱发送验证码
	 * @return
	 */
	public String getCodeByEmail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String email = request.getParameter("email");
//		String email ="740842107@qq.com";
		String code = CheckCode.getValidateCode(6);//生成验证码
		try {
			if(registerService.validateEmail(email))
			{
				checkcode.sendEmail(code, email);
			}
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//发送验证码
		HttpSession session = request.getSession();//获得session
		long timeOut = (System.currentTimeMillis()+2*60*1000);//获得系统当前时间，毫秒，子1970年开始至今多长时间
		ValidateCode validateCode = new ValidateCode(timeOut,code);
		session.setAttribute("validateCode", validateCode);//将验证码存放在session当中
		validateCode = (ValidateCode) session.getAttribute("validateCode");
		
		System.out.println("验证码为："+validateCode.getCode());
		return Action.SUCCESS;
	}
	/**
	 * 验证用户填写验证码的正确性
	 * 此方法执行前需前台验证完验证码是否为空。
	 */
	public String validateCode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String validate = request.getParameter("validate");
		ValidateCode validateCode = (ValidateCode) request.getSession().getAttribute("validateCode");
		if(validateCode == null){
			hashmap.put("validateState", "noVerificationCode");//用户没有获取验证码
			return Action.SUCCESS;
		}
		long currentTime = System.currentTimeMillis();
		if(currentTime <= validateCode.getExpire())
		{
			if(validate.equals(validateCode.getCode())){
				hashmap.put("validateState", "true");//验证成功
			}else
			{
				hashmap.put("validateState", "false");//验证失败
			}
		}else{
			hashmap.put("validateState", "validateTimeOut");//验证码超时
		}
		return Action.SUCCESS;
	}
	/**
	 * 验证用户所填图片验证码是否正确
	 */
	public String validatePicture(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String validate = request.getParameter("validate");//从前台获取验证码
		if(validate == null || validate.equals(""))
		{	
			hashmap.put("validateState", "null");//该用户未填写验证码
		}else
		{
			HttpSession session = request.getSession();
			String picture = (String) session.getAttribute("pictureValidate");
			if(picture == null || picture.equals("")){
				hashmap.put("validateState", "none");//图片验证码还未生成
			}else if(picture.equalsIgnoreCase(validate)){
				hashmap.put("validateState", "true");//图片验证码验证成功
			}else
			{
				hashmap.put("validateState", "fail");//用户填写验证码有误
			}
		}
		return Action.SUCCESS;
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
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
}
