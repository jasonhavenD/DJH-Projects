package com.model.action;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Company;
import com.entity.Userinfo;
import com.model.service.CompanyService;
import com.opensymphony.xwork2.Action;

import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

@Entity
@Controller
@Scope("prototype")
public class AuthenticateImgAction {
	@ManyToOne
	@Resource
	private CompanyService companyService;
	private File image;//与前台file类型的input框名字相同
	private String imageFileName;//固定格式**FileName
	private String imageContentType;//固定格式**ContentType
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	
	public String idcardpictureUpload(){
		String idcardpicture = ImageUpload();
		Userinfo user = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		Integer companyid = user.getUserinfoid();
		companyService.updateIdcardpicture(idcardpicture, companyid);
		/**
		 * 获取相对于根目录的路径将其保存在数据库中
		 */
		hashmap.put("imagepath", idcardpicture);
		return Action.SUCCESS;
	}
	public String companylicensepictureUpload(){
		String companylicensepicture = ImageUpload();
		Userinfo user = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		Integer companyid = user.getUserinfoid();
		companyService.updateCompanylicensepicture(companylicensepicture, companyid);
		hashmap.put("imagepath1", companylicensepicture);
		return Action.SUCCESS;
	}
	public String companypictureUpload(){
		String companypicture = ImageUpload();//
		Userinfo user = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		Integer companyid = user.getUserinfoid();
		companyService.updateCompanypicture(companypicture, companyid);
		System.out.println("companypicture:"+companypicture);
		hashmap.put("imagepath2", companypicture);
		return Action.SUCCESS;
	}
	/**
	 * 图片上传
	 * @return
	 */
	private String ImageUpload(){
		FileInputStream input = null;//读入从前台传过来的文件流
		FileOutputStream output = null;
		String nFilename="";
		try{
			//获取上传到磁盘的真实路径，即配置到服务器上的工程的真是路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/authenticImage");
			File file = new File(realPath);
			if(!file.exists())
				file.mkdirs();//创建目录
			input = new FileInputStream(image);
			String filename = getImageNewName(imageFileName);//获得加密文件名
			nFilename = filename.replace("-", "");
			output = new FileOutputStream(realPath+"/"+nFilename);//写文件   目录+文件名
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = input.read(buffer))>0){
				output.write(buffer, 0, buffer.length);
			}
			System.out.println("/authenticImage/"+nFilename);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return "/authenticImage/"+nFilename;//返回相对于项目跟目录的路径保存在数据库中
	}
	/**
	 * 重新定义文件名,加密文件名(将文件名+用户id+系统当前时间的用md5算法加密)
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getImageNewName(String imageFileName) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		System.out.println(imageFileName);
		int index = imageFileName.indexOf(".");
		String image = imageFileName.substring(0,index);
		System.out.println(image);
		StringBuffer filename = new StringBuffer(image);
		StringBuffer result = new StringBuffer();
		Userinfo user = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(user != null){
			filename.append(user.getUserinfoid());
		}
		filename.append(System.currentTimeMillis());
		MessageDigest md5 = MessageDigest.getInstance("md5");
		md5.update(filename.toString().getBytes("utf-8"));
		byte[]encrypt = md5.digest();
		for(byte b : encrypt){
			result.append(b);
		}
		result.append(imageFileName.substring(index));
		System.out.println(result);
		return result.toString();
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
}
