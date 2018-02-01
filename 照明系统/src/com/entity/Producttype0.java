package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Producttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "producttype", schema = "dbo", catalog = "NewLightSystem")
public class Producttype0 implements java.io.Serializable {

	// Fields

	private Integer producttypeid;
	private String producttypename;
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public Producttype0() {
	}

	/** minimal constructor */
	public Producttype0(String producttypename) {
		this.producttypename = producttypename;
	}

	/** full constructor */
	public Producttype0(String producttypename, String tablename,
			Set<Product> products) {
		this.producttypename = producttypename;
		this.products = products;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "producttypeid", unique = true, nullable = false)
	public Integer getProducttypeid() {
		return this.producttypeid;
	}

	public void setProducttypeid(Integer producttypeid) {
		this.producttypeid = producttypeid;
	}

	@Column(name = "producttypename", nullable = false, length = 50)
	public String getProducttypename() {
		return this.producttypename;
	}

	public void setProducttypename(String producttypename) {
		this.producttypename = producttypename;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "producttype")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}