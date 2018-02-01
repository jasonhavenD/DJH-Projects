package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Competition entity. @author MyEclipse Persistence Tools
 */

public class Competition implements java.io.Serializable {

	// Fields

	private Integer comNumber;
	private String comName;
	private String comType;
	private String comRank;
	private String year;
	private String note;
	private Integer tag;
	private String comYear;
	private Set studentcoepetitions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Competition() {
	}

	/** full constructor */
	public Competition(String comName, String comType, String comRank,
			String year, String note, Integer tag, String comYear,
			Set studentcoepetitions) {
		this.comName = comName;
		this.comType = comType;
		this.comRank = comRank;
		this.year = year;
		this.note = note;
		this.tag = tag;
		this.comYear = comYear;
		this.studentcoepetitions = studentcoepetitions;
	}

	// Property accessors

	public Integer getComNumber() {
		return this.comNumber;
	}

	public void setComNumber(Integer comNumber) {
		this.comNumber = comNumber;
	}

	public String getComName() {
		return this.comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComType() {
		return this.comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getComRank() {
		return this.comRank;
	}

	public void setComRank(String comRank) {
		this.comRank = comRank;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getComYear() {
		return this.comYear;
	}

	public void setComYear(String comYear) {
		this.comYear = comYear;
	}

	public Set getStudentcoepetitions() {
		return this.studentcoepetitions;
	}

	public void setStudentcoepetitions(Set studentcoepetitions) {
		this.studentcoepetitions = studentcoepetitions;
	}

}