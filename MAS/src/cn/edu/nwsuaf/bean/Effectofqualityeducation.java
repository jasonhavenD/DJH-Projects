package cn.edu.nwsuaf.bean;

/**
 * Effectofqualityeducation entity. @author MyEclipse Persistence Tools
 */

public class Effectofqualityeducation implements java.io.Serializable {

	// Fields

	private Integer effNumber;
	private Major major;
	private Integer cupCount;
	private Integer majorCount;
	private Integer hostReportCount;
	private Integer partiCount;
	private Integer otherProject;
	private String year;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Effectofqualityeducation() {
	}

	/** full constructor */
	public Effectofqualityeducation(Major major, Integer cupCount,
			Integer majorCount, Integer hostReportCount, Integer partiCount,
			Integer otherProject, String year, String note, Integer tag) {
		this.major = major;
		this.cupCount = cupCount;
		this.majorCount = majorCount;
		this.hostReportCount = hostReportCount;
		this.partiCount = partiCount;
		this.otherProject = otherProject;
		this.year = year;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getEffNumber() {
		return this.effNumber;
	}

	public void setEffNumber(Integer effNumber) {
		this.effNumber = effNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Integer getCupCount() {
		return this.cupCount;
	}

	public void setCupCount(Integer cupCount) {
		this.cupCount = cupCount;
	}

	public Integer getMajorCount() {
		return this.majorCount;
	}

	public void setMajorCount(Integer majorCount) {
		this.majorCount = majorCount;
	}

	public Integer getHostReportCount() {
		return this.hostReportCount;
	}

	public void setHostReportCount(Integer hostReportCount) {
		this.hostReportCount = hostReportCount;
	}

	public Integer getPartiCount() {
		return this.partiCount;
	}

	public void setPartiCount(Integer partiCount) {
		this.partiCount = partiCount;
	}

	public Integer getOtherProject() {
		return this.otherProject;
	}

	public void setOtherProject(Integer otherProject) {
		this.otherProject = otherProject;
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

}