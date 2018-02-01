package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private String mno;
	private Department department;
	private Majorcategory majorcategory;
	private Disciplinetype disciplinetype;
	private Majortype majortype;
	private String mname;
	private Integer majorStudentNum;
	private String codeVer;
	private String inMno;
	private String inmName;
	private String menglishName;
	private String mdirectId;
	private String mdirectName;
	private String innerNo;
	private String teachernNo;
	private String enrollmentState;
	private String majorFeatures;
	private String majorTrainingObjective;
	private Integer majorLength;
	private String year;
	private String majorNew;
	private Integer majorHours;
	private Integer majorCompulsoryHours;
	private Integer majorSelectedHours;
	private Integer courseInnerTeachHours;
	private Integer practiceTeachHours;
	private Float credit;
	private Float compulsoryCredit;
	private Float selectedCredit;
	private Float focusParcticeCredit;
	private Float courseInnerTeachCredit;
	private Float practiceCredit;
	private Float outerScienticActivityCredit;
	private Integer enableState;
	private Integer tag;
	private Set students = new HashSet(0);
	private Set qualitystandards = new HashSet(0);
	private Set teachingplanchanges = new HashSet(0);
	private Set addmissionses = new HashSet(0);
	private Set majorcourses = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set communicationsitus = new HashSet(0);
	private Set teachingcosts = new HashSet(0);
	private Set trainingvenueuses = new HashSet(0);
	private Set trainingvenueuses_1 = new HashSet(0);
	private Set teachingcosts_1 = new HashSet(0);
	private Set curriculumresources = new HashSet(0);
	private Set teachers_1 = new HashSet(0);
	private Set employments = new HashSet(0);
	private Set effectofqualityeducations = new HashSet(0);
	private Set basevenueuses = new HashSet(0);
	private Set fulfillinginstances = new HashSet(0);
	private Set curriculumresources_1 = new HashSet(0);
	private Set fulfillinginstances_1 = new HashSet(0);
	private Set addmissionses_1 = new HashSet(0);
	private Set mases = new HashSet(0);
	private Set effectofqualityeducations_1 = new HashSet(0);
	private Set basevenueuses_1 = new HashSet(0);
	private Set employments_1 = new HashSet(0);
	private Set students_1 = new HashSet(0);
	private Set mases_1 = new HashSet(0);
	private Set teachingplanchanges_1 = new HashSet(0);
	private Set qualitystandards_1 = new HashSet(0);
	private Set majorcourses_1 = new HashSet(0);
	private Set communicationsitus_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(String mno) {
		this.mno = mno;
	}

	/** full constructor */
	public Major(String mno, Department department,
			Majorcategory majorcategory, Disciplinetype disciplinetype,
			Majortype majortype, String mname, Integer majorStudentNum,
			String codeVer, String inMno, String inmName, String menglishName,
			String mdirectId, String mdirectName, String innerNo,
			String teachernNo, String enrollmentState, String majorFeatures,
			String majorTrainingObjective, Integer majorLength, String year,
			String majorNew, Integer majorHours, Integer majorCompulsoryHours,
			Integer majorSelectedHours, Integer courseInnerTeachHours,
			Integer practiceTeachHours, Float credit, Float compulsoryCredit,
			Float selectedCredit, Float focusParcticeCredit,
			Float courseInnerTeachCredit, Float practiceCredit,
			Float outerScienticActivityCredit, Integer enableState,
			Integer tag, Set students, Set qualitystandards,
			Set teachingplanchanges, Set addmissionses, Set majorcourses,
			Set teachers, Set communicationsitus, Set teachingcosts,
			Set trainingvenueuses, Set trainingvenueuses_1,
			Set teachingcosts_1, Set curriculumresources, Set teachers_1,
			Set employments, Set effectofqualityeducations, Set basevenueuses,
			Set fulfillinginstances, Set curriculumresources_1,
			Set fulfillinginstances_1, Set addmissionses_1, Set mases,
			Set effectofqualityeducations_1, Set basevenueuses_1,
			Set employments_1, Set students_1, Set mases_1,
			Set teachingplanchanges_1, Set qualitystandards_1,
			Set majorcourses_1, Set communicationsitus_1) {
		this.mno = mno;
		this.department = department;
		this.majorcategory = majorcategory;
		this.disciplinetype = disciplinetype;
		this.majortype = majortype;
		this.mname = mname;
		this.majorStudentNum = majorStudentNum;
		this.codeVer = codeVer;
		this.inMno = inMno;
		this.inmName = inmName;
		this.menglishName = menglishName;
		this.mdirectId = mdirectId;
		this.mdirectName = mdirectName;
		this.innerNo = innerNo;
		this.teachernNo = teachernNo;
		this.enrollmentState = enrollmentState;
		this.majorFeatures = majorFeatures;
		this.majorTrainingObjective = majorTrainingObjective;
		this.majorLength = majorLength;
		this.year = year;
		this.majorNew = majorNew;
		this.majorHours = majorHours;
		this.majorCompulsoryHours = majorCompulsoryHours;
		this.majorSelectedHours = majorSelectedHours;
		this.courseInnerTeachHours = courseInnerTeachHours;
		this.practiceTeachHours = practiceTeachHours;
		this.credit = credit;
		this.compulsoryCredit = compulsoryCredit;
		this.selectedCredit = selectedCredit;
		this.focusParcticeCredit = focusParcticeCredit;
		this.courseInnerTeachCredit = courseInnerTeachCredit;
		this.practiceCredit = practiceCredit;
		this.outerScienticActivityCredit = outerScienticActivityCredit;
		this.enableState = enableState;
		this.tag = tag;
		this.students = students;
		this.qualitystandards = qualitystandards;
		this.teachingplanchanges = teachingplanchanges;
		this.addmissionses = addmissionses;
		this.majorcourses = majorcourses;
		this.teachers = teachers;
		this.communicationsitus = communicationsitus;
		this.teachingcosts = teachingcosts;
		this.trainingvenueuses = trainingvenueuses;
		this.trainingvenueuses_1 = trainingvenueuses_1;
		this.teachingcosts_1 = teachingcosts_1;
		this.curriculumresources = curriculumresources;
		this.teachers_1 = teachers_1;
		this.employments = employments;
		this.effectofqualityeducations = effectofqualityeducations;
		this.basevenueuses = basevenueuses;
		this.fulfillinginstances = fulfillinginstances;
		this.curriculumresources_1 = curriculumresources_1;
		this.fulfillinginstances_1 = fulfillinginstances_1;
		this.addmissionses_1 = addmissionses_1;
		this.mases = mases;
		this.effectofqualityeducations_1 = effectofqualityeducations_1;
		this.basevenueuses_1 = basevenueuses_1;
		this.employments_1 = employments_1;
		this.students_1 = students_1;
		this.mases_1 = mases_1;
		this.teachingplanchanges_1 = teachingplanchanges_1;
		this.qualitystandards_1 = qualitystandards_1;
		this.majorcourses_1 = majorcourses_1;
		this.communicationsitus_1 = communicationsitus_1;
	}

	// Property accessors

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Majorcategory getMajorcategory() {
		return this.majorcategory;
	}

	public void setMajorcategory(Majorcategory majorcategory) {
		this.majorcategory = majorcategory;
	}

	public Disciplinetype getDisciplinetype() {
		return this.disciplinetype;
	}

	public void setDisciplinetype(Disciplinetype disciplinetype) {
		this.disciplinetype = disciplinetype;
	}

	public Majortype getMajortype() {
		return this.majortype;
	}

	public void setMajortype(Majortype majortype) {
		this.majortype = majortype;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMajorStudentNum() {
		return this.majorStudentNum;
	}

	public void setMajorStudentNum(Integer majorStudentNum) {
		this.majorStudentNum = majorStudentNum;
	}

	public String getCodeVer() {
		return this.codeVer;
	}

	public void setCodeVer(String codeVer) {
		this.codeVer = codeVer;
	}

	public String getInMno() {
		return this.inMno;
	}

	public void setInMno(String inMno) {
		this.inMno = inMno;
	}

	public String getInmName() {
		return this.inmName;
	}

	public void setInmName(String inmName) {
		this.inmName = inmName;
	}

	public String getMenglishName() {
		return this.menglishName;
	}

	public void setMenglishName(String menglishName) {
		this.menglishName = menglishName;
	}

	public String getMdirectId() {
		return this.mdirectId;
	}

	public void setMdirectId(String mdirectId) {
		this.mdirectId = mdirectId;
	}

	public String getMdirectName() {
		return this.mdirectName;
	}

	public void setMdirectName(String mdirectName) {
		this.mdirectName = mdirectName;
	}

	public String getInnerNo() {
		return this.innerNo;
	}

	public void setInnerNo(String innerNo) {
		this.innerNo = innerNo;
	}

	public String getTeachernNo() {
		return this.teachernNo;
	}

	public void setTeachernNo(String teachernNo) {
		this.teachernNo = teachernNo;
	}

	public String getEnrollmentState() {
		return this.enrollmentState;
	}

	public void setEnrollmentState(String enrollmentState) {
		this.enrollmentState = enrollmentState;
	}

	public String getMajorFeatures() {
		return this.majorFeatures;
	}

	public void setMajorFeatures(String majorFeatures) {
		this.majorFeatures = majorFeatures;
	}

	public String getMajorTrainingObjective() {
		return this.majorTrainingObjective;
	}

	public void setMajorTrainingObjective(String majorTrainingObjective) {
		this.majorTrainingObjective = majorTrainingObjective;
	}

	public Integer getMajorLength() {
		return this.majorLength;
	}

	public void setMajorLength(Integer majorLength) {
		this.majorLength = majorLength;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMajorNew() {
		return this.majorNew;
	}

	public void setMajorNew(String majorNew) {
		this.majorNew = majorNew;
	}

	public Integer getMajorHours() {
		return this.majorHours;
	}

	public void setMajorHours(Integer majorHours) {
		this.majorHours = majorHours;
	}

	public Integer getMajorCompulsoryHours() {
		return this.majorCompulsoryHours;
	}

	public void setMajorCompulsoryHours(Integer majorCompulsoryHours) {
		this.majorCompulsoryHours = majorCompulsoryHours;
	}

	public Integer getMajorSelectedHours() {
		return this.majorSelectedHours;
	}

	public void setMajorSelectedHours(Integer majorSelectedHours) {
		this.majorSelectedHours = majorSelectedHours;
	}

	public Integer getCourseInnerTeachHours() {
		return this.courseInnerTeachHours;
	}

	public void setCourseInnerTeachHours(Integer courseInnerTeachHours) {
		this.courseInnerTeachHours = courseInnerTeachHours;
	}

	public Integer getPracticeTeachHours() {
		return this.practiceTeachHours;
	}

	public void setPracticeTeachHours(Integer practiceTeachHours) {
		this.practiceTeachHours = practiceTeachHours;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Float getCompulsoryCredit() {
		return this.compulsoryCredit;
	}

	public void setCompulsoryCredit(Float compulsoryCredit) {
		this.compulsoryCredit = compulsoryCredit;
	}

	public Float getSelectedCredit() {
		return this.selectedCredit;
	}

	public void setSelectedCredit(Float selectedCredit) {
		this.selectedCredit = selectedCredit;
	}

	public Float getFocusParcticeCredit() {
		return this.focusParcticeCredit;
	}

	public void setFocusParcticeCredit(Float focusParcticeCredit) {
		this.focusParcticeCredit = focusParcticeCredit;
	}

	public Float getCourseInnerTeachCredit() {
		return this.courseInnerTeachCredit;
	}

	public void setCourseInnerTeachCredit(Float courseInnerTeachCredit) {
		this.courseInnerTeachCredit = courseInnerTeachCredit;
	}

	public Float getPracticeCredit() {
		return this.practiceCredit;
	}

	public void setPracticeCredit(Float practiceCredit) {
		this.practiceCredit = practiceCredit;
	}

	public Float getOuterScienticActivityCredit() {
		return this.outerScienticActivityCredit;
	}

	public void setOuterScienticActivityCredit(Float outerScienticActivityCredit) {
		this.outerScienticActivityCredit = outerScienticActivityCredit;
	}

	public Integer getEnableState() {
		return this.enableState;
	}

	public void setEnableState(Integer enableState) {
		this.enableState = enableState;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getQualitystandards() {
		return this.qualitystandards;
	}

	public void setQualitystandards(Set qualitystandards) {
		this.qualitystandards = qualitystandards;
	}

	public Set getTeachingplanchanges() {
		return this.teachingplanchanges;
	}

	public void setTeachingplanchanges(Set teachingplanchanges) {
		this.teachingplanchanges = teachingplanchanges;
	}

	public Set getAddmissionses() {
		return this.addmissionses;
	}

	public void setAddmissionses(Set addmissionses) {
		this.addmissionses = addmissionses;
	}

	public Set getMajorcourses() {
		return this.majorcourses;
	}

	public void setMajorcourses(Set majorcourses) {
		this.majorcourses = majorcourses;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getCommunicationsitus() {
		return this.communicationsitus;
	}

	public void setCommunicationsitus(Set communicationsitus) {
		this.communicationsitus = communicationsitus;
	}

	public Set getTeachingcosts() {
		return this.teachingcosts;
	}

	public void setTeachingcosts(Set teachingcosts) {
		this.teachingcosts = teachingcosts;
	}

	public Set getTrainingvenueuses() {
		return this.trainingvenueuses;
	}

	public void setTrainingvenueuses(Set trainingvenueuses) {
		this.trainingvenueuses = trainingvenueuses;
	}

	public Set getTrainingvenueuses_1() {
		return this.trainingvenueuses_1;
	}

	public void setTrainingvenueuses_1(Set trainingvenueuses_1) {
		this.trainingvenueuses_1 = trainingvenueuses_1;
	}

	public Set getTeachingcosts_1() {
		return this.teachingcosts_1;
	}

	public void setTeachingcosts_1(Set teachingcosts_1) {
		this.teachingcosts_1 = teachingcosts_1;
	}

	public Set getCurriculumresources() {
		return this.curriculumresources;
	}

	public void setCurriculumresources(Set curriculumresources) {
		this.curriculumresources = curriculumresources;
	}

	public Set getTeachers_1() {
		return this.teachers_1;
	}

	public void setTeachers_1(Set teachers_1) {
		this.teachers_1 = teachers_1;
	}

	public Set getEmployments() {
		return this.employments;
	}

	public void setEmployments(Set employments) {
		this.employments = employments;
	}

	public Set getEffectofqualityeducations() {
		return this.effectofqualityeducations;
	}

	public void setEffectofqualityeducations(Set effectofqualityeducations) {
		this.effectofqualityeducations = effectofqualityeducations;
	}

	public Set getBasevenueuses() {
		return this.basevenueuses;
	}

	public void setBasevenueuses(Set basevenueuses) {
		this.basevenueuses = basevenueuses;
	}

	public Set getFulfillinginstances() {
		return this.fulfillinginstances;
	}

	public void setFulfillinginstances(Set fulfillinginstances) {
		this.fulfillinginstances = fulfillinginstances;
	}

	public Set getCurriculumresources_1() {
		return this.curriculumresources_1;
	}

	public void setCurriculumresources_1(Set curriculumresources_1) {
		this.curriculumresources_1 = curriculumresources_1;
	}

	public Set getFulfillinginstances_1() {
		return this.fulfillinginstances_1;
	}

	public void setFulfillinginstances_1(Set fulfillinginstances_1) {
		this.fulfillinginstances_1 = fulfillinginstances_1;
	}

	public Set getAddmissionses_1() {
		return this.addmissionses_1;
	}

	public void setAddmissionses_1(Set addmissionses_1) {
		this.addmissionses_1 = addmissionses_1;
	}

	public Set getMases() {
		return this.mases;
	}

	public void setMases(Set mases) {
		this.mases = mases;
	}

	public Set getEffectofqualityeducations_1() {
		return this.effectofqualityeducations_1;
	}

	public void setEffectofqualityeducations_1(Set effectofqualityeducations_1) {
		this.effectofqualityeducations_1 = effectofqualityeducations_1;
	}

	public Set getBasevenueuses_1() {
		return this.basevenueuses_1;
	}

	public void setBasevenueuses_1(Set basevenueuses_1) {
		this.basevenueuses_1 = basevenueuses_1;
	}

	public Set getEmployments_1() {
		return this.employments_1;
	}

	public void setEmployments_1(Set employments_1) {
		this.employments_1 = employments_1;
	}

	public Set getStudents_1() {
		return this.students_1;
	}

	public void setStudents_1(Set students_1) {
		this.students_1 = students_1;
	}

	public Set getMases_1() {
		return this.mases_1;
	}

	public void setMases_1(Set mases_1) {
		this.mases_1 = mases_1;
	}

	public Set getTeachingplanchanges_1() {
		return this.teachingplanchanges_1;
	}

	public void setTeachingplanchanges_1(Set teachingplanchanges_1) {
		this.teachingplanchanges_1 = teachingplanchanges_1;
	}

	public Set getQualitystandards_1() {
		return this.qualitystandards_1;
	}

	public void setQualitystandards_1(Set qualitystandards_1) {
		this.qualitystandards_1 = qualitystandards_1;
	}

	public Set getMajorcourses_1() {
		return this.majorcourses_1;
	}

	public void setMajorcourses_1(Set majorcourses_1) {
		this.majorcourses_1 = majorcourses_1;
	}

	public Set getCommunicationsitus_1() {
		return this.communicationsitus_1;
	}

	public void setCommunicationsitus_1(Set communicationsitus_1) {
		this.communicationsitus_1 = communicationsitus_1;
	}
	@Override  
	 public boolean equals(Object obj) {  
	          
	        boolean flag = obj instanceof Major;  
	        if(flag == false){  
	            return false;  
	        }  
	        Major major = (Major)obj;  
	        if(this.getMno().equals(major.getMno())){  
	            return true;  
	        }else {
	            return false;  
	        }  
	}
}