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
 * Tsinglestudy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tsinglestudy", catalog = "teachermanager")
public class Tsinglestudy implements java.io.Serializable {

	// Fields

	private TsinglestudyId id;
	private Singlestudy singlestudy;
	private Teacherinfo teacherinfo;
	private String tname;
	private String tunit;
	private String gender;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private String studyplace;
	private String studycontent;
	private Date starttime;
	private Date endtime;
	private String checkstatus;
	private String summarymaterial;
	private String period;
	private String auditor;
	private String note;

	// Constructors

	/** default constructor */
	public Tsinglestudy() {
	}

	/** minimal constructor */
	public Tsinglestudy(TsinglestudyId id, Singlestudy singlestudy,
			Teacherinfo teacherinfo) {
		this.id = id;
		this.singlestudy = singlestudy;
		this.teacherinfo = teacherinfo;
	}

	/** full constructor */
	public Tsinglestudy(TsinglestudyId id, Singlestudy singlestudy,
			Teacherinfo teacherinfo, String tname, String tunit, String gender,
			Integer age, String rank, String education, String degree,
			String studyplace, String studycontent, Date starttime,
			Date endtime, String checkstatus, String summarymaterial,
			String period, String auditor, String note) {
		this.id = id;
		this.singlestudy = singlestudy;
		this.teacherinfo = teacherinfo;
		this.tname = tname;
		this.tunit = tunit;
		this.gender = gender;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.studyplace = studyplace;
		this.studycontent = studycontent;
		this.starttime = starttime;
		this.endtime = endtime;
		this.checkstatus = checkstatus;
		this.summarymaterial = summarymaterial;
		this.period = period;
		this.auditor = auditor;
		this.note = note;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tno", column = @Column(name = "tno", nullable = false, length = 10)),
			@AttributeOverride(name = "studyno", column = @Column(name = "studyno", nullable = false, length = 10)) })
	public TsinglestudyId getId() {
		return this.id;
	}

	public void setId(TsinglestudyId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studyno", nullable = false, insertable = false, updatable = false)
	public Singlestudy getSinglestudy() {
		return this.singlestudy;
	}

	public void setSinglestudy(Singlestudy singlestudy) {
		this.singlestudy = singlestudy;
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

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "rank", length = 10)
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

	@Column(name = "studyplace", length = 100)
	public String getStudyplace() {
		return this.studyplace;
	}

	public void setStudyplace(String studyplace) {
		this.studyplace = studyplace;
	}

	@Column(name = "studycontent", length = 65535)
	public String getStudycontent() {
		return this.studycontent;
	}

	public void setStudycontent(String studycontent) {
		this.studycontent = studycontent;
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

	@Column(name = "checkstatus", length = 10)
	public String getCheckstatus() {
		return this.checkstatus;
	}

	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}

	@Column(name = "summarymaterial", length = 200)
	public String getSummarymaterial() {
		return this.summarymaterial;
	}

	public void setSummarymaterial(String summarymaterial) {
		this.summarymaterial = summarymaterial;
	}

	@Column(name = "period", length = 4)
	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Column(name = "auditor", length = 20)
	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}