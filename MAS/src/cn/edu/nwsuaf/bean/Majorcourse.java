package cn.edu.nwsuaf.bean;

/**
 * Majorcourse entity. @author MyEclipse Persistence Tools
 */

public class Majorcourse implements java.io.Serializable {

	// Fields

	private Integer openCourseNo;
	private Major major;
	private Course course;
	private Teacher teacher;
	private String year;
	private String openSemester;
	private String inMajor;
	private String professionalTitleName;
	private Integer classhours;
	private Integer courseHours;
	private String ctype;
	private String beizhu;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Majorcourse() {
	}

	/** minimal constructor */
	public Majorcourse(Major major, Course course, Teacher teacher) {
		this.major = major;
		this.course = course;
		this.teacher = teacher;
	}

	/** full constructor */
	public Majorcourse(Major major, Course course, Teacher teacher,
			String year, String openSemester, String inMajor,
			String professionalTitleName, Integer classhours,
			Integer courseHours, String ctype, String beizhu, Integer tag) {
		this.major = major;
		this.course = course;
		this.teacher = teacher;
		this.year = year;
		this.openSemester = openSemester;
		this.inMajor = inMajor;
		this.professionalTitleName = professionalTitleName;
		this.classhours = classhours;
		this.courseHours = courseHours;
		this.ctype = ctype;
		this.beizhu = beizhu;
		this.tag = tag;
	}

	// Property accessors

	public Integer getOpenCourseNo() {
		return this.openCourseNo;
	}

	public void setOpenCourseNo(Integer openCourseNo) {
		this.openCourseNo = openCourseNo;
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

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOpenSemester() {
		return this.openSemester;
	}

	public void setOpenSemester(String openSemester) {
		this.openSemester = openSemester;
	}

	public String getInMajor() {
		return this.inMajor;
	}

	public void setInMajor(String inMajor) {
		this.inMajor = inMajor;
	}

	public String getProfessionalTitleName() {
		return this.professionalTitleName;
	}

	public void setProfessionalTitleName(String professionalTitleName) {
		this.professionalTitleName = professionalTitleName;
	}

	public Integer getClasshours() {
		return this.classhours;
	}

	public void setClasshours(Integer classhours) {
		this.classhours = classhours;
	}

	public Integer getCourseHours() {
		return this.courseHours;
	}

	public void setCourseHours(Integer courseHours) {
		this.courseHours = courseHours;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}