package cn.edu.nwsuaf.bean;

/**
 * Addmissions entity. @author MyEclipse Persistence Tools
 */

public class Addmissions implements java.io.Serializable {

	// Fields

	private Integer addmNumber;
	private Major major;
	private String addmYear;
	private Integer expectCount;
	private Integer addmCount;
	private Float firstChoice;
	private Float entranceEverage;
	private Float hotDeggree;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Addmissions() {
	}

	/** full constructor */
	public Addmissions(Major major, String addmYear, Integer expectCount,
			Integer addmCount, Float firstChoice, Float entranceEverage,
			Float hotDeggree, String note, Integer tag) {
		this.major = major;
		this.addmYear = addmYear;
		this.expectCount = expectCount;
		this.addmCount = addmCount;
		this.firstChoice = firstChoice;
		this.entranceEverage = entranceEverage;
		this.hotDeggree = hotDeggree;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getAddmNumber() {
		return this.addmNumber;
	}

	public void setAddmNumber(Integer addmNumber) {
		this.addmNumber = addmNumber;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getAddmYear() {
		return this.addmYear;
	}

	public void setAddmYear(String addmYear) {
		this.addmYear = addmYear;
	}

	public Integer getExpectCount() {
		return this.expectCount;
	}

	public void setExpectCount(Integer expectCount) {
		this.expectCount = expectCount;
	}

	public Integer getAddmCount() {
		return this.addmCount;
	}

	public void setAddmCount(Integer addmCount) {
		this.addmCount = addmCount;
	}

	public Float getFirstChoice() {
		return this.firstChoice;
	}

	public void setFirstChoice(Float firstChoice) {
		this.firstChoice = firstChoice;
	}

	public Float getEntranceEverage() {
		return this.entranceEverage;
	}

	public void setEntranceEverage(Float entranceEverage) {
		this.entranceEverage = entranceEverage;
	}

	public Float getHotDeggree() {
		return this.hotDeggree;
	}

	public void setHotDeggree(Float hotDeggree) {
		this.hotDeggree = hotDeggree;
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