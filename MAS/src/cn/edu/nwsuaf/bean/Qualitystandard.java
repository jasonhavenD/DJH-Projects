package cn.edu.nwsuaf.bean;

/**
 * Qualitystandard entity. @author MyEclipse Persistence Tools
 */

public class Qualitystandard implements java.io.Serializable {

	// Fields

	private Integer quaNumber;
	private Major major;
	private Integer allCount;
	private Integer completeCount;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Qualitystandard() {
	}

	/** full constructor */
	public Qualitystandard(Major major, Integer allCount,
			Integer completeCount, String note, Integer tag) {
		this.major = major;
		this.allCount = allCount;
		this.completeCount = completeCount;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getQuaNumber() {
		return this.quaNumber;
	}

	public void setQuaNumber(Integer quaNumber) {
		this.quaNumber = quaNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Integer getAllCount() {
		return this.allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public Integer getCompleteCount() {
		return this.completeCount;
	}

	public void setCompleteCount(Integer completeCount) {
		this.completeCount = completeCount;
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