package cn.edu.nwsuaf.Action;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nwsuaf.Model.InnovationModel;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.Model.TeachReBaseModel;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Model.TeachprojectModel;
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
import cn.edu.nwsuaf.Service.Impl.TeachResultBaseService;
import cn.edu.nwsuaf.Service.Impl.TeachResultService;
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
import cn.edu.nwsuaf.bean.Teachprojectuser;
import cn.edu.nwsuaf.bean.Teachresult;
import cn.edu.nwsuaf.bean.Teachresultbaseinfo;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

@SuppressWarnings("unused")
public class TeachResultBaseAction extends ActionSupport {
	
	//教学质量工程
	private static final long serialVersionUID = 1L;
	
	// Service
	private TeachResultService teachResultService;
	private TeachResultBaseService teachResultBaseService;
	
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// 传到前台下拉列表从数据库中读取显示

	private List<Teacher> teacherList;// 教师
	private List<Major> majorList;// 专业
	private List<Department> departmentList;// 学院
	
	private List<String> yearList;// 年份
	private List<String> tresultJibieList;// 级别
	private List<String> tresultClassList;// 类别
	
	private List<Teachresult> teachresultList;// 教学成果成员表
	private List<Teachresultbaseinfo> TeachresultbaseinfoList;// 教学成果基本信息
	private List<Teachresultbaseinfo> TBList;//竞赛成员基本信息
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;

	private String majorId;// 专业编号
	private String departmentId;// 学院编号
	
	private Teachresult teachresult;
	private Teachresultbaseinfo teachresultbaseinfo;
	private TeachReBaseModel teachReBaseModel= new TeachReBaseModel();
	
	public Integer tresultBaseNo;
	public Integer tresultNo;
	private int rol;
	private String errstring;
	
	// 初始化修改页面
	public String edit() {
		if (tresultBaseNo == 0) {
			teachresultbaseinfo = null;
		} else {
			try {
				teachresultbaseinfo = teachResultBaseService.findById(
						Teachresultbaseinfo.class, tresultBaseNo);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "edit";
	}
	//初始化添加页面
	public String edit1() {
		edit() ;
		return "edit1";
	}
	// 修改
	public String modifi() {
		try {
			if (tresultBaseNo == 0) {
				
				teachResultBaseService.save(teachresultbaseinfo);
			} else {
				System.out.println("已经存在");
				teachResultBaseService.update(teachresultbaseinfo);
			}
		} catch (Exception e) {
			
			return "error";
		}

		return "modifi";
	}

	// 初始化修改页面
	public String editB() {
		if (tresultNo == 0) {
			teachresult = null;
		} else {
			try {
				teachresult = teachResultService.findById(
						Teachresult.class, tresultNo);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "editB";
	}

	// 修改
	public String modifiB() {
		try {

			List<Teachresult> s;
			s = teachResultService
					.findByHQL("from Teachresult as t where t.tresultNo='"
							+ teachresult.getTresultNo()+"'");
			if (s.size() == 0) {
				teachresult.setTeachresultbaseinfo(teachresultbaseinfo);
				teachResultService.save(teachresult);
			} else {
				System.out.println("已经存在");
				teachResultService.update(teachresult);
			}
		} catch (Exception e) {
		
			return "error";
		}

		return "modifiB";
	}

	// 添加
	public String add() {
		
		return "add";
	}

	// 添加
	public String addB() {
		try {
			teachresult.setTeachresultbaseinfo(teachresultbaseinfo);
			teachResultService.save(teachresult);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addB";
	}

	// 删除
	public String delete() {
		try {
			System.out.print("tresultBaseNo" + tresultBaseNo);
			Teachresultbaseinfo teachresultbaseinfo = teachResultBaseService.findById(
					Teachresultbaseinfo.class, tresultBaseNo);
			List<Teachresult> newteachresultList;
			newteachresultList=teachResultService.findByHQL("from Teachresult as ta where ta.teachresultbaseinfo.tresultBaseNo="+tresultBaseNo);
			int size=0;
			size=newteachresultList.size();
			if(size!=0){
				for(Teachresult t:newteachresultList)
				{
					teachResultService.delete(t);
				}
			}
			teachResultBaseService.delete(teachresultbaseinfo);
		} catch (Exception e) {
			
			return "error";
		}

		return "delete";
	}
	//清空奖项成员信息
	public String clearB() {
		try {
			List<Teachresult> tsnewlist=new ArrayList<Teachresult>();
			tsnewlist = teachResultService.findByHQL("from Teachresult as ts where ts.teachresultbaseinfo.tresultBaseNo="+tresultBaseNo);
			for(Teachresult t:tsnewlist){
				teachResultService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//清空当前页奖项成员信息
	public String clearListB() {
		try {
			for(Teachresult t:teachresultList){
				teachResultService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	// 删除成员
	public String deleteB() {
		try {
			Teachresult teachresult = teachResultService.findById(
					Teachresult.class, tresultNo);
			teachResultService.delete(teachresult);
		} catch (Exception e) {
			
			return "error";
		}

		return "deleteB";
	}

	// 初始化信息，用于页面显示数据库中信息
	public String initSee() {
		if (tresultBaseNo == 0) {
			teachresultbaseinfo = null;
		} else {
			try {
				teachresultbaseinfo = teachResultBaseService.findById(
						Teachresultbaseinfo.class, tresultBaseNo);
				teachresultList = teachResultService.findTeaReList(teachresult, page,
						rows, tresultBaseNo);
				totalRows = teachResultService.countTeaRe(teachresult, tresultBaseNo);
				if (totalRows % rows == 0) {
					totalPage = totalRows / rows;
				} else {
					totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
				}
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "initSee";
	}
	// 查看创新创业项目信息
	public String see() {
		try {
			teachresultList = teachResultService.findTeaReList(teachresult, page,
					rows, tresultBaseNo);
			totalRows = teachResultService.countTeaRe(teachresult, tresultBaseNo);
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
		teachReBaseModel=null;
		try {
			//2015-12-24注解教师
			//teacherList = teacherService.findAll(Teacher.class);
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = teachResultBaseService.findyearList();
			tresultJibieList = teachResultBaseService.findtresultJibieList();
			tresultClassList = teachResultBaseService.findtresultClassList();
			TeachresultbaseinfoList = teachResultBaseService.findallTeachresultbaseinfoList(page, rows, mno, dno);
			totalRows = teachResultBaseService.count(mno, dno);
			
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

	// 条件查询学生信息
	public String find() {
		//System.out.println("find++++++++++++++++++");
		//initSearch();
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
			if(teachReBaseModel==null){
				teachReBaseModel = new TeachReBaseModel();
				teachReBaseModel.setTresultName("");
				if(!mno.equals("000000")){
					teachReBaseModel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					teachReBaseModel.setDepartmentId(dno);
				}
			}
			if(!mno.equals("000000")){
				teachReBaseModel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				teachReBaseModel.setDepartmentId(dno);
			}
			if(teachReBaseModel==null){
				teachReBaseModel = new TeachReBaseModel();
				teachReBaseModel.setTresultName("");
				if(!mno.equals("000000")){
					teachReBaseModel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					teachReBaseModel.setDepartmentId(dno);
				}
			}
			else if(teachReBaseModel!=null&&teachReBaseModel.getName()!=null&&teachReBaseModel.getTresultJibie()!=null&&teachReBaseModel.getTresultClass()!=null&&teachReBaseModel.getRewardDepart()!=null){
				teachReBaseModel.setName(java.net.URLDecoder.decode(teachReBaseModel
						.getName(), "UTF-8"));
				teachReBaseModel.setTresultJibie(java.net.URLDecoder.decode(teachReBaseModel
						.getTresultJibie(), "UTF-8"));
				teachReBaseModel.setTresultClass(java.net.URLDecoder.decode(teachReBaseModel
						.getTresultClass(), "UTF-8"));
				teachReBaseModel.setRewardDepart(java.net.URLDecoder.decode(teachReBaseModel
						.getRewardDepart(), "UTF-8"));
			}
			TeachresultbaseinfoList = teachResultBaseService.findTeRebaseinfoList(teachReBaseModel, page, rows);
			totalRows = teachResultBaseService.countTeRebaseinfoList(teachReBaseModel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "find";
	}
	public TeachResultService getTeachResultService() {
		return teachResultService;
	}
	public void setTeachResultService(TeachResultService teachResultService) {
		this.teachResultService = teachResultService;
	}
	public TeachResultBaseService getTeachResultBaseService() {
		return teachResultBaseService;
	}
	public void setTeachResultBaseService(
			TeachResultBaseService teachResultBaseService) {
		this.teachResultBaseService = teachResultBaseService;
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
	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
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
	public List<String> getTresultJibieList() {
		return tresultJibieList;
	}
	public void setTresultJibieList(List<String> tresultJibieList) {
		this.tresultJibieList = tresultJibieList;
	}
	public List<String> getTresultClassList() {
		return tresultClassList;
	}
	public void setTresultClassList(List<String> tresultClassList) {
		this.tresultClassList = tresultClassList;
	}
	public List<Teachresult> getTeachresultList() {
		return teachresultList;
	}
	public void setTeachresultList(List<Teachresult> teachresultList) {
		this.teachresultList = teachresultList;
	}
	public List<Teachresultbaseinfo> getTeachresultbaseinfoList() {
		return TeachresultbaseinfoList;
	}
	public void setTeachresultbaseinfoList(
			List<Teachresultbaseinfo> teachresultbaseinfoList) {
		TeachresultbaseinfoList = teachresultbaseinfoList;
	}
	public List<Teachresultbaseinfo> getTBList() {
		return TBList;
	}
	public void setTBList(List<Teachresultbaseinfo> tBList) {
		TBList = tBList;
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
	public Teachresult getTeachresult() {
		return teachresult;
	}
	public void setTeachresult(Teachresult teachresult) {
		this.teachresult = teachresult;
	}
	public Teachresultbaseinfo getTeachresultbaseinfo() {
		return teachresultbaseinfo;
	}
	public void setTeachresultbaseinfo(Teachresultbaseinfo teachresultbaseinfo) {
		this.teachresultbaseinfo = teachresultbaseinfo;
	}

	public TeachReBaseModel getTeachReBaseModel() {
		return teachReBaseModel;
	}
	public void setTeachReBaseModel(TeachReBaseModel teachReBaseModel) {
		this.teachReBaseModel = teachReBaseModel;
	}
	public Integer getTresultBaseNo() {
		return tresultBaseNo;
	}
	public void setTresultBaseNo(Integer tresultBaseNo) {
		this.tresultBaseNo = tresultBaseNo;
	}
	public Integer getTresultNo() {
		return tresultNo;
	}
	public void setTresultNo(Integer tresultNo) {
		this.tresultNo = tresultNo;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
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
