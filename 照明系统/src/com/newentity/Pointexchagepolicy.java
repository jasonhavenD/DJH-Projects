package com.newentity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Pointexchagepolicy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pointexchagepolicy", schema = "dbo", catalog = "newlightsystem")

public class Pointexchagepolicy implements java.io.Serializable {

	// Fields

	private PointexchagepolicyId id;

	// Constructors

	/** default constructor */
	public Pointexchagepolicy() {
	}

	/** full constructor */
	public Pointexchagepolicy(PointexchagepolicyId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pointexchangeid", column = @Column(name = "pointexchangeid", nullable = false) ),
			@AttributeOverride(name = "pointtomoney", column = @Column(name = "pointtomoney", nullable = false, precision = 53, scale = 0) ) })

	public PointexchagepolicyId getId() {
		return this.id;
	}

	public void setId(PointexchagepolicyId id) {
		this.id = id;
	}

}