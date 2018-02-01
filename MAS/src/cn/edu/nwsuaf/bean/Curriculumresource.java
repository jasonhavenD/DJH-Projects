package cn.edu.nwsuaf.bean;

/**
 * Curriculumresource entity. @author MyEclipse Persistence Tools
 */

public class Curriculumresource implements java.io.Serializable {

	// Fields

	private Integer sourNumer;
	private Major major;
	private Course course;
	private String coursePlann;
	private String isOpen;
	private String isExcellent;
	private String year;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Curriculumresource() {
	}

	/** full constructor */
	public Curriculumresource(Major major, Course course, String coursePlann,
			String isOpen, String isExcellent, String year, String note,
			Integer tag) {
		this.major = major;
		this.course = course;
		this.coursePlann = coursePlann;
		this.isOpen = isOpen;
		this.isExcellent = isExcellent;
		this.year = year;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getSourNumer() {
		return this.sourNumer;
	}

	public void setSourNumer(Integer sourNumer) {
		this.sourNumer = sourNumer;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getCoursePlann() {
		return this.coursePlann;
	}

	public void setCoursePlann(String coursePlann) {
		this.coursePlann = coursePlann;
	}

	public String getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getIsExcellent() {
		return this.isExcellent;
	}

	public void setIsExcellent(String isExcellent) {
		this.isExcellent = isExcellent;
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