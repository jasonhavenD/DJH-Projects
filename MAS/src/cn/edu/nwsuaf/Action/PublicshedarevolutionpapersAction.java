package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.PublicshedaacademicpapersModel;
import cn.edu.nwsuaf.Model.PublicshedarevolutionpapersModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.PublicshedarevolutionpapersService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Publicshedaacademicpapers;
import cn.edu.nwsuaf.bean.Publicshedarevolutionpapers;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;


public class PublicshedarevolutionpapersAction extends ActionSupport {

	//教改论文
	private static final long serialVersionUID = 1L;

	// Service
	private PublicshedarevolutionpapersService publicshedarevolutionpapersService;

	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Publicshedarevolutionpapers> pepList;

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> periodicalTypeList;
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private String majorId;
	private String departmentId;
	private Publicshedarevolutionpapers publicshedarevolutionpapers;
	private PublicshedarevolutionpapersModel pepmodel = new PublicshedarevolutionpapersModel();
	private int revoPaperNo;
	private int rol;
	//错误提示
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	// 初始化修改页面
	public String initEdit() {

		try {
			if (revoPaperNo == 0) {
				publicshedarevolutionpapers = null;
			} else {

				publicshedarevolutionpapers = publicshedarevolutionpapersService.findById(Publicshedarevolutionpapers.class, revoPaperNo);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiPep() {
		try {

			List<Publicshedarevolutionpapers> s;
			s = publicshedarevolutionpapersService
					.findByHQL("from Publicshedarevolutionpapers as pu where pu.revoPaperNo="
							+ publicshedarevolutionpapers.getRevoPaperNo() );
			if (s.size() == 0) {
				publicshedarevolutionpapersService.save(publicshedarevolutionpapers);
			} else {

				publicshedarevolutionpapersService.update(publicshedarevolutionpapers);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertPep() {
		try {
			publicshedarevolutionpapersService.save(publicshedarevolutionpapers);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deletePep() {
		try {
			Publicshedarevolutionpapers publicshedarevolutionpaperss = publicshedarevolutionpapersService.findById(Publicshedarevolutionpapers.class,
					revoPaperNo);
			publicshedarevolutionpapersService.delete(publicshedarevolutionpaperss);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	
	// 删除某学院的查询信息
	public String clearPep() {
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
			if(pepmodel==null){
				pepmodel=new PublicshedarevolutionpapersModel();
				pepmodel.setId("");
				pepmodel.setName("");
				pepmodel.setPeriodicalType("");
				pepmodel.setRevoPaperName("");
				pepmodel.setYear("");
			}
			else if(pepmodel!=null&&pepmodel.getName()!=null&&pepmodel.getPeriodicalType()!=null){
				pepmodel.setName(java.net.URLDecoder.decode(pepmodel.getName(),"UTF-8"));
				pepmodel.setPeriodicalType(java.net.URLDecoder.decode(pepmodel.getPeriodicalType(),"UTF-8"));
			}
			if(!mno.equals("000000")){
				pepmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				pepmodel.setDepartmentId(dno);
			}			
			List<Publicshedarevolutionpapers> publicshedaacademicpaperssList=new ArrayList<Publicshedarevolutionpapers>();
			publicshedaacademicpaperssList = publicshedarevolutionpapersService.clearPepList(pepmodel);
			for(Publicshedarevolutionpapers p:publicshedaacademicpaperssList){
				publicshedarevolutionpapersService.delete(p);
			}			
		} catch (Exception e) {			
			return "error";
		}
		return "success";
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
		pepmodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = publicshedarevolutionpapersService.findYearList();
			periodicalTypeList=publicshedarevolutionpapersService.findPeriodicalTypeList();
			pepList = publicshedarevolutionpapersService.findallPublicshedarevolutionpapersList(page, rows,mno,dno);
			totalRows=publicshedarevolutionpapersService.count(mno,dno);
			System.out.println("init"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";

	}
	//多条件查询信息
	public String findPep() throws UnsupportedEncodingException {
		
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
			yearList = publicshedarevolutionpapersService.findYearList();
			periodicalTypeList=publicshedarevolutionpapersService.findPeriodicalTypeList();
			if(!mno.equals("000000")){
				pepmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				pepmodel.setDepartmentId(dno);
			}
			if(pepmodel==null){
				pepmodel=new PublicshedarevolutionpapersModel();
				pepmodel.setId("");
				pepmodel.setName("");
				pepmodel.setPeriodicalType("");
				pepmodel.setRevoPaperName("");
				pepmodel.setYear("");
			}
			else if(pepmodel!=null&&pepmodel.getName()!=null&&pepmodel.getPeriodicalType()!=null){
				pepmodel.setName(java.net.URLDecoder.decode(pepmodel.getName(),"UTF-8"));
				pepmodel.setPeriodicalType(java.net.URLDecoder.decode(pepmodel.getPeriodicalType(),"UTF-8"));
			}
			pepList = publicshedarevolutionpapersService.findPepList(pepmodel, page,
					rows);
			totalRows = publicshedarevolutionpapersService.countFindPep(pepmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	
	//get-----set方法
	

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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

	public PublicshedarevolutionpapersService getPublicshedarevolutionpapersService() {
		return publicshedarevolutionpapersService;
	}

	public void setPublicshedarevolutionpapersService(
			PublicshedarevolutionpapersService publicshedarevolutionpapersService) {
		this.publicshedarevolutionpapersService = publicshedarevolutionpapersService;
	}

	public List<Publicshedarevolutionpapers> getPepList() {
		return pepList;
	}

	public void setPepList(List<Publicshedarevolutionpapers> pepList) {
		this.pepList = pepList;
	}

	public Publicshedarevolutionpapers getPublicshedarevolutionpapers() {
		return publicshedarevolutionpapers;
	}

	public void setPublicshedarevolutionpapers(
			Publicshedarevolutionpapers publicshedarevolutionpapers) {
		this.publicshedarevolutionpapers = publicshedarevolutionpapers;
	}

	public PublicshedarevolutionpapersModel getPepmodel() {
		return pepmodel;
	}

	public void setPepmodel(PublicshedarevolutionpapersModel pepmodel) {
		this.pepmodel = pepmodel;
	}

	public int getRevoPaperNo() {
		return revoPaperNo;
	}

	public void setRevoPaperNo(int revoPaperNo) {
		this.revoPaperNo = revoPaperNo;
	}

	public List<String> getPeriodicalTypeList() {
		return periodicalTypeList;
	}

	public void setPeriodicalTypeList(List<String> periodicalTypeList) {
		this.periodicalTypeList = periodicalTypeList;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	
	

}
