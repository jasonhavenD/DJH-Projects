package cn.edu.nwsuaf.view;

/**
 * PracticecourseView entity. @author MyEclipse Persistence Tools
 */

public class PracticecourseView implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mno;
	private String year;
	private Integer planChangeNumber;
	private Integer professorTeachTime;
	private Integer inprofessorTteachTime;
	private Integer teachTotalTime;
	private Double totalTeachCost;
	private Integer courseTotaoNum;
	private Integer openCourseTotaoNum;
	private Integer goodCourseTotaoNum;
	private Integer practiceBaseTotalNum;
	private Integer studentPersistProjectNum;

	// Constructors

	/** default constructor */
	public PracticecourseView() {
	}

	public PracticecourseView(Integer id, String mno, String year,
			Integer planChangeNumber, Integer professorTeachTime,
			Integer inprofessorTteachTime, Integer teachTotalTime,
			Double totalTeachCost, Integer courseTotaoNum, Integer openCourseTotaoNum,
			Integer goodCourseTotaoNum, Integer practiceBaseTotalNum,
			Integer studentPersistProjectNum) {
		super();
		this.id = id;
		this.mno = mno;
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
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getPlanChangeNumber() {
		return planChangeNumber;
	}

	public void setPlanChangeNumber(Integer planChangeNumber) {
		this.planChangeNumber = planChangeNumber;
	}

	public Integer getProfessorTeachTime() {
		return professorTeachTime;
	}

	public void setProfessorTeachTime(Integer professorTeachTime) {
		this.professorTeachTime = professorTeachTime;
	}

	public Integer getInprofessorTteachTime() {
		return inprofessorTteachTime;
	}

	public void setInprofessorTteachTime(Integer inprofessorTteachTime) {
		this.inprofessorTteachTime = inprofessorTteachTime;
	}

	public Integer getTeachTotalTime() {
		return teachTotalTime;
	}

	public void setTeachTotalTime(Integer teachTotalTime) {
		this.teachTotalTime = teachTotalTime;
	}

	public double getTotalTeachCost() {
		return totalTeachCost;
	}

	public void setTotalTeachCost(Double totalTeachCost) {
		this.totalTeachCost = totalTeachCost;
	}

	public Integer getCourseTotaoNum() {
		return courseTotaoNum;
	}

	public void setCourseTotaoNum(Integer courseTotaoNum) {
		this.courseTotaoNum = courseTotaoNum;
	}

	public Integer getOpenCourseTotaoNum() {
		return openCourseTotaoNum;
	}

	public void setOpenCourseTotaoNum(Integer openCourseTotaoNum) {
		this.openCourseTotaoNum = openCourseTotaoNum;
	}

	public Integer getGoodCourseTotaoNum() {
		return goodCourseTotaoNum;
	}

	public void setGoodCourseTotaoNum(Integer goodCourseTotaoNum) {
		this.goodCourseTotaoNum = goodCourseTotaoNum;
	}

	public Integer getPracticeBaseTotalNum() {
		return practiceBaseTotalNum;
	}

	public void setPracticeBaseTotalNum(Integer practiceBaseTotalNum) {
		this.practiceBaseTotalNum = practiceBaseTotalNum;
	}

	public Integer getStudentPersistProjectNum() {
		return studentPersistProjectNum;
	}

	public void setStudentPersistProjectNum(Integer studentPersistProjectNum) {
		this.studentPersistProjectNum = studentPersistProjectNum;
	}
	
	
	
	

}