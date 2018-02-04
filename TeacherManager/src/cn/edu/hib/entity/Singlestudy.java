package cn.edu.hib.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Singlestudy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "singlestudy", catalog = "teachermanager")
public class Singlestudy implements java.io.Serializable {

	// Fields

	private String studyno;
	private String studyname;
	private Integer period;
	private String year;
	private Integer offstatus;
	private String note;
	private Set<Tsinglestudy> tsinglestudies = new HashSet<Tsinglestudy>(0);

	// Constructors

	/** default constructor */
	public Singlestudy() {
	}

	/** minimal constructor */
	public Singlestudy(String studyno) {
		this.studyno = studyno;
	}

	/** full constructor */
	public Singlestudy(String studyno, String studyname, Integer period,
			String year, Integer offstatus, String note,
			Set<Tsinglestudy> tsinglestudies) {
		this.studyno = studyno;
		this.studyname = studyname;
		this.period = period;
		this.year = year;
		this.offstatus = offstatus;
		this.note = note;
		this.tsinglestudies = tsinglestudies;
	}

	// Property accessors
	@Id
	@Column(name = "studyno", unique = true, nullable = false, length = 10)
	public String getStudyno() {
		return this.studyno;
	}

	public void setStudyno(String studyno) {
		this.studyno = studyno;
	}

	@Column(name = "studyname", length = 20)
	public String getStudyname() {
		return this.studyname;
	}

	public void setStudyname(String studyname) {
		this.studyname = studyname;
	}

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Column(name = "year", length = 4)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "offstatus")
	public Integer getOffstatus() {
		return this.offstatus;
	}

	public void setOffstatus(Integer offstatus) {
		this.offstatus = offstatus;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "singlestudy")
	public Set<Tsinglestudy> getTsinglestudies() {
		return this.tsinglestudies;
	}

	public void setTsinglestudies(Set<Tsinglestudy> tsinglestudies) {
		this.tsinglestudies = tsinglestudies;
	}

}