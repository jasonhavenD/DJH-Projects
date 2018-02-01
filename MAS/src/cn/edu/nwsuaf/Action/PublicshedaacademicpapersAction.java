package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.nwsuaf.Model.PublicshedaacademicpapersModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.PublicshedaacademicpapersService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Publicshedaacademicpapers;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;


public class PublicshedaacademicpapersAction extends ActionSupport {
	
    //科研论文
	private static final long serialVersionUID = 1L;

	// Service
	private PublicshedaacademicpapersService publicshedaacademicpapersService;
	
	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Publicshedaacademicpapers> papList;

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
	private Publicshedaacademicpapers publicshedaacademicpapers;
	private PublicshedaacademicpapersModel papmodel = new PublicshedaacademicpapersModel();
	private int paperNo;
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
			if (paperNo == 0) {
				publicshedaacademicpapers = null;
			} else {

				publicshedaacademicpapers = publicshedaacademicpapersService.findById(Publicshedaacademicpapers.class, paperNo);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiPap() {
		try {

			List<Publicshedaacademicpapers> s;
			s = publicshedaacademicpapersService
					.findByHQL("from Publicshedaacademicpapers as pu where pu.paperNo="
							+ publicshedaacademicpapers.getPaperNo() );
			if (s.size() == 0) {
				publicshedaacademicpapersService.save(publicshedaacademicpapers);
			} else {

				publicshedaacademicpapersService.update(publicshedaacademicpapers);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertPap() {
		try {
			publicshedaacademicpapersService.save(publicshedaacademicpapers);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deletePap() {
		try {
			Publicshedaacademicpapers publicshedaacademicpaperss = publicshedaacademicpapersService.findById(Publicshedaacademicpapers.class,
					paperNo);
			publicshedaacademicpapersService.delete(publicshedaacademicpaperss);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}
	// 删除某学院的查询信息
	public String clearPap() {
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
			if(papmodel==null){
				papmodel=new PublicshedaacademicpapersModel();
            	papmodel.setId("");
            	papmodel.setPaperName("");
            	papmodel.setPeriodicalType("");
            	papmodel.setYear("");
            }
            else if(papmodel!=null&&papmodel.getName()!=null&&papmodel.getPeriodicalType()!=null){
            	papmodel.setName(java.net.URLDecoder.decode(papmodel.getName(), "UTF-8"));
            	papmodel.setPeriodicalType(java.net.URLDecoder.decode(papmodel.getPeriodicalType(), "UTF-8"));
            }
			if(!mno.equals("000000")){
				papmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				papmodel.setDepartmentId(dno);
			}
			List<Publicshedaacademicpapers> publicshedaacademicpaperssList=new ArrayList<Publicshedaacademicpapers>();
			publicshedaacademicpaperssList = publicshedaacademicpapersService.clearPapList(papmodel);
			for(Publicshedaacademicpapers p:publicshedaacademicpaperssList){
				publicshedaacademicpapersService.delete(p);
			}			
		} catch (Exception e) {			
			return "error";
		}
		return "success";
	}

	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		
		papmodel=null;
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
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = publicshedaacademicpapersService.findYearList();
			periodicalTypeList=publicshedaacademicpapersService.findPeriodicalTypeList();
			papList = publicshedaacademicpapersService.findallPublicshedaacademicpapersList(page, rows,mno,dno);
			totalRows=publicshedaacademicpapersService.count(mno,dno);
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
	public String findPap() throws UnsupportedEncodingException {

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
			yearList = publicshedaacademicpapersService.findYearList();
			periodicalTypeList=publicshedaacademicpapersService.findPeriodicalTypeList();			
			if(papmodel==null){
				papmodel=new PublicshedaacademicpapersModel();
            	papmodel.setId("");
            	papmodel.setPaperName("");
            	papmodel.setPeriodicalType("");
            	papmodel.setYear("");
            }
            else if(papmodel!=null&&papmodel.getName()!=null&&papmodel.getPeriodicalType()!=null){
            	papmodel.setName(java.net.URLDecoder.decode(papmodel
						.getName(), "UTF-8"));
            	papmodel.setPeriodicalType(java.net.URLDecoder.decode(papmodel
						.getPeriodicalType(), "UTF-8"));
            }
			if(!mno.equals("000000")){
				papmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				papmodel.setDepartmentId(dno);
			}
			papList = publicshedaacademicpapersService.findPapList(papmodel, page,
					rows);
			totalRows = publicshedaacademicpapersService.countFindPap(papmodel);
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
	

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

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

	public PublicshedaacademicpapersService getpublicshedaacademicpapersService() {
		return publicshedaacademicpapersService;
	}

	public void setpublicshedaacademicpapersService(
			PublicshedaacademicpapersService publicshedaacademicpapersService) {
		this.publicshedaacademicpapersService = publicshedaacademicpapersService;
	}

	public PublicshedaacademicpapersService getPublicshedaacademicpapersService() {
		return publicshedaacademicpapersService;
	}

	public void setPublicshedaacademicpapersService(
			PublicshedaacademicpapersService publicshedaacademicpapersService) {
		this.publicshedaacademicpapersService = publicshedaacademicpapersService;
	}

	public List<Publicshedaacademicpapers> getPapList() {
		return papList;
	}

	public void setPapList(List<Publicshedaacademicpapers> papList) {
		this.papList = papList;
	}

	public Publicshedaacademicpapers getPublicshedaacademicpapers() {
		return publicshedaacademicpapers;
	}

	public void setPublicshedaacademicpapers(
			Publicshedaacademicpapers publicshedaacademicpapers) {
		this.publicshedaacademicpapers = publicshedaacademicpapers;
	}

	public PublicshedaacademicpapersModel getPapmodel() {
		return papmodel;
	}

	public void setPapmodel(PublicshedaacademicpapersModel papmodel) {
		this.papmodel = papmodel;
	}

	public int getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(int paperNo) {
		this.paperNo = paperNo;
	}

	public List<String> getPeriodicalTypeList() {
		return periodicalTypeList;
	}

	public void setPeriodicalTypeList(List<String> periodicalTypeList) {
		this.periodicalTypeList = periodicalTypeList;
	}

	
	

	

	

}
