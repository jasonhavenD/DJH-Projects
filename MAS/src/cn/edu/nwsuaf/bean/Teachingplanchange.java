package cn.edu.nwsuaf.bean;

import java.util.Date;

/**
 * Teachingplanchange entity. @author MyEclipse Persistence Tools
 */

public class Teachingplanchange implements java.io.Serializable {

	// Fields

	private Integer teachPlanChaneId;
	private Major major;
	private Course course;
	private String grade;
	private String courseNature;
	private String changeType;
	private String changeMode;
	private String changeReason;
	private String changeContext;
	private Date changeDate;
	private String year;
	private Integer adjustNature;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Teachingplanchange() {
	}

	/** full constructor */
	public Teachingplanchange(Major major, Course course, String grade,
			String courseNature, String changeType, String changeMode,
			String changeReason, String changeContext, Date changeDate,
			String year, Integer adjustNature, Integer tag) {
		this.major = major;
		this.course = course;
		this.grade = grade;
		this.courseNature = courseNature;
		this.changeType = changeType;
		this.changeMode = changeMode;
		this.changeReason = changeReason;
		this.changeContext = changeContext;
		this.changeDate = changeDate;
		this.year = year;
		this.adjustNature = adjustNature;
		this.tag = tag;
	}

	// Property accessors

	public Integer getTeachPlanChaneId() {
		return this.teachPlanChaneId;
	}

	public void setTeachPlanChaneId(Integer teachPlanChaneId) {
		this.teachPlanChaneId = teachPlanChaneId;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseNature() {
		return this.courseNature;
	}

	public void setCourseNature(String courseNature) {
		this.courseNature = courseNature;
	}

	public String getChangeType() {
		return this.changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getChangeMode() {
		return this.changeMode;
	}

	public void setChangeMode(String changeMode) {
		this.changeMode = changeMode;
	}

	public String getChangeReason() {
		return this.changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getChangeContext() {
		return this.changeContext;
	}

	public void setChangeContext(String changeContext) {
		this.changeContext = changeContext;
	}

	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getAdjustNature() {
		return this.adjustNature;
	}

	public void setAdjustNature(Integer adjustNature) {
		this.adjustNature = adjustNature;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}