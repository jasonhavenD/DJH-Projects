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
 * Tonlinetrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tonlinetrain", catalog = "teachermanager")
public class Tonlinetrain implements java.io.Serializable {

	// Fields

	private TonlinetrainId id;
	private Onlinetrain onlinetrain;
	private Teacherinfo teacherinfo;
	private String tname;
	private String gender;
	private String tunit;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private Integer period;
	private String auditor;
	private Integer checkstatus;
	private String note;

	// Constructors

	/** default constructor */
	public Tonlinetrain() {
	}

	/** minimal constructor */
	public Tonlinetrain(TonlinetrainId id, Onlinetrain onlinetrain,
			Teacherinfo teacherinfo, String rank) {
		this.id = id;
		this.onlinetrain = onlinetrain;
		this.teacherinfo = teacherinfo;
		this.rank = rank;
	}

	/** full constructor */
	public Tonlinetrain(TonlinetrainId id, Onlinetrain onlinetrain,
			Teacherinfo teacherinfo, String tname, String gender, String tunit,
			Integer age, String rank, String education, String degree,
			Integer period, String auditor, Integer checkstatus, String note) {
		this.id = id;
		this.onlinetrain = onlinetrain;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.gender = gender;
		this.tunit = tunit;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.period = period;
		this.auditor = auditor;
		this.checkstatus = checkstatus;
		this.note = note;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tno", column = @Column(name = "tno", nullable = false, length = 10)),
			@AttributeOverride(name = "trainno", column = @Column(name = "trainno", nullable = false, length = 15)) })
	public TonlinetrainId getId() {
		return this.id;
	}

	public void setId(TonlinetrainId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainno", nullable = false, insertable = false, updatable = false)
	public Onlinetrain getOnlinetrain() {
		return this.onlinetrain;
	}

	public void setOnlinetrain(Onlinetrain onlinetrain) {
		this.onlinetrain = onlinetrain;
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

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "tunit", length = 100)
	public String getTunit() {
		return this.tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "rank", nullable = false, length = 20)
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

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Column(name = "auditor", length = 20)
	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	@Column(name = "checkstatus")
	public Integer getCheckstatus() {
		return this.checkstatus;
	}

	public void setCheckstatus(Integer checkstatus) {
		this.checkstatus = checkstatus;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Tonlinetrain [onlinetrain=" + onlinetrain.getTrainno()
				+ ", teacherinfo=" + teacherinfo.getTno() + ", tname=" + tname
				+ ", gender=" + gender + ", tunit=" + tunit + ", age=" + age
				+ ", rank=" + rank + ", education=" + education + ", degree="
				+ degree + ", period=" + period + ", auditor=" + auditor
				+ ", checkstatus=" + checkstatus + ", note=" + note + "]";
	}

}