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
 * Onlinetrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "onlinetrain", catalog = "teachermanager")
public class Onlinetrain implements java.io.Serializable {

	// Fields

	private String trainno;
	private String trainname;
	private Integer period;
	private Date starttime;
	private Date endtime;
	private Integer offstatus;
	private String note;
	private Set<Tonlinetrain> tonlinetrains = new HashSet<Tonlinetrain>(0);

	// Constructors

	/** default constructor */
	public Onlinetrain() {
	}

	/** minimal constructor */
	public Onlinetrain(String trainno) {
		this.trainno = trainno;
		this.trainname = "";
		this.period = 0;
		this.starttime = new Date(0);
		this.endtime = new Date();
		this.offstatus = 0;
		this.note = "暂无";
	}

	/** full constructor */
	public Onlinetrain(String trainno, String trainname, Integer period,
			Date starttime, Date endtime, Integer offstatus, String note,
			Set<Tonlinetrain> tonlinetrains) {
		this.trainno = trainno;
		this.trainname = trainname;
		this.period = period;
		this.starttime = starttime;
		this.endtime = endtime;
		this.offstatus = offstatus;
		this.note = note;
		this.tonlinetrains = tonlinetrains;
	}

	// Property accessors
	@Id
	@Column(name = "trainno", unique = true, nullable = false, length = 15)
	public String getTrainno() {
		return this.trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	@Column(name = "trainname", length = 200)
	public String getTrainname() {
		return this.trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "onlinetrain")
	public Set<Tonlinetrain> getTonlinetrains() {
		return this.tonlinetrains;
	}

	public void setTonlinetrains(Set<Tonlinetrain> tonlinetrains) {
		this.tonlinetrains = tonlinetrains;
	}

	@Override
	public String toString() {
		return "Onlinetrain [trainno=" + trainno + ", trainname=" + trainname
				+ ", period=" + period + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", offstatus=" + offstatus
				+ ", note=" + note + ", tonlinetrains=" + tonlinetrains + "]";
	}

}