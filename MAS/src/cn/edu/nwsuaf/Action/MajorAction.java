package cn.edu.nwsuaf.Action;

import java.util.Iterator;
import java.util.List;
import cn.edu.nwsuaf.Model.MajorModel;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MajorTypeService;
import cn.edu.nwsuaf.Service.Impl.MajorCategoryService;
import cn.edu.nwsuaf.Service.Impl.DisciplineTypeService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;

import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Disciplinetype;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorcategory;
import cn.edu.nwsuaf.bean.Majortype;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class MajorAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private MajorTypeService majortypeservice;
	private MajorCategoryService majorcategoryservice;
	private DisciplineTypeService disciplinetypeservice;
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private int number;
	private MajorModel majormodel = new MajorModel();
	public Major major;
	public String mno;
	public String majorleadername;
	private List<Majorcategory> majorcategoryList;// 学院
	private List<Majortype> majortypeList;
	private List<Disciplinetype> disciplinetypeList;
	
	
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<Major> maList;// 专业
	private List<String> yearList;// 年份
	private int rol;
	
	//错误提示
	private String errstring;
	
	public String list() {
		majorList = majorService.getAllMajorList();
		Iterator<Major> iterator = majorList.iterator();
		while (iterator.hasNext()) {
			System.out.println("专业：" + iterator.next().toString());
		}
		return "list";
	}
	
	public String initInfo(){
		
		try {
			majorleadername=null;
			majortypeList=majortypeservice.findAll(Majortype.class);
			majorcategoryList=majorcategoryservice.findAll(Majorcategory.class);
			disciplinetypeList=disciplinetypeservice.findAll(Disciplinetype.class);
			major = majorService.findById(Major.class, mno);
			int i=teacherService.findByHQL("from Teacher as t where t.tno='"
					+ major.getTeachernNo() + "'").size();
			if(i==1)
			{majorleadername=teacherService.findByHQL("from Teacher as t where t.tno='"
					+ major.getTeachernNo() + "'").get(0).getTname();}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
		
	}
	
	// 初始化修改页面
	public String initEdit() {

		try {
			if (mno==null) {
				major = null;
			} else {
				majorleadername=null;
				major = majorService.findById(Major.class, mno);
				int i=teacherService.findByHQL("from Teacher as t where t.tno='"
						+ major.getTeachernNo() + "'").size();
				if(i==1)
				{majorleadername=teacherService.findByHQL("from Teacher as t where t.tno='"
						+ major.getTeachernNo() + "'").get(0).getTname();}
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	public String initAdd() {	
						
				if (number==0) {
					System.out.println("添加");
					major = null;
				} 	
											
		return "success";
	}
	
	// 修改
	public String modifiMajor() {
		try {
			
			List<Major> s;
			s = majorService
					.findByHQL(" from Major as m where m.mno='"
							+ major.getMno() + "'");
			System.out.println("s.size="+s.size());
			if (s.size() == 0) {
				majorService.save(major);
			} else {

				majorService.update(major);
			}
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertMajor() {
		try {
			majorService.save(major);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteMajor() {
		try {
			Major majors = majorService.findById(Major.class,
					mno);
			majorService.delete(majors);
		} catch (ServiceException e) {
			errstring="您所要删除的专业在其他表中仍有使用，故无法删除";
			return "errorstring";
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
		majormodel=null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = majorService.findYearList();
			maList = majorService.getAllMajorListByPage(page, rows,mno,dno);
			majortypeList=majortypeservice.findAll(Majortype.class);
			majorcategoryList=majorcategoryservice.findAll(Majorcategory.class);
			disciplinetypeList=disciplinetypeservice.findAll(Disciplinetype.class);
			totalRows=majorService.count(mno,dno);
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
	public String findMajor() {
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
			yearList = majorService.findYearList();
			majortypeList=majortypeservice.findAll(Majortype.class);
			majorcategoryList=majorcategoryservice.findAll(Majorcategory.class);
			disciplinetypeList=disciplinetypeservice.findAll(Disciplinetype.class);
			if(majormodel==null){
				majormodel=new MajorModel();
				majormodel.setMajorId("");
				majormodel.setYear(null);
				majormodel.setMno(null);
				majormodel.setDisciplinetype(null);
				majormodel.setMajortype(null);
				majormodel.setMajorcategory(null);
				majormodel.setDepartmentId(null);
				majormodel.setEnrollmentState(null);
			}else{
				majormodel.setEnrollmentState(java.net.URLDecoder.decode(majormodel.getEnrollmentState(), "UTF-8"));
			}
			if(!mno.equals("000000")){
				majormodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				majormodel.setDepartmentId(dno);
			}

			maList = majorService.findMajorList(majormodel, page,
					rows);
			totalRows = majorService.countFindMajor(majormodel);
			System.out.println("totalRows"+totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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

	

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public MajorModel getMajormodel() {
		return majormodel;
	}

	public void setMajormodel(MajorModel majormodel) {
		this.majormodel = majormodel;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	


	public MajorTypeService getMajortypeservice() {
		return majortypeservice;
	}

	public void setMajortypeservice(MajorTypeService majortypeservice) {
		this.majortypeservice = majortypeservice;
	}

	public MajorCategoryService getMajorcategoryservice() {
		return majorcategoryservice;
	}

	public void setMajorcategoryservice(MajorCategoryService majorcategoryservice) {
		this.majorcategoryservice = majorcategoryservice;
	}

	public DisciplineTypeService getDisciplinetypeservice() {
		return disciplinetypeservice;
	}

	public void setDisciplinetypeservice(DisciplineTypeService disciplinetypeservice) {
		this.disciplinetypeservice = disciplinetypeservice;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public List<Majorcategory> getMajorcategoryList() {
		return majorcategoryList;
	}

	public void setMajorcategoryList(List<Majorcategory> majorcategoryList) {
		this.majorcategoryList = majorcategoryList;
	}

	public List<Majortype> getMajortypeList() {
		return majortypeList;
	}

	public void setMajortypeList(List<Majortype> majortypeList) {
		this.majortypeList = majortypeList;
	}

	public List<Disciplinetype> getDisciplinetypeList() {
		return disciplinetypeList;
	}

	public void setDisciplinetypeList(List<Disciplinetype> disciplinetypeList) {
		this.disciplinetypeList = disciplinetypeList;
	}

	public List<Major> getMaList() {
		return maList;
	}

	public void setMaList(List<Major> maList) {
		this.maList = maList;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getMajorleadername() {
		return majorleadername;
	}

	public void setMajorleadername(String majorleadername) {
		this.majorleadername = majorleadername;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}	
	
}
