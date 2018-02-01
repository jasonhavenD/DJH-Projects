package cn.edu.nwsuaf.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Sysfunmodle entity. @author MyEclipse Persistence Tools
 */

public class Sysfunmodle implements java.io.Serializable {

	// Fields

	private String funModleCode;
	private String funParentCode;
	private String funModleName;
	private Integer state;
	private Set sysrolejuris = new HashSet(0);
	private Set sysrolejuris_1 = new HashSet(0);
	private Set sysrolejuris_2 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sysfunmodle() {
	}

	/** minimal constructor */
	public Sysfunmodle(String funModleCode) {
		this.funModleCode = funModleCode;
	}

	/** full constructor */
	public Sysfunmodle(String funModleCode, String funParentCode,
			String funModleName, Integer state, Set sysrolejuris,
			Set sysrolejuris_1, Set sysrolejuris_2) {
		this.funModleCode = funModleCode;
		this.funParentCode = funParentCode;
		this.funModleName = funModleName;
		this.state = state;
		this.sysrolejuris = sysrolejuris;
		this.sysrolejuris_1 = sysrolejuris_1;
		this.sysrolejuris_2 = sysrolejuris_2;
	}

	// Property accessors

	public String getFunModleCode() {
		return this.funModleCode;
	}

	public void setFunModleCode(String funModleCode) {
		this.funModleCode = funModleCode;
	}

	public String getFunParentCode() {
		return this.funParentCode;
	}

	public void setFunParentCode(String funParentCode) {
		this.funParentCode = funParentCode;
	}

	public String getFunModleName() {
		return this.funModleName;
	}

	public void setFunModleName(String funModleName) {
		this.funModleName = funModleName;
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

	public Set getSysrolejuris_2() {
		return this.sysrolejuris_2;
	}

	public void setSysrolejuris_2(Set sysrolejuris_2) {
		this.sysrolejuris_2 = sysrolejuris_2;
	}

}