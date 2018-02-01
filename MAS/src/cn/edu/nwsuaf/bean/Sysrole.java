package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Sysrole entity. @author MyEclipse Persistence Tools
 */

public class Sysrole implements java.io.Serializable {

	// Fields

	private String roleCode;
	private String roleName;
	private String roleDescription;
	private Integer state;
	private Set sysrolejuris = new HashSet(0);
	private Set sysrolejuris_1 = new HashSet(0);
	private Set sysuserinfos = new HashSet(0);
	private Set sysuserinfos_1 = new HashSet(0);
	private Set sysrolejuris_2 = new HashSet(0);
	private Set sysuserinfos_2 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sysrole() {
	}

	/** minimal constructor */
	public Sysrole(String roleCode) {
		this.roleCode = roleCode;
	}

	/** full constructor */
	public Sysrole(String roleCode, String roleName, String roleDescription,
			Integer state, Set sysrolejuris, Set sysrolejuris_1,
			Set sysuserinfos, Set sysuserinfos_1, Set sysrolejuris_2,
			Set sysuserinfos_2) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.state = state;
		this.sysrolejuris = sysrolejuris;
		this.sysrolejuris_1 = sysrolejuris_1;
		this.sysuserinfos = sysuserinfos;
		this.sysuserinfos_1 = sysuserinfos_1;
		this.sysrolejuris_2 = sysrolejuris_2;
		this.sysuserinfos_2 = sysuserinfos_2;
	}

	// Property accessors

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getSysrolejuris() {
		return this.sysrolejuris;
	}

	public void setSysrolejuris(Set sysrolejuris) {
		this.sysrolejuris = sysrolejuris;
	}

	public Set getSysrolejuris_1() {
		return this.sysrolejuris_1;
	}

	public void setSysrolejuris_1(Set sysrolejuris_1) {
		this.sysrolejuris_1 = sysrolejuris_1;
	}

	public Set getSysuserinfos() {
		return this.sysuserinfos;
	}

	public void setSysuserinfos(Set sysuserinfos) {
		this.sysuserinfos = sysuserinfos;
	}

	public Set getSysuserinfos_1() {
		return this.sysuserinfos_1;
	}

	public void setSysuserinfos_1(Set sysuserinfos_1) {
		this.sysuserinfos_1 = sysuserinfos_1;
	}

	public Set getSysrolejuris_2() {
		return this.sysrolejuris_2;
	}

	public void setSysrolejuris_2(Set sysrolejuris_2) {
		this.sysrolejuris_2 = sysrolejuris_2;
	}

	public Set getSysuserinfos_2() {
		return this.sysuserinfos_2;
	}

	public void setSysuserinfos_2(Set sysuserinfos_2) {
		this.sysuserinfos_2 = sysuserinfos_2;
	}

}