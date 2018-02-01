package com.newentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Inventory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventory", schema = "dbo", catalog = "newlightsystem")

public class NewInventory implements java.io.Serializable {

	// Fields

	private Integer inventoryid;
	private NewCompany company;
	private NewProduct product;
	private Integer inventoryquantity;

	// Constructors

	/** default constructor */
	public NewInventory() {
	}

	/** minimal constructor */
	public NewInventory(Integer inventoryid, NewCompany company, NewProduct product) {
		this.inventoryid = inventoryid;
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public NewInventory(Integer inventoryid, NewCompany company, NewProduct product, Integer inventoryquantity) {
		this.inventoryid = inventoryid;
		this.company = company;
		this.product = product;
		this.inventoryquantity = inventoryquantity;
	}

	// Property accessors
	@Id

	@Column(name = "inventoryid", unique = true, nullable = false)

	public Integer getInventoryid() {
		return this.inventoryid;
	}

	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
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

	@Column(name = "inventoryquantity")

	public Integer getInventoryquantity() {
		return this.inventoryquantity;
	}

	public void setInventoryquantity(Integer inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}

}