package cn.edu.nwsuaf.bean;

/**
 * Teachbook entity. @author MyEclipse Persistence Tools
 */

public class Teachbook implements java.io.Serializable {

	// Fields

	private Integer tbZno;
	private Teachingbooks teachingbooks;
	private Teacher teacher;
	private String authorJuese;
	private Integer authorRank;

	// Constructors

	/** default constructor */
	public Teachbook() {
	}

	/** minimal constructor */
	public Teachbook(Integer tbZno) {
		this.tbZno = tbZno;
	}

	/** full constructor */
	public Teachbook(Integer tbZno, Teachingbooks teachingbooks,
			Teacher teacher, String authorJuese, Integer authorRank) {
		this.tbZno = tbZno;
		this.teachingbooks = teachingbooks;
		this.teacher = teacher;
		this.authorJuese = authorJuese;
		this.authorRank = authorRank;
	}

	// Property accessors

	public Integer getTbZno() {
		return this.tbZno;
	}

	public void setTbZno(Integer tbZno) {
		this.tbZno = tbZno;
	}

	public Teachingbooks getTeachingbooks() {
		return this.teachingbooks;
	}

	public void setTeachingbooks(Teachingbooks teachingbooks) {
		this.teachingbooks = teachingbooks;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getAuthorJuese() {
		return this.authorJuese;
	}

	public void setAuthorJuese(String authorJuese) {
		this.authorJuese = authorJuese;
	}

	public Integer getAuthorRank() {
		return this.authorRank;
	}

	public void setAuthorRank(Integer authorRank) {
		this.authorRank = authorRank;
	}

}