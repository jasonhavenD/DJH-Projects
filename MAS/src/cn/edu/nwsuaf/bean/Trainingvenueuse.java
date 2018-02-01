package cn.edu.nwsuaf.bean;

/**
 * Trainingvenueuse entity. @author MyEclipse Persistence Tools
 */

public class Trainingvenueuse implements java.io.Serializable {

	// Fields

	private Integer useNumber;
	private Major major;
	private Trainingvenue trainingvenue;
	private Integer courseCount;
	private Integer traCount;
	private Integer thHcount;
	private Integer thPcount;
	private String year;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Trainingvenueuse() {
	}

	/** full constructor */
	public Trainingvenueuse(Major major, Trainingvenue trainingvenue,
			Integer courseCount, Integer traCount, Integer thHcount,
			Integer thPcount, String year, Integer tag) {
		this.major = major;
		this.trainingvenue = trainingvenue;
		this.courseCount = courseCount;
		this.traCount = traCount;
		this.thHcount = thHcount;
		this.thPcount = thPcount;
		this.year = year;
		this.tag = tag;
	}

	// Property accessors

	public Integer getUseNumber() {
		return this.useNumber;
	}

	public void setUseNumber(Integer useNumber) {
		this.useNumber = useNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Trainingvenue getTrainingvenue() {
		return this.trainingvenue;
	}

	public void setTrainingvenue(Trainingvenue trainingvenue) {
		this.trainingvenue = trainingvenue;
	}

	public Integer getCourseCount() {
		return this.courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public Integer getTraCount() {
		return this.traCount;
	}

	public void setTraCount(Integer traCount) {
		this.traCount = traCount;
	}

	public Integer getThHcount() {
		return this.thHcount;
	}

	public void setThHcount(Integer thHcount) {
		this.thHcount = thHcount;
	}

	public Integer getThPcount() {
		return this.thPcount;
	}

	public void setThPcount(Integer thPcount) {
		this.thPcount = thPcount;
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