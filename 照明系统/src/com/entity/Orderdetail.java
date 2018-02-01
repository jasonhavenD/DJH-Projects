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
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderdetail", schema = "dbo", catalog = "NewLightSystem")
public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer oderdetailid;
	private Product product;
	private Orderinfo orderinfo;
	private Integer quantity;
	private Integer saletype;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(Product product, Orderinfo orderinfo) {
		this.product = product;
		this.orderinfo = orderinfo;
	}

	/** full constructor */
	public Orderdetail(Product product, Orderinfo orderinfo, Integer quantity,
			Integer saletype) {
		this.product = product;
		this.orderinfo = orderinfo;
		this.quantity = quantity;
		this.saletype = saletype;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "oderdetailid", unique = true, nullable = false)
	public Integer getOderdetailid() {
		return this.oderdetailid;
	}

	public void setOderdetailid(Integer oderdetailid) {
		this.oderdetailid = oderdetailid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false)
	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
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