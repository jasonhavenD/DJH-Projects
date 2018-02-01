package com.entity;

import java.sql.Timestamp;
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
import javax.persistence.Table;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderinfo", schema = "dbo", catalog = "NewLightSystem")
public class Orderinfo implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Company company;//客户
	private String deliverycompany;//物流公司
	private String deliveryid;//订单号
	private Address address;//地址
	private Integer oderstate;//订单状态 待付款1,待发货2,待收货3，完成4，已取消5
	private Double usedpoints;//使用积分
	private Double usedwalletamount;//平台钱包
	private Double usedthirdpayment;//第三方支付
	private Double lastprice;//总价格，成交价格
	private String invoicetitle;//发票抬头
	private Timestamp createdatetime;//创建日期
	private Timestamp paydatetime;//支付日期
	private Timestamp startdeliverytime;//开始发货时间
	private Timestamp finishidatetime;//收货日期
	private Integer deliverycycle;//交货周期
	private String comments;//备注信息
	private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);
	private Set<Walletserial> walletserials = new HashSet<Walletserial>(0);

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** minimal constructor */
	public Orderinfo(Company company, Address address) {
		this.company = company;
		this.address = address;
	}

	/** full constructor */
	public Orderinfo(Company company, Address address, Integer oderstate,
			Double usedpoints, Double usedwalletamount,
			Double usedthirdpayment, Double lastprice, String invoicetitle,
			Timestamp createdatetime, Timestamp paydatetime,
			Timestamp finishidatetime, Integer deliverycycle, String comments,
			Set<Orderdetail> orderdetails, Set<Walletserial> walletserials) {
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
		this.orderdetails = orderdetails;
		this.walletserials = walletserials;
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
	@JoinColumn(name = "companyid", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressid", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderinfo")
	public Set<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderinfo")
	public Set<Walletserial> getWalletserials() {
		return this.walletserials;
	}

	public void setWalletserials(Set<Walletserial> walletserials) {
		this.walletserials = walletserials;
	}

	public String getDeliverycompany() {
		return deliverycompany;
	}

	public void setDeliverycompany(String deliverycompany) {
		this.deliverycompany = deliverycompany;
	}

	public String getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}

	public Timestamp getStartdeliverytime() {
		return startdeliverytime;
	}

	public void setStartdeliverytime(Timestamp startdeliverytime) {
		this.startdeliverytime = startdeliverytime;
	}

}