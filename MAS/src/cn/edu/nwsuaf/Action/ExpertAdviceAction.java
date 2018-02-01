package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertadviceService;
import cn.edu.nwsuaf.Service.Impl.ExpertscoreService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Expertadvice;
import cn.edu.nwsuaf.bean.Expertmajor;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ExpertAdviceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int rol;
	private String mno;
	private String errstring;
	private String question;
	private String advice;
	private Expertadvice expertadvice;
	private String expertName;
	private List<Expertadvice> eaList;
	private String mname;
	private MajorService majorService;
	private DepartmentService departmentService;
	private ExpertscoreService expertscoreService;
	private ExpertadviceService expertadviceService;
	private List<Major> majorList;// 专业
	private List<Department> departmentList;// 专业

	public String initSearch() {
		boolean isExpert;
		System.out.println(expertName);
		expertName="";
		// System.out.println(rol);
		if (rol == 5) {
			isExpert = true;

		} else {
			isExpert = false;
		}
		System.out.println(isExpert);
		try {
			if (!isExpert) {
				//mno = QueryUtil.getUserMno().getMajor().getInMno();
				mno = null;
				// 初始化查询
				List eaListCount = expertadviceService.searchByModel("", "");
				page = 1;
				rows = 10;

				totalRows = eaListCount.size();

				eaList = expertadviceService.searchByModelPage("", "", page,
						rows);

				if (totalRows % rows == 0) {
					totalPage = totalRows / rows;
				} else {
					totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
				}
			}

		} catch (Exception e) {
			// e.printStack();
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		departmentList = departmentService.findAll(Department.class);
		majorList = expertscoreService.findMajorList(sysuserinfo, isExpert);

		if (isExpert) {
			if(majorList!=null&&majorList.size()!=0){
				mno = majorList.get(0).getMno();
				return "expertsuccess";
			}
			else{
				return "expertnull";
			}
			
			
		} else {
			return "success";
		}

	}

	public String saveAdvice() {
		Expertmajor em = null;
		em = expertadviceService.findexpertmajor(mno).get(0);
		System.out.println(mno + "  " + question + "   " + advice);
		expertadviceService.updateEA(em.getExpertMajorCode(), question, advice);

		return "success";
	}

	public String findAdvice() {
		Expertmajor em = null;
		System.out.println("mno:" + mno);
		if(majorList!=null&&majorList.size()!=0){
			em = expertadviceService.findexpertmajor(mno).get(0);		
			expertadvice = expertadviceService.findEA(em.getExpertMajorCode());
			setQuestion(expertadvice.getQuestion());
			question = expertadvice.getQuestion();
			setAdvice(expertadvice.getAdvice());
			mname=expertadviceService.findByIdName(Major.class,mno);
		}
		return "success";
	}

	public String searchAdvice() {

		System.out.println(page
				+ " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
				+ rows);
		List eaListCount = expertadviceService.searchByModel(mno, expertName);
		totalRows = eaListCount.size();

		eaList = expertadviceService.searchByModelPage(mno, expertName, page,
				rows);

		if (totalRows % rows == 0) {
			totalPage = totalRows / rows;
		} else {
			totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
		}
		System.out.println(eaList.size());
		return SUCCESS;
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

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public ExpertscoreService getExpertscoreService() {
		return expertscoreService;
	}

	public void setExpertscoreService(ExpertscoreService expertscoreservice) {
		this.expertscoreService = expertscoreservice;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public ExpertadviceService getExpertadviceService() {
		return expertadviceService;
	}

	public void setExpertadviceService(ExpertadviceService expertadviceService) {
		this.expertadviceService = expertadviceService;
	}

	public Expertadvice getExpertadvice() {
		return expertadvice;
	}

	public void setExpertadvice(Expertadvice expertadvice) {
		this.expertadvice = expertadvice;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public List<Expertadvice> getEaList() {
		return eaList;
	}

	public void setEaList(List<Expertadvice> eaList) {
		this.eaList = eaList;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

}
