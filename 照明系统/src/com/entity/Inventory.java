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
 * Inventory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventory", schema = "dbo", catalog = "NewLightSystem")
public class Inventory implements java.io.Serializable {

	// Fields

	private Integer inventoryid;
	private Company company;
	private Product product;
	private Integer inventoryquantity;

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** minimal constructor */
	public Inventory(Company company, Product product) {
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public Inventory(Company company, Product product, Integer inventoryquantity) {
		this.company = company;
		this.product = product;
		this.inventoryquantity = inventoryquantity;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inventoryid", unique = true, nullable = false)
	public Integer getInventoryid() {
		return this.inventoryid;
	}

	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
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

	@Column(name = "inventoryquantity")
	public Integer getInventoryquantity() {
		return this.inventoryquantity;
	}

	public void setInventoryquantity(Integer inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}

}