package com.newentity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customproduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customproduct", schema = "dbo", catalog = "NewLightSystem")
public class Customproduct implements java.io.Serializable {

	// Fields

	private Integer propertyid;
	private String productkey;
	private String productvalue;
	private Integer productid;

	// Constructors

	/** default constructor */
	public Customproduct() {
	}

	/** minimal constructor */
	public Customproduct(Integer productid) {
		this.productid = productid;
	}

	/** full constructor */
	public Customproduct(Integer propertyid, String productkey,
			String productvalue, Integer productid) {
		this.propertyid = propertyid;
		this.productkey = productkey;
		this.productvalue = productvalue;
		this.productid = productid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "propertyid", unique = true, nullable = false)
	public Integer getPropertyid() {
		return this.propertyid;
	}

	public void setPropertyid(Integer propertyid) {
		this.propertyid = propertyid;
	}

	@Column(name = "productkey", length = 50)
	public String getProductkey() {
		return this.productkey;
	}

	public void setProductkey(String productkey) {
		this.productkey = productkey;
	}

	@Column(name = "productvalue", length = 50)
	public String getProductvalue() {
		return this.productvalue;
	}

	public void setProductvalue(String productvalue) {
		this.productvalue = productvalue;
	}

	@Column(name = "productid")
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

}