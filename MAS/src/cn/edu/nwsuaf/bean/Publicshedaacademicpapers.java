package cn.edu.nwsuaf.bean;

import java.sql.Timestamp;

/**
 * Publicshedaacademicpapers entity. @author MyEclipse Persistence Tools
 */

public class Publicshedaacademicpapers implements java.io.Serializable {

	// Fields

	private Integer paperNo;
	private Teacher teacher;
	private String paperName;
	private String periodicalInfo;
	private String periodicalType;
	private String year;
	private Float influenceFactors;
	private String beizhu;
	private Integer tag;
	private Timestamp publishedDate;

	// Constructors

	/** default constructor */
	public Publicshedaacademicpapers() {
	}

	/** full constructor */
	public Publicshedaacademicpapers(Teacher teacher, String paperName,
			String periodicalInfo, String periodicalType, String year,
			Float influenceFactors, String beizhu, Integer tag,
			Timestamp publishedDate) {
		this.teacher = teacher;
		this.paperName = paperName;
		this.periodicalInfo = periodicalInfo;
		this.periodicalType = periodicalType;
		this.year = year;
		this.influenceFactors = influenceFactors;
		this.beizhu = beizhu;
		this.tag = tag;
		this.publishedDate = publishedDate;
	}

	// Property accessors

	public Integer getPaperNo() {
		return this.paperNo;
	}

	public void setPaperNo(Integer paperNo) {
		this.paperNo = paperNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getPaperName() {
		return this.paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPeriodicalInfo() {
		return this.periodicalInfo;
	}

	public void setPeriodicalInfo(String periodicalInfo) {
		this.periodicalInfo = periodicalInfo;
	}

	public String getPeriodicalType() {
		return this.periodicalType;
	}

	public void setPeriodicalType(String periodicalType) {
		this.periodicalType = periodicalType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Float getInfluenceFactors() {
		return this.influenceFactors;
	}

	public void setInfluenceFactors(Float influenceFactors) {
		this.influenceFactors = influenceFactors;
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

	public Timestamp getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}

}