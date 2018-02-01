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
 * Favorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favorite", schema = "dbo", catalog = "NewLightSystem")
public class Favorite implements java.io.Serializable {

	// Fields

	private Integer favoriteid;
	private Company company;
	private Product product;
	private Timestamp collectiontime;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** minimal constructor */
	public Favorite(Company company, Product product) {
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public Favorite(Company company, Product product, Timestamp collectiontime) {
		this.company = company;
		this.product = product;
		this.collectiontime = collectiontime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "favoriteid", unique = true, nullable = false)
	public Integer getFavoriteid() {
		return this.favoriteid;
	}

	public void setFavoriteid(Integer favoriteid) {
		this.favoriteid = favoriteid;
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

	@Column(name = "collectiontime", length = 23)
	public Timestamp getCollectiontime() {
		return this.collectiontime;
	}

	public void setCollectiontime(Timestamp collectiontime) {
		this.collectiontime = collectiontime;
	}

}