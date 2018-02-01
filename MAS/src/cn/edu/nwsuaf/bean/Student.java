package cn.edu.nwsuaf.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String stuNumber;
	private Major major;
	private National national;
	private String stuName;
	private Date birth;
	private String sex;
	private String class_;
	private String grade;
	private String year;
	private Date graduationDate;
	private Integer eductionalSystme;
	private String isRoll;
	private String isInSchool;
	private String status;
	private Integer tag;
	private Set innovationmembers = new HashSet(0);
	private Set stuthesises = new HashSet(0);
	private Set stupatents = new HashSet(0);
	private Set studentcoepetitions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	/** full constructor */
	public Student(String stuNumber, Major major, National national,
			String stuName, Date birth, String sex, String class_,
			String grade, String year, Date graduationDate,
			Integer eductionalSystme, String isRoll, String isInSchool,
			String status, Integer tag, Set innovationmembers, Set stuthesises,
			Set stupatents, Set studentcoepetitions) {
		this.stuNumber = stuNumber;
		this.major = major;
		this.national = national;
		this.stuName = stuName;
		this.birth = birth;
		this.sex = sex;
		this.class_ = class_;
		this.grade = grade;
		this.year = year;
		this.graduationDate = graduationDate;
		this.eductionalSystme = eductionalSystme;
		this.isRoll = isRoll;
		this.isInSchool = isInSchool;
		this.status = status;
		this.tag = tag;
		this.innovationmembers = innovationmembers;
		this.stuthesises = stuthesises;
		this.stupatents = stupatents;
		this.studentcoepetitions = studentcoepetitions;
	}

	// Property accessors

	public String getStuNumber() {
		return this.stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public National getNational() {
		return this.national;
	}

	public void setNational(National national) {
		this.national = national;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Integer getEductionalSystme() {
		return this.eductionalSystme;
	}

	public void setEductionalSystme(Integer eductionalSystme) {
		this.eductionalSystme = eductionalSystme;
	}

	public String getIsRoll() {
		return this.isRoll;
	}

	public void setIsRoll(String isRoll) {
		this.isRoll = isRoll;
	}

	public String getIsInSchool() {
		return this.isInSchool;
	}

	public void setIsInSchool(String isInSchool) {
		this.isInSchool = isInSchool;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getInnovationmembers() {
		return this.innovationmembers;
	}

	public void setInnovationmembers(Set innovationmembers) {
		this.innovationmembers = innovationmembers;
	}

	public Set getStuthesises() {
		return this.stuthesises;
	}

	public void setStuthesises(Set stuthesises) {
		this.stuthesises = stuthesises;
	}

	public Set getStupatents() {
		return this.stupatents;
	}

	public void setStupatents(Set stupatents) {
		this.stupatents = stupatents;
	}

	public Set getStudentcoepetitions() {
		return this.studentcoepetitions;
	}

	public void setStudentcoepetitions(Set studentcoepetitions) {
		this.studentcoepetitions = studentcoepetitions;
	}

}