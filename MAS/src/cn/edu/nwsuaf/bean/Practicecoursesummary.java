package cn.edu.nwsuaf.bean;

/**
 * Practicecoursesummary entity. @author MyEclipse Persistence Tools
 */

public class Practicecoursesummary implements java.io.Serializable {

	// Fields

	private Integer id;
	private Major major;
	private String year;
	private Integer planChangeNumber;
	private Integer professorTeachTime;
	private Integer inprofessorTteachTime;
	private Integer teachTotalTime;
	private Float totalTeachCost;
	private Integer courseTotaoNum;
	private Integer openCourseTotaoNum;
	private Integer goodCourseTotaoNum;
	private Integer practiceBaseTotalNum;
	private Integer studentPersistProjectNum;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Practicecoursesummary() {
	}

	/** full constructor */
	public Practicecoursesummary(Major major, String year,
			Integer planChangeNumber, Integer professorTeachTime,
			Integer inprofessorTteachTime, Integer teachTotalTime,
			Float totalTeachCost, Integer courseTotaoNum,
			Integer openCourseTotaoNum, Integer goodCourseTotaoNum,
			Integer practiceBaseTotalNum, Integer studentPersistProjectNum,
			Integer tag) {
		this.major = major;
		this.year = year;
		this.planChangeNumber = planChangeNumber;
		this.professorTeachTime = professorTeachTime;
		this.inprofessorTteachTime = inprofessorTteachTime;
		this.teachTotalTime = teachTotalTime;
		this.totalTeachCost = totalTeachCost;
		this.courseTotaoNum = courseTotaoNum;
		this.openCourseTotaoNum = openCourseTotaoNum;
		this.goodCourseTotaoNum = goodCourseTotaoNum;
		this.practiceBaseTotalNum = practiceBaseTotalNum;
		this.studentPersistProjectNum = studentPersistProjectNum;
		this.tag = tag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getPlanChangeNumber() {
		return this.planChangeNumber;
	}

	public void setPlanChangeNumber(Integer planChangeNumber) {
		this.planChangeNumber = planChangeNumber;
	}

	public Integer getProfessorTeachTime() {
		return this.professorTeachTime;
	}

	public void setProfessorTeachTime(Integer professorTeachTime) {
		this.professorTeachTime = professorTeachTime;
	}

	public Integer getInprofessorTteachTime() {
		return this.inprofessorTteachTime;
	}

	public void setInprofessorTteachTime(Integer inprofessorTteachTime) {
		this.inprofessorTteachTime = inprofessorTteachTime;
	}

	public Integer getTeachTotalTime() {
		return this.teachTotalTime;
	}

	public void setTeachTotalTime(Integer teachTotalTime) {
		this.teachTotalTime = teachTotalTime;
	}

	public Float getTotalTeachCost() {
		return this.totalTeachCost;
	}

	public void setTotalTeachCost(Float totalTeachCost) {
		this.totalTeachCost = totalTeachCost;
	}

	public Integer getCourseTotaoNum() {
		return this.courseTotaoNum;
	}

	public void setCourseTotaoNum(Integer courseTotaoNum) {
		this.courseTotaoNum = courseTotaoNum;
	}

	public Integer getOpenCourseTotaoNum() {
		return this.openCourseTotaoNum;
	}

	public void setOpenCourseTotaoNum(Integer openCourseTotaoNum) {
		this.openCourseTotaoNum = openCourseTotaoNum;
	}

	public Integer getGoodCourseTotaoNum() {
		return this.goodCourseTotaoNum;
	}

	public void setGoodCourseTotaoNum(Integer goodCourseTotaoNum) {
		this.goodCourseTotaoNum = goodCourseTotaoNum;
	}

	public Integer getPracticeBaseTotalNum() {
		return this.practiceBaseTotalNum;
	}

	public void setPracticeBaseTotalNum(Integer practiceBaseTotalNum) {
		this.practiceBaseTotalNum = practiceBaseTotalNum;
	}

	public Integer getStudentPersistProjectNum() {
		return this.studentPersistProjectNum;
	}

	public void setStudentPersistProjectNum(Integer studentPersistProjectNum) {
		this.studentPersistProjectNum = studentPersistProjectNum;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}