package cn.edu.nwsuaf.bean;

/**
 * Innovationmember entity. @author MyEclipse Persistence Tools
 */

public class Innovationmember implements java.io.Serializable {

	// Fields

	private Integer innoMemNumber;
	private Student student;
	private Innovationproject innovationproject;
	private Integer rank;

	// Constructors

	/** default constructor */
	public Innovationmember() {
	}

	/** minimal constructor */
	public Innovationmember(Integer innoMemNumber) {
		this.innoMemNumber = innoMemNumber;
	}

	/** full constructor */
	public Innovationmember(Integer innoMemNumber, Student student,
			Innovationproject innovationproject, Integer rank) {
		this.innoMemNumber = innoMemNumber;
		this.student = student;
		this.innovationproject = innovationproject;
		this.rank = rank;
	}

	// Property accessors

	public Integer getInnoMemNumber() {
		return this.innoMemNumber;
	}

	public void setInnoMemNumber(Integer innoMemNumber) {
		this.innoMemNumber = innoMemNumber;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Innovationproject getInnovationproject() {
		return this.innovationproject;
	}

	public void setInnovationproject(Innovationproject innovationproject) {
		this.innovationproject = innovationproject;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}