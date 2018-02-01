package cn.edu.nwsuaf.bean;

import java.util.Date;

/**
 * Presidedoverrevolutionresearchproject entity. @author MyEclipse Persistence
 * Tools
 */

public class Presidedoverrevolutionresearchproject implements
		java.io.Serializable {

	// Fields

	private String rprojectNo;
	private Teacher teacher;
	private String rprojectName;
	private String rprojecJibie;
	private String rprojecType;
	private String year;
	private Date rprojecTime;
	private Date racceptenceDate;
	private Float rcost;
	private Integer rpartTeacherNum;
	private String beizhu;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Presidedoverrevolutionresearchproject() {
	}

	/** minimal constructor */
	public Presidedoverrevolutionresearchproject(String rprojectNo) {
		this.rprojectNo = rprojectNo;
	}

	/** full constructor */
	public Presidedoverrevolutionresearchproject(String rprojectNo,
			Teacher teacher, String rprojectName, String rprojecJibie,
			String rprojecType, String year, Date rprojecTime,
			Date racceptenceDate, Float rcost, Integer rpartTeacherNum,
			String beizhu, Integer tag) {
		this.rprojectNo = rprojectNo;
		this.teacher = teacher;
		this.rprojectName = rprojectName;
		this.rprojecJibie = rprojecJibie;
		this.rprojecType = rprojecType;
		this.year = year;
		this.rprojecTime = rprojecTime;
		this.racceptenceDate = racceptenceDate;
		this.rcost = rcost;
		this.rpartTeacherNum = rpartTeacherNum;
		this.beizhu = beizhu;
		this.tag = tag;
	}

	// Property accessors

	public String getRprojectNo() {
		return this.rprojectNo;
	}

	public void setRprojectNo(String rprojectNo) {
		this.rprojectNo = rprojectNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getRprojectName() {
		return this.rprojectName;
	}

	public void setRprojectName(String rprojectName) {
		this.rprojectName = rprojectName;
	}

	public String getRprojecJibie() {
		return this.rprojecJibie;
	}

	public void setRprojecJibie(String rprojecJibie) {
		this.rprojecJibie = rprojecJibie;
	}

	public String getRprojecType() {
		return this.rprojecType;
	}

	public void setRprojecType(String rprojecType) {
		this.rprojecType = rprojecType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getRprojecTime() {
		return this.rprojecTime;
	}

	public void setRprojecTime(Date rprojecTime) {
		this.rprojecTime = rprojecTime;
	}

	public Date getRacceptenceDate() {
		return this.racceptenceDate;
	}

	public void setRacceptenceDate(Date racceptenceDate) {
		this.racceptenceDate = racceptenceDate;
	}

	public Float getRcost() {
		return this.rcost;
	}

	public void setRcost(Float rcost) {
		this.rcost = rcost;
	}

	public Integer getRpartTeacherNum() {
		return this.rpartTeacherNum;
	}

	public void setRpartTeacherNum(Integer rpartTeacherNum) {
		this.rpartTeacherNum = rpartTeacherNum;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}