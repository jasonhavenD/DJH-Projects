package com.newentity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PointexchagepolicyId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class PointexchagepolicyId implements java.io.Serializable {

	// Fields

	private Integer pointexchangeid;
	private Double pointtomoney;

	// Constructors

	/** default constructor */
	public PointexchagepolicyId() {
	}

	/** full constructor */
	public PointexchagepolicyId(Integer pointexchangeid, Double pointtomoney) {
		this.pointexchangeid = pointexchangeid;
		this.pointtomoney = pointtomoney;
	}

	// Property accessors

	@Column(name = "pointexchangeid", nullable = false)

	public Integer getPointexchangeid() {
		return this.pointexchangeid;
	}

	public void setPointexchangeid(Integer pointexchangeid) {
		this.pointexchangeid = pointexchangeid;
	}

	@Column(name = "pointtomoney", nullable = false, precision = 53, scale = 0)

	public Double getPointtomoney() {
		return this.pointtomoney;
	}

	public void setPointtomoney(Double pointtomoney) {
		this.pointtomoney = pointtomoney;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PointexchagepolicyId))
			return false;
		PointexchagepolicyId castOther = (PointexchagepolicyId) other;

		return ((this.getPointexchangeid() == castOther.getPointexchangeid())
				|| (this.getPointexchangeid() != null && castOther.getPointexchangeid() != null
						&& this.getPointexchangeid().equals(castOther.getPointexchangeid())))
				&& ((this.getPointtomoney() == castOther.getPointtomoney())
						|| (this.getPointtomoney() != null && castOther.getPointtomoney() != null
								&& this.getPointtomoney().equals(castOther.getPointtomoney())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPointexchangeid() == null ? 0 : this.getPointexchangeid().hashCode());
		result = 37 * result + (getPointtomoney() == null ? 0 : this.getPointtomoney().hashCode());
		return result;
	}

}