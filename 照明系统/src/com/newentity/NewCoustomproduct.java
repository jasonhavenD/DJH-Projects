package com.newentity;

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
@Table(name = "coustomproduct", schema = "dbo", catalog = "newlightsystem")

public class NewCoustomproduct implements java.io.Serializable {

	// Fields

	private NewCoustomproductId id;

	// Constructors

	/** default constructor */
	public NewCoustomproduct() {
	}

	/** full constructor */
	public NewCoustomproduct(NewCoustomproductId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "productid", column = @Column(name = "productid") ),
			@AttributeOverride(name = "customkey", column = @Column(name = "customkey", length = 100) ),
			@AttributeOverride(name = "customvalue", column = @Column(name = "customvalue", length = 100) ) })

	public NewCoustomproductId getId() {
		return this.id;
	}

	public void setId(NewCoustomproductId id) {
		this.id = id;
	}

}