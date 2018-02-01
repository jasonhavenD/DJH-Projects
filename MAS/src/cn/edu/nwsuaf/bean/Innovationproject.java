package cn.edu.nwsuaf.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Innovationproject entity. @author MyEclipse Persistence Tools
 */

public class Innovationproject implements java.io.Serializable {

	// Fields

	private String innoNumber;
	private String innoName;
	private String level;
	private String type;
	private String year;
	private String cost;
	private Date setDate;
	private Date endDate;
	private String assessment;
	private String note;
	private Integer tag;
	private Set innovationmembers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Innovationproject() {
	}

	/** minimal constructor */
	public Innovationproject(String innoNumber) {
		this.innoNumber = innoNumber;
	}

	/** full constructor */
	public Innovationproject(String innoNumber, String innoName, String level,
			String type, String year, String cost, Date setDate, Date endDate,
			String assessment, String note, Integer tag, Set innovationmembers) {
		this.innoNumber = innoNumber;
		this.innoName = innoName;
		this.level = level;
		this.type = type;
		this.year = year;
		this.cost = cost;
		this.setDate = setDate;
		this.endDate = endDate;
		this.assessment = assessment;
		this.note = note;
		this.tag = tag;
		this.innovationmembers = innovationmembers;
	}

	// Property accessors

	public String getInnoNumber() {
		return this.innoNumber;
	}

	public void setInnoNumber(String innoNumber) {
		this.innoNumber = innoNumber;
	}

	public String getInnoName() {
		return this.innoName;
	}

	public void setInnoName(String innoName) {
		this.innoName = innoName;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Date getSetDate() {
		return this.setDate;
	}

	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAssessment() {
		return this.assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

}