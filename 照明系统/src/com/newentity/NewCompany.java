package com.newentity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", schema = "dbo", catalog = "newlightsystem")

public class NewCompany implements java.io.Serializable {

	// Fields

	private Integer companyid;
	private Double money;
	private Double frozenmoney;
	private String paypassword;
	private String companyname;
	private String managername;
	private String managerphone;
	private String idcardpicture;
	private String companylicensepicture;
	private String companypicture;
	private Double longitude;
	private Double latitude;
	private String province;
	private String city;
	private String district;
	private String detailaddress;
	private String email;
	private String fixphone;
	private Timestamp birthday;
	private String zipcode;
	private Integer state;
	private Set<NewOrderinfo> orderinfos = new HashSet<NewOrderinfo>(0);
	private Set<NewPoint> points = new HashSet<NewPoint>(0);
	private Set<NewFavorite> favorites = new HashSet<NewFavorite>(0);
	private Set<NewInventory> inventories = new HashSet<NewInventory>(0);
	private Set<NewCartdetail> cartdetails = new HashSet<NewCartdetail>(0);
	private Set<NewWalletserial> walletserials = new HashSet<NewWalletserial>(0);
	private Set<NewAddress> addresses = new HashSet<NewAddress>(0);
	private Set<NewComment> comments = new HashSet<NewComment>(0);

	// Constructors

	/** default constructor */
	public NewCompany() {
	}

	/** minimal constructor */
	public NewCompany(Integer companyid, Integer state) {
		this.companyid = companyid;
		this.state = state;
	}

	/** full constructor */
	public NewCompany(Integer companyid, Double money, Double frozenmoney, String paypassword, String companyname,
			String managername, String managerphone, String idcardpicture, String companylicensepicture,
			String companypicture, Double longitude, Double latitude, String province, String city, String district,
			String detailaddress, String email, String fixphone, Timestamp birthday, String zipcode, Integer state,
			Set<NewOrderinfo> orderinfos, Set<NewPoint> points, Set<NewFavorite> favorites, Set<NewInventory> inventories,
			Set<NewCartdetail> cartdetails, Set<NewWalletserial> walletserials, Set<NewAddress> addresses,
			Set<NewComment> comments) {
		this.companyid = companyid;
		this.money = money;
		this.frozenmoney = frozenmoney;
		this.paypassword = paypassword;
		this.companyname = companyname;
		this.managername = managername;
		this.managerphone = managerphone;
		this.idcardpicture = idcardpicture;
		this.companylicensepicture = companylicensepicture;
		this.companypicture = companypicture;
		this.longitude = longitude;
		this.latitude = latitude;
		this.province = province;
		this.city = city;
		this.district = district;
		this.detailaddress = detailaddress;
		this.email = email;
		this.fixphone = fixphone;
		this.birthday = birthday;
		this.zipcode = zipcode;
		this.state = state;
		this.orderinfos = orderinfos;
		this.points = points;
		this.favorites = favorites;
		this.inventories = inventories;
		this.cartdetails = cartdetails;
		this.walletserials = walletserials;
		this.addresses = addresses;
		this.comments = comments;
	}

	// Property accessors
	@Id

	@Column(name = "companyid", unique = true, nullable = false)

	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	@Column(name = "money", precision = 53, scale = 0)

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "frozenmoney", precision = 53, scale = 0)

	public Double getFrozenmoney() {
		return this.frozenmoney;
	}

	public void setFrozenmoney(Double frozenmoney) {
		this.frozenmoney = frozenmoney;
	}

	@Column(name = "paypassword", length = 50)

	public String getPaypassword() {
		return this.paypassword;
	}

	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}

	@Column(name = "companyname", length = 50)

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Column(name = "managername", length = 50)

	public String getManagername() {
		return this.managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	@Column(name = "managerphone", length = 50)

	public String getManagerphone() {
		return this.managerphone;
	}

	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}

	@Column(name = "idcardpicture")

	public String getIdcardpicture() {
		return this.idcardpicture;
	}

	public void setIdcardpicture(String idcardpicture) {
		this.idcardpicture = idcardpicture;
	}

	@Column(name = "companylicensepicture")

	public String getCompanylicensepicture() {
		return this.companylicensepicture;
	}

	public void setCompanylicensepicture(String companylicensepicture) {
		this.companylicensepicture = companylicensepicture;
	}

	@Column(name = "companypicture")

	public String getCompanypicture() {
		return this.companypicture;
	}

	public void setCompanypicture(String companypicture) {
		this.companypicture = companypicture;
	}

	@Column(name = "longitude", precision = 53, scale = 0)

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", precision = 53, scale = 0)

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "province", length = 50)

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 50)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "district", length = 50)

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "detailaddress", length = 200)

	public String getDetailaddress() {
		return this.detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	@Column(name = "email", length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fixphone", length = 50)

	public String getFixphone() {
		return this.fixphone;
	}

	public void setFixphone(String fixphone) {
		this.fixphone = fixphone;
	}

	@Column(name = "birthday", length = 23)

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "zipcode", length = 50)

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "state", nullable = false)

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewOrderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<NewOrderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewPoint> getPoints() {
		return this.points;
	}

	public void setPoints(Set<NewPoint> points) {
		this.points = points;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewFavorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<NewFavorite> favorites) {
		this.favorites = favorites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewInventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<NewInventory> inventories) {
		this.inventories = inventories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewCartdetail> getCartdetails() {
		return this.cartdetails;
	}

	public void setCartdetails(Set<NewCartdetail> cartdetails) {
		this.cartdetails = cartdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewWalletserial> getWalletserials() {
		return this.walletserials;
	}

	public void setWalletserials(Set<NewWalletserial> walletserials) {
		this.walletserials = walletserials;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewAddress> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<NewAddress> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")

	public Set<NewComment> getComments() {
		return this.comments;
	}

	public void setComments(Set<NewComment> comments) {
		this.comments = comments;
	}

}