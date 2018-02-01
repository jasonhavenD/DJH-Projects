package cn.edu.nwsuaf.Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Service.Impl.AcademicdegreeService;
import cn.edu.nwsuaf.Service.Impl.DegreeService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.JobTypeService;
import cn.edu.nwsuaf.Service.Impl.LearningEdgeService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.ProfessionalTitleService;
import cn.edu.nwsuaf.Service.Impl.SubjectCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.Service.Impl.TeachersCategoryService;
import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherscategory;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

public class TeacherAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Service
	private TeacherService teacherService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private DegreeService degreeService;
	private ProfessionalTitleService professionalTitleServoce;
	private TeachersCategoryService teacherCategoryService;
	private JobTypeService jobTypeService;
	private LearningEdgeService learningEdgeService;
	private SubjectCategoryService subjectCategoryService;
	private AcademicdegreeService academicDegreeService;

	// 传到前台下拉列表从数据库中读取显示
	private List<Teacher> teacList;// 教师

	private List<Degree> degreeList;// 学历
	private List<Department> departmentList;// 学院
	private List<Professionaltitle> professionalTitleList;// 职称
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<Teacherscategory> teachersCategoryList;// 师资类别
	private List<Jobtype> jobTypeList;// 岗位类型
	private List<Learningedge> learningEdgelist;// 学缘
	private List<Subjectcategory> subjectCategoryList;// 学科类别
	private List<Academicdegree> academicdegreeList;// 学位

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String tno;// 教师编号
	private String teacherName;
	private String majorId;
	private String departmentId;

	private Teacher teacher;
	private TeacherModel teachermodel = new TeacherModel();
	private int rol;
	private String errstring;
	
	// 初始化修改页面
	public String initEdit() {

		try {
			System.out.println("tttttttttttttt:" + tno);
			if (tno.equals("0")){
				teacher = null;
			} else {				
				teacher = teacherService.findById(Teacher.class, tno);
				majorList=majorService.findByHQL("from Major as m where m.department.dno='"+teacher.getMajor().getDepartment().getDno()+"'");
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 初始化查看页面
	public String initScan() {
		
		teacher = teacherService.findById(Teacher.class, tno);
		return "success";
	}

	// 修改
	public String modifiTeacher() {
		try {
			//System.out.print("修改教师信息"+teacher.toString());
			teacherService.update(teacher);
		} catch (ServiceException e) {
			
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertTeacher() {
		try {
			teacherService.save(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteTeacher() {
		try {
			Teacher fs = teacherService.findById(Teacher.class, tno);
			teacherService.delete(fs);
		} catch (ServiceException e) {
			
			return "error";
		}
		return "success";
	}

	// 初始化信息，用于页面显示数据库中信息
	@SuppressWarnings("unchecked")
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
		teachermodel=null;
		try {
			page = 1;
			rows = 10;
			degreeList = degreeService.findAll(Degree.class);
			professionalTitleList = professionalTitleServoce
					.findAll(Professionaltitle.class);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = teacherService.findYearList();
			teachersCategoryList = teacherCategoryService
					.findAll(Teacherscategory.class);
			jobTypeList = jobTypeService.findAll(Jobtype.class);
			learningEdgelist = learningEdgeService.findAll(Learningedge.class);
			subjectCategoryList = subjectCategoryService
					.findAll(Subjectcategory.class);
			academicdegreeList = academicDegreeService
					.findAll(Academicdegree.class);

			teacList = teacherService.findallTeacherList(page, rows, mno, dno);
			totalRows = teacherService.count(mno, dno);

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

	// 条件查询教师信息
	@SuppressWarnings("unchecked")
	public String findTeacher() {
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
			if(teachermodel==null){
				teachermodel=new TeacherModel();
				teachermodel.setTname("");
				teachermodel.setAcademicdegree(null);
				teachermodel.setProfessionaltitle(null);
			}else if(teachermodel.getTname()!=null){
				teachermodel.setTname(java.net.URLDecoder.decode(teachermodel.getTname(),"UTF-8"));
			}
			degreeList = degreeService.findAll(Degree.class);
			professionalTitleList = professionalTitleServoce
					.findAll(Professionaltitle.class);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = teacherService.findYearList();
			teachersCategoryList = teacherCategoryService
					.findAll(Teacherscategory.class);
			jobTypeList = jobTypeService.findAll(Jobtype.class);
			learningEdgelist = learningEdgeService.findAll(Learningedge.class);
			subjectCategoryList = subjectCategoryService
					.findAll(Subjectcategory.class);
			academicdegreeList = academicDegreeService
					.findAll(Academicdegree.class);

			if (!mno.equals("000000")) {
				teachermodel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				teachermodel.setDepartmentId(dno);
			}
			teacList = teacherService.findTeacherList(teachermodel, page, rows,
					mno, dno);
			totalRows = teacherService.countFindTeacher(teachermodel);
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

	public List<Teacher> getTeacList() {
		return teacList;
	}

	public void setTeacList(List<Teacher> teacList) {
		this.teacList = teacList;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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

	public DegreeService getDegreeService() {
		return degreeService;
	}

	public void setDegreeService(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	public ProfessionalTitleService getProfessionalTitleServoce() {
		return professionalTitleServoce;
	}

	public void setProfessionalTitleServoce(
			ProfessionalTitleService professionalTitleServoce) {
		this.professionalTitleServoce = professionalTitleServoce;
	}

	public TeachersCategoryService getTeacherCategoryService() {
		return teacherCategoryService;
	}

	public void setTeacherCategoryService(
			TeachersCategoryService teacherCategoryService) {
		this.teacherCategoryService = teacherCategoryService;
	}

	public JobTypeService getJobTypeService() {
		return jobTypeService;
	}

	public void setJobTypeService(JobTypeService jobTypeService) {
		this.jobTypeService = jobTypeService;
	}

	public LearningEdgeService getLearningEdgeService() {
		return learningEdgeService;
	}

	public void setLearningEdgeService(LearningEdgeService learningEdgeService) {
		this.learningEdgeService = learningEdgeService;
	}

	public SubjectCategoryService getSubjectCategoryService() {
		return subjectCategoryService;
	}

	public void setSubjectCategoryService(
			SubjectCategoryService subjectCategoryService) {
		this.subjectCategoryService = subjectCategoryService;
	}

	public List<Degree> getDegreeList() {
		return degreeList;
	}

	public void setDegreeList(List<Degree> degreeList) {
		this.degreeList = degreeList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Professionaltitle> getProfessionalTitleList() {
		return professionalTitleList;
	}

	public void setProfessionalTitleList(
			List<Professionaltitle> professionalTitleList) {
		this.professionalTitleList = professionalTitleList;
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

	public List<Teacherscategory> getTeachersCategoryList() {
		return teachersCategoryList;
	}

	public void setTeachersCategoryList(
			List<Teacherscategory> teachersCategoryList) {
		this.teachersCategoryList = teachersCategoryList;
	}

	public List<Jobtype> getJobTypeList() {
		return jobTypeList;
	}

	public void setJobTypeList(List<Jobtype> jobTypeList) {
		this.jobTypeList = jobTypeList;
	}

	public List<Learningedge> getLearningEdgelist() {
		return learningEdgelist;
	}

	public void setLearningEdgelist(List<Learningedge> learningEdgelist) {
		this.learningEdgelist = learningEdgelist;
	}

	public List<Subjectcategory> getSubjectCategoryList() {
		return subjectCategoryList;
	}

	public void setSubjectCategoryList(List<Subjectcategory> subjectCategoryList) {
		this.subjectCategoryList = subjectCategoryList;
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

	public AcademicdegreeService getAcademicDegreeService() {
		return academicDegreeService;
	}

	public void setAcademicDegreeService(
			AcademicdegreeService academicDegreeService) {
		this.academicDegreeService = academicDegreeService;
	}

	public List<Academicdegree> getAcademicdegreeList() {
		return academicdegreeList;
	}

	public void setAcademicdegreeList(List<Academicdegree> academicdegreeList) {
		this.academicdegreeList = academicdegreeList;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setTeachermodel(TeacherModel teachermodel) {
		this.teachermodel = teachermodel;
	}

	public TeacherModel getTeachermodel() {
		return teachermodel;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String list() {

		return "list";
	}
}
