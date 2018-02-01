package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import cn.edu.nwsuaf.Model.PreRevolutModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.PresidedRevolutionService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Presidedoverrevolutionresearchproject;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class PreRevolutAction extends ActionSupport {

	// 主持教改项目
	private static final long serialVersionUID = 1L;

	// Service
	private PresidedRevolutionService prerService;
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// List
	private List<Presidedoverrevolutionresearchproject> prerList;
	private List<Teacher> teacherList;
	private List<String> yearList;
	private List<Major> majorList;
	private List<Department> departmentList;
	private List<String> rprojecTypeList;
	private List<String> rprojecJibieList;

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String Pno;
	private int rol;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	// private String Tno;
	// private String year;
	// private String majorId;
	// private String departmetnId;
	// private String projecType;
	// private String projecJibie;

	private Presidedoverrevolutionresearchproject prer;
	private PreRevolutModel pmodel = new PreRevolutModel();

	public String list() {

		return "list";
	}

	// 初始化修改页面
	public String initEdit() {

		try {
			if (Pno == "0") {
				prer = null;
			} else {
				System.out.println();
				prer = prerService.findById(
						Presidedoverrevolutionresearchproject.class, Pno);
			}
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiPrer() {

		try {
			// List<Presidedoverscientificresearchproject> s = null;
			if (Pno.equals("0")) {
				prerService.save(prer);
			} else {
				prerService.update(prer);
			}
		} catch (Exception e) {

			return "error";
		}

		return "success";
	}

	// 添加
	public String insertPrer() {
		try {
			prerService.save(prer);
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// 删除
	public String deletePrer() {
		try {
			prer = prerService.findById(
					Presidedoverrevolutionresearchproject.class, Pno);
			prerService.delete(prer);
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
        	e.printStackTrace();
        	return "errorstring";
        }
		
		try {
			pmodel = null;
			page = 1;
			rows = 10;
			prerList = prerService.getAllPreRevolutListByPage(page, rows, mno,
					dno);

			teacherList = prerService.findAllInSort();
			yearList = prerService.findYear();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			rprojecTypeList = prerService.findRProType();
			rprojecJibieList = prerService.findRProjecJibie();

			totalRows = prerService.getAllPreRevolut(mno,dno).size();
			
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {

			return "error";
		}
		return "success";

	}

	// 多条件查询信息
	public String findPrer() throws UnsupportedEncodingException {

		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	e.printStackTrace();
        	return "errorstring";
        }
		
		try {

			teacherList = prerService.findAllInSort();
			yearList = prerService.findYear();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			rprojecTypeList = prerService.findRProType();
			rprojecJibieList = prerService.findRProjecJibie();

			if (pmodel == null) {
				pmodel = new PreRevolutModel();
				pmodel.setId("");
				pmodel.setName("");
				pmodel.setProjecJibie("");
				pmodel.setProjecType("");
				pmodel.setTname("");
				pmodel.setTno("");
				pmodel.setYear("");
			} else if (pmodel != null && pmodel.getName() != null
					&& pmodel.getTname() != null
					&& pmodel.getProjecType() != null
					&& pmodel.getProjecJibie() != null) {
				System.out.println("教师姓名" + pmodel.getTname());
				pmodel.setName(java.net.URLDecoder.decode(pmodel.getName(),
						"UTF-8"));
				pmodel.setTname(java.net.URLDecoder.decode(pmodel.getTname(),
						"UTF-8"));

				pmodel.setProjecType(java.net.URLDecoder.decode(pmodel
						.getProjecType(), "UTF-8"));
				pmodel.setProjecJibie(java.net.URLDecoder.decode(pmodel
						.getProjecJibie(), "UTF-8"));
			}

			prerList = prerService.findPreRevolutList(pmodel, page, rows,mno,dno);

			totalRows = prerService.countFindPrer(pmodel,mno,dno);
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

	/************** GETTERS & SETTERS **************/

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
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

	public String getPno() {
		return Pno;
	}

	public void setPno(String pno) {
		Pno = pno;
	}

	public PresidedRevolutionService getPrerService() {
		return prerService;
	}

	public void setPrerService(PresidedRevolutionService prerService) {
		this.prerService = prerService;
	}

	public List<Presidedoverrevolutionresearchproject> getPrerList() {
		return prerList;
	}

	public void setPrerList(List<Presidedoverrevolutionresearchproject> prerList) {
		this.prerList = prerList;
	}

	public List<String> getRprojecTypeList() {
		return rprojecTypeList;
	}

	public void setRprojecTypeList(List<String> rprojecTypeList) {
		this.rprojecTypeList = rprojecTypeList;
	}

	public List<String> getRprojecJibieList() {
		return rprojecJibieList;
	}

	public void setRprojecJibieList(List<String> rprojecJibieList) {
		this.rprojecJibieList = rprojecJibieList;
	}

	public Presidedoverrevolutionresearchproject getPrer() {
		return prer;
	}

	public void setPrer(Presidedoverrevolutionresearchproject prer) {
		this.prer = prer;
	}

	public void setPmodel(PreRevolutModel pmodel) {
		this.pmodel = pmodel;
	}

	public PreRevolutModel getPmodel() {
		return pmodel;
	}

}
