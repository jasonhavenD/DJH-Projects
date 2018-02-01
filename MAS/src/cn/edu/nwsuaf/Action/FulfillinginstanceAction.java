package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Model.FulfillinginstanceModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.FulfillinginstanceService;
import cn.edu.nwsuaf.Service.Impl.MajorService;

import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Fulfillinginstance;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class FulfillinginstanceAction extends ActionSupport{

	//实习实践毕业设计
	private static final long serialVersionUID = 1L;
	
	// Service
	private FulfillinginstanceService fulfillinginstanceService; 
	private DepartmentService departmentService;
	private MajorService majorService;
    
	// 传到前台下拉列表从数据库中读取显示
	
	private List<Fulfillinginstance> fffList;// 

	private List<Department> departmentList;// 学院

	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> ftList;
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	
	private Integer stuNumber1;
	private Integer stuNumber2;
	private Integer endNumber;
	private Float openRate;
	private Float finishRate;
	


	private String majorId;
	private String departmentId;
	
	
	private Fulfillinginstance fulfillinginstance ;
	private FulfillinginstanceModel fulmodel = new FulfillinginstanceModel();
	
	
	private int fulNumber;
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
			if (fulNumber == 0) {
				fulfillinginstance = null;
			} else {
				fulfillinginstance=fulfillinginstanceService.findById(Fulfillinginstance.class, fulNumber);			
			}
		
		return "success";
	}
	
	// 修改
	public String modifiFulfillinginstance() {
		try {

			List<Fulfillinginstance> s;
			s = fulfillinginstanceService
			.findByHQL("from Fulfillinginstance as ful where ful.fulNumber='"
					+ fulfillinginstance.getFulNumber() + "'");
			if (s.size() == 0) {
				fulfillinginstanceService.save(fulfillinginstance);
			} else {

				fulfillinginstanceService.update(fulfillinginstance);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertFulfillinginstance() {
		try {
			fulfillinginstanceService.save(fulfillinginstance);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteFulfillinginstance() {
		try {
			Fulfillinginstance fs = fulfillinginstanceService.findById(Fulfillinginstance.class,
					fulNumber);
			fulfillinginstanceService.delete(fs);
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
		fulmodel=null;
		try {
			page = 1;
			rows = 10;
			ftList=fulfillinginstanceService.findFTypeList();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = fulfillinginstanceService.findYearList();
			fffList = fulfillinginstanceService.findallfulList(page, rows,mno,dno);			
			totalRows = fulfillinginstanceService.count(mno, dno);
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
	//多条件查询信息
	public String findFulfillinginstance() throws UnsupportedEncodingException {
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
			yearList = fulfillinginstanceService.findYearList();
			if(!mno.equals("000000")){
				fulmodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				fulmodel.setDepartmentId(dno);
			}
			if (fulmodel == null) {
				fulmodel = new FulfillinginstanceModel();	
				fulmodel.setYear("");
				fulmodel.setFulType(null);
				fulmodel.setDepartmentId(null);
				fulmodel.setMajorId(null);
			} else if(fulmodel.getFulType()!=null){
				fulmodel.setFulType(java.net.URLDecoder.decode(fulmodel
						.getFulType(), "UTF-8"));
			}
			fffList = fulfillinginstanceService.findFulfillinginstancetList(fulmodel, page,
					rows);
			
			ftList=fulfillinginstanceService.findFTypeList();
			System.out.println(fffList.size());
			System.out.println("fulmodelid+  "+fulmodel.getId());
			totalRows = fulfillinginstanceService.countFindFulfillinginstance(fulmodel);
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
	public FulfillinginstanceService getFulfillinginstanceService() {
		return fulfillinginstanceService;
	}


	public void setFulfillinginstanceService(
			FulfillinginstanceService fulfillinginstanceService) {
		this.fulfillinginstanceService = fulfillinginstanceService;
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

	
    
	

	

	public List<Fulfillinginstance> getFffList() {
		return fffList;
	}

	public void setFffList(List<Fulfillinginstance> fffList) {
		this.fffList = fffList;
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


	

	public Fulfillinginstance getFulfillinginstance() {
		return fulfillinginstance;
	}

	public void setFulfillinginstance(Fulfillinginstance fulfillinginstance) {
		this.fulfillinginstance = fulfillinginstance;
	}

	

	public FulfillinginstanceModel getFulmodel() {
		return fulmodel;
	}

	public void setFulmodel(FulfillinginstanceModel fulmodel) {
		this.fulmodel = fulmodel;
	}

	public int getFulNumber() {
		return fulNumber;
	}


	public void setFulNumber(int fulNumber) {
		this.fulNumber = fulNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	public Integer getStuNumber1() {
		return stuNumber1;
	}

	public void setStuNumber1(Integer stuNumber1) {
		this.stuNumber1 = stuNumber1;
	}

	public Integer getStuNumber2() {
		return stuNumber2;
	}

	public void setStuNumber2(Integer stuNumber2) {
		this.stuNumber2 = stuNumber2;
	}

	public Integer getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(Integer endNumber) {
		this.endNumber = endNumber;
	}

	public Float getOpenRate() {
		return openRate;
	}

	public void setOpenRate(Float openRate) {
		this.openRate = openRate;
	}

	public Float getFinishRate() {
		return finishRate;
	}

	public void setFinishRate(Float finishRate) {
		this.finishRate = finishRate;
	}

	public List<String> getFtList() {
		return ftList;
	}

	public void setFtList(List<String> ftList) {
		this.ftList = ftList;
	}

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	
}
