package cn.edu.nwsuaf.bean;

/**
 * Sysuserinfo entity. @author MyEclipse Persistence Tools
 */

public class Sysuserinfo implements java.io.Serializable {

	// Fields

	private String userCode;
	private Major major;
	private Department department;
	private Sysrole sysrole;
	private String password;
	private String userName;
	private String userType;
	private String useDesc;
	private String mail;
	

	// Constructors

	/** default constructor */
	public Sysuserinfo() {
	}

	/** minimal constructor */
	public Sysuserinfo(String userCode) {
		this.userCode = userCode;
	}

	public Sysuserinfo(String userCode, Major major, Department department,
			Sysrole sysrole, String password, String userName, String userType,
			String useDesc) {
		this.userCode = userCode;
		this.major = major;
		this.department = department;
		this.sysrole = sysrole;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
		this.useDesc = useDesc;
		this.mail="";
	}

	
	
	/** full constructor */
	public Sysuserinfo(String userCode, Major major, Department department,
			Sysrole sysrole, String password, String userName, String userType,
			String useDesc, String mail) {
		super();
		this.userCode = userCode;
		this.major = major;
		this.department = department;
		this.sysrole = sysrole;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
		this.useDesc = useDesc;
		this.mail = mail;
	}

	// Property accessors

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Sysrole getSysrole() {
		return this.sysrole;
	}

	public void setSysrole(Sysrole sysrole) {
		this.sysrole = sysrole;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUseDesc() {
		return this.useDesc;
	}

	public void setUseDesc(String useDesc) {
		this.useDesc = useDesc;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}