package cn.edu.nwsuaf.Action;


import java.util.List;

import cn.edu.nwsuaf.Model.TeachingcostModel;

import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.TeachingcostService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.TeachingcosttypeService;

import cn.edu.nwsuaf.bean.Department;

import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Teachingcost;
import cn.edu.nwsuaf.bean.Teachingcosttype;

import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class TeachingcostAction extends ActionSupport {

	/**
	 * 
	 */
	//教学经费Action
	private static final long serialVersionUID = 1L;

	// Service
	private TeachingcostService teachingcostService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private TeachingcosttypeService teachingcosttypeService;
	
	// 传到前台下拉列表从数据库中读取显示

	private List<Teachingcost> teaList;
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<Teachingcosttype> ttList;// 类型
    private List<String> yearList;//年份
    
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;

	private Integer costNumber;
	private String teachCostTypeNo;
	private Integer stuNumber;
	private Float cost;
	private String useness;
	private String majorId;
	private String departmentId;

	private Teachingcost teachingcost;
	private TeachingcostModel teamodel = new TeachingcostModel();
	private int rol;
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
			if (costNumber == 0) {
				teachingcost = null;
			} else {

				teachingcost = teachingcostService.findById(Teachingcost.class,
						costNumber);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiTeachingcost() {
		try {

			List<Teachingcost> s;
			s = teachingcostService
					.findByHQL("from Teachingcost as tea where tea.costNumber='"
							+ teachingcost.getCostNumber() + "'");
			if (s.size() == 0) {
				teachingcostService.save(teachingcost);
			} else {
				teachingcostService.update(teachingcost);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertTeachingcost() {
		try {
			teachingcostService.save(teachingcost);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteTeachingcost() {
		try {
			Teachingcost fs = teachingcostService.findById(Teachingcost.class,
					costNumber);
			teachingcostService.delete(fs);
		} catch (ServiceException e) {
			
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
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		teamodel=null;
		try {
			page = 1;
			rows = 10;
			teaList = teachingcostService.findallCostList(page, rows, mno, dno);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			ttList = teachingcostService.findTypeList();
			yearList = teachingcostService.findYearList();
			totalRows = teachingcostService.count(mno, dno);
			
			
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

	// 多条件查询信息
	public String findTeachingcost() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		try {
			System.out.println("当前页数是==" + page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			
			if(!mno.equals("000000")){
				teamodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				teamodel.setDepartmentId(dno);
			}if(teamodel==null){
				teamodel=new TeachingcostModel();
				teamodel.setDepartmentId(null);
				teamodel.setMajorId(null);
				teamodel.setYear(null);
				teamodel.setId(null);
				teamodel.getTeachingcosttype().setTeachCostTypeNo("");
			}

			
			
			teaList = teachingcostService.findTeachingcostList(teamodel, page,
					rows);
			totalRows = teachingcostService.countFindTeachingcost(teamodel);
			ttList = teachingcosttypeService.findAll(Teachingcosttype.class);
			yearList = teachingcostService.findYearList();
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

	// get&&set
	public TeachingcostService getTeachingcostService() {
		return teachingcostService;
	}

	public void setTeachingcostService(TeachingcostService teachingcostService) {
		this.teachingcostService = teachingcostService;
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

	public List<Teachingcost> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<Teachingcost> teaList) {
		this.teaList = teaList;
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

	public Integer getCostNumber() {
		return costNumber;
	}

	public void setCostNumber(Integer costNumber) {
		this.costNumber = costNumber;
	}

	public Integer getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(Integer stuNumber) {
		this.stuNumber = stuNumber;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getUseness() {
		return useness;
	}

	public void setUseness(String useness) {
		this.useness = useness;
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

	public Teachingcost getTeachingcost() {
		return teachingcost;
	}

	public void setTeachingcost(Teachingcost teachingcost) {
		this.teachingcost = teachingcost;
	}

	public TeachingcostModel getTeamodel() {
		return teamodel;
	}

	public void setTeamodel(TeachingcostModel teamodel) {
		this.teamodel = teamodel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Teachingcosttype> getTtList() {
		return ttList;
	}

	public void setTtList(List<Teachingcosttype> ttList) {
		this.ttList = ttList;
	}

	public String getTeachCostTypeNo() {
		return teachCostTypeNo;
	}

	public void setTeachCostTypeNo(String teachCostTypeNo) {
		this.teachCostTypeNo = teachCostTypeNo;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setTeachingcosttypeService(TeachingcosttypeService teachingcosttypeService) {
		this.teachingcosttypeService = teachingcosttypeService;
	}

	public TeachingcosttypeService getTeachingcosttypeService() {
		return teachingcosttypeService;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

}
