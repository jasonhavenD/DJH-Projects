package cn.edu.nwsuaf.comAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nwsuaf.Service.Impl.AcademicdegreeService;
import cn.edu.nwsuaf.Service.Impl.AchievementService;
import cn.edu.nwsuaf.Service.Impl.AddmissionsService;
import cn.edu.nwsuaf.Service.Impl.CommunicationsituService;
import cn.edu.nwsuaf.Service.Impl.CompetitionService;
import cn.edu.nwsuaf.Service.Impl.CourseService;
import cn.edu.nwsuaf.Service.Impl.CurriculumresourceService;
import cn.edu.nwsuaf.Service.Impl.DegreeService;
import cn.edu.nwsuaf.Service.Impl.DepartmentService;
import cn.edu.nwsuaf.Service.Impl.EffectqualityeducationService;
import cn.edu.nwsuaf.Service.Impl.EmploymentService;
import cn.edu.nwsuaf.Service.Impl.FulfillinginstanceService;
import cn.edu.nwsuaf.Service.Impl.HighleveltalentService;
import cn.edu.nwsuaf.Service.Impl.InnovationmemberService;
import cn.edu.nwsuaf.Service.Impl.InnovationprojectService;
import cn.edu.nwsuaf.Service.Impl.JobTypeService;
import cn.edu.nwsuaf.Service.Impl.LearningEdgeService;
import cn.edu.nwsuaf.Service.Impl.MajorService;
import cn.edu.nwsuaf.Service.Impl.MajorcourseService;
import cn.edu.nwsuaf.Service.Impl.NationalService;
import cn.edu.nwsuaf.Service.Impl.PresidedRevolutionService;
import cn.edu.nwsuaf.Service.Impl.PresidedScientificService;
import cn.edu.nwsuaf.Service.Impl.ProfessionalTitleService;
import cn.edu.nwsuaf.Service.Impl.PublicshedaacademicpapersService;
import cn.edu.nwsuaf.Service.Impl.PublicshedarevolutionpapersService;
import cn.edu.nwsuaf.Service.Impl.QualitystandardService;
import cn.edu.nwsuaf.Service.Impl.StuCptionService;
import cn.edu.nwsuaf.Service.Impl.StudentService;
import cn.edu.nwsuaf.Service.Impl.StupatentService;
import cn.edu.nwsuaf.Service.Impl.StuthesisService;
import cn.edu.nwsuaf.Service.Impl.SubjectCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeachAchieveService;
import cn.edu.nwsuaf.Service.Impl.TeachBookService;
import cn.edu.nwsuaf.Service.Impl.TeachBooksService;
import cn.edu.nwsuaf.Service.Impl.TeachResultBaseService;
import cn.edu.nwsuaf.Service.Impl.TeachResultService;
import cn.edu.nwsuaf.Service.Impl.TeacherService;
import cn.edu.nwsuaf.Service.Impl.TeachersCategoryService;
import cn.edu.nwsuaf.Service.Impl.TeachertrainingService;
import cn.edu.nwsuaf.Service.Impl.TeachingcostService;
import cn.edu.nwsuaf.Service.Impl.TeachingcosttypeService;
import cn.edu.nwsuaf.Service.Impl.TeachingplanchangeService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectService;
import cn.edu.nwsuaf.Service.Impl.TeachprojectuserService;
import cn.edu.nwsuaf.Service.Impl.TraininguseinginformationService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueService;
import cn.edu.nwsuaf.Service.Impl.TrainingvenueUsingService;
import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Achievements;
import cn.edu.nwsuaf.bean.Addmissions;
import cn.edu.nwsuaf.bean.Communicationsitu;
import cn.edu.nwsuaf.bean.Competition;
import cn.edu.nwsuaf.bean.Course;
import cn.edu.nwsuaf.bean.Curriculumresource;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Department;
import cn.edu.nwsuaf.bean.Effectofqualityeducation;
import cn.edu.nwsuaf.bean.Employment;
import cn.edu.nwsuaf.bean.Fulfillinginstance;
import cn.edu.nwsuaf.bean.Highleveltalent;
import cn.edu.nwsuaf.bean.Innovationmember;
import cn.edu.nwsuaf.bean.Innovationproject;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Majorcourse;
import cn.edu.nwsuaf.bean.National;
import cn.edu.nwsuaf.bean.Presidedoverrevolutionresearchproject;
import cn.edu.nwsuaf.bean.Presidedoverscientificresearchproject;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Publicshedaacademicpapers;
import cn.edu.nwsuaf.bean.Publicshedarevolutionpapers;
import cn.edu.nwsuaf.bean.Qualitystandard;
import cn.edu.nwsuaf.bean.Student;
import cn.edu.nwsuaf.bean.Studentcoepetition;
import cn.edu.nwsuaf.bean.Stupatent;
import cn.edu.nwsuaf.bean.Stuthesis;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teachbook;
import cn.edu.nwsuaf.bean.Teacher;
import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.bean.Teacherscategory;
import cn.edu.nwsuaf.bean.Teachertraining;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.bean.Teachingcost;
import cn.edu.nwsuaf.bean.Teachingcosttype;
import cn.edu.nwsuaf.bean.Teachingplanchange;
import cn.edu.nwsuaf.bean.Teachproject;
import cn.edu.nwsuaf.bean.Teachprojectuser;
import cn.edu.nwsuaf.bean.Teachresult;
import cn.edu.nwsuaf.bean.Teachresultbaseinfo;
import cn.edu.nwsuaf.bean.Traininguseinginformation;
import cn.edu.nwsuaf.bean.Trainingvenue;
import cn.edu.nwsuaf.bean.Trainingvenueuse;
import cn.edu.nwsuaf.util.FileTools;
import cn.edu.nwsuaf.util.QueryUtil;

/**
 * 导入Excel文件信息
 * 
 * @author wal
 * 
 */
public class ImportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String excelFile;// File对象，目的是获取页面上传的文件
	private int totalRows = 0;
	private int totalCells = 0;
	private int contestId;
	private String importName;
	private String certificateNo;
	private String courseNo;
	private String presNo;
	private String prerNo;
	private String teacherNo;
	// private int comNumber;// 竞赛编号
	// Service
	private PublicshedaacademicpapersService publicshedaacademicpapersService;
	private PublicshedarevolutionpapersService publicshedarevolutionpapersService;
	private TeachertrainingService teachertrainingService;
	private EffectqualityeducationService eqeService;
	private NationalService nationalService;// 民族
	private StupatentService stupatentService;
	private EmploymentService empService;// 就业情况
	private MajorService majorService;// 专业
	private CourseService courseService;// 课程
	private CurriculumresourceService curService;// 专业课程资源
	private AddmissionsService admService;// 招生情况
	private QualitystandardService quastanService;// 课程质量标准
	private AchievementService achievementService;// 科研成果信息
	private CompetitionService competitionService;// 获奖竞赛列表
	private TeachBooksService teachBooksService;// 教材信息列表
	private TeachprojectService teachprojectService;// 教学质量工程列表
	private TeachResultBaseService teachResultBaseService;// 教学成果列表
	private InnovationprojectService innovationprojectService;// 创新创业列表
	private TeachingplanchangeService tplanService;// 教学计划变更
	private StuthesisService stuthesisService;// 学生发表论文
	private MajorcourseService mcourseService;// 专业课开课
	private StudentService studentService;// 学生

	private StuCptionService stuCptionService;// 竞赛获奖成员列表
	private InnovationmemberService innovationmemberService;// 科创成员列表
	private TeachBookService teachBookService; // 教材作者表
	private TeachprojectuserService teachprojectuserService; // 质量工程成员表
	private TeachResultService teachResultService;// 教学成果成员列表
	private TeachAchieveService teachAchieveService;// 科研成果成员列表
	private TeachingcostService teachingcostService;// 教学经费
	private TeachingcosttypeService teachingcosttypeService;// 教学经费类型

	private CommunicationsituService communicationsituService;// 学生国内外交流
	private FulfillinginstanceService fulfillinginstanceService;// 实习实践毕业设计
	private TraininguseinginformationService traininguseinginformationService;// 实践教学资源
	private DepartmentService departmentService;// 学院信息列表
	private HighleveltalentService highService;// 高层次人才信息列表
	private PresidedScientificService presService;// 主持科研项目列表
	private PresidedRevolutionService prerService;// 主持教改项目列表
	private TeacherService teacherService;// 教师

	private DegreeService degreeService;// 学历
	private ProfessionalTitleService professionalTitleService;// 教师职称项目列表
	private AcademicdegreeService academicdegreeService;// 学位项目列表
	private TeachersCategoryService teachersCategoryService;// 师资类别
	private LearningEdgeService learningEdgeService;// 学缘
	private JobTypeService jobTypeService;// 岗位类型
	private SubjectCategoryService subjectCategoryService;// 学科类别
	private TrainingvenueService trainingvenueService;// 实验实训场地
	private TrainingvenueUsingService trainingvenueuseService;// 实验实训场地使用情况

	// 输出列表
	private List<Teachertraining> teatList = new ArrayList<Teachertraining>();// 教师进修
	private List<Publicshedaacademicpapers> papList = new ArrayList<Publicshedaacademicpapers>();// 科研论文
	private List<Publicshedarevolutionpapers> pepList = new ArrayList<Publicshedarevolutionpapers>();// 教改论文
	private List<Effectofqualityeducation> eqeList = new ArrayList<Effectofqualityeducation>();// 人文素质教育
	private List<Student> studentList = new ArrayList<Student>();// 学生获得专利
	private List<Stupatent> stupList = new ArrayList<Stupatent>();// 学生获得专利
	private List<Employment> empList = new ArrayList<Employment>();// 就业情况
	private List<Curriculumresource> curList = new ArrayList<Curriculumresource>();// 专业课程资源
	private List<Addmissions> admList = new ArrayList<Addmissions>();// 招生情况
	private List<Qualitystandard> quastanList = new ArrayList<Qualitystandard>();// 课程质量标准
	private List<Achievements> achievementslist = new ArrayList<Achievements>();// 科研成果信息列表
	private List<Competition> competitionlist = new ArrayList<Competition>();// 竞赛获奖列表
	private List<Innovationproject> innovationprojectlist = new ArrayList<Innovationproject>();// 创新创业项目列表
	private List<Teachingbooks> teachingbookslist = new ArrayList<Teachingbooks>();// 教材信息列表
	private List<Teachproject> teachprojectlist = new ArrayList<Teachproject>();// 质量工程列表
	private List<Teachresultbaseinfo> teachresultbaseinfolist = new ArrayList<Teachresultbaseinfo>();// 教学成果列表
	private List<Teachingplanchange> tplanList = new ArrayList<Teachingplanchange>();// 教学计划变更
	private List<Stuthesis> stutList = new ArrayList<Stuthesis>();// 学生发表论文
	private List<Majorcourse> mcourseList = new ArrayList<Majorcourse>();// 专业课开课
	private List<Studentcoepetition> studentcoepetitionlist = new ArrayList<Studentcoepetition>();// 竞赛获奖成员列表
	private List<Innovationmember> innovationmemberlist = new ArrayList<Innovationmember>();// 科创成员列表
	private List<Teachbook> teachbooklist = new ArrayList<Teachbook>();// 教材作者列表
	private List<Teachprojectuser> teachprojectuserlist = new ArrayList<Teachprojectuser>();// 质量工程成员表
	private List<Teachresult> teachresultlist = new ArrayList<Teachresult>();// 教学成果成员表
	private List<Teacherachievements> teacherachievementslist = new ArrayList<Teacherachievements>();// 科研成果成员表
	private List<Teachingcost> teachingcostList = new ArrayList<Teachingcost>();// 教学经费
	private List<Communicationsitu> communicationsituList = new ArrayList<Communicationsitu>();// 学生国内外交流
	private List<Fulfillinginstance> fulfillinginstanceList = new ArrayList<Fulfillinginstance>();// 实习实践毕业设计
	private List<Traininguseinginformation> traininguseinginformationList = new ArrayList<Traininguseinginformation>();// 实践教学资源
	private List<Course> courseList = new ArrayList<Course>();// 课程基本信息表
	private List<Teacher> teacherList = new ArrayList<Teacher>();// 教师基本信息表
	private List<Highleveltalent> highList = new ArrayList<Highleveltalent>();// 高层次人才信息表
	private List<Presidedoverscientificresearchproject> presList = new ArrayList<Presidedoverscientificresearchproject>();// 主持科研项目表
	private List<Presidedoverrevolutionresearchproject> prerList = new ArrayList<Presidedoverrevolutionresearchproject>();// 主持教改项目表
	private List<Academicdegree> academicdegreeList = new ArrayList<Academicdegree>();// 学位项目表
	private List<Degree> degreeList = new ArrayList<Degree>();// 学历项目表
	private List<Teacherscategory> teacherscategoryList = new ArrayList<Teacherscategory>();// 师资类别
	private List<Learningedge> learningEdgeList = new ArrayList<Learningedge>();// 学缘类别
	private List<Jobtype> jobtypeList = new ArrayList<Jobtype>();// 岗位类别
	private List<Subjectcategory> subjectCategoryList = new ArrayList<Subjectcategory>();// 学科类别
	private List<Trainingvenue> traingvenueList = new ArrayList<Trainingvenue>();// 实验场地
	private List<Trainingvenueuse> traingvenueuseList = new ArrayList<Trainingvenueuse>();// 实验场地

	/**
	 * 导入Excel文件信息
	 * 
	 * @return
	 * @throws Exception
	 */
	private File attachment;
	private String attachmentFileName;
	private int rol;
	private String errorMessg;
	private String successMessg;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	public String importExcel() throws Exception {
		System.out.println("LOG : ImportAction-importExcel");
		System.out.println("LOG : excelFile" + excelFile);
		System.out.println("LOG : importName" + importName);
		System.out.println("LOG : " + attachment.getName());
		System.out.println("LOG : " + attachmentFileName + "," + attachment);
		try {
			excelFile = FileTools.fileUp(attachment, attachmentFileName,
					"import");
		} catch (Exception e) {
			return ERROR;
		}

		try {
			Workbook workbook = null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			/**
			 * 
			 * 学生开始
			 * 
			 */

			// 错误提示信息

			if (excelFile != null && importName.equals("stud")) {
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);
				studentList.clear();
				errorMessg = "";

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();
				System.out.println("LOG: totalRows = " + this.totalRows);
				
				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}

				/** 循环Excel的行 */
				int rflag = 0;
				
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 学号
						Cell cell_1 = row.getCell(1);// 姓名
						Cell cell_2 = row.getCell(2);// 性别
						Cell cell_3 = row.getCell(3);// 民族
						Cell cell_4 = row.getCell(4);// 专业
						Cell cell_5 = row.getCell(5);// 出生日期
						Cell cell_6 = row.getCell(6);// 年级
						Cell cell_7 = row.getCell(7);// 班级
						Cell cell_8 = row.getCell(8);// 入学年份
						Cell cell_9 = row.getCell(9);// 毕业日期
						Cell cell_10 = row.getCell(10);// 学制
						Cell cell_11 = row.getCell(11);// 是否有学籍
						Cell cell_12 = row.getCell(12);// 是否在校
						Cell cell_13 = row.getCell(13);// 当前学生状态

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Date cellValue_5 = null;
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						Date cellValue_9 = null;
						String cellValue_10 = "";
						String cellValue_11 = "";
						String cellValue_12 = "";
						String cellValue_13 = "";
						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							System.out.println("cell_0 type is ok");
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							System.out.println("cell_0.getCellType() = "
									+ cell_0.getCellType());
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							System.out.println("cell_1 type is ok");
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							System.out.println("cell_2 type is ok");
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}

						System.out.println("cell_5.getCellType() = "
								+ cell_5.getCellType());
						System.out.println("HSSFCell.CELL_TYPE_NUMERIC = "
								+ HSSFCell.CELL_TYPE_NUMERIC);

						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_5)) {
								cellValue_5 = cell_5.getDateCellValue();
							} else {
								errorMessg = "第六列日期型数据格式不正确，格式如YYYY-MM-DD";
								return "error";
							}
						} else {
							errorMessg = "第六列数据类型应该为日期型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_9)) {
								cellValue_9 = cell_9.getDateCellValue();
							} else {
								errorMessg = "第十列日期型数据格式不正确，格式如2015/7/1！";
								return "error";
							}
						} else {
							errorMessg = "第十列数据类型应该为日期型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 = cell_10.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_12.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_12 += cell_12.getStringCellValue();
						} else {
							errorMessg = "第十三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_13.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_13 += cell_13.getStringCellValue();
						} else {
							errorMessg = "第十四列数据类型应该为文本型！";
							return "error";
						}

						Student stud = studentService.findById(Student.class,
								cellValue_0);

						/*
						 * List national
						 * =nationalService.findIdByName(cellValue_3);
						 * 
						 * List national = nationalService
						 * .findEntityByName(cellValue_3);// 测试民族是否符合
						 */
						List major = majorService.findEntityByName(Major.class,
								"mname", cellValue_4);// 测试导入专业数据是否符合
						List national = nationalService.findEntityByName(
								National.class, "nationName", cellValue_3);
						National nationa = null;
						Major Imajor = null;
						if (national.size() != 0) {
							nationa = (National) national.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行民族信息有误，该民族在民族信息库中不存在！";
							continue;
						}
						// }else{
						// errorMessg += "第" + r + "行民族在数据库中不存在！";
						// continue;
						// }
						if (major.size() != 0) {
							Imajor = (Major) major.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// }else{
						// errorMessg += "第" + r + "行专业在数据库中不存在！";
						// continue;
						// }
						String mno = QueryUtil.getUserMno().getMajor().getMno();
						String dno = QueryUtil.getUserMno().getDepartment()
								.getDno();
						if (mno.equals("000000")) {// 最外层校验导入者的身份
							if (nationa != null) {// 校验民族数据是否非法
								if (Imajor != null) {// 校验专业数据是否非法
									if (stud == null) {// 校验是否重复翻入学生数据

										Student stud1 = new Student();

										stud1.setStuNumber(cellValue_0);
										stud1.setStuName(cellValue_1);
										stud1.setSex(cellValue_2);
										stud1.setNational(nationa);
										stud1.setMajor(Imajor);

										stud1.setBirth(cellValue_5);
										stud1.setGrade(cellValue_6);
										stud1.setClass_(cellValue_7);
										stud1.setYear(cellValue_8);
										stud1.setGraduationDate(cellValue_9);
										stud1.setEductionalSystme(Integer
												.parseInt(cellValue_10));
										stud1.setIsRoll(cellValue_11);
										stud1.setIsInSchool(cellValue_12);
										stud1.setStatus(cellValue_13);
										studentList.add(stud1);
									} else {// 导入的学生数据已在数据库存在，这时候是批量更新
										stud.setStuName(cellValue_1);
										stud.setNational(nationa);
										stud.setMajor(Imajor);
										stud.setSex(cellValue_2);
										stud.setBirth(cellValue_5);
										stud.setGrade(cellValue_6);
										stud.setClass_(cellValue_7);
										stud.setYear(cellValue_8);
										stud.setGraduationDate(cellValue_9);
										stud.setEductionalSystme(Integer
												.parseInt(cellValue_10));
										stud.setIsRoll(cellValue_11);
										stud.setIsInSchool(cellValue_12);
										stud.setStatus(cellValue_13);

										/** 保存第r行的第c列 */
										studentList.add(stud);
									}
								} else {
									errorMessg += "第" + rflag + "行专业数据列数据项有误！";
									continue;
								}
							} else {
								errorMessg += "第" + rflag + "行民族数据列数据项有误！";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据！";
							continue;
						}

					}
				}
				System.out.println(studentList.size());
				// 更新数据库：
				studentService.batchUpdateResult(Student.class, studentList);
				setSuccessMessg("您此次导入了" + studentList.size() + "条学生基本信息 !"
						+ errorMessg);
			}

			/**
			 * 
			 * 学生结束
			 * 
			 */

			// 学生获得专利
			if (excelFile != null && importName.equals("stup")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				stupList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0); // 编号
						Cell cell_1 = row.getCell(0);// 专利号
						Cell cell_2 = row.getCell(1);// 专利名称
						Cell cell_3 = row.getCell(2);// 申请人学号
						Cell cell_4 = row.getCell(3);// 申请人姓名
						// Cell cell_5 = row.getCell(4);// 获取年份
						Cell cell_6 = row.getCell(4);// 授权日期
						Cell cell_7 = row.getCell(5);// 专利类别
						Cell cell_8 = row.getCell(6);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						// String cellValue_5 = "";
						Date cellValue_6 = null;
						String cellValue_7 = "";
						String cellValue_8 = "";

						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						// cellValue_0 = cell_0.getNumericCellValue();
						// }
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_6)) {
								cellValue_6 = cell_6.getDateCellValue();
							} else {
								errorMessg = "第五列日期型数据格式不正确，格式如2015/7/1！";
								return "error";
							}
						} else {
							errorMessg = "第五列数据类型应该为日期型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						// cellValue_5 += cell_5.getStringCellValue();

						// contestId = cellValue_0.intValue();

						String mno = QueryUtil.getUserMno().getMajor().getMno();

						Student student = studentService.findById(
								Student.class, cellValue_3);

						/*
						 * System.out.println("cellValue_4"+cellValue_4);
						 * System.out.println("cellValue_3"+cellValue_3);
						 * System.out.println("ss"+student.getStuNumber());
						 * System.out.println("sname"+student.getStuName());
						 */
						if (mno.equals("000000")
								|| mno.equals(student.getMajor().getMno())) {
							if (student != null) {
								if (cellValue_4.equals(student.getStuName())) {

									Stupatent stup1 = new Stupatent();
									stup1.setPatentNumber(cellValue_1);
									stup1.setPateName(cellValue_2);
									student.setStuNumber(cellValue_3);
									stup1.setStudent(student);
									stup1.setYear(String.valueOf(cellValue_6
											.getYear() + 1900));
									stup1.setAuthorityDate(cellValue_6);
									stup1.setPateType(cellValue_7);
									stup1.setNote(cellValue_8);
									stupList.add(stup1);
								} else {
									errorMessg += "第" + rflag
											+ "行申请人姓名与数据库中申请人姓名信息不匹配！";
									continue;
								}
							} else {
								errorMessg += "第" + rflag + "行申请人在数据库中不存在！";
								continue;

							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据！";
							continue;
						}

					}
				}
				// 更新数据库：
				stupatentService.batchUpdateResult(Stupatent.class, stupList);
				successMessg = "您此次导入了" + stupList.size() + "条学生专利信息！";
				successMessg += errorMessg;

			}
			// 教师发表科研论文
			if (excelFile != null && importName.equals("pap")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				papList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0); // 编号
						// Cell cell_1 = row.getCell(2);// 教师编号
						Cell cell_2 = row.getCell(0);// 论文名称
						Cell cell_3 = row.getCell(3);// 发表期刊信息
						Cell cell_4 = row.getCell(4);// 论文类别
						Cell cell_5 = row.getCell(5);// 影响因子
						Cell cell_6 = row.getCell(6);// 发表年份
						Cell cell_7 = row.getCell(7);// 备注
						Cell cell_8 = row.getCell(1);// 教师姓名
						Cell cell_9 = row.getCell(2);// 学院名称
						// Cell cell_10 = row.getCell(2);// 专业名称

						// Double cellValue_0;
						// String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						// String cellValue_10 = "";
						/*
						 * if (cell_0 == null) { cellValue_0 = -1.0; } else {
						 * cellValue_0 = cell_0.getNumericCellValue(); }
						 */
						// cellValue_1 += cell_1.getStringCellValue();
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}

						// cellValue_10 += cell_10.getStringCellValue();
						/*
						 * contestId = cellValue_0.intValue();
						 * Publicshedaacademicpapers pap =
						 * publicshedaacademicpapersService
						 * .findById(Publicshedaacademicpapers.class,
						 * cellValue_0.intValue());
						 */
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_8 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_8 + "'").get(0);
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						// System.out.println("as"+mno);
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院
						// String majorNo = "";// 导入数据中传递的专业
						String departNo = "";// 导入数据中传递的学院

						// if (teacher != null) {
						// // majorNo = teacher.getMajor().getMno();
						departNo = teacher.getMajor().getDepartment().getDno();
						if (departNo.equals(cellValue_9)) {
							errorMessg += "第" + rflag + "行教师所在学院与数据库中数据不符！";
							continue;
						}
						// if (teacher.getTname().equals(cellValue_8)) {
						// // 校验身份
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && departNo
										.equals(departNos))
								|| departNo.equals(departNos)) {// ||
							// mno.equals(majorNo)
							// if (teacher.getMajor().getMname().equals(
							// cellValue_10)) {// 校验教师专业
							// if (teacher.getMajor().getDepartment()
							// .getDname().equals(cellValue_9)) {// 校验学院
							Publicshedaacademicpapers pap1 = new Publicshedaacademicpapers();
							pap1.setTeacher(teacher);
							pap1.setPaperName(cellValue_2);
							pap1.setPeriodicalInfo(cellValue_3);
							pap1.setPeriodicalType(cellValue_4);
							pap1
									.setInfluenceFactors(Float
											.valueOf(cellValue_5));
							pap1.setYear(cellValue_6);
							pap1.setBeizhu(cellValue_7);
							papList.add(pap1);
							// } else {
							// errorMessg = "第" + r
							// + "行学院名称与系统中教师所在学院不匹配！";
							// return "majorStyleerror";
							// }

							// } else {
							// errorMessg = "第" + r
							// + "行专业名称与系统中教师所在专业不匹配！";
							// return "majorStyleerror";
							// }

						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg = "第" + r
						// + "行教师姓名数据项与数据库中对应教师姓名不匹配！";
						// return "majorStyleerror";
						//
						// }
						//
						// } else {
						// errorMessg = "第" + r + "行教师编号数据项在数据库中不存在！";
						// return "majorStyleerror";
						//
						// }

					}
				}
				// System.out.println(papList.size());
				// 更新数据库：
				publicshedaacademicpapersService.batchUpdateResult(
						Publicshedaacademicpapers.class, papList);
				successMessg = "您此次导入了" + papList.size() + "条教师科研论文基本信息!";
				successMessg += errorMessg;
			}
			// 教师发表教改论文
			if (excelFile != null && importName.equals("pep")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				pepList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0); // 编号
						Cell cell_1 = row.getCell(2);// 教师编号
						Cell cell_2 = row.getCell(4);// 论文名称
						Cell cell_3 = row.getCell(5);// 发表期刊信息
						Cell cell_4 = row.getCell(6);// 论文类别
						Cell cell_5 = row.getCell(7);// 年份
						Cell cell_6 = row.getCell(8);// 备注
						Cell cell_7 = row.getCell(3);// 教师姓名
						Cell cell_8 = row.getCell(0);// 学院
						// 专业 Cell cell_9 = row.getCell(2);

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						// 专业String cellValue_9 = "";
						/*
						 * if (cell_0 == null) { cellValue_0 = -1.0; } else {
						 * cellValue_0 = cell_0.getNumericCellValue(); }
						 */
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}

						// 专业cellValue_9 += cell_9.getStringCellValue();

						/*
						 * contestId = cellValue_0.intValue();
						 * Publicshedarevolutionpapers pep =
						 * publicshedarevolutionpapersService
						 * .findById(Publicshedarevolutionpapers.class,
						 * cellValue_0.intValue());
						 */
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_7 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_7 + "'").get(0);
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						// System.out.println("as"+mno);
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院
						// String majorNo = "";// 导入数据中传递的专业
						String departNo = "";// 导入数据中传递的学院

						// majorNo = teacher.getMajor().getMno();
						departNo = teacher.getMajor().getDepartment().getDno();
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && departNo
										.equals(departNos))
								|| departNo.equals(departNos)) {// ||
							// mno.equals(majorNo)
							// if (teacher.getMajor().getMname().equals(
							// cellValue_9)) {// 校验教师专业
							// if (teacher.getMajor().getDepartment()
							// .getDname().equals(cellValue_8)) {// 校验学院

							Publicshedarevolutionpapers pep1 = new Publicshedarevolutionpapers();
							pep1.setTeacher(teacher);
							pep1.setRevoPaperName(cellValue_2);
							pep1.setRevoPeriodicalInfo(cellValue_3);
							pep1.setPeriodicalType(cellValue_4);
							pep1.setYear(cellValue_5);
							pep1.setBeizhu(cellValue_6);

							pepList.add(pep1);
							// } else {
							// errorMessg = "第" + r
							// + "行学院名称与系统中教师所在学院不匹配！";
							// return "majorStyleerror";
							// }

							// } else {
							// errorMessg = "第" + r
							// + "行专业名称与系统中教师所在专业不匹配！";
							// return "majorStyleerror";
							// }

						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
					}
				}
				// System.out.println(pepList.size());
				// 更新数据库：
				publicshedarevolutionpapersService.batchUpdateResult(
						Publicshedarevolutionpapers.class, pepList);
				successMessg = "您此次导入了" + pepList.size() + "条教师教改论文基本信息！";
				successMessg += errorMessg;
			}
			// 教师进修
			if (excelFile != null && importName.equals("teat")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teatList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0); // 编号
						Cell cell_1 = row.getCell(0);// 教师编号
						Cell cell_12 = row.getCell(1);// 教师姓名
						Cell cell_2 = row.getCell(2);// 培训类型
						Cell cell_3 = row.getCell(3);// 培训名称
						Cell cell_4 = row.getCell(4);// 培训年份
						Cell cell_5 = row.getCell(5);// 境内外培训
						Cell cell_6 = row.getCell(6);// 培训时间
						Cell cell_7 = row.getCell(7);// 培训天数
						Cell cell_8 = row.getCell(8);// 获得证书
						Cell cell_9 = row.getCell(9);// 发证机构
						Cell cell_10 = row.getCell(10);// 是否行业培训
						Cell cell_11 = row.getCell(11);// 是否教学能力培训

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						Double cellValue_7;
						String cellValue_8 = "";
						String cellValue_9 = "";
						String cellValue_10 = "";
						String cellValue_11 = "";
						String cellValue_12 = "";

						/*
						 * if (cell_0 == null) { cellValue_0 = -1.0; } else {
						 * cellValue_0 = cell_0.getNumericCellValue(); }
						 */
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_7 = cell_7.getNumericCellValue();
						} else {
							errorMessg = "第八列数据类型应该为数值型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 += cell_10.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_12.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_12 += cell_12.getStringCellValue();
						} else {
							errorMessg = "第十三列数据类型应该为文本型！";
							return "error";
						}
						/*
						 * contestId = cellValue_0.intValue(); Teachertraining
						 * teat = teachertrainingService.findById(
						 * Teachertraining.class, cellValue_0.intValue());
						 */
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_12 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_12 + "'").get(0);
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						// System.out.println("as"+mno);
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院
						// String majorNo = "";// 导入数据中传递的专业
						String departNo = "";// 导入数据中传递的学院

						// if (techer != null) {
						// majorNo = techer.getMajor().getMno();
						departNo = teacher.getMajor().getDepartment().getDno();
						// if (techer.getTname().equals(cellValue_12)) {
						// 校验身份
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && departNo
										.equals(departNos))
								|| departNo.equals(departNos)) {// ||mno.equals(majorNo)
							Teachertraining teat1 = new Teachertraining();
							teat1.setTeacher(teacher);
							teat1.setTrainType(cellValue_2);
							teat1.setTrainContend(cellValue_3);
							teat1.setYear(cellValue_4);
							teat1.setTrainingArea(cellValue_5);
							teat1.setTrainDate(cellValue_6);
							teat1.setTrainTime(cellValue_7.intValue());
							teat1.setGetCertificate(cellValue_8);
							teat1.setGivenCertificateDepart(cellValue_9);
							teat1.setIsIndustryTrain(cellValue_10);
							teat1.setIsPraticeTeachTraining(cellValue_11);
							teatList.add(teat1);
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg = "第" + r
						// + "行教师姓名数据项与数据库中对应教师姓名不匹配！";
						// return "majorStyleerror";
						//
						// }
						//
						// } else {
						// errorMessg = "第" + r + "行教师编号数据项在数据库中不存在！";
						// return "majorStyleerror";
						//
						// }

					}
				}
				// System.out.println(teatList.size());
				// 更新数据库：
				teachertrainingService.batchUpdateResult(Teachertraining.class,
						teatList);
				successMessg = "您此次导入了" + teatList.size() + "条教师进修基本信息!";
				successMessg += errorMessg;
			}
			// 人文素质教育
			if (excelFile != null && importName.equals("eqe")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				eqeList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0); // 编号
						Cell cell_1 = row.getCell(0);// 专业名称
						Cell cell_2 = row.getCell(1);// 挑战杯参与人数
						Cell cell_3 = row.getCell(2);// 专业总人数
						Cell cell_4 = row.getCell(3);// 报告会举办次数
						Cell cell_5 = row.getCell(4);// 报告会参与次数
						Cell cell_6 = row.getCell(5);// 其他教育类项目数
						Cell cell_7 = row.getCell(6);// 年份
						Cell cell_8 = row.getCell(7);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						Double cellValue_2 = 0.0;
						Double cellValue_3 = 0.0;
						Double cellValue_4 = 0.0;
						Double cellValue_5 = 0.0;
						Double cellValue_6 = 0.0;
						String cellValue_7 = "";
						String cellValue_8 = "";

						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						// cellValue_0 = cell_0.getNumericCellValue();
						// }
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_2 = cell_2.getNumericCellValue();
						} else {
							errorMessg = "第二列数据类型应该为数值型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_3 = cell_3.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_6 = cell_6.getNumericCellValue();
						} else {
							errorMessg = "第六列数据类型应该为数值型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 = cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						// contestId = cellValue_0.intValue();
						/*
						 * Effectofqualityeducation eqe = eqeService.findById(
						 * Effectofqualityeducation.class, cellValue_0
						 * .intValue());
						 */
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_1);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						String mno = QueryUtil.getUserMno().getMajor().getMno();

						if (major != null) {
							Department department = major.getDepartment();
							if (department != null) {
								if (major.getDepartment().getDname().equals(
										department.getDname())) {
									if (mno.equals(major.getMno())
											|| mno.equals("000000")) {
										// if (eqe == null) {
										Effectofqualityeducation eqe1 = new Effectofqualityeducation();
										eqe1.setMajor(major);
										eqe1
												.setCupCount(cellValue_2
														.intValue());
										eqe1.setMajorCount(cellValue_3
												.intValue());
										eqe1.setHostReportCount(cellValue_4
												.intValue());
										eqe1.setPartiCount(cellValue_5
												.intValue());
										eqe1.setOtherProject(cellValue_6
												.intValue());
										eqe1.setYear(cellValue_7);
										eqe1.setNote(cellValue_8);
										eqeList.add(eqe1);
									} else {
										errorMessg += "第" + rflag
												+ "行由于权限问题，只能导入本学院专业的数据！";
										continue;
									}
								}
							} else {
								errorMessg += "第" + rflag + "行学院和专业信息不匹配！";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行专业数据列数据项有误！";
							continue;
						}
					}
				}

				// 更新数据库：
				eqeService.batchUpdateResult(Effectofqualityeducation.class,
						eqeList);
				setSuccessMessg("您此次导入了" + eqeList.size() + "条人文素质教育基本信息！"
						+ errorMessg);

			}
			// 就业情况
			if (excelFile != null && importName.equals("emp")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				empList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				errorMessg = "";
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 毕业人数
						Cell cell_4 = row.getCell(3);// 初次就业人数
						Cell cell_5 = row.getCell(4);// 就业人数
						Cell cell_6 = row.getCell(5);// 年份
						Cell cell_7 = row.getCell(6);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						Double cellValue_3;
						Double cellValue_4;
						Double cellValue_5;
						String cellValue_6 = "";
						String cellValue_7 = "";
						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						// cellValue_0 = cell_0.getNumericCellValue();
						// }
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_3 = cell_3.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}

						// contestId = cellValue_0.intValue();
						String mno = QueryUtil.getUserMno().getMajor().getMno();
						/*
						 * Employment emp =
						 * empService.findById(Employment.class,
						 * cellValue_0.intValue());
						 */
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						Department department = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
							department = major.getDepartment();
						} else {
							errorMessg += "第" + rflag + "行专业在数据库中不存在！";
							continue;
						}
						// if (major != null) {
						// if (department != null) {
						// if (major.getDepartment().getDname().equals(
						// department.getDname())) {
						if (mno.equals(major.getMno()) || mno.equals("000000")) {
							// if (emp== null) {
							Employment emp1 = new Employment();
							emp1.setGraduCount(cellValue_3.intValue());
							emp1.setFempCount(cellValue_4.intValue());
							emp1.setEmpCount(cellValue_5.intValue());
							emp1.setYear(cellValue_6);
							emp1.setNote(cellValue_7);
							major.setDepartment(department);
							emp1.setMajor(major);
							empList.add(emp1);
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg = "第" + rflag + "行学院和专业信息不匹配;";
						// return "majorStyleerror";
						// }
						// } else {
						//
						// errorMessg = "第" + rflag + "行学院数据有误！";
						// return "majorStyleerror";
						// }
						// } else {
						//
						// errorMessg = "第" + rflag + "行专业数据项有误！";
						// return "majorStyleerror";
						// }

					}
				}

				// 更新数据库：
				empService.batchUpdateResult(Employment.class, empList);

				setSuccessMessg("您此次导入了" + empList.size() + "条就业情况信息!"
						+ errorMessg);
			}
			// 招生情况
			if (excelFile != null && importName.equals("adm")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				admList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {

						// Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(0);// 专业名称
						Cell cell_3 = row.getCell(1);// 计划人数
						Cell cell_4 = row.getCell(2);// 招生人数
						Cell cell_5 = row.getCell(3);// 专业第一志愿率
						Cell cell_6 = row.getCell(4);// 入学平均分
						Cell cell_7 = row.getCell(5);// 专业报考热门度
						Cell cell_8 = row.getCell(6);// 年份
						Cell cell_9 = row.getCell(7);// 备注

						// String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5;
						String cellValue_6 = "";
						Double cellValue_7;
						String cellValue_8 = "";
						String cellValue_9 = "";

						// cellValue_1 += cell_1.getStringCellValue();
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_7 = cell_7.getNumericCellValue();
						} else {
							errorMessg = "第六列数据类型应该为数值型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}

						String mno = QueryUtil.getUserMno().getMajor().getMno();
						/*
						 * Addmissions adm = admService.findById(
						 * Addmissions.class, cellValue_0.intValue());
						 */
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag + "行专业在专业信息库中不存在！";
							continue;
						}
						// List departmentList = departmentService
						// .findEntityByName(Department.class, "dname",
						// cellValue_1);
						// Department department = null;
						// if (departmentList.size() != 0) {
						// department = (Department) departmentList.get(0);
						// }
						// if (major != null) {
						if (mno.equals(major.getMno()) || mno.equals("000000")) {
							// if (adm == null) {
							Addmissions adm1 = new Addmissions();
							adm1.setExpectCount(Integer.valueOf(cellValue_3));
							adm1.setAddmCount(Integer.valueOf(cellValue_4));
							adm1.setFirstChoice(cellValue_5.floatValue());
							adm1.setEntranceEverage(Float.valueOf(cellValue_6));
							adm1.setHotDeggree(cellValue_7.floatValue());
							adm1.setAddmYear(cellValue_8);
							adm1.setNote(cellValue_9);
							adm1.setMajor(major);
							admList.add(adm1);
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据";
							continue;
						}
						// } else {
						// errorMessg = "第" + rflag + "行学院和专业信息不匹配";
						// return "majorStyleerror";
						// }
						// } else {
						//
						// errorMessg = "第" + rflag + "行学院数据有误！";
						// return "majorStyleerror";
						// }
						// } else {
						//
						// errorMessg = "第" + rflag + "行专业数据项有误！";
						// return "majorStyleerror";
						// }

					}
				}
				admService.batchUpdateResult(Addmissions.class, admList);
				setSuccessMessg("您此次导入了" + admList.size() + "条课招生情况信息!"
						+ errorMessg);
			}

			/**
			 * 
			 *课程开始
			 * 
			 * 
			 */

			if (excelFile != null && importName.equals("cur")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				curList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院
						Cell cell_2 = row.getCell(1);// 专业
						Cell cell_3 = row.getCell(2);// 课程编号
						Cell cell_4 = row.getCell(3);// 课程名称
						Cell cell_5 = row.getCell(4);// 是否开出
						Cell cell_6 = row.getCell(5);// 是否优质课程
						Cell cell_7 = row.getCell(6);// 课程规划
						Cell cell_8 = row.getCell(7);// 开设年份
						Cell cell_9 = row.getCell(8);// 备注

						// /Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						/*
						 * if (cell_0 == null) { cellValue_0 = -1.0; } else {
						 * cellValue_0 = cell_0.getNumericCellValue(); }
						 */
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}

						if (cellValue_5.equals("是") || cellValue_5.equals("Y")) {
							cellValue_5 = "Y";
						} else {
							cellValue_5 = "N";
						}
						if (cellValue_6.equals("是") || cellValue_6.equals("Y")) {
							cellValue_6 = "Y";
						} else {
							cellValue_6 = "N";
						}
						/*
						 * contestId = cellValue_0.intValue();
						 * Curriculumresource cur = curService.findById(
						 * Curriculumresource.class, cellValue_0 .intValue());
						 */
						// 专业外键
						List<Major> majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							for (Major m : majorList) {
								if (m.getDepartment().getDname().equals(
										cellValue_1)) {
									major = m;
								}
							}
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// 课程
						Course course = null;
						if (!cellValue_3.equals("录入")) {
							course = courseService.findById(Course.class,
									cellValue_3);
							if (course == null) {
								errorMessg += "第" + rflag + "行课程编号在数据库中不存在！";
								continue;
							}
						} else {
							int size = 0;
							String s = "from Course as c where c.cname='"
									+ cellValue_4.trim() + "'";
							size = courseService.findByHQL(s).size();
							if (size == 0) {
								errorMessg += "第" + rflag + "行课程名称在数据库中不存在！";
								continue;
							} else {
								course = courseService.findByHQL(s).get(0);
							}
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (major != null) {
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && major
										.getDepartment().getDno().equals(
												departNos))
								|| mno.equals(major.getInMno())) {// 检验身份
							if (major.getDepartment().getDname().equals(
									cellValue_1)) {
								if (course != null) {
									if (course.getCname().equals(cellValue_4)) {// 校验课程名字
										Curriculumresource cur1 = new Curriculumresource();
										cur1.setCourse(course);
										cur1.setIsOpen(cellValue_5);
										cur1.setIsExcellent(cellValue_6);
										cur1.setCoursePlann(cellValue_7);
										cur1.setYear(cellValue_8);
										cur1.setNote(cellValue_9);
										cur1.setMajor(major);
										curList.add(cur1);
									} else {
										errorMessg += "第" + rflag
												+ "行课程名字数据列数据项与数据库不匹配！";
										continue;
									}
								} else {// 校验课程
									errorMessg += "第" + rflag
											+ "行课程在课程信息库中不存在！";
									continue;
								}
							} else {// 校验专业与学院是否匹配
								errorMessg += "第" + rflag + "行学院与专业数据列数据项匹配有误！";
								continue;
							}

						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据！";
							continue;
						}
						// } else {// 专业名称无误
						// errorMessg += "第" + rflag + "行专业数据列数据项有误！";
						// continue;
						// }
					}
				}
				// 更新数据库：
				curService.batchUpdateResult(Curriculumresource.class, curList);
				successMessg = "您此次导入了" + curList.size() + "条专业课资源基本信息！";
				successMessg += errorMessg;
			}
			/**
			 * 
			 *课程结束
			 * 
			 * 
			 */

			/**
			 * 
			 * 课程质量标准开始
			 */

			if (excelFile != null && importName.equals("quastan")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				quastanList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 总数
						Cell cell_4 = row.getCell(3);// 完成数
						Cell cell_5 = row.getCell(4);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						Double cellValue_3;
						Double cellValue_4;
						String cellValue_5 = "";

						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						// cellValue_0 = cell_0.getNumericCellValue();
						// }
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_3 = cell_3.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						// contestId = cellValue_0.intValue();
						/*
						 * Qualitystandard quastan = quastanService.findById(
						 * Qualitystandard.class, cellValue_0.intValue());
						 */
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();
						System.out.println("mno=" + mno);
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;

						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						// if (major != null) {
						// if (department != null) {
						if (major.getDepartment().getDname().equals(
								department.getDname())) {
							if (mno.equals(major.getMno())
									|| mno.equals("000000")) {
								@SuppressWarnings("unused")
								List<Qualitystandard> qList = new ArrayList<Qualitystandard>();
								qList = quastanService
										.findByHQL("from Qualitystandard as q where q.major.mno='"
												+ major.getMno() + "'");
								if (qList.size() == 0) {
									// if (quastan == null) {
									Qualitystandard quastan1 = new Qualitystandard();
									quastan1
											.setAllCount(cellValue_3.intValue());
									quastan1.setCompleteCount(cellValue_4
											.intValue());
									quastan1.setNote(cellValue_5);
									major.setDepartment(department);
									quastan1.setMajor(major);
									quastanList.add(quastan1);
								} else {
									errorMessg += "第" + rflag
											+ "行所导入的专业已经存在，如需修改数据请直接编辑数据！";
									continue;
								}
							} /*
							 * else { quastan.setAllCount(cellValue_3
							 * .intValue()); quastan
							 * .setCompleteCount(cellValue_4 .intValue());
							 * quastan.setNote(cellValue_5);
							 * major.setDepartment(department);
							 * quastan.setMajor(major);
							 *//** 保存第r行的第c列 */
							/*
							 * quastanList.add(quastan); } }
							 */

							else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据！";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行学院和专业信息不匹配！";
							continue;
						}
						// } else {
						//
						// errorMessg += "第" + rflag + "行学院数据有误！";
						// continue;
						// }
						// } else {
						//
						// errorMessg += "第" + rflag + "行专业数据项有误！";
						// continue;
						// }

					}
				}
				quastanService.batchUpdateResult(Qualitystandard.class,
						quastanList);
				setSuccessMessg("您此次导入了" + quastanList.size() + "条课程质量标准信息!"
						+ errorMessg);

			}
			// 获奖竞赛信息
			if (excelFile != null && importName.equals("competition")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				competitionlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(0);// 名称
						Cell cell_2 = row.getCell(1);// 获奖类别
						Cell cell_3 = row.getCell(2);// 获奖等级
						Cell cell_4 = row.getCell(3);// 年份
						Cell cell_5 = row.getCell(4);// 备注

						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";

						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}

						String mno = QueryUtil.getUserMno().getMajor().getMno();
						if (mno.equals("000000")) {
							Competition com1 = new Competition();
							com1.setComName(cellValue_1);
							com1.setComType(cellValue_2);
							com1.setComRank(cellValue_3);
							com1.setYear(cellValue_4);
							com1.setNote(cellValue_5);

							competitionlist.add(com1);
						} else {
							errorMessg += "第" + rflag + "行数据，由于权限问题，您不能导入该条数据！";
							continue;
						}
					}
				}
				// 更新数据库：
				competitionService.batchUpdateResult(Competition.class,
						competitionlist);
				setSuccessMessg("您此次导入了" + competitionlist.size()
						+ "条课学科竞赛获奖情况信息!" + errorMessg);

			}
			// 竞赛成员导入
			if (excelFile != null && importName.equals("stucption")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				studentcoepetitionlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(3);// 学生编号
						Cell cell_2 = row.getCell(2);// 学生姓名
						Cell cell_3 = row.getCell(1);// 获奖等级
						Cell cell_4 = row.getCell(0);// 竞赛名称
						Cell cell_5 = row.getCell(5);// 排名
						Cell cell_6 = row.getCell(4);// 学生学院
						Cell cell_7 = row.getCell(6);// 竞赛类别
						Cell cell_8 = row.getCell(7);// 竞赛年份

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5;
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第六列数据类型应该为数值型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}

						Student student = null;
						// 学生外键
						if (cellValue_1.equals("无")) {
							int size = 0;
							size = studentService.findByHQL(
									"from Student as s where s.stuName='"
											+ cellValue_2 + "'").size();
							if (size == 0) {
								errorMessg += "第" + rflag + "行学生在数据库中不存在！";
								continue;
							} else {
								List<Student> studentList = new ArrayList<Student>();
								studentList = studentService
										.findByHQL("from Student as s where s.stuName='"
												+ cellValue_2 + "'");
								int flag = 0;
								for (Student s : studentList) {
									if (s.getMajor().getDepartment().getDname()
											.equals(cellValue_6)) {
										flag = 1;
										student = s;
										break;
									}
								}
								if (flag == 0) {
									errorMessg += "第" + rflag
											+ "行学生学院信息与数据库不符！";
									continue;
								}
							}
						} else {
							student = studentService.findById(Student.class,
									cellValue_1);
							if (student == null) {
								errorMessg += "第" + rflag + "行学生在数据库中不存在！";
								continue;
							}
						}
						// 竞赛外键
						int size = 0;
						size = competitionService.findByHQL(
								"from Competition as c where c.comName='"
										+ cellValue_4 + "' and c.comRank='"
										+ cellValue_3 + "' and c.comType='"
										+ cellValue_7 + "' and c.year='"
										+ cellValue_8 + "'").size();
						Competition comption = new Competition();
						// comption=competitionService.findById(Competition.class,comNumber);
						if (size != 0) {
							comption = competitionService.findByHQL(
									"from Competition as c where c.comName='"
											+ cellValue_4 + "' and c.comRank='"
											+ cellValue_3 + "' and c.comType='"
											+ cellValue_7 + "' and c.year='"
											+ cellValue_8 + "'").get(0);
							if (student != null) {
								List<Studentcoepetition> newsc = new ArrayList<Studentcoepetition>();
								newsc = stuCptionService
										.findByHQL("from Studentcoepetition as sc where sc.competition.comNumber='"
												+ comption.getComNumber()
												+ "' and sc.student.stuNumber='"
												+ student.getStuNumber() + "'");
								if (newsc.size() != 0) {
									errorMessg += "第" + rflag
											+ "行学生已存在在该竞赛项目中！";
									continue;
								}
							}
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (student != null) {
						if (size != 0) {
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && student
											.getMajor().getDepartment()
											.getDno().equals(departNos))
									|| mno
											.equals(student.getMajor()
													.getInMno())) {// 检验身份
								System.out.println("compRank"
										+ comption.getComRank());
								System.out.println("import" + cellValue_3);
								// if
								// (comption.getComRank().equals(cellValue_3)) {
								Studentcoepetition stu1 = new Studentcoepetition();
								// stu1.setInnoMemNumber(cellValue_0.intValue());
								stu1.setStudent(student);
								stu1.setCompetition(comption);
								stu1.setRank(cellValue_5.intValue());
								studentcoepetitionlist.add(stu1);
								// } else {
								// errorMessg = "第" + rflag
								// + "行竞赛获奖等级数据列数据项与系统中不匹配！";
								// return "majorStyleerror";
								// }
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行竞赛数据列数据项不存在该系统中！";
							continue;
						}
						// } else {
						// errorMessg = "第" + r + "行学生数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				stuCptionService.batchUpdateResult(Studentcoepetition.class,
						studentcoepetitionlist);
				successMessg = "您此次导入了" + studentcoepetitionlist.size()
						+ "条竞赛成员基本信息!";
				successMessg += errorMessg;

			}
			// 质量工程信息
			if (excelFile != null && importName.equals("teachproject")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachprojectlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				// int rflag=0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					// rflag=r+1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(1);// 名称
						Cell cell_2 = row.getCell(2);// 级别
						Cell cell_3 = row.getCell(3);// 类型
						Cell cell_4 = row.getCell(4);// 年份
						Cell cell_5 = row.getCell(5);// 批准文号
						Cell cell_6 = row.getCell(6);// 备注
						// Cell cell_8 = row.getCell(7);//操作标志

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						// Double cellValue_8 ;
						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 = cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						// cellValue_8 = cell_8.getNumericCellValue();

						certificateNo = cellValue_0;
						Teachproject teachp = teachprojectService.findById(
								Teachproject.class, cellValue_0);
						if (teachp == null) {
							Teachproject teachp1 = new Teachproject();
							teachp1.setTprojectNo(cellValue_0);
							teachp1.setTprojectName(cellValue_1);
							teachp1.setTprojecJibie(cellValue_2);
							teachp1.setTprojecType(cellValue_3);
							teachp1.setYear(cellValue_4);
							teachp1.setApprovalNumber(cellValue_5);
							teachp1.setBeizhu(cellValue_6);
							// teachp1.setTag(cellValue_8.intValue());
							teachprojectlist.add(teachp1);
						} else {
							teachp.setTprojectName(cellValue_1);
							teachp.setTprojecJibie(cellValue_2);
							teachp.setTprojecType(cellValue_3);
							teachp.setYear(cellValue_4);
							teachp.setApprovalNumber(cellValue_5);
							teachp.setBeizhu(cellValue_6);
							// teachp.setTag(cellValue_8.intValue());
							teachprojectlist.add(teachp);
						}
					}
				}
				// 更新数据库：
				teachprojectService.batchUpdateResult(Teachproject.class,
						teachprojectlist);
				successMessg = "您此次导入了" + teachprojectlist.size()
						+ "条教学质量工程基本信息！";
			}
			// 教学成果
			if (excelFile != null && importName.equals("teachresult")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachresultbaseinfolist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 名称
						Cell cell_2 = row.getCell(1);// 获奖级别
						Cell cell_3 = row.getCell(2);// 获奖等级
						Cell cell_4 = row.getCell(3);// 年份
						Cell cell_5 = row.getCell(4);// 证书编号
						Cell cell_6 = row.getCell(5);// 授予单位
						Cell cell_7 = row.getCell(6);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						// Double cellValue_8;

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						// cellValue_8 = cell_8.getNumericCellValue();

						/*
						 * contestId = cellValue_0.intValue();
						 * Teachresultbaseinfo teachrs = teachResultBaseService
						 * .findById(Teachresultbaseinfo.class,
						 * cellValue_0.intValue());
						 */

						Teachresultbaseinfo teachrs1 = new Teachresultbaseinfo();
						// teachrs1.setTresultBaseNo(cellValue_0.intValue());
						teachrs1.setTresultName(cellValue_1);
						teachrs1.setTresultJibie(cellValue_2);
						teachrs1.setTresultClass(cellValue_3);
						teachrs1.setYear(cellValue_4);
						teachrs1.setApprovalNumber(cellValue_5);
						teachrs1.setRewardDepart(cellValue_6);
						teachrs1.setBeizhu(cellValue_7);
						// teachrs1.setTag(cellValue_8.intValue());
						teachresultbaseinfolist.add(teachrs1);

					}
				}
				// 更新数据库：
				teachResultBaseService.batchUpdateResult(
						Teachresultbaseinfo.class, teachresultbaseinfolist);
				successMessg = "您此次导入了" + teachresultbaseinfolist.size()
						+ "条教学成果奖基本信息！";
			}
			// 教学成果成员导入
			if (excelFile != null && importName.equals("teachresultbaseinfo")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachresultlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(0);// 教师编号
						Cell cell_2 = row.getCell(1);// 教师姓名
						Cell cell_3 = row.getCell(2);// 教学成果编号
						Cell cell_4 = row.getCell(3);// 成果名称
						Cell cell_5 = row.getCell(4);// 排名
						Cell cell_6 = row.getCell(5);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5;
						String cellValue_6 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						/*
						 * contestId = cellValue_0.intValue();
						 * Teacherachievements tche = teachAchieveService
						 * .findById(Teacherachievements.class,
						 * cellValue_0.intValue());
						 */
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						// 教学成果外键
						Teachresultbaseinfo teachresultbaseinfo = teachResultBaseService
								.findById(Teachresultbaseinfo.class, Integer
										.valueOf(cellValue_3));

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (teacher != null) {
						if (teachresultbaseinfo != null) {
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && teacher
											.getMajor().getDepartment()
											.getDno().equals(departNos))
									|| teacher.getMajor().getDepartment()
											.getDno().equals(departNos)) {// 检验身份mno.equals(teacher.getMajor().getInMno())
								if (teachresultbaseinfo.getTresultName()
										.equals(cellValue_4)) {
									Teachresult tchs1 = new Teachresult();
									// tchs1.setTresultNo(cellValue_0.intValue());
									tchs1.setTeacher(teacher);
									tchs1
											.setTeachresultbaseinfo(teachresultbaseinfo);
									tchs1
											.setTresultRank(cellValue_5
													.intValue());
									tchs1.setBeizhu(cellValue_6);
									teachresultlist.add(tchs1);
								} else {
									errorMessg += "第" + rflag
											+ "行教学成果名称数据列数据项与系统中匹配！";
									continue;
								}
								// 若成员中已有该教师则导不进去
								if (teacher != null) {
									List<Teachresultbaseinfo> newsc = new ArrayList<Teachresultbaseinfo>();
									newsc = teachResultBaseService
											.findByHQL("");
									if (newsc.size() != 0) {
										errorMessg += "第" + rflag
												+ "行教师已存在在该教学成果成员中！";
										continue;
									}
								}
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行教学成果数据列数据项不存在该系统中！";
							continue;
						}
						// } else {
						// errorMessg = "第" + r + "行教师数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				teachResultService.batchUpdateResult(Teachresult.class,
						teachresultlist);
				successMessg = "您此次导入了" + teachresultlist.size()
						+ "条教学成果成员基本信息！";
				successMessg += errorMessg;
			}
			// 科研成果
			if (excelFile != null && importName.equals("achievements")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				achievementslist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				errorMessg = "";
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(1);// 名称
						Cell cell_2 = row.getCell(2);// 完成单位排名
						Cell cell_3 = row.getCell(3);// 获奖级别
						Cell cell_4 = row.getCell(4);// 获奖类别
						Cell cell_5 = row.getCell(5);// 获奖等级
						Cell cell_6 = row.getCell(6);// 年份
						Cell cell_7 = row.getCell(7);// 备注
						// Cell cell_8 = row.getCell(8);// 操作标志

						String cellValue_0 = "";
						String cellValue_1 = "";
						Double cellValue_2;
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						// Double cellValue_8;
						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_2 = cell_2.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}

						// cellValue_8 = cell_8.getNumericCellValue();

						certificateNo = cellValue_0;
						// System.out.println("bianhao"+certificateNo);
						Achievements achi = achievementService.findById(
								Achievements.class, certificateNo);
						// System.out.println("as"+achi.toString());
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						// String departNos =
						// QueryUtil.getUserMno().getDepartment().getDno();//
						// 登陆者所在学院

						if (mno.equals("000000")) {// 检验身份
							if (achi == null) {
								Achievements achi1 = new Achievements();
								achi1.setCertificateNo(certificateNo);
								achi1.setCertificateName(cellValue_1);
								achi1.setDepartRank(cellValue_2.intValue());
								achi1.setCertificateJibie(cellValue_3);
								achi1.setCertificateType(cellValue_4);
								achi1.setCertificateClass(cellValue_5);
								achi1.setCertificateDate(cellValue_6);
								achi1.setBeizhu(cellValue_7);
								// achi1.setTag(cellValue_8.intValue());
								achievementslist.add(achi1);
							} else {
								achi.setCertificateName(cellValue_1);
								achi.setDepartRank(cellValue_2.intValue());
								achi.setCertificateJibie(cellValue_3);
								achi.setCertificateType(cellValue_4);
								achi.setCertificateClass(cellValue_5);
								achi.setCertificateDate(cellValue_6);
								achi.setBeizhu(cellValue_7);
								// achi.setTag(cellValue_8.intValue());
								achievementslist.add(achi);
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}

					}
				}
				// 更新数据库：
				achievementService.batchUpdateResult(Achievements.class,
						achievementslist);
				successMessg = "您此次导入了" + achievementslist.size()
						+ "条科研成果基本信息!" + errorMessg;
			}
			// 科研成员导入，注意此导入并没有限制只可导入本奖项的成员信息，
			if (excelFile != null && importName.equals("teacherachievements")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teacherachievementslist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 教师编号
						Cell cell_2 = row.getCell(1);// 教师姓名
						Cell cell_3 = row.getCell(2);// 成果编号
						Cell cell_4 = row.getCell(3);// 成果名称
						Cell cell_5 = row.getCell(4);// 排名
						Cell cell_6 = row.getCell(5);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5;
						String cellValue_6 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						/*
						 * contestId = cellValue_0.intValue();
						 * Teacherachievements tche = teachAchieveService
						 * .findById(Teacherachievements.class,
						 * cellValue_0.intValue());
						 */
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						// 科研成果外键
						Achievements achievement = achievementService.findById(
								Achievements.class, cellValue_3);

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (teacher != null) {
						if (achievement != null) {
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && teacher
											.getMajor().getDepartment()
											.getDno().equals(departNos))
									|| teacher.getMajor().getDepartment()
											.getDno().equals(departNos)) {// 检验身份mno.equals(teacher.getMajor().getInMno())
								if (achievement.getCertificateName().equals(
										cellValue_4)) {
									Teacherachievements tche1 = new Teacherachievements();
									// tche1.setTechArcNo(cellValue_0.intValue());
									tche1.setTeacher(teacher);
									tche1.setAchievements(achievement);
									tche1.setTeachRank(cellValue_5.intValue());
									tche1.setBeizhu(cellValue_6);
									teacherachievementslist.add(tche1);
								} else {
									errorMessg += "第" + rflag
											+ "行科研成果名称数据列数据项与系统中匹配！";
									continue;
								}
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行科研成果数据列数据项不存在该系统中！";
							continue;
						}
						// } else {
						// errorMessg = "第" + r + "行教师数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				teachAchieveService.batchUpdateResult(
						Teacherachievements.class, teacherachievementslist);
				successMessg = "您此次导入" + teacherachievementslist.size()
						+ "条出版科研成果成员信息！";
				successMessg += errorMessg;
			}
			// 教材信息
			if (excelFile != null && importName.equals("teachbooks")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachingbookslist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 名称
						Cell cell_2 = row.getCell(1);// INBS
						Cell cell_3 = row.getCell(2);// 出版社
						Cell cell_4 = row.getCell(3);// 年份
						Cell cell_5 = row.getCell(4);// 出版时间
						Cell cell_6 = row.getCell(5);// 出版类型
						Cell cell_7 = row.getCell(6);// 级别
						Cell cell_8 = row.getCell(7);// 优秀教材级别
						Cell cell_9 = row.getCell(8);// 优秀教材奖项级别
						Cell cell_10 = row.getCell(9);// 字数
						Cell cell_11 = row.getCell(10);// 使用情况
						Cell cell_12 = row.getCell(11);// 完成单位排名
						Cell cell_13 = row.getCell(12);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Date cellValue_5;
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						Double cellValue_10;
						String cellValue_11 = "";
						String cellValue_12 = "";
						String cellValue_13 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_5)) {
								cellValue_5 = cell_5.getDateCellValue();
							} else {
								errorMessg = "第五列日期型数据格式不正确，格式如2015/7/1！";
								return "error";
							}
						} else {
							errorMessg = "第五列数据类型应该为日期型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_10 = cell_10.getNumericCellValue();
						} else {
							errorMessg = "第十列数据类型应该为数值型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_12.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_12 += cell_12.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_13.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_13 += cell_13.getStringCellValue();
						} else {
							errorMessg = "第十三列数据类型应该为文本型！";
							return "error";
						}

						// 校验ISBN
						List<Teachingbooks> tbooks = teachBooksService
								.findEntityByName(Teachingbooks.class, "isbn",
										cellValue_2);

						Teachingbooks tbook = null;
						if (tbooks.size() != 0) {
							tbook = tbooks.get(0);
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						if (mno.equals("000000")) {
							if (tbook == null) {
								Teachingbooks teab1 = new Teachingbooks();
								teab1.setTbname(cellValue_1);
								teab1.setIsbn(cellValue_2);
								teab1.setPublisher(cellValue_3);
								teab1.setYear(cellValue_4);
								teab1.setPublishTime(cellValue_5);
								teab1.setPublishType(cellValue_6);
								teab1.setTbookJibie(cellValue_7);
								teab1.setTbookClass(cellValue_8);
								teab1.setTbookRewardClass(cellValue_9);
								teab1.setBookWords(cellValue_10.intValue());
								teab1.setUseState(cellValue_11);
								teab1.setFininshDepartRate(cellValue_12);
								teab1.setBeizhu(cellValue_13);
								teachingbookslist.add(teab1);
							} else {
								errorMessg += "第" + rflag
										+ "行ISBN数据列数据项存在该系统中！";
								// System.out.println(errorMessg);
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}

					}
				}
				// 更新数据库：
				// System.out.println("as"+teachingbookslist.size());
				teachBooksService.batchUpdateResult(Teachingbooks.class,
						teachingbookslist);
				successMessg = "您此次导入了" + teachingbookslist.size() + "条出版教材信息！"
						+ errorMessg;

			}
			// 教材作者导入
			if (excelFile != null && importName.equals("teachbook")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachbooklist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 教师编号
						Cell cell_2 = row.getCell(1);// 教师姓名
						Cell cell_3 = row.getCell(2);// 教材名称
						Cell cell_4 = row.getCell(3);// 教材ISBN
						Cell cell_5 = row.getCell(4);// 出版社
						Cell cell_6 = row.getCell(5);// 作者角色
						Cell cell_7 = row.getCell(6);// 排名

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						Double cellValue_7;

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_7 = cell_7.getNumericCellValue();
						} else {
							errorMessg = "第七列数据类型应该为数值型！";
							return "error";
						}
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						// 教材外键
						List<Teachingbooks> tbooks = teachBooksService
								.findEntityByName(Teachingbooks.class, "isbn",
										cellValue_4);
						Teachingbooks tbook = null;
						if (tbooks.size() != 0) {
							tbook = tbooks.get(0);
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (teacher != null) {
						if (tbook != null) {
							if (teacher != null) {
								List<Teachbook> newtb = new ArrayList<Teachbook>();
								newtb = teachBookService
										.findByHQL("from Teachbook as tb where tb.teachingbooks.tbno='"
												+ tbook.getTbno()
												+ "' and tb.teacher.tno='"
												+ teacher.getTno() + "'");
								if (newtb.size() != 0) {
									errorMessg += "第" + rflag
											+ "行教师已存在在该教材作者列表中！";
									continue;
								}
							}
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && teacher
											.getMajor().getDepartment()
											.getDno().equals(departNos))) {// mno.equals(teacher.getMajor().getInMno())检验身份
								if (tbook.getTbname().equals(cellValue_3)) {
									Teachbook tbk1 = new Teachbook();
									// tbk1.setTbZno(cellValue_0.intValue());
									tbk1.setTeacher(teacher);
									tbk1.setTeachingbooks(tbook);
									tbk1.setAuthorJuese(cellValue_6);
									tbk1.setAuthorRank(cellValue_7.intValue());
									teachbooklist.add(tbk1);
								} else {
									errorMessg += "第" + rflag
											+ "行教材名称数据列数据项与系统中匹配！";
									continue;
								}
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行教材数据列数据项不存在该系统中！";
							continue;
						}
						// } else {
						// errorMessg = "第" + r + "行教师数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				teachBookService.batchUpdateResult(Teachbook.class,
						teachbooklist);
				successMessg = "您此次导入了" + teachbooklist.size() + "条出版成员信息！";
				successMessg += errorMessg;
			}
			// 创新创业项目
			if (excelFile != null && importName.equals("innoproject")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				innovationprojectlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/**
				 * 循环Excel的行 tableHeader = new String[] { "编号", "项目名称", "项目级别",
				 * "项目类型", "立项年份", "项目经费", "立项时间", "结题时间", "验收结论", "备注"
				 * /*,"操作标志"
				 */
				errorMessg = "";
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(1);// 项目名称
						Cell cell_2 = row.getCell(2);// 项目级别
						Cell cell_3 = row.getCell(3);// 项目类型
						Cell cell_4 = row.getCell(4);// 立项年份
						Cell cell_5 = row.getCell(5);// 项目经费
						Cell cell_6 = row.getCell(6);// 立项时间
						Cell cell_7 = row.getCell(7);// 结题时间
						Cell cell_8 = row.getCell(8);// 验收结论
						Cell cell_9 = row.getCell(9);// 备注

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						Date cellValue_6 = null;
						Date cellValue_7 = null;
						String cellValue_8 = "";
						String cellValue_9 = "";

						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_6)) {
								cellValue_6 = cell_6.getDateCellValue();
							} else {
								errorMessg = "第七列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第七列数据类型应该为日期型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_7)) {
								cellValue_7 = cell_7.getDateCellValue();
							} else {
								errorMessg = "第八列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第八列数据类型应该为日期型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String innovationpNo = cellValue_0;
						Innovationproject inno = innovationprojectService
								.findById(Innovationproject.class,
										innovationpNo);
						if (mno.equals("000000")) {
							if (inno == null) {
								Innovationproject inno1 = new Innovationproject();
								inno1.setInnoNumber(cellValue_0);
								inno1.setInnoName(cellValue_1);
								inno1.setLevel(cellValue_2);
								inno1.setType(cellValue_3);
								inno1.setYear(cellValue_4);
								inno1.setCost(cellValue_5);
								inno1.setSetDate(cellValue_6);
								inno1.setEndDate(cellValue_7);
								inno1.setAssessment(cellValue_8);
								inno1.setNote(cellValue_9);
								innovationprojectlist.add(inno1);
							} else {
								inno.setInnoName(cellValue_1);
								inno.setLevel(cellValue_2);
								inno.setType(cellValue_3);
								inno.setYear(cellValue_4);
								inno.setCost(cellValue_5);
								inno.setSetDate(cellValue_6);
								inno.setEndDate(cellValue_7);
								inno.setAssessment(cellValue_8);
								inno.setNote(cellValue_9);
								innovationprojectlist.add(inno);
							}
						}
					} else {
						errorMessg += "第" + rflag + "行由于权限问题，无法导入该数据!";
						continue;
					}
				}

				// 更新数据库：
				innovationprojectService.batchUpdateResult(
						Innovationproject.class, innovationprojectlist);
				successMessg = "您此次导入了" + innovationprojectlist.size()
						+ "条大学生科创情况信息！" + errorMessg;

			}
			// 科创成员导入
			if (excelFile != null && importName.equals("innovationmember")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				innovationmemberlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(0);// 学生编号
						Cell cell_2 = row.getCell(1);// 学生姓名
						Cell cell_3 = row.getCell(2);// 科创编号
						Cell cell_4 = row.getCell(3);// 科创名称
						Cell cell_5 = row.getCell(4);// 排名

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5;

						// cellValue_0 = cell_0.getNumericCellValue();'
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						// 学生外键
						Student student = null;
						if (cellValue_1.equals("无")) {
							int size = 0;
							size = studentService.findByHQL(
									"from Student as s where s.stuName='"
											+ cellValue_2 + "'").size();
							if (size == 0) {
								errorMessg += "第" + rflag + "行学生在数据库中不存在！";
								continue;
							} else {
								List<Student> studentList = new ArrayList<Student>();
								studentList = studentService
										.findByHQL("from Student as s where s.stuName='"
												+ cellValue_2 + "'");
								student = studentList.get(0);
								// int flag = 0;
								// for (Student s : studentList) {
								// if (s.getMajor().getDepartment().getDname()
								// .equals(cellValue_6)) {
								// flag = 1;
								// student = s;
								// break;
								// }
								// }
								// if (flag == 0) {
								// errorMessg += "第" + rflag
								// + "行学生学院信息与数据库不符！";
								// continue;
								// }
							}
						} else {
							student = studentService.findById(Student.class,
									cellValue_1);
							if (student == null) {
								errorMessg += "第" + rflag + "行学生在数据库中不存在！";
								continue;
							}
						}
						// 项目外键
						Innovationproject inovationproject = null;
						inovationproject = innovationprojectService.findById(
								Innovationproject.class, cellValue_3);
						if (inovationproject == null) {
							errorMessg += "第" + rflag + "行科创项目在数据库中不存在！";
							continue;
						}

						if (student != null) {
							List<Innovationmember> newim = new ArrayList<Innovationmember>();
							newim = innovationmemberService
									.findByHQL("from Innovationmember as im where im.innovationproject.innoNumber='"
											+ inovationproject.getInnoNumber()
											+ "' and im.student.stuNumber='"
											+ student.getStuNumber() + "'");
							if (newim.size() != 0) {
								errorMessg += "第" + rflag + "行学生已存在在该科创项目中！";
								continue;
							}
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (student != null) {
						// if (inovationproject != null) {
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && student.getMajor()
										.getDepartment().getDno().equals(
												departNos))
								|| mno.equals(student.getMajor().getInMno())) {// 检验身份
							if (inovationproject.getInnoName().equals(
									cellValue_4)) {
								Innovationmember inno1 = new Innovationmember();
								// inno1.setInnoMemNumber(cellValue_0.intValue());
								inno1.setStudent(student);
								inno1.setInnovationproject(inovationproject);
								inno1.setRank(cellValue_5.intValue());
								innovationmemberlist.add(inno1);
							} else {
								errorMessg += "第" + rflag
										+ "行科创名称数据列数据项与系统中不匹配！";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行数据您没有权限导入！";
							continue;
						}
						// } else {
						// errorMessg = "第" + rflag + "行科创数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
						// } else {
						// errorMessg = "第" + rflag + "行学生数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}

				// 更新数据库：
				innovationmemberService.batchUpdateResult(
						Innovationmember.class, innovationmemberlist);
				successMessg = "您此次导入了" + innovationmemberlist.size()
						+ "条大学生科创成员情况信息！" + errorMessg;
			}

			// 教学计划变更
			/*
			 * tableHeader = new String[] { "编号", "所在学院", "专业名称",课程编号， "课程名称",
			 * "年级", "课程性质", "变动类型", "变更方式", "变更原因", "变更内容", "变更日期", "年份" };
			 */
			if (excelFile != null && importName.equals("tplan")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				tplanList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// 序号
						Cell cell_1 = row.getCell(0);// 学院
						Cell cell_2 = row.getCell(1);// 专业
						Cell cell_3 = row.getCell(2);// 课程
						Cell cell_4 = row.getCell(4);// 年级
						Cell cell_5 = row.getCell(5);// 课程性质
						Cell cell_6 = row.getCell(6);// 变动类型
						Cell cell_7 = row.getCell(7);// 变更方式
						Cell cell_8 = row.getCell(8);// 变更原因
						Cell cell_9 = row.getCell(9);// 变更内容
						Cell cell_10 = row.getCell(10);// 变更日期
						Cell cell_11 = row.getCell(11);// 年份

						Cell cell_cNmae = row.getCell(3);// 课程名字

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						Date cellValue_10 = null;
						String cellValue_11 = "";
						String cellValue_cName = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 = cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 = cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_cNmae.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_cName += cell_cNmae.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 = cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 = cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_10)) {
								cellValue_10 = cell_10.getDateCellValue();
							} else {
								errorMessg = "第十一列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第十一列数据类型应该为日期型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						// 由于教学计划变更表主键自增，所以导入时的编号不必导入数据库
						/*
						 * contestId = cellValue_0.intValue();
						 * Teachingplanchange tplan = tplanService.findById(
						 * Teachingplanchange.class, cellValue_0 .intValue());
						 */
						// 学院外键1
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						// 专业外键
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// 课程外键3
						Course course = courseService.findById(Course.class,
								cellValue_3);

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						if (major != null) {
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && major
											.getDepartment().getDno().equals(
													departNos))
									|| mno.equals(major.getInMno())) {// 检验身份
								if (major.getDepartment().getDname().equals(
										department.getDname())) {
									if (course != null) {
										Teachingplanchange tplan1 = new Teachingplanchange();
										tplan1.setMajor(major);
										tplan1.setCourse(course);
										tplan1.setGrade(cellValue_4);
										tplan1.setCourseNature(cellValue_5);
										tplan1.setChangeType(cellValue_6);
										tplan1.setChangeMode(cellValue_7);
										tplan1.setChangeReason(cellValue_8);
										tplan1.setChangeContext(cellValue_9);
										tplan1.setChangeDate(cellValue_10);
										tplan1.setYear(cellValue_11);
										tplanList.add(tplan1);
									} else {// 课程检测
										errorMessg += "第"
												+ rflag
												+ "行课程编号数据列数据项有误，该课程编号对应课程在课程信息库中不存在！";
										continue;
									}

								} else {// 学院专业匹配检测
									errorMessg += "第" + rflag
											+ "行学院专业数据列数据项匹配有误！";
									continue;
								}

							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {// 专业检测
							errorMessg += "第" + rflag + "行专业数据列数据项有误！";
							continue;
						}

					}
				}
				// 更新数据库：
				tplanService.batchUpdateResult(Teachingplanchange.class,
						tplanList);
				successMessg = "您此次导入了" + tplanList.size() + "条教学计划变更信息!";
				successMessg += errorMessg;
			}
			// 学生发表论文
			if (excelFile != null && importName.equals("stut")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				stutList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/**
					 * 循环Excel的列 tableHeader = new String[] { "编号", "所在学院",
					 * "专业名称", "学号", "姓名", "论文名称", "发表期刊", "期刊类型", "发表年份", "备注"
					 * };
					 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// 编号
						Cell cell_1 = row.getCell(0);// 所在学院
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 学号
						Cell cell_4 = row.getCell(3);// 姓名
						Cell cell_5 = row.getCell(4);// 论文名称
						Cell cell_6 = row.getCell(5);// 发表期刊
						Cell cell_7 = row.getCell(6);// 期刊类型
						Cell cell_8 = row.getCell(7);// 发表年份
						Cell cell_9 = row.getCell(8);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";

						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}

						String mno = QueryUtil.getUserMno().getMajor().getMno();
						// List majorList = majorService.findEntityByName(
						// Major.class, "mname", cellValue_2);
						// Major major = null;
						// if (majorList.size() != 0) {
						// major = (Major) majorList.get(0);
						// }
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						Student student = studentService.findById(
								Student.class, cellValue_3);
						// if (major != null) {
						// if (department != null) {
						if (student != null) {
							// if (major.getDepartment().getDname()
							// .equals(department.getDname())) {
							if (mno.equals(student.getMajor().getMno())
									|| mno.equals("000000")) {
								Stuthesis stut1 = new Stuthesis();

								stut1.setJournal(cellValue_6);
								stut1.setComName(cellValue_5);
								stut1.setJournalType(cellValue_7);
								stut1.setYear(cellValue_8);
								stut1.setNote(cellValue_9);
								stut1.setStudent(student);
								stutList.add(stut1);
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据！";
								continue;
							}
							// } else {
							// errorMessg += "第" + rflag
							// + "行学院和专业信息不匹配";
							// continue;
							// }
						} else {
							errorMessg += "第" + rflag
									+ "行学生信息有误，该学生在学生信息库中不存在！";
							continue;
						}
						// } else {
						// errorMessg += "第" + rflag + "行学院数据有误！";
						// continue;
						// }
						// } else {
						// errorMessg += "第" + rflag + "行专业数据项有误！";
						// continue;
						// }

					}
				}
				// 更新数据库：
				stuthesisService.batchUpdateResult(Stuthesis.class, stutList);
				setSuccessMessg("您此次导入了" + stutList.size() + "条学生论文信息！"
						+ errorMessg);

			}
			// 专业课开课
			/*
			 * tableHeader = new String[] { "编号", "所在学院", "专业名称", "教师编号",
			 * "教师姓名", "职称", "课程编号","课程名称", "学期", "所属专业", "上课学时", "总学时", "课程类型",
			 * "开课年份", "备注" };
			 */
			if (excelFile != null && importName.equals("mcourse")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				mcourseList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_1 = row.getCell(0);// 学院
						Cell cell_2 = row.getCell(1);// 专业
						Cell cell_3 = row.getCell(2);// 教师编号
						Cell cell_4 = row.getCell(3);// 教师名称
						Cell cell_5 = row.getCell(4);// 职称
						Cell cell_6 = row.getCell(5);// 课程编号
						Cell cell_7 = row.getCell(6);// 课程名字
						Cell cell_8 = row.getCell(7);// 学期
						Cell cell_9 = row.getCell(8);// 上课学时
						Cell cell_10 = row.getCell(9);// 总学时
						Cell cell_11 = row.getCell(10);// 课程类型
						Cell cell_12 = row.getCell(11);// 开课年份
						Cell cell_13 = row.getCell(12);// 备注

						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						Double cellValue_9 = 0.0;
						Double cellValue_10 = 0.0;
						String cellValue_11 = "";
						String cellValue_12 = "";
						String cellValue_13 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 = cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_9 = cell_9.getNumericCellValue();
						} else {
							errorMessg = "第九列数据类型应该为数值型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_10 = cell_10.getNumericCellValue();
						} else {
							errorMessg = "第十列数据类型应该为数值型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_12.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_12 += cell_12.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_13.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_13 += cell_13.getStringCellValue();
						} else {
							errorMessg = "第十三列数据类型应该为文本型！";
							return "error";
						}
						// contestId = cellValue_0.intValue();
						// Majorcourse mcourse = mcourseService.findById(
						// Majorcourse.class, cellValue_0.intValue());
						// 学院外键1
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						// 专业外键
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// 教师外键
						Teacher techer = teacherService.findById(Teacher.class,
								cellValue_3);

						// 课程外键3
						Course course = courseService.findById(Course.class,
								cellValue_6);

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (major != null) {
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && major
										.getDepartment().getDno().equals(
												departNos))
								|| major.getDepartment().getDno().equals(
										departNos)) {// mno.equals(major.getInMno())检验身份
							if (major.getDepartment().getDname().equals(
									department.getDname())) {
								if (techer != null) {
									if (techer.getTname().equals(cellValue_4)) {
										if (course != null) {
											if (course.getCname().equals(
													cellValue_7)) {
												Majorcourse mcourse = new Majorcourse();
												mcourse
														.setOpenSemester(cellValue_8);

												mcourse
														.setProfessionalTitleName(cellValue_5);
												mcourse.setYear(cellValue_12);
												mcourse.setBeizhu(cellValue_13);
												mcourse
														.setClasshours(cellValue_9
																.intValue());
												mcourse
														.setCourseHours(cellValue_10
																.intValue());
												mcourse.setCtype(cellValue_11);
												mcourse.setMajor(major);
												mcourse.setTeacher(techer);
												mcourse.setCourse(course);

												mcourseList.add(mcourse);
											} else {// 检测课程名称是否匹配
												errorMessg += "第" + rflag
														+ "行课程数据列数据项中课程名字不匹配！";
												continue;
											}

										} else {// 检测课程是否存在数据库
											errorMessg += "第" + rflag
													+ "行课程数据列数据项中不存在！";
											continue;
										}
									} else {// 检测老师姓名是否匹配
										errorMessg += "第" + rflag
												+ "行老师数据列数据项中老师姓名不匹配！";
										continue;
									}

								} else {// 检测老师在数据库是否存在
									errorMessg += "第" + rflag
											+ "行老师数据列数据项中老师不存在该数据库中！";
									continue;
								}
							} else {// 专业学院数据列检测
								errorMessg += "第" + rflag + "行专业学院数据列数据项匹配有误！";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg += "第" + rflag + "行专业数据列数据项中有误！";
						// continue;
						// }
					}
				}
				// 更新数据库：
				mcourseService
						.batchUpdateResult(Majorcourse.class, mcourseList);
				successMessg = "您此次导入了" + mcourseList.size() + "条开课信息！";
				successMessg += errorMessg;
			}

			// 教学质量工程成员导入
			if (excelFile != null && importName.equals("teachprojectuser")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachprojectuserlist.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 教师编号
						Cell cell_2 = row.getCell(1);// 教师姓名
						Cell cell_3 = row.getCell(2);// 项目编号
						Cell cell_4 = row.getCell(3);// 项目名称
						Cell cell_5 = row.getCell(4);// 排名
						Cell cell_6 = row.getCell(5);// 备注
						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						Double cellValue_5 = 0.0;
						String cellValue_6 = "";

						// cellValue_0 = cell_0.getNumericCellValue();
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}

						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						// 质量工程外键
						Teachproject teachProject = teachprojectService
								.findById(Teachproject.class, cellValue_3);

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (teacher != null) {
						if (teachProject != null) {
							if (teacher != null) {
								List<Teachprojectuser> newtp = new ArrayList<Teachprojectuser>();
								newtp = teachprojectuserService
										.findByHQL("from Teachprojectuser as tp where tp.teachproject.tprojectNo='"
												+ teachProject.getTprojectNo()
												+ "' and tp.teacher.tno='"
												+ teacher.getTno() + "'");
								if (newtp.size() != 0) {
									errorMessg += "第" + rflag
											+ "行教师已存在在该质量工程成员列表中！";
									continue;
								}
							}
							if ((mno.equals("000000") && departNos
									.equals("00000"))
									|| (mno.equals("000000") && teacher
											.getMajor().getDepartment()
											.getDno().equals(departNos))
									|| teacher.getMajor().getDepartment()
											.getDno().equals(departNos)) {// mno.equals(teacher.getMajor().getInMno())检验身份
								if (teachProject.getTprojectName().equals(
										cellValue_4)) {
									Teachprojectuser tpu1 = new Teachprojectuser();
									// tpu1.setTpUno(cellValue_0.intValue());
									tpu1.setTeacher(teacher);
									tpu1.setTeachproject(teachProject);
									tpu1.setRank(cellValue_5.intValue());
									tpu1.setBeizhu(cellValue_6);
									teachprojectuserlist.add(tpu1);
								} else {
									errorMessg += "第" + rflag
											+ "行质量工程数据列数据项与系统中匹配！";
									continue;
								}
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行质量工程数据列数据项不存在该系统中！";
							continue;
						}
						// } else {
						// errorMessg = "第" + r + "行教师数据列数据项不存在该系统中！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				teachprojectuserService.batchUpdateResult(
						Teachprojectuser.class, teachprojectuserlist);
				successMessg = "您此次导入了" + teachprojectuserlist.size()
						+ "条质量工程成员信息!";
				successMessg += errorMessg;
			}

			// 教学经费
			if (excelFile != null && importName.equals("teachcost")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teachingcostList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院名称
						// Cell cell_2 = row.getCell(2);// 专业编号
						Cell cell_3 = row.getCell(1);// 专业名称
						Cell cell_4 = row.getCell(2);// 适用类型
						Cell cell_5 = row.getCell(3);// 经费
						Cell cell_6 = row.getCell(4);// 用途
						Cell cell_7 = row.getCell(5);// 年份

						// Double cellValue_0;
						String cellValue_1 = "";
						// String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";

						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}

						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}

						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}

						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}

						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}

						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						// cellValue_2 += cell_2.getStringCellValue();

						/*
						 * // 学院外键1 List departmentList = departmentService
						 * .findEntityByName(Department.class, "dname",
						 * cellValue_1); Department department = null; if
						 * (departmentList.size() != 0) { department =
						 * (Department) departmentList.get(0); }
						 */
						// 专业外键
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_3);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// 教学经费适用类型
						List costTypes = teachingcosttypeService
								.findEntityByName(Teachingcosttype.class,
										"useType", cellValue_4);
						Teachingcosttype costType = null;
						if (costTypes.size() != 0) {
							costType = (Teachingcosttype) costTypes.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行教学经费适用类型信息有误，该教学经费适用类型在信息库中不存在！";
							continue;
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (major != null) {// 专业无误
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && major
										.getDepartment().getDno().equals(
												departNos))
								|| mno.equals(major.getInMno())) {// 读出专业并判断是否一致
							if (major.getDepartment().getDname().equals(
									cellValue_1)) {// 校验专业学院名称
								// if (costType != null) {
								Teachingcost teacc1 = new Teachingcost();
								teacc1.setTeachingcosttype(costType);
								/*
								 * teacc1.setStuNumber(cellValue_3.intValue ());
								 */
								teacc1.setCost(Double.valueOf(cellValue_5));
								teacc1.setUseness(cellValue_6);
								teacc1.setYear(cellValue_7);
								teacc1.setMajor(major);
								teachingcostList.add(teacc1);
								// } else {
								// errorMessg += "第" + rflag
								// + "行教学经费适用类型数据项不存在数据库中！";
								// continue;
								// }
							} else {
								errorMessg += "第" + rflag
										+ "行专业所在学院与数据库中记录的数据不匹配！";
								continue;
							}
						} else {// 返回权限
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {// 返回专业不存在错误
						// errorMessg += "第" + rflag + "行专业编号数据项不存在数据库中！";
						// continue;
						//
						// }

					}
				}
				teachingcostService.batchUpdateResult(Teachingcost.class,
						teachingcostList);
				successMessg = "您此次导入了" + teachingcostList.size()
						+ "条专业经费基本信息!";
				successMessg += errorMessg;
			}
			// 国内外交流
			if (excelFile != null && importName.equals("international")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {

						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 交流项目数
						Cell cell_4 = row.getCell(3);// 参与学生数
						Cell cell_5 = row.getCell(4);// 年份
						Cell cell_6 = row.getCell(5);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						Double cellValue_3 = 0.0;
						Double cellValue_4 = 0.0;
						String cellValue_5 = "";
						String cellValue_6 = "";

						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						//
						// cellValue_0 = cell_0.getNumericCellValue();
						// }// 如果新添加一条数据，判断编码为空

						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_3 = cell_3.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						// contestId = cellValue_0.intValue();

						/*
						 * Communicationsitu comc = communicationsituService
						 * .findById(Communicationsitu.class, cellValue_0
						 * .intValue());
						 */
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();

						// 专业外键 别忘了检查spring的配置2
						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						// if (major != null) {// 读出专业并判断是否一致
						// if (department != null) {
						if (major.getDepartment().getDname().equals(
								department.getDname())) {
							if (mno.equals(major.getMno())
									|| mno.equals("000000")) {
								Communicationsitu comc1 = new Communicationsitu();
								comc1.setProjCounts(cellValue_3.intValue());
								comc1.setStuCount(cellValue_4.intValue());
								major.setDepartment(department);
								comc1.setYear(cellValue_5);
								comc1.setNote(cellValue_6);
								comc1.setMajor(major);
								communicationsituList.add(comc1);
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行学院和专业信息不匹配!";
							continue;
						}
						// } else {
						// errorMessg += "第" + rflag + "行学院数据有误！";
						// continue;
						// }
						// } else {
						// errorMessg += "第" + rflag + "行专业数据项有误！";
						// continue;
						// }// 返回专业不匹配错误

					}
				}
				communicationsituService.batchUpdateResult(
						Communicationsitu.class, communicationsituList);
				setSuccessMessg("您此次导入了" + communicationsituList.size()
						+ "条学生国内外交流信息!" + errorMessg);
				communicationsituList.clear();

			}
			// 实习实践
			if (excelFile != null && importName.equals("practice")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				fulfillinginstanceList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				errorMessg = "";
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {

						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 实习类型
						Cell cell_4 = row.getCell(3);// 应开
						Cell cell_5 = row.getCell(4);// 实开
						Cell cell_6 = row.getCell(5);// 完成
						Cell cell_7 = row.getCell(6);// 开出率
						Cell cell_8 = row.getCell(7);// 完成率
						Cell cell_9 = row.getCell(8);// 年份
						Cell cell_10 = row.getCell(9);// 备注

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						Double cellValue_4 = 0.0;
						Double cellValue_5 = 0.0;
						Double cellValue_6 = 0.0;
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						String cellValue_10 = "";
						/*
						 * if (cell_0 == null) { cellValue_0 = -1.0; } else {
						 * 
						 * cellValue_0 = cell_0.getNumericCellValue(); }//
						 * 如果新添加一条数据，判断编码为空
						 */
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_5 = cell_5.getNumericCellValue();
						} else {
							errorMessg = "第五列数据类型应该为数值型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_6 = cell_6.getNumericCellValue();
						} else {
							errorMessg = "第六列数据类型应该为数值型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 = cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 = cell_8.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 += cell_10.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();

						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag + "行专业数据项有误！";
							continue;
						}
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag + "行学院数据项有误！";
							continue;
						}
						// if (major != null) {
						// if (department != null) {
						if (major.getDepartment().getDname().equals(
								department.getDname())) {
							if (mno.equals(major.getMno())
									|| mno.equals("000000")) {

								Fulfillinginstance full1 = new Fulfillinginstance();
								full1.setFulType(cellValue_3);
								full1.setStuNumber1(cellValue_4.intValue());
								full1.setStuNumber2(cellValue_5.intValue());
								full1.setEndNumber(cellValue_6.intValue());
								full1.setOpenRate(Float.valueOf(cellValue_7));
								full1.setFinishRate(Float.valueOf(cellValue_8));
								full1.setYear(cellValue_9);
								full1.setNote(cellValue_10);
								major.setDepartment(department);
								full1.setMajor(major);
								fulfillinginstanceList.add(full1);
							} else {
								errorMessg += "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据!";
								continue;
							}
						} else {
							errorMessg += "第" + rflag + "行学院和专业信息不匹配!";
							continue;
						}
						// } else {
						// errorMessg += "第" + rflag + "行学院数据有误！";
						// continue;
						// }
						// } else {
						// errorMessg += "第" + rflag + "行专业数据项有误！";
						// continue;
						// }

					}

					// 更新数据库：

				}
				fulfillinginstanceService.batchUpdateResult(
						Fulfillinginstance.class, fulfillinginstanceList);
				setSuccessMessg("您此次导入了" + fulfillinginstanceList.size()
						+ "条实习实践毕业设计信息!" + errorMessg);
			}
			// 实践教学
			if (excelFile != null && importName.equals("pratea")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				traininguseinginformationList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {

						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 学院名称
						Cell cell_2 = row.getCell(1);// 专业名称
						Cell cell_3 = row.getCell(2);// 共建教学资源数
						Cell cell_4 = row.getCell(3);// 实验设备生均值
						Cell cell_5 = row.getCell(4);// 实验室满足率
						Cell cell_6 = row.getCell(5);// 实验开放人时数
						Cell cell_7 = row.getCell(6);// 校内基地数
						Cell cell_8 = row.getCell(7);// 校外基地数
						Cell cell_9 = row.getCell(8);// 校内基地满足率
						Cell cell_10 = row.getCell(9);// 校外基地满足 率
						Cell cell_11 = row.getCell(10); // 年份

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						Double cellValue_3 = 0.0;
						Double cellValue_4 = 0.0;
						String cellValue_5 = "";
						Double cellValue_6 = 0.0;
						Double cellValue_7 = 0.0;
						Double cellValue_8 = 0.0;
						String cellValue_9 = "";
						String cellValue_10 = "";
						String cellValue_11 = "";

						// if (cell_0 == null) {
						// cellValue_0 = -1.0;
						// } else {
						//
						// cellValue_0 = cell_0.getNumericCellValue();
						// }// 如果新添加一条数据，判断编码为空
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_3 = cell_3.getNumericCellValue();
						} else {
							errorMessg = "第三列数据类型应该为数值型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_4 = cell_4.getNumericCellValue();
						} else {
							errorMessg = "第四列数据类型应该为数值型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 = cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_6 = cell_6.getNumericCellValue();
						} else {
							errorMessg = "第六列数据类型应该为数值型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_7 = cell_7.getNumericCellValue();
						} else {
							errorMessg = "第七列数据类型应该为数值型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_8 = cell_8.getNumericCellValue();
						} else {
							errorMessg = "第八列数据类型应该为数值型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 = cell_9.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 = cell_10.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();

						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_2);
						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag + "行专业数据在专业信息库中不存在！";
							continue;
						}
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_1);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag + "行学院数据在学院信息库中不存在！";
							continue;
						}
						// if (major != null) {
						// if (department != null) {
						if (major.getDepartment().getDname().equals(
								department.getDname())) {
							if (mno.equals(major.getMno())
									|| mno.equals("000000")) {
								Traininguseinginformation tra1 = new Traininguseinginformation();
								tra1.setResourceConstructionNumber(cellValue_3
										.intValue());
								tra1.setExperimentalEquipmentMean(cellValue_4
										.intValue());
								tra1.setLaboratorySatisfactionRate(Float
										.valueOf(cellValue_5));
								tra1
										.setExperimentNumber(cellValue_6
												.intValue());
								tra1.setSchooBaseNumber(cellValue_7.intValue());
								tra1.setOutBaseNumber(cellValue_8.intValue());
								tra1.setSchooBaseRate(Float
										.valueOf(cellValue_9));
								tra1
										.setOutBaseRate(Float
												.valueOf(cellValue_10));
								major.setDepartment(department);
								tra1.setMajor(major);
								tra1.setYear(cellValue_11);
								traininguseinginformationList.add(tra1);
							} else {
								errorMessg = "第" + rflag
										+ "行由于权限问题，只能导入本学院专业的数据！";
								continue;
							}
						} else {
							errorMessg = "第" + rflag + "行学院和专业信息不匹配！";
							continue;
						}
						// } else {
						//
						// errorMessg = "第" + rflag + "行学院数据有误！";
						// return "majorStyleerror";
						// }
						// } else {
						//
						// errorMessg = "第" + rflag + "行专业数据项有误！";
						// return "majorStyleerror";
						// }

					}
				}

				// 更新数据库：
				traininguseinginformationService.batchUpdateResult(
						Traininguseinginformation.class,
						traininguseinginformationList);
				setSuccessMessg("您此次导入了" + traininguseinginformationList.size()
						+ "条实践教学资源情况信息！" + errorMessg);

			}
			// 课程基本信息
			if (excelFile != null && importName.equals("course")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				courseList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 课程编号
						Cell cell_1 = row.getCell(1);// 课程名称
						Cell cell_2 = row.getCell(2);// 学院名称
						Cell cell_3 = row.getCell(3);// 课程类别
						Cell cell_4 = row.getCell(4);// 是否是双语授课
						Cell cell_5 = row.getCell(5);// 考核方式
						Cell cell_6 = row.getCell(6);// 学时
						Cell cell_7 = row.getCell(7);// 学分
						Cell cell_8 = row.getCell(8);// 方案版本

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						Double cellValue_6 = 0.0;
						Double cellValue_7 = 0.0;
						String cellValue_8 = "";

						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_6 = cell_6.getNumericCellValue();
						} else {
							errorMessg = "第七列数据类型应该为数值型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							cellValue_7 = cell_7.getNumericCellValue();
						} else {
							errorMessg = "第八列数据类型应该为数值型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						courseNo = cellValue_0;
						System.out.println("courseNo---" + courseNo
								+ "cellValue_0----" + cellValue_0);
						Course crs = courseService.findById(Course.class,
								courseNo);

						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_2);

						Department department = null;
						if (departmentList.size() != 0) {

							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag + "行学院数据在学院信息库中不存在！";
							continue;
						}
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();
						String dno = QueryUtil.getUserMno().getDepartment()
								.getDno();

						if (mno.equals("000000") && dno.equals("00000")) {
							// if (department != null) {
							if (crs == null) {

								Course course = new Course();
								course.setCno(cellValue_0);
								course.setDepartment(department);
								course.setCname(cellValue_1);
								course.setCtype(cellValue_3);
								course.setIsDoubleLanguageTeach(cellValue_4);
								course.setTestMode(cellValue_5);
								course.setCourseHours(cellValue_6.intValue());
								course.setCredit(cellValue_7.floatValue());
								course.setVersion(cellValue_8.toString());

								courseList.add(course);
							} else {
								crs.setDepartment(department);
								crs.setCname(cellValue_1);
								crs.setCtype(cellValue_3);
								crs.setIsDoubleLanguageTeach(cellValue_4);
								crs.setTestMode(cellValue_5);
								crs.setCourseHours(cellValue_6.intValue());
								crs.setCredit(cellValue_7.floatValue());
								crs.setVersion(cellValue_8);

								courseList.add(crs);
							}
							// } else {
							// errorMessg += "第" + rflag + "行学院数据列数据项有误！";
							// continue;
							// }

						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
					}
				}
				// 更新数据库：
				courseService.batchUpdateResult(Course.class, courseList);
				successMessg = "您此次导入了" + courseList.size() + "条课程基本信息!";
				successMessg += errorMessg;
			}

			// 教师基本信息
			/*
			 * tableHeader = new String[] { "职工编号", "职工姓名","性别","出生日期", "所在学院",
			 * "所在专业", "职称","学位", "学历", "师资类别", "在职状态","岗位类型"
			 * ,"学缘","学科类别","是否双师","是否工程背景",
			 * "是否具有行业培训","是否具有实践教学能力培训","导师类别","是否外聘教师"};
			 */
			if (excelFile != null && importName.equals("teacher")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				teacherList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 职工编号
						Cell cell_1 = row.getCell(1);// 职工姓名
						Cell cell_2 = row.getCell(2);// 性别
						Cell cell_3 = row.getCell(3);// 出生日期
						Cell cell_4 = row.getCell(4);// 所在学院
						Cell cell_5 = row.getCell(5);// 所在专业
						Cell cell_6 = row.getCell(6);// 职称
						Cell cell_7 = row.getCell(7);// 学位
						Cell cell_8 = row.getCell(8);// 学历
						Cell cell_9 = row.getCell(9);// 师资类别
						Cell cell_10 = row.getCell(10);// 在职状态
						Cell cell_11 = row.getCell(11);// 岗位类型
						Cell cell_12 = row.getCell(12);// 学缘
						Cell cell_13 = row.getCell(13);// 学科类别
						Cell cell_14 = row.getCell(14);// 是否双师
						Cell cell_15 = row.getCell(15);// 是否工程背景
						Cell cell_16 = row.getCell(16);// 是否具有行业培训
						Cell cell_17 = row.getCell(17);// 是否具有实践教学能力培训
						Cell cell_18 = row.getCell(18);// 导师类别
						Cell cell_19 = row.getCell(19);// 是否外聘教师

						// Double cellValue_0;
						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						Date cellValue_3;
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";
						String cellValue_10 = "";
						String cellValue_11 = "";
						String cellValue_12 = "";
						String cellValue_13 = "";
						String cellValue_14 = "";
						String cellValue_15 = "";
						String cellValue_16 = "";
						String cellValue_17 = "";
						String cellValue_18 = "";
						String cellValue_19 = "";
						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_10)) {
								cellValue_3 = cell_3.getDateCellValue();
							} else {
								errorMessg = "第四列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第四列数据类型应该为日期型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 += cell_10.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_11.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_11 += cell_11.getStringCellValue();
						} else {
							errorMessg = "第十二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_12.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_12 += cell_12.getStringCellValue();
						} else {
							errorMessg = "第十三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_13.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_13 += cell_13.getStringCellValue();
						} else {
							errorMessg = "第十四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_14.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_14 += cell_14.getStringCellValue();
						} else {
							errorMessg = "第十五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_15.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_15 += cell_15.getStringCellValue();
						} else {
							errorMessg = "第十六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_16.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_16 += cell_16.getStringCellValue();
						} else {
							errorMessg = "第十七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_17.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_17 += cell_17.getStringCellValue();
						} else {
							errorMessg = "第十八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_18.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_18 += cell_18.getStringCellValue();
						} else {
							errorMessg = "第十九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_19.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_19 += cell_19.getStringCellValue();
						} else {
							errorMessg = "第二十列数据类型应该为文本型！";
							return "error";
						}
						teacherNo = cellValue_0;
						System.out.println("teacherNo---" + teacherNo
								+ "cellValue_0----" + cellValue_0);
						Teacher tea = teacherService.findById(Teacher.class,
								teacherNo);
						// 学院外键1
						List departmentList = departmentService
								.findEntityByName(Department.class, "dname",
										cellValue_4);
						Department department = null;
						if (departmentList.size() != 0) {
							department = (Department) departmentList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学院信息有误，该学院在学院信息库中不存在！";
							continue;
						}
						// 专业外键
						List<Major> majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_5);
						Major major = null;
						if (majorList.size() != 0) {
							for (Major m : majorList) {
								if (department != null
										&& department.getDname().equals(
												m.getDepartment().getDname()))
									major = (Major) m;
							}
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						// 职称外键3
						List professionaltitleList = professionalTitleService
								.findEntityByName(Professionaltitle.class,
										"professionalTitleName", cellValue_6);
						Professionaltitle professionaltitle = null;
						if (professionaltitleList.size() != 0) {
							professionaltitle = (Professionaltitle) professionaltitleList
									.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行职称信息有误，该职称在职称信息库中不存在！";
							continue;
						}

						// 学位外键4

						List academicdegreeList = academicdegreeService
								.findEntityByName(Academicdegree.class,
										"bestDegreeName", cellValue_7);

						Academicdegree academicdegree = null;
						if (academicdegreeList.size() != 0) {
							academicdegree = (Academicdegree) academicdegreeList
									.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学位信息有误，该学位在学位信息库中不存在！";
							continue;
						}
						// 学历外键5
						List degreeList = degreeService.findEntityByName(
								Degree.class, "degreeName", cellValue_8);
						Degree degree = null;

						if (degreeList.size() != 0) {

							degree = (Degree) degreeList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学历信息有误，该学历在学历信息库中不存在！";
							continue;
						}
						// 师资类别6
						List teacherscategoryList = teachersCategoryService
								.findEntityByName(Teacherscategory.class,
										"teachersCategoryName", cellValue_9);
						Teacherscategory teacherscategory = null;
						if (teacherscategoryList.size() != 0) {
							teacherscategory = (Teacherscategory) teacherscategoryList
									.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行师资类别信息有误，该师资类别在师资类别信息库中不存在！";
							continue;
						}
						// 岗位类型
						List jobtypeList = jobTypeService.findEntityByName(
								Jobtype.class, "jobTypeName", cellValue_11);
						Jobtype jobtype = null;
						if (jobtypeList.size() != 0) {
							jobtype = (Jobtype) jobtypeList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行岗位类型信息有误，该岗位类型在岗位类型信息库中不存在！";
							continue;
						}
						// 学缘
						List learningEdgeList = learningEdgeService
								.findEntityByName(Learningedge.class,
										"learnEdgeName", cellValue_12);
						Learningedge learningEdge = null;
						if (learningEdgeList.size() != 0) {
							learningEdge = (Learningedge) learningEdgeList
									.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学缘信息有误，该学缘在学缘信息库中不存在！";
							continue;
						}
						// 学科类别

						List subjectCategoryList = subjectCategoryService
								.findEntityByName(Subjectcategory.class,
										"subjectCategoryName", cellValue_13);
						Subjectcategory subjectCategory = null;
						if (subjectCategoryList.size() != 0) {
							subjectCategory = (Subjectcategory) subjectCategoryList
									.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行学科类别信息有误，该学科类别在学科类别信息库中不存在！";
							continue;
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();
						String dno = QueryUtil.getUserMno().getDepartment()
								.getDno();
						/*
						 * System.out.println(major.getDepartment().getDname()+"  "
						 * +
						 * department.getDname()+"  "+major.getDepartment().getDname
						 * () .equals(department.getDname()));
						 */
						if (mno.equals("000000")) {
							// if (department != null) {
							// if (major != null) {
							if (major.getDepartment().getDname().equals(
									department.getDname())) {
								// if (professionaltitle != null) {
								// if (academicdegree != null) {
								// if (degree != null) {
								// if (teacherscategory != null) {
								// if (jobtype != null) {
								// if (learningEdge != null) {
								// if (subjectCategory != null) {
								if (tea == null) {
									Teacher teacher = new Teacher();
									teacher.setTno(cellValue_0);
									teacher.setTname(cellValue_1);
									teacher.setBirthDay(cellValue_3);
									// major.setDepartment(department);

									teacher.setMajor(major);
									teacher
											.setProfessionaltitle(professionaltitle);
									teacher.setAcademicdegree(academicdegree);
									teacher.setDegree(degree);
									teacher
											.setTeacherscategory(teacherscategory);
									teacher.setInServiceState(cellValue_10);
									teacher.setIsDoubleTeacher(cellValue_14);
									teacher.setJobtype(jobtype);
									teacher.setSubjectcategory(subjectCategory);
									teacher.setLearningedge(learningEdge);
									teacher
											.setIsEngineerBackground(cellValue_15);
									teacher
											.setIsIndustryBackground(cellValue_16);
									teacher.setIsOuterTeacher(cellValue_19);
									teacher
											.setIsPracticeTeachTraining(cellValue_17);
									teacher.setSex(cellValue_2);
									teacher.setTutorType(cellValue_18);
									teacherList.add(teacher);

								} else {

									tea.setTname(cellValue_1);
									tea.setBirthDay(cellValue_3);
									// major.setDepartment(department);
									tea.setMajor(major);
									tea.setProfessionaltitle(professionaltitle);
									tea.setAcademicdegree(academicdegree);
									tea.setDegree(degree);
									tea.setTeacherscategory(teacherscategory);
									tea.setInServiceState(cellValue_10);
									tea.setIsDoubleTeacher(cellValue_14);
									tea.setJobtype(jobtype);
									tea.setSubjectcategory(subjectCategory);
									tea.setLearningedge(learningEdge);
									tea.setIsEngineerBackground(cellValue_15);
									tea.setIsIndustryBackground(cellValue_16);
									tea.setIsOuterTeacher(cellValue_19);
									tea
											.setIsPracticeTeachTraining(cellValue_17);
									tea.setSex(cellValue_2);
									tea.setTutorType(cellValue_18);
									teacherList.add(tea);

								}
								// } else {
								// errorMessg += "第"
								// + rflag
								// + "学科类别数据项有误！";
								// continue;
								// }
								// } else {
								// errorMessg += "第"
								// + rflag
								// + "学缘列数据项有误！";
								// continue;
								// }
								//
								// } else {
								// errorMessg += "第"
								// + rflag
								// + "行岗位类型列数据项有误！";
								// continue;
								// }
								// } else {
								//
								// errorMessg += "第"
								// + rflag
								// + "行师资类别列数据项有误！";
								// continue;
								// }
								// } else {
								// errorMessg = "第" + rflag
								// + "行学历数据列数据项有误！";
								// continue;
								// }
								// } else {
								// errorMessg = "第" + rflag
								// + "行学位数据列数据项有误！";
								// continue;
								// }
								// } else {
								//
								// errorMessg = "第" + rflag
								// + "行职称数据列数据项有误！";
								// continue;
								//
								// }
							} else {
								errorMessg = "第" + rflag + "行学院与专业数据列数据项匹配有误！";
								continue;
							}
							// } else {
							//
							// errorMessg = "第" + rflag + "行专业数据列数据项有误！";
							// continue;
							//
							// }
							// } else {
							// errorMessg = "第" + rflag + "行学院数据列数据项有误！";
							// continue;
							// }

						}

						else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据！";
							continue;
						}
					}
				}
				// 更新数据库：
				teacherService.batchUpdateResult(Teacher.class, teacherList);
				successMessg = "您此次导入了" + teacherList.size() + "条教师基本信息!";
				successMessg += errorMessg;
			}
			// 高层次人才
			HSSFWorkbook workbook1;
			if (excelFile != null && importName.equals("high")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				highList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook1 = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook1.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {

						// Cell cell_0 = row.getCell(0);// Id
						Cell cell_1 = row.getCell(0);// 教师Id
						Cell cell_2 = row.getCell(1);// 教师名字
						Cell cell_3 = row.getCell(2);// 所在专业
						Cell cell_4 = row.getCell(3);// 人才类型
						Cell cell_5 = row.getCell(4);// 人才级别
						Cell cell_6 = row.getCell(5);// 研究领域
						Cell cell_7 = row.getCell(6);// 获得年份

						// Double cellValue_0;
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						// 专业外键
						// List majorList = majorService.findEntityByName(
						// Major.class, "mname", cellValue_3);
						Major major = null;
						major = teacher.getMajor();
						// if (majorList.size() != 0) {
						// major = (Major) majorList.get(0);
						// }

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院

						// if (major != null) {
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && major
										.getDepartment().getDno().equals(
												departNos))
								|| mno.equals(major.getInMno())) {// 检验身份
							// if (teacher != null) {
							// if (teacher.getTname().equals(cellValue_2)) {
							// if (teacher.getMajor().getMname()
							// .equals(cellValue_3)) {
							Highleveltalent high1 = new Highleveltalent();
							high1.setTeacher(teacher);
							high1.setTalentType(cellValue_4);
							high1.setTalentLevel(cellValue_5);
							high1.setRearchField(cellValue_6);
							high1.setYear(cellValue_7);
							highList.add(high1);
							// } else {
							// errorMessg = "第"
							// + r
							// + "行专业名称数据项与数据库对应的专业名称信息不匹配！";
							// return "majorStyleerror";
							// }

							// } else {
							// errorMessg = "第" + r
							// + "行教师名称数据项数据库中教师名字不匹配！";
							// return "majorStyleerror";
							// }

							// } else {
							// errorMessg = "第" + r + "行教师编号数据项在数据库中不存在！";
							// return "majorStyleerror";
							// }
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}

						// } else {// 专业
						// errorMessg = "第" + r + "行专业数据项在数据库中不存在！";
						// return "majorStyleerror";
						// }
					}
				}
				// 更新数据库：
				highService.batchUpdateResult(Highleveltalent.class, highList);
				successMessg = "您此次导入了" + highList.size() + "条高层次人才基本信息!";
				successMessg += errorMessg;
			}
			// 主持科研项目
			if (excelFile != null && importName.equals("pres")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				presList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook1 = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook1.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				errorMessg = "";
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;
					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 项目编号
						Cell cell_1 = row.getCell(1);// 项目名称
						Cell cell_2 = row.getCell(2);// 教师名称
						Cell cell_3 = row.getCell(3);// 项目级别
						Cell cell_4 = row.getCell(4);// 项目类型
						Cell cell_5 = row.getCell(5);// 立项时间
						Cell cell_6 = row.getCell(6);// 验收时间
						Cell cell_7 = row.getCell(7);// 经费
						Cell cell_8 = row.getCell(8);// 参与教师人数
						Cell cell_9 = row.getCell(9);// 备注

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";
						String cellValue_9 = "";

						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 += cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 = cell_2.toString().replaceAll("\\s",
									"");
							// cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						presNo = cellValue_0;
						Presidedoverscientificresearchproject pres = presService
								.findById(
										Presidedoverscientificresearchproject.class,
										cellValue_0);
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_2 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_2 + "'").get(0);
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院
						// String majorNo = "";// 导入数据中传递的专业
						String departNo = "";// 导入数据中传递的学院
						// if (teacher != null) {
						// majorNo = techer.getMajor().getMno();
						departNo = teacher.getMajor().getDepartment().getDno();
						// if (teacher.getTname().equals(cellValue_3)) {
						// 校验身份
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && departNo
										.equals(departNos))
								|| departNo.equals(departNos)) {// ||
							// mno.equals(majorNo)
							if (pres == null) {
								Presidedoverscientificresearchproject pres1 = new Presidedoverscientificresearchproject();
								pres1.setProjectNo(cellValue_0);
								pres1.setTeacher(teacher);
								pres1.setProjectName(cellValue_1);
								pres1.setProjecJibie(cellValue_3);
								pres1.setProjecType(cellValue_4);
								pres1.setYear(cellValue_5);
								pres1.setProjecTime(cellValue_5);
								pres1.setAcceptenceDate(cellValue_6);
								pres1.setCost(Float.valueOf(cellValue_7));
								pres1.setPartTeacherNum(Integer
										.valueOf(cellValue_8));
								pres1.setBeizhu(cellValue_9);
								presList.add(pres1);
							} else {
								pres.setTeacher(teacher);
								pres.setProjectName(cellValue_1);
								pres.setProjecJibie(cellValue_3);
								pres.setProjecType(cellValue_4);
								pres.setYear(cellValue_5);
								pres.setProjecTime(cellValue_5);
								pres.setAcceptenceDate(cellValue_6);
								pres.setCost(Float.valueOf(cellValue_7));
								pres.setPartTeacherNum(Integer
										.valueOf(cellValue_8));
								pres.setBeizhu(cellValue_9);
								presList.add(pres);
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg = "第" + rflag
						// + "行教师姓名数据项与数据库中对应教师姓名不匹配！";
						// return "majorStyleerror";
						//
						// }

						// } else {
						// errorMessg = "第" + rflag + "行教师编号数据项在数据库中不存在！";
						// return "majorStyleerror";
						//
						// }

					}
				}// for
				// 更新数据库：
				presService.batchUpdateResult(
						Presidedoverscientificresearchproject.class, presList);
				successMessg = "您此次导入了" + presList.size() + "条教师主持科研基本信息!";
				successMessg += errorMessg;
			}

			// 主持教改项目
			if (excelFile != null && importName.equals("prer")) {
				// String path = excelFile.getAbsolutePath();// 获取文件的路径
				System.out.println("进入导入");
				prerList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook1 = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook1.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				errorMessg = "";
				/** 循环Excel的行 */
				int rflag = 0;
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 项目编号
						Cell cell_1 = row.getCell(1);// 项目名称
						Cell cell_2 = row.getCell(2);// 教师编号
						Cell cell_3 = row.getCell(3);// 教师名称
						Cell cell_4 = row.getCell(4);// 项目级别
						Cell cell_5 = row.getCell(5);// 项目类型
						Cell cell_6 = row.getCell(6);// 立项时间
						Cell cell_7 = row.getCell(7);// 验收时间
						Cell cell_8 = row.getCell(8);// 经费
						Cell cell_9 = row.getCell(9);// 参与教师人数
						Cell cell_10 = row.getCell(10);// 备注

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						Date cellValue_6 = null;
						Date cellValue_7 = null;
						String cellValue_8 = "";
						String cellValue_9 = "";
						String cellValue_10 = "";

						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 = cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_6)) {
								cellValue_6 = cell_6.getDateCellValue();
							} else {
								errorMessg = "第七列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第七列数据类型应该为日期型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (HSSFDateUtil.isCellDateFormatted(cell_7)) {
								cellValue_7 = cell_7.getDateCellValue();
							} else {
								errorMessg = "第八列日期型数据格式不正确，格式如2015/7/01！";
								return "error";
							}
						} else {
							errorMessg = "第八列数据类型应该为日期型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}
						if (cell_9.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_9 += cell_9.getStringCellValue();
						} else {
							errorMessg = "第十列数据类型应该为文本型！";
							return "error";
						}
						if (cell_10.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_10 += cell_10.getStringCellValue();
						} else {
							errorMessg = "第十一列数据类型应该为文本型！";
							return "error";
						}
						prerNo = cellValue_0;
						Presidedoverrevolutionresearchproject prer = prerService
								.findById(
										Presidedoverrevolutionresearchproject.class,
										cellValue_0);
						// 教师外键
						Teacher teacher = null;
						int size = 0;
						size = teacherService.findByHQL(
								"from Teacher as t where t.tname='"
										+ cellValue_3 + "'").size();
						if (size == 0) {
							errorMessg += "第" + rflag + "行教师在数据库中不存在！";
							continue;
						} else {
							teacher = teacherService.findByHQL(
									"from Teacher as t where t.tname='"
											+ cellValue_3 + "'").get(0);
						}

						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业
						String departNos = QueryUtil.getUserMno()
								.getDepartment().getDno();// 登陆者所在学院
						String majorNo = "";// 导入数据中传递的专业
						String departNo = "";// 导入数据中传递的学院

						// if (techer != null) {
						majorNo = teacher.getMajor().getMno();
						departNo = teacher.getMajor().getDepartment().getDno();
						// if (teacher.getTname().equals(cellValue_3)) {
						// 校验身份
						int newyear = cellValue_6.getYear() + 1900;
						if ((mno.equals("000000") && departNos.equals("00000"))
								|| (mno.equals("000000") && departNo
										.equals(departNos))
								|| mno.equals(majorNo)) {
							if (prer == null) {
								Presidedoverrevolutionresearchproject prer1 = new Presidedoverrevolutionresearchproject();
								prer1.setRprojectNo(cellValue_0);
								prer1.setTeacher(teacher);
								prer1.setRprojectName(cellValue_1);
								prer1.setRprojecJibie(cellValue_4);
								prer1.setRprojecType(cellValue_5);
								prer1.setYear(String.valueOf(newyear));
								prer1.setRprojecTime(cellValue_6);
								prer1.setRacceptenceDate(cellValue_7);
								prer1.setRcost(Float.valueOf(cellValue_8));
								prer1.setRpartTeacherNum(Integer
										.valueOf(cellValue_9));
								prer1.setBeizhu(cellValue_10);
								prerList.add(prer1);
							} else {
								prer.setTeacher(teacher);
								prer.setRprojectName(cellValue_1);
								prer.setRprojecJibie(cellValue_4);
								prer.setRprojecType(cellValue_5);
								prer.setYear(String.valueOf(newyear));
								prer.setRprojecTime(cellValue_6);
								prer.setRacceptenceDate(cellValue_7);
								prer.setRcost(Float.valueOf(cellValue_8));
								prer.setRpartTeacherNum(Integer
										.valueOf(cellValue_9));
								prer.setBeizhu(cellValue_10);
								prerList.add(prer);
							}
						} else {
							errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
							continue;
						}
						// } else {
						// errorMessg = "第" + r
						// + "行教师姓名数据项与数据库中对应教师姓名不匹配！";
						// return "majorStyleerror";
						//
						// }
						//
						// } else {
						// errorMessg = "第" + r + "行教师编号数据项在数据库中不存在！";
						// return "majorStyleerror";
						//
						// }

					}
				}
				// 更新数据库：
				prerService.batchUpdateResult(
						Presidedoverrevolutionresearchproject.class, prerList);
				successMessg = "您此次导入了" + prerList.size() + "条教师主持教改基本信息!";
				successMessg += errorMessg;
			}
			// 实验实习场地
			if (excelFile != null && importName.equals("traingvenue")) {

				System.out.println("进入导入");
				traingvenueList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook1 = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook1.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";
				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 实验室编号
						Cell cell_1 = row.getCell(1);// 实验室名称
						Cell cell_2 = row.getCell(2);// 实验室性质
						Cell cell_3 = row.getCell(3);// 面积
						Cell cell_4 = row.getCell(4);// 最大容纳学生数
						Cell cell_5 = row.getCell(5);// 实验设备总值
						Cell cell_6 = row.getCell(6);// 1000元以上设备总价值
						Cell cell_7 = row.getCell(7);// 开放使用人数
						Cell cell_8 = row.getCell(8);// 使用年份

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						String cellValue_7 = "";
						String cellValue_8 = "";

						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 = cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}
						if (cell_7.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_7 += cell_7.getStringCellValue();
						} else {
							errorMessg = "第八列数据类型应该为文本型！";
							return "error";
						}
						if (cell_8.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_8 += cell_8.getStringCellValue();
						} else {
							errorMessg = "第九列数据类型应该为文本型！";
							return "error";
						}

						Trainingvenue tra = trainingvenueService.findById(
								Trainingvenue.class, cellValue_0);
						if (tra == null) {
							Trainingvenue tra1 = new Trainingvenue();
							tra1.setTraNumer(cellValue_0);
							tra1.setTraName(cellValue_1);
							tra1.setTraCharacter(cellValue_2);
							tra1.setArea(Float.valueOf(cellValue_3));
							tra1.setAptCount(Integer.valueOf(cellValue_4));
							tra1.setEaquipAllVal(Float.valueOf(cellValue_5));
							tra1.setEquipVal(Float.valueOf(cellValue_6));
							tra1.setUseCount(Integer.valueOf(cellValue_7));
							tra1.setYear(cellValue_8);
							traingvenueList.add(tra1);
						} else {
							tra.setTraName(cellValue_1);
							tra.setTraCharacter(cellValue_2);
							tra.setArea(Float.valueOf(cellValue_3));
							tra.setAptCount(Integer.valueOf(cellValue_4));
							tra.setEaquipAllVal(Float.valueOf(cellValue_5));
							tra.setEquipVal(Float.valueOf(cellValue_6));
							tra.setUseCount(Integer.valueOf(cellValue_7));
							tra.setYear(cellValue_8);
							traingvenueList.add(tra);
						}
					} else {
						errorMessg += "第" + rflag + "行由于权限问题，只能导入本学院专业的数据!";
						continue;
					}
				}

				// 更新数据库：
				trainingvenueService.batchUpdateResult(Trainingvenue.class,
						traingvenueList);
				successMessg = "您此次导入了" + traingvenueList.size() + "条实验实训场地信息!"
						+ errorMessg;
			}
			// 实验实习场地使用情况
			if (excelFile != null && importName.equals("traingvenueUse")) {

				System.out.println("进入导入");
				traingvenueuseList.clear();
				InputStream is = new FileInputStream(excelFile);
				workbook1 = new HSSFWorkbook(is);

				/** 得到第一个shell */
				Sheet sheet = workbook1.getSheetAt(0);

				/** 得到Excel的行数 */
				this.totalRows = sheet.getPhysicalNumberOfRows();

				/** 得到Excel的列数 */
				if (this.totalRows >= 1 && sheet.getRow(0) != null) {
					this.totalCells = sheet.getRow(0)
							.getPhysicalNumberOfCells();
				}
				/** 循环Excel的行 */
				int rflag = 0;
				errorMessg = "";

				for (int r = 1; r < this.totalRows; r++) {
					Row row = sheet.getRow(r);
					rflag = r + 1;

					/** 循环Excel的列 */
					if (0 < this.getTotalCells()) {
						Cell cell_0 = row.getCell(0);// 所在专业
						Cell cell_1 = row.getCell(1);// 实验室编号
						Cell cell_2 = row.getCell(2);// 实验室名称
						Cell cell_3 = row.getCell(3);// 课程数
						Cell cell_4 = row.getCell(4);// 专业实验教学人时数
						Cell cell_5 = row.getCell(5);// 专业实验教学人次数
						Cell cell_6 = row.getCell(6);// 使用年份

						String cellValue_0 = "";
						String cellValue_1 = "";
						String cellValue_2 = "";
						String cellValue_3 = "";
						String cellValue_4 = "";
						String cellValue_5 = "";
						String cellValue_6 = "";
						if (cell_0.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_0 = cell_0.getStringCellValue();
						} else {
							errorMessg = "第一列数据类型应该为文本型！";
							return "error";
						}
						if (cell_1.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_1 += cell_1.getStringCellValue();
						} else {
							errorMessg = "第二列数据类型应该为文本型！";
							return "error";
						}
						if (cell_2.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_2 += cell_2.getStringCellValue();
						} else {
							errorMessg = "第三列数据类型应该为文本型！";
							return "error";
						}
						if (cell_3.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_3 += cell_3.getStringCellValue();
						} else {
							errorMessg = "第四列数据类型应该为文本型！";
							return "error";
						}
						if (cell_4.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_4 += cell_4.getStringCellValue();
						} else {
							errorMessg = "第五列数据类型应该为文本型！";
							return "error";
						}
						if (cell_5.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_5 += cell_5.getStringCellValue();
						} else {
							errorMessg = "第六列数据类型应该为文本型！";
							return "error";
						}
						if (cell_6.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							cellValue_6 += cell_6.getStringCellValue();
						} else {
							errorMessg = "第七列数据类型应该为文本型！";
							return "error";
						}

						List majorList = majorService.findEntityByName(
								Major.class, "mname", cellValue_0);// 测试导入专业数据是否符合
						/*
						 * List departmentList = departmentService
						 * .findEntityByName(Department.class, "dname",
						 * cellValue_0);
						 */

						Trainingvenue tra = trainingvenueService.findById(
								Trainingvenue.class, cellValue_1);
						String mno = QueryUtil.getUserMno().getMajor()
								.getInMno();// 登陆者所在专业

						Major major = null;
						if (majorList.size() != 0) {
							major = (Major) majorList.get(0);
						} else {
							errorMessg += "第" + rflag
									+ "行专业信息有误，该专业在专业信息库中不存在！";
							continue;
						}
						Department department = null;
						/*
						 * if (departmentList.size() != 0) { department =
						 * (Department) departmentList.get(0); }else{ errorMessg
						 * += "第" + rflag + "行学院信息有误，该学院在学院信息库中不存在！"; continue;
						 * }
						 */
						// if (major != null) {
						// if (department != null) {
						if (tra != null) {
							/*
							 * if (major.getDepartment().getDname()
							 * .equals(department.getDname())) {
							 */
							if (mno.equals(major.getMno())
									|| mno.equals("000000")) {
								if (tra.getTraName().equals(cellValue_2)) {
									Trainingvenueuse trause = new Trainingvenueuse();
									trause.setTrainingvenue(tra);
									trause.setMajor(major);
									trause.setCourseCount(Integer
											.valueOf(cellValue_3));
									trause.setThHcount(Integer
											.valueOf(cellValue_4));
									trause.setThPcount(Integer
											.valueOf(cellValue_5));
									trause.setYear(cellValue_6);
									traingvenueuseList.add(trause);
								} else {
									errorMessg += "第" + rflag
											+ "行实验室编号和实验室名称不匹配!";
									continue;
								}
							} else {
								errorMessg += "第" + rflag + "行专业编号和专业名称不匹配!";
								continue;
							}
							/*
							 * } else { errorMessg = "第" + rflag +
							 * "行学院和专业信息不匹配!"; continue; }
							 */
						} else {
							errorMessg += "第" + rflag + "行实验室数据有误！";
							continue;
						}
					}
					// } else {
					//
					// errorMessg = "第" + rflag + "行学院数据有误！";
					// return "majorStyleerror";
					// }
					// } else {
					//
					// errorMessg = "第" + rflag + "行专业数据项有误！";
					// return "majorStyleerror";
					// }

				}
				// 更新数据库：
				trainingvenueuseService.batchUpdateResult(
						Trainingvenueuse.class, traingvenueuseList);
				System.out.println("SSD" + traingvenueuseList.size());
				setSuccessMessg("您此次导入了" + traingvenueuseList.size()
						+ "条实验实训场地使用情况信息!" + errorMessg);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}

	public TeachingplanchangeService getTplanService() {
		return tplanService;
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

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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

	// getter and setter
	public int getContestId() {
		return contestId;
	}

	public void setContestId(int contestId) {
		this.contestId = contestId;
	}

	/*
	 * public File getExcelFile() { return excelFile; } public void
	 * setExcelFile(File excelFile) { this.excelFile = excelFile; }
	 */
	public String getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalCells() {
		return totalCells;
	}

	public void setTotalCells(int totalCells) {
		this.totalCells = totalCells;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public EmploymentService getEmpService() {
		return empService;
	}

	public void setEmpService(EmploymentService empService) {
		this.empService = empService;
	}

	public List<Employment> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employment> empList) {
		this.empList = empList;
	}

	public String getImportName() {
		return importName;
	}

	public void setImportName(String importName) {
		this.importName = importName;
	}

	public CurriculumresourceService getCurService() {
		return curService;
	}

	public void setCurService(CurriculumresourceService curService) {
		this.curService = curService;
	}

	public AddmissionsService getAdmService() {
		return admService;
	}

	public void setAdmService(AddmissionsService admService) {
		this.admService = admService;
	}

	public QualitystandardService getQuastanService() {
		return quastanService;
	}

	public void setQuastanService(QualitystandardService quastanService) {
		this.quastanService = quastanService;
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

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public CompetitionService getCompetitionService() {
		return competitionService;
	}

	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
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

	public TeachResultBaseService getTeachResultBaseService() {
		return teachResultBaseService;
	}

	public void setTeachResultBaseService(
			TeachResultBaseService teachResultBaseService) {
		this.teachResultBaseService = teachResultBaseService;
	}

	public InnovationprojectService getInnovationprojectService() {
		return innovationprojectService;
	}

	public void setInnovationprojectService(
			InnovationprojectService innovationprojectService) {
		this.innovationprojectService = innovationprojectService;
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

	public AchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
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

	public List<Teachresultbaseinfo> getTeachresultbaseinfolist() {
		return teachresultbaseinfolist;
	}

	public void setTeachresultbaseinfolist(
			List<Teachresultbaseinfo> teachresultbaseinfolist) {
		this.teachresultbaseinfolist = teachresultbaseinfolist;
	}

	public String attachFileList() {

		return SUCCESS;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
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

	public StupatentService getStupatentService() {
		return stupatentService;
	}

	public void setStupatentService(StupatentService stupatentService) {
		this.stupatentService = stupatentService;
	}

	public List<Stupatent> getStupList() {
		return stupList;
	}

	public void setStupList(List<Stupatent> stupList) {
		this.stupList = stupList;
	}

	public NationalService getNationalService() {
		return nationalService;
	}

	public void setNationalService(NationalService nationalService) {
		this.nationalService = nationalService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public TeachingcostService getTeachingcostService() {
		return teachingcostService;
	}

	public void setTeachingcostService(TeachingcostService teachingcostService) {
		this.teachingcostService = teachingcostService;
	}

	public List<Teachingcost> getTeachingcostList() {
		return teachingcostList;
	}

	public void setTeachingcostList(List<Teachingcost> teachingcostList) {
		this.teachingcostList = teachingcostList;
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

	public TraininguseinginformationService getTraininguseinginformationService() {
		return traininguseinginformationService;
	}

	public void setTraininguseinginformationService(
			TraininguseinginformationService traininguseinginformationService) {
		this.traininguseinginformationService = traininguseinginformationService;
	}

	public List<Communicationsitu> getCommunicationsituList() {
		return communicationsituList;
	}

	public void setCommunicationsituList(
			List<Communicationsitu> communicationsituList) {
		this.communicationsituList = communicationsituList;
	}

	public List<Fulfillinginstance> getFulfillinginstanceList() {
		return fulfillinginstanceList;
	}

	public void setFulfillinginstanceList(
			List<Fulfillinginstance> fulfillinginstanceList) {
		this.fulfillinginstanceList = fulfillinginstanceList;
	}

	public List<Traininguseinginformation> getTraininguseinginformationList() {
		return traininguseinginformationList;
	}

	public void setTraininguseinginformationList(
			List<Traininguseinginformation> traininguseinginformationList) {
		this.traininguseinginformationList = traininguseinginformationList;
	}

	public EffectqualityeducationService getEqeService() {
		return eqeService;
	}

	public void setEqeService(EffectqualityeducationService eqeService) {
		this.eqeService = eqeService;
	}

	public List<Effectofqualityeducation> getEqeList() {
		return eqeList;
	}

	public void setEqeList(List<Effectofqualityeducation> eqeList) {
		this.eqeList = eqeList;
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

	public TeachertrainingService getTeachertrainingService() {
		return teachertrainingService;
	}

	public void setTeachertrainingService(
			TeachertrainingService teachertrainingService) {
		this.teachertrainingService = teachertrainingService;
	}

	public List<Teachertraining> getTeatList() {
		return teatList;
	}

	public void setTeatList(List<Teachertraining> teatList) {
		this.teatList = teatList;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getPresNo() {
		return presNo;
	}

	public void setPresNo(String presNo) {
		this.presNo = presNo;
	}

	public String getPrerNo() {
		return prerNo;
	}

	public void setPrerNo(String prerNo) {
		this.prerNo = prerNo;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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

	public TeachingcosttypeService getTeachingcosttypeService() {
		return teachingcosttypeService;
	}

	public void setTeachingcosttypeService(
			TeachingcosttypeService teachingcosttypeService) {
		this.teachingcosttypeService = teachingcosttypeService;
	}

	public void setErrorMessg(String errorMessg) {
		this.errorMessg = errorMessg;
	}

	public String getErrorMessg() {
		return errorMessg;
	}

	public void setSuccessMessg(String successMessg) {
		this.successMessg = successMessg;
	}

	public String getSuccessMessg() {
		return successMessg;
	}

	public void setAcademicdegreeList(List<Academicdegree> academicdegreeList) {
		this.academicdegreeList = academicdegreeList;
	}

	public List<Academicdegree> getAcademicdegreeList() {
		return academicdegreeList;
	}

	public void setDegreeList(List<Degree> degreeList) {
		this.degreeList = degreeList;
	}

	public List<Degree> getDegreeList() {
		return degreeList;
	}

	public DegreeService getDegreeService() {
		return degreeService;
	}

	public void setDegreeService(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public ProfessionalTitleService getProfessionalTitleService() {
		return professionalTitleService;
	}

	public void setProfessionalTitleService(
			ProfessionalTitleService professionalTitleService) {
		this.professionalTitleService = professionalTitleService;
	}

	public AcademicdegreeService getAcademicdegreeService() {
		return academicdegreeService;
	}

	public void setAcademicdegreeService(
			AcademicdegreeService academicdegreeService) {
		this.academicdegreeService = academicdegreeService;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public void setLearningEdgeList(List<Learningedge> learningEdgeList) {
		this.learningEdgeList = learningEdgeList;
	}

	public List<Learningedge> getLearningEdgeList() {
		return learningEdgeList;
	}

	public void setJobtypeList(List<Jobtype> jobtypeList) {
		this.jobtypeList = jobtypeList;
	}

	public List<Jobtype> getJobtypeList() {
		return jobtypeList;
	}

	public void setSubjectCategoryList(List<Subjectcategory> subjectCategoryList) {
		this.subjectCategoryList = subjectCategoryList;
	}

	public List<Subjectcategory> getSubjectCategoryList() {
		return subjectCategoryList;
	}

	public JobTypeService getJobTypeService() {
		return jobTypeService;
	}

	public void setJobTypeService(JobTypeService jobTypeService) {
		this.jobTypeService = jobTypeService;
	}

	public SubjectCategoryService getSubjectCategoryService() {
		return subjectCategoryService;
	}

	public void setSubjectCategoryService(
			SubjectCategoryService subjectCategoryService) {
		this.subjectCategoryService = subjectCategoryService;
	}

	public TeachersCategoryService getTeachersCategoryService() {
		return teachersCategoryService;
	}

	public void setTeachersCategoryService(
			TeachersCategoryService teachersCategoryService) {
		this.teachersCategoryService = teachersCategoryService;
	}

	public LearningEdgeService getLearningEdgeService() {
		return learningEdgeService;
	}

	public void setLearningEdgeService(LearningEdgeService learningEdgeService) {
		this.learningEdgeService = learningEdgeService;
	}

	public List<Teacherscategory> getTeacherscategoryList() {
		return teacherscategoryList;
	}

	public void setTeacherscategoryList(
			List<Teacherscategory> teacherscategoryList) {
		this.teacherscategoryList = teacherscategoryList;
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

	public TrainingvenueUsingService getTrainingvenueuseService() {
		return trainingvenueuseService;
	}

	public void setTrainingvenueuseService(
			TrainingvenueUsingService trainingvenueuseService) {
		this.trainingvenueuseService = trainingvenueuseService;
	}

	public List<Trainingvenueuse> getTraingvenueuseList() {
		return traingvenueuseList;
	}

	public void setTraingvenueuseList(List<Trainingvenueuse> traingvenueuseList) {
		this.traingvenueuseList = traingvenueuseList;
	}

	public List<Trainingvenue> getTraingvenueList() {
		return traingvenueList;
	}

}
