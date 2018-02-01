package com.newentity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "address", schema = "dbo", catalog = "newlightsystem")

public class NewAddress implements java.io.Serializable {

	// Fields

	private Integer addressid;
	private NewCompany company;
	private Integer isdefault;
	private String consigneename;
	private String consigneeaddress;
	private String consigneephone;
	private String zipcode;
	private Set<NewOrderinfo> orderinfos = new HashSet<NewOrderinfo>(0);

	// Constructors

	/** default constructor */
	public NewAddress() {
	}

	/** minimal constructor */
	public NewAddress(Integer addressid, NewCompany company, String consigneename, String consigneeaddress,
			String consigneephone, String zipcode) {
		this.addressid = addressid;
		this.company = company;
		this.consigneename = consigneename;
		this.consigneeaddress = consigneeaddress;
		this.consigneephone = consigneephone;
		this.zipcode = zipcode;
	}

	/** full constructor */
	public NewAddress(Integer addressid, NewCompany company, Integer isdefault, String consigneename, String consigneeaddress,
			String consigneephone, String zipcode, Set<NewOrderinfo> orderinfos) {
		this.addressid = addressid;
		this.company = company;
		this.isdefault = isdefault;
		this.consigneename = consigneename;
		this.consigneeaddress = consigneeaddress;
		this.consigneephone = consigneephone;
		this.zipcode = zipcode;
		this.orderinfos = orderinfos;
	}

	// Property accessors
	@Id

	@Column(name = "addressid", unique = true, nullable = false)

	public Integer getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)

	public NewCompany getCompany() {
		return this.company;
	}

	public void setCompany(NewCompany company) {
		this.company = company;
	}

	@Column(name = "isdefault")

	public Integer getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}

	@Column(name = "consigneename", nullable = false, length = 50)

	public String getConsigneename() {
		return this.consigneename;
	}

	public void setConsigneename(String consigneename) {
		this.consigneename = consigneename;
	}

	@Column(name = "consigneeaddress", nullable = false, length = 100)

	public String getConsigneeaddress() {
		return this.consigneeaddress;
	}

	public void setConsigneeaddress(String consigneeaddress) {
		this.consigneeaddress = consigneeaddress;
	}

	@Column(name = "consigneephone", nullable = false, length = 50)

	public String getConsigneephone() {
		return this.consigneephone;
	}

	public void setConsigneephone(String consigneephone) {
		this.consigneephone = consigneephone;
	}

	@Column(name = "zipcode", nullable = false, length = 10)

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")

	public Set<NewOrderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<NewOrderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

}