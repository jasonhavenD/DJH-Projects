package cn.edu.hib.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Teachingevaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teachingevaluation", catalog = "teachermanager")
public class Teachingevaluation implements java.io.Serializable {

	// Fields

	private String valuationno;
	private String valuationname;
	private Date starttime;
	private Date endtime;
	private Integer checkstatus;
	private String note;
	private Set<Tteachingevaluation> tteachingevaluations = new HashSet<Tteachingevaluation>(
			0);

	// Constructors

	/** default constructor */
	public Teachingevaluation() {
	}

	/** minimal constructor */
	public Teachingevaluation(String valuationno) {
		this.valuationno = valuationno;
	}

	/** full constructor */
	public Teachingevaluation(String valuationno, String valuationname,
			Date starttime, Date endtime, Integer checkstatus, String note,
			Set<Tteachingevaluation> tteachingevaluations) {
		this.valuationno = valuationno;
		this.valuationname = valuationname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.checkstatus = checkstatus;
		this.note = note;
		this.tteachingevaluations = tteachingevaluations;
	}

	// Property accessors
	@Id
	@Column(name = "valuationno", unique = true, nullable = false, length = 15)
	public String getValuationno() {
		return this.valuationno;
	}

	public void setValuationno(String valuationno) {
		this.valuationno = valuationno;
	}

	@Column(name = "valuationname", length = 50)
	public String getValuationname() {
		return this.valuationname;
	}

	public void setValuationname(String valuationname) {
		this.valuationname = valuationname;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teachingevaluation")
	public Set<Tteachingevaluation> getTteachingevaluations() {
		return this.tteachingevaluations;
	}

	public void setTteachingevaluations(
			Set<Tteachingevaluation> tteachingevaluations) {
		this.tteachingevaluations = tteachingevaluations;
	}

}