package cn.edu.nwsuaf.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.PreScientModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.PresidedScientificService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Presidedoverscientificresearchproject;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class PreScientAction extends ActionSupport {

	// 主持科研项目

	private static final long serialVersionUID = 1L;

	// Service
	private PresidedScientificService presService;
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// List
	private List<Presidedoverscientificresearchproject> presList;
	private List<Teacher> teacherList;
	private List<String> yearList;
	private List<Major> majorList;
	private List<Department> departmentList;
	private List<String> projecTypeList;
	private List<String> projecJibieList;

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String Pno;
	// private String Tno;
	// private String year;
	// private String majorId;
	// private String departmetnId;
	// private String projecType;
	// private String projecJibie;
	private int rol;
	private Presidedoverscientificresearchproject pres;
	private PreScientModel pmodel = new PreScientModel();

	public String list() {

		return "list";
	}

	// 初始化修改页面
	public String initEdit() {

		try {
			if (Pno == "0") {
				pres = null;
			} else {
				System.out.println();
				pres = presService.findById(
						Presidedoverscientificresearchproject.class, Pno);
			}
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// 修改
	public String modifiPres() {

		try {
			// System.out.println(Pno);
			// List<Presidedoverscientificresearchproject> s = null;
			if (Pno.equals("0")) {
				// System.out.println("pres:"+pres.getProjectNo()+pres.getProjectName());
				presService.save(pres);
			} else {
				presService.update(pres);
			}
		} catch (Exception e) {

			return "error";
		}

		return "success";
	}

	// 添加
	public String insertPres() {
		try {
			presService.save(pres);
		} catch (Exception e) {

			return "error";
		}
		return "success";
	}

	// 删除
	public String deletePres() {
		try {
			pres = presService.findById(
					Presidedoverscientificresearchproject.class, Pno);
			presService.delete(pres);
		} catch (ServiceException e) {

			return "error";
		}
		return "success";
	}

	// 全部清空
	public String clearPres() {
		try {
			List<Presidedoverscientificresearchproject> presnewlist = new ArrayList<Presidedoverscientificresearchproject>();
			presnewlist = presService
					.findAll(Presidedoverscientificresearchproject.class);
			for (Presidedoverscientificresearchproject pres : presnewlist) {
				presService.delete(pres);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "success";
	}

	// 初始化信息，用于页面显示数据库中信息
	public String initSearch() {
		try {
			 pmodel=new PreScientModel();
			 pmodel.setId("");
			 pmodel.setName("");
			 pmodel.setProjecJibie("");
			 pmodel.setProjecType("");
			 pmodel.setTname("");
			 pmodel.setTno("");
			 pmodel.setYear("");
			
			page = 1;
			rows = 10;
			String mno = "";
			String dno = "";

			try {
				mno = QueryUtil.getUserMno().getMajor().getInMno();
				dno = QueryUtil.getUserMno().getDepartment().getDno();
			} catch (Exception e) {
				e.printStackTrace();
				return "errorstring";
			}

			// 获取所有项目
			// 此处应该根据当前登陆专家来确定获取哪些专业
			// 这里是错误的
			// presList = presService.getAllPreScientListByPage(page, rows);

			presList = presService.getAllPreScient(page, rows, mno, dno);
			teacherList = presService.findAllInSort();
			yearList = presService.findYear();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			projecTypeList = presService.findProType();
			projecJibieList = presService.findProjecJibie();

			// 同上 错误
			// totalRows =
			// presService.findAll(Presidedoverscientificresearchproject.class).size();

			totalRows = presService.countFindPres(pmodel,mno,dno);

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

	// 多条件查询信息,同样没有考虑专业负责人的权限
	// public String findPres() {
	// try {
	// teacherList = presService.findAllInSort();
	// yearList = presService.findYear();
	// departmentList = departmentService.findAll(Department.class);
	// majorList = majorService.findAll(Major.class);
	// projecTypeList = presService.findProType();
	// projecJibieList = presService.findProjecJibie();
	// if(pmodel==null){
	// pmodel=new PreScientModel();
	// pmodel.setId("");
	// pmodel.setName("");
	// pmodel.setProjecJibie("");
	// pmodel.setProjecType("");
	// pmodel.setTname("");
	// pmodel.setTno("");
	// pmodel.setYear("");
	// }
	// else
	// if(pmodel!=null&&pmodel.getName()!=null&&pmodel.getTname()!=null&&pmodel.getProjecJibie()!=null&&pmodel.getProjecType()!=null){
	// pmodel.setName(java.net.URLDecoder.decode(pmodel
	// .getName(), "UTF-8"));
	// pmodel.setTname(java.net.URLDecoder.decode(pmodel
	// .getTname(), "UTF-8"));
	// pmodel.setProjecType(java.net.URLDecoder.decode(pmodel
	// .getProjecType(), "UTF-8"));
	// pmodel.setProjecJibie(java.net.URLDecoder.decode(pmodel
	// .getProjecJibie(), "UTF-8"));
	// }
	// presList = presService.findPreScientList(pmodel, page, rows);
	//			
	// totalRows = presService.countFindPres(pmodel);
	// if (totalRows % rows == 0) {
	// totalPage = totalRows / rows;
	// } else {
	// totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
	// }
	// } catch (ServiceException e) {
	//			
	// return "error";
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return "success";
	// }

	public String findPres() {

		String mno = "";
		String dno = "";

		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			e.printStackTrace();
			return "errorstring";
		}

		try {
			teacherList = presService.findAllInSort();
			yearList = presService.findYear();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			projecTypeList = presService.findProType();
			projecJibieList = presService.findProjecJibie();
			if (pmodel == null) {
				pmodel = new PreScientModel();
				pmodel.setId("");
				pmodel.setName("");
				pmodel.setProjecJibie("");
				pmodel.setProjecType("");
				pmodel.setTname("");
				pmodel.setTno("");
				pmodel.setYear("");
			} else if (pmodel != null && pmodel.getName() != null
					&& pmodel.getTname() != null
					&& pmodel.getProjecJibie() != null
					&& pmodel.getProjecType() != null) {
				pmodel.setName(java.net.URLDecoder.decode(pmodel.getName(),
						"UTF-8"));
				pmodel.setTname(java.net.URLDecoder.decode(pmodel.getTname(),
						"UTF-8"));
				pmodel.setProjecType(java.net.URLDecoder.decode(pmodel
						.getProjecType(), "UTF-8"));
				pmodel.setProjecJibie(java.net.URLDecoder.decode(pmodel
						.getProjecJibie(), "UTF-8"));
			}
			presList = presService.findPreScientList(pmodel, page, rows, mno,
					dno);

			totalRows = presService.countFindPres(pmodel, mno, dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	/************** GETTERS & SETTERS **************/

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public PresidedScientificService getPresService() {
		return presService;
	}

	public void setPresService(PresidedScientificService presService) {
		this.presService = presService;
	}

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

	public List<Presidedoverscientificresearchproject> getPresList() {
		return presList;
	}

	public void setPresList(List<Presidedoverscientificresearchproject> presList) {
		this.presList = presList;
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

	public List<String> getProjecTypeList() {
		return projecTypeList;
	}

	public void setProjecTypeList(List<String> projecTypeList) {
		this.projecTypeList = projecTypeList;
	}

	public List<String> getProjecJibieList() {
		return projecJibieList;
	}

	public void setProjecJibieList(List<String> projecJibieList) {
		this.projecJibieList = projecJibieList;
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

	public Presidedoverscientificresearchproject getPres() {
		return pres;
	}

	public void setPres(Presidedoverscientificresearchproject pres) {
		this.pres = pres;
	}

	public PreScientModel getPmodel() {
		return pmodel;
	}

	public void setPmodel(PreScientModel pmodel) {
		this.pmodel = pmodel;
	}
}
