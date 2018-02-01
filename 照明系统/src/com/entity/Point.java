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
 * Point entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "point", schema = "dbo", catalog = "NewLightSystem")
public class Point implements java.io.Serializable {

	// Fields

	private Integer pointid;
	private Product product;
	private Company company;
	private Integer productid;
	private Timestamp updatetime;
	private Integer type;
	private Integer pointamount;

	// Constructors

	/** default constructor */
	public Point() {
	}

	/** minimal constructor */
	public Point(Product product, Company company, Integer productid) {
		this.product = product;
		this.company = company;
		this.productid = productid;
	}

	/** full constructor */
	public Point(Product product, Company company, Integer productid,
			Timestamp updatetime, Integer type, Integer pointamount) {
		this.product = product;
		this.company = company;
		this.productid = productid;
		this.updatetime = updatetime;
		this.type = type;
		this.pointamount = pointamount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pointid", unique = true, nullable = false)
	public Integer getPointid() {
		return this.pointid;
	}

	public void setPointid(Integer pointid) {
		this.pointid = pointid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pointid", unique = true, nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
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