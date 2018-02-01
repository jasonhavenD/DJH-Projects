package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String cno;
	private Department department;
	private String cname;
	private String ctype;
	private String isDoubleLanguageTeach;
	private String testMode;
	private Integer courseHours;
	private Float credit;
	private String version;
	private Integer tag;
	private Set teachingplanchanges = new HashSet(0);
	private Set majorcourses = new HashSet(0);
	private Set majorcourses_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cno) {
		this.cno = cno;
	}

	/** full constructor */
	public Course(String cno, Department department, String cname,
			String ctype, String isDoubleLanguageTeach, String testMode,
			Integer courseHours, Float credit, String version, Integer tag,
			Set teachingplanchanges, Set majorcourses, Set majorcourses_1) {
		this.cno = cno;
		this.department = department;
		this.cname = cname;
		this.ctype = ctype;
		this.isDoubleLanguageTeach = isDoubleLanguageTeach;
		this.testMode = testMode;
		this.courseHours = courseHours;
		this.credit = credit;
		this.version = version;
		this.tag = tag;
		this.teachingplanchanges = teachingplanchanges;
		this.majorcourses = majorcourses;
		this.majorcourses_1 = majorcourses_1;
	}

	// Property accessors

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getIsDoubleLanguageTeach() {
		return this.isDoubleLanguageTeach;
	}

	public void setIsDoubleLanguageTeach(String isDoubleLanguageTeach) {
		this.isDoubleLanguageTeach = isDoubleLanguageTeach;
	}

	public String getTestMode() {
		return this.testMode;
	}

	public void setTestMode(String testMode) {
		this.testMode = testMode;
	}

	public Integer getCourseHours() {
		return this.courseHours;
	}

	public void setCourseHours(Integer courseHours) {
		this.courseHours = courseHours;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getTeachingplanchanges() {
		return this.teachingplanchanges;
	}

	public void setTeachingplanchanges(Set teachingplanchanges) {
		this.teachingplanchanges = teachingplanchanges;
	}

	public Set getMajorcourses() {
		return this.majorcourses;
	}

	public void setMajorcourses(Set majorcourses) {
		this.majorcourses = majorcourses;
	}

	public Set getMajorcourses_1() {
		return this.majorcourses_1;
	}

	public void setMajorcourses_1(Set majorcourses_1) {
		this.majorcourses_1 = majorcourses_1;
	}

}