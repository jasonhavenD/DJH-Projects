package cn.edu.nwsuaf.Action;

import java.util.Date;
import java.util.List;

import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.Service.Impl.*;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class AchievementAction extends ActionSupport {
	
	
    //科研奖励
	private static final long serialVersionUID = 1L;
	private DepartmentService departmentService;
	private MajorService majorService;
	private TeacherService teacherService;
	private AchievementService achievementService;
	private TeachAchieveService teachAchieveService;
	// 传到前台下拉列表从数据库中读取显示
	private List<Teacher> teacherList;// 教师
	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> certificateDateList;// 年份
	private List<String> C_jibie;// 获奖级别
	private List<String> C_type;// 获奖类别
	private List<String> C_class;// 获奖等级

	// 从前台获取属性
	private int page = 1;
	private int rows = 10;
	private int tpage = 1;
	private int trows = 10;
	private int totalRows;
	private int totalPage;
	private String certificateNo;// 获奖证书编号
	private String certificateName;// 成果名称
	private String majorId;// 专业Id
	private String departmentId;// 学院Id

	private List<Achievements> achievementslist;
	private List<Achievements> achievelist;
	public List<Teacherachievements> teachAchievelist;
	private Teacher teacher;
	private Teacherachievements teacherachievements;
	private Achievements achievements;
	private AchieveModel amodel = new AchieveModel();
	public int techArcNo;
	private int rol;
	private Exception err;	
	private String errstring;	

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
		amodel=null;
		try {
			page=1;
			rows=10;
			certificateDateList = achievementService.findCertificateDateList();
			C_jibie = achievementService.findCertificateJibieList();
			C_type = achievementService.findCertificateTypeList();
			C_class = achievementService.findCertificateClassList();
			achievementslist = achievementService.findallAchievementsList(page, rows, mno, dno);			
			teacherList = teacherService.findAll(Teacher.class);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			totalRows = achievementService.count(mno, dno);
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

	// 初始化编辑页面
	public String initEdit() {
		if (certificateNo == null) {
			achievements = null;
		} else {
		
			achievements = achievementService.findById(Achievements.class,
					certificateNo);
		}
		return "success";
	}

	// 初始化成员编辑页面
	public String initEditTache() {
       if(techArcNo==0){
    	   teacherachievements=null;
       }else{
    	   teacherachievements = teachAchieveService.findById(
					Teacherachievements.class, techArcNo);
       }
			
		
		return "success";
	}

	// 条件查询成果信息列表
	public String findAchievements() {
		String mno="";
		String dno="";
		try{
			mno=QueryUtil.getUserMno().getMajor().getInMno();
    		dno=QueryUtil.getUserMno().getDepartment().getDno();
        }catch(Exception e){
        	errstring="登录超时！请重新登录！";
        	return "errorstring";
        }
		try {
			if(amodel==null){
				amodel = new AchieveModel();
				amodel.setId("");
				amodel.setName("");
				amodel.setCertificateClass("");
				amodel.setCertificateJibie("");
				amodel.setCertificateType("");
				if(!mno.equals("000000")){
					amodel.setMajorId(mno);
					
				}else if(!dno.equals("00000")&&mno.equals("000000")){
					
					amodel.setDepartmentId(dno);
				}
			}
			if(!mno.equals("000000")){
				amodel.setMajorId(mno);
				
			}else if(!dno.equals("00000")&&mno.equals("000000")){
				
				amodel.setDepartmentId(dno);
			}
			achievementslist = achievementService.findAchievementsList(amodel,
					page, rows);
			
			totalRows = achievementService.countFindAchievements(amodel);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {
			err=e;
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 查询成员信息
	public String findTeachAchieves() {
		initEdit();
		try {
			
			/*teachAchievelist = teachAchieveService
					.findByHQL("from Teacherachievements as ta where ta.achievements.certificateNo ='"
							+ certificateNo+"'");*/
			teachAchievelist=teachAchieveService.findTeachAchiList(teacherachievements, page, rows, certificateNo);
			totalRows=teachAchieveService.findTeachAchi(teacherachievements, certificateNo);
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

	public String list() {

		return "list";
	}

	// 修改成果信息
	public String modifiAchievements() {
		try {
			List<Achievements> s;
			s = achievementService
					.findByHQL("from Achievements as a where a.certificateNo ='"
							+ achievements.getCertificateNo()+"'");
			if (s.size() == 0) {
				
				achievementService.save(achievements);
			} else {
				System.out.println("已经存在！");
				achievementService.update(achievements);
				System.out.print("achievements========="
						+ achievements.getCertificateName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	// 修改成员信息
	public String modifiTeacherachievements() {
		try {
			List<Teacherachievements> s;

			s = teachAchieveService
					.findByHQL("from Teacherachievements as t where t.techArcNo ='"
							+ teacherachievements.getTechArcNo()+"'");
			if(s.size()==0){
				teacherachievements.setAchievements(achievements);
				teachAchieveService.save(teacherachievements);
			}else{
				System.out.println("size"+s.size());
				System.out.println("教师成员列表主键"+teacherachievements.getTechArcNo());
				System.out.println("教师编号"+teacherachievements.getTeacher().getTno());
				System.out.println("获奖排名"+teacherachievements.getTeachRank());
				teachAchieveService.update(teacherachievements);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	
	// 添加
	public String insertAchievements() {
		try {

			achievementService.save(achievements);
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}
	// 添加成员信息
	public String insertTeacherachievements() {
		try {
			System.out.println("添加成功");
			teacherachievements.setAchievements(achievements);
			teachAchieveService.save(teacherachievements);
			
		} catch (Exception e) {
			
			return "error";
		}
		return "success";
	}

	// 删除成果信息
	public String deleteAchievements() {
		try {
			Achievements achievements = achievementService.findById(
					Achievements.class, certificateNo);
			List<Teacherachievements> newachievementsList;
			newachievementsList=teachAchieveService.findByHQL("from Teacherachievements as ta where ta.achievements.certificateNo='"+certificateNo+"'");
			int size=0;
			size=newachievementsList.size();
			System.out.println("Teacherachievementssize"+size);
			if(size!=0){
				for(Teacherachievements t:newachievementsList)
				{
					teachAchieveService.delete(t);
				}
			}
			achievementService.delete(achievements);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}
	// 删除成果成员信息
	public String deleteTeacherachievements() {
		try {
			Teacherachievements tacherachievements = teachAchieveService.findById(
					Teacherachievements.class, techArcNo);
			teachAchieveService.delete(tacherachievements);
		} catch (Exception e) {
			
			return "error";
		}

		return "success";
	}
	
	public Teacherachievements getTeacherachievements() {
		return teacherachievements;
	}

	public void setTeacherachievements(Teacherachievements teacherachievements) {
		this.teacherachievements = teacherachievements;
	}

	public int getTechArcNo() {
		return techArcNo;
	}

	public void setTechArcNo(int techArcNo) {
		this.techArcNo = techArcNo;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeachAchieveService getTeachAchieveService() {
		return teachAchieveService;
	}

	public void setTeachAchieveService(TeachAchieveService teachAchieveService) {
		this.teachAchieveService = teachAchieveService;
	}

	public List<Teacherachievements> getTeachAchievelist() {
		return teachAchievelist;
	}

	public void setTeachAchievelist(List<Teacherachievements> teachAchievelist) {
		this.teachAchievelist = teachAchievelist;
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

	public List<String> getCertificateDateList() {
		return certificateDateList;
	}

	public void setCertificateDateList(List<String> certificateDateList) {
		this.certificateDateList = certificateDateList;
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

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
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

	public List<Achievements> getAchievementslist() {
		return achievementslist;
	}

	public void setAchievementslist(List<Achievements> achievementslist) {
		this.achievementslist = achievementslist;
	}

	public Achievements getAchievements() {
		return achievements;
	}

	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}

	public AchieveModel getAmodel() {
		return amodel;
	}

	public void setAmodel(AchieveModel amodel) {
		this.amodel = amodel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getC_jibie() {
		return C_jibie;
	}

	public void setC_jibie(List<String> cJibie) {
		C_jibie = cJibie;
	}

	public List<String> getC_type() {
		return C_type;
	}

	public void setC_type(List<String> cType) {
		C_type = cType;
	}

	public List<String> getC_class() {
		return C_class;
	}

	public void setC_class(List<String> cClass) {
		C_class = cClass;
	}

	public List<Achievements> getAchievelist() {
		return achievelist;
	}

	public void setAchievelist(List<Achievements> achievelist) {
		this.achievelist = achievelist;
	}

	public AchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
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
	public Exception getErr() {
		return err;
	}
	public void setErr(Exception err) {
		this.err = err;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}
}
