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
 * Point entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "point", schema = "dbo", catalog = "newlightsystem")

public class NewPoint implements java.io.Serializable {

	// Fields

	private Integer pointid;
	private NewCompany company;
	private NewProduct product;
	private Integer productid;
	private Timestamp updatetime;
	private Integer type;
	private Integer pointamount;

	// Constructors

	/** default constructor */
	public NewPoint() {
	}

	/** minimal constructor */
	public NewPoint(Integer pointid, NewCompany company, NewProduct product, Integer productid) {
		this.pointid = pointid;
		this.company = company;
		this.product = product;
		this.productid = productid;
	}

	/** full constructor */
	public NewPoint(Integer pointid, NewCompany company, NewProduct product, Integer productid, Timestamp updatetime,
			Integer type, Integer pointamount) {
		this.pointid = pointid;
		this.company = company;
		this.product = product;
		this.productid = productid;
		this.updatetime = updatetime;
		this.type = type;
		this.pointamount = pointamount;
	}

	// Property accessors
	@Id

	@Column(name = "pointid", unique = true, nullable = false)

	public Integer getPointid() {
		return this.pointid;
	}

	public void setPointid(Integer pointid) {
		this.pointid = pointid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)

	public NewCompany getCompany() {
		return this.company;
	}

	public void setCompany(NewCompany company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pointid", unique = true, nullable = false, insertable = false, updatable = false)

	public NewProduct getProduct() {
		return this.product;
	}

	public void setProduct(NewProduct product) {
		this.product = product;
	}

	@Column(name = "productid", nullable = false)

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	@Column(name = "pointamount")

	public Integer getPointamount() {
		return this.pointamount;
	}

	public void setPointamount(Integer pointamount) {
		this.pointamount = pointamount;
	}

}