package cn.edu.nwsuaf.view;

/**
 * TeacherinfolastView entity. @author MyEclipse Persistence Tools
 */

public class TeacherinfolastView implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mno;
	private String year;
	private Integer facultyNumber;
	private Integer stuNumber;
	private Integer professionaTteacherNumbers;
	private Float studentsTeachersRatio;
	private Integer doctorNumber;
	private Integer professorNuber;
	private Integer associateProfessorNumber;
	private Integer talentnuber1;
	private Integer talentnuber2;
	private Integer talentnuber3;
	private Integer industryExperienceNumber;
	private Integer youngTeacherNumber;
	private Integer trainTeacherNumber;
	private Integer tag;

	// Constructors

	/** default constructor */
	public TeacherinfolastView() {
	}

	public TeacherinfolastView(Integer id, String mno, String year,
			Integer facultyNumber, Integer stuNumber,
			Integer professionaTteacherNumbers, Float studentsTeachersRatio,
			Integer doctorNumber, Integer professorNuber,
			Integer associateProfessorNumber, Integer talentnuber1,
			Integer talentnuber2, Integer talentnuber3,
			Integer industryExperienceNumber, Integer youngTeacherNumber,
			Integer trainTeacherNumber, Integer tag) {
		super();
		this.id = id;
		this.mno = mno;
		this.year = year;
		this.facultyNumber = facultyNumber;
		this.stuNumber = stuNumber;
		this.professionaTteacherNumbers = professionaTteacherNumbers;
		this.studentsTeachersRatio = studentsTeachersRatio;
		this.doctorNumber = doctorNumber;
		this.professorNuber = professorNuber;
		this.associateProfessorNumber = associateProfessorNumber;
		this.talentnuber1 = talentnuber1;
		this.talentnuber2 = talentnuber2;
		this.talentnuber3 = talentnuber3;
		this.industryExperienceNumber = industryExperienceNumber;
		this.youngTeacherNumber = youngTeacherNumber;
		this.trainTeacherNumber = trainTeacherNumber;
		this.tag = tag;
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

	public Integer getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(Integer facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public Integer getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(Integer stuNumber) {
		this.stuNumber = stuNumber;
	}

	public Integer getProfessionaTteacherNumbers() {
		return professionaTteacherNumbers;
	}

	public void setProfessionaTteacherNumbers(Integer professionaTteacherNumbers) {
		this.professionaTteacherNumbers = professionaTteacherNumbers;
	}

	public Float getStudentsTeachersRatio() {
		return studentsTeachersRatio;
	}

	public void setStudentsTeachersRatio(Float studentsTeachersRatio) {
		this.studentsTeachersRatio = studentsTeachersRatio;
	}

	public Integer getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(Integer doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Integer getProfessorNuber() {
		return professorNuber;
	}

	public void setProfessorNuber(Integer professorNuber) {
		this.professorNuber = professorNuber;
	}

	public Integer getAssociateProfessorNumber() {
		return associateProfessorNumber;
	}

	public void setAssociateProfessorNumber(Integer associateProfessorNumber) {
		this.associateProfessorNumber = associateProfessorNumber;
	}

	public Integer getTalentnuber1() {
		return talentnuber1;
	}

	public void setTalentnuber1(Integer talentnuber1) {
		this.talentnuber1 = talentnuber1;
	}

	public Integer getTalentnuber2() {
		return talentnuber2;
	}

	public void setTalentnuber2(Integer talentnuber2) {
		this.talentnuber2 = talentnuber2;
	}

	public Integer getTalentnuber3() {
		return talentnuber3;
	}

	public void setTalentnuber3(Integer talentnuber3) {
		this.talentnuber3 = talentnuber3;
	}

	public Integer getIndustryExperienceNumber() {
		return industryExperienceNumber;
	}

	public void setIndustryExperienceNumber(Integer industryExperienceNumber) {
		this.industryExperienceNumber = industryExperienceNumber;
	}

	public Integer getYoungTeacherNumber() {
		return youngTeacherNumber;
	}

	public void setYoungTeacherNumber(Integer youngTeacherNumber) {
		this.youngTeacherNumber = youngTeacherNumber;
	}

	public Integer getTrainTeacherNumber() {
		return trainTeacherNumber;
	}

	public void setTrainTeacherNumber(Integer trainTeacherNumber) {
		this.trainTeacherNumber = trainTeacherNumber;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	

}