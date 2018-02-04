package cn.edu.fileaciton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.entity.Teacherinfo;

import com.opensymphony.xwork2.ActionSupport;

public class UpDownFileAction extends ActionSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OnlinetrainDAO.class);
	private File formFile;// 得到上传的文件
	private String formFileContentType;// 得到文件的类型
	private String formFileFileName;// 得到文件的名称
	private String downLoadFile;// 前台提供
	private String downLoadFilePath;
	private String fileType;// 上传的文件类型//"结业证书" "学习心得" "成绩单" "其他材料"
	InputStream inputStream;

	// 文件保存目录
	private String uploadDir;

	// 构成文件名的各部分
	private String teacherName;

	/**
	 * 设置长传的文件目录
	 */
	private void setUploadDir(boolean isUpload, String downLoadfileName) {
		log.error("UpDownFileAction-setUploadDir()");
		// 设置用户名
		setTeacherName();
		if (fileType == null) {
			System.out.println("fileType==null");
		} else {
			System.out.println("fileType=" + fileType);
		}
		if (isUpload) {
			uploadDir = "/TeacherManager/upload/" + teacherName + "/"
					+ fileType;
			String realpath = ServletActionContext.getServletContext()
					.getRealPath(uploadDir);
			File file = new File(uploadDir);
			if (!file.exists()) {
				file.mkdirs();
			}
		} else {
			uploadDir = "/TeacherManager/download/";
			String realpath = ServletActionContext.getServletContext()
					.getRealPath(uploadDir);
			File file = new File(uploadDir);
			if (!file.exists()) {
				file.mkdirs();
			}
			downLoadFilePath = uploadDir + downLoadfileName;
		}
	}

	private void setTeacherName() {
		log.error("UpDownFileAction-setTeacherName()");
		Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("loginedUser");
		teacherName = u.getTname();
	}

	/**
	 * 上传附件
	 */
	public String uploadFile() {
		log.error("UpDownFileAction-uploadFile()");
		// 设置目录
		setUploadDir(true, null);
		if (teacherName == null || formFile == null
				|| formFileContentType == null || fileType == null) {
			System.out.println("上传用户" + teacherName);
			System.out.println("上传文件名" + formFile);
			System.out.println("上传文件类型" + formFileContentType);
			System.out.println("上传的材料类型" + fileType);
			return "input";
		}
		System.out.println("上传用户" + teacherName);
		System.out.println("上传文件名" + formFile);
		System.out.println("上传文件类型" + formFileContentType);
		System.out.println("上传的材料类型" + fileType);

		// 基于myFile创建一个文件输入流
		InputStream is = null;

		// 创建一个输出流
		OutputStream os = null;

		try {
			is = new FileInputStream(formFile);
		} catch (FileNotFoundException e2) {
			return "input";
		}

		// 设置上传文件目录
		String uploadPath = uploadDir;

		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String time = form.format(date.getTime());

		System.out.println(formFileFileName);
		// 设置文件名
		String fileName = "xxx";
		String extension = "txt";
		int idx = formFileFileName.lastIndexOf('.');
		fileName = formFileFileName.substring(0, idx);
		extension = formFileFileName.substring(idx);
		String fullFileName = fileName + '-' + time + extension;

		// 设置目标文件
		File toFile = new File(uploadPath, fullFileName);

		// 判断文件是否存在
		if (!toFile.exists()) {
			try {
				toFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			os = new FileOutputStream(toFile);
		} catch (FileNotFoundException e1) {
			return "input";
		}

		// 设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		// 读取myFile文件输出到toFile文件中
		try {
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输入流
				is.close();
				// 关闭输出流
				os.close();
			} catch (IOException e) {
				return "input";
			}

		}

		return "success1";
	}

	/**
	 * 下载附件
	 */
	public String downloadFile() {
		log.error("UpDownFileAction-downloadFile()");
		setUploadDir(false, downLoadFile);
		System.out.println(downLoadFilePath);
		return "success2";
	}

	public InputStream getInputStream() throws Exception {
		log.error("UpDownFileAction-getInputStream()");
		inputStream = new FileInputStream(downLoadFilePath);
		return inputStream;
	}

	/**
	 * 设置下载文件的名字
	 * 
	 * @return
	 */
	public String getFilename() {
		log.error("UpDownFileAction-getFilename()");
		String name = FileNameUtil.getRandomNumAndChacters(30);
		int idx = downLoadFile.lastIndexOf('.');
		String extension = downLoadFile.substring(idx);
		return name + extension;
	}

	public File getFormFile() {
		return formFile;
	}

	public void setFormFile(File formFile) {
		this.formFile = formFile;
	}

	public String getFormFileContentType() {
		return formFileContentType;
	}

	public void setFormFileContentType(String formFileContentType) {
		this.formFileContentType = formFileContentType;
	}

	public String getFormFileFileName() {
		return formFileFileName;
	}

	public void setFormFileFileName(String formFileFileName) {
		this.formFileFileName = formFileFileName;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDownLoadFile() throws Exception {
		return new String(downLoadFile.getBytes(), "iso-8859-1");
	}

	public void setDownLoadFile(String downLoadFile) {
		this.downLoadFile = downLoadFile;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	......
	public  set/get(){}


}


