package cn.edu.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Inductiontrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inductiontrain", catalog = "teachermanager")
public class Inductiontrain implements java.io.Serializable {

	// Fields

	private String tno;
	private Teacherinfo teacherinfo;
	private String tname;
	private String tunit;
	private String gender;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private String teacherethics;
	private String teachingeffect;
	private Integer teachingpractice;
	private String qualificationtestcoach;
	private Integer qualificationtest;
	private Integer professionalskillstest;
	private Integer period;
	private String note;

	// Constructors

	/** default constructor */
	public Inductiontrain() {
	}

	/** minimal constructor */
	public Inductiontrain(String tno, Teacherinfo teacherinfo) {
		this.tno = tno;
		this.teacherinfo = teacherinfo;
	}

	/** full constructor */
	public Inductiontrain(String tno, Teacherinfo teacherinfo, String tname,
			String tunit, String gender, Integer age, String rank,
			String education, String degree, String teacherethics,
			String teachingeffect, Integer teachingpractice,
			String qualificationtestcoach, Integer qualificationtest,
			Integer professionalskillstest, Integer period, String note) {
		this.tno = tno;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.tunit = tunit;
		this.gender = gender;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.teacherethics = teacherethics;
		this.teachingeffect = teachingeffect;
		this.teachingpractice = teachingpractice;
		this.qualificationtestcoach = qualificationtestcoach;
		this.qualificationtest = qualificationtest;
		this.professionalskillstest = professionalskillstest;
		this.period = period;
		this.note = note;
	}

	// Property accessors
	@Id
	@Column(name = "tno", unique = true, nullable = false, length = 10)
	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
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

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "rank", length = 20)
	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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

	@Column(name = "teacherethics", length = 6)
	public String getTeacherethics() {
		return this.teacherethics;
	}

	public void setTeacherethics(String teacherethics) {
		this.teacherethics = teacherethics;
	}

	@Column(name = "teachingeffect", length = 6)
	public String getTeachingeffect() {
		return this.teachingeffect;
	}

	public void setTeachingeffect(String teachingeffect) {
		this.teachingeffect = teachingeffect;
	}

	@Column(name = "teachingpractice")
	public Integer getTeachingpractice() {
		return this.teachingpractice;
	}

	public void setTeachingpractice(Integer teachingpractice) {
		this.teachingpractice = teachingpractice;
	}

	@Column(name = "qualificationtestcoach", length = 6)
	public String getQualificationtestcoach() {
		return this.qualificationtestcoach;
	}

	public void setQualificationtestcoach(String qualificationtestcoach) {
		this.qualificationtestcoach = qualificationtestcoach;
	}

	@Column(name = "qualificationtest")
	public Integer getQualificationtest() {
		return this.qualificationtest;
	}

	public void setQualificationtest(Integer qualificationtest) {
		this.qualificationtest = qualificationtest;
	}

	@Column(name = "professionalskillstest")
	public Integer getProfessionalskillstest() {
		return this.professionalskillstest;
	}

	public void setProfessionalskillstest(Integer professionalskillstest) {
		this.professionalskillstest = professionalskillstest;
	}

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}