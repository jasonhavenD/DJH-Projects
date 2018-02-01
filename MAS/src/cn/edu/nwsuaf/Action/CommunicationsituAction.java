package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.Model.CommunicationsituModel;
import cn.edu.nwsuaf.Service.Impl.CommunicationsituService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.bean.Communicationsitu;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class CommunicationsituAction extends ActionSupport {

	/**
	 * 
	 */
	// 学生国内外交流
	private static final long serialVersionUID = 1L;

	// Service
	private CommunicationsituService communicationsituService;
	private DepartmentService departmentService;
	private MajorService majorService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Communicationsitu> cccList;
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份

	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;

	private Integer comNumber;
	private Integer projCounts;
	private Integer stuCount;
	private String note;
	private String majorId;
	private String departmentId;

	private Communicationsitu communicationsitu;
	private Communicationsitu addcommunicationsitu;
	private CommunicationsituModel commodel = new CommunicationsituModel();
	private int rol;
	
	private int flag=0;
	private String errstring;

	// 初始化修改页面
	public String initEdit() {
		System.out.println("flag"+flag);
		if (comNumber == 0) {			
			communicationsitu = null;			
		} else {
			communicationsitu = communicationsituService.findById(
					Communicationsitu.class, comNumber);
		}
		addcommunicationsitu=communicationsitu;
		return "success";
	}

	// 修改
	public String modifiCommunicationsitu() {
		try {
			System.out.println("flag"+flag);
			List<Communicationsitu> s;
			s = communicationsituService
					.findByHQL("from Communicationsitu as co where co.comNumber='"
							+ communicationsitu.getComNumber() + "'");
			
			if (addcommunicationsitu==null||!addcommunicationsitu.getMajor().getMno().equals(communicationsitu.getMajor().getMno())
					|| !addcommunicationsitu.getYear().equals(communicationsitu.getYear())) {							
				System.out.println("dao");
				List<Communicationsitu> adds=new ArrayList<Communicationsitu>();
				adds = communicationsituService.findAll(Communicationsitu.class);
				for (Communicationsitu c : adds) {
					System.out.println("daozhe");
					if ((c.getMajor().getMno().equals(communicationsitu.getMajor().getMno()))
							&& (c.getYear().equals(communicationsitu.getYear()))) {
						flag=1;
						System.out.println("daozheyibula");
						return "adderror";
					}
				}
			}
			if (s.size() == 0) {
				communicationsituService.save(communicationsitu);
			} else {

				communicationsituService.update(communicationsitu);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteCommunicationsitu() {
		try {
			Communicationsitu fs = communicationsituService.findById(
					Communicationsitu.class, comNumber);
			communicationsituService.delete(fs);
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
		commodel = null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = communicationsituService.findYearList();
			cccList = communicationsituService.findallCommunicationsituList(
					page, rows, mno, dno);
			System.out.println("aaaaaaaaaaaa" + cccList.size());
			totalRows = communicationsituService.count(mno, dno);
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

	// 多条件查询信息
	public String findCommunicationsitu() {
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
			if(commodel==null){
				commodel = new CommunicationsituModel();
				commodel.setYear("");
				if(!mno.equals("000000")){
					commodel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					commodel.setDepartmentId(dno);
				}
			}if(commodel==null){
				commodel=new CommunicationsituModel();
				commodel.setDepartmentId(null);
				commodel.setMajorId(null);
				commodel.setYear("");
			}
			System.out.println("当前页数是==" + page);
			if (!mno.equals("000000")) {
				commodel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				commodel.setDepartmentId(dno);
			}

			cccList = communicationsituService.findCommunicationsituList(
					commodel, page, rows);
			System.out.println(cccList.size());
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = communicationsituService.findYearList();
			totalRows = communicationsituService
					.countFindCommunicationsitu(commodel);
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

	// getter && setter
	public CommunicationsituService getCommunicationsituService() {
		return communicationsituService;
	}

	public void setCommunicationsituService(
			CommunicationsituService communicationsituService) {
		this.communicationsituService = communicationsituService;
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

	public List<Communicationsitu> getCccList() {
		return cccList;
	}

	public void setCccList(List<Communicationsitu> cccList) {
		this.cccList = cccList;
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

	public Integer getComNumber() {
		return comNumber;
	}

	public void setComNumber(Integer comNumber) {
		this.comNumber = comNumber;
	}

	public Integer getProjCounts() {
		return projCounts;
	}

	public void setProjCounts(Integer projCounts) {
		this.projCounts = projCounts;
	}

	public Integer getStuCount() {
		return stuCount;
	}

	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Communicationsitu getCommunicationsitu() {
		return communicationsitu;
	}

	public void setCommunicationsitu(Communicationsitu communicationsitu) {
		this.communicationsitu = communicationsitu;
	}

	public CommunicationsituModel getCommodel() {
		return commodel;
	}

	public void setCommodel(CommunicationsituModel commodel) {
		this.commodel = commodel;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Communicationsitu getAddcommunicationsitu() {
		return addcommunicationsitu;
	}

	public void setAddcommunicationsitu(Communicationsitu addcommunicationsitu) {
		this.addcommunicationsitu = addcommunicationsitu;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
	
}
