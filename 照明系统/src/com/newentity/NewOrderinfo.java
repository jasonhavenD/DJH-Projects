package com.newentity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderinfo", schema = "dbo", catalog = "newlightsystem")

public class NewOrderinfo implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private NewCompany company;
	private NewAddress address;
	private Integer oderstate;
	private Double usedpoints;
	private Double usedwalletamount;
	private Double usedthirdpayment;
	private Double lastprice;
	private String invoicetitle;
	private Timestamp createdatetime;
	private Timestamp paydatetime;
	private Timestamp finishidatetime;
	private Integer deliverycycle;
	private String comments;
	private String deliveryid;
	private Timestamp startdeliverytime;
	private String deliverycompany;
	private Set<NewWalletserial> walletserials = new HashSet<NewWalletserial>(0);
	private Set<NewOrderdetail> orderdetails = new HashSet<NewOrderdetail>(0);

	// Constructors

	/** default constructor */
	public NewOrderinfo() {
	}

	/** minimal constructor */
	public NewOrderinfo(Integer orderid, NewAddress address) {
		this.orderid = orderid;
		this.address = address;
	}

	/** full constructor */
	public NewOrderinfo(Integer orderid, NewCompany company, NewAddress address, Integer oderstate, Double usedpoints,
			Double usedwalletamount, Double usedthirdpayment, Double lastprice, String invoicetitle,
			Timestamp createdatetime, Timestamp paydatetime, Timestamp finishidatetime, Integer deliverycycle,
			String comments, String deliveryid, Timestamp startdeliverytime, String deliverycompany,
			Set<NewWalletserial> walletserials, Set<NewOrderdetail> orderdetails) {
		this.orderid = orderid;
		this.company = company;
		this.address = address;
		this.oderstate = oderstate;
		this.usedpoints = usedpoints;
		this.usedwalletamount = usedwalletamount;
		this.usedthirdpayment = usedthirdpayment;
		this.lastprice = lastprice;
		this.invoicetitle = invoicetitle;
		this.createdatetime = createdatetime;
		this.paydatetime = paydatetime;
		this.finishidatetime = finishidatetime;
		this.deliverycycle = deliverycycle;
		this.comments = comments;
		this.deliveryid = deliveryid;
		this.startdeliverytime = startdeliverytime;
		this.deliverycompany = deliverycompany;
		this.walletserials = walletserials;
		this.orderdetails = orderdetails;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderid", unique = true, nullable = false)

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyid")

	public NewCompany getCompany() {
		return this.company;
	}

	public void setCompany(NewCompany company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressid", nullable = false)

	public NewAddress getAddress() {
		return this.address;
	}

	public void setAddress(NewAddress address) {
		this.address = address;
	}

	@Column(name = "oderstate")

	public Integer getOderstate() {
		return this.oderstate;
	}

	public void setOderstate(Integer oderstate) {
		this.oderstate = oderstate;
	}

	@Column(name = "usedpoints", precision = 53, scale = 0)

	public Double getUsedpoints() {
		return this.usedpoints;
	}

	public void setUsedpoints(Double usedpoints) {
		this.usedpoints = usedpoints;
	}

	@Column(name = "usedwalletamount", precision = 53, scale = 0)

	public Double getUsedwalletamount() {
		return this.usedwalletamount;
	}

	public void setUsedwalletamount(Double usedwalletamount) {
		this.usedwalletamount = usedwalletamount;
	}

	@Column(name = "usedthirdpayment", precision = 53, scale = 0)

	public Double getUsedthirdpayment() {
		return this.usedthirdpayment;
	}

	public void setUsedthirdpayment(Double usedthirdpayment) {
		this.usedthirdpayment = usedthirdpayment;
	}

	@Column(name = "lastprice", precision = 53, scale = 0)

	public Double getLastprice() {
		return this.lastprice;
	}

	public void setLastprice(Double lastprice) {
		this.lastprice = lastprice;
	}

	@Column(name = "invoicetitle", length = 100)

	public String getInvoicetitle() {
		return this.invoicetitle;
	}

	public void setInvoicetitle(String invoicetitle) {
		this.invoicetitle = invoicetitle;
	}

	@Column(name = "createdatetime", length = 23)

	public Timestamp getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "paydatetime", length = 23)

	public Timestamp getPaydatetime() {
		return this.paydatetime;
	}

	public void setPaydatetime(Timestamp paydatetime) {
		this.paydatetime = paydatetime;
	}

	@Column(name = "finishidatetime", length = 23)

	public Timestamp getFinishidatetime() {
		return this.finishidatetime;
	}

	public void setFinishidatetime(Timestamp finishidatetime) {
		this.finishidatetime = finishidatetime;
	}

	@Column(name = "deliverycycle")

	public Integer getDeliverycycle() {
		return this.deliverycycle;
	}

	public void setDeliverycycle(Integer deliverycycle) {
		this.deliverycycle = deliverycycle;
	}

	@Column(name = "comments", length = 50)

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "deliveryid", length = 50)

	public String getDeliveryid() {
		return this.deliveryid;
	}

	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}

	@Column(name = "startdeliverytime", length = 23)

	public Timestamp getStartdeliverytime() {
		return this.startdeliverytime;
	}

	public void setStartdeliverytime(Timestamp startdeliverytime) {
		this.startdeliverytime = startdeliverytime;
	}

	@Column(name = "deliverycompany", length = 100)

	public String getDeliverycompany() {
		return this.deliverycompany;
	}

	public void setDeliverycompany(String deliverycompany) {
		this.deliverycompany = deliverycompany;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderinfo")

	public Set<NewWalletserial> getWalletserials() {
		return this.walletserials;
	}

	public void setWalletserials(Set<NewWalletserial> walletserials) {
		this.walletserials = walletserials;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderinfo")

	public Set<NewOrderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<NewOrderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

}