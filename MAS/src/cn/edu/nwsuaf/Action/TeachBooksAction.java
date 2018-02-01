package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.Model.TeacherModel;
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
import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Studentcoepetition;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherscategory;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

@SuppressWarnings("unused")
public class TeachBooksAction extends ActionSupport {
	
	//出版教材
	private static final long serialVersionUID = 1L;

	// Service
	private TeachBooksService teachBooksService;
	private TeachBookService teachBookService;
	
	private TeacherService teacherService;
	private MajorService majorService;
	private DepartmentService departmentService;

	// 传到前台下拉列表从数据库中读取显示

	private List<Teacher> teacherList;// 教师
	private List<Major> majorList;// 专业
	private List<Department> departmentList;// 学院
	
	private List<String> yearList;// 年份
	private List<String> tbookJibieList;// 级别
	private List<String> tbookClassList;// 类别
	private List<String> tbookRewardClassList;// 奖项级别
	private List<String> publishTypeList;// 出版类型
	
	private List<Teachbook> teachBookList;// 教材作者表
	private List<Teachingbooks> teachBooksList;// 教材基本信息
	
	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;// 专业编号
	private String departmentId;// 学院编号
	private Teachbook teachBook;
	private Teachingbooks teachBooks;
	private TeachBooksModel teachBooksModel = new TeachBooksModel();
	public Integer tbno;
	public Integer tbZno;
	private int rol;
	private String errstring;
	// 初始化成员信息
	public String initSee() {
		
		if (tbno == 0) {
			teachBooks = null;
		} else {
			try {
			    page = 1;
	            rows = 10;
				teachBooks = teachBooksService.findById(Teachingbooks.class,
						tbno);
				teachBookList = teachBookService.findTBookList(teachBook, page,
						rows, tbno);
				totalRows=teachBookService.countFindTBook(teachBook, tbno);
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

	// 查看教材作者信息
	public String see() {

		try {
			System.out.println("页数"+page+"条数"+rows);
			teachBookList = teachBookService.findTBookList(teachBook, page,
					rows, tbno);
			totalRows = teachBookService.countFindTBook(teachBook, tbno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
				System.out.println();
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
		System.out.println("输出");
		if (tbno == 0) {
			teachBooks = null;
		} else {
			try {
				teachBooks = teachBooksService.findById(Teachingbooks.class,
						tbno);
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

	// 修改教材信息
	public String modifi() {
		try {

			/*List<Teachingbooks> s;
			s = teachBooksService
					.findBySQL("select * from Teachingbooks where tbno="
							+ teachBooks.getTbno());*/
			if (tbno == 0) {
				teachBooksService.save(teachBooks);
			} else {
				System.out.println("已经存在");
				teachBooksService.update(teachBooks);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "modifi";
	}

	// 初始化修改页面
	public String editTB() {
		if (tbZno == null) {
			teachBook = null;
		} else {
			try {
				teachBook = teachBookService.findById(Teachbook.class, tbZno);
			} catch (Exception e) {
				
				return "error";
			}
		}
		return "editTB";
	}

	// 修改
	public String modifiTB() {
		try {

			List<Teachbook> s;
			s = teachBookService
					.findByHQL("from Teachbook as t where t.tbZno='"
							+ teachBook.getTbZno()+"'");
			if (s.size() == 0) {
				teachBook.setTeachingbooks(teachBooks);
				teachBookService.save(teachBook);
			} else {
				//System.out.println("已经存在:  "+teachBook.getTeacher().getTno()+"  "+teachBook.getTeacher().getTname());
				teachBookService.update(teachBook);
			}
		} catch (Exception e) {
			
			return "error";
		}
		return "modifiTB";
	}

	// 添加
	public String add() {
		try {
			teachBooksService.save(teachBooks);
		} catch (Exception e) {
			
			return "error";
		}
		return "add";
	}

	// 添加
	public String addTB() {
		try {
			teachBook.setTeachingbooks(teachBooks);
			teachBookService.save(teachBook);
		} catch (Exception e) {
			
			return "error";
		}
		return "addTB";
	}

	// 删除教材
	public String delete() {
		try {
			Teachingbooks teachBooks = teachBooksService.findById(Teachingbooks.class, tbno);
			List<Teachbook> newteachBookList;
			newteachBookList=teachBookService.findByHQL("from Teachbook as t where t.teachingbooks.tbno="+tbno);
			int size=0;
			size=newteachBookList.size();
			if(size!=0){
				for(Teachbook t:newteachBookList)
				{
					teachBookService.delete(t);
				}
			}
			teachBooksService.delete(teachBooks);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "delete";
	}


	// 删除作者
	public String deleteTB() {
		try {
			Teachbook teachBook = teachBookService.findById(Teachbook.class,
					tbZno);
			teachBookService.delete(teachBook);
		} catch (Exception e) {
			
			return "error";
		}

		return "deleteTB";
	}

	//清空教材作者信息
	public String clearTB() {
		try {
			List<Teachbook> tbnewlist=new ArrayList<Teachbook>();
			tbnewlist = teachBookService.findByHQL("from Teachbook as tb where tb.teachingbooks.tbno="+tbno);
			for(Teachbook t:tbnewlist){
				teachBookService.delete(t);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//清空当前页教材作者信息
	public String clearListTB() {
		try {
			for(Teachbook t:teachBookList){
				teachBookService.delete(t);
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
        	errstring="登录超时！请安全退出再重新登录！";
        	return "errorstring";
        }
		teachBooksModel=null;
//		System.out.println("mno=:"+mno);
//		System.out.println("dno=:"+dno);
		try {
			page=1;
			rows=10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			//注解 2015-12-23
			//teacherList = teacherService.findAll(Teacher.class);
			
			yearList = teachBooksService.findYearList();
			tbookJibieList = teachBooksService.findTbookJibieList();
			tbookClassList = teachBooksService.findTBookClassList();
			tbookRewardClassList = teachBooksService.findTBookRewardClassList();
			publishTypeList = teachBooksService.findPublishTypeList();
			System.out.println("教材页面"+page+rows);
			teachBooksList = teachBooksService.findallTeachingbooksList(page, rows, mno, dno);
			totalRows = teachBooksService.count(mno, dno);
			
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

	// 条件查询教材信息
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
			System.out.println("教材页面"+page+rows);
			if(teachBooksModel==null){
				teachBooksModel = new TeachBooksModel();
				teachBooksModel.setId("");
				teachBooksModel.setName("");
			}
			teachBooksList = teachBooksService.findTBooksList(teachBooksModel,
					page, rows);
			totalRows = teachBooksService.countFindTBooks(teachBooksModel);
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

	public TeachBooksService getTeachBooksService() {
		return teachBooksService;
	}

	public void setTeachBooksService(TeachBooksService teachBooksService) {
		this.teachBooksService = teachBooksService;
	}

	public TeachBookService getTeachBookService() {
		return teachBookService;
	}

	public void setTeachBookService(TeachBookService teachBookService) {
		this.teachBookService = teachBookService;
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

	public List<String> getTbookJibieList() {
		return tbookJibieList;
	}

	public void setTbookJibieList(List<String> tbookJibieList) {
		this.tbookJibieList = tbookJibieList;
	}

	public List<String> getTbookClassList() {
		return tbookClassList;
	}

	public void setTbookClassList(List<String> tbookClassList) {
		this.tbookClassList = tbookClassList;
	}

	public List<String> getTbookRewardClassList() {
		return tbookRewardClassList;
	}

	public void setTbookRewardClassList(List<String> tbookRewardClassList) {
		this.tbookRewardClassList = tbookRewardClassList;
	}

	public List<String> getPublishTypeList() {
		return publishTypeList;
	}

	public void setPublishTypeList(List<String> publishTypeList) {
		this.publishTypeList = publishTypeList;
	}

	public List<Teachbook> getTeachBookList() {
		return teachBookList;
	}

	public void setTeachBookList(List<Teachbook> teachBookList) {
		this.teachBookList = teachBookList;
	}

	public List<Teachingbooks> getTeachBooksList() {
		return teachBooksList;
	}

	public void setTeachBooksList(List<Teachingbooks> teachBooksList) {
		this.teachBooksList = teachBooksList;
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

	public Teachbook getTeachBook() {
		return teachBook;
	}

	public void setTeachBook(Teachbook teachBook) {
		this.teachBook = teachBook;
	}

	public Teachingbooks getTeachBooks() {
		return teachBooks;
	}

	public void setTeachBooks(Teachingbooks teachBooks) {
		this.teachBooks = teachBooks;
	}

	public TeachBooksModel getTeachBooksModel() {
		return teachBooksModel;
	}

	public void setTeachBooksModel(TeachBooksModel teachBooksModel) {
		this.teachBooksModel = teachBooksModel;
	}

	public Integer getTbno() {
		return tbno;
	}

	public void setTbno(Integer tbno) {
		this.tbno = tbno;
	}

	public Integer getTbZno() {
		return tbZno;
	}

	public void setTbZno(Integer tbZno) {
		this.tbZno = tbZno;
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

	public String getErrstring() {
		return errstring;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}
	
}
