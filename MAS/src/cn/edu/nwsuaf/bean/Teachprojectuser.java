package cn.edu.nwsuaf.bean;

/**
 * Teachprojectuser entity. @author MyEclipse Persistence Tools
 */

public class Teachprojectuser implements java.io.Serializable {

	// Fields

	private Integer tpUno;
	private Teacher teacher;
	private Teachproject teachproject;
	private String beizhu;
	private Integer rank;

	// Constructors

	/** default constructor */
	public Teachprojectuser() {
	}

	/** full constructor */
	public Teachprojectuser(Teacher teacher, Teachproject teachproject,
			String beizhu, Integer rank) {
		this.teacher = teacher;
		this.teachproject = teachproject;
		this.beizhu = beizhu;
		this.rank = rank;
	}

	// Property accessors

	public Integer getTpUno() {
		return this.tpUno;
	}

	public void setTpUno(Integer tpUno) {
		this.tpUno = tpUno;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teachproject getTeachproject() {
		return this.teachproject;
	}

	public void setTeachproject(Teachproject teachproject) {
		this.teachproject = teachproject;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}