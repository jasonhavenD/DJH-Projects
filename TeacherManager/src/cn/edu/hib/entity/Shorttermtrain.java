package cn.edu.hib.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Shorttermtrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shorttermtrain", catalog = "teachermanager")
public class Shorttermtrain implements java.io.Serializable {

	// Fields

	private ShorttermtrainId id;
	private Teacherinfo teacherinfo;
	private String tname;
	private String tunit;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private String traintopic;
	private String trainaddr;
	private Integer period;
	private Date starttime;
	private Date endtime;
	private String note;

	// Constructors

	/** default constructor */
	public Shorttermtrain() {
	}

	/** minimal constructor */
	public Shorttermtrain(ShorttermtrainId id, Teacherinfo teacherinfo) {
		this.id = id;
		this.teacherinfo = teacherinfo;
	}

	/** full constructor */
	public Shorttermtrain(ShorttermtrainId id, Teacherinfo teacherinfo,
			String tname, String tunit, Integer age, String rank,
			String education, String degree, String traintopic,
			String trainaddr, Integer period, Date starttime, Date endtime,
			String note) {
		this.id = id;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.tunit = tunit;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.traintopic = traintopic;
		this.trainaddr = trainaddr;
		this.period = period;
		this.starttime = starttime;
		this.endtime = endtime;
		this.note = note;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "trainno", column = @Column(name = "trainno", nullable = false, length = 15)),
			@AttributeOverride(name = "tno", column = @Column(name = "tno", nullable = false, length = 10)) })
	public ShorttermtrainId getId() {
		return this.id;
	}

	public void setId(ShorttermtrainId id) {
		this.id = id;
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

	@Column(name = "traintopic", length = 40)
	public String getTraintopic() {
		return this.traintopic;
	}

	public void setTraintopic(String traintopic) {
		this.traintopic = traintopic;
	}

	@Column(name = "trainaddr", length = 100)
	public String getTrainaddr() {
		return this.trainaddr;
	}

	public void setTrainaddr(String trainaddr) {
		this.trainaddr = trainaddr;
	}

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "starttime", length = 10)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtime", length = 10)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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
		return "Shorttermtrain [id=" + id + ", teacherinfo=" + teacherinfo
				+ ", tname=" + tname + ", tunit=" + tunit + ", age=" + age
				+ ", rank=" + rank + ", education=" + education + ", degree="
				+ degree + ", traintopic=" + traintopic + ", trainaddr="
				+ trainaddr + ", period=" + period + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", note=" + note + "]";
	}

}