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
 * Tpromotetrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tpromotetrain", catalog = "teachermanager")
public class Tpromotetrain implements java.io.Serializable {

	// Fields

	private TpromotetrainId id;
	private Promotetrain promotetrain;
	private Teacherinfo teacherinfo;
	private String tname;
	private String tunit;
	private String gender;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private Integer period;
	private float traingrade;
	private Integer checkstatus;
	private String note;

	// Constructors

	/** default constructor */
	public Tpromotetrain() {
	}

	/** minimal constructor */
	public Tpromotetrain(TpromotetrainId id, Promotetrain promotetrain,
			Teacherinfo teacherinfo) {
		this.id = id;
		this.promotetrain = promotetrain;
		this.teacherinfo = teacherinfo;
	}

	/** full constructor */
	public Tpromotetrain(TpromotetrainId id, Promotetrain promotetrain,
			Teacherinfo teacherinfo, String tname, String tunit, String gender,
			Integer age, String rank, String education, String degree,
			Integer period, float traingrade, Integer checkstatus, String note) {
		this.id = id;
		this.promotetrain = promotetrain;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.tunit = tunit;
		this.gender = gender;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.period = period;
		this.traingrade = traingrade;
		this.checkstatus = checkstatus;
		this.note = note;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "trainno", column = @Column(name = "trainno", nullable = false, length = 15)),
			@AttributeOverride(name = "tno", column = @Column(name = "tno", nullable = false, length = 10)) })
	public TpromotetrainId getId() {
		return this.id;
	}

	public void setId(TpromotetrainId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainno", nullable = false, insertable = false, updatable = false)
	public Promotetrain getPromotetrain() {
		return this.promotetrain;
	}

	public void setPromotetrain(Promotetrain promotetrain) {
		this.promotetrain = promotetrain;
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

	@Column(name = "gender", length = 4)
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

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Column(name = "traingrade", precision = 4, scale = 0)
	public float getTraingrade() {
		return this.traingrade;
	}

	public void setTraingrade(float traingrade) {
		this.traingrade = traingrade;
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

}