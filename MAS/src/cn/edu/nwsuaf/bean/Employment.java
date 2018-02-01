package cn.edu.nwsuaf.bean;

/**
 * Employment entity. @author MyEclipse Persistence Tools
 */

public class Employment implements java.io.Serializable {

	// Fields

	private Integer empNumber;
	private Major major;
	private String year;
	private Integer graduCount;
	private Integer fempCount;
	private Integer empCount;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Employment() {
	}

	/** full constructor */
	public Employment(Major major, String year, Integer graduCount,
			Integer fempCount, Integer empCount, String note, Integer tag) {
		this.major = major;
		this.year = year;
		this.graduCount = graduCount;
		this.fempCount = fempCount;
		this.empCount = empCount;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getEmpNumber() {
		return this.empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
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

	public Integer getGraduCount() {
		return this.graduCount;
	}

	public void setGraduCount(Integer graduCount) {
		this.graduCount = graduCount;
	}

	public Integer getFempCount() {
		return this.fempCount;
	}

	public void setFempCount(Integer fempCount) {
		this.fempCount = fempCount;
	}

	public Integer getEmpCount() {
		return this.empCount;
	}

	public void setEmpCount(Integer empCount) {
		this.empCount = empCount;
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