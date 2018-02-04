package cn.edu.hib.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tteachingevaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tteachingevaluation", catalog = "teachermanager")
public class Tteachingevaluation implements java.io.Serializable {

	// Fields

	private TteachingevaluationId id;
	private Teachingevaluation teachingevaluation;
	private Teacherinfo teacherinfo;
	private String tname;
	private String tunit;
	private String gender;
	private String rank;
	private Integer age;
	private String education;
	private String degree;
	private Integer grade;
	private String note;

	// Constructors

	/** default constructor */
	public Tteachingevaluation() {
	}

	/** minimal constructor */
	public Tteachingevaluation(TteachingevaluationId id,
			Teachingevaluation teachingevaluation, Teacherinfo teacherinfo) {
		this.id = id;
		this.teachingevaluation = teachingevaluation;
		this.teacherinfo = teacherinfo;
	}

	/** full constructor */
	public Tteachingevaluation(TteachingevaluationId id,
			Teachingevaluation teachingevaluation, Teacherinfo teacherinfo,
			String tname, String tunit, String gender, String rank,
			Integer age, String education, String degree, Integer grade,
			String note) {
		this.id = id;
		this.teachingevaluation = teachingevaluation;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.tunit = tunit;
		this.gender = gender;
		this.rank = rank;
		this.age = age;
		this.education = education;
		this.degree = degree;
		this.grade = grade;
		this.note = note;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "valuationno", column = @Column(name = "valuationno", nullable = false, length = 15)),
			@AttributeOverride(name = "tno", column = @Column(name = "tno", nullable = false, length = 10)) })
	public TteachingevaluationId getId() {
		return this.id;
	}

	public void setId(TteachingevaluationId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "valuationno", nullable = false, insertable = false, updatable = false)
	public Teachingevaluation getTeachingevaluation() {
		return this.teachingevaluation;
	}

	public void setTeachingevaluation(Teachingevaluation teachingevaluation) {
		this.teachingevaluation = teachingevaluation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tno", nullable = false, insertable = false, updatable = false)
	public Teacherinfo getTeacherinfo() {
		return this.teacherinfo;
	}

	public void setTeacherinfo(Teacherinfo teacherinfo) {
		this.teacherinfo = teacherinfo;
	}

	@Column(name = "tname", length = 100)
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name = "tunit", length = 100)
	public String getTunit() {
		return this.tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "rank", length = 20)
	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "education", length = 20)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "degree", length = 20)
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "grade")
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}