package com.newentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderdetail", schema = "dbo", catalog = "newlightsystem")

public class NewOrderdetail implements java.io.Serializable {

	// Fields

	private Integer oderdetailid;
	private NewOrderinfo orderinfo;
	private NewProduct product;
	private Integer quantity;
	private Integer saletype;

	// Constructors

	/** default constructor */
	public NewOrderdetail() {
	}

	/** minimal constructor */
	public NewOrderdetail(Integer oderdetailid, NewOrderinfo orderinfo, NewProduct product) {
		this.oderdetailid = oderdetailid;
		this.orderinfo = orderinfo;
		this.product = product;
	}

	/** full constructor */
	public NewOrderdetail(Integer oderdetailid, NewOrderinfo orderinfo, NewProduct product, Integer quantity, Integer saletype) {
		this.oderdetailid = oderdetailid;
		this.orderinfo = orderinfo;
		this.product = product;
		this.quantity = quantity;
		this.saletype = saletype;
	}

	// Property accessors
	@Id

	@Column(name = "oderdetailid", unique = true, nullable = false)

	public Integer getOderdetailid() {
		return this.oderdetailid;
	}

	public void setOderdetailid(Integer oderdetailid) {
		this.oderdetailid = oderdetailid;
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
	@JoinColumn(name = "productid", nullable = false)

	public NewProduct getProduct() {
		return this.product;
	}

	public void setProduct(NewProduct product) {
		this.product = product;
	}

	@Column(name = "quantity")

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "saletype")

	public Integer getSaletype() {
		return this.saletype;
	}

	public void setSaletype(Integer saletype) {
		this.saletype = saletype;
	}

}