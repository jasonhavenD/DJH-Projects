package cn.edu.nwsuaf.Action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;
import cn.edu.nwsuaf.Model.PracticecoursesummaryModel;
import cn.edu.nwsuaf.Model.StudentculturesummaryModel;
import cn.edu.nwsuaf.Model.TeacherinfosummaryModel;
import cn.edu.nwsuaf.Model.TeacherresearchSummaryModel;
import cn.edu.nwsuaf.Service.Impl.BaseServiceImpl;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.ExpertscoreService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.SummaryService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Practicecoursesummary;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherinfosummary;
import cn.edu.nwsuaf.bean.Teacherresearchsummary;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;

public class SummaryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private BaseServiceImpl<Practicecoursesummary> baseService;
	private SummaryService summaryService;
	private DepartmentService departmentService;
	private MajorService majorService;
	private FileinfoattachmentService fiaService;
	private ExpertscoreService expertscoreservice;
	private TeacherService teacherService;

	private List<Department> departmentList;// 学院
	private List<Major> majorList;// 专业
	private List<String> yearList;// 年份
	private List<Teacherinfosummary> teacherinfosummaryList;
	private List<Teacherresearchsummary> teacherresearchsummaryList;
	private List<Studentculturesummary> studentculturesummaryList;
	private List<Practicecoursesummary> practicecoursesummaryList;
	private List<FileinfoAttachment> fiaList;// 定性列表
	private List<Teacher> teacherList;
	private List<Teacherinfosummary> teacherinfosummaryCountList;//图形显示
	private List<Teacherresearchsummary> trAllList;
	private Teacherinfosummary teacherinfosummary;
	private Teacherresearchsummary teacherresearchsummary;
	private Studentculturesummary studentculturesummary;
	private Practicecoursesummary practicecoursesummary;

	// 前台获取属性
	private int page = 1;
	private int rows = 10;
	private int totalRows;
	private int totalPage;
	private String majorId;
	private String departmentId;
	private TeacherinfosummaryModel teacherinfosummaryModel = new TeacherinfosummaryModel();
	private TeacherresearchSummaryModel teacherresearchsummaryModel = new TeacherresearchSummaryModel();
	private StudentculturesummaryModel studentculturesummaryModel = new StudentculturesummaryModel();
	private PracticecoursesummaryModel practicecoursesummaryModel = new PracticecoursesummaryModel();
	private int pnumber;
	private boolean flag;
	private HttpServletRequest request;
	private String result;
	private int rol;
	private String errstring;
	private FileinfoAttachment fia;
	private FileinfoAttachmentModel fiamodel = new FileinfoAttachmentModel();
	private JSONArray jsonArray;
	private JSONArray jsonArray1;
	private JSONObject json=new JSONObject();
	private String num;
	private String major;
	private String coll;
	private String year;
	// 统计计算
	public String summary() {
		try {
			summaryService.summary();
			expertSummary();
			// 师生比
			teacherinfosummaryList = summaryService
					.findAll(Teacherinfosummary.class);
			int i = 0;
			for (Teacherinfosummary t : teacherinfosummaryList) {
				i = i + 1;
				if (t.getStuNumber() != null && t.getStuNumber() != 0) {
					t.setStudentsTeachersRatio((float) (t
							.getProfessionaTteacherNumbers().floatValue() / t
							.getStuNumber().floatValue()));
					summaryService.update(t);
				}
			}
			// 实践教学情况数据null的值置为0
			practicecoursesummaryList = baseService
					.findAll(Practicecoursesummary.class);
			for (Practicecoursesummary p : practicecoursesummaryList) {
				if (p.getPlanChangeNumber() == null) {
					p.setPlanChangeNumber(0);
				}
				if (p.getProfessorTeachTime() == null) {
					p.setProfessorTeachTime(0);
				}
				if (p.getInprofessorTteachTime() == null) {
					p.setInprofessorTteachTime(0);
				}
				if (p.getTeachTotalTime() == null) {
					p.setTeachTotalTime(0);
				}
				if (p.getTotalTeachCost() == null) {
					p.setTotalTeachCost(Float.valueOf((float) 0.00));
				}
				if (p.getCourseTotaoNum() == null) {
					p.setCourseTotaoNum(0);
				}
				if (p.getOpenCourseTotaoNum() == null) {
					p.setOpenCourseTotaoNum(0);
				}
				if (p.getGoodCourseTotaoNum() == null) {
					p.setGoodCourseTotaoNum(0);
				}
				if (p.getPracticeBaseTotalNum() == null) {
					p.setPracticeBaseTotalNum(0);
				}
				if (p.getStudentPersistProjectNum() == null) {
					p.setStudentPersistProjectNum(0);
				}
				baseService.update(p);
			}
			System.out.println("更新统计信息完成!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "summary";
	}

	// 定性统计计算
	public String expertSummary() {
		try {
			fiaList = fiaService.findAll(FileinfoAttachment.class);
			for (FileinfoAttachment f : fiaList) {
				List<Expertscore> eList = new ArrayList<Expertscore>();
				List<Expertscore> enewList = new ArrayList<Expertscore>();
				eList = expertscoreservice
						.findByHQL("from Expertscore as e where fileinfoAttachment.attachmentId='"
								+ f.getAttachmentId() + "'");
				for (Expertscore e : eList) {
					if (e.getAsseisingValue() != null
							&& e.getAsseisingValue() > (float) 0) {
						enewList.add(e);
					}
				}
				float totalscore = 0;
				for (Expertscore enew : enewList) {
					totalscore += enew.getAsseisingValue();
				}
				float averagescore = 0;
				if (enewList.size() != 0) {
					averagescore = totalscore / enewList.size();
				}
				//System.out.println(averagescore);
				BigDecimal n = new BigDecimal(averagescore);
				double n2 = n.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				//System.out.println(n2+"   "+Float.parseFloat(String.valueOf(n2)));
				f.setAsseisingValue(Float.parseFloat(String.valueOf(n2)));
				fiaService.update(f);
				//System.out.println("aaa");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 定性统计初始化
	public String initSearch() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		fiamodel = null;
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = fiaService.findYearList();
			fiaList = fiaService.findallFileinfoAttachmentList(page, rows, mno,
					dno);
			totalRows = fiaService.count(mno, dno);
			System.out.println("init" + totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "ExpertsummaryList";

	}

	// 定性统计查询
	public String findFia() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			System.out.println("当前页数是==" + page);
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findAll(Major.class);
			yearList = fiaService.findYearList();
			if (!mno.equals("000000")) {
				fiamodel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				fiamodel.setDepartmentId(dno);
			}

			fiaList = fiaService.findFiaList(fiamodel, page, rows);
			totalRows = fiaService.countFindFia(fiamodel);
			System.out.println("totalRows" + totalRows);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
			System.out.println(totalPage);
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "findSExpertsummaryList";
	}

	// 专业教师情况统计列表
	public String TeacherinfosummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherinfosummary");
			teacherinfosummaryList = summaryService
					.getAllTeacherinfosummaryList(teacherinfosummary, page,
							rows,mno,dno);
			for (Teacherinfosummary t : teacherinfosummaryList) {
				Float f = new Float((float) (t.getStuNumber().floatValue() / t
						.getProfessionaTteacherNumbers()));
				t.setStudentsTeachersRatio((float) (Math.round(f * 10)) / 10);
			}
			totalRows = summaryService
					.countTeacherinfosummaryList(teacherinfosummary,mno,dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {

			return "error";
		}
		return "TeacherinfosummaryList";
	}

	// 专业教师情况统计列表图形显示-初始化
	public String findTeacherinfosummaryList() {

		try {
			departmentList = departmentService.findAll(Department.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherinfosummary");
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 专业教师情况统计列表图形显示-条件查询
	public String findTeacherinfosummaryCount() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 专业教师科研教研情况统计列表
	public String TeacherresearchsummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		
		try {
			page = 1;
			rows = 5;
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherresearchsummary");
			teacherresearchsummaryList = summaryService
					.getAllTeacherresearchsummaryList(teacherresearchsummary,
							page, rows,mno,dno);
			totalRows = summaryService
					.countTeacherresearchsummaryList(teacherresearchsummary,mno,dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {

			return "error";
		}
		return "TeacherresearchsummaryList";
	}

	// 学生培养情况统计列表
	public String StudentculturesummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Studentculturesummary");
			studentculturesummaryList = summaryService
					.getAllStudentculturesummaryList(studentculturesummary,
							page, rows,mno,dno);
			totalRows = summaryService
					.countStudentculturesummaryList(studentculturesummary,mno,dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {

			return "error";
		}
		return "StudentculturesummaryList";
	}

	// 实践课程情况统计列表
	public String PracticecoursesummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			page = 1;
			rows = 10;
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Practicecoursesummary");
			practicecoursesummaryList = summaryService
					.getAllPracticecoursesummaryList(practicecoursesummary,
							page, rows,mno,dno);
			totalRows = summaryService
					.countPracticecoursesummaryList(practicecoursesummary,mno,dno);
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (Exception e) {

			return "error";
		}
		return "PracticecoursesummaryList";
	}

	// 专业教师基本情况多条件查询
	@SuppressWarnings("unchecked")
	public String findSTeacherinfosummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherinfosummary");
			if (!mno.equals("000000")) {
				teacherinfosummaryModel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				teacherinfosummaryModel.setDepartmentId(dno);
			}

			teacherinfosummaryList = (List<Teacherinfosummary>) summaryService
					.findSTableList(teacherinfosummaryModel,
							"Teacherinfosummary", page, rows);
			for (Teacherinfosummary t : teacherinfosummaryList) {
				if (!t.getProfessionaTteacherNumbers().equals(0)) {
					Float f = new Float(
							(float) (t.getStuNumber().floatValue() / t
									.getProfessionaTteacherNumbers()));
					t
							.setStudentsTeachersRatio((float) (Math
									.round(f * 10)) / 10);
				}
			}
			totalRows = summaryService.countFindSTeacherresearchsummary(
					teacherinfosummaryModel, "Teacherinfosummary");
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "findSTeacherinfosummaryList";
	}

	// 教学科研情况多条件查询信息
	@SuppressWarnings("unchecked")
	public String findSTeacherresearchsummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherresearchsummary");
			if (!mno.equals("000000")) {
				teacherresearchsummaryModel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				teacherresearchsummaryModel.setDepartmentId(dno);
			}

			teacherresearchsummaryList = (List<Teacherresearchsummary>) summaryService
					.findSTableList(teacherresearchsummaryModel,
							"Teacherresearchsummary", page, rows);
			totalRows = summaryService.countFindSTeacherresearchsummary(
					teacherresearchsummaryModel, "Teacherresearchsummary");
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "findSTeacherresearchsummaryList";
	}

	// 学生培养情况多条件查询信息
	@SuppressWarnings("unchecked")
	public String findSStudentculturesummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Studentculturesummary");
			if (!mno.equals("000000")) {
				studentculturesummaryModel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				studentculturesummaryModel.setDepartmentId(dno);
			}

			studentculturesummaryList = (List<Studentculturesummary>) summaryService
					.findSTableList(studentculturesummaryModel,
							"Studentculturesummary", page, rows);
			totalRows = summaryService.countFindSTeacherresearchsummary(
					studentculturesummaryModel, "Studentculturesummary");
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "findSStudentculturesummaryList";
	}

	// 实践教学多条件查询信息
	@SuppressWarnings("unchecked")
	public String findSPracticecoursesummaryList() {
		String mno = "";
		String dno = "";
		try {
			mno = QueryUtil.getUserMno().getMajor().getInMno();
			dno = QueryUtil.getUserMno().getDepartment().getDno();
		} catch (Exception e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		try {
			departmentList = departmentService.findAll(Department.class);
			// majorList = majorService.findAll(Major.class);
			majorList = majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Practicecoursesummary");
			if (!mno.equals("000000")) {
				practicecoursesummaryModel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				practicecoursesummaryModel.setDepartmentId(dno);
			}

			practicecoursesummaryList = (List<Practicecoursesummary>) summaryService
					.findSTableList(practicecoursesummaryModel,
							"Practicecoursesummary", page, rows);
			totalRows = summaryService.countFindSTeacherresearchsummary(
					practicecoursesummaryModel, "Practicecoursesummary");
			if (totalRows % rows == 0) {
				totalPage = totalRows / rows;
			} else {
				totalPage = totalRows == 0 ? 1 : (totalRows / rows + 1);
			}
		} catch (ServiceException e) {

			return "error";
		}
		return "findSPracticecoursesummaryList";
	}
	// 专业教师情况统计列表图形显示-初始化
	public String findSTeacherresearchsummaryCountList(){
		
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList=majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherresearchsummary");
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//教学科研情况多条件查询-图形显示
	@SuppressWarnings("unchecked")
	public String findSTeacherresearchsummaryCount(){
		String mno = QueryUtil.getUserMno().getMajor().getInMno();
		String dno = QueryUtil.getUserMno().getDepartment().getDno();
		try {
			departmentList = departmentService.findAll(Department.class);
			majorList=majorService.findSummaryMajor(Major.class);
			yearList = summaryService.findYearList("Teacherresearchsummary");
			trAllList=summaryService.findAllTR(Teacherresearchsummary.class);
			if (!mno.equals("000000")) {
				teacherresearchsummaryModel.setMajorId(mno);

			} else if (!dno.equals("00000") && mno.equals("000000")) {

				teacherresearchsummaryModel.setDepartmentId(dno);
			}
			teacherresearchsummaryList = (List<Teacherresearchsummary>) summaryService.findSummaryCountList(major,coll,year, "Teacherresearchsummary");
			//1.科研论文EI/SCI/SSCI
			int sum1 = 0, sum2 = 0,sum3 = 0,sum4 = 0, sum5= 0,sum6 = 0,sum7 = 0, sum8 = 0,sum9 = 0,sum10 = 0, sum11 = 0,sum12 = 0;
			int sum13 = 0, sum14 = 0,sum15 = 0,sum16 = 0, sum17 = 0,sum18 = 0,sum19 = 0, sum20 = 0,sum21 = 0,sum22 = 0, sum23 = 0,sum24 = 0;
			int rsum1 = 0, rsum2 = 0,rsum3 = 0,rsum4 = 0, rsum5= 0,rsum6 = 0,rsum7 = 0, rsum8 = 0,rsum9 = 0,rsum10 = 0, rsum11 = 0,rsum12 = 0,rsum13 = 0, rsum14 = 0,rsum15 = 0,rsum16 = 0, rsum17 = 0,rsum18 = 0;
			int count1 = 0,count2 = 0,count3 = 0,count4 = 0,count5 = 0,count6 = 0,count7 = 0,count8 = 0,count9 = 0;
			int count10 = 0,count11 = 0,count12 = 0,count13 = 0,count14 = 0,count15 = 0,count16 = 0,count17 = 0,count18 = 0;
			int all1=0,all2=0,all3=0,all4=0,all5=0,all6=0,all7=0;
			jsonArray=new JSONArray();
			for(int i=0;i<trAllList.size();i++){
				sum1+=trAllList.get(i).getResearchPaperNumber1();
				sum2+=trAllList.get(i).getResearchPaperNumber2();
				sum3+=trAllList.get(i).getResearchPaperNumber3();
				sum4+=trAllList.get(i).getResearchProjectNumber1();
				sum5+=trAllList.get(i).getResearchProjectNumber2();
				sum6+=trAllList.get(i).getResearchProjectNumber3();
				sum7+=trAllList.get(i).getEducationProjectNumber1();
				sum8+=trAllList.get(i).getEducationProjectNumber2();
				sum9+=trAllList.get(i).getEducationProjectNumber3();
				sum10+=trAllList.get(i).getEducationPaperNumber1();
				sum11+=trAllList.get(i).getEducationPaperNumber2();
				sum12+=trAllList.get(i).getEducationPaperNumber3();
				sum13+=trAllList.get(i).getQualitylEngineeringNumber1();
				sum14+=trAllList.get(i).getQualitylEngineeringNumber2();
				sum15+=trAllList.get(i).getQualitylEngineeringNumber3();
				//教学成果奖
				sum16+=trAllList.get(i).getTeachingAchievementNumber11();
				sum17+=trAllList.get(i).getTeachingAchievementNumber12();
				sum18+=trAllList.get(i).getTeachingAchievementNumber13();
				sum19+=trAllList.get(i).getTeachingAchievementNumber21();
				sum20+=trAllList.get(i).getTeachingAchievementNumber22();
				sum21+=trAllList.get(i).getTeachingAchievementNumber23();
				sum22+=trAllList.get(i).getTeachingAchievementNumber31();
				sum23+=trAllList.get(i).getTeachingAchievementNumber32();
				sum24+=trAllList.get(i).getTeachingAchievementNumber33();
				//科研奖励
				rsum1+=trAllList.get(i).getResearchAwardNumber111();
				rsum2+=trAllList.get(i).getResearchAwardNumber112();
				rsum3+=trAllList.get(i).getResearchAwardNumber113();
				rsum4+=trAllList.get(i).getResearchAwardNumber121();
				rsum5+=trAllList.get(i).getResearchAwardNumber122();
				rsum6+=trAllList.get(i).getResearchAwardNumber123();
				rsum7+=trAllList.get(i).getResearchAwardNumber131();
				rsum8+=trAllList.get(i).getResearchAwardNumber132();
				rsum9+=trAllList.get(i).getResearchAwardNumber133();
				rsum10+=trAllList.get(i).getResearchAwardNumber211();
				rsum11+=trAllList.get(i).getResearchAwardNumber212();
				rsum12+=trAllList.get(i).getResearchAwardNumber213();
				rsum13+=trAllList.get(i).getResearchAwardNumber221();
				rsum14+=trAllList.get(i).getResearchAwardNumber222();
				rsum15+=trAllList.get(i).getResearchAwardNumber223();
				rsum16+=trAllList.get(i).getResearchAwardNumber231();
				rsum17+=trAllList.get(i).getResearchAwardNumber232();
				rsum18+=trAllList.get(i).getResearchAwardNumber233();
			}
			all1=sum1+sum2+sum3;
			all2=sum4+sum5+sum6;
			all3=sum7+sum8+sum9;
			all4=sum10+sum11+sum12;
			all5=sum13+sum14+sum15;
			all6=sum16+sum17+sum18+sum19+sum20+sum21+sum22+sum23+sum24;
			all7=rsum1+rsum2+rsum3+rsum4+rsum5+rsum6+rsum7+rsum8+rsum9+rsum10+rsum11+rsum12+rsum13+rsum8+rsum14+rsum15+rsum16+rsum17;
			System.out.println("all1=="+all1);
			int num1=Integer.parseInt(num);
			System.out.println("num1  ="+num1);
			switch(num1){
			case 1:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getResearchPaperNumber1();
					count2+=teacherresearchsummaryList.get(i).getResearchPaperNumber2();
					count3+=teacherresearchsummaryList.get(i).getResearchPaperNumber3();
				}
				JSONObject js=new JSONObject();
				js.put("ResearchPaperNumber1", "SCI");
				js.put("count1", (double)count1/(double)all1);
				System.out.println("SCI="+count1+"  "+(double)count1/(double)all1);
				js.put("ResearchPaperCount1", "SCI");
				js.put("sum1", count1);
				js.put("ResearchPaperNumber2", "A类");
				js.put("count2", (double)count2/(double)all1);
				js.put("ResearchPaperCount2", "A类");
				js.put("sum2", count2);
				System.out.println("A类="+count2+"  "+(double)count2/(double)all1);
				js.put("ResearchPaperNumber3", "B类");
				js.put("count3", (double)count3/(double)all1);
				System.out.println("B类="+count3+"  "+(double)count3/(double)all1);
				js.put("ResearchPaperCount3", "B类");
				js.put("sum3", count3);
				jsonArray.add(js);
				json.put("jsonarray", jsonArray);
				break;
			case 2:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getResearchProjectNumber1();
					count2+=teacherresearchsummaryList.get(i).getResearchProjectNumber2();
					count3+=teacherresearchsummaryList.get(i).getResearchProjectNumber3();
				}
				JSONObject js1=new JSONObject();
				js1.put("ResearchPaperNumber1", "国家级");
				js1.put("count1", (double)count1/(double)all2);
				js1.put("ResearchPaperCount1", "国家级");
				js1.put("sum1", count1);
				js1.put("ResearchPaperNumber2", "省级");
				js1.put("count2", (double)count2/(double)all2);
				js1.put("ResearchPaperCount2", "省级");
				js1.put("sum2", count2);
				js1.put("ResearchPaperNumber3", "其他类别");
				js1.put("count3", (double)count3/(double)all2);
				js1.put("ResearchPaperCount3", "其他类别");
				js1.put("sum3", count3);
				jsonArray.add(js1);
				json.put("jsonarray", jsonArray);
				break;
			case 3:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getEducationProjectNumber1();
					count2+=teacherresearchsummaryList.get(i).getEducationProjectNumber2();
					count3+=teacherresearchsummaryList.get(i).getEducationProjectNumber3();
				}
				JSONObject js2=new JSONObject();
				js2.put("ResearchPaperNumber1", "A类");
				js2.put("count1", (double)count1/(double)all3);
				js2.put("ResearchPaperCount1", "A类");
				js2.put("sum1", count1);
				js2.put("ResearchPaperNumber2", "B类");
				js2.put("count2", (double)count2/(double)all3);
				js2.put("ResearchPaperCount2", "B类");
				js2.put("sum2", count2);
				js2.put("ResearchPaperNumber3", "公开发表");
				js2.put("count3", (double)count3/(double)all3);
				js2.put("ResearchPaperCount3", "公开发表");
				js2.put("sum3", count3);
				jsonArray.add(js2);
				json.put("jsonarray", jsonArray);
				break;
			case 4:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getEducationPaperNumber1();
					count2+=teacherresearchsummaryList.get(i).getEducationPaperNumber2();
					count3+=teacherresearchsummaryList.get(i).getEducationPaperNumber3();
				}
				JSONObject js3=new JSONObject();
				js3.put("ResearchPaperNumber1", "省级");
				js3.put("count1", (double)count1/(double)all4);
				js3.put("ResearchPaperCount1", "省级");
				js3.put("sum1", count1);
				js3.put("ResearchPaperNumber2", "校级");
				js3.put("count2", (double)count2/(double)all4);
				js3.put("ResearchPaperCount2", "校级");
				js3.put("sum2", count2);
				js3.put("ResearchPaperNumber3", "其他");
				js3.put("count3", (double)count3/(double)all4);
				js3.put("ResearchPaperCount3", "其他");
				js3.put("sum3", count3);
				jsonArray.add(js3);
				json.put("jsonarray", jsonArray);
				break;
			case 5:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getQualitylEngineeringNumber1();
					count2+=teacherresearchsummaryList.get(i).getQualitylEngineeringNumber2();
					count3+=teacherresearchsummaryList.get(i).getQualitylEngineeringNumber3();
				}
				JSONObject js4=new JSONObject();
				js4.put("ResearchPaperNumber1", "国家级");
				js4.put("count1", (double)count1/(double)all5);
				js4.put("ResearchPaperCount1", "国家级");
				js4.put("sum1", count1);
				js4.put("ResearchPaperNumber2", "省级");
				js4.put("count2", (double)count2/(double)all5);
				js4.put("ResearchPaperCount2", "省级");
				js4.put("sum2", count2);
				js4.put("ResearchPaperNumber3", "校级");
				js4.put("count3", (double)count3/(double)all5);
				js4.put("ResearchPaperCount3", "校级");
				js4.put("sum3", count3);
				jsonArray.add(js4);
				json.put("jsonarray", jsonArray);
				break;
			case 6:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber11();
					count2+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber12();
					count3+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber13();
					count4+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber21();
					count5+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber22();
					count6+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber23();
					count7+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber31();
					count8+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber32();
					count9+=teacherresearchsummaryList.get(i).getTeachingAchievementNumber33();
				}
				JSONObject js5=new JSONObject();
				js5.put("ResearchPaperNumber1", "国家特等奖");
				js5.put("count1", (double)count1/(double)all6);
				js5.put("ResearchPaperCount1", "国家特等奖");
				js5.put("sum1", count1);
				js5.put("ResearchPaperNumber2", "国家一等奖");
				js5.put("count2", (double)count2/(double)all6);
				js5.put("ResearchPaperCount2", "国家一等奖");
				js5.put("sum2", count2);
				js5.put("ResearchPaperNumber3", "国家二等奖");
				js5.put("count3", (double)count3/(double)all6);
				js5.put("ResearchPaperCount3", "国家二等奖");
				js5.put("sum3", count3);
				js5.put("ResearchPaperNumber4", "省级特等奖");
				js5.put("count4", (double)count4/(double)all6);
				js5.put("ResearchPaperCount4", "省级特等奖");
				js5.put("sum4", count4);
				js5.put("ResearchPaperNumber5", "省级一等奖");
				js5.put("count5", (double)count5/(double)all6);
				js5.put("ResearchPaperCount5", "省级一等奖");
				js5.put("sum5", count5);
				js5.put("ResearchPaperNumber6", "省级二等奖");
				js5.put("count6", (double)count6/(double)all6);
				js5.put("ResearchPaperCount6", "省级二等奖");
				js5.put("sum6", count6);
				js5.put("ResearchPaperNumber7", "校级特等奖");
				js5.put("count7", (double)count7/(double)all6);
				js5.put("ResearchPaperCount7", "校特等奖");
				js5.put("sum7", count7);
				js5.put("ResearchPaperNumber8", "校级一等奖");
				js5.put("count8", (double)count8/(double)all6);
				js5.put("ResearchPaperCount8", "校级一等奖");
				js5.put("sum8", count8);
				js5.put("ResearchPaperNumber9", "校级二等奖");
				js5.put("count9", (double)count9/(double)all6);
				js5.put("ResearchPaperCount9", "校级二等奖");
				js5.put("sum9", count9);
				jsonArray.add(js5);
				json.put("jsonarray", jsonArray);
				break;
			case 7:
				for(int i=0;i<teacherresearchsummaryList.size();i++){
					count1+=teacherresearchsummaryList.get(i).getResearchAwardNumber111();
					count2+=teacherresearchsummaryList.get(i).getResearchAwardNumber112();
					count3+=teacherresearchsummaryList.get(i).getResearchAwardNumber113();
					count4+=teacherresearchsummaryList.get(i).getResearchAwardNumber121();
					count5+=teacherresearchsummaryList.get(i).getResearchAwardNumber122();
					count6+=teacherresearchsummaryList.get(i).getResearchAwardNumber123();
					count7+=teacherresearchsummaryList.get(i).getResearchAwardNumber131();
					count8+=teacherresearchsummaryList.get(i).getResearchAwardNumber132();
					count9+=teacherresearchsummaryList.get(i).getResearchAwardNumber133();
					count10+=teacherresearchsummaryList.get(i).getResearchAwardNumber211();
					count11+=teacherresearchsummaryList.get(i).getResearchAwardNumber212();
					count12+=teacherresearchsummaryList.get(i).getResearchAwardNumber213();
					count13+=teacherresearchsummaryList.get(i).getResearchAwardNumber221();
					count14+=teacherresearchsummaryList.get(i).getResearchAwardNumber222();
					count15+=teacherresearchsummaryList.get(i).getResearchAwardNumber223();
					count16+=teacherresearchsummaryList.get(i).getResearchAwardNumber231();
					count17+=teacherresearchsummaryList.get(i).getResearchAwardNumber232();
					count18+=teacherresearchsummaryList.get(i).getResearchAwardNumber233();
				}
				JSONObject js6=new JSONObject();
				js6.put("ResearchPaperNumber1", "国一等第一");
				js6.put("count1", (double)count1/(double)all7);
				js6.put("ResearchPaperCount1", "国一等第一");
				js6.put("sum1", count1);
				js6.put("ResearchPaperNumber2", "国一等第二");
				js6.put("count2", (double)count2/(double)all7);
				js6.put("ResearchPaperCount2", "国一等第二");
				js6.put("sum2", count2);
				js6.put("ResearchPaperNumber3", "国一等第三");
				js6.put("count3", (double)count3/(double)all7);
				js6.put("ResearchPaperCount3", "国一等第三");
				js6.put("sum3", count3);
				js6.put("ResearchPaperNumber4", "国二等第一");
				js6.put("count4", (double)count4/(double)all7);
				js6.put("ResearchPaperCount4", "国二等第一");
				js6.put("sum4", count4);
				js6.put("ResearchPaperNumber5", "国二等第二");
				js6.put("count5", (double)count5/(double)all7);
				js6.put("ResearchPaperCount5", "国二等第二");
				js6.put("sum5", count5);
				js6.put("ResearchPaperNumber6", "国二等第三");
				js6.put("count6", (double)count6/(double)all7);
				js6.put("ResearchPaperCount6", "国二等第三");
				js6.put("sum6", count6);
				js6.put("ResearchPaperNumber7", "国三等第一");
				js6.put("count7", (double)count7/(double)all7);
				js6.put("ResearchPaperCount7", "国三等第一");
				js6.put("sum7", count7);
				js6.put("ResearchPaperNumber8", "国三等第二");
				js6.put("count8", (double)count8/(double)all7);
				js6.put("ResearchPaperCount8", "国三等第二");
				js6.put("sum8", count8);
				js6.put("ResearchPaperNumber9", "国三等第三");
				js6.put("count9", (double)count9/(double)all7);
				js6.put("ResearchPaperCount9", "国三等第三");
				js6.put("sum9", count9);
				js6.put("ResearchPaperNumber10", "省一等第一");
				js6.put("count10", (double)count10/(double)all7);
				js6.put("ResearchPaperCount10", "省一等第一");
				js6.put("sum10", count10);
				js6.put("ResearchPaperNumber11", "省一等第二");
				js6.put("count11", (double)count11/(double)all7);
				js6.put("ResearchPaperCount11", "省一等第二");
				js6.put("sum11", count11);
				js6.put("ResearchPaperNumber12", "省一等第三");
				js6.put("count12", (double)count12/(double)all7);
				js6.put("ResearchPaperCount12", "省一等第三");
				js6.put("sum12", count12);
				js6.put("ResearchPaperNumber13", "省二等第一");
				js6.put("count13", (double)count13/(double)all7);
				js6.put("ResearchPaperCount13", "省二等第一");
				js6.put("sum13", count13);
				js6.put("ResearchPaperNumber14", "省二等第二");
				js6.put("count14", (double)count14/(double)all7);
				js6.put("ResearchPaperCount14", "省二等第二");
				js6.put("sum14", count14);
				js6.put("ResearchPaperNumber15", "二等第三");
				js6.put("count15", (double)count15/(double)all7);
				js6.put("ResearchPaperCount15", "省二等第三");
				js6.put("sum15", count15);
				js6.put("ResearchPaperNumber16", "省三等第一");
				js6.put("count16", (double)count16/(double)all7);
				js6.put("ResearchPaperCount16", "省三等第一");
				js6.put("sum16", count16);
				js6.put("ResearchPaperNumber17", "省三等第二名");
				js6.put("count17", (double)count17/(double)all7);
				js6.put("ResearchPaperCount17", "省三等奖二");
				js6.put("sum17", count17);
				js6.put("ResearchPaperNumber18", "省三等第三");
				js6.put("count18", (double)count18/(double)all7);
				js6.put("ResearchPaperCount18", "省三等第三");
				js6.put("sum18", count18);
				jsonArray.add(js6);
				json.put("jsonarray", jsonArray);
				break;
				
			}
		} catch (ServiceException e) {
			setErrstring("登录超时！请安全退出再重新登录！");
			return "errorstring";
		}
		return "success";
	}

	// get、set方法
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

	public SummaryService getSummaryService() {
		return summaryService;
	}

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public List<Teacherinfosummary> getTeacherinfosummaryList() {
		return teacherinfosummaryList;
	}

	public void setTeacherinfosummaryList(
			List<Teacherinfosummary> teacherinfosummaryList) {
		this.teacherinfosummaryList = teacherinfosummaryList;
	}

	public List<Teacherresearchsummary> getTeacherresearchsummaryList() {
		return teacherresearchsummaryList;
	}

	public void setTeacherresearchsummaryList(
			List<Teacherresearchsummary> teacherresearchsummaryList) {
		this.teacherresearchsummaryList = teacherresearchsummaryList;
	}

	public List<Studentculturesummary> getStudentculturesummaryList() {
		return studentculturesummaryList;
	}

	public void setStudentculturesummaryList(
			List<Studentculturesummary> studentculturesummaryList) {
		this.studentculturesummaryList = studentculturesummaryList;
	}

	public Teacherinfosummary getTeacherinfosummary() {
		return teacherinfosummary;
	}

	public void setTeacherinfosummary(Teacherinfosummary teacherinfosummary) {
		this.teacherinfosummary = teacherinfosummary;
	}

	public Teacherresearchsummary getTeacherresearchsummary() {
		return teacherresearchsummary;
	}

	public void setTeacherresearchsummary(
			Teacherresearchsummary teacherresearchsummary) {
		this.teacherresearchsummary = teacherresearchsummary;
	}

	public Studentculturesummary getStudentculturesummary() {
		return studentculturesummary;
	}

	public void setStudentculturesummary(
			Studentculturesummary studentculturesummary) {
		this.studentculturesummary = studentculturesummary;
	}

	public List<Practicecoursesummary> getPracticecoursesummaryList() {
		return practicecoursesummaryList;
	}

	public void setPracticecoursesummaryList(
			List<Practicecoursesummary> practicecoursesummaryList) {
		this.practicecoursesummaryList = practicecoursesummaryList;
	}

	public Practicecoursesummary getPracticecoursesummary() {
		return practicecoursesummary;
	}

	public void setPracticecoursesummary(
			Practicecoursesummary practicecoursesummary) {
		this.practicecoursesummary = practicecoursesummary;
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

	public TeacherinfosummaryModel getTeacherinfosummaryModel() {
		return teacherinfosummaryModel;
	}

	public void setTeacherinfosummaryModel(
			TeacherinfosummaryModel teacherinfosummaryModel) {
		this.teacherinfosummaryModel = teacherinfosummaryModel;
	}

	public TeacherresearchSummaryModel getTeacherresearchsummaryModel() {
		return teacherresearchsummaryModel;
	}

	public void setTeacherresearchsummaryModel(
			TeacherresearchSummaryModel teacherresearchsummaryModel) {
		this.teacherresearchsummaryModel = teacherresearchsummaryModel;
	}

	public StudentculturesummaryModel getStudentculturesummaryModel() {
		return studentculturesummaryModel;
	}

	public void setStudentculturesummaryModel(
			StudentculturesummaryModel studentculturesummaryModel) {
		this.studentculturesummaryModel = studentculturesummaryModel;
	}

	public PracticecoursesummaryModel getPracticecoursesummaryModel() {
		return practicecoursesummaryModel;
	}

	public void setPracticecoursesummaryModel(
			PracticecoursesummaryModel practicecoursesummaryModel) {
		this.practicecoursesummaryModel = practicecoursesummaryModel;
	}

	@SuppressWarnings("unchecked")
	public BaseServiceImpl getBaseService() {
		return baseService;
	}

	@SuppressWarnings("unchecked")
	public void setBaseService(BaseServiceImpl baseService) {
		this.baseService = baseService;
	}

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}

	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}

	public List<FileinfoAttachment> getFiaList() {
		return fiaList;
	}

	public void setFiaList(List<FileinfoAttachment> fiaList) {
		this.fiaList = fiaList;
	}

	public FileinfoAttachment getFia() {
		return fia;
	}

	public void setFia(FileinfoAttachment fia) {
		this.fia = fia;
	}

	public FileinfoAttachmentModel getFiamodel() {
		return fiamodel;
	}

	public void setFiamodel(FileinfoAttachmentModel fiamodel) {
		this.fiamodel = fiamodel;
	}

	public ExpertscoreService getExpertscoreservice() {
		return expertscoreservice;
	}

	public void setExpertscoreservice(ExpertscoreService expertscoreservice) {
		this.expertscoreservice = expertscoreservice;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public void setErrstring(String errstring) {
		this.errstring = errstring;
	}

	public String getErrstring() {
		return errstring;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public JSONArray getJsonArray1() {
		return jsonArray1;
	}

	public void setJsonArray1(JSONArray jsonArray1) {
		this.jsonArray1 = jsonArray1;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getColl() {
		return coll;
	}

	public void setColl(String coll) {
		this.coll = coll;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

}
