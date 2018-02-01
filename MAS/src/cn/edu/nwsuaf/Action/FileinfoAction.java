package cn.edu.nwsuaf.Action;

import java.util.List;
import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;


public class FileinfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Service
	private FileinfoattachmentService fiaService;

	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<FileinfoAttachment> fiaList;// 

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private FileinfoAttachment fia;
	private FileinfoAttachmentModel fiamodel = new FileinfoAttachmentModel();
	
	private String attachmentId;
	private boolean flag;
	private HttpServletRequest request;
	private String patentNumber;
	private String result;
	private int rol;
	//错误提示
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public String attachFileList(){
		try{
			fia = fiaService.findById(FileinfoAttachment.class, attachmentId);
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String cover(){
		try{
			System.out.println("覆盖");
			fia = fiaService.findById(FileinfoAttachment.class, attachmentId);
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		fiamodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = fiaService.findYearList();
			fiaList = fiaService.findallFileinfoAttachmentList(page, rows,mno,dno);
			
			totalRows=fiaService.count(mno,dno);
			System.out.println("init"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}
	//多条件查询信息
	public String findFia() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	setErrstring("登录超时！请安全退出再重新登录！");
        	return "errorstring";
        }
		try {
			System.out.println("当前页数是=="+page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = fiaService.findYearList();
			if(!mno.equals("000000")){
				fiamodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				fiamodel.setDepartmentId(dno);
			}

			fiaList = fiaService.findFiaList(fiamodel, page,
					rows);
			totalRows = fiaService.countFindFia(fiamodel);
			System.out.println("totalRows"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//get-----set方法
	
	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}


	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPatentNumber() {
		return patentNumber;
	}

	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}
	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}
	public List<FileinfoAttachment> getFiaList() {
		return fiaList;
	}
	public void setFiaList(List<FileinfoAttachment> fiaList) {
		this.fiaList = fiaList;
	}
	public FileinfoAttachment getFia() {
		return fia;
	}
	public void setFia(FileinfoAttachment fia) {
		this.fia = fia;
	}
	public FileinfoAttachmentModel getFiamodel() {
		return fiamodel;
	}
	public void setFiamodel(FileinfoAttachmentModel fiamodel) {
		this.fiamodel = fiamodel;
	}
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

}
