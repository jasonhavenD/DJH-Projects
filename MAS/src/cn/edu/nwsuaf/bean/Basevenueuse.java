package cn.edu.nwsuaf.bean;

/**
 * Basevenueuse entity. @author MyEclipse Persistence Tools
 */

public class Basevenueuse implements java.io.Serializable {

	// Fields

	private Integer buseNumber;
	private Practicebase practicebase;
	private Major major;
	private Integer mhcount;
	private Integer mpcount;
	private String year;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Basevenueuse() {
	}

	/** full constructor */
	public Basevenueuse(Practicebase practicebase, Major major,
			Integer mhcount, Integer mpcount, String year, Integer tag) {
		this.practicebase = practicebase;
		this.major = major;
		this.mhcount = mhcount;
		this.mpcount = mpcount;
		this.year = year;
		this.tag = tag;
	}

	// Property accessors

	public Integer getBuseNumber() {
		return this.buseNumber;
	}

	public void setBuseNumber(Integer buseNumber) {
		this.buseNumber = buseNumber;
	}

	public Practicebase getPracticebase() {
		return this.practicebase;
	}

	public void setPracticebase(Practicebase practicebase) {
		this.practicebase = practicebase;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Integer getMhcount() {
		return this.mhcount;
	}

	public void setMhcount(Integer mhcount) {
		this.mhcount = mhcount;
	}

	public Integer getMpcount() {
		return this.mpcount;
	}

	public void setMpcount(Integer mpcount) {
		this.mpcount = mpcount;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}