package cn.edu.nwsuaf.Action;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nwsuaf.Model.InnovationModel;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.Model.TeachReBaseModel;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Service.Impl.AcademicdegreeService;
import cn.edu.nwsuaf.Service.Impl.DegreeService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.InnovationmemberService;
import cn.edu.nwsuaf.Service.Impl.InnovationprojectService;
import cn.edu.nwsuaf.Service.Impl.JobTypeService;
import cn.edu.nwsuaf.Service.Impl.LearningEdgeService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.ProfessionalTitleService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.Service.Impl.SubjectCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeachBookService;
import cn.edu.nwsuaf.Service.Impl.TeachBooksService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.Service.Impl.TeachersCategoryService;
import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Innovationmember;
import cn.edu.nwsuaf.bean.Innovationproject;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherscategory;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.bean.Teachresult;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

@SuppressWarnings("unused")
public class InnovationAction extends ActionSupport {
	
	//大学生科创情况
	private static final long serialVersionUID = 1L;
	// Service
	private InnovationmemberService innovationmemberService;
	private InnovationprojectService innovationprojectService;
	private StudentService studentService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// 传到前台下拉列表从数据库中读取显示

	private List<Student> studentList;// 学生
	private List<Major> majorList;// 专业
	private List<Department> departmentList;// 学院
	private List<String> yearList;// 年份
	private List<String> levelList;// 级别
	private List<String> typeList;// 类别
	private List<String> setDateList;// 类别
	private List<String> endDateList;// 类别
	private List<Innovationmember> innovationmemberList;// 创新创业项目成员表
	private List<Innovationproject> innovationprojectList;// 创新创业项目基本信息
	private List<Innovationproject> iprojectList;// 创新创业项目成员基本信息
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;

	private String majorId;// 专业编号
	private String departmentId;// 学院编号
	private Innovationmember innovationmember;
	public String getMajorId() {
		return majorId;
	}

	private Innovationproject innovationproject;
	private InnovationModel innovationModel= new InnovationModel();
	public String innoNumber;
	public Integer innoMemNumber;
	private int rol;
	private int number;
	//错误提示
	private String errstring;

	// 初始化信息，用于页面显示数据库中信息
	public String initSee() {
		
			try {
				page=1;
				rows=10;
				if (innoNumber == null) {
					innovationproject = null;
				} else {
					//System.out.print("as"+innoNumber);
				innovationproject = innovationprojectService.findById(
						Innovationproject.class, innoNumber);
			
				innovationmemberList = innovationmemberService.findIMList(innovationmember, page,
						rows, innoNumber);
				totalRows = innovationmemberService.countFindIM(innovationmember, innoNumber);
				if (totalRows % rows == 0) {
					totalPage = totalRows / rows;
				} else {
					totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
					return "error";
			}
		
		return "initSee";
	}
	// 查看创新创业项目信息
	public String see() {
		try {
			innovationmemberList = innovationmemberService.findIMList(innovationmember, page,
					rows, innoNumber);
			totalRows = innovationmemberService.countFindIM(innovationmember, innoNumber);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "see";
	}

	// 初始化修改页面
	public String edit() {
		if (innoNumber == null) {
			innovationproject = null;
		} else {
			try {
				innovationproject = innovationprojectService.findById(
						Innovationproject.class, innoNumber);
			} catch (Exception e) {
			
				return "error";
			}
		}
		return "edit";
	}
	//初始化添加成员页面 
	public String edit1()
	{
		edit();
		return "edit1";
	}
	// 修改创新项目信息
	public String modifi() {
		try {
			List<Innovationproject> s;
			s = innovationprojectService
					.findByHQL("from Innovationproject as inn where inn.innoNumber='"
							+ innovationproject.getInnoNumber()+"'");
			if (s.size()==0) {
				
				innovationprojectService.save(innovationproject);
			} else {
				System.out.println("已经存在");
				innovationprojectService.update(innovationproject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "modifi";
	}

	// 初始化修改页面
	public String editM() {
		if (innoMemNumber == 0) {
			innovationmember = null;
		} else {
			try {
				innovationmember = innovationmemberService.findById(
						Innovationmember.class, innoMemNumber);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "editM";
	}

	// 修改创新项目成员信息
	public String modifiM() {
		try {

			List<Innovationmember> s;
			s = innovationmemberService
					.findByHQL("from Innovationmember as inno where inno.innoMemNumber='"
							+ innovationmember.getInnoMemNumber()+"'");
			if (s.size() == 0) {
				innovationmember.setInnovationproject(innovationproject);
				innovationmemberService.save(innovationmember);
			} else {
				System.out.println("已经存在");
				innovationmemberService.update(innovationmember);
			}
		} catch (Exception e) {
		
			return "error";
		}

		return "modifiM";
	}

	// 添加
	public String add() {
		
		return "add";
	}

	// 添加
	public String addM() {
		try {
			
			innovationmember.setInnovationproject(innovationproject);
			
			innovationmemberService.save(innovationmember);
		
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addM";
	}

	// 删除
	public String delete() {
		try {
			System.out.print("innoNumber" + innoNumber);
			Innovationproject innovationproject = innovationprojectService.findById(
					Innovationproject.class, innoNumber);
			List<Innovationmember> newinnovationmemberList;
			newinnovationmemberList=innovationmemberService.findByHQL("from Innovationmember as ta where ta.innovationproject.innoNumber="+innoNumber);
			int size=0;
			size=newinnovationmemberList.size();
			if(size!=0){
				for(Innovationmember t:newinnovationmemberList)
				{
					innovationmemberService.delete(t);
				}
			}
			innovationprojectService.delete(innovationproject);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "delete";
	}

	// 删除成员
	public String deleteM() {
		try {
			Innovationmember innovationmember = innovationmemberService.findById(
					Innovationmember.class, innoMemNumber);
			innovationmemberService.delete(innovationmember);
		} catch (Exception e) {
			
			return "error";
		}

		return "deleteM";
	}

	//清空科创成员信息
	public String clearM() {
		try {
			List<Innovationmember> innewlist=new ArrayList<Innovationmember>();
			innewlist = innovationmemberService.findByHQL("from Innovationmember as ta where ta.innovationproject.innoNumber="+innoNumber);
			for(Innovationmember t:innewlist){
				innovationmemberService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//清空当前页科创成员信息
	public String clearListM() {
		try {
			for(Innovationmember t:innovationmemberList){
				innovationmemberService.delete(t);
			}		
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
		innovationModel=null;
		try {
			page=1;
			rows=10;
			//	学生竞赛信息，把学生信息注释掉学生信息2015-12-23
			//studentList = studentService.findAll(Student.class);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = innovationprojectService.findYearList();
			levelList = innovationprojectService.findLevelList();
			typeList = innovationprojectService.findTypeList();
			setDateList = innovationprojectService.findSetDateList();
			endDateList = innovationprojectService.findEndDateList();
			
			innovationprojectList = innovationprojectService.findallCompetitionList(page, rows, mno, dno);
			totalRows = innovationprojectService.count(mno, dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "initSearch";
	}

	// 条件查询大学生科创信息
	public String find() {
		//System.out.println("find++++++++++++++++++");
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
			if(innovationModel==null){
				innovationModel = new InnovationModel();
				innovationModel.setName("");
				innovationModel.setLevel(null);
				innovationModel.setType(null);
				if(!mno.equals("000000")){
					innovationModel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					innovationModel.setDepartmentId(dno);
				}
			}
			if(!mno.equals("000000")){
				innovationModel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				innovationModel.setDepartmentId(dno);
			}
			
			System.out.println(page+" "+rows);
			innovationprojectList = innovationprojectService.findIProjectsList(innovationModel, page, rows,mno,dno);
			totalRows = innovationprojectService.countFindIProject(innovationModel,mno,dno);
			
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "find";
	}

	public String getErrstring() {
		return errstring;
	}
	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	public InnovationmemberService getInnovationmemberService() {
		return innovationmemberService;
	}

	public void setInnovationmemberService(
			InnovationmemberService innovationmemberService) {
		this.innovationmemberService = innovationmemberService;
	}

	public InnovationprojectService getInnovationprojectService() {
		return innovationprojectService;
	}

	public void setInnovationprojectService(
			InnovationprojectService innovationprojectService) {
		this.innovationprojectService = innovationprojectService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<String> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<String> levelList) {
		this.levelList = levelList;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public List<String> getSetDateList() {
		return setDateList;
	}

	public void setSetDateList(List<String> setDateList) {
		this.setDateList = setDateList;
	}

	public List<String> getEndDateList() {
		return endDateList;
	}

	public void setEndDateList(List<String> endDateList) {
		this.endDateList = endDateList;
	}

	public List<Innovationmember> getInnovationmemberList() {
		return innovationmemberList;
	}

	public void setInnovationmemberList(List<Innovationmember> innovationmemberList) {
		this.innovationmemberList = innovationmemberList;
	}

	public List<Innovationproject> getInnovationprojectList() {
		return innovationprojectList;
	}

	public void setInnovationprojectList(
			List<Innovationproject> innovationprojectList) {
		this.innovationprojectList = innovationprojectList;
	}

	public List<Innovationproject> getIprojectList() {
		return iprojectList;
	}

	public void setIprojectList(List<Innovationproject> iprojectList) {
		this.iprojectList = iprojectList;
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

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Innovationmember getInnovationmember() {
		return innovationmember;
	}

	public void setInnovationmember(Innovationmember innovationmember) {
		this.innovationmember = innovationmember;
	}

	public Innovationproject getInnovationproject() {
		return innovationproject;
	}

	public void setInnovationproject(Innovationproject innovationproject) {
		this.innovationproject = innovationproject;
	}

	public InnovationModel getInnovationModel() {
		return innovationModel;
	}

	public void setInnovationModel(InnovationModel innovationModel) {
		this.innovationModel = innovationModel;
	}

	public String getInnoNumber() {
		return innoNumber;
	}

	public void setInnoNumber(String innoNumber) {
		this.innoNumber = innoNumber;
	}

	public Integer getInnoMemNumber() {
		return innoMemNumber;
	}

	public void setInnoMemNumber(Integer innoMemNumber) {
		this.innoMemNumber = innoMemNumber;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public int getTpage() {
		return tpage;
	}
	public void setTpage(int tpage) {
		this.tpage = tpage;
	}
	public int getTrows() {
		return trows;
	}
	public void setTrows(int trows) {
		this.trows = trows;
	}
	
}
