package cn.edu.fileaciton;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 导出Excel文件
 * 
 */
public class ExportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 公用参数
	private String exportName;
	private Integer isDownload = 0;
	private Date date = new Date();
	private String comNumber;
	private String insNumber;
	private int stuComNumber;

	// Service
	// private StudentService studentService;// 学生
	// Model
	// private StudentModel studentmodel;// 学生
	// 输出列表
	// private List<Student> studentList = new ArrayList<Student>();// 学生

	/**
	 * 导出Excel文件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		
		return "";
	}
}
