package cn.edu.nwsuaf.bean;

/**
 * Studentculturesummary entity. @author MyEclipse Persistence Tools
 */

public class Studentculturesummary implements java.io.Serializable {

	// Fields

	private Integer id;
	private Major major;
	private String year;
	private Integer studentNumber;
	private Integer researchPaperNumber;
	private Integer patentNumber;
	private Integer raceNumber1;
	private Integer raceNumber2;
	private Integer raceNumber3;
	private Integer studentInnovationNumber11;
	private Integer studentInnovationNumber12;
	private Integer studentInnovationNumber13;
	private Float firstVolunteerRate;
	private Float popularityRate;
	private Float initialemploymentrate;
	private Float employmentrate;
	private Integer exchangeprojects;
	private Integer exchangepeople;
	private String beizhu;

	// Constructors

	/** default constructor */
	public Studentculturesummary() {
	}

	/** full constructor */
	public Studentculturesummary(Major major, String year,
			Integer studentNumber, Integer researchPaperNumber,
			Integer patentNumber, Integer raceNumber1, Integer raceNumber2,
			Integer raceNumber3, Integer studentInnovationNumber11,
			Integer studentInnovationNumber12,
			Integer studentInnovationNumber13, Float firstVolunteerRate,
			Float popularityRate, Float initialemploymentrate,
			Float employmentrate, Integer exchangeprojects,
			Integer exchangepeople, String beizhu) {
		this.major = major;
		this.year = year;
		this.studentNumber = studentNumber;
		this.researchPaperNumber = researchPaperNumber;
		this.patentNumber = patentNumber;
		this.raceNumber1 = raceNumber1;
		this.raceNumber2 = raceNumber2;
		this.raceNumber3 = raceNumber3;
		this.studentInnovationNumber11 = studentInnovationNumber11;
		this.studentInnovationNumber12 = studentInnovationNumber12;
		this.studentInnovationNumber13 = studentInnovationNumber13;
		this.firstVolunteerRate = firstVolunteerRate;
		this.popularityRate = popularityRate;
		this.initialemploymentrate = initialemploymentrate;
		this.employmentrate = employmentrate;
		this.exchangeprojects = exchangeprojects;
		this.exchangepeople = exchangepeople;
		this.beizhu = beizhu;
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

	public Integer getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Integer getResearchPaperNumber() {
		return this.researchPaperNumber;
	}

	public void setResearchPaperNumber(Integer researchPaperNumber) {
		this.researchPaperNumber = researchPaperNumber;
	}

	public Integer getPatentNumber() {
		return this.patentNumber;
	}

	public void setPatentNumber(Integer patentNumber) {
		this.patentNumber = patentNumber;
	}

	public Integer getRaceNumber1() {
		return this.raceNumber1;
	}

	public void setRaceNumber1(Integer raceNumber1) {
		this.raceNumber1 = raceNumber1;
	}

	public Integer getRaceNumber2() {
		return this.raceNumber2;
	}

	public void setRaceNumber2(Integer raceNumber2) {
		this.raceNumber2 = raceNumber2;
	}

	public Integer getRaceNumber3() {
		return this.raceNumber3;
	}

	public void setRaceNumber3(Integer raceNumber3) {
		this.raceNumber3 = raceNumber3;
	}

	public Integer getStudentInnovationNumber11() {
		return this.studentInnovationNumber11;
	}

	public void setStudentInnovationNumber11(Integer studentInnovationNumber11) {
		this.studentInnovationNumber11 = studentInnovationNumber11;
	}

	public Integer getStudentInnovationNumber12() {
		return this.studentInnovationNumber12;
	}

	public void setStudentInnovationNumber12(Integer studentInnovationNumber12) {
		this.studentInnovationNumber12 = studentInnovationNumber12;
	}

	public Integer getStudentInnovationNumber13() {
		return this.studentInnovationNumber13;
	}

	public void setStudentInnovationNumber13(Integer studentInnovationNumber13) {
		this.studentInnovationNumber13 = studentInnovationNumber13;
	}

	public Float getFirstVolunteerRate() {
		return this.firstVolunteerRate;
	}

	public void setFirstVolunteerRate(Float firstVolunteerRate) {
		this.firstVolunteerRate = firstVolunteerRate;
	}

	public Float getPopularityRate() {
		return this.popularityRate;
	}

	public void setPopularityRate(Float popularityRate) {
		this.popularityRate = popularityRate;
	}

	public Float getInitialemploymentrate() {
		return this.initialemploymentrate;
	}

	public void setInitialemploymentrate(Float initialemploymentrate) {
		this.initialemploymentrate = initialemploymentrate;
	}

	public Float getEmploymentrate() {
		return this.employmentrate;
	}

	public void setEmploymentrate(Float employmentrate) {
		this.employmentrate = employmentrate;
	}

	public Integer getExchangeprojects() {
		return this.exchangeprojects;
	}

	public void setExchangeprojects(Integer exchangeprojects) {
		this.exchangeprojects = exchangeprojects;
	}

	public Integer getExchangepeople() {
		return this.exchangepeople;
	}

	public void setExchangepeople(Integer exchangepeople) {
		this.exchangepeople = exchangepeople;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}