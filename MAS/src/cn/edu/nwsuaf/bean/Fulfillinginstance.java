package cn.edu.nwsuaf.bean;

/**
 * Fulfillinginstance entity. @author MyEclipse Persistence Tools
 */

public class Fulfillinginstance implements java.io.Serializable {

	// Fields

	private Integer fulNumber;
	private Major major;
	private Integer stuNumber1;
	private Integer stuNumber2;
	private Integer endNumber;
	private Float openRate;
	private Float finishRate;
	private String fulType;
	private String year;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Fulfillinginstance() {
	}

	/** full constructor */
	public Fulfillinginstance(Major major, Integer stuNumber1,
			Integer stuNumber2, Integer endNumber, Float openRate,
			Float finishRate, String fulType, String year, String note,
			Integer tag) {
		this.major = major;
		this.stuNumber1 = stuNumber1;
		this.stuNumber2 = stuNumber2;
		this.endNumber = endNumber;
		this.openRate = openRate;
		this.finishRate = finishRate;
		this.fulType = fulType;
		this.year = year;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getFulNumber() {
		return this.fulNumber;
	}

	public void setFulNumber(Integer fulNumber) {
		this.fulNumber = fulNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Integer getStuNumber1() {
		return this.stuNumber1;
	}

	public void setStuNumber1(Integer stuNumber1) {
		this.stuNumber1 = stuNumber1;
	}

	public Integer getStuNumber2() {
		return this.stuNumber2;
	}

	public void setStuNumber2(Integer stuNumber2) {
		this.stuNumber2 = stuNumber2;
	}

	public Integer getEndNumber() {
		return this.endNumber;
	}

	public void setEndNumber(Integer endNumber) {
		this.endNumber = endNumber;
	}

	public Float getOpenRate() {
		return this.openRate;
	}

	public void setOpenRate(Float openRate) {
		this.openRate = openRate;
	}

	public Float getFinishRate() {
		return this.finishRate;
	}

	public void setFinishRate(Float finishRate) {
		this.finishRate = finishRate;
	}

	public String getFulType() {
		return this.fulType;
	}

	public void setFulType(String fulType) {
		this.fulType = fulType;
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