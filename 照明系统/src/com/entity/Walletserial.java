package com.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Walletserial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "walletserial", schema = "dbo", catalog = "NewLightSystem")
public class Walletserial implements java.io.Serializable {

	// Fields

	private Integer serialid;
	private Company company;
	private Orderinfo orderinfo;
	private Timestamp updatetime;
	private Integer type;
	private Double amount;

	// Constructors

	/** default constructor */
	public Walletserial() {
	}

	/** minimal constructor */
	public Walletserial(Company company, Orderinfo orderinfo) {
		this.company = company;
		this.orderinfo = orderinfo;
	}

	/** full constructor */
	public Walletserial(Company company, Orderinfo orderinfo,
			Timestamp updatetime, Integer type, Double amount) {
		this.company = company;
		this.orderinfo = orderinfo;
		this.updatetime = updatetime;
		this.type = type;
		this.amount = amount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "serialid", unique = true, nullable = false)
	public Integer getSerialid() {
		return this.serialid;
	}

	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false)
	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	@Column(name = "updatetime", length = 23)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "amount", precision = 53, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}