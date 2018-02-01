package com.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", schema = "dbo", catalog = "NewLightSystem")
public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userinfoid;
	private String username;
	private String phone;
	private String email;
	private String qq;
	private String weixin;
	private String weibo;
	private String taobao;
	private String zhifubao;
	private String password;
	private Integer membertype;
	private Integer state;
	private Timestamp registerdatetime;
	private Timestamp lastdatetime;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username, String password, Integer membertype) {
		this.username = username;
		this.password = password;
		this.membertype = membertype;
	}

	/** full constructor */
	public Userinfo(String username, String phone, String email, String qq,
			String weixin, String weibo, String taobao, String zhifubao,
			String password, Integer membertype, Integer state,
			Timestamp registerdatetime, Timestamp lastdatetime) {
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.weixin = weixin;
		this.weibo = weibo;
		this.taobao = taobao;
		this.zhifubao = zhifubao;
		this.password = password;
		this.membertype = membertype;
		this.state = state;
		this.registerdatetime = registerdatetime;
		this.lastdatetime = lastdatetime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userinfoid", unique = true, nullable = false)
	public Integer getUserinfoid() {
		return this.userinfoid;
	}

	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "qq", length = 50)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "weixin", length = 50)
	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	@Column(name = "weibo", length = 50)
	public String getWeibo() {
		return this.weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	@Column(name = "taobao", length = 50)
	public String getTaobao() {
		return this.taobao;
	}

	public void setTaobao(String taobao) {
		this.taobao = taobao;
	}

	@Column(name = "zhifubao", length = 50)
	public String getZhifubao() {
		return this.zhifubao;
	}

	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "membertype", nullable = false)
	public Integer getMembertype() {
		return this.membertype;
	}

	public void setMembertype(Integer membertype) {
		this.membertype = membertype;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "registerdatetime", length = 23)
	public Timestamp getRegisterdatetime() {
		return this.registerdatetime;
	}

	public void setRegisterdatetime(Timestamp registerdatetime) {
		this.registerdatetime = registerdatetime;
	}

	@Column(name = "lastdatetime", length = 23)
	public Timestamp getLastdatetime() {
		return this.lastdatetime;
	}

	public void setLastdatetime(Timestamp lastdatetime) {
		this.lastdatetime = lastdatetime;
	}

	@Override
	public String toString() {
		return "Userinfo [email=" + email + ", lastdatetime=" + lastdatetime
				+ ", membertype=" + membertype + ", password=" + password
				+ ", phone=" + phone + ", qq=" + qq + ", registerdatetime="
				+ registerdatetime + ", state=" + state + ", taobao=" + taobao
				+ ", userinfoid=" + userinfoid + ", username=" + username
				+ ", weibo=" + weibo + ", weixin=" + weixin + ", zhifubao="
				+ zhifubao + "]";
	}

}