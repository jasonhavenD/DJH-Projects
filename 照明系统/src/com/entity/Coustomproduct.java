package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Coustomproduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "coustomproduct", schema = "dbo", catalog = "NewLightSystem")
public class Coustomproduct implements java.io.Serializable {

	// Fields

	private CoustomproductId id;

	// Constructors

	/** default constructor */
	public Coustomproduct() {
	}

	/** full constructor */
	public Coustomproduct(CoustomproductId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "productid", column = @Column(name = "productid")),
			@AttributeOverride(name = "customkey", column = @Column(name = "customkey", length = 50)),
			@AttributeOverride(name = "customvalue", column = @Column(name = "customvalue", length = 50)) })
	public CoustomproductId getId() {
		return this.id;
	}

	public void setId(CoustomproductId id) {
		this.id = id;
	}

}