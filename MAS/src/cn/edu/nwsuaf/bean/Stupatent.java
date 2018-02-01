package cn.edu.nwsuaf.bean;

import java.util.Date;

/**
 * Stupatent entity. @author MyEclipse Persistence Tools
 */

public class Stupatent implements java.io.Serializable {

	// Fields

	public Integer pnumber;
	private Student student;
	private String pateName;
	private String patentNumber;
	private String year;
	private Date authorityDate;
	private String pateType;
	private String certiNumber;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Stupatent() {
	}

	/** full constructor */
	public Stupatent(Student student, String pateName, String patentNumber,
			String year, Date authorityDate, String pateType,
			String certiNumber, String note, Integer tag) {
		this.student = student;
		this.pateName = pateName;
		this.patentNumber = patentNumber;
		this.year = year;
		this.authorityDate = authorityDate;
		this.pateType = pateType;
		this.certiNumber = certiNumber;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPateName() {
		return this.pateName;
	}

	public void setPateName(String pateName) {
		this.pateName = pateName;
	}

	public String getPatentNumber() {
		return this.patentNumber;
	}

	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getAuthorityDate() {
		return this.authorityDate;
	}

	public void setAuthorityDate(Date authorityDate) {
		this.authorityDate = authorityDate;
	}

	public String getPateType() {
		return this.pateType;
	}

	public void setPateType(String pateType) {
		this.pateType = pateType;
	}

	public String getCertiNumber() {
		return this.certiNumber;
	}

	public void setCertiNumber(String certiNumber) {
		this.certiNumber = certiNumber;
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

}