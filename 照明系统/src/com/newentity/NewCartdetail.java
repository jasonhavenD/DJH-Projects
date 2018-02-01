package com.newentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cartdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cartdetail", schema = "dbo", catalog = "newlightsystem")

public class NewCartdetail implements java.io.Serializable {

	// Fields

	private Integer cartdetailid;
	private NewCompany company;
	private NewProduct product;
	private Integer number;
	private Integer saletype;

	// Constructors

	/** default constructor */
	public NewCartdetail() {
	}

	/** minimal constructor */
	public NewCartdetail(Integer cartdetailid, NewCompany company, NewProduct product) {
		this.cartdetailid = cartdetailid;
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public NewCartdetail(Integer cartdetailid, NewCompany company, NewProduct product, Integer number, Integer saletype) {
		this.cartdetailid = cartdetailid;
		this.company = company;
		this.product = product;
		this.number = number;
		this.saletype = saletype;
	}

	// Property accessors
	@Id

	@Column(name = "cartdetailid", unique = true, nullable = false)

	public Integer getCartdetailid() {
		return this.cartdetailid;
	}

	public void setCartdetailid(Integer cartdetailid) {
		this.cartdetailid = cartdetailid;
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
	@JoinColumn(name = "productid", nullable = false)

	public NewProduct getProduct() {
		return this.product;
	}

	public void setProduct(NewProduct product) {
		this.product = product;
	}

	@Column(name = "number")

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "saletype")

	public Integer getSaletype() {
		return this.saletype;
	}

	public void setSaletype(Integer saletype) {
		this.saletype = saletype;
	}

}