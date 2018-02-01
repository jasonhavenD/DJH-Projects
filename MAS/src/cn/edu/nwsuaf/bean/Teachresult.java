package cn.edu.nwsuaf.bean;

/**
 * Teachresult entity. @author MyEclipse Persistence Tools
 */

public class Teachresult implements java.io.Serializable {

	// Fields

	private Integer tresultNo;
	private Teachresultbaseinfo teachresultbaseinfo;
	private Teacher teacher;
	private Integer tresultRank;
	private String beizhu;

	// Constructors

	/** default constructor */
	public Teachresult() {
	}

	/** minimal constructor */
	public Teachresult(Integer tresultNo) {
		this.tresultNo = tresultNo;
	}

	/** full constructor */
	public Teachresult(Integer tresultNo,
			Teachresultbaseinfo teachresultbaseinfo, Teacher teacher,
			Integer tresultRank, String beizhu) {
		this.tresultNo = tresultNo;
		this.teachresultbaseinfo = teachresultbaseinfo;
		this.teacher = teacher;
		this.tresultRank = tresultRank;
		this.beizhu = beizhu;
	}

	// Property accessors

	public Integer getTresultNo() {
		return this.tresultNo;
	}

	public void setTresultNo(Integer tresultNo) {
		this.tresultNo = tresultNo;
	}

	public Teachresultbaseinfo getTeachresultbaseinfo() {
		return this.teachresultbaseinfo;
	}

	public void setTeachresultbaseinfo(Teachresultbaseinfo teachresultbaseinfo) {
		this.teachresultbaseinfo = teachresultbaseinfo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getTresultRank() {
		return this.tresultRank;
	}

	public void setTresultRank(Integer tresultRank) {
		this.tresultRank = tresultRank;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}