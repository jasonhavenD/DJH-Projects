package cn.edu.nwsuaf.Action;

import java.util.List;
import cn.edu.nwsuaf.Model.EffectqualityeducationModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.EffectqualityeducationService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Effectofqualityeducation;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;


public class EffectqualityeducationAction extends ActionSupport {

	//人文素质教育
	private static final long serialVersionUID = 1L;

	// Service
	private EffectqualityeducationService effectqualityeducationService;

	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Effectofqualityeducation> effectList;// 专利
	private List<Effectofqualityeducation> efList;// 

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private String majorId;
	private String departmentId;
	private Effectofqualityeducation effectofqualityeducation;
	private EffectqualityeducationModel eqemodel = new EffectqualityeducationModel();
	private int effNumber;
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

		
			if (effNumber == 0) {
				 effectofqualityeducation = null;
			} else {

				 effectofqualityeducation = effectqualityeducationService.findById(Effectofqualityeducation.class, effNumber);
			}
		
		return "success";
	}

	// 修改
	public String modifiEqe() {
		try {

			List<Effectofqualityeducation> s;
			s = effectqualityeducationService
					.findByHQL("from Effectofqualityeducation as ef where ef.effNumber="
							+ effectofqualityeducation.getEffNumber() );
			if (s.size() == 0) {
				effectqualityeducationService.save(effectofqualityeducation);
			} else {

				effectqualityeducationService.update(effectofqualityeducation);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertStupatent() {
		try {
			effectqualityeducationService.save(effectofqualityeducation);
		} catch (Exception e) {
	
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteEqe() {
		try {
			Effectofqualityeducation effectofqualityeducations = effectqualityeducationService.findById(Effectofqualityeducation.class,
					effNumber);
			effectqualityeducationService.delete(effectofqualityeducations);
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
		eqemodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = effectqualityeducationService.findYearList();
			efList = effectqualityeducationService.findallEffectofqualityeducationList(page, rows,mno,dno);
			totalRows=effectqualityeducationService.count(mno,dno);
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
	public String findEqe() {

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
			yearList = effectqualityeducationService.findYearList();
			if(!mno.equals("000000")){
				eqemodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				eqemodel.setDepartmentId(dno);
			}if(eqemodel==null){
				eqemodel=new EffectqualityeducationModel();
				eqemodel.setDepartmentId(null);
				eqemodel.setMajorId(null);
				eqemodel.setYear("");
			}

			efList = effectqualityeducationService.findEqeList(eqemodel, page,
					rows);
			totalRows = effectqualityeducationService.countFindEqe(eqemodel);
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

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public EffectqualityeducationService getEffectqualityeducationService() {
		return effectqualityeducationService;
	}

	public void setEffectqualityeducationService(
			EffectqualityeducationService effectqualityeducationService) {
		this.effectqualityeducationService = effectqualityeducationService;
	}

	public List<Effectofqualityeducation> getEffectList() {
		return effectList;
	}

	public void setEffectList(List<Effectofqualityeducation> effectList) {
		this.effectList = effectList;
	}

	public List<Effectofqualityeducation> getEfList() {
		return efList;
	}

	public void setEfList(List<Effectofqualityeducation> efList) {
		this.efList = efList;
	}

	public Effectofqualityeducation getEffectofqualityeducation() {
		return effectofqualityeducation;
	}

	public void setEffectofqualityeducation(
			Effectofqualityeducation effectofqualityeducation) {
		this.effectofqualityeducation = effectofqualityeducation;
	}

	public EffectqualityeducationModel getEqemodel() {
		return eqemodel;
	}

	public void setEqemodel(EffectqualityeducationModel eqemodel) {
		this.eqemodel = eqemodel;
	}

	public int getEffNumber() {
		return effNumber;
	}

	public void setEffNumber(int effNumber) {
		this.effNumber = effNumber;
	}

	

}
