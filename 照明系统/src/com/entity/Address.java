package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Address implements java.io.Serializable {
	// Fields

	private Integer addressid;
	private Company company;
	private Integer isdefault;
	private String consigneename;
	private String consigneeaddress;
	private String consigneephone;
	private String zipcode;
	private Set<Orderinfo> orderinfos = new HashSet<Orderinfo>(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Company company, String consigneename,
			String consigneeaddress, String consigneephone, String zipcode) {
		this.company = company;
		this.consigneename = consigneename;
		this.consigneeaddress = consigneeaddress;
		this.consigneephone = consigneephone;
		this.zipcode = zipcode;
	}

	/** full constructor */
	public Address(Company company, Integer isdefault, String consigneename,
			String consigneeaddress, String consigneephone, String zipcode,
			Set<Orderinfo> orderinfos) {
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "addressid", unique = true, nullable = false)
	public Integer getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "address")
	public Set<Orderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<Orderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

}