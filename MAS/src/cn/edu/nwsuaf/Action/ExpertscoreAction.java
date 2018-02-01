package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Model.ExpertscoreModel;
import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;
import cn.edu.nwsuaf.Model.StuthesisModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertscoreService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class ExpertscoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ERROR = null;
	private static final String SUCCESS = null;
	private List<Float> scoreList;// 分数列表

	// service
	private DepartmentService departmentService;
	private MajorService majorService;
	private ExpertscoreService expertscoreservice;
	private FileinfoattachmentService fiaService;

	// 前台 列表读取
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<Expertscore> expertscoreList;// 专家评分表
	private List<FileinfoAttachment> fiaList;
	private FileinfoAttachment fia;
	private FileinfoAttachmentModel fiamodel;
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private Expertscore expertscore;// 分数实体

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private ExpertscoreModel expertscoreModel = new ExpertscoreModel();

	private String attachmentId;
	private boolean flag;
	private HttpServletRequest request;
	private String patentNumber;
	private String result;
	private int rol;
	private int epertscoreId;
	private float asseisingValue;
	private String date = "保存失败";
	private HashMap<String, Object> map;
	// pdf路径名称
	private String pdfFileName;
	// 错误提示
	private String errstring;

	// 专家打分
	public int getEpertscoreId() {
		return epertscoreId;
	}

	public void setEpertscoreId(int epertscoreId) {
		this.epertscoreId = epertscoreId;
	}

	public String saveExpertscore() {
		map = new HashMap<String, Object>();
		try {
			List<Expertscore> e;
			e = expertscoreservice.findByHQL("from Expertscore as e where e.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1' and e.epertscoreId='"
							+ epertscoreId + "'");
			if (e.size() == 0) {
				expertscore = new Expertscore();
				expertscore.setEpertscoreId(e.get(0).getEpertscoreId());
				expertscore.setFileinfoAttachment(e.get(0).getFileinfoAttachment());
				expertscore.setAsseisingValue(asseisingValue);
				expertscore.setBeizhu(e.get(0).getBeizhu());
				expertscore.setTag(e.get(0).getTag());
				expertscoreservice.save(expertscore);
				map.put("id", epertscoreId);
				date = "保存成功";
			} else {
				expertscore = new Expertscore();
				expertscore.setEpertscoreId(e.get(0).getEpertscoreId());
				expertscore.setFileinfoAttachment(e.get(0).getFileinfoAttachment());
				expertscore.setExpert(e.get(0).getExpert());
				expertscore.setAsseisingValue(asseisingValue);
				expertscore.setBeizhu(e.get(0).getBeizhu());
				expertscore.setTag(e.get(0).getTag());
				expertscoreservice.update(expertscore);
				map.put("id", epertscoreId);
				date = "保存成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	public String cover() {
		String ExptuserID = QueryUtil.getUserMno().getUserCode();
		try {
			System.out.println("覆盖");
			expertscoreList = expertscoreservice.findEntityByName(
					Expertscore.class, "ExptuserID", ExptuserID);

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		//HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session = request.getSession();
		//String role = (String) session.getAttribute("rol");
		boolean isExpert;
		System.out.println(rol);
		if (rol==5) {
			isExpert = true;
			System.out.println("aaa!");
		} else {
			isExpert = false;
		}
		String mno = "";
		String dno = "";
		System.out.println(isExpert);
		try {
			if (!isExpert) {
				mno = QueryUtil.getUserMno().getMajor().getInMno();
				dno = QueryUtil.getUserMno().getDepartment().getDno();
			}
		} catch (Exception e) {
			//e.printStack();
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();

		expertscoreModel = null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = expertscoreservice.findMajorList(sysuserinfo, isExpert);
			yearList = expertscoreservice.findYearList();
			expertscoreList = expertscoreservice.findallExpertscoreList(page,
					rows, sysuserinfo, isExpert);
			totalRows = expertscoreservice.count(sysuserinfo, isExpert);
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

	// 初始化修改页面
	public String initEdit() {
		try {
			if (epertscoreId == 0) {
				expertscore = null;
			} else {
				expertscore = expertscoreservice.findById(Expertscore.class,
						epertscoreId);
			}
			pdfFileName = expertscore.getFileinfoAttachment().getActualPath();
			pdfFileName = pdfFileName.substring(pdfFileName.indexOf("/MAS/"),
					pdfFileName.lastIndexOf("."))
					+ ".pdf";// todo: calc
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	// 多条件查询信息
	public String findexpertscore() {

		//HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session = request.getSession();
		//String role = (String) session.getAttribute("rol");
		boolean isExpert;
		if (rol==5) {
			isExpert = true;
		} else {
			isExpert = false;
		}

		String mno = "";
		String dno = "";
		try {
			if (!isExpert) {

				mno = QueryUtil.getUserMno().getMajor().getInMno();
				dno = QueryUtil.getUserMno().getDepartment().getDno();
			}
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		try {
			System.out.println("当前页数是==" + page);
			// expertscore=expertscoreservice.findById(Expertscore.class,
			// epertscoreId);
			setDepartmentList(departmentService.findAll(Department.class));
			majorList = expertscoreservice.findMajorList(sysuserinfo, isExpert);
			setYearList(expertscoreservice.findYearList());
			if (!isExpert) {
				if (!mno.equals("000000")) {
					expertscoreModel.setMajorId(mno);

				} else if (!dno.equals("00000") && mno.equals("000000")) {

					expertscoreModel.setDepartmentId(dno);
				}
			}
			if (expertscoreModel == null) {
				expertscoreModel = new ExpertscoreModel();
				expertscoreModel.setIndicatorName("");
				expertscoreModel.setIsScore("");
				expertscoreModel.setMajorId(null);
			} else if (expertscoreModel.getIndicatorName() != null
					&& expertscoreModel.getIsScore() != null) {
				expertscoreModel.setIndicatorName(java.net.URLDecoder.decode(
						expertscoreModel.getIndicatorName(), "UTF-8"));
				expertscoreModel.setIsScore(java.net.URLDecoder.decode(
						expertscoreModel.getIsScore(), "UTF-8"));
			}
			expertscoreList = expertscoreservice.findExpertscoreList(
					expertscoreModel, page, rows, sysuserinfo, isExpert);
			totalRows = expertscoreservice.countFindFia(expertscoreModel,
					sysuserinfo, isExpert);
			System.out.println("totalRows" + totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	// get-set
	public ExpertscoreService getExpertscoreservice() {
		return expertscoreservice;
	}

	public void setExpertscoreservice(ExpertscoreService expertscoreservice) {
		this.expertscoreservice = expertscoreservice;
	}

	public void setScoreList(List<Float> scoreList) {
		this.scoreList = scoreList;
	}

	public List<Float> getScoreList() {
		return scoreList;
	}

	public float getAsseisingValue() {
		return asseisingValue;
	}

	public void setAsseisingValue(float asseisingValue) {
		this.asseisingValue = asseisingValue;
	}

	public void setExpertscore(Expertscore expertscore) {
		this.expertscore = expertscore;
	}

	public Expertscore getExpertscore() {
		return expertscore;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}

	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
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

	public static String getError() {
		return ERROR;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}

	public String getPatentNumber() {
		return patentNumber;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getRol() {
		return rol;
	}

	public void setExpertscoreModel(ExpertscoreModel expertscoreModel) {
		this.expertscoreModel = expertscoreModel;
	}

	public ExpertscoreModel getExpertscoreModel() {
		return expertscoreModel;
	}

	public void setExpertscoreList(List<Expertscore> expertscoreList) {
		this.expertscoreList = expertscoreList;
	}

	public List<Expertscore> getExpertscoreList() {
		return expertscoreList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setFiaList(List<FileinfoAttachment> fiaList) {
		this.fiaList = fiaList;
	}

	public List<FileinfoAttachment> getFiaList() {
		return fiaList;
	}

	public void setFia(FileinfoAttachment fia) {
		this.fia = fia;
	}

	public FileinfoAttachment getFia() {
		return fia;
	}

	public void setFiamodel(FileinfoAttachmentModel fiamodel) {
		this.fiamodel = fiamodel;
	}

	public FileinfoAttachmentModel getFiamodel() {
		return fiamodel;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

}
