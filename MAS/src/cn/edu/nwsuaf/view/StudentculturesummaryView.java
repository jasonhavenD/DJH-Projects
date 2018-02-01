package cn.edu.nwsuaf.view;

import java.math.BigDecimal;

/**
 * StudentculturesummaryView entity. @author MyEclipse Persistence Tools
 */

public class StudentculturesummaryView implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mno;
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
	private Double firstVolunteerRate;
	private Double popularityRate;
	private Double initialemploymentrate;
	private Double employmentrate;
	private Integer exchangeprojects;
	private Integer exchangepeople;

	// Constructors

	/** default constructor */
	public StudentculturesummaryView() {
	}

	public StudentculturesummaryView(Integer id, String mno, String year,
			Integer studentNumber, Integer researchPaperNumber, Integer patentNumber,
			Integer raceNumber1, Integer raceNumber2, Integer raceNumber3,
			Integer studentInnovationNumber11, Integer studentInnovationNumber12,
			Integer studentInnovationNumber13, Double firstVolunteerRate,
			Double popularityRate, Double initialemploymentrate,
			Double employmentrate, Integer exchangeprojects, Integer exchangepeople) {
		super();
		this.id = id;
		this.mno = mno;
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

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Integer getResearchPaperNumber() {
		return researchPaperNumber;
	}

	public void setResearchPaperNumber(Integer researchPaperNumber) {
		this.researchPaperNumber = researchPaperNumber;
	}

	public Integer getPatentNumber() {
		return patentNumber;
	}

	public void setPatentNumber(Integer patentNumber) {
		this.patentNumber = patentNumber;
	}

	public Integer getRaceNumber1() {
		return raceNumber1;
	}

	public void setRaceNumber1(Integer raceNumber1) {
		this.raceNumber1 = raceNumber1;
	}

	public Integer getRaceNumber2() {
		return raceNumber2;
	}

	public void setRaceNumber2(Integer raceNumber2) {
		this.raceNumber2 = raceNumber2;
	}

	public Integer getRaceNumber3() {
		return raceNumber3;
	}

	public void setRaceNumber3(Integer raceNumber3) {
		this.raceNumber3 = raceNumber3;
	}

	public Integer getStudentInnovationNumber11() {
		return studentInnovationNumber11;
	}

	public void setStudentInnovationNumber11(Integer studentInnovationNumber11) {
		this.studentInnovationNumber11 = studentInnovationNumber11;
	}

	public Integer getStudentInnovationNumber12() {
		return studentInnovationNumber12;
	}

	public void setStudentInnovationNumber12(Integer studentInnovationNumber12) {
		this.studentInnovationNumber12 = studentInnovationNumber12;
	}

	public Integer getStudentInnovationNumber13() {
		return studentInnovationNumber13;
	}

	public void setStudentInnovationNumber13(Integer studentInnovationNumber13) {
		this.studentInnovationNumber13 = studentInnovationNumber13;
	}

	public Double getFirstVolunteerRate() {
		return firstVolunteerRate;
	}

	public void setFirstVolunteerRate(Double firstVolunteerRate) {
		this.firstVolunteerRate = firstVolunteerRate;
	}

	public Double getPopularityRate() {
		return popularityRate;
	}

	public void setPopularityRate(Double popularityRate) {
		this.popularityRate = popularityRate;
	}

	public Double getInitialemploymentrate() {
		return initialemploymentrate;
	}

	public void setInitialemploymentrate(Double initialemploymentrate) {
		this.initialemploymentrate = initialemploymentrate;
	}

	public Double getEmploymentrate() {
		return employmentrate;
	}

	public void setEmploymentrate(Double employmentrate) {
		this.employmentrate = employmentrate;
	}

	public Integer getExchangeprojects() {
		return exchangeprojects;
	}

	public void setExchangeprojects(Integer exchangeprojects) {
		this.exchangeprojects = exchangeprojects;
	}

	public Integer getExchangepeople() {
		return exchangepeople;
	}

	public void setExchangepeople(Integer exchangepeople) {
		this.exchangepeople = exchangepeople;
	}

	
	

}