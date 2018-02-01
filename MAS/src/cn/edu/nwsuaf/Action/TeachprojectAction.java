package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Model.TeachprojectModel;
import cn.edu.nwsuaf.Service.Impl.AcademicdegreeService;
import cn.edu.nwsuaf.Service.Impl.DegreeService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.JobTypeService;
import cn.edu.nwsuaf.Service.Impl.LearningEdgeService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.ProfessionalTitleService;
import cn.edu.nwsuaf.Service.Impl.SubjectCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeachBookService;
import cn.edu.nwsuaf.Service.Impl.TeachBooksService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.Service.Impl.TeachersCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectuserService;
import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.bean.Teacherscategory;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.bean.Teachproject;
import cn.edu.nwsuaf.bean.Teachprojectuser;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

@SuppressWarnings("unused")
public class TeachprojectAction extends ActionSupport {
	
	//教学质量工程
	private static final long serialVersionUID = 1L;

	// Service
	private TeachprojectService teachprojectService;
	private TeachprojectuserService teachprojectuserService;
	
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// 传到前台下拉列表从数据库中读取显示

	private List<Teacher> teacherList;// 教师
	private List<Major> majorList;// 专业
	private List<Department> departmentList;// 学院
	
	private List<String> yearList;// 年份
	private List<String> tprojecJibieList;// 级别
	private List<String> tprojecTypeList;// 类别
	 
	private List<Teachprojectuser> teachprojectuserList;// 教材作者表
	private List<Teachproject> teachprojectList;// 教材基本信息
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;

	private String majorId;// 专业编号
	private String departmentId;// 学院编号
	
	private Teachprojectuser teachprojectuser;
	private Teachproject teachproject;
	private TeachprojectModel teachprojectModel = new TeachprojectModel();
	
	public  String tprojectNo;
	public Integer tpUno;
	private int rol;
	private Exception err;	
	private String errstring;
	
	public Exception getErr() {
		return err;
	}
	public void setErr(Exception err) {
		this.err = err;
	}

	// 初始化信息
	public String initSee() {
		if (tprojectNo == null) {
			teachproject = null;
		} else {
			try {
				teachproject = teachprojectService.findById(Teachproject.class,
						tprojectNo);
				teachprojectuserList = teachprojectuserService.findTPUList(teachprojectuser, page,
						rows, tprojectNo);
				totalRows = teachprojectuserService.countFindTBook(teachprojectuser, tprojectNo);
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

	// 查看信息
	public String see() {
		try {
			teachprojectuserList = teachprojectuserService.findTPUList(teachprojectuser, page,
					rows, tprojectNo);
			totalRows = teachprojectuserService.countFindTBook(teachprojectuser, tprojectNo);
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
		if (tprojectNo == null) {
			teachproject = null;
		} else {
			try {
				teachproject = teachprojectService.findById(Teachproject.class,
						tprojectNo);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "edit";
	}
	//初始化成员添加页面
	public String edit1(){
		edit();
		return "edit1";
	}
	// 修改
	public String modifi() {
		try {

			List<Teachproject> s;
			s = teachprojectService
			.findByHQL("from Teachproject as tea where tea.tprojectNo='"
					+ teachproject.getTprojectNo()+"'");

			if (s.size() == 0) {
				teachprojectService.save(teachproject);
			} else {
				System.out.println("已经存在");
				teachprojectService.update(teachproject);
			}
		} catch (Exception e) {
			
			return "error";
		}

		return "modifi";
	}

	// 初始化修改页面
	public String editU() {
		if (tpUno == 0) {
			teachprojectuser = null;
		} else {
			try {
				teachprojectuser = teachprojectuserService.findById(Teachprojectuser.class, tpUno);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "editU";
	}

	// 修改 
	public String modifiU() {
		try {
			List<Teachprojectuser> s;
			s = teachprojectuserService.findByHQL("from Teachprojectuser as t where t.tpUno='"+ teachprojectuser.getTpUno()+"'");
			if (s.size() == 0) {
				teachprojectuser.setTeachproject(teachproject);
				teachprojectuserService.save(teachprojectuser);
			} else {
				System.out.println("已经存在");
				teachprojectuserService.update(teachprojectuser);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "modifiU";
	}

	// 添加
	public String add() {
		
		return "add";
	}

	// 添加
	public String addU() {
		try {
			teachprojectuser.setTeachproject(teachproject);
			teachprojectuserService.save(teachprojectuser);
		} catch (Exception e) {
			
			return "error";
		}
		return "addU";
	}

	// 删除
	public String delete() {
		try {
			Teachproject teachproject = teachprojectService.findById(Teachproject.class, tprojectNo);
			List<Teachprojectuser> newteachprojectuserList;
			newteachprojectuserList=teachprojectuserService.findByHQL("from Teachprojectuser as ta where ta.teachproject.tprojectNo='"+tprojectNo+"'");
			int size=0;
			size=newteachprojectuserList.size();
			if(size!=0){
				for(Teachprojectuser t:newteachprojectuserList)
				{
					teachprojectuserService.delete(t);
				}
			}
			teachprojectService.delete(teachproject);
		} catch (Exception e) {
		
			return "error";
		}

		return "delete";
	}
	//清空工程成员信息
	public String clearU() {
		try {
			List<Teachprojectuser> tpnewlist=new ArrayList<Teachprojectuser>();
			tpnewlist = teachprojectuserService.findByHQL("from Teachprojectuser as ta where ta.teachproject.tprojectNo='"+tprojectNo+"'");
			for(Teachprojectuser t:tpnewlist){
				teachprojectuserService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//清空当前页工程成员信息
	public String clearListU() {
		try {
			for(Teachprojectuser t:teachprojectuserList){
				teachprojectuserService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	// 删除作者
	public String deleteU() {
		try {
			Teachprojectuser teachprojectuser = teachprojectuserService.findById(Teachprojectuser.class,
					tpUno);
			teachprojectuserService.delete(teachprojectuser);
		} catch (Exception e) {
			
			return "error";
		}

		return "deleteU";
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
		teachprojectModel=null;
		try {
			page = 1;
			rows = 10;
			teacherList = teacherService.findAll(Teacher.class);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			
			yearList = teachprojectService.findYearList();
			tprojecJibieList = teachprojectService.findTprojecJibieList();
			tprojecTypeList = teachprojectService.findTprojecTypeList();
			
			teachprojectList = teachprojectService.findallTeachprojectList(page, rows, mno, dno);
			//System.out.print("asd"+teachprojectList.size());
			totalRows = teachprojectService.count(mno, dno);
			//System.out.print("asd"+totalRows);
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

	// 条件查询教师信息
	public String find() {
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
			if(teachprojectModel==null){
				teachprojectModel = new TeachprojectModel();
				teachprojectModel.setName("");
				if(!mno.equals("000000")){
					teachprojectModel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					teachprojectModel.setDepartmentId(dno);
				}
			}
			if(!mno.equals("000000")){
				teachprojectModel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				teachprojectModel.setDepartmentId(dno);
			}
			if(teachprojectModel==null){
				teachprojectModel = new TeachprojectModel();
				teachprojectModel.setName("");
				teachprojectModel.setApprovalNumber("");
				teachprojectModel.setId("");
				teachprojectModel.setTprojecJibie("");
				teachprojectModel.setTprojecType("");
				teachprojectModel.setYear("");
				if(!mno.equals("000000")){
					teachprojectModel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					teachprojectModel.setDepartmentId(dno);
				}
			}
			else if(teachprojectModel!=null&&teachprojectModel.getName()!=null&&teachprojectModel.getTprojecJibie()!=null&&teachprojectModel.getTprojecType()!=null){
				teachprojectModel.setName(java.net.URLDecoder.decode(teachprojectModel
						.getName(), "UTF-8"));
				teachprojectModel.setTprojecJibie(java.net.URLDecoder.decode(teachprojectModel
						.getTprojecJibie(), "UTF-8"));
				teachprojectModel.setTprojecType(java.net.URLDecoder.decode(teachprojectModel
						.getTprojecType(), "UTF-8"));
			}
			teachprojectList = teachprojectService.findTPList(teachprojectModel,
					page, rows);

			totalRows = teachprojectService.countFindTBooks(teachprojectModel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			err=e;
			StackTraceElement[] st = err.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String exclass = stackTraceElement.getClassName();
				String method = stackTraceElement.getMethodName();
				System.out.println(new Date() + ":" + "[类:" + exclass + "]调用"
				+ method + "时在第" + stackTraceElement.getLineNumber()
				+ "行代码处发生异常!异常类型:" + err.getClass().getName());
			}
			return "error";
		}
		return "find";
	}

	public TeachprojectService getTeachprojectService() {
		return teachprojectService;
	}

	public void setTeachprojectService(TeachprojectService teachprojectService) {
		this.teachprojectService = teachprojectService;
	}

	public TeachprojectuserService getTeachprojectuserService() {
		return teachprojectuserService;
	}

	public void setTeachprojectuserService(
			TeachprojectuserService teachprojectuserService) {
		this.teachprojectuserService = teachprojectuserService;
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

	public List<String> getTprojecJibieList() {
		return tprojecJibieList;
	}

	public void setTprojecJibieList(List<String> tprojecJibieList) {
		this.tprojecJibieList = tprojecJibieList;
	}

	public List<String> getTprojecTypeList() {
		return tprojecTypeList;
	}

	public void setTprojecTypeList(List<String> tprojecTypeList) {
		this.tprojecTypeList = tprojecTypeList;
	}

	public List<Teachprojectuser> getTeachprojectuserList() {
		return teachprojectuserList;
	}

	public void setTeachprojectuserList(List<Teachprojectuser> teachprojectuserList) {
		this.teachprojectuserList = teachprojectuserList;
	}

	public List<Teachproject> getTeachprojectList() {
		return teachprojectList;
	}

	public void setTeachprojectList(List<Teachproject> teachprojectList) {
		this.teachprojectList = teachprojectList;
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

	public Teachprojectuser getTeachprojectuser() {
		return teachprojectuser;
	}

	public void setTeachprojectuser(Teachprojectuser teachprojectuser) {
		this.teachprojectuser = teachprojectuser;
	}

	public Teachproject getTeachproject() {
		return teachproject;
	}

	public void setTeachproject(Teachproject teachproject) {
		this.teachproject = teachproject;
	}

	public TeachprojectModel getTeachprojectModel() {
		return teachprojectModel;
	}

	public void setTeachprojectModel(TeachprojectModel teachprojectModel) {
		this.teachprojectModel = teachprojectModel;
	}

	public String getTprojectNo() {
		return tprojectNo;
	}

	public void setTprojectNo(String tprojectNo) {
		this.tprojectNo = tprojectNo;
	}

	public Integer getTpUno() {
		return tpUno;
	}

	public void setTpUno(Integer tpUno) {
		this.tpUno = tpUno;
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
