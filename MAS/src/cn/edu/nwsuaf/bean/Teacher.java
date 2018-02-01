package cn.edu.nwsuaf.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private String tno;
	private Major major;
	private Professionaltitle professionaltitle;
	private Teacherscategory teacherscategory;
	private Learningedge learningedge;
	private Degree degree;
	private Academicdegree academicdegree;
	private Subjectcategory subjectcategory;
	private Jobtype jobtype;
	private Date titleEvaluationTime;
	private String departmentGroup;
	private String tname;
	private String sex;
	private Date birthDay;
	private Date entryDate;
	private String year;
	private String inServiceState;
	private String gratuatdSchool;
	private String graduatedMajor;
	private String getScholarYear;
	private String resrachDirection;
	private String isDoubleTeacher;
	private String isEngineerBackground;
	private String isIndustryBackground;
	private String isPracticeTeachTraining;
	private String tutorType;
	private String isOuterTeacher;
	private Integer tag;
	private String mname;
	private String getScholarDate;
	private Integer enableState;
	private Set presidedoverrevolutionresearchprojects = new HashSet(0);
	private Set teachprojectusers = new HashSet(0);
	private Set teacherachievementses = new HashSet(0);
	private Set teachertrainings = new HashSet(0);
	private Set presidedoverscientificresearchprojects = new HashSet(0);
	private Set publicshedarevolutionpaperses = new HashSet(0);
	private Set teachresults = new HashSet(0);
	private Set teacherachievementses_1 = new HashSet(0);
	private Set majorcourses = new HashSet(0);
	private Set teacherprojectusers = new HashSet(0);
	private Set presidedoverrevolutionresearchprojects_1 = new HashSet(0);
	private Set highleveltalents = new HashSet(0);
	private Set publicshedaacademicpaperses = new HashSet(0);
	private Set presidedoverscientificresearchprojects_1 = new HashSet(0);
	private Set teachbooks = new HashSet(0);
	private Set teachbooks_1 = new HashSet(0);
	private Set highleveltalents_1 = new HashSet(0);
	private Set teachresults_1 = new HashSet(0);
	private Set publicshedaacademicpaperses_1 = new HashSet(0);
	private Set teachprojects = new HashSet(0);
	private Set teachertrainings_1 = new HashSet(0);
	private Set teachprojects_1 = new HashSet(0);
	private Set publicshedarevolutionpaperses_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String tno) {
		this.tno = tno;
	}

	/** full constructor */
	public Teacher(String tno, Major major,
			Professionaltitle professionaltitle,
			Teacherscategory teacherscategory, Learningedge learningedge,
			Degree degree, Academicdegree academicdegree,
			Subjectcategory subjectcategory, Jobtype jobtype,
			Date titleEvaluationTime, String departmentGroup, String tname,
			String sex, Date birthDay, Date entryDate, String year,
			String inServiceState, String gratuatdSchool,
			String graduatedMajor, String getScholarYear,
			String resrachDirection, String isDoubleTeacher,
			String isEngineerBackground, String isIndustryBackground,
			String isPracticeTeachTraining, String tutorType,
			String isOuterTeacher, Integer tag, String mname,
			String getScholarDate, Integer enableState,
			Set presidedoverrevolutionresearchprojects, Set teachprojectusers,
			Set teacherachievementses, Set teachertrainings,
			Set presidedoverscientificresearchprojects,
			Set publicshedarevolutionpaperses, Set teachresults,
			Set teacherachievementses_1, Set majorcourses,
			Set teacherprojectusers,
			Set presidedoverrevolutionresearchprojects_1, Set highleveltalents,
			Set publicshedaacademicpaperses,
			Set presidedoverscientificresearchprojects_1, Set teachbooks,
			Set teachbooks_1, Set highleveltalents_1, Set teachresults_1,
			Set publicshedaacademicpaperses_1, Set teachprojects,
			Set teachertrainings_1, Set teachprojects_1,
			Set publicshedarevolutionpaperses_1) {
		this.tno = tno;
		this.major = major;
		this.professionaltitle = professionaltitle;
		this.teacherscategory = teacherscategory;
		this.learningedge = learningedge;
		this.degree = degree;
		this.academicdegree = academicdegree;
		this.subjectcategory = subjectcategory;
		this.jobtype = jobtype;
		this.titleEvaluationTime = titleEvaluationTime;
		this.departmentGroup = departmentGroup;
		this.tname = tname;
		this.sex = sex;
		this.birthDay = birthDay;
		this.entryDate = entryDate;
		this.year = year;
		this.inServiceState = inServiceState;
		this.gratuatdSchool = gratuatdSchool;
		this.graduatedMajor = graduatedMajor;
		this.getScholarYear = getScholarYear;
		this.resrachDirection = resrachDirection;
		this.isDoubleTeacher = isDoubleTeacher;
		this.isEngineerBackground = isEngineerBackground;
		this.isIndustryBackground = isIndustryBackground;
		this.isPracticeTeachTraining = isPracticeTeachTraining;
		this.tutorType = tutorType;
		this.isOuterTeacher = isOuterTeacher;
		this.tag = tag;
		this.mname = mname;
		this.getScholarDate = getScholarDate;
		this.enableState = enableState;
		this.presidedoverrevolutionresearchprojects = presidedoverrevolutionresearchprojects;
		this.teachprojectusers = teachprojectusers;
		this.teacherachievementses = teacherachievementses;
		this.teachertrainings = teachertrainings;
		this.presidedoverscientificresearchprojects = presidedoverscientificresearchprojects;
		this.publicshedarevolutionpaperses = publicshedarevolutionpaperses;
		this.teachresults = teachresults;
		this.teacherachievementses_1 = teacherachievementses_1;
		this.majorcourses = majorcourses;
		this.teacherprojectusers = teacherprojectusers;
		this.presidedoverrevolutionresearchprojects_1 = presidedoverrevolutionresearchprojects_1;
		this.highleveltalents = highleveltalents;
		this.publicshedaacademicpaperses = publicshedaacademicpaperses;
		this.presidedoverscientificresearchprojects_1 = presidedoverscientificresearchprojects_1;
		this.teachbooks = teachbooks;
		this.teachbooks_1 = teachbooks_1;
		this.highleveltalents_1 = highleveltalents_1;
		this.teachresults_1 = teachresults_1;
		this.publicshedaacademicpaperses_1 = publicshedaacademicpaperses_1;
		this.teachprojects = teachprojects;
		this.teachertrainings_1 = teachertrainings_1;
		this.teachprojects_1 = teachprojects_1;
		this.publicshedarevolutionpaperses_1 = publicshedarevolutionpaperses_1;
	}

	// Property accessors

	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Professionaltitle getProfessionaltitle() {
		return this.professionaltitle;
	}

	public void setProfessionaltitle(Professionaltitle professionaltitle) {
		this.professionaltitle = professionaltitle;
	}

	public Teacherscategory getTeacherscategory() {
		return this.teacherscategory;
	}

	public void setTeacherscategory(Teacherscategory teacherscategory) {
		this.teacherscategory = teacherscategory;
	}

	public Learningedge getLearningedge() {
		return this.learningedge;
	}

	public void setLearningedge(Learningedge learningedge) {
		this.learningedge = learningedge;
	}

	public Degree getDegree() {
		return this.degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Academicdegree getAcademicdegree() {
		return this.academicdegree;
	}

	public void setAcademicdegree(Academicdegree academicdegree) {
		this.academicdegree = academicdegree;
	}

	public Subjectcategory getSubjectcategory() {
		return this.subjectcategory;
	}

	public void setSubjectcategory(Subjectcategory subjectcategory) {
		this.subjectcategory = subjectcategory;
	}

	public Jobtype getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}

	public Date getTitleEvaluationTime() {
		return this.titleEvaluationTime;
	}

	public void setTitleEvaluationTime(Date titleEvaluationTime) {
		this.titleEvaluationTime = titleEvaluationTime;
	}

	public String getDepartmentGroup() {
		return this.departmentGroup;
	}

	public void setDepartmentGroup(String departmentGroup) {
		this.departmentGroup = departmentGroup;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getInServiceState() {
		return this.inServiceState;
	}

	public void setInServiceState(String inServiceState) {
		this.inServiceState = inServiceState;
	}

	public String getGratuatdSchool() {
		return this.gratuatdSchool;
	}

	public void setGratuatdSchool(String gratuatdSchool) {
		this.gratuatdSchool = gratuatdSchool;
	}

	public String getGraduatedMajor() {
		return this.graduatedMajor;
	}

	public void setGraduatedMajor(String graduatedMajor) {
		this.graduatedMajor = graduatedMajor;
	}

	public String getGetScholarYear() {
		return this.getScholarYear;
	}

	public void setGetScholarYear(String getScholarYear) {
		this.getScholarYear = getScholarYear;
	}

	public String getResrachDirection() {
		return this.resrachDirection;
	}

	public void setResrachDirection(String resrachDirection) {
		this.resrachDirection = resrachDirection;
	}

	public String getIsDoubleTeacher() {
		return this.isDoubleTeacher;
	}

	public void setIsDoubleTeacher(String isDoubleTeacher) {
		this.isDoubleTeacher = isDoubleTeacher;
	}

	public String getIsEngineerBackground() {
		return this.isEngineerBackground;
	}

	public void setIsEngineerBackground(String isEngineerBackground) {
		this.isEngineerBackground = isEngineerBackground;
	}

	public String getIsIndustryBackground() {
		return this.isIndustryBackground;
	}

	public void setIsIndustryBackground(String isIndustryBackground) {
		this.isIndustryBackground = isIndustryBackground;
	}

	public String getIsPracticeTeachTraining() {
		return this.isPracticeTeachTraining;
	}

	public void setIsPracticeTeachTraining(String isPracticeTeachTraining) {
		this.isPracticeTeachTraining = isPracticeTeachTraining;
	}

	public String getTutorType() {
		return this.tutorType;
	}

	public void setTutorType(String tutorType) {
		this.tutorType = tutorType;
	}

	public String getIsOuterTeacher() {
		return this.isOuterTeacher;
	}

	public void setIsOuterTeacher(String isOuterTeacher) {
		this.isOuterTeacher = isOuterTeacher;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGetScholarDate() {
		return this.getScholarDate;
	}

	public void setGetScholarDate(String getScholarDate) {
		this.getScholarDate = getScholarDate;
	}

	public Integer getEnableState() {
		return this.enableState;
	}

	public void setEnableState(Integer enableState) {
		this.enableState = enableState;
	}

	public Set getPresidedoverrevolutionresearchprojects() {
		return this.presidedoverrevolutionresearchprojects;
	}

	public void setPresidedoverrevolutionresearchprojects(
			Set presidedoverrevolutionresearchprojects) {
		this.presidedoverrevolutionresearchprojects = presidedoverrevolutionresearchprojects;
	}

	public Set getTeachprojectusers() {
		return this.teachprojectusers;
	}

	public void setTeachprojectusers(Set teachprojectusers) {
		this.teachprojectusers = teachprojectusers;
	}

	public Set getTeacherachievementses() {
		return this.teacherachievementses;
	}

	public void setTeacherachievementses(Set teacherachievementses) {
		this.teacherachievementses = teacherachievementses;
	}

	public Set getTeachertrainings() {
		return this.teachertrainings;
	}

	public void setTeachertrainings(Set teachertrainings) {
		this.teachertrainings = teachertrainings;
	}

	public Set getPresidedoverscientificresearchprojects() {
		return this.presidedoverscientificresearchprojects;
	}

	public void setPresidedoverscientificresearchprojects(
			Set presidedoverscientificresearchprojects) {
		this.presidedoverscientificresearchprojects = presidedoverscientificresearchprojects;
	}

	public Set getPublicshedarevolutionpaperses() {
		return this.publicshedarevolutionpaperses;
	}

	public void setPublicshedarevolutionpaperses(
			Set publicshedarevolutionpaperses) {
		this.publicshedarevolutionpaperses = publicshedarevolutionpaperses;
	}

	public Set getTeachresults() {
		return this.teachresults;
	}

	public void setTeachresults(Set teachresults) {
		this.teachresults = teachresults;
	}

	public Set getTeacherachievementses_1() {
		return this.teacherachievementses_1;
	}

	public void setTeacherachievementses_1(Set teacherachievementses_1) {
		this.teacherachievementses_1 = teacherachievementses_1;
	}

	public Set getMajorcourses() {
		return this.majorcourses;
	}

	public void setMajorcourses(Set majorcourses) {
		this.majorcourses = majorcourses;
	}

	public Set getTeacherprojectusers() {
		return this.teacherprojectusers;
	}

	public void setTeacherprojectusers(Set teacherprojectusers) {
		this.teacherprojectusers = teacherprojectusers;
	}

	public Set getPresidedoverrevolutionresearchprojects_1() {
		return this.presidedoverrevolutionresearchprojects_1;
	}

	public void setPresidedoverrevolutionresearchprojects_1(
			Set presidedoverrevolutionresearchprojects_1) {
		this.presidedoverrevolutionresearchprojects_1 = presidedoverrevolutionresearchprojects_1;
	}

	public Set getHighleveltalents() {
		return this.highleveltalents;
	}

	public void setHighleveltalents(Set highleveltalents) {
		this.highleveltalents = highleveltalents;
	}

	public Set getPublicshedaacademicpaperses() {
		return this.publicshedaacademicpaperses;
	}

	public void setPublicshedaacademicpaperses(Set publicshedaacademicpaperses) {
		this.publicshedaacademicpaperses = publicshedaacademicpaperses;
	}

	public Set getPresidedoverscientificresearchprojects_1() {
		return this.presidedoverscientificresearchprojects_1;
	}

	public void setPresidedoverscientificresearchprojects_1(
			Set presidedoverscientificresearchprojects_1) {
		this.presidedoverscientificresearchprojects_1 = presidedoverscientificresearchprojects_1;
	}

	public Set getTeachbooks() {
		return this.teachbooks;
	}

	public void setTeachbooks(Set teachbooks) {
		this.teachbooks = teachbooks;
	}

	public Set getTeachbooks_1() {
		return this.teachbooks_1;
	}

	public void setTeachbooks_1(Set teachbooks_1) {
		this.teachbooks_1 = teachbooks_1;
	}

	public Set getHighleveltalents_1() {
		return this.highleveltalents_1;
	}

	public void setHighleveltalents_1(Set highleveltalents_1) {
		this.highleveltalents_1 = highleveltalents_1;
	}

	public Set getTeachresults_1() {
		return this.teachresults_1;
	}

	public void setTeachresults_1(Set teachresults_1) {
		this.teachresults_1 = teachresults_1;
	}

	public Set getPublicshedaacademicpaperses_1() {
		return this.publicshedaacademicpaperses_1;
	}

	public void setPublicshedaacademicpaperses_1(
			Set publicshedaacademicpaperses_1) {
		this.publicshedaacademicpaperses_1 = publicshedaacademicpaperses_1;
	}

	public Set getTeachprojects() {
		return this.teachprojects;
	}

	public void setTeachprojects(Set teachprojects) {
		this.teachprojects = teachprojects;
	}

	public Set getTeachertrainings_1() {
		return this.teachertrainings_1;
	}

	public void setTeachertrainings_1(Set teachertrainings_1) {
		this.teachertrainings_1 = teachertrainings_1;
	}

	public Set getTeachprojects_1() {
		return this.teachprojects_1;
	}

	public void setTeachprojects_1(Set teachprojects_1) {
		this.teachprojects_1 = teachprojects_1;
	}

	public Set getPublicshedarevolutionpaperses_1() {
		return this.publicshedarevolutionpaperses_1;
	}

	public void setPublicshedarevolutionpaperses_1(
			Set publicshedarevolutionpaperses_1) {
		this.publicshedarevolutionpaperses_1 = publicshedarevolutionpaperses_1;
	}

}