package com.newentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", schema = "dbo", catalog = "newlightsystem")

public class NewComment implements java.io.Serializable {

	// Fields

	private Integer commentid;
	private NewCompany company;
	private NewProduct product;
	private Integer state;
	private String commentcontent;

	// Constructors

	/** default constructor */
	public NewComment() {
	}

	/** minimal constructor */
	public NewComment(Integer commentid, NewCompany company, NewProduct product) {
		this.commentid = commentid;
		this.company = company;
		this.product = product;
	}

	/** full constructor */
	public NewComment(Integer commentid, NewCompany company, NewProduct product, Integer state, String commentcontent) {
		this.commentid = commentid;
		this.company = company;
		this.product = product;
		this.state = state;
		this.commentcontent = commentcontent;
	}

	// Property accessors
	@Id

	@Column(name = "commentid", unique = true, nullable = false)

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
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

	@Column(name = "state")

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "commentcontent", length = 200)

	public String getCommentcontent() {
		return this.commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

}