package com.entity;

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
 * Cartdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cartdetail", schema = "dbo", catalog = "NewLightSystem")
public class Cartdetail implements java.io.Serializable {

	// Fields

	private Integer cartdetailid;
	private Company company;
	private Product product;
	private Integer number;
	private Integer saletype;

	// Constructors

	/** default constructor */
	public Cartdetail() {
	}

	/** minimal constructor */
	public Cartdetail(Company company, Product product) {
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public Cartdetail(Company company, Product product, Integer number,
			Integer saletype) {
		this.company = company;
		this.product = product;
		this.number = number;
		this.saletype = saletype;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cartdetailid", unique = true, nullable = false)
	public Integer getCartdetailid() {
		return this.cartdetailid;
	}

	public void setCartdetailid(Integer cartdetailid) {
		this.cartdetailid = cartdetailid;
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
	@JoinColumn(name = "productid", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
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