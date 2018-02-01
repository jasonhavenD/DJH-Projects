package cn.edu.nwsuaf.bean;

/**
 * Highleveltalent entity. @author MyEclipse Persistence Tools
 */

public class Highleveltalent implements java.io.Serializable {

	// Fields

	private Integer hno;
	private Teacher teacher;
	private String talentType;
	private String talentLevel;
	private String rearchField;
	private String year;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Highleveltalent() {
	}

	/** full constructor */
	public Highleveltalent(Teacher teacher, String talentType,
			String talentLevel, String rearchField, String year, Integer tag) {
		this.teacher = teacher;
		this.talentType = talentType;
		this.talentLevel = talentLevel;
		this.rearchField = rearchField;
		this.year = year;
		this.tag = tag;
	}

	// Property accessors

	public Integer getHno() {
		return this.hno;
	}

	public void setHno(Integer hno) {
		this.hno = hno;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTalentType() {
		return this.talentType;
	}

	public void setTalentType(String talentType) {
		this.talentType = talentType;
	}

	public String getTalentLevel() {
		return this.talentLevel;
	}

	public void setTalentLevel(String talentLevel) {
		this.talentLevel = talentLevel;
	}

	public String getRearchField() {
		return this.rearchField;
	}

	public void setRearchField(String rearchField) {
		this.rearchField = rearchField;
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