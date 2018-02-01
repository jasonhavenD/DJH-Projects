package com.model.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FileUploadAction extends ActionSupport {
	private File file;
	// 提交过来的file的名字
	private String fileFileName;
	HashMap<String, Object> hashmap = new HashMap<String, Object>();
	/**
	 * 上传产品列表图片
	 * 
	 * @return
	 */
	public String uploadProductImg(){
		String filename = null;
		String root = null;
		Date tasktime = null;
		SimpleDateFormat df = null;
		try {
			Calendar cale = Calendar.getInstance();
			// 将Calendar类型转换成Date类型
			tasktime = cale.getTime();
			// 设置日期输出的格式
			df = new SimpleDateFormat("yyyy-MM-dd");

			root = ServletActionContext.getServletContext().getRealPath(
					"/admin/productimg/" + df.format(tasktime));
			File fp = new File(root);
			if (!fp.exists()) {
				fp.mkdirs();// 目录不存在的情况下，创建目录。
			}
			InputStream is = new FileInputStream(file);
			String type = fileFileName.substring(fileFileName.lastIndexOf("."));

			filename = String.valueOf(System.currentTimeMillis()) + type;
			OutputStream os = new FileOutputStream(new File(root, filename));
			byte[] buffer = new byte[1024];
			int length = 0;
			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			os.close();
			is.close();
		} catch (Exception e) {
		}
		
		hashmap.put("path", "/LightSystem20161016/admin/productimg/" + df.format(tasktime)
				+ "/" + filename);
		return SUCCESS;
	}

	/**
	 * 上传产品类型图片
	 * 
	 * @return
	 */
	public String uploadTypeP() {
		String filename = null;
		String root = null;
		Date tasktime = null;
		SimpleDateFormat df = null;
		try {
			Calendar cale = Calendar.getInstance();
			// 将Calendar类型转换成Date类型
			tasktime = cale.getTime();
			// 设置日期输出的格式
			df = new SimpleDateFormat("yyyy-MM-dd");

			root = ServletActionContext.getServletContext().getRealPath(
					"/admin/typeimg/" + df.format(tasktime));
			File fp = new File(root);
			if (!fp.exists()) {
				fp.mkdirs();// 目录不存在的情况下，创建目录。
			}
			InputStream is = new FileInputStream(file);
			String type = fileFileName.substring(fileFileName.lastIndexOf("."));

			filename = String.valueOf(System.currentTimeMillis()) + type;
			OutputStream os = new FileOutputStream(new File(root, filename));
			byte[] buffer = new byte[1024];
			int length = 0;
			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			os.close();
			is.close();
		} catch (Exception e) {
		}
		hashmap.put("path", "/LightSystem20161016/admin/typeimg/" + df.format(tasktime)
				+ "/" + filename);
		return SUCCESS;
	}
	


	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}



	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}



	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	

}
