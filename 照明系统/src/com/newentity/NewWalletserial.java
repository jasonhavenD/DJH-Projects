package com.newentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Walletserial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "walletserial", schema = "dbo", catalog = "newlightsystem")

public class NewWalletserial implements java.io.Serializable {

	// Fields

	private Integer serialid;
	private NewOrderinfo orderinfo;
	private NewCompany company;
	private Timestamp updatetime;
	private Integer type;
	private Double amount;

	// Constructors

	/** default constructor */
	public NewWalletserial() {
	}

	/** minimal constructor */
	public NewWalletserial(Integer serialid, NewOrderinfo orderinfo, NewCompany company) {
		this.serialid = serialid;
		this.orderinfo = orderinfo;
		this.company = company;
	}

	/** full constructor */
	public NewWalletserial(Integer serialid, NewOrderinfo orderinfo, NewCompany company, Timestamp updatetime, Integer type,
			Double amount) {
		this.serialid = serialid;
		this.orderinfo = orderinfo;
		this.company = company;
		this.updatetime = updatetime;
		this.type = type;
		this.amount = amount;
	}

	// Property accessors
	@Id

	@Column(name = "serialid", unique = true, nullable = false)

	public Integer getSerialid() {
		return this.serialid;
	}

	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false)

	public NewOrderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(NewOrderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)

	public NewCompany getCompany() {
		return this.company;
	}

	public void setCompany(NewCompany company) {
		this.company = company;
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