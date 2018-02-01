package cn.edu.nwsuaf.comAction;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Model.AchieveModel;
import cn.edu.nwsuaf.Model.AddmissionsModel;
import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Model.CommunicationsituModel;
import cn.edu.nwsuaf.Model.CompetitionModel;
import cn.edu.nwsuaf.Model.CourseModel;
import cn.edu.nwsuaf.Model.CurriculumresourceModel;
import cn.edu.nwsuaf.Model.EffectqualityeducationModel;
import cn.edu.nwsuaf.Model.EmploymentModel;
import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;
import cn.edu.nwsuaf.Model.FulfillinginstanceModel;
import cn.edu.nwsuaf.Model.HighleveltalentModel;
import cn.edu.nwsuaf.Model.InnovationModel;
import cn.edu.nwsuaf.Model.MajorModel;
import cn.edu.nwsuaf.Model.MajorcourseModel;
import cn.edu.nwsuaf.Model.PracticecoursesummaryModel;
import cn.edu.nwsuaf.Model.PreRevolutModel;
import cn.edu.nwsuaf.Model.PreScientModel;
import cn.edu.nwsuaf.Model.PublicshedaacademicpapersModel;
import cn.edu.nwsuaf.Model.PublicshedarevolutionpapersModel;
import cn.edu.nwsuaf.Model.QualitystandardModel;
import cn.edu.nwsuaf.Model.StudentModel;
import cn.edu.nwsuaf.Model.StudentculturesummaryModel;
import cn.edu.nwsuaf.Model.StupatentModel;
import cn.edu.nwsuaf.Model.StuthesisModel;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.Model.TeachReBaseModel;
import cn.edu.nwsuaf.Model.TeacherModel;
import cn.edu.nwsuaf.Model.TeacherinfosummaryModel;
import cn.edu.nwsuaf.Model.TeacherresearchSummaryModel;
import cn.edu.nwsuaf.Model.TeachertrainingModel;
import cn.edu.nwsuaf.Model.TeachingcostModel;
import cn.edu.nwsuaf.Model.TeachingplanchangeModel;
import cn.edu.nwsuaf.Model.TeachprojectModel;
import cn.edu.nwsuaf.Model.TraininguseinginformationModel;
import cn.edu.nwsuaf.Model.TrainingvenueModel;
import cn.edu.nwsuaf.Service.Impl.AchievementService;
import cn.edu.nwsuaf.Service.Impl.AddmissionsService;
import cn.edu.nwsuaf.Service.Impl.CommunicationsituService;
import cn.edu.nwsuaf.Service.Impl.CompetitionService;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.CurriculumresourceService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.EffectqualityeducationService;
import cn.edu.nwsuaf.Service.Impl.EmploymentService;
import cn.edu.nwsuaf.Service.Impl.ExpertadviceService;
import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.Service.Impl.FulfillinginstanceService;
import cn.edu.nwsuaf.Service.Impl.HighleveltalentService;
import cn.edu.nwsuaf.Service.Impl.InnovationmemberService;
import cn.edu.nwsuaf.Service.Impl.InnovationprojectService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MajorcourseService;
import cn.edu.nwsuaf.Service.Impl.MasService;
import cn.edu.nwsuaf.Service.Impl.PresidedRevolutionService;
import cn.edu.nwsuaf.Service.Impl.PresidedScientificService;
import cn.edu.nwsuaf.Service.Impl.PublicshedaacademicpapersService;
import cn.edu.nwsuaf.Service.Impl.PublicshedarevolutionpapersService;
import cn.edu.nwsuaf.Service.Impl.QualitystandardService;
import cn.edu.nwsuaf.Service.Impl.ScoreService;
import cn.edu.nwsuaf.Service.Impl.StuCptionService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.Service.Impl.StupatentService;
import cn.edu.nwsuaf.Service.Impl.StuthesisService;
import cn.edu.nwsuaf.Service.Impl.SummaryService;
import cn.edu.nwsuaf.Service.Impl.TeachAchieveService;
import cn.edu.nwsuaf.Service.Impl.TeachBookService;
import cn.edu.nwsuaf.Service.Impl.TeachBooksService;
import cn.edu.nwsuaf.Service.Impl.TeachResultBaseService;
import cn.edu.nwsuaf.Service.Impl.TeachResultService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.Service.Impl.TeachertrainingService;
import cn.edu.nwsuaf.Service.Impl.TeachingcostService;
import cn.edu.nwsuaf.Service.Impl.TeachingplanchangeService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectuserService;
import cn.edu.nwsuaf.Service.Impl.TraininguseinginformationService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueUsingService;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Addmissions;
import cn.edu.nwsuaf.bean.Communicationsitu;
import cn.edu.nwsuaf.bean.Competition;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Effectofqualityeducation;
import cn.edu.nwsuaf.bean.Employment;
import cn.edu.nwsuaf.bean.Expertadvice;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Fulfillinginstance;
import cn.edu.nwsuaf.bean.Highleveltalent;
import cn.edu.nwsuaf.bean.Innovationmember;
import cn.edu.nwsuaf.bean.Innovationproject;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorcourse;
import cn.edu.nwsuaf.bean.Mas;
import cn.edu.nwsuaf.bean.Practicecoursesummary;
import cn.edu.nwsuaf.bean.Presidedoverrevolutionresearchproject;
import cn.edu.nwsuaf.bean.Presidedoverscientificresearchproject;
import cn.edu.nwsuaf.bean.Publicshedaacademicpapers;
import cn.edu.nwsuaf.bean.Publicshedarevolutionpapers;
import cn.edu.nwsuaf.bean.Qualitystandard;
import cn.edu.nwsuaf.bean.Score;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.bean.Studentcoepetition;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.bean.Stuthesis;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.bean.Teacherinfosummary;
import cn.edu.nwsuaf.bean.Teacherresearchsummary;
import cn.edu.nwsuaf.bean.Teachertraining;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.bean.Teachingcost;
import cn.edu.nwsuaf.bean.Teachingplanchange;
import cn.edu.nwsuaf.bean.Teachproject;
import cn.edu.nwsuaf.bean.Teachprojectuser;
import cn.edu.nwsuaf.bean.Teachresult;
import cn.edu.nwsuaf.bean.Teachresultbaseinfo;
import cn.edu.nwsuaf.bean.Traininguseinginformation;
import cn.edu.nwsuaf.bean.Trainingvenue;
import cn.edu.nwsuaf.bean.Trainingvenueuse;
import cn.edu.nwsuaf.util.QueryUtil;

/**
 * 导出Excel文件
 * 
 * @author wal
 * 
 */
public class ExportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 公用参数
	private String exportName;
	private Integer isDownload = 0;
	private Date date = new Date();
	private String comNumber;
	private String insNumber;
	
	//传输参数
	private String majorNum;
	private String expertName;

	private int stuComNumber;
	// Service
	private MasService masService;// 专业评估指标统计信息
	private StudentService studentService;// 学生
	private MajorService majorService;// 专业
	private EmploymentService empService;// 就业情况
	private CurriculumresourceService curService;// 专业课程资源
	private AddmissionsService admService;// 招生情况
	private QualitystandardService quastanService;// 课程质量标准
	private TeachingplanchangeService tplanService;// 教学计划变更
	private StuthesisService stuthesisService;// 学生发表论文
	private MajorcourseService mcourseService;// 专业课开课
	private CourseService courseService;// 课程信息
	private HighleveltalentService highService;// 高层次人才信息
	private PresidedScientificService presService;// 主持科研项目
	private PresidedRevolutionService prerService;// 主持教改项目
	private StupatentService stupatentService;// 学生专利
	private EffectqualityeducationService effectqualityeducationService;// 人文素质教育
	private PublicshedaacademicpapersService publicshedaacademicpapersService;// 教师发表科研论文
	private PublicshedarevolutionpapersService publicshedarevolutionpapersService;// 教师发表教改论文
	private TeachertrainingService teachertrainingService;// 教师进修培新
	private CommunicationsituService communicationsituService;// 学生国内外交流
	private FulfillinginstanceService fulfillinginstanceService;// 实习实践毕业设计
	private TeachResultBaseService teachResultBaseService;// 教学成果列表
	private AchievementService achievementService;// 科研成果信息
	private CompetitionService competitionService;// 获奖竞赛列表
	private InnovationprojectService innovationprojectService;// 创新创业列表
	private StuCptionService stuCptionService;// 竞赛获奖成员列表
	private InnovationmemberService innovationmemberService;// 科创成员列表
	private TeachBookService teachBookService; // 教材作者表
	private TeachprojectuserService teachprojectuserService; // 质量工程成员表
	private TeachResultService teachResultService;// 教学成果成员列表
	private TeachAchieveService teachAchieveService;// 科研成果成员列表
	private TeachprojectService teachprojectService;// 教学质量工程列表
	private TeachBooksService teachBooksService;// 教材信息列表
	private TraininguseinginformationService traininguseinginformationService;// 实践教学
	private TeachingcostService teachingcostService;// 教学经费
	private TeacherService teacherService;// 教师
	private TrainingvenueService trainingvenueService;// 实验实训场地
	private TrainingvenueUsingService trainingvenueuseService;// 实验实训场地使用情况
	private DepartmentService departmentService;// 学院信息
	private FileinfoattachmentService fiaService;// 定性指标统计
	private SummaryService summaryService;// 所有统计情况
	private ScoreService scoreService;// 评估结果
	private ExpertadviceService expertAdviceService;
	// Model
	private StudentModel studentmodel;// 学生
	private MajorModel majormodel;// 专业
	private EmploymentModel empmodel;// 就业情况
	private CurriculumresourceModel curmodel;// 专业课程资源
	private AddmissionsModel admmodel;// 招生情况
	private QualitystandardModel quastanmodel;// 课程质量标准
	private TeachingplanchangeModel tplanmodel;// 教学计划变更
	private StuthesisModel stutmodel;// 学生发表论文
	private MajorcourseModel mcoursemodel;// 专业课开课
	private CourseModel cmodel;// 课程信息
	private HighleveltalentModel hmodel;// 高层次人才信息
	private PreScientModel presmodel;// 主持科研项目
	private PreRevolutModel prermodel;// 主持教改项目
	private StupatentModel stupmodel;// 学生专利
	private PublicshedaacademicpapersModel papmodel;// 教师发表教改论文
	private PublicshedarevolutionpapersModel pepmodel;// 教师发表科研论文
	private EffectqualityeducationModel eqemodel;// 人文科学素质教育
	private TeachertrainingModel teatmodel;// 教师进修培训
	private CommunicationsituModel commodel;// 学生国内外交流
	private FulfillinginstanceModel fulmodel;// 实习实践毕业设计
	private TeachReBaseModel teachReBaseModel;// 教学成果列表
	private AchieveModel amodel;// 科研成果信息
	private CompetitionModel comodel;// 竞赛获奖列表
	private InnovationModel innovationModel;// 创新创业列表
	private TeachBooksModel teachBooksModel;// 教材信息列表
	private TeachprojectModel teachprojectModel;// 教学质量工程列表
	private Studentcoepetition studentcoepetition;// 竞赛获奖成员列表
	private Innovationmember innovationmember;// 科创成员列表
	private Teachbook teachbook;// 教材作者列表
	private Teachprojectuser teachprojectuser;// 质量工程成员表
	private Teachresult teachresult; // 教学成果成员表
	private Teacherachievements teacherachievements;// 科研成果成员表
	private TraininguseinginformationModel tuimodel;// 实践教学
	private TeachingcostModel teamodel;// 教学经费
	private TeacherModel teachermodel;// 教师
	private TrainingvenueModel tramodel;// 实验实习场地
	private BaseModel trausemodel;// 实验实习场地使用情况
	private BaseModel departmentmodel;// 学院信息
	private FileinfoAttachmentModel fiamodel;// 定性指标统计
	private TeacherinfosummaryModel teacherinfosummaryModel;// 专业教师基本情况
	private TeacherresearchSummaryModel teacherresearchsummaryModel;// 教学科研情况
	private StudentculturesummaryModel studentculturesummaryModel;// 学生培养情况
	private PracticecoursesummaryModel practicecoursesummaryModel;// 实践教学情况
	private BaseModel basemodel;// 专业评估指标统计
	//private BaseModel baseModel;// 专业评估指标统计
	// 输出列表
	private List<Student> studentList = new ArrayList<Student>();// 学生
	private List<Major> majorList = new ArrayList<Major>();// 专业
	private List<Employment> empList = new ArrayList<Employment>();// 就业情况
	private List<Curriculumresource> curList = new ArrayList<Curriculumresource>();// 专业课程资源
	private List<Addmissions> admList = new ArrayList<Addmissions>();// 招生情况
	private List<Qualitystandard> quastanList = new ArrayList<Qualitystandard>();// 课程质量标准
	private List<Teachingplanchange> tplanList = new ArrayList<Teachingplanchange>();// 教学计划变更
	private List<Stuthesis> stutList = new ArrayList<Stuthesis>();// 学生发表论文
	private List<Majorcourse> mcourseList = new ArrayList<Majorcourse>();// 专业课开课
	private List<Course> courseList = new ArrayList<Course>();// 课程信息
	private List<Highleveltalent> highList = new ArrayList<Highleveltalent>();// 高层次人才信息
	private List<Presidedoverscientificresearchproject> presList = new ArrayList<Presidedoverscientificresearchproject>();// 主持科研项目
	private List<Presidedoverrevolutionresearchproject> prerList = new ArrayList<Presidedoverrevolutionresearchproject>();// 主持教改项目
	private List<Stupatent> stupList = new ArrayList<Stupatent>();// 学生获得专利
	private List<Effectofqualityeducation> efList = new ArrayList<Effectofqualityeducation>();// 人文科学素质教育
	private List<Publicshedaacademicpapers> papList = new ArrayList<Publicshedaacademicpapers>();// 教师发表科研论文
	private List<Publicshedarevolutionpapers> pepList = new ArrayList<Publicshedarevolutionpapers>();// 教师发表教改论文
	private List<Teachertraining> teatList = new ArrayList<Teachertraining>();// 教师进修培训
	private List<Communicationsitu> cccList = new ArrayList<Communicationsitu>();// 学生国内外交流
	private List<Fulfillinginstance> fffList = new ArrayList<Fulfillinginstance>();// 实习实践毕业设计
	private List<Teachresultbaseinfo> teachresultbaseinfolist = new ArrayList<Teachresultbaseinfo>();// 教学成果列表
	private List<Achievements> achievementslist = new ArrayList<Achievements>();// 科研成果信息列表
	private List<Competition> competitionlist = new ArrayList<Competition>();// 竞赛获奖列表
	private List<Innovationproject> innovationprojectlist = new ArrayList<Innovationproject>();// 创新创业项目列表
	private List<Teachingbooks> teachingbookslist = new ArrayList<Teachingbooks>();// 教材信息列表
	private List<Teachproject> teachprojectlist = new ArrayList<Teachproject>();// 质量工程列表
	private List<Studentcoepetition> studentcoepetitionlist = new ArrayList<Studentcoepetition>();// 竞赛获奖成员列表
	private List<Innovationmember> innovationmemberlist = new ArrayList<Innovationmember>();// 科创成员列表
	private List<Teachbook> teachbooklist = new ArrayList<Teachbook>();// 教材作者列表
	private List<Teachprojectuser> teachprojectuserlist = new ArrayList<Teachprojectuser>();// 质量工程成员表
	private List<Teachresult> teachresultlist = new ArrayList<Teachresult>();// 教学成果成员表
	private List<Teacherachievements> teacherachievementslist = new ArrayList<Teacherachievements>();// 科研成果成员表
	private List<Traininguseinginformation> tuiList = new ArrayList<Traininguseinginformation>();
	private List<Teachingcost> teaList = new ArrayList<Teachingcost>();
	private List<Teacher> teacList = new ArrayList<Teacher>();// 教师
	private List<Trainingvenue> traingvenueList = new ArrayList<Trainingvenue>();// 实验场地
	private List<Trainingvenueuse> traingvenueuseList = new ArrayList<Trainingvenueuse>();// 实验场地
	private List<Department> departmentList = new ArrayList<Department>();// 学院信息
	private List<FileinfoAttachment> fiaList = new ArrayList<FileinfoAttachment>();// 定性指标统计信息
	private List<Teacherinfosummary> teacherinfosummaryList;// 专业教师基本情况
	private List<Teacherresearchsummary> teacherresearchsummaryList;// 教学科研情况
	private List<Studentculturesummary> studentculturesummaryList;// 学生培养情况
	private List<Practicecoursesummary> practicecoursesummaryList;// 实践教学情况
	private List<Score> scoreList;// 实体存储分数
	private List<Mas> exportMasList;// 专业评估指标统计信息
	private List<Expertadvice> expertAdviceList;

	
	
	/**
	 * 获取session对象 contestNotifierId 是申报人或用户Id
	 */
	// HttpServletRequest request = ServletActionContext.getRequest();
	// HttpSession session = request.getSession();
	// private UserModel userInfo = (UserModel)
	// session.getAttribute("userInfo");
	// private String contestNotifierId = userInfo.getUserId();

	/**
	 * 导出Excel文件
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String export() throws Exception {
		
		/*
		 * sheet 名称
		 */
		String sheetName = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		/*
		 * 设置表头：对Excel每列取名(必须根据你取的数据编写)
		 */
		String[] tableHeader = null;
		if ("stud".equals(exportName)) {
			/*
			 * tableHeader = new String[] { "学号", "学生姓名","民族编号", "民族","专业编号",
			 * "专业", "性别", "出生日期", "年级", "班级",
			 * "入学年份","毕业日期","学制","是否有学籍","是否在校","当前学生状态" };
			 */
			tableHeader = new String[] { "学号", "学生姓名", "性别", "民族", "专业",
					"出生日期", "年级", "班级", "入学年份", "毕业日期", "学制", "是否有学籍", "是否在校",
					"当前学生状态" };
			if (0 == isDownload)
				// 测试
				// System.out.println("ExportAction学生学院："+studentmodel.getDepartmentId());
				studentList = studentService.exportallStudentList(studentmodel);
			sheetName = "学生信息表";

		}
		if ("major".equals(exportName)) {
			tableHeader = new String[] { "专业编号", "专业名称", "所在学院", "学科门类", "专业类",
					"专业类别", "专业开设年份" };
			if (0 == isDownload)
				System.out.println("进入service");
			majorList = majorService.exportallMajorList(majormodel);
			sheetName = "专业信息表";

		}
		if ("emp".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "所在专业", "毕业人数", "初次就业人数",
					"就业人数", "年份", "备注" };
			if (0 == isDownload)
				empList = empService.exportallEmploymentList(empmodel);
			sheetName = "就业情况信息表";

		}
		if ("cur".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "所在专业", "课程编号", "课程名称",
					"是否开出", "是否优质课程", "课程规划", "年份", "备注" };
			if (0 == isDownload)
				curList = curService.exportallCurriculumresourceList(curmodel);
			sheetName = "专业课程资源信息表";
		}
		if ("adm".equals(exportName)) {
			tableHeader = new String[] { "专业名称", "计划人数", "招生人数", "专业第一志愿率",
					"入学平均分", "专业报考热门度", "年份", "备注" };
			if (0 == isDownload)
				admList = admService.exportallAddmissionsList(admmodel);
			System.out.println("admsize" + admList.size());
			sheetName = "招生情况信息表";
		}
		if ("quastan".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "总数", "完成数", "备注" };
			if (0 == isDownload)
				quastanList = quastanService
						.exportallQualitystandardList(quastanmodel);
			sheetName = "课程质量标准信息表";
		}
		if ("tplan".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "课程编号", "课程名称", "年级",
					"课程性质", "变动类型", "变更方式", "变更原因", "变更内容", "变更日期", "年份" };
			/*
			 * tableHeader = new String[] { "编号", "所在学院", "专业名称", "课程名称", "年级",
			 * "课程性质", "变动类型", "变更方式", "变更原因", "变更内容", "变更日期", "年份" };
			 */
			if (0 == isDownload)
				tplanList = tplanService.exportList(tplanmodel);
			sheetName = "教学计划变更信息表";

		}
		if ("stut".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "学号", "姓名", "论文名称",
					"发表期刊", "期刊类型", "发表年份", "备注" };

			if (0 == isDownload)
				stutList = stuthesisService.exportList(stutmodel);
			sheetName = "学生发表论文信息表";

		}
		if ("mcourse".equals(exportName)) {
			/*
			 * tableHeader = new String[] { "编号", "所在学院", "专业名称", "专业编号",
			 * "教师编号", "教师姓名", "职称", "课程名称", "课程编号", "学期", "所属专业", "上课学时",
			 * "总学时", "课程类型", "开课年份", "备注" };
			 */
			tableHeader = new String[] { "所在学院", "专业名称", "教师编号", "教师姓名", "职称",
					"课程编号", "课程名称", "学期", "上课学时", "总学时", "课程类型", "开课年份", "备注" };
			if (0 == isDownload)
				mcourseList = mcourseService.exportList(mcoursemodel);
			sheetName = "专业课开课信息表";

		}
		if ("course".equals(exportName)) {
			/*
			 * tableHeader = new String[] { "课程编号", "学院编号", "所在学院", "课程名称",
			 * "课程类别", "是否是双语授课", "考核方式", "学时", "学分", "方案版本" };
			 */
			tableHeader = new String[] { "课程编号", "课程名称", "所在学院", "课程类别",
					"是否是双语授课", "考核方式", "学时", "学分", "方案版本" };
			if (0 == isDownload) {
				cmodel.setName(java.net.URLDecoder.decode(cmodel.getName(),
						"UTF-8"));
				System.out.println("cmodel.getCtype()qian========"
						+ cmodel.getCtype());
				cmodel.setCtype(java.net.URLDecoder.decode(cmodel.getCtype(),
						"UTF-8"));
				System.out.println("cmodel.getCtype()hou========"
						+ cmodel.getCtype());
				cmodel.setIsDoubleLanguageTeach(java.net.URLDecoder.decode(
						cmodel.getIsDoubleLanguageTeach(), "UTF-8"));
				cmodel.setTestMode(java.net.URLDecoder.decode(cmodel
						.getTestMode(), "UTF-8"));

				courseList = courseService.exportallCourseList(cmodel);
			}
			sheetName = "课程基本信息表";
		}
		if ("highlevelTalent".equals(exportName)) {
			tableHeader = new String[] { "教师编号", "教师姓名", "所在专业", "人才类型",
					"人才级别", "研究领域", "获得年份" };
			if (0 == isDownload) {
				hmodel.setName(java.net.URLDecoder.decode(hmodel.getName(),
						"UTF-8"));
				hmodel.setTalentType(java.net.URLDecoder.decode(hmodel
						.getTalentType(), "UTF-8"));
				hmodel.setRearchField(java.net.URLDecoder.decode(hmodel
						.getRearchField(), "UTF-8"));
				highList = highService.exportallHighList(hmodel);
			}
			sheetName = "高层次人才表";
		}
		if ("presidedScientific".equals(exportName)) {
			tableHeader = new String[] { "项目编号", "项目名称", "教师姓名", "项目级别",
					"项目类型", "立项时间", "验收时间", "经费", "参与教师人数", "备注" };
			if (0 == isDownload) {
				presmodel.setName(java.net.URLDecoder.decode(presmodel
						.getName(), "UTF-8"));
				presmodel.setTname(java.net.URLDecoder.decode(presmodel
						.getTname(), "UTF-8"));
				presmodel.setProjecType(java.net.URLDecoder.decode(presmodel
						.getProjecType(), "UTF-8"));
				presmodel.setProjecJibie(java.net.URLDecoder.decode(presmodel
						.getProjecJibie(), "UTF-8"));
				presList = presService.exportallPresList(presmodel);
			}
			sheetName = "主持科研项目表";
		}
		if ("PresidedRevolution".equals(exportName)) {
			tableHeader = new String[] { "项目编号", "项目名称", "教师编号", "教师姓名",
					"项目级别", "项目类型", "立项时间", "验收时间", "经费", "参与教师人数", "备注" };
			if (0 == isDownload) {
				prermodel.setName(java.net.URLDecoder.decode(prermodel
						.getName()
						+ "", "UTF-8"));
				prermodel.setTname(java.net.URLDecoder.decode(prermodel
						.getTname()
						+ "", "UTF-8"));
				prermodel.setProjecType(java.net.URLDecoder.decode(prermodel
						.getProjecType()
						+ "", "UTF-8"));
				prermodel.setProjecJibie(java.net.URLDecoder.decode(prermodel
						.getProjecJibie()
						+ "", "UTF-8"));
				prerList = prerService.exportallPrerList(prermodel);
				// System.out.println("prer====" + prermodel.getProjecJibie());
			}
			sheetName = "主持教改项目表";
		}
		if ("stup".equals(exportName)) {
			tableHeader = new String[] { "专利号", "专利名称", "申请人学号", "申请人", "获取年份",
					"授权日期", "专利类别", "备注" };
			if (0 == isDownload)
				stupList = stupatentService.exportallStupatentList(stupmodel);
			sheetName = "学生获得专利信息表";

		}
		if ("eqe".equals(exportName)) {
			tableHeader = new String[] { "专业名称", "挑战杯参与人数", "专业总人数", "报告会举办次数",
					"报告会参与次数", "其他教育类项目数", "年份", "备注" };
			if (0 == isDownload)
				efList = effectqualityeducationService
						.exportallEqeList(eqemodel);
			sheetName = "人文科学素质教育效果信息表";

		}
		if ("pap".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "教师编号", "教师名称",
					"论文名称", "发表期刊信息", "期刊类型", "影响因子", "发表年份", "备注" };
			/*
			 * tableHeader = new String[] { "编号", "教师编号","教师名称", "论文名称",
			 * "发表期刊信息", "期刊类型", "影响因子", "发表年份", "备注" };
			 */
			if (0 == isDownload)
				papmodel.setName(java.net.URLDecoder.decode(papmodel.getName()
						+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			papmodel.setPeriodicalType(java.net.URLDecoder.decode(papmodel
					.getPeriodicalType()
					+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			papmodel.setTname(java.net.URLDecoder.decode(papmodel.getTname()
					+ "", "UTF-8"));
			papList = publicshedaacademicpapersService
					.exportallPapList(papmodel);
			sheetName = "教师发表科研论文信息表";

		}
		if ("pep".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "教师编号", "教师名称",
					"论文名称", "发表期刊信息", "论文类别", "发表年份", "备注" };
			if (0 == isDownload)
				pepmodel.setName(java.net.URLDecoder.decode(pepmodel.getName()
						+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			pepmodel.setPeriodicalType(java.net.URLDecoder.decode(pepmodel
					.getPeriodicalType()
					+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			pepmodel.setTname(java.net.URLDecoder.decode(pepmodel.getTname()
					+ "", "UTF-8"));
			pepList = publicshedarevolutionpapersService
					.exportallPepList(pepmodel);
			sheetName = "教师发表教改论文信息表";

		}
		if ("teat".equals(exportName)) {
			tableHeader = new String[] { "教师编号", "教师名称", "培训类型", "培训名称",
					"培训年份", "境内外培训", "培训时间", "培训天数", "获得证书", "发证机构", "是否行业培训",
					"是否实践教学能力培训" };
			if (0 == isDownload)
				teatmodel.setName(java.net.URLDecoder.decode(teatmodel
						.getName()
						+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			teatmodel.setTrainType(java.net.URLDecoder.decode(teatmodel
					.getTrainType()
					+ "", "UTF-8"));
			// System.out.println("as:"+papmodel.getPeriodicalType());
			teatmodel.setTname(java.net.URLDecoder.decode(teatmodel.getTname()
					+ "", "UTF-8"));
			teatList = teachertrainingService.exportallTeatList(teatmodel);
			sheetName = "教师进修培训信息表";

		}
		// 学生国内外交流情况
		if ("ccc".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "交流项目数", "参与学生人数",
					"年份", "备注" };
			if (0 == isDownload)
				cccList = communicationsituService
						.exportallAddmissionsList(commodel);
			sheetName = "学生国内外交流情况表";
		}
		// 学生实践毕业设计落实情况
		if ("ful".equals(exportName)) {
			tableHeader = new String[] { "所在学院", "专业名称", "实践类型", "应开数", "实开数",
					"完成数", "开出率", "完成率", "年份", "备注" };
			if (0 == isDownload)
				fffList = fulfillinginstanceService.exportallFulList(fulmodel);
			sheetName = "学生实践毕业设计落实情况表";
		}
		// 教学成果
		if ("teachresultbaseinfo".equals(exportName)) {
			tableHeader = new String[] { "奖励项目名称", "获奖级别", "获奖等级", "获奖年份",
					"证书编号", "授予单位", "备注" };
			if (0 == isDownload) {
				System.out.println("teachReBaseModel.getName()======="
						+ teachReBaseModel.getName());
				System.out.println("teachReBaseModel.getYear()======="
						+ teachReBaseModel.getYear());
				teachReBaseModel.setTresultName(java.net.URLDecoder.decode(
						teachReBaseModel.getTresultName(), "UTF-8"));
				teachReBaseModel.setTresultJibie(java.net.URLDecoder.decode(
						teachReBaseModel.getTresultJibie(), "UTF-8"));
				teachReBaseModel.setTresultClass(java.net.URLDecoder.decode(
						teachReBaseModel.getTresultClass(), "UTF-8"));
				teachReBaseModel.setRewardDepart(java.net.URLDecoder.decode(
						teachReBaseModel.getRewardDepart(), "UTF-8"));
				teachresultbaseinfolist = teachResultBaseService
						.exportTeRebaseinfoList(teachReBaseModel);
				sheetName = "教学成果奖";
			}
		}
		// 教材信息
		if ("teachbooks".equals(exportName)) {
			// System.out.println("进入teachbooks判断");
			tableHeader = new String[] { "教材名称", "ISBN", "出版社", "年份", "出版时间",
					"出版类型", "级别", "优秀教材级别", "优秀教材获奖级别", "字数", "使用情况", "完成单位排名",
					"备注" };
			// System.out.println(tableHeader.length);
			if (0 == isDownload) {
				teachBooksModel.setName(java.net.URLDecoder.decode(
						teachBooksModel.getName(), "UTF-8"));
				teachBooksModel.setPublisher(java.net.URLDecoder.decode(
						teachBooksModel.getPublisher(), "UTF-8"));
				teachBooksModel.setTbookJibie(java.net.URLDecoder.decode(
						teachBooksModel.getTbookJibie(), "UTF-8"));
				teachBooksModel.setTbookClass(java.net.URLDecoder.decode(
						teachBooksModel.getTbookClass(), "UTF-8"));
				teachBooksModel.setTbookRewardClass(java.net.URLDecoder.decode(
						teachBooksModel.getTbookRewardClass(), "UTF-8"));
				// System.out.println(teachBooksModel.getTbookClass());
				teachingbookslist = teachBooksService
						.exportTBooksList(teachBooksModel);
				// System.out.println("teachingbookslist==========="+
				// teachingbookslist);
				sheetName = "教材信息列表";
			}
		}
		if ("achievements".equals(exportName)) {
			tableHeader = new String[] { "成果名称", "完成单位排名", "获奖级别", "获奖类别",
					"获奖等级", "获奖年份", "备注" };

			if (0 == isDownload) {
				amodel.setName(java.net.URLDecoder.decode(amodel.getName(),
						"UTF-8"));
				// System.out.println(amodel.getName());
				amodel.setCertificateClass(java.net.URLDecoder.decode(amodel
						.getCertificateClass(), "UTF-8"));
				amodel.setCertificateType(java.net.URLDecoder.decode(amodel
						.getCertificateType(), "UTF-8"));
				// System.out.println(amodel.getCertificateJibie());
				amodel.setCertificateJibie(java.net.URLDecoder.decode(amodel
						.getCertificateJibie(), "UTF-8"));
				// System.out.println(amodel.getCertificateJibie());
				achievementslist = achievementService
						.exportAchievementsList(amodel);
				// System.out.println("achievementslist.size()========="+achievementslist.size());
				sheetName = "科研成果信息列表";
			}
		}
		if ("competition".equals(exportName)) {
			tableHeader = new String[] { "竞赛名称", "获奖类别", "获奖等级", "年份", "备注" };
			if (0 == isDownload) {
				comodel.setComName(java.net.URLDecoder.decode(comodel
						.getComName(), "UTF-8"));
				comodel.setComRank(java.net.URLDecoder.decode(comodel
						.getComRank(), "UTF-8"));
				System.out.println("comodel.getComType()前===="
						+ comodel.getComType());
				comodel.setComType(java.net.URLDecoder.decode(comodel
						.getComType(), "UTF-8"));
				System.out.println("comodel.getComType()后===="
						+ comodel.getComType());
				competitionlist = competitionService.exportCompesList(comodel);
				System.out.println("competitionlist.size()========="
						+ competitionlist.size());
				sheetName = "竞赛获奖列表";
			}
		}
		if ("innovap".equals(exportName)) {
			tableHeader = new String[] { "编号", "项目名称", "项目级别", "项目类型", "立项年份",
					"项目经费", "立项时间", "结题时间", "验收结论", "备注" /* ,"操作标志" */};
			if (0 == isDownload) {
				innovationModel.setName(java.net.URLDecoder.decode(
						innovationModel.getName(), "UTF-8"));
				innovationModel.setLevel(java.net.URLDecoder.decode(
						innovationModel.getLevel(), "UTF-8"));
				innovationModel.setType(java.net.URLDecoder.decode(
						innovationModel.getType(), "UTF-8"));
				innovationModel.setName(java.net.URLDecoder.decode(
						innovationModel.getName(), "UTF-8"));

				innovationprojectlist = innovationprojectService
						.exportIProjectsList(innovationModel);

				sheetName = "创新创业项目列表";
			}
		}

		if ("teachproject".equals(exportName)) {
			tableHeader = new String[] { "编号", "质量工程名称", "质量工程级别", "质量工程类型",
					"获批年份", "批准文号", "备注" };
			if (0 == isDownload) {
				teachprojectModel.setName(java.net.URLDecoder.decode(
						teachprojectModel.getName(), "UTF-8"));
				teachprojectModel.setTprojecJibie(java.net.URLDecoder.decode(
						teachprojectModel.getTprojecJibie(), "UTF-8"));
				System.out.println(teachprojectModel.getTprojecType());
				teachprojectModel.setTprojecType(java.net.URLDecoder.decode(
						teachprojectModel.getTprojecType(), "UTF-8"));
				System.out.println(teachprojectModel.getTprojecType());
				teachprojectlist = teachprojectService
						.exportTPList(teachprojectModel);
				sheetName = "质量工程列表";
			}
		}
		if ("stucption".equals(exportName)) {
			tableHeader = new String[] { "竞赛项目", "获奖等级", "学生姓名", "学号", "学院",
					"获奖人排名", "竞赛类别", "竞赛年份" };
			if (0 == isDownload) {
				System.out.println("stuComNumber======" + stuComNumber);
				studentcoepetitionlist = stuCptionService.exportStuptionList(
						studentcoepetition, stuComNumber);
				sheetName = "竞赛获奖成员列表";
			}
		}
		if ("innovationmember".equals(exportName)) {
			tableHeader = new String[] { "学生学号", "学生姓名", "项目编号", "项目名称", "成员排名" };
			if (0 == isDownload) {
				System.out.println("comNumber======" + comNumber.toString());
				innovationmemberlist = innovationmemberService.exportInberList(
						innovationmember, comNumber.toString());
				sheetName = "科创成员列表";
			}
		}
		if ("teachbook".equals(exportName)) {
			tableHeader = new String[] { "教师编号", "教师姓名", "教材名称", "教材ISBN",
					"出版社", "作者角色", "作者排名" };
			if (0 == isDownload) {
				int intNumber = Integer.parseInt(insNumber.toString());
				System.out.println("intNumber======" + intNumber);
				teachbooklist = teachBookService.exportTeaBList(teachbook,
						intNumber);
				sheetName = "教材成员列表";
			}
		}
		if ("teachprojectuser".equals(exportName)) {
			tableHeader = new String[] { "教师编号", "教师姓名", "质量工程编号", "质量工程名称",
					"获奖人排名", "备注" };
			if (0 == isDownload) {
				System.out.println("comNumber======" + comNumber.toString());
				teachprojectuserlist = teachprojectuserService.exportInberList(
						teachprojectuser, comNumber.toString());
				System.out.println("comNumberSize======"
						+ teachprojectuserlist.size());
				sheetName = "质量工程成员列表";
			}
		}
		if ("teachresult".equals(exportName)) {
			System.out.println("intNumber======");
			tableHeader = new String[] { "教师编号", "教师姓名", "教学成果奖编号", "教学成果名称",
					"获奖人排名", "备注" };
			if (0 == isDownload) {
				int intNumber = Integer.parseInt(insNumber.toString());
				System.out.println("intNumber======" + intNumber);
				teachresultlist = teachResultService.exportInberList(
						teachresult, intNumber);
				sheetName = "教学成果成员列表";
				// System.out.println("teachresultlist======" +
				// teachresultlist);
			}
		}
		if ("teacherachievements".equals(exportName)) {
			tableHeader = new String[] { "教师编号", "教师姓名", "科研成果编号", "科研成果名称",
					"获奖人排名", "备注" };
			if (0 == isDownload) {
				System.out.println("comNumber======" + comNumber.toString());
				teacherachievementslist = teachAchieveService
						.exportTeachAchiList(teacherachievements, comNumber
								.toString());

				sheetName = "科研成果成员列表";
			}
		}
		if ("tui".equals(exportName)) {
			tableHeader = new String[] { "学院名称", "专业名称", "共建教学资源数", "实验设备生均值",
					"实验室满足率", "实验开放人时数", "校内基地数", "校外基地数", "校内基地满足率",
					"校外基地满足率", "年份" };
			if (0 == isDownload)
				tuiList = traininguseinginformationService
						.exportallTraList(tuimodel);
			sheetName = "实践教学资源情况表";
		}
		if ("tea".equals(exportName)) {
			tableHeader = new String[] { "学院名称", "专业名称", "使用类型", "经费", "用途",
					"年份" };
			if (0 == isDownload)
				teaList = teachingcostService.exportallTeachList(teamodel);
			sheetName = "教学经费情况表";
		}
		if ("teacher".equals(exportName)) {
			/*
			 * tableHeader = new String[] { "职工编号", "职工姓名", "所在学院", "所在专业",
			 * "职称", "学历", "师资类别", "在职状态" };
			 */
			tableHeader = new String[] { "职工编号", "职工姓名", "性别", "出生日期", "所在学院",
					"所在专业", "职称", "学位", "学历", "师资类别", "在职状态", "岗位类型", "学缘",
					"学科类别", "是否双师", "是否工程背景", "是否具有行业培训", "是否具有实践教学能力培训",
					"导师类别", "是否外聘教师" };
			if (0 == isDownload)
				teachermodel.setTname(java.net.URLDecoder.decode(teachermodel
						.getTname(), "UTF-8"));
			System.out.println(teachermodel.getTname());
			String mno = QueryUtil.getUserMno().getMajor().getInMno();
			String dno = QueryUtil.getUserMno().getDepartment().getDno();
			teacList = teacherService.exportallTeacherList(teachermodel, mno,
					dno);
			System.out.println("teachersize" + teacList.size());
			sheetName = "教师信息表";
		}
		// 评估指标数值统计
		if ("assessmentIndexInfo".equals(exportName)) {
			tableHeader = new String[] { "专业", "开启评估项目名称", "指标名称", "	指标权重",
					"评估得分" };
			String mno = QueryUtil.getUserMno().getMajor().getInMno();
			String dno = QueryUtil.getUserMno().getDepartment().getDno();
			exportMasList = masService.exportAllMas(basemodel, mno, dno);
			
			sheetName = "专业评估指标统计信息表";
		}
		if ("traingvenue".equals(exportName)) {
			tableHeader = new String[] { "实验室编号", "实验室名称", "实验室性质", "面积",
					"最大容纳学生数", "实验设备总值", "1000元以上设备总价值", "开放使用人数", "使用年份" };
			if (0 == isDownload)
				tramodel.setTraName(java.net.URLDecoder.decode(tramodel
						.getTraName(), "UTF-8"));
			tramodel.setTraCharacter(java.net.URLDecoder.decode(tramodel
					.getTraCharacter(), "UTF-8"));
			traingvenueList = trainingvenueService.exportTraList(tramodel);
			sheetName = "实验实习场地信息";
		}
		if ("traingvenueUse".equals(exportName)) {
			tableHeader = new String[] { "所在专业", "实验室编号", "实验室名称", "课程数",
					"专业实验教学人时数", "专业实验教学人次数", "使用年份" };
			if (0 == isDownload) {
				trausemodel.setName(java.net.URLDecoder.decode(trausemodel
						.getName(), "UTF-8"));
				traingvenueuseList = trainingvenueuseService
						.exportTrauseList(trausemodel);
			}
			sheetName = "实验实习场地使用信息";
		}
		if ("department".equals(exportName)) {
			tableHeader = new String[] { "学院代码", "学院名称", "学院负责人" };
			if (0 == isDownload)
				departmentList = departmentService
						.exportallDepartmentList(departmentmodel);
			sheetName = "学院信息";
		}
		if ("expertsummary".equals(exportName)) {
			tableHeader = new String[] { "年份", "专业", "专业评估编号", "指标名称", "上传否",
					"平均得分" };
			if (0 == isDownload)
				fiaList = fiaService.exportallFiaList(fiamodel);
			sheetName = "定性指标统计表";
		}
		if ("practicecoursesummary".equals(exportName)) {
			tableHeader = new String[] { "专业代码", "专业名称", "统计年份", "年度计划调整次数",
					"教授授课课程总学时", "高职授课课程总学时", "课程总学时", "总教学经费", "课程总数",
					"开出课程数", "优质课程数", "实习基地总数 ", "学生科创主持项目数 " };
			if (0 == isDownload)
				practicecoursesummaryList = (List<Practicecoursesummary>) summaryService
						.exportSTableList(practicecoursesummaryModel,
								"Practicecoursesummary");
			sheetName = "实践教学情况";
		}
		if ("studentculturesummary".equals(exportName)) {
			tableHeader = new String[] { "专业代码", "专业名称", "统计年份", "在籍学生数",
					"学生论文数", "专利数", "竞赛人数（国家级）", "竞赛人数（省级）", "竞赛人数（校级）",
					"科创人数（国家级）", "科创人数（省级）", "科创人数（校级）", "专业第一志愿率", "专业热门度",
					"初次就业率", "就业率", "国内外交流项目数", "国内外交流人数" };
			if (0 == isDownload)
				studentculturesummaryList = (List<Studentculturesummary>) summaryService
						.exportSTableList(studentculturesummaryModel,
								"Studentculturesummary");
			sheetName = "学生培养情况";
		}
		if ("teacherinfosummary".equals(exportName)) {
			tableHeader = new String[] { "专业代码", "专业名称", "统计年份", "职工数", "学生数",
					"专任教师数", "师生比", "博士人数", "教授人数", "副教授人数", "国家级人才数", "省级人才数",
					"校级人才数", "行业经历人数", "中青年专业教师人数", "中青年专业教师参加培训人数 " };
			if (0 == isDownload)
				teacherinfosummaryList = (List<Teacherinfosummary>) summaryService
						.exportSTableList(teacherinfosummaryModel,
								"Teacherinfosummary");
			sheetName = "专业教师基本情况";
		}
		if ("teacherresearchsummary".equals(exportName)) {
			tableHeader = new String[] { "专业代码", "专业名称", "统计年份",
					"科研论文数（EI\\SCI\\SSCI）", "科研论文数（A类）", "科研论文数（B类）",
					"科研项目数（国家级）", "科研项目数（省级）", "科研项目数（其他级别）", "教改论文数（A类）",
					"教改论文数（B类）", "教改论文数（公开发表）", "教改项目数（省级）", "教改项目数（校级）",
					"教改项目数（其他）", "出版教材数（主编）", "质量工程项目数 （国家级）", "质量工程项目数 （省级）",
					"质量工程项目数 （校级）", "教学成果奖（国家级-特等奖）", "教学成果奖（国家级-一等奖）",
					"教学成果奖（国家级-二等奖）", "教学成果奖（国家级-二等奖）", "教学成果奖（省级-特等奖）",
					"教学成果奖（省级-一等奖）", "教学成果奖（省级-二等奖）", "教学成果奖（校级-特等奖）",
					"教学成果奖（校级-一等奖）", "科研奖励数（国家级-一等奖-第一名）",
					"科研奖励数（国家级-一等奖-第二名）", "科研奖励数（国家级-一等奖-第三名）",
					"科研奖励数（国家级-二等奖-第一名）", "科研奖励数（国家级-二等奖-第二名）",
					"科研奖励数（国家级-二等奖-第三名）", "科研奖励数（国家级-三等奖-第一名）",
					"科研奖励数（国家级-三等奖-第二名）", "科研奖励数（国家级-三等奖-第三名）",
					"科研奖励数（省级级-一等奖-第一名）", "科研奖励数（省级级-一等奖-第二名）",
					"科研奖励数（省级级-一等奖-第三名）", "科研奖励数（省级级-二等奖-第一名）",
					"科研奖励数（省级级-二等奖-第二名）", "科研奖励数（省级级-二等奖-第三名）",
					"科研奖励数（省级级-三等奖-第一名）", "科研奖励数（省级级-三等奖-第二名）",
					"科研奖励数（省级级-三等奖-第三名）" };
			if (0 == isDownload)
				teacherresearchsummaryList = (List<Teacherresearchsummary>) summaryService
						.exportSTableList(teacherresearchsummaryModel,
								"Teacherresearchsummary");
			sheetName = "教学科研情况";
		}
		if ("mascore".equals(exportName)) {
			tableHeader = new String[] { "评估项目", "专业名称", "1.专业设置", "2.培养模式",
					"3.师资队伍", "4.教学资源", "5.培养过程", "6.教学质量保证", "7.学生发展",
					"8.专业特色", "总和" };
			if (0 == isDownload) {
				basemodel.setName(java.net.URLDecoder.decode(basemodel
						.getName(), "UTF-8"));
				scoreList = scoreService.exportScoreList(basemodel);
			}

			sheetName = "评估结果";
		}
		if("expertAdvice".equals(exportName)){
			
			tableHeader =  new String [] {
					"专业名称","专家","问题","建议"
			};
			
//			try {
//				expertName = new String(expertName.getBytes("ISO-8859-1"),"UTF8");
//				expertName=java.net.URLDecoder.decode(expertName, "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
			
			expertAdviceList = expertAdviceService.searchByModel(majorNum,expertName);
			sheetName = "专家建议";
		}
		
		/*
		 * 设置表格样式
		 */

		/*
		 * 1.得到表了列数2.创建一个excel文件3.创建一个sheet4.根据excel文件创建style
		 */

		int cellNumber = tableHeader.length;// 表的列数
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCellStyle style1 = workbook.createCellStyle(); // 设置表头的类型
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet(sheetName); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头
		try {
			row = sheet.createRow(0);
			row.setHeight((short) 400);
			for (int k = 0; k < cellNumber; k++) {
				cell = row.createCell(k);// 创建第0行第k列
				cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
				sheet.setColumnWidth(k, 8000);// 设置列的宽度
				font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
				font.setFontHeight((short) 350); // 设置单元字体高度
				style.setFont(font);// 设置字体风格
				cell.setCellStyle(style);
			}
			// 教师信息
			if ("teacher".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 * 职工编号", "职工姓名","性别","出生日期(YYYY-MM-DD)", "所在学院
				 * ", "所在专业", "职称","学位", "学历", "师资类别", "在职状态","岗位类型"
				 * ,"学缘","学科类别"
				 * ,"是否双师","是否工程背景","是否具有行业培训","是否具有实践教学能力培训","导师类别","是否外聘教师"};
				 */
				if (teacList == null || teacList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teacList.size(); i++) {
						Teacher teacher = (Teacher) teacList.get(i);

						Object[] values = {
								teacher.getTno(),
								teacher.getTname() + "",
								teacher.getSex() + "",
								df.format(teacher.getBirthDay()) + "",
								teacher.getMajor().getDepartment().getDname()
										+ "",
								teacher.getMajor().getMname(),
								teacher.getProfessionaltitle()
										.getProfessionalTitleName()
										+ "",
								teacher.getAcademicdegree().getBestDegreeName()
										+ "",
								teacher.getDegree().getDegreeName() + "",
								teacher.getTeacherscategory()
										.getTeachersCategoryName()
										+ "",
								teacher.getInServiceState() + "",
								teacher.getJobtype().getJobTypeName() + "",
								teacher.getLearningedge().getLearnEdgeName()
										+ " ",
								teacher.getSubjectcategory()
										.getSubjectCategoryName()
										+ " ",
								teacher.getIsDoubleTeacher() + " ",
								teacher.getIsEngineerBackground() + " ",
								teacher.getIsIndustryBackground() + " ",
								teacher.getIsPracticeTeachTraining() + " ",
								teacher.getTutorType() + "",
								teacher.getIsOuterTeacher() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 专业评估指标统计
			if ("assessmentIndexInfo".equals(exportName)) {
				if (teacList == null || teacList.size() < 1) {
					header.setCenter("查无资料");
					for (int i = 0; i < exportMasList.size(); i++) {
						
//						System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!test");
//						System.out.println(exportMasList.get(i).getMajor().getMname());
						
						Mas mas = (Mas) exportMasList.get(i);
						Object[] values = {
								mas.getMajor().getMname() + "",
								mas.getAssessingneedtarget()
										.getAssessingproject()
										.getMasprojectName()
										+ "",
								mas.getAssessingneedtarget()
										.getAppraisalsystem()
										.getIndicatorName()
										+ "",
								mas.getAssessingneedtarget()
										.getIndicatorWeight()
										+ "", mas.getAssessingScore() };
						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			
			//专家建议
			if("expertAdvice".equals(exportName)){
				if (expertAdviceList == null || expertAdviceList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					for(int i = 0;i<expertAdviceList.size();i++){
						Expertadvice expertadvice = (Expertadvice)expertAdviceList.get(i);
						
						Object [] values = {		
								expertadvice.getExpertmajor().getMajor().getMname()+"",
								expertadvice.getExpertmajor().getExpert().getExpertName()+"",
								" "+expertadvice.getQuestion(),
								" "+expertadvice.getAdvice()
						};
						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高
						
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			
			// 学生
			if ("stud".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (studentList == null || studentList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */

					for (int i = 0; i < studentList.size(); i++) {
						Student student = (Student) studentList.get(i);

						Object[] values = { student.getStuNumber() + "",
								student.getStuName() + "",
								student.getSex() + "",
								/* student.getNational().getNationNnumber()+"", */
								student.getNational().getNationName() + "",
								/* student.getMajor().getMno()+"", */
								student.getMajor().getMname() + "",

								df.format(student.getBirth()) + "",
								student.getGrade() + "",
								student.getClass_() + "",
								student.getYear() + "",
								df.format(student.getGraduationDate()) + "",
								student.getEductionalSystme() + "",
								student.getIsRoll() + "",
								student.getIsInSchool() + "",
								student.getStatus() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 专业
			if ("major".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (majorList == null || majorList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < majorList.size(); i++) {
						Major major = (Major) majorList.get(i);

						Object[] values = {
								major.getMno(),
								major.getMname(),
								major.getDepartment().getDname(),
								major.getDisciplinetype()
										.getDisciplineTypeName(),
								major.getMajortype().getMajorTypeName(),
								major.getMajorcategory().getMajorCategoryName(),
								major.getYear() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 就业情况
			if ("emp".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (empList == null || empList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < empList.size(); i++) {
						Employment emp = (Employment) empList.get(i);
						if (emp.getEmpCount() == null) {
							emp.setEmpCount(0);
						}
						if (emp.getGraduCount() == null) {
							emp.setGraduCount(0);
						}
						if (emp.getFempCount() == null) {
							emp.setFempCount(0);
						}
						Object[] values = {
								emp.getMajor().getDepartment().getDname(),
								emp.getMajor().getMname(),
								// emp.getMajor().getMno(),
								emp.getGraduCount(), emp.getFempCount(),
								emp.getEmpCount(), emp.getYear() + "",
								emp.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 课程资源
			if ("cur".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (curList == null || curList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < curList.size(); i++) {
						Curriculumresource cur = (Curriculumresource) curList
								.get(i);
						Object[] values = {
								cur.getMajor().getDepartment().getDname(),
								/* cur.getMajor().getMno(), */
								cur.getMajor().getMname(),
								cur.getCourse().getCno(),
								cur.getCourse().getCname(), cur.getIsOpen(),
								cur.getIsExcellent(),
								cur.getCoursePlann() + "", cur.getYear() + "",
								cur.getNote() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 招生情况
			if ("adm".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (admList == null || admList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < admList.size(); i++) {
						Addmissions adm = (Addmissions) admList.get(i);
						if (adm.getExpectCount() == null) {
							adm.setExpectCount(0);
						}
						if (adm.getAddmCount() == null) {
							adm.setAddmCount(0);
						}
						if (adm.getFirstChoice() == null) {
							adm.setFirstChoice((float) (0.0));
						}
						if (adm.getEntranceEverage() == null) {
							adm.setEntranceEverage((float) (0.0));
						}
						if (adm.getHotDeggree() == null) {
							adm.setHotDeggree((float) (0.0));
						}
						Object[] values = {
								adm.getMajor().getMname(),
								// adm.getMajor().getMno(),
								adm.getExpectCount().toString(),
								adm.getAddmCount().toString(),
								adm.getFirstChoice().toString(),
								adm.getEntranceEverage().toString(),
								adm.getHotDeggree().toString(),
								adm.getAddmYear().toString(),
								adm.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof Float) {
								cell.setCellValue(Float.parseFloat(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 课程质量标准
			if ("quastan".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (quastanList == null || quastanList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < quastanList.size(); i++) {
						Qualitystandard quastan = (Qualitystandard) quastanList
								.get(i);
						if (quastan.getAllCount() == null) {
							quastan.setAllCount(0);
						}
						if (quastan.getCompleteCount() == null) {
							quastan.setCompleteCount(0);
						}
						Object[] values = {
								quastan.getMajor().getDepartment().getDname(),
								quastan.getMajor().getMname(),
								// quastan.getMajor().getMno(),
								quastan.getAllCount(),
								quastan.getCompleteCount(),
								quastan.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教学计划变更
			if ("tplan".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (tplanList == null || tplanList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < tplanList.size(); i++) {
						/*
						 * SimpleDateFormat df = new
						 * SimpleDateFormat("yyyy-MM-dd");
						 */
						Teachingplanchange tplan = (Teachingplanchange) tplanList
								.get(i);
						if (tplan.getTeachPlanChaneId() == null) {
							tplan.setTeachPlanChaneId(0);
						}
						if (tplan.getChangeDate() == null) {
							tplan.setChangeDate(df.parse("2000-1-1"));
						}

						Object[] values = {
								tplan.getMajor().getDepartment().getDname(),
								tplan.getMajor().getMname(),
								tplan.getCourse().getCno() + "",
								tplan.getCourse().getCname(), tplan.getGrade(),
								tplan.getCourseNature(), tplan.getChangeType(),
								tplan.getChangeMode(), tplan.getChangeReason(),
								tplan.getChangeContext(),
								df.format(tplan.getChangeDate()),
								tplan.getYear() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 学生发表论文
			if ("stut".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (stutList == null || stutList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					System.out.println("导出学生论文：" + stutList.size());
					for (int i = 0; i < stutList.size(); i++) {
						Stuthesis stut = (Stuthesis) stutList.get(i);

						if (stut.getNote() == null) {
							stut.setNote("");
						}
						if (stut.getYear() == null) {
							stut.setYear("");
						}
						Object[] values = {
								stut.getStudent().getMajor().getDepartment()
										.getDname(),
								stut.getStudent().getMajor().getMname(),
								// stut.getStudent().getMajor().getMno(),
								stut.getStudent().getStuNumber(),
								stut.getStudent().getStuName(),
								stut.getComName(), stut.getJournal(),
								stut.getJournalType(), stut.getYear(),
								stut.getNote() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 专业课开课
			if ("mcourse".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (mcourseList == null || mcourseList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < mcourseList.size(); i++) {
						Majorcourse mcourse = (Majorcourse) mcourseList.get(i);
						if (mcourse.getBeizhu() == null) {
							mcourse.setBeizhu("");
						}
						Object[] values = {
								mcourse.getMajor().getDepartment().getDname(),
								mcourse.getMajor().getMname(),
								/* mcourse.getMajor().getMno(), */
								mcourse.getTeacher().getTno(),
								mcourse.getTeacher().getTname(),
								mcourse.getProfessionalTitleName(),
								mcourse.getCourse().getCno(),
								mcourse.getCourse().getCname(),
								mcourse.getOpenSemester(),
								mcourse.getClasshours(),
								mcourse.getCourseHours(), mcourse.getCtype(),
								mcourse.getYear(), mcourse.getBeizhu() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof String) {
								cell.setCellValue(values[m].toString());
							} else if (values[m] instanceof Double) {
								cell.setCellValue(Double.parseDouble(values[m]
										.toString()));
							}
							// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 课程基本信息
			if ("course".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (courseList == null || courseList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					System.out.println("course==else===" + courseList.size());
					for (int i = 0; i < courseList.size(); i++) {
						Course course = (Course) courseList.get(i);

						if (course.getCourseHours() == null) {
							course.setCourseHours(0);
						}
						if (course.getCredit() == null) {
							course.setCredit((float) 0);
						}
						if (course.getTestMode() == null) {
							course.setTestMode("未知");
						}

						Object[] values = { course.getCno(), course.getCname(),
								course.getDepartment().getDname(),
								course.getCtype(),
								course.getIsDoubleLanguageTeach(),
								course.getTestMode(), course.getCourseHours(),
								course.getCredit(), course.getVersion() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {

								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof Float) {
								/*
								 * System.out.println("进入float" + Float
								 * .parseFloat(values[m] .toString()));
								 */
								cell.setCellValue(Float.parseFloat(values[m]
										.toString()));
							} else {

								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 高层次人才
			if ("highlevelTalent".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (highList == null || highList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < highList.size(); i++) {
						Highleveltalent high = (Highleveltalent) highList
								.get(i);

						Object[] values = { high.getTeacher().getTno() + "",
								high.getTeacher().getTname().toString() + "",
								high.getTeacher().getMajor().getMname() + "",
								high.getTalentType() + "",
								high.getTalentLevel() + "",
								high.getRearchField() + "",
								high.getYear().toString() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof Float) {
								cell.setCellValue(Float.parseFloat(values[m]
										.toString()));
							} else if (values[m] instanceof String) {
								cell.setCellValue(String.valueOf(values[m]));
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 主持科研项目
			if ("presidedScientific".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (presList == null || presList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < presList.size(); i++) {
						Presidedoverscientificresearchproject pres = (Presidedoverscientificresearchproject) presList
								.get(i);
						/*
						 * SimpleDateFormat df = new
						 * SimpleDateFormat("yyyy-MM-dd");
						 */
						// System.out.println("pres===="+pres.getCost());
						if (pres.getCost() == null) {
							pres.setCost((float) 0);
						}
						if (pres.getPartTeacherNum() == null) {
							pres.setPartTeacherNum(0);
						}

						Object[] values = { pres.getProjectNo() + "",
								pres.getProjectName() + "",
								pres.getTeacher().getTname(),
								pres.getProjecJibie() + "",
								pres.getProjecType() + "",
								/*
								 * String.valueOf(pres.getProjecTime().getYear())
								 * + "",
								 */
								pres.getProjecTime(), pres.getAcceptenceDate(),
								pres.getCost(), pres.getPartTeacherNum(),
								pres.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						DecimalFormat simple = new java.text.DecimalFormat(
								"#.##");
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							/*
							 * if (values[m] instanceof Integer) {
							 * cell.setCellValue(Integer.parseInt(values[m]
							 * .toString())); } else
							 */if (values[m] instanceof Float) {
								Float cost = Float.parseFloat(values[m]
										.toString());

								cell.setCellValue(simple.format(cost));
							} else if (values[m] instanceof Date) {

								cell.setCellValue(df
										.parse(values[m].toString()));

							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 主持教改项目
			if ("PresidedRevolution".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (prerList == null || prerList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < prerList.size(); i++) {
						Presidedoverrevolutionresearchproject prer = (Presidedoverrevolutionresearchproject) prerList
								.get(i);
						/*
						 * SimpleDateFormat df = new
						 * SimpleDateFormat("yyyy-MM-dd");
						 */
						System.out.println("as" + prer.getRcost());
						if (prer.getRprojecTime() == null) {
							prer.setRprojecTime(date);
						}
						if (prer.getRacceptenceDate() == null) {
							prer.setRacceptenceDate(date);
						}
						if (prer.getRcost() == null) {
							prer.setRcost((float) 0.00);
						}
						if (prer.getRpartTeacherNum() == null) {
							prer.setRpartTeacherNum(0);
						}

						Object[] values = { prer.getRprojectNo() + "",
								prer.getRprojectName() + "",
								prer.getTeacher().getTno() + "",
								prer.getTeacher().getTname(),
								prer.getRprojecJibie() + "",
								prer.getRprojecType() + "",
								/* prer.getYear() + "", */
								df.format(prer.getRprojecTime()),
								df.format(prer.getRacceptenceDate()),
								prer.getRcost(), prer.getRpartTeacherNum(),
								prer.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高
						DecimalFormat simple = new java.text.DecimalFormat(
								"#.##");
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							/*
							 * if (values[m] instanceof Integer) {
							 * cell.setCellValue(Integer.parseInt(values[m]
							 * .toString())); } else
							 */if (values[m] instanceof Float) {
								Float cost = Float.parseFloat(values[m]
										.toString());

								cell.setCellValue(simple.format(cost));
							} else if (values[m] instanceof Date) {

								cell.setCellValue(df
										.parse(values[m].toString()));

							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 学生获得专利
			if ("stup".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (stupList == null || stupList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < stupList.size(); i++) {
						Stupatent stup = (Stupatent) stupList.get(i);
						if (stup.getAuthorityDate() == null) {
							stup.setAuthorityDate(date);
						}
						Object[] values = { stup.getPatentNumber() + "",
								stup.getPateName() + "",
								stup.getStudent().getStuNumber() + "",
								stup.getStudent().getStuName() + "",
								stup.getYear(),

								df.format(stup.getAuthorityDate()),
								stup.getPateType() + "", stup.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高
						System.out.println("values=123");
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 人文科学素质教育效果
			if ("eqe".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (efList == null || efList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < efList.size(); i++) {
						Effectofqualityeducation eqe = (Effectofqualityeducation) efList
								.get(i);

						Object[] values = { eqe.getMajor().getMname() + "",
								eqe.getCupCount(), eqe.getMajorCount(),
								eqe.getHostReportCount(), eqe.getPartiCount(),
								eqe.getOtherProject(), eqe.getYear() + "",
								eqe.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教师发表科研论文
			if ("pap".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (papList == null || papList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < papList.size(); i++) {
						Publicshedaacademicpapers pap = (Publicshedaacademicpapers) papList
								.get(i);

						Object[] values = {
								pap.getTeacher().getMajor().getDepartment()
										.getDname()
										+ "",
								pap.getTeacher().getMajor().getMname() + "",
								pap.getTeacher().getTno() + "",
								pap.getTeacher().getTname() + "",
								pap.getPaperName() + "",
								pap.getPeriodicalInfo() + "",
								pap.getPeriodicalType() + "",
								pap.getInfluenceFactors(), pap.getYear() + "",
								pap.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教师发表教改论文
			if ("pep".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (pepList == null || pepList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < pepList.size(); i++) {
						Publicshedarevolutionpapers pep = (Publicshedarevolutionpapers) pepList
								.get(i);

						Object[] values = {
								pep.getTeacher().getMajor().getDepartment()
										.getDname()
										+ "",

								pep.getTeacher().getMajor().getMname() + "",
								pep.getTeacher().getTno() + "",
								pep.getTeacher().getTname() + "",
								pep.getRevoPaperName() + "",
								pep.getRevoPeriodicalInfo() + "",
								pep.getPeriodicalType() + "",
								pep.getYear() + "", pep.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教师进修
			if ("teat".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (teatList == null || teatList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teatList.size(); i++) {
						Teachertraining teat = (Teachertraining) teatList
								.get(i);

						Object[] values = { teat.getTeacher().getTno() + "",
								teat.getTeacher().getTname() + "",
								teat.getTrainType() + "",
								teat.getTrainContend() + "",
								teat.getYear() + "",
								teat.getTrainingArea() + "",
								teat.getTrainDate() + "", teat.getTrainTime(),
								teat.getGetCertificate() + "",
								teat.getGivenCertificateDepart() + "",
								teat.getIsIndustryTrain() + "",
								teat.getIsPraticeTeachTraining() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 学生国内外交流
			if ("ccc".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (cccList == null || cccList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < cccList.size(); i++) {
						Communicationsitu ccc = (Communicationsitu) cccList
								.get(i);
						if (ccc.getProjCounts() == null) {
							ccc.setProjCounts(0);
						}
						if (ccc.getStuCount() == null) {
							ccc.setStuCount(0);
						}
						Object[] values = {
								ccc.getMajor().getDepartment().getDname(),
								ccc.getMajor().getMname(),
								// ccc.getMajor().getMno(),
								ccc.getProjCounts(), ccc.getStuCount(),
								ccc.getYear() + "", ccc.getNote() + "" };

						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 学生实践毕业设计落实情况
			if ("ful".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (fffList == null || fffList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < fffList.size(); i++) {
						Fulfillinginstance ful = (Fulfillinginstance) fffList
								.get(i);
						if (ful.getStuNumber1() == null) {
							ful.setStuNumber1(0);
						}
						if (ful.getStuNumber2() == null) {
							ful.setStuNumber2(0);
						}
						if (ful.getEndNumber() == null) {
							ful.setEndNumber(0);
						}
						if (ful.getOpenRate() == null) {
							ful.setOpenRate((float) 0);
						}
						if (ful.getFinishRate() == null) {
							ful.setFinishRate((float) 0);
						}

						Object[] values = {
								ful.getMajor().getDepartment().getDname(),
								ful.getMajor().getMname(),
								// ful.getMajor().getMno(),
								ful.getFulType() + "", ful.getStuNumber1(),
								ful.getStuNumber2(), ful.getEndNumber(),
								ful.getOpenRate(), ful.getFinishRate(),
								ful.getYear() + "", ful.getNote() + "" };

						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 创新创业项目列表
			if ("innovap".equals(exportName)) {
				if (innovationprojectlist == null
						|| innovationprojectlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < innovationprojectlist.size(); i++) {
						Innovationproject inno = (Innovationproject) innovationprojectlist
								.get(i);
						if (inno.getCost() == null) {
							inno.setCost("");
						}
						Object[] values = { inno.getInnoNumber(),
								inno.getInnoName() + "", inno.getLevel() + "",
								inno.getType() + "", inno.getYear() + "",
								inno.getCost(),
								df.format(inno.getSetDate()) + "",
								df.format(inno.getEndDate()) + "",

								inno.getAssessment() + "", inno.getNote() + "",
								inno.getTag() + "" };
						// System.out.print("lalalla"+df.format(inno.getSetDate()).toString());
						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof Date) {
								System.out.println("as");
								cell.setCellValue(df.format(values[m]
										.toString()));
							} else if (values[m] instanceof Float) {
								cell.setCellValue(Float.parseFloat(values[m]
										.toString()));
							} else {

								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 竞赛获奖列表
			if ("competition".equals(exportName)) {
				for (Competition c : competitionlist) {
					System.out.println("c.getComName()=" + c.getComName());
				}
				if (competitionlist == null || competitionlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < competitionlist.size(); i++) {
						Competition com = (Competition) competitionlist.get(i);
						Object[] values = { com.getComName() + "",
								com.getComType() + "", com.getComRank() + "",
								com.getYear() + "", com.getNote() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								System.out.println("m1==" + m);
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}

			// 科研成果信息列表
			if ("achievements".equals(exportName)) {
				if (achievementslist == null || achievementslist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < achievementslist.size(); i++) {
						Achievements achi = (Achievements) achievementslist
								.get(i);
						if (achi.getDepartRank() == null) {
							achi.setDepartRank((int) 0);
						}
						if (achi.getTag() == null) {
							achi.setTag((int) 0);
						}
						Object[] values = { achi.getCertificateNo(),
								achi.getCertificateName() + "",
								achi.getDepartRank(),
								achi.getCertificateJibie() + "",
								achi.getCertificateType() + "",
								achi.getCertificateClass() + "",
								achi.getCertificateDate() + "",
								achi.getBeizhu() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof String) {
								cell.setCellValue(String.valueOf(values[m]));
							}
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 科研成果成员表
			if ("teacherachievements".equals(exportName)) {
				if (teacherachievementslist == null
						|| teacherachievementslist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teacherachievementslist.size(); i++) {
						Teacherachievements teachachi = (Teacherachievements) teacherachievementslist
								.get(i);
						Object[] values = {
								teachachi.getTeacher().getTno(),
								teachachi.getTeacher().getTname(),
								teachachi.getAchievements().getCertificateNo(),
								teachachi.getAchievements()
										.getCertificateName(),
								teachachi.getTeachRank(),
								teachachi.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 教学成果成员列表
			if ("teachresult".equals(exportName)) {
				if (teachresultlist == null || teachresultlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teachresultlist.size(); i++) {
						Teachresult teachs = (Teachresult) teachresultlist
								.get(i);
						Object[] values = {
								teachs.getTeacher().getTno(),
								teachs.getTeacher().getTname(),
								teachs.getTeachresultbaseinfo()
										.getTresultBaseNo()
										+ "",
								teachs.getTeachresultbaseinfo()
										.getTresultName(),
								teachs.getTresultRank(),
								teachs.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 质量工程成员列表
			if ("teachprojectuser".equals(exportName)) {
				if (teachprojectuserlist == null
						|| teachprojectuserlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teachprojectuserlist.size(); i++) {
						Teachprojectuser teachpu = (Teachprojectuser) teachprojectuserlist
								.get(i);
						if (teachpu.getRank() == null) {
							teachpu.setRank(0);
						}
						Object[] values = {
								teachpu.getTeacher().getTno() + "",
								teachpu.getTeacher().getTname() + "",
								teachpu.getTeachproject().getTprojectNo() + "",
								teachpu.getTeachproject().getTprojectName()
										+ "", teachpu.getRank(),
								teachpu.getBeizhu() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 教材作者列表
			if ("teachbook".equals(exportName)) {
				if (teachbooklist == null || teachbooklist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teachbooklist.size(); i++) {
						Teachbook teachbk = (Teachbook) teachbooklist.get(i);
						Object[] values = { teachbk.getTeacher().getTno(),
								teachbk.getTeacher().getTname(),

								teachbk.getTeachingbooks().getTbname(),
								teachbk.getTeachingbooks().getIsbn() + "",
								teachbk.getTeachingbooks().getPublisher(),
								teachbk.getAuthorJuese(),
								teachbk.getAuthorRank() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 科创成员列表
			if ("innovationmember".equals(exportName)) {
				if (innovationmemberlist == null
						|| innovationmemberlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < innovationmemberlist.size(); i++) {
						Innovationmember inno = (Innovationmember) innovationmemberlist
								.get(i);
						Object[] values = { inno.getStudent().getStuNumber(),
								inno.getStudent().getStuName(),
								inno.getInnovationproject().getInnoNumber(),
								inno.getInnovationproject().getInnoName(),
								inno.getRank() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 竞赛获奖成员列表
			if ("stucption".equals(exportName)) {
				if (studentcoepetitionlist == null
						|| studentcoepetitionlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < studentcoepetitionlist.size(); i++) {
						Studentcoepetition stup = (Studentcoepetition) studentcoepetitionlist
								.get(i);
						Object[] values = {
								stup.getCompetition().getComName(),
								stup.getCompetition().getComRank(),
								stup.getStudent().getStuName(),
								stup.getStudent().getStuNumber(),
								stup.getStudent().getMajor().getDepartment()
										.getDname(), stup.getRank(),
								stup.getCompetition().getComType(),
								stup.getCompetition().getYear() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}

			// 教学成果列表
			if ("teachresultbaseinfo".equals(exportName)) {
				if (teachresultbaseinfolist == null
						|| teachresultbaseinfolist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teachresultbaseinfolist.size(); i++) {
						Teachresultbaseinfo teachst = (Teachresultbaseinfo) teachresultbaseinfolist
								.get(i);
						Object[] values = { teachst.getTresultName() + "",
								teachst.getTresultJibie() + "",
								teachst.getTresultClass() + "",
								teachst.getYear() + "",
								teachst.getApprovalNumber() + "",
								teachst.getRewardDepart() + "",
								teachst.getBeizhu() };
						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高
						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof String) {
								cell.setCellValue(String.valueOf(values[m]
										.toString()));
							} else {
								cell.setCellValue(String.valueOf(values[m]
										.toString()));
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 质量工程列表
			if ("teachproject".equals(exportName)) {
				if (teachprojectlist == null || teachprojectlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teachprojectlist.size(); i++) {
						Teachproject teachp = (Teachproject) teachprojectlist
								.get(i);
						Object[] values = { teachp.getTprojectNo(),
								teachp.getTprojectName(),
								teachp.getTprojecJibie(),
								teachp.getTprojecType(), teachp.getYear(),
								teachp.getApprovalNumber(), teachp.getBeizhu() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 教材信息列表
			if ("teachbooks".equals(exportName)) {
				if (teachingbookslist == null || teachingbookslist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */

					for (int i = 0; i < teachingbookslist.size(); i++) {
						Teachingbooks teachb = (Teachingbooks) teachingbookslist
								.get(i);
						if (teachb.getBeizhu() == null) {
							teachb.setBeizhu("");
						}
						if (teachb.getBookWords() == null) {
							teachb.setBookWords(0);
						}
						if (teachb.getUseState() == null) {
							teachb.setUseState("");
						}
						if (teachb.getFininshDepartRate() == null) {
							teachb.setFininshDepartRate("");
						}
						Object[] values = { teachb.getTbname(),
								teachb.getIsbn(), teachb.getPublisher(),
								teachb.getYear(),
								df.format(teachb.getPublishTime()) + "",
								teachb.getPublishType(),
								teachb.getTbookJibie(), teachb.getTbookClass(),
								teachb.getTbookRewardClass(),
								teachb.getBookWords(), teachb.getUseState(),
								teachb.getFininshDepartRate() + "",
								teachb.getBeizhu() };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 创新创业项目列表
			if ("innovap".equals(exportName)) {
				if (innovationprojectlist == null
						|| innovationprojectlist.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < innovationprojectlist.size(); i++) {
						Innovationproject inno = (Innovationproject) innovationprojectlist
								.get(i);
						Object[] values = { inno.getInnoNumber(),
								inno.getInnoName() + "", inno.getLevel() + "",
								inno.getType() + "", inno.getYear() + "",
								inno.getCost(), inno.getSetDate() + "",
								inno.getEndDate() + "",
								inno.getAssessment() + "", inno.getNote() + ""/*
																			 * ,
																			 * inno
																			 * .
																			 * getTag
																			 * (
																			 * )
																			 * +
																			 * ""
																			 */};

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else if (values[m] instanceof Float) {
								System.out.println("进入float"
										+ Float
												.parseFloat(values[m]
														.toString()));
								cell.setCellValue(Float.parseFloat(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格

						}
					}
				}
			}
			// 实践教学资源情况
			if ("tui".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (tuiList == null || tuiList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < tuiList.size(); i++) {
						Traininguseinginformation tui = (Traininguseinginformation) tuiList
								.get(i);
						if (tui.getResourceConstructionNumber() == null) {
							tui.setResourceConstructionNumber(0);
						}
						if (tui.getExperimentalEquipmentMean() == null) {
							tui.setExperimentalEquipmentMean(0);
						}
						if (tui.getLaboratorySatisfactionRate() == null) {
							tui.setLaboratorySatisfactionRate((float) 0);
						}
						if (tui.getExperimentNumber() == null) {
							tui.setExperimentNumber(0);
						}
						if (tui.getSchooBaseNumber() == null) {
							tui.setSchooBaseNumber(0);
						}
						if (tui.getOutBaseNumber() == null) {
							tui.setOutBaseNumber(0);
						}
						if (tui.getSchooBaseRate() == null) {
							tui.setSchooBaseRate((float) 0);
						}
						if (tui.getOutBaseRate() == null) {
							tui.setOutBaseRate((float) 0);
						}

						Object[] values = {
								tui.getMajor().getDepartment().getDname(),
								tui.getMajor().getMname(),
								// tui.getMajor().getMno(),
								tui.getResourceConstructionNumber(),
								tui.getExperimentalEquipmentMean(),
								tui.getLaboratorySatisfactionRate(),
								tui.getExperimentNumber(),
								tui.getSchooBaseNumber(),
								tui.getOutBaseNumber(), tui.getSchooBaseRate(),
								tui.getOutBaseRate(), tui.getYear() + "" };
						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教学经费
			if ("tea".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (teaList == null || teaList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teaList.size(); i++) {
						Teachingcost tea = (Teachingcost) teaList.get(i);

						if (tea.getCost() == null) {
							tea.setCost(0.0);
						}

						Object[] values = {
								tea.getMajor().getDepartment().getDname(),/*
																		 * tea.getMajor
																		 * (
																		 * ).getMno
																		 * (),
																		 */
								tea.getMajor().getMname(),
								tea.getTeachingcosttype().getUseType() + "",
								tea.getCost(), tea.getUseness() + "",
								tea.getYear() + "" };
						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 实验实习场地
			if ("traingvenue".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (traingvenueList == null || traingvenueList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < traingvenueList.size(); i++) {
						Trainingvenue trainingvenue = traingvenueList.get(i);
						if (trainingvenue.getUseCount() == null) {
							trainingvenue.setUseCount(0);
						}
						if (trainingvenue.getCourseCount() == null) {
							trainingvenue.setCourseCount(0);
						}
						if (trainingvenue.getPjCount() == null) {
							trainingvenue.setPjCount(0);
						}
						if (trainingvenue.getThHcount() == null) {
							trainingvenue.setThHcount(0);
						}
						if (trainingvenue.getThPcount() == null) {
							trainingvenue.setThPcount(0);
						}
						if (trainingvenue.getYear() == null) {
							trainingvenue.setYear("");
						}
						Object[] values = { trainingvenue.getTraNumer(),
								trainingvenue.getTraName(),
								trainingvenue.getTraCharacter(),
								trainingvenue.getArea() + "",
								trainingvenue.getAptCount() + "",
								trainingvenue.getEaquipAllVal() + "",
								trainingvenue.getEquipVal() + "",
								trainingvenue.getUseCount() + "",
								trainingvenue.getYear() + "" };
						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 实验实习场地使用情况
			if ("traingvenueUse".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (traingvenueuseList == null || traingvenueuseList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < traingvenueuseList.size(); i++) {
						Trainingvenueuse trainingvenueuse = traingvenueuseList
								.get(i);
						Object[] values = {
								trainingvenueuse.getMajor().getMname(),
								trainingvenueuse.getTrainingvenue()
										.getTraNumer(),
								trainingvenueuse.getTrainingvenue()
										.getTraName(),
								trainingvenueuse.getCourseCount() + "",
								trainingvenueuse.getThHcount() + "",
								trainingvenueuse.getThPcount() + "",
								trainingvenueuse.getYear(), };
						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 学院信息
			if ("department".equals(exportName)) {
				/*
				 * 根据是否取出数据，设置header信息
				 */
				if (departmentList == null || departmentList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < departmentList.size(); i++) {
						Department department = departmentList.get(i);
						Object[] values = { department.getDno(),
								department.getDname(), department.getFuzeren() };
						row = sheet.createRow((short) (i + 1)); // 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}

			// 定性指标统计信息
			if ("expertsummary".equals(exportName)) {
				if (fiaList == null || fiaList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < fiaList.size(); i++) {
						FileinfoAttachment fia = (FileinfoAttachment) fiaList
								.get(i);
						String s = "";
						if (fia.getUploadStatus() == 1) {
							s += "已经上传";
						} else {
							s += "未上传";
						}
						Object[] values = {
								fia.getYear() + "",
								fia.getMas().getMajor().getMname() + "",
								fia.getMas().getMasCode() + "",
								fia.getMas().getAssessingneedtarget()
										.getAppraisalsystem()
										.getIndicatorName()
										+ "", s, fia.getAsseisingValue() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 实践教学情况
			if ("practicecoursesummary".equals(exportName)) {
				if (practicecoursesummaryList == null
						|| practicecoursesummaryList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < practicecoursesummaryList.size(); i++) {
						Practicecoursesummary prac = (Practicecoursesummary) practicecoursesummaryList
								.get(i);
						Object[] values = { prac.getMajor().getMno() + "",
								prac.getMajor().getMname() + "",
								prac.getYear() + "",
								prac.getPlanChangeNumber() + "",
								prac.getProfessorTeachTime() + "",
								prac.getInprofessorTteachTime() + "",
								prac.getTeachTotalTime() + "",
								prac.getTotalTeachCost() + "",
								prac.getCourseTotaoNum() + "",
								prac.getOpenCourseTotaoNum() + "",
								prac.getGoodCourseTotaoNum() + "",
								prac.getPracticeBaseTotalNum() + "",
								prac.getStudentPersistProjectNum() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 学生培养情况
			if ("studentculturesummary".equals(exportName)) {
				if (studentculturesummaryList == null
						|| studentculturesummaryList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < studentculturesummaryList.size(); i++) {
						Studentculturesummary stud = (Studentculturesummary) studentculturesummaryList
								.get(i);
						Object[] values = { stud.getMajor().getMno() + "",
								stud.getMajor().getMname() + "",
								stud.getYear() + "",
								stud.getStudentNumber() + "",
								stud.getResearchPaperNumber() + "",
								stud.getPatentNumber() + "",
								stud.getRaceNumber1() + "",
								stud.getRaceNumber2() + "",
								stud.getRaceNumber3() + "",
								stud.getStudentInnovationNumber11() + "",
								stud.getStudentInnovationNumber12() + "",
								stud.getStudentInnovationNumber13() + "",
								stud.getFirstVolunteerRate() + "",
								stud.getPopularityRate() + "",
								stud.getInitialemploymentrate() + "",
								stud.getEmploymentrate() + "",
								stud.getExchangeprojects() + "",
								stud.getExchangepeople() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 专业教师基本情况
			if ("teacherinfosummary".equals(exportName)) {
				if (teacherinfosummaryList == null
						|| teacherinfosummaryList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teacherinfosummaryList.size(); i++) {
						Teacherinfosummary tea = (Teacherinfosummary) teacherinfosummaryList
								.get(i);
						Object[] values = { tea.getMajor().getMno() + "",
								tea.getMajor().getMname() + "",
								tea.getYear() + "",
								tea.getFacultyNumber() + "",
								tea.getStuNumber() + "",
								tea.getProfessionaTteacherNumbers() + "",
								tea.getStudentsTeachersRatio() + "",
								tea.getDoctorNumber() + "",
								tea.getProfessorNuber() + "",
								tea.getAssociateProfessorNumber() + "",
								tea.getTalentnuber1() + "",
								tea.getTalentnuber2() + "",
								tea.getTalentnuber3() + "",
								tea.getIndustryExperienceNumber() + "",
								tea.getYoungTeacherNumber() + "",
								tea.getTrainTeacherNumber() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 教学科研情况
			if ("teacherresearchsummary".equals(exportName)) {
				if (teacherresearchsummaryList == null
						|| teacherresearchsummaryList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < teacherresearchsummaryList.size(); i++) {
						Teacherresearchsummary teasearch = (Teacherresearchsummary) teacherresearchsummaryList
								.get(i);
						Object[] values = {
								teasearch.getMajor().getMno() + "",
								teasearch.getMajor().getMname() + "",
								teasearch.getYear() + "",
								teasearch.getResearchPaperNumber1() + "",
								teasearch.getResearchPaperNumber2() + "",
								teasearch.getResearchPaperNumber3() + "",
								teasearch.getResearchProjectNumber1() + "",
								teasearch.getResearchProjectNumber2() + "",
								teasearch.getResearchProjectNumber3() + "",
								teasearch.getEducationProjectNumber1() + "",
								teasearch.getEducationProjectNumber2() + "",
								teasearch.getEducationProjectNumber3() + "",
								teasearch.getEducationPaperNumber1() + "",
								teasearch.getEducationPaperNumber2() + "",
								teasearch.getEducationPaperNumber3() + "",
								teasearch.getTextbookNumber1() + "",
								teasearch.getQualitylEngineeringNumber1() + "",
								teasearch.getQualitylEngineeringNumber2() + "",
								teasearch.getQualitylEngineeringNumber3() + "",
								teasearch.getTeachingAchievementNumber11() + "",
								teasearch.getTeachingAchievementNumber21() + "",
								teasearch.getTeachingAchievementNumber31() + "",
								teasearch.getTeachingAchievementNumber12() + "",
								teasearch.getTeachingAchievementNumber22() + "",
								teasearch.getTeachingAchievementNumber32() + "",
								teasearch.getTeachingAchievementNumber13() + "",
								teasearch.getTeachingAchievementNumber23() + "",
								teasearch.getTeachingAchievementNumber33() + "",
								teasearch.getResearchAwardNumber111() + "",
								teasearch.getResearchAwardNumber211() + "",
								teasearch.getResearchAwardNumber311() + "",
								teasearch.getResearchAwardNumber121() + "",
								teasearch.getResearchAwardNumber221() + "",
								teasearch.getResearchAwardNumber321() + "",
								teasearch.getResearchAwardNumber131() + "",
								teasearch.getResearchAwardNumber231() + "",
								teasearch.getResearchAwardNumber331() + "",
								teasearch.getResearchAwardNumber112() + "",
								teasearch.getResearchAwardNumber212() + "",
								teasearch.getResearchAwardNumber312() + "",
								teasearch.getResearchAwardNumber122() + "",
								teasearch.getResearchAwardNumber222() + "",
								teasearch.getResearchAwardNumber322() + "",
								teasearch.getResearchAwardNumber132() + "",
								teasearch.getResearchAwardNumber232() + "",
								teasearch.getResearchAwardNumber332() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
			// 专业评估指标统计
			if ("mascore".equals(exportName)) {
				if (scoreList == null || scoreList.size() < 1) {
					header.setCenter("查无资料");
				} else {
					/*
					 * // 给excel填充数据这里需要编写
					 */
					for (int i = 0; i < scoreList.size(); i++) {
						Score score = (Score) scoreList.get(i);
						Object[] values = { score.getMasprojectName(),
								score.getMname(), score.getFirstTarget() + "",
								score.getSecondTarget() + "",
								score.getThirdTarget() + "",
								score.getFouthTarget() + "",
								score.getFifthTarget() + "",
								score.getSixthTarget() + "",
								score.getSeventhTarget() + "",
								score.getEightTarget() + "",
								score.getTotalScore() + "" };

						row = sheet.createRow((short) (i + 1));// 创建第i+1行
						row.setHeight((short) 400);// 设置行高

						for (int m = 0; m < values.length; m++) {
							cell = row.createCell(m);// 创建第i+1行第0列
							if (values[m] instanceof Integer) {
								cell.setCellValue(Integer.parseInt(values[m]
										.toString()));
							} else {
								cell.setCellValue(values[m].toString());
							}// 设置第i+1行第0列的值
							cell.setCellStyle(style1);// 设置风格
						}
					}
				}
			}
		} catch (Exception e) {
			/* e.printStackTrace(); */
		}

		/*
		 * 输出到浏览器
		 */
		HttpServletResponse response = null;// 创建一个HttpServletResponse对象
		OutputStream out = null;// 创建一个输出流对象
		try {
			response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
			out = response.getOutputStream();//
			response.setHeader("Content-disposition", "attachment; filename="
					+ exportName + ".xls");// filename是下载的xls的名，建议最好用英文
			response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
			response.setHeader("Pragma", "No-cache");// 设置头
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头
			workbook.write(out);
			out.flush();
			workbook.write(out);
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
		return null;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public BaseModel getBasemodel() {
		return basemodel;
	}

	public void setBasemodel(BaseModel basemodel) {
		this.basemodel = basemodel;
	}

	public List<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentModel getStudentmodel() {
		return studentmodel;
	}

	public void setStudentmodel(StudentModel studentmodel) {
		this.studentmodel = studentmodel;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public MajorModel getMajormodel() {
		return majormodel;
	}

	public void setMajormodel(MajorModel majormodel) {
		this.majormodel = majormodel;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	// getter and setter
	public EmploymentModel getEmpmodel() {
		return empmodel;
	}

	public void setEmpmodel(EmploymentModel empmodel) {
		this.empmodel = empmodel;
	}

	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	public EmploymentService getEmpService() {
		return empService;
	}

	public void setEmpService(EmploymentService empService) {
		this.empService = empService;
	}

	public CurriculumresourceService getCurService() {
		return curService;
	}

	public void setCurService(CurriculumresourceService curService) {
		this.curService = curService;
	}

	public CurriculumresourceModel getCurmodel() {
		return curmodel;
	}

	public void setCurmodel(CurriculumresourceModel curmodel) {
		this.curmodel = curmodel;
	}

	public AddmissionsService getAdmService() {
		return admService;
	}

	public void setAdmService(AddmissionsService admService) {
		this.admService = admService;
	}

	public AddmissionsModel getAdmmodel() {
		return admmodel;
	}

	public void setAdmmodel(AddmissionsModel admmodel) {
		this.admmodel = admmodel;
	}

	public TrainingvenueUsingService getTrainingvenueuseService() {
		return trainingvenueuseService;
	}

	public void setTrainingvenueuseService(
			TrainingvenueUsingService trainingvenueuseService) {
		this.trainingvenueuseService = trainingvenueuseService;
	}

	public BaseModel getTrausemodel() {
		return trausemodel;
	}

	public void setTrausemodel(BaseModel trausemodel) {
		this.trausemodel = trausemodel;
	}

	public List<Trainingvenueuse> getTraingvenueuseList() {
		return traingvenueuseList;
	}

	public void setTraingvenueuseList(List<Trainingvenueuse> traingvenueuseList) {
		this.traingvenueuseList = traingvenueuseList;
	}

	public QualitystandardService getQuastanService() {
		return quastanService;
	}

	public void setQuastanService(QualitystandardService quastanService) {
		this.quastanService = quastanService;
	}

	public QualitystandardModel getQuastanmodel() {
		return quastanmodel;
	}

	public void setQuastanmodel(QualitystandardModel quastanmodel) {
		this.quastanmodel = quastanmodel;
	}

	public Integer getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(Integer isDownload) {
		this.isDownload = isDownload;
	}

	public TeachingplanchangeService getTplanService() {
		return tplanService;
	}

	public List<Mas> getExportMasList() {
		return exportMasList;
	}

	public void setExportMasList(List<Mas> exportMasList) {
		this.exportMasList = exportMasList;
	}

	public void setTplanService(TeachingplanchangeService tplanService) {
		this.tplanService = tplanService;
	}

	public StuthesisService getStuthesisService() {
		return stuthesisService;
	}

	public void setStuthesisService(StuthesisService stuthesisService) {
		this.stuthesisService = stuthesisService;
	}

	public MajorcourseService getMcourseService() {
		return mcourseService;
	}

	public void setMcourseService(MajorcourseService mcourseService) {
		this.mcourseService = mcourseService;
	}

	public TeachingplanchangeModel getTplanmodel() {
		return tplanmodel;
	}

	public void setTplanmodel(TeachingplanchangeModel tplanmodel) {
		this.tplanmodel = tplanmodel;
	}

	public StuthesisModel getStutmodel() {
		return stutmodel;
	}

	public void setStutmodel(StuthesisModel stutmodel) {
		this.stutmodel = stutmodel;
	}

	public MajorcourseModel getMcoursemodel() {
		return mcoursemodel;
	}

	public void setMcoursemodel(MajorcourseModel mcoursemodel) {
		this.mcoursemodel = mcoursemodel;
	}

	public List<Employment> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employment> empList) {
		this.empList = empList;
	}

	public List<Curriculumresource> getCurList() {
		return curList;
	}

	public void setCurList(List<Curriculumresource> curList) {
		this.curList = curList;
	}

	public List<Addmissions> getAdmList() {
		return admList;
	}

	public void setAdmList(List<Addmissions> admList) {
		this.admList = admList;
	}

	public List<Qualitystandard> getQuastanList() {
		return quastanList;
	}

	public void setQuastanList(List<Qualitystandard> quastanList) {
		this.quastanList = quastanList;
	}

	public List<Teachingplanchange> getTplanList() {
		return tplanList;
	}

	public void setTplanList(List<Teachingplanchange> tplanList) {
		this.tplanList = tplanList;
	}

	public List<Stuthesis> getStutList() {
		return stutList;
	}

	public void setStutList(List<Stuthesis> stutList) {
		this.stutList = stutList;
	}

	public List<Majorcourse> getMcourseList() {
		return mcourseList;
	}

	public void setMcourseList(List<Majorcourse> mcourseList) {
		this.mcourseList = mcourseList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public HighleveltalentService getHighService() {
		return highService;
	}

	public void setHighService(HighleveltalentService highService) {
		this.highService = highService;
	}

	public PresidedScientificService getPresService() {
		return presService;
	}

	public void setPresService(PresidedScientificService presService) {
		this.presService = presService;
	}

	public PresidedRevolutionService getPrerService() {
		return prerService;
	}

	public void setPrerService(PresidedRevolutionService prerService) {
		this.prerService = prerService;
	}

	public CourseModel getCmodel() {
		return cmodel;
	}

	public void setCmodel(CourseModel cmodel) {
		this.cmodel = cmodel;
	}

	public HighleveltalentModel getHmodel() {
		return hmodel;
	}

	public void setHmodel(HighleveltalentModel hmodel) {
		this.hmodel = hmodel;
	}

	public MasService getMasService() {
		return masService;
	}

	public void setMasService(MasService masService) {
		this.masService = masService;
	}

	public PreScientModel getPresmodel() {
		return presmodel;
	}

	public void setPresmodel(PreScientModel presmodel) {
		this.presmodel = presmodel;
	}

	public PreRevolutModel getPrermodel() {
		return prermodel;
	}

	public void setPrermodel(PreRevolutModel prermodel) {
		this.prermodel = prermodel;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Highleveltalent> getHighList() {
		return highList;
	}

	public void setHighList(List<Highleveltalent> highList) {
		this.highList = highList;
	}

	public List<Presidedoverscientificresearchproject> getPresList() {
		return presList;
	}

	public void setPresList(List<Presidedoverscientificresearchproject> presList) {
		this.presList = presList;
	}

	public List<Presidedoverrevolutionresearchproject> getPrerList() {
		return prerList;
	}

	public void setPrerList(List<Presidedoverrevolutionresearchproject> prerList) {
		this.prerList = prerList;
	}

	public StupatentService getStupatentService() {
		return stupatentService;
	}

	public void setStupatentService(StupatentService stupatentService) {
		this.stupatentService = stupatentService;
	}

	public StupatentModel getStupmodel() {
		return stupmodel;
	}

	public void setStupmodel(StupatentModel stupmodel) {
		this.stupmodel = stupmodel;
	}

	public List<Stupatent> getStupList() {
		return stupList;
	}

	public void setStupList(List<Stupatent> stupList) {
		this.stupList = stupList;
	}

	public EffectqualityeducationService getEffectqualityeducationService() {
		return effectqualityeducationService;
	}

	public void setEffectqualityeducationService(
			EffectqualityeducationService effectqualityeducationService) {
		this.effectqualityeducationService = effectqualityeducationService;
	}

	public PublicshedaacademicpapersService getPublicshedaacademicpapersService() {
		return publicshedaacademicpapersService;
	}

	public void setPublicshedaacademicpapersService(
			PublicshedaacademicpapersService publicshedaacademicpapersService) {
		this.publicshedaacademicpapersService = publicshedaacademicpapersService;
	}

	public PublicshedarevolutionpapersService getPublicshedarevolutionpapersService() {
		return publicshedarevolutionpapersService;
	}

	public void setPublicshedarevolutionpapersService(
			PublicshedarevolutionpapersService publicshedarevolutionpapersService) {
		this.publicshedarevolutionpapersService = publicshedarevolutionpapersService;
	}

	public TeachertrainingService getTeachertrainingService() {
		return teachertrainingService;
	}

	public void setTeachertrainingService(
			TeachertrainingService teachertrainingService) {
		this.teachertrainingService = teachertrainingService;
	}

	public PublicshedaacademicpapersModel getPapmodel() {
		return papmodel;
	}

	public void setPapmodel(PublicshedaacademicpapersModel papmodel) {
		this.papmodel = papmodel;
	}

	public PublicshedarevolutionpapersModel getPepmodel() {
		return pepmodel;
	}

	public void setPepmodel(PublicshedarevolutionpapersModel pepmodel) {
		this.pepmodel = pepmodel;
	}

	public EffectqualityeducationModel getEqemodel() {
		return eqemodel;
	}

	public void setEqemodel(EffectqualityeducationModel eqemodel) {
		this.eqemodel = eqemodel;
	}

	public TeachertrainingModel getTeatmodel() {
		return teatmodel;
	}

	public void setTeatmodel(TeachertrainingModel teatmodel) {
		this.teatmodel = teatmodel;
	}

	public List<Effectofqualityeducation> getEfList() {
		return efList;
	}

	public void setEfList(List<Effectofqualityeducation> efList) {
		this.efList = efList;
	}

	public List<Publicshedaacademicpapers> getPapList() {
		return papList;
	}

	public void setPapList(List<Publicshedaacademicpapers> papList) {
		this.papList = papList;
	}

	public List<Publicshedarevolutionpapers> getPepList() {
		return pepList;
	}

	public void setPepList(List<Publicshedarevolutionpapers> pepList) {
		this.pepList = pepList;
	}

	public List<Teachertraining> getTeatList() {
		return teatList;
	}

	public void setTeatList(List<Teachertraining> teatList) {
		this.teatList = teatList;
	}

	public CommunicationsituService getCommunicationsituService() {
		return communicationsituService;
	}

	public void setCommunicationsituService(
			CommunicationsituService communicationsituService) {
		this.communicationsituService = communicationsituService;
	}

	public FulfillinginstanceService getFulfillinginstanceService() {
		return fulfillinginstanceService;
	}

	public void setFulfillinginstanceService(
			FulfillinginstanceService fulfillinginstanceService) {
		this.fulfillinginstanceService = fulfillinginstanceService;
	}

	public CommunicationsituModel getCommodel() {
		return commodel;
	}

	public void setCommodel(CommunicationsituModel commodel) {
		this.commodel = commodel;
	}

	public FulfillinginstanceModel getFulmodel() {
		return fulmodel;
	}

	public void setFulmodel(FulfillinginstanceModel fulmodel) {
		this.fulmodel = fulmodel;
	}

	public List<Communicationsitu> getCccList() {
		return cccList;
	}

	public void setCccList(List<Communicationsitu> cccList) {
		this.cccList = cccList;
	}

	public List<Fulfillinginstance> getFffList() {
		return fffList;
	}

	public void setFffList(List<Fulfillinginstance> fffList) {
		this.fffList = fffList;
	}

	public TeachResultBaseService getTeachResultBaseService() {
		return teachResultBaseService;
	}

	public void setTeachResultBaseService(
			TeachResultBaseService teachResultBaseService) {
		this.teachResultBaseService = teachResultBaseService;
	}

	public TeachReBaseModel getTeachReBaseModel() {
		return teachReBaseModel;
	}

	public void setTeachReBaseModel(TeachReBaseModel teachReBaseModel) {
		this.teachReBaseModel = teachReBaseModel;
	}

	public List<Teachresultbaseinfo> getTeachresultbaseinfolist() {
		return teachresultbaseinfolist;
	}

	public void setTeachresultbaseinfolist(
			List<Teachresultbaseinfo> teachresultbaseinfolist) {
		this.teachresultbaseinfolist = teachresultbaseinfolist;
	}

	public AchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public CompetitionService getCompetitionService() {
		return competitionService;
	}

	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public InnovationprojectService getInnovationprojectService() {
		return innovationprojectService;
	}

	public void setInnovationprojectService(
			InnovationprojectService innovationprojectService) {
		this.innovationprojectService = innovationprojectService;
	}

	public TeachBooksService getTeachBooksService() {
		return teachBooksService;
	}

	public void setTeachBooksService(TeachBooksService teachBooksService) {
		this.teachBooksService = teachBooksService;
	}

	public TeachprojectService getTeachprojectService() {
		return teachprojectService;
	}

	public void setTeachprojectService(TeachprojectService teachprojectService) {
		this.teachprojectService = teachprojectService;
	}
	

	

	public String getMajorNum() {
		return majorNum;
	}

	public void setMajorNum(String majorNum) {
		this.majorNum = majorNum;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public AchieveModel getAmodel() {
		return amodel;
	}

	public void setAmodel(AchieveModel amodel) {
		this.amodel = amodel;
	}

	public CompetitionModel getComodel() {
		return comodel;
	}

	public void setComodel(CompetitionModel comodel) {
		this.comodel = comodel;
	}

	public InnovationModel getInnovationModel() {
		return innovationModel;
	}

	public void setInnovationModel(InnovationModel innovationModel) {
		this.innovationModel = innovationModel;
	}

	public TeachBooksModel getTeachBooksModel() {
		return teachBooksModel;
	}

	public void setTeachBooksModel(TeachBooksModel teachBooksModel) {
		this.teachBooksModel = teachBooksModel;
	}

	public TeachprojectModel getTeachprojectModel() {
		return teachprojectModel;
	}

	public void setTeachprojectModel(TeachprojectModel teachprojectModel) {
		this.teachprojectModel = teachprojectModel;
	}

	public List<Achievements> getAchievementslist() {
		return achievementslist;
	}

	public void setAchievementslist(List<Achievements> achievementslist) {
		this.achievementslist = achievementslist;
	}

	public List<Competition> getCompetitionlist() {
		return competitionlist;
	}

	public void setCompetitionlist(List<Competition> competitionlist) {
		this.competitionlist = competitionlist;
	}

	public List<Innovationproject> getInnovationprojectlist() {
		return innovationprojectlist;
	}

	public void setInnovationprojectlist(
			List<Innovationproject> innovationprojectlist) {
		this.innovationprojectlist = innovationprojectlist;
	}

	public List<Teachingbooks> getTeachingbookslist() {
		return teachingbookslist;
	}

	public void setTeachingbookslist(List<Teachingbooks> teachingbookslist) {
		this.teachingbookslist = teachingbookslist;
	}

	public List<Teachproject> getTeachprojectlist() {
		return teachprojectlist;
	}

	public void setTeachprojectlist(List<Teachproject> teachprojectlist) {
		this.teachprojectlist = teachprojectlist;
	}

	public StuCptionService getStuCptionService() {
		return stuCptionService;
	}

	public void setStuCptionService(StuCptionService stuCptionService) {
		this.stuCptionService = stuCptionService;
	}

	public InnovationmemberService getInnovationmemberService() {
		return innovationmemberService;
	}

	public void setInnovationmemberService(
			InnovationmemberService innovationmemberService) {
		this.innovationmemberService = innovationmemberService;
	}

	public TeachBookService getTeachBookService() {
		return teachBookService;
	}

	public void setTeachBookService(TeachBookService teachBookService) {
		this.teachBookService = teachBookService;
	}

	public TeachprojectuserService getTeachprojectuserService() {
		return teachprojectuserService;
	}

	public void setTeachprojectuserService(
			TeachprojectuserService teachprojectuserService) {
		this.teachprojectuserService = teachprojectuserService;
	}

	public TeachResultService getTeachResultService() {
		return teachResultService;
	}

	public void setTeachResultService(TeachResultService teachResultService) {
		this.teachResultService = teachResultService;
	}

	public TeachAchieveService getTeachAchieveService() {
		return teachAchieveService;
	}

	public void setTeachAchieveService(TeachAchieveService teachAchieveService) {
		this.teachAchieveService = teachAchieveService;
	}

	public Studentcoepetition getStudentcoepetition() {
		return studentcoepetition;
	}

	public void setStudentcoepetition(Studentcoepetition studentcoepetition) {
		this.studentcoepetition = studentcoepetition;
	}

	public Innovationmember getInnovationmember() {
		return innovationmember;
	}

	public void setInnovationmember(Innovationmember innovationmember) {
		this.innovationmember = innovationmember;
	}

	public Teachbook getTeachbook() {
		return teachbook;
	}

	public void setTeachbook(Teachbook teachbook) {
		this.teachbook = teachbook;
	}

	public Teachprojectuser getTeachprojectuser() {
		return teachprojectuser;
	}

	public void setTeachprojectuser(Teachprojectuser teachprojectuser) {
		this.teachprojectuser = teachprojectuser;
	}

	public Teachresult getTeachresult() {
		return teachresult;
	}

	public void setTeachresult(Teachresult teachresult) {
		this.teachresult = teachresult;
	}

	public Teacherachievements getTeacherachievements() {
		return teacherachievements;
	}

	public void setTeacherachievements(Teacherachievements teacherachievements) {
		this.teacherachievements = teacherachievements;
	}

	public List<Studentcoepetition> getStudentcoepetitionlist() {
		return studentcoepetitionlist;
	}

	public void setStudentcoepetitionlist(
			List<Studentcoepetition> studentcoepetitionlist) {
		this.studentcoepetitionlist = studentcoepetitionlist;
	}

	public List<Innovationmember> getInnovationmemberlist() {
		return innovationmemberlist;
	}

	public void setInnovationmemberlist(
			List<Innovationmember> innovationmemberlist) {
		this.innovationmemberlist = innovationmemberlist;
	}

	public List<Teachbook> getTeachbooklist() {
		return teachbooklist;
	}

	public void setTeachbooklist(List<Teachbook> teachbooklist) {
		this.teachbooklist = teachbooklist;
	}

	public List<Teachprojectuser> getTeachprojectuserlist() {
		return teachprojectuserlist;
	}

	public void setTeachprojectuserlist(
			List<Teachprojectuser> teachprojectuserlist) {
		this.teachprojectuserlist = teachprojectuserlist;
	}

	public List<Teachresult> getTeachresultlist() {
		return teachresultlist;
	}

	public void setTeachresultlist(List<Teachresult> teachresultlist) {
		this.teachresultlist = teachresultlist;
	}

	public List<Teacherachievements> getTeacherachievementslist() {
		return teacherachievementslist;
	}

	public void setTeacherachievementslist(
			List<Teacherachievements> teacherachievementslist) {
		this.teacherachievementslist = teacherachievementslist;
	}

	public String getComNumber() {
		return comNumber;
	}

	public void setComNumber(String comNumber) {
		this.comNumber = comNumber;
	}

	public String getInsNumber() {
		return insNumber;
	}

	public void setInsNumber(String insNumber) {
		this.insNumber = insNumber;
	}

	public TraininguseinginformationService getTraininguseinginformationService() {
		return traininguseinginformationService;
	}

	public void setTraininguseinginformationService(
			TraininguseinginformationService traininguseinginformationService) {
		this.traininguseinginformationService = traininguseinginformationService;
	}

	public TeachingcostService getTeachingcostService() {
		return teachingcostService;
	}

	public void setTeachingcostService(TeachingcostService teachingcostService) {
		this.teachingcostService = teachingcostService;
	}

	public TraininguseinginformationModel getTuimodel() {
		return tuimodel;
	}

	public void setTuimodel(TraininguseinginformationModel tuimodel) {
		this.tuimodel = tuimodel;
	}

	public TeachingcostModel getTeamodel() {
		return teamodel;
	}

	public void setTeamodel(TeachingcostModel teamodel) {
		this.teamodel = teamodel;
	}

	public List<Traininguseinginformation> getTuiList() {
		return tuiList;
	}

	public void setTuiList(List<Traininguseinginformation> tuiList) {
		this.tuiList = tuiList;
	}

	public List<Teachingcost> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<Teachingcost> teaList) {
		this.teaList = teaList;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TeacherModel getTeachermodel() {
		return teachermodel;
	}

	public void setTeachermodel(TeacherModel teachermodel) {
		this.teachermodel = teachermodel;
	}

	public List<Teacher> getTeacList() {
		return teacList;
	}

	public void setTeacList(List<Teacher> teacList) {
		this.teacList = teacList;
	}

	public void setStuComNumber(int stuComNumber) {
		this.stuComNumber = stuComNumber;
	}

	public int getStuComNumber() {
		return stuComNumber;
	}

	public void setTrainingvenueService(
			TrainingvenueService trainingvenueService) {
		this.trainingvenueService = trainingvenueService;
	}

	public TrainingvenueService getTrainingvenueService() {
		return trainingvenueService;
	}

	public void setTraingvenueList(List<Trainingvenue> traingvenueList) {
		this.traingvenueList = traingvenueList;
	}

	public List<Trainingvenue> getTraingvenueList() {
		return traingvenueList;
	}

	public TrainingvenueModel getTramodel() {
		return tramodel;
	}

	public void setTramodel(TrainingvenueModel tramodel) {
		this.tramodel = tramodel;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public BaseModel getDepartmentmodel() {
		return departmentmodel;
	}

	public void setDepartmentmodel(BaseModel departmentmodel) {
		this.departmentmodel = departmentmodel;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public void setFiaList(List<FileinfoAttachment> fiaList) {
		this.fiaList = fiaList;
	}

	public List<FileinfoAttachment> getFiaList() {
		return fiaList;
	}

	public void setFiamodel(FileinfoAttachmentModel fiamodel) {
		this.fiamodel = fiamodel;
	}

	public FileinfoAttachmentModel getFiamodel() {
		return fiamodel;
	}

	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}

	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}

	public void setPracticecoursesummaryList(
			List<Practicecoursesummary> practicecoursesummaryList) {
		this.practicecoursesummaryList = practicecoursesummaryList;
	}

	public List<Practicecoursesummary> getPracticecoursesummaryList() {
		return practicecoursesummaryList;
	}

	public void setPracticecoursesummaryModel(
			PracticecoursesummaryModel practicecoursesummaryModel) {
		this.practicecoursesummaryModel = practicecoursesummaryModel;
	}

	public PracticecoursesummaryModel getPracticecoursesummaryModel() {
		return practicecoursesummaryModel;
	}

	public void setTeacherinfosummaryModel(
			TeacherinfosummaryModel teacherinfosummaryModel) {
		this.teacherinfosummaryModel = teacherinfosummaryModel;
	}

	public TeacherinfosummaryModel getTeacherinfosummaryModel() {
		return teacherinfosummaryModel;
	}

	public void setTeacherresearchsummaryModel(
			TeacherresearchSummaryModel teacherresearchsummaryModel) {
		this.teacherresearchsummaryModel = teacherresearchsummaryModel;
	}

	public TeacherresearchSummaryModel getTeacherresearchsummaryModel() {
		return teacherresearchsummaryModel;
	}

	public void setStudentculturesummaryModel(
			StudentculturesummaryModel studentculturesummaryModel) {
		this.studentculturesummaryModel = studentculturesummaryModel;
	}

	public StudentculturesummaryModel getStudentculturesummaryModel() {
		return studentculturesummaryModel;
	}

	public void setTeacherinfosummaryList(
			List<Teacherinfosummary> teacherinfosummaryList) {
		this.teacherinfosummaryList = teacherinfosummaryList;
	}

	public List<Teacherinfosummary> getTeacherinfosummaryList() {
		return teacherinfosummaryList;
	}

	public void setTeacherresearchsummaryList(
			List<Teacherresearchsummary> teacherresearchsummaryList) {
		this.teacherresearchsummaryList = teacherresearchsummaryList;
	}

	public List<Teacherresearchsummary> getTeacherresearchsummaryList() {
		return teacherresearchsummaryList;
	}

	public void setStudentculturesummaryList(
			List<Studentculturesummary> studentculturesummaryList) {
		this.studentculturesummaryList = studentculturesummaryList;
	}

	public List<Studentculturesummary> getStudentculturesummaryList() {
		return studentculturesummaryList;
	}

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public SummaryService getSummaryService() {
		return summaryService;
	}

	public ExpertadviceService getExpertAdviceService() {
		return expertAdviceService;
	}

	public void setExpertAdviceService(ExpertadviceService expertAdviceService) {
		this.expertAdviceService = expertAdviceService;
	}

	public List<Expertadvice> getExpertAdviceList() {
		return expertAdviceList;
	}

	public void setExpertAdviceList(List<Expertadvice> expertAdviceList) {
		this.expertAdviceList = expertAdviceList;
	}
	
}
