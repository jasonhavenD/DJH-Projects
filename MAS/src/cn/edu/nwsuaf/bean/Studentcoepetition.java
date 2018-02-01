package cn.edu.nwsuaf.bean;

/**
 * Studentcoepetition entity. @author MyEclipse Persistence Tools
 */

public class Studentcoepetition implements java.io.Serializable {

	// Fields

	private Integer innoMemNumber;
	private Competition competition;
	private Student student;
	private Integer rank;

	// Constructors

	/** default constructor */
	public Studentcoepetition() {
	}

	/** full constructor */
	public Studentcoepetition(Competition competition, Student student,
			Integer rank) {
		this.competition = competition;
		this.student = student;
		this.rank = rank;
	}

	// Property accessors

	public Integer getInnoMemNumber() {
		return this.innoMemNumber;
	}

	public void setInnoMemNumber(Integer innoMemNumber) {
		this.innoMemNumber = innoMemNumber;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}