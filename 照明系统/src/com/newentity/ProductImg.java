package com.newentity;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductImg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_img", schema = "dbo", catalog = "NewLightSystem")
public class ProductImg implements java.io.Serializable {

	// Fields

	private Integer productimgid;
	private Integer productid;
	private Integer imgtype;
	private String imgurl;
	

	// Constructors

	/** default constructor */
	public ProductImg() {
	}

	/** minimal constructor */
	public ProductImg(Integer productimgid) {
		this.productimgid = productimgid;
	}

	/** full constructor */
	public ProductImg(Integer productimgid, Integer productid, Integer imgtype,
			String imgurl) {
		this.productimgid = productimgid;
		this.productid = productid;
		this.imgtype = imgtype;
		this.imgurl = imgurl;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productimgid", unique = true, nullable = false)
	public Integer getProductimgid() {
		return this.productimgid;
	}

	public void setProductimgid(Integer productimgid) {
		this.productimgid = productimgid;
	}

	@Column(name = "productid")
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "imgtype")
	public Integer getImgtype() {
		return this.imgtype;
	}

	public void setImgtype(Integer imgtype) {
		this.imgtype = imgtype;
	}

	@Column(name = "imgurl", length = 100)
	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}