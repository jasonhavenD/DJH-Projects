package cn.edu.nwsuaf.bean;

/**
 * Presidedoverscientificresearchproject entity. @author MyEclipse Persistence
 * Tools
 */

public class Presidedoverscientificresearchproject implements
		java.io.Serializable {

	// Fields

	private String projectNo;
	private Teacher teacher;
	private String projectName;
	private String projecJibie;
	private String projecType;
	private String year;
	private String projecTime;
	private String acceptenceDate;
	private Float cost;
	private Integer partTeacherNum;
	private String beizhu;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Presidedoverscientificresearchproject() {
	}

	/** minimal constructor */
	public Presidedoverscientificresearchproject(String projectNo) {
		this.projectNo = projectNo;
	}

	/** full constructor */
	public Presidedoverscientificresearchproject(String projectNo,
			Teacher teacher, String projectName, String projecJibie,
			String projecType, String year, String projecTime,
			String acceptenceDate, Float cost, Integer partTeacherNum,
			String beizhu, Integer tag) {
		this.projectNo = projectNo;
		this.teacher = teacher;
		this.projectName = projectName;
		this.projecJibie = projecJibie;
		this.projecType = projecType;
		this.year = year;
		this.projecTime = projecTime;
		this.acceptenceDate = acceptenceDate;
		this.cost = cost;
		this.partTeacherNum = partTeacherNum;
		this.beizhu = beizhu;
		this.tag = tag;
	}

	// Property accessors

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjecJibie() {
		return this.projecJibie;
	}

	public void setProjecJibie(String projecJibie) {
		this.projecJibie = projecJibie;
	}

	public String getProjecType() {
		return this.projecType;
	}

	public void setProjecType(String projecType) {
		this.projecType = projecType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProjecTime() {
		return this.projecTime;
	}

	public void setProjecTime(String projecTime) {
		this.projecTime = projecTime;
	}

	public String getAcceptenceDate() {
		return this.acceptenceDate;
	}

	public void setAcceptenceDate(String acceptenceDate) {
		this.acceptenceDate = acceptenceDate;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getPartTeacherNum() {
		return this.partTeacherNum;
	}

	public void setPartTeacherNum(Integer partTeacherNum) {
		this.partTeacherNum = partTeacherNum;
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