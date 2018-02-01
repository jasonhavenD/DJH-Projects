package cn.edu.nwsuaf.bean;

/**
 * Sysrolejuri entity. @author MyEclipse Persistence Tools
 */

public class Sysrolejuri implements java.io.Serializable {

	// Fields

	private Integer roleMenuCode;
	private Sysrole sysrole;
	private Sysfunmodle sysfunmodle;

	// Constructors

	/** default constructor */
	public Sysrolejuri() {
	}

	/** full constructor */
	public Sysrolejuri(Sysrole sysrole, Sysfunmodle sysfunmodle) {
		this.sysrole = sysrole;
		this.sysfunmodle = sysfunmodle;
	}

	// Property accessors

	public Integer getRoleMenuCode() {
		return this.roleMenuCode;
	}

	public void setRoleMenuCode(Integer roleMenuCode) {
		this.roleMenuCode = roleMenuCode;
	}

	public Sysrole getSysrole() {
		return this.sysrole;
	}

	public void setSysrole(Sysrole sysrole) {
		this.sysrole = sysrole;
	}

	public Sysfunmodle getSysfunmodle() {
		return this.sysfunmodle;
	}

	public void setSysfunmodle(Sysfunmodle sysfunmodle) {
		this.sysfunmodle = sysfunmodle;
	}

	@Override
	public String toString() {
		return "Sysrolejuri [roleMenuCode=" + roleMenuCode + ", sysfunmodle="
				+ sysfunmodle + ", sysrole=" + sysrole + "]";
	}

}