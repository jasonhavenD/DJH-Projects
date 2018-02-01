package cn.edu.nwsuaf.Action;

import java.util.List;

import cn.edu.nwsuaf.Model.AddmissionsModel;
import cn.edu.nwsuaf.Service.Impl.AddmissionsService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.bean.Addmissions;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class AddmissionsAction extends ActionSupport{
	
	//招生情况
	private static final long serialVersionUID = 1L;

	// Service
	private AddmissionsService admService;//就业情况
	private DepartmentService departmentService;// 学院
	private MajorService majorService;// 专业
	
	// 传到前台下拉列表从数据库中读取显示
	private List<Addmissions> admList;// 就业情况	
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
	private Addmissions adm;
	private AddmissionsModel admmodel=new AddmissionsModel();		
	private int addmNumber;
	private int rol;
	private String errstring;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	//初始化修改or添加页面
	public String initEdit() throws ServiceException{
		
		if (addmNumber == 0) {
			adm=null;
		} else {
			adm = admService.findById(Addmissions.class, addmNumber);
		}	
		return "success";
	}
	
	//修改or添加
	public String modifiAddmissions(){
		try {
			List<Addmissions> s;
			s=admService.findByHQL("from Addmissions as ad where ad.addmNumber="+adm.getAddmNumber());
			if(s.size()==0){
				adm.setMajor(majorService.findMajorById(adm.getMajor().getMno()));
				admService.save(adm);
			}else{
				adm.setMajor(majorService.findMajorById(adm.getMajor().getMno()));
				admService.update(adm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	//删除
	public String deleteAddmissions(){
		try {
			Addmissions deladm=admService.findById(Addmissions.class, addmNumber);
			admService.delete(deladm);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		admmodel=null;
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
			
			yearList = admService.findYearList();		
			admList = admService.findallAddmissionsList(page,rows,mno,dno);	
			totalRows =  admService.count(mno, dno);
			System.out.println("init"+totalRows);	
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}
	//查找
	public String find() {
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
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = admService.findYearList();
			if(!mno.equals("000000")){
				admmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				admmodel.setDepartmentId(dno);
			}
			if(admmodel==null){
				admmodel=new AddmissionsModel();
				admmodel.setYear("");
				admmodel.setBigaddmCount(null);
				admmodel.setBigexpectCount(null);
				admmodel.setLittleaddmCount(null);
				admmodel.setLittleentranceEverage(null);
				admmodel.setBigentranceEverage(null);
				admmodel.setLittleexpectCount(null);
				admmodel.setDepartmentId(null);
				admmodel.setMajorId(null);
			}
			admList = admService.findAddmissionsList(admmodel, page, rows);
			totalRows = admService.countFindAddmissions(admmodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println("page"+totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public AddmissionsService getAdmService() {
		return admService;
	}

	public void setAdmService(AddmissionsService admService) {
		this.admService = admService;
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

	public List<Addmissions> getAdmList() {
		return admList;
	}

	public void setAdmList(List<Addmissions> admList) {
		this.admList = admList;
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

	public Addmissions getAdm() {
		return adm;
	}

	public void setAdm(Addmissions adm) {
		this.adm = adm;
	}

	public AddmissionsModel getAdmmodel() {
		return admmodel;
	}

	public void setAdmmodel(AddmissionsModel admmodel) {
		this.admmodel = admmodel;
	}

	public int getAddmNumber() {
		return addmNumber;
	}

	public void setAddmNumber(int addmNumber) {
		this.addmNumber = addmNumber;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

}
