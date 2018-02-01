package cn.edu.nwsuaf.bean;

/**
 * Teacherinfosummary entity. @author MyEclipse Persistence Tools
 */

public class Teacherinfosummary implements java.io.Serializable {

	// Fields

	private Integer id;
	private Major major;
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
	public Teacherinfosummary() {
	}

	/** full constructor */
	public Teacherinfosummary(Major major, String year, Integer facultyNumber,
			Integer stuNumber, Integer professionaTteacherNumbers,
			Float studentsTeachersRatio, Integer doctorNumber,
			Integer professorNuber, Integer associateProfessorNumber,
			Integer talentnuber1, Integer talentnuber2, Integer talentnuber3,
			Integer industryExperienceNumber, Integer youngTeacherNumber,
			Integer trainTeacherNumber, Integer tag) {
		this.major = major;
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

	public Integer getFacultyNumber() {
		return this.facultyNumber;
	}

	public void setFacultyNumber(Integer facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public Integer getStuNumber() {
		return this.stuNumber;
	}

	public void setStuNumber(Integer stuNumber) {
		this.stuNumber = stuNumber;
	}

	public Integer getProfessionaTteacherNumbers() {
		return this.professionaTteacherNumbers;
	}

	public void setProfessionaTteacherNumbers(Integer professionaTteacherNumbers) {
		this.professionaTteacherNumbers = professionaTteacherNumbers;
	}

	public Float getStudentsTeachersRatio() {
		return this.studentsTeachersRatio;
	}

	public void setStudentsTeachersRatio(Float studentsTeachersRatio) {
		this.studentsTeachersRatio = studentsTeachersRatio;
	}

	public Integer getDoctorNumber() {
		return this.doctorNumber;
	}

	public void setDoctorNumber(Integer doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Integer getProfessorNuber() {
		return this.professorNuber;
	}

	public void setProfessorNuber(Integer professorNuber) {
		this.professorNuber = professorNuber;
	}

	public Integer getAssociateProfessorNumber() {
		return this.associateProfessorNumber;
	}

	public void setAssociateProfessorNumber(Integer associateProfessorNumber) {
		this.associateProfessorNumber = associateProfessorNumber;
	}

	public Integer getTalentnuber1() {
		return this.talentnuber1;
	}

	public void setTalentnuber1(Integer talentnuber1) {
		this.talentnuber1 = talentnuber1;
	}

	public Integer getTalentnuber2() {
		return this.talentnuber2;
	}

	public void setTalentnuber2(Integer talentnuber2) {
		this.talentnuber2 = talentnuber2;
	}

	public Integer getTalentnuber3() {
		return this.talentnuber3;
	}

	public void setTalentnuber3(Integer talentnuber3) {
		this.talentnuber3 = talentnuber3;
	}

	public Integer getIndustryExperienceNumber() {
		return this.industryExperienceNumber;
	}

	public void setIndustryExperienceNumber(Integer industryExperienceNumber) {
		this.industryExperienceNumber = industryExperienceNumber;
	}

	public Integer getYoungTeacherNumber() {
		return this.youngTeacherNumber;
	}

	public void setYoungTeacherNumber(Integer youngTeacherNumber) {
		this.youngTeacherNumber = youngTeacherNumber;
	}

	public Integer getTrainTeacherNumber() {
		return this.trainTeacherNumber;
	}

	public void setTrainTeacherNumber(Integer trainTeacherNumber) {
		this.trainTeacherNumber = trainTeacherNumber;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}