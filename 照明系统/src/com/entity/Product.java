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
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", schema = "dbo", catalog = "NewLightSystem")
public class Product implements java.io.Serializable {

	// Fields

	private Integer productid;
	private Producttype0 producttype;
	private String productname;
	private String productpicture;
	private String productdiscribe;
	private Double price;
	private Double certifiedprice;
	private Double logisticsprice;
	private Integer sendpoints;
	private Integer issale;//是否上架
	private Integer issnapup;//是否限时抢购
	private Integer isgroupon;//是否团购
	private Integer iscrowdfunding;//众筹预售
	private Integer ishot;//是否热卖
	private Integer isnew;//是否新品
	private Integer isrecommend;//是否推荐
	private Integer ispromotion;//是否促销
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
	private String inventoryquantity;
	private Set<Point> points = new HashSet<Point>(0);
	private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);
	private Set<Favorite> favorites = new HashSet<Favorite>(0);
	private Set<Cartdetail> cartdetails = new HashSet<Cartdetail>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Inventory> inventories = new HashSet<Inventory>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}
	public Product(Integer productid){
		this.productid = productid;
	}
	/** minimal constructor */
	public Product(Producttype0 producttype, String productname,
			String productpicture, String productdiscribe, Double price,
			Double certifiedprice, Double logisticsprice, Integer sendpoints) {
		this.producttype = producttype;
		this.productname = productname;
		this.productpicture = productpicture;
		this.productdiscribe = productdiscribe;
		this.price = price;
		this.certifiedprice = certifiedprice;
		this.logisticsprice = logisticsprice;
		this.sendpoints = sendpoints;
	}

	/** full constructor */
	public Product(Producttype0 producttype, String productname,
			String productpicture, String productdiscribe, Double price,
			Double certifiedprice, Double logisticsprice, Integer sendpoints,
			Integer issale, Integer issnapup, Integer isgroupon,
			Integer iscrowdfunding, Integer ishot, Integer isnew,
			Integer isrecommend, Integer ispromotion,
			Timestamp snapupstarttime, Timestamp snapupendtime,
			Double snapupprice, Double snapupcertifiedprice,
			Double snapuplogisticsprice, Integer snapupquantity,
			Integer grouponstartquantity, Timestamp grouponstarttime,
			Timestamp grouponendtime, Double grouponprice,
			Double grouponcertifiedprice, Double grouponlogisticsprice,
			Integer grouponquantity, Integer crowfundingstartquantity,
			Integer crowfundingdepositrate, Timestamp crowfundingstarttime,
			Timestamp crowfundingendtime, Double crowfundingprice,
			Double crowfundingcertifiedprice, Double crowfundinglogisticsprice,
			Integer crowfundingquantity, Set<Point> points,
			Set<Orderdetail> orderdetails, Set<Favorite> favorites,
			Set<Cartdetail> cartdetails, Set<Comment> comments,
			Set<Inventory> inventories) {
		this.producttype = producttype;
		this.productname = productname;
		this.productpicture = productpicture;
		this.productdiscribe = productdiscribe;
		this.price = price;
		this.certifiedprice = certifiedprice;
		this.logisticsprice = logisticsprice;
		this.sendpoints = sendpoints;
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
		this.points = points;
		this.orderdetails = orderdetails;
		this.favorites = favorites;
		this.cartdetails = cartdetails;
		this.comments = comments;
		this.inventories = inventories;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productid", unique = true, nullable = false)
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producttypeid", nullable = false)
	public Producttype0 getProducttype() {
		return this.producttype;
	}

	public void setProducttype(Producttype0 producttype) {
		this.producttype = producttype;
	}

	@Column(name = "productname", nullable = false, length = 50)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "productpicture", nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Point> getPoints() {
		return this.points;
	}

	public void setPoints(Set<Point> points) {
		this.points = points;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Cartdetail> getCartdetails() {
		return this.cartdetails;
	}

	public void setCartdetails(Set<Cartdetail> cartdetails) {
		this.cartdetails = cartdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	public String getInventoryquantity() {
		return inventoryquantity;
	}

	public void setInventoryquantity(String inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}

	@Override
	public String toString() {
		return "Product [certifiedprice=" + certifiedprice 
				+ ", crowfundingcertifiedprice=" + crowfundingcertifiedprice
				+ ", crowfundingdepositrate=" + crowfundingdepositrate
				+ ", crowfundingendtime=" + crowfundingendtime
				+ ", crowfundinglogisticsprice=" + crowfundinglogisticsprice
				+ ", crowfundingprice=" + crowfundingprice
				+ ", crowfundingquantity=" + crowfundingquantity
				+ ", crowfundingstartquantity=" + crowfundingstartquantity
				+ ", crowfundingstarttime=" + crowfundingstarttime
				 + ", grouponcertifiedprice="
				+ grouponcertifiedprice + ", grouponendtime=" + grouponendtime
				+ ", grouponlogisticsprice=" + grouponlogisticsprice
				+ ", grouponprice=" + grouponprice + ", grouponquantity="
				+ grouponquantity + ", grouponstartquantity="
				+ grouponstartquantity + ", grouponstarttime="
				+ grouponstarttime + ", iscrowdfunding=" + iscrowdfunding + ", isgroupon="
				+ isgroupon + ", ishot=" + ishot + ", isnew=" + isnew
				+ ", ispromotion=" + ispromotion + ", isrecommend="
				+ isrecommend + ", issale=" + issale + ", issnapup=" + issnapup
				+ ", logisticsprice=" + logisticsprice + ", price=" + price
				+ ", productdiscribe=" + productdiscribe + ", productid="
				+ productid + ", productname=" + productname
				+ ", productpicture=" + productpicture + ", producttype="
				+ producttype + ", sendpoints=" + sendpoints
				+ ", snapupcertifiedprice=" + snapupcertifiedprice
				+ ", snapupendtime=" + snapupendtime
				+ ", snapuplogisticsprice=" + snapuplogisticsprice
				+ ", snapupprice=" + snapupprice + ", snapupquantity="
				+ snapupquantity + ", snapupstarttime=" + snapupstarttime + "]";
	}

}