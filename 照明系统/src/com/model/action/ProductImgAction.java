package com.model.action;

import javax.persistence.Entity;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import java.io.*;
import java.util.*;
/**
 * 上传产品多文件上传
 *
 */
@Entity
@Controller
@Scope("prototype")
public class ProductImgAction {
	private File[] image;
	private String[] imageFileName;
	private String[] imageContentType;
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	public String upload(){
		FileInputStream input = null;
		FileOutputStream output = null;
		String []filenames = null; 
		try{
			String realPath = ServletActionContext.getServletContext().getRealPath("/product");
			File file = new File(realPath);
			if(!file.exists())
				file.mkdirs();
			int length = image.length;
			if(length > 5){
				hashmap.put("filenames", "more");
				return Action.SUCCESS;
			}
			filenames = new String[length];
			String str = ".*\\.(?i)png|.*\\.(?i)jpg|.*\\.(?i)gif|.*\\.(?i)jpeg|.*\\.(?i)tag|.*\\.(?i)tiff|.*\\.(?i)bm|.*\\.(?i)svg|.*\\.(?i)pcx|.*\\.(?i)dxf|.*\\.(?i)wmf|.*\\.(?i)emf|.*\\.(?i)lic|.*\\.(?i)fli|.*\\.(?i)flc|.*\\.(?i)eps|.*\\.(?i)tga|.*\\.(?i)jpg";
			for(int i = 0; i < length; i++ ){
				if(!imageFileName[i].matches(str)){
					hashmap.put("filenames", "fomarterror");
					return Action.SUCCESS;
				}
			}
			for(int i = 0; i < length; i++ ){
				input = new FileInputStream(image[i]);
				String filename = AuthenticateImgAction.getImageNewName(imageFileName[i]);
				filename = filename.replace("-", "");
				output = new FileOutputStream(realPath+"/"+filename);
				byte[] buffer = new byte[1024];
				while((input.read(buffer)) > 0)
				{
					output.write(buffer,0,buffer.length);
				}
				filenames[i] = "/LightSystem20161016/product/"+filename;
			}
			int filelength = filenames.length;
			StringBuffer fileStr = new StringBuffer();
			for(int i = 0 ; i < filelength; i++){
				fileStr.append(filenames[i]);
				if( i != (filelength - 1)){
					fileStr.append("|");
				}
			}
			System.out.println( fileStr.toString());
			hashmap.put("filenames", fileStr.toString());
		}catch(Exception e){
			hashmap.put("filenames", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	public File[] getImage() {
		return image;
	}
	public void setImage(File[] image) {
		this.image = image;
	}
	
	public String[] getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String[] getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
	
}
