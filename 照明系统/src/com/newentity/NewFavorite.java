package com.newentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favorite", schema = "dbo", catalog = "newlightsystem")

public class NewFavorite implements java.io.Serializable {

	// Fields

	private Integer favoriteid;
	private NewCompany company;
	private NewProduct product;
	private Timestamp collectiontime;

	// Constructors

	/** default constructor */
	public NewFavorite() {
	}

	/** minimal constructor */
	public NewFavorite(Integer favoriteid, NewCompany company, NewProduct product) {
		this.favoriteid = favoriteid;
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public NewFavorite(Integer favoriteid, NewCompany company, NewProduct product, Timestamp collectiontime) {
		this.favoriteid = favoriteid;
		this.company = company;
		this.product = product;
		this.collectiontime = collectiontime;
	}

	// Property accessors
	@Id

	@Column(name = "favoriteid", unique = true, nullable = false)

	public Integer getFavoriteid() {
		return this.favoriteid;
	}

	public void setFavoriteid(Integer favoriteid) {
		this.favoriteid = favoriteid;
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

	@Column(name = "collectiontime", length = 23)

	public Timestamp getCollectiontime() {
		return this.collectiontime;
	}

	public void setCollectiontime(Timestamp collectiontime) {
		this.collectiontime = collectiontime;
	}

}