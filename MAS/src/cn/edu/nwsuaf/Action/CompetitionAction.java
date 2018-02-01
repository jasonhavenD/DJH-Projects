package cn.edu.nwsuaf.Action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nwsuaf.Model.CompetitionModel;
import cn.edu.nwsuaf.Model.InnovationModel;
import cn.edu.nwsuaf.Model.StuCptionModel;
import cn.edu.nwsuaf.Service.Impl.CompetitionService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.StuCptionService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.bean.Competition;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Innovationmember;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.bean.Studentcoepetition;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class CompetitionAction extends ActionSupport {
	
	//学科竞赛获奖
	private static final long serialVersionUID = 1L;
	private CompetitionService competitionService;
	private StuCptionService stuCptionService;
	private StudentService studentService;
	private DepartmentService departmentService;
	private MajorService majorService;
	// 传到前台下拉列表从数据库中读取显示
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<String> typeList;// 获奖类别
	private List<String> rankList;// 获奖等

	// 从前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;
	private int comNumber;// 竞赛编号
	private String comName;// 竞赛名称
	private Integer innoMemNumber;// 成员编号
	private List<Student> studentList;
	private List<Competition> competitionlist;		
	private List<Competition> competitionfindlist;
	private List<Studentcoepetition> studentcoepetitionlist;
	private CompetitionModel comodel = new CompetitionModel();
	private Competition competition;
	private Studentcoepetition studentcoepetition;
	private Student student;
	private StuCptionModel smodel =new StuCptionModel();

	private int rol;
	private String errstring;

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
		comodel=null;
		try {
			page=1;
			rows=10;
			yearList = competitionService.findYearList();
			typeList = competitionService.findTypeList();
			rankList = competitionService.findRankList();
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			competitionfindlist = competitionService.findallCompetitionList(page, rows, mno, dno);
			//学生竞赛信息  学生信息2015-12-23
			//studentList = studentService.findAll(Student.class);
			totalRows = competitionService.count(mno, dno);
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

	// 初始化编辑页面
	public String initEdit() {
		if (comNumber == 0) {
			competition = null;
		} else 
		{
			
			competition = competitionService.findById(Competition.class, comNumber);
		}
		return "success";
	}

	// 条件查询教师信息
	public String findCompetition() {
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
			if(comodel==null){
            	System.out.println("页数"+page+"条数"+rows);
            	comodel = new CompetitionModel();
            	comodel.setComName("");
            	if(comodel==null){
                	comodel = new CompetitionModel();
                	comodel.setComName("");
                	comodel.setComType("");
                	comodel.setComRank("");
                	comodel.setMajorId("");
                	comodel.setDepartmentId("");
    			}else if(comodel.getComName()!=null){
    				comodel.setComName(java.net.URLDecoder.decode(comodel.getComName(),"UTF-8"));
    			}

            	if(!mno.equals("000000")){
    				comodel.setMajorId(mno);
    				
    			}else if(!dno.equals("00000")&&mno.equals("000000")){
    				comodel.setDepartmentId(dno);
    			}
			}
			if(!mno.equals("000000")){
				comodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				comodel.setDepartmentId(dno);
			}

			competitionfindlist = competitionService.findCompesList(comodel,
					page, rows);

			totalRows = competitionService.countFindTtion(comodel);
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

	// 查询成员信息
	public String findStuCption() {
		initEdit();
		try {
			
			studentcoepetitionlist = stuCptionService.findStuptionList(studentcoepetition, page, rows,comNumber);
			totalRows=stuCptionService.findStuption(studentcoepetition,comNumber);
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

	// 修改
	public String modifiCompetition() {
		try {
			List<Competition> s;
			s = competitionService
					.findByHQL("from Competition as com where com.comNumber ="
							+ competition.getComNumber());

			if (s.size() == 0) {

				competitionService.save(competition);
			} else {
				System.out.println("已经存在！");
				competitionService.update(competition);
				System.out.print("competition========="
						+ competition.getComName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	// 初始化成员编辑页面
	public String initEditSuCp() {
		try {
			studentcoepetition = stuCptionService.findById(
					Studentcoepetition.class, innoMemNumber);
		} catch (Exception e) {
			
			return "error";
		}

		return "success";
	}

	// 修改成员信息
	public String modifiStuCption() {
		try {
		/*	List<Studentcoepetition> s;
			System.out.println(studentcoepetition.getInnoMemNumber());
			s = stuCptionService
					.findBySQL("select * from Studentcoepetition where innoMemNumber ="
							+ studentcoepetition.getInnoMemNumber());*/
			if (innoMemNumber == 0) {
				System.out.println("as"+competition.getComNumber());
				studentcoepetition.setCompetition(competition);
				stuCptionService.save(studentcoepetition);
			} else {
				System.out.println("成员排名"+studentcoepetition.getRank());
				stuCptionService.update(studentcoepetition);
				/*System.out.println("teacherachievements.getTeachRank()==="
						+ studentcoepetition.getRank());
				System.out.println("innoMemNumber=========" + innoMemNumber);*/
			}

		} catch (Exception e) {
			e.printStackTrace();                 
			return "error";
		}

		return "success";
	}

	// 添加
	public String insertCompetition() {
		try {
			
			competitionService.save(competition);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	//添加成员信息
	public String insertStuCption() {
		try {
			studentcoepetition.setCompetition(competition);
			stuCptionService.save(studentcoepetition);
		} catch (Exception e) {
		
			return "error";
		}
		return "success";
	}

	// 删除
	public String deleteCompetition() {
		try {
			competition = competitionService.findById(Competition.class,
					comNumber);
			List<Studentcoepetition> newstudentcoepetitionList;
			newstudentcoepetitionList=stuCptionService.findByHQL("from Studentcoepetition as ta where ta.competition.comNumber="+comNumber);
			int size=0;
			size=newstudentcoepetitionList.size();
			if(size!=0){
				for(Studentcoepetition t:newstudentcoepetitionList)
				{
					stuCptionService.delete(t);
				}
			}
			competitionService.delete(competition);

		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 删除竞赛成员信息
	public String deleteStuCption() {
		try {
			studentcoepetition = stuCptionService.findById(Studentcoepetition.class,
					innoMemNumber);
			stuCptionService.delete(studentcoepetition);

		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	//清空竞赛成员信息
	public String clearStuCption() {
		try {
			List<Studentcoepetition> sclist=new ArrayList<Studentcoepetition>();
			sclist = stuCptionService.findByHQL("from Studentcoepetition as ta where ta.competition.comNumber="+comNumber);
			for(Studentcoepetition s:sclist){
				stuCptionService.delete(s);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	//清空当年页竞赛成员信息
	public String clearListStuCption() {
		try {
			for(Studentcoepetition s:studentcoepetitionlist){
				stuCptionService.delete(s);
			}		
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	
	public CompetitionService getCompetitionService() {
		return competitionService;
	}

	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public StuCptionService getStuCptionService() {
		return stuCptionService;
	}

	public void setStuCptionService(StuCptionService stuCptionService) {
		this.stuCptionService = stuCptionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public List<String> getRankList() {
		return rankList;
	}

	public void setRankList(List<String> rankList) {
		this.rankList = rankList;
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

	
	public int getComNumber() {
		return comNumber;
	}

	public void setComNumber(int comNumber) {
		this.comNumber = comNumber;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Integer getInnoMemNumber() {
		return innoMemNumber;
	}

	public void setInnoMemNumber(Integer innoMemNumber) {
		this.innoMemNumber = innoMemNumber;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Competition> getCompetitionlist() {
		return competitionlist;
	}

	public void setCompetitionlist(List<Competition> competitionlist) {
		this.competitionlist = competitionlist;
	}

	public List<Competition> getCompetitionfindlist() {
		return competitionfindlist;
	}

	public void setCompetitionfindlist(List<Competition> competitionfindlist) {
		this.competitionfindlist = competitionfindlist;
	}

	public List<Studentcoepetition> getStudentcoepetitionlist() {
		return studentcoepetitionlist;
	}

	public void setStudentcoepetitionlist(
			List<Studentcoepetition> studentcoepetitionlist) {
		this.studentcoepetitionlist = studentcoepetitionlist;
	}

	

	public CompetitionModel getComodel() {
		return comodel;
	}

	public void setComodel(CompetitionModel comodel) {
		this.comodel = comodel;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Studentcoepetition getStudentcoepetition() {
		return studentcoepetition;
	}

	public void setStudentcoepetition(Studentcoepetition studentcoepetition) {
		this.studentcoepetition = studentcoepetition;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StuCptionModel getSmodel() {
		return smodel;
	}

	public void setSmodel(StuCptionModel smodel) {
		this.smodel = smodel;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getTrows() {
		return trows;
	}

	public void setTrows(int trows) {
		this.trows = trows;
	}

	public void setTpage(int tpage) {
		this.tpage = tpage;
	}

	public int getTpage() {
		return tpage;
	}

	public String list() {

		return "list";
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
	
}
