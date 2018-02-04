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
 * Promotetrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "promotetrain", catalog = "teachermanager")
public class Promotetrain implements java.io.Serializable {

	// Fields

	private String trainno;
	private String trainname;
	private String traintype;
	private String trainaddr;
	private String speaker;
	private Integer period;
	private Date starttime;
	private Date endtime;
	private Integer checkstatus;
	private String note;
	private Set<Tpromotetrain> tpromotetrains = new HashSet<Tpromotetrain>(0);

	// Constructors

	/** default constructor */
	public Promotetrain() {
	}

	/** minimal constructor */
	public Promotetrain(String trainno) {
		this.trainno = trainno;
	}

	/** full constructor */
	public Promotetrain(String trainno, String trainname, String traintype,
			String trainaddr, String speaker, Integer period, Date starttime,
			Date endtime, Integer checkstatus, String note,
			Set<Tpromotetrain> tpromotetrains) {
		this.trainno = trainno;
		this.trainname = trainname;
		this.traintype = traintype;
		this.trainaddr = trainaddr;
		this.speaker = speaker;
		this.period = period;
		this.starttime = starttime;
		this.endtime = endtime;
		this.checkstatus = checkstatus;
		this.note = note;
		this.tpromotetrains = tpromotetrains;
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

	@Column(name = "trainname", length = 50)
	public String getTrainname() {
		return this.trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	@Column(name = "traintype", length = 50)
	public String getTraintype() {
		return this.traintype;
	}

	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}

	@Column(name = "trainaddr", length = 100)
	public String getTrainaddr() {
		return this.trainaddr;
	}

	public void setTrainaddr(String trainaddr) {
		this.trainaddr = trainaddr;
	}

	@Column(name = "speaker", length = 30)
	public String getSpeaker() {
		return this.speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promotetrain")
	public Set<Tpromotetrain> getTpromotetrains() {
		return this.tpromotetrains;
	}

	public void setTpromotetrains(Set<Tpromotetrain> tpromotetrains) {
		this.tpromotetrains = tpromotetrains;
	}

}