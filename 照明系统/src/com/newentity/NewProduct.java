package com.newentity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import javax.persistence.Transient;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", schema = "dbo", catalog = "newlightsystem")

public class NewProduct implements java.io.Serializable {

	// Fields

	private Integer productid;
	private NewProducttype producttype;
	private String productname;
	private String productpicture;
	private String productdiscribe;
	private Double price;//普通经销商的价格
	private Double certifiedprice;//认证经销商的价格
	private Double logisticsprice;//物流中心的价格
	private Integer sendpoints;
	private String inventoryquantity;
	private Integer issale;
	private Integer issnapup;
	private Integer isgroupon;
	private Integer iscrowdfunding;
	private Integer ishot;
	private Integer isnew;
	private Integer isrecommend;
	private Integer ispromotion;
	private Timestamp snapupstarttime;
	private Timestamp snapupendtime;
	private Double snapupprice;
	private Double snapupcertifiedprice;
	private Double snapuplogisticsprice;
	private Integer snapupquantity;
	private Integer grouponstartquantity;
	private Timestamp grouponstarttime;
	private Timestamp grouponendtime;
	private Double grouponprice;
	private Double grouponcertifiedprice;
	private Double grouponlogisticsprice;
	private Integer grouponquantity;
	private Integer crowfundingstartquantity;
	private Integer crowfundingdepositrate;
	private Timestamp crowfundingstarttime;
	private Timestamp crowfundingendtime;
	private Double crowfundingprice;
	private Double crowfundingcertifiedprice;
	private Double crowfundinglogisticsprice;
	private Integer crowfundingquantity;
	private Set<NewFavorite> favorites = new HashSet<NewFavorite>(0);
	private Set<NewComment> comments = new HashSet<NewComment>(0);
	private Set<NewInventory> inventories = new HashSet<NewInventory>(0);
	private Set<NewPoint> points = new HashSet<NewPoint>(0);
	private Set<NewOrderdetail> orderdetails = new HashSet<NewOrderdetail>(0);
	private Set<NewCartdetail> cartdetails = new HashSet<NewCartdetail>(0);
	private Set<ProductImg> proimgs = new LinkedHashSet<ProductImg>();

	private String openDatetime; //transient
	private String closingDatetime; //transient

	// Constructors

	/** default constructor */
	public NewProduct() {
	}

	/** minimal constructor */
	public NewProduct(Integer productid, NewProducttype producttype, String productname, String productdiscribe, Double price,
			Double certifiedprice, Double logisticsprice, Integer sendpoints) {
		this.productid = productid;
		this.producttype = producttype;
		this.productname = productname;
		this.productdiscribe = productdiscribe;
		this.price = price;
		this.certifiedprice = certifiedprice;
		this.logisticsprice = logisticsprice;
		this.sendpoints = sendpoints;
	}

	/** full constructor */
	public NewProduct(Integer productid, NewProducttype producttype, String productname, String productpicture,
			String productdiscribe, Double price, Double certifiedprice, Double logisticsprice, Integer sendpoints,
			String inventoryquantity, Integer issale, Integer issnapup, Integer isgroupon, Integer iscrowdfunding,
			Integer ishot, Integer isnew, Integer isrecommend, Integer ispromotion, Timestamp snapupstarttime,
			Timestamp snapupendtime, Double snapupprice, Double snapupcertifiedprice, Double snapuplogisticsprice,
			Integer snapupquantity, Integer grouponstartquantity, Timestamp grouponstarttime, Timestamp grouponendtime,
			Double grouponprice, Double grouponcertifiedprice, Double grouponlogisticsprice, Integer grouponquantity,
			Integer crowfundingstartquantity, Integer crowfundingdepositrate, Timestamp crowfundingstarttime,
			Timestamp crowfundingendtime, Double crowfundingprice, Double crowfundingcertifiedprice,
			Double crowfundinglogisticsprice, Integer crowfundingquantity, Set<NewFavorite> favorites,
			Set<NewComment> comments, Set<NewInventory> inventories, Set<NewPoint> points, Set<NewOrderdetail> orderdetails,
			Set<NewCartdetail> cartdetails) {
		this.productid = productid;
		this.producttype = producttype;
		this.productname = productname;
		this.productpicture = productpicture;
		this.productdiscribe = productdiscribe;
		this.price = price;
		this.certifiedprice = certifiedprice;
		this.logisticsprice = logisticsprice;
		this.sendpoints = sendpoints;
		this.inventoryquantity = inventoryquantity;
		this.issale = issale;
		this.issnapup = issnapup;
		this.isgroupon = isgroupon;
		this.iscrowdfunding = iscrowdfunding;
		this.ishot = ishot;
		this.isnew = isnew;
		this.isrecommend = isrecommend;
		this.ispromotion = ispromotion;
		this.snapupstarttime = snapupstarttime;
		this.snapupendtime = snapupendtime;
		this.snapupprice = snapupprice;
		this.snapupcertifiedprice = snapupcertifiedprice;
		this.snapuplogisticsprice = snapuplogisticsprice;
		this.snapupquantity = snapupquantity;
		this.grouponstartquantity = grouponstartquantity;
		this.grouponstarttime = grouponstarttime;
		this.grouponendtime = grouponendtime;
		this.grouponprice = grouponprice;
		this.grouponcertifiedprice = grouponcertifiedprice;
		this.grouponlogisticsprice = grouponlogisticsprice;
		this.grouponquantity = grouponquantity;
		this.crowfundingstartquantity = crowfundingstartquantity;
		this.crowfundingdepositrate = crowfundingdepositrate;
		this.crowfundingstarttime = crowfundingstarttime;
		this.crowfundingendtime = crowfundingendtime;
		this.crowfundingprice = crowfundingprice;
		this.crowfundingcertifiedprice = crowfundingcertifiedprice;
		this.crowfundinglogisticsprice = crowfundinglogisticsprice;
		this.crowfundingquantity = crowfundingquantity;
		this.favorites = favorites;
		this.comments = comments;
		this.inventories = inventories;
		this.points = points;
		this.orderdetails = orderdetails;
		this.cartdetails = cartdetails;
	}

	public NewProduct(Integer productid,String productname,String productpicture, String productdiscribe, Double price) {
		this.productid = productid;
		this.productname = productname;
		this.productdiscribe = productdiscribe;
		this.price = price;
		this.productpicture = productpicture;
		
	}

	public NewProduct(Integer productid, String productname, Double price) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
	}

	// Property accessors
	@Id
	@Column(name = "productid", unique = true, nullable = false)

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producttypeid", nullable = false)

	public NewProducttype getProducttype() {
		return this.producttype;
	}

	public void setProducttype(NewProducttype producttype) {
		this.producttype = producttype;
	}

	@Column(name = "productname", nullable = false, length = 50)

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "productpicture")

	public String getProductpicture() {
		return this.productpicture;
	}

	public void setProductpicture(String productpicture) {
		this.productpicture = productpicture;
	}

	@Column(name = "productdiscribe", nullable = false)

	public String getProductdiscribe() {
		return this.productdiscribe;
	}

	public void setProductdiscribe(String productdiscribe) {
		this.productdiscribe = productdiscribe;
	}

	@Column(name = "price", nullable = false, precision = 53, scale = 0)

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "certifiedprice", nullable = false, precision = 53, scale = 0)

	public Double getCertifiedprice() {
		return this.certifiedprice;
	}

	public void setCertifiedprice(Double certifiedprice) {
		this.certifiedprice = certifiedprice;
	}

	@Column(name = "logisticsprice", nullable = false, precision = 53, scale = 0)

	public Double getLogisticsprice() {
		return this.logisticsprice;
	}

	public void setLogisticsprice(Double logisticsprice) {
		this.logisticsprice = logisticsprice;
	}

	@Column(name = "sendpoints", nullable = false)

	public Integer getSendpoints() {
		return this.sendpoints;
	}

	public void setSendpoints(Integer sendpoints) {
		this.sendpoints = sendpoints;
	}

	@Column(name = "inventoryquantity", length = 10)

	public String getInventoryquantity() {
		return this.inventoryquantity;
	}

	public void setInventoryquantity(String inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}

	@Column(name = "issale")

	public Integer getIssale() {
		return this.issale;
	}

	public void setIssale(Integer issale) {
		this.issale = issale;
	}

	@Column(name = "issnapup")

	public Integer getIssnapup() {
		return this.issnapup;
	}

	public void setIssnapup(Integer issnapup) {
		this.issnapup = issnapup;
	}

	@Column(name = "isgroupon")

	public Integer getIsgroupon() {
		return this.isgroupon;
	}

	public void setIsgroupon(Integer isgroupon) {
		this.isgroupon = isgroupon;
	}

	@Column(name = "iscrowdfunding")

	public Integer getIscrowdfunding() {
		return this.iscrowdfunding;
	}

	public void setIscrowdfunding(Integer iscrowdfunding) {
		this.iscrowdfunding = iscrowdfunding;
	}

	@Column(name = "ishot")

	public Integer getIshot() {
		return this.ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	@Column(name = "isnew")

	public Integer getIsnew() {
		return this.isnew;
	}

	public void setIsnew(Integer isnew) {
		this.isnew = isnew;
	}

	@Column(name = "isrecommend")

	public Integer getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(Integer isrecommend) {
		this.isrecommend = isrecommend;
	}

	@Column(name = "ispromotion")

	public Integer getIspromotion() {
		return this.ispromotion;
	}

	public void setIspromotion(Integer ispromotion) {
		this.ispromotion = ispromotion;
	}

	@Column(name = "snapupstarttime", length = 23)

	public Timestamp getSnapupstarttime() {
		return this.snapupstarttime;
	}

	public void setSnapupstarttime(Timestamp snapupstarttime) {
		this.snapupstarttime = snapupstarttime;
	}

	@Column(name = "snapupendtime", length = 23)

	public Timestamp getSnapupendtime() {
		return this.snapupendtime;
	}

	public void setSnapupendtime(Timestamp snapupendtime) {
		this.snapupendtime = snapupendtime;
	}

	@Column(name = "snapupprice", precision = 53, scale = 0)

	public Double getSnapupprice() {
		return this.snapupprice;
	}

	public void setSnapupprice(Double snapupprice) {
		this.snapupprice = snapupprice;
	}

	@Column(name = "snapupcertifiedprice", precision = 53, scale = 0)

	public Double getSnapupcertifiedprice() {
		return this.snapupcertifiedprice;
	}

	public void setSnapupcertifiedprice(Double snapupcertifiedprice) {
		this.snapupcertifiedprice = snapupcertifiedprice;
	}

	@Column(name = "snapuplogisticsprice", precision = 53, scale = 0)

	public Double getSnapuplogisticsprice() {
		return this.snapuplogisticsprice;
	}

	public void setSnapuplogisticsprice(Double snapuplogisticsprice) {
		this.snapuplogisticsprice = snapuplogisticsprice;
	}

	@Column(name = "snapupquantity")

	public Integer getSnapupquantity() {
		return this.snapupquantity;
	}

	public void setSnapupquantity(Integer snapupquantity) {
		this.snapupquantity = snapupquantity;
	}

	@Column(name = "grouponstartquantity")

	public Integer getGrouponstartquantity() {
		return this.grouponstartquantity;
	}

	public void setGrouponstartquantity(Integer grouponstartquantity) {
		this.grouponstartquantity = grouponstartquantity;
	}

	@Column(name = "grouponstarttime", length = 23)

	public Timestamp getGrouponstarttime() {
		return this.grouponstarttime;
	}

	public void setGrouponstarttime(Timestamp grouponstarttime) {
		this.grouponstarttime = grouponstarttime;
	}

	@Column(name = "grouponendtime", length = 23)

	public Timestamp getGrouponendtime() {
		return this.grouponendtime;
	}

	public void setGrouponendtime(Timestamp grouponendtime) {
		this.grouponendtime = grouponendtime;
	}

	@Column(name = "grouponprice", precision = 53, scale = 0)

	public Double getGrouponprice() {
		return this.grouponprice;
	}

	public void setGrouponprice(Double grouponprice) {
		this.grouponprice = grouponprice;
	}

	@Column(name = "grouponcertifiedprice", precision = 53, scale = 0)

	public Double getGrouponcertifiedprice() {
		return this.grouponcertifiedprice;
	}

	public void setGrouponcertifiedprice(Double grouponcertifiedprice) {
		this.grouponcertifiedprice = grouponcertifiedprice;
	}

	@Column(name = "grouponlogisticsprice", precision = 53, scale = 0)

	public Double getGrouponlogisticsprice() {
		return this.grouponlogisticsprice;
	}

	public void setGrouponlogisticsprice(Double grouponlogisticsprice) {
		this.grouponlogisticsprice = grouponlogisticsprice;
	}

	@Column(name = "grouponquantity")

	public Integer getGrouponquantity() {
		return this.grouponquantity;
	}

	public void setGrouponquantity(Integer grouponquantity) {
		this.grouponquantity = grouponquantity;
	}

	@Column(name = "crowfundingstartquantity")

	public Integer getCrowfundingstartquantity() {
		return this.crowfundingstartquantity;
	}

	public void setCrowfundingstartquantity(Integer crowfundingstartquantity) {
		this.crowfundingstartquantity = crowfundingstartquantity;
	}

	@Column(name = "crowfundingdepositrate")

	public Integer getCrowfundingdepositrate() {
		return this.crowfundingdepositrate;
	}

	public void setCrowfundingdepositrate(Integer crowfundingdepositrate) {
		this.crowfundingdepositrate = crowfundingdepositrate;
	}

	@Column(name = "crowfundingstarttime", length = 23)

	public Timestamp getCrowfundingstarttime() {
		return this.crowfundingstarttime;
	}

	public void setCrowfundingstarttime(Timestamp crowfundingstarttime) {
		this.crowfundingstarttime = crowfundingstarttime;
	}

	@Column(name = "crowfundingendtime", length = 23)

	public Timestamp getCrowfundingendtime() {
		return this.crowfundingendtime;
	}

	public void setCrowfundingendtime(Timestamp crowfundingendtime) {
		this.crowfundingendtime = crowfundingendtime;
	}

	@Column(name = "crowfundingprice", precision = 53, scale = 0)

	public Double getCrowfundingprice() {
		return this.crowfundingprice;
	}

	public void setCrowfundingprice(Double crowfundingprice) {
		this.crowfundingprice = crowfundingprice;
	}

	@Column(name = "crowfundingcertifiedprice", precision = 53, scale = 0)

	public Double getCrowfundingcertifiedprice() {
		return this.crowfundingcertifiedprice;
	}

	public void setCrowfundingcertifiedprice(Double crowfundingcertifiedprice) {
		this.crowfundingcertifiedprice = crowfundingcertifiedprice;
	}

	@Column(name = "crowfundinglogisticsprice", precision = 53, scale = 0)

	public Double getCrowfundinglogisticsprice() {
		return this.crowfundinglogisticsprice;
	}

	public void setCrowfundinglogisticsprice(Double crowfundinglogisticsprice) {
		this.crowfundinglogisticsprice = crowfundinglogisticsprice;
	}

	@Column(name = "crowfundingquantity")

	public Integer getCrowfundingquantity() {
		return this.crowfundingquantity;
	}

	public void setCrowfundingquantity(Integer crowfundingquantity) {
		this.crowfundingquantity = crowfundingquantity;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewFavorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<NewFavorite> favorites) {
		this.favorites = favorites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewComment> getComments() {
		return this.comments;
	}

	public void setComments(Set<NewComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewInventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<NewInventory> inventories) {
		this.inventories = inventories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewPoint> getPoints() {
		return this.points;
	}

	public void setPoints(Set<NewPoint> points) {
		this.points = points;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewOrderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<NewOrderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")

	public Set<NewCartdetail> getCartdetails() {
		return this.cartdetails;
	}

	public void setCartdetails(Set<NewCartdetail> cartdetails) {
		this.cartdetails = cartdetails;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	public Set<ProductImg> getProimgs() {
		return proimgs;
	}

	public void setProimgs(Set<ProductImg> proimgs) {
		this.proimgs = proimgs;
	}
	
	@Transient
	public String getOpenDatetime() {
		return openDatetime;
	}
	public void setOpenDatetime(String openDatetime) {
		this.openDatetime = openDatetime;
	}

	@Transient
	public String getClosingDatetime() {
		return closingDatetime;
	}
	public void setClosingDatetime(String closingDatetime) {
		this.closingDatetime = closingDatetime;
	}

}