package cn.edu.nwsuaf.bean;

/**
 * Publicshedarevolutionpapers entity. @author MyEclipse Persistence Tools
 */

public class Publicshedarevolutionpapers implements java.io.Serializable {

	// Fields

	private Integer revoPaperNo;
	private Teacher teacher;
	private String revoPaperName;
	private String revoPeriodicalInfo;
	private String periodicalType;
	private String year;
	private String beizhu;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Publicshedarevolutionpapers() {
	}

	/** full constructor */
	public Publicshedarevolutionpapers(Teacher teacher, String revoPaperName,
			String revoPeriodicalInfo, String periodicalType, String year,
			String beizhu, Integer tag) {
		this.teacher = teacher;
		this.revoPaperName = revoPaperName;
		this.revoPeriodicalInfo = revoPeriodicalInfo;
		this.periodicalType = periodicalType;
		this.year = year;
		this.beizhu = beizhu;
		this.tag = tag;
	}

	// Property accessors

	public Integer getRevoPaperNo() {
		return this.revoPaperNo;
	}

	public void setRevoPaperNo(Integer revoPaperNo) {
		this.revoPaperNo = revoPaperNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getRevoPaperName() {
		return this.revoPaperName;
	}

	public void setRevoPaperName(String revoPaperName) {
		this.revoPaperName = revoPaperName;
	}

	public String getRevoPeriodicalInfo() {
		return this.revoPeriodicalInfo;
	}

	public void setRevoPeriodicalInfo(String revoPeriodicalInfo) {
		this.revoPeriodicalInfo = revoPeriodicalInfo;
	}

	public String getPeriodicalType() {
		return this.periodicalType;
	}

	public void setPeriodicalType(String periodicalType) {
		this.periodicalType = periodicalType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
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