package com.newentity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CoustomproductId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class NewCoustomproductId implements java.io.Serializable {

	// Fields

	private Integer productid;
	private String customkey;
	private String customvalue;

	// Constructors

	/** default constructor */
	public NewCoustomproductId() {
	}

	/** full constructor */
	public NewCoustomproductId(Integer productid, String customkey, String customvalue) {
		this.productid = productid;
		this.customkey = customkey;
		this.customvalue = customvalue;
	}

	// Property accessors

	@Column(name = "productid")

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "customkey", length = 100)

	public String getCustomkey() {
		return this.customkey;
	}

	public void setCustomkey(String customkey) {
		this.customkey = customkey;
	}

	@Column(name = "customvalue", length = 100)

	public String getCustomvalue() {
		return this.customvalue;
	}

	public void setCustomvalue(String customvalue) {
		this.customvalue = customvalue;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NewCoustomproductId))
			return false;
		NewCoustomproductId castOther = (NewCoustomproductId) other;

		return ((this.getProductid() == castOther.getProductid()) || (this.getProductid() != null
				&& castOther.getProductid() != null && this.getProductid().equals(castOther.getProductid())))
				&& ((this.getCustomkey() == castOther.getCustomkey()) || (this.getCustomkey() != null
						&& castOther.getCustomkey() != null && this.getCustomkey().equals(castOther.getCustomkey())))
				&& ((this.getCustomvalue() == castOther.getCustomvalue())
						|| (this.getCustomvalue() != null && castOther.getCustomvalue() != null
								&& this.getCustomvalue().equals(castOther.getCustomvalue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductid() == null ? 0 : this.getProductid().hashCode());
		result = 37 * result + (getCustomkey() == null ? 0 : this.getCustomkey().hashCode());
		result = 37 * result + (getCustomvalue() == null ? 0 : this.getCustomvalue().hashCode());
		return result;
	}

}