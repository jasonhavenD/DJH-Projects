package cn.edu.nwsuaf.bean;

/**
 * Expert entity. @author MyEclipse Persistence Tools
 */

public class Expert implements java.io.Serializable {

	// Fields

	private String expertId;
	private String expertName;
	private String password;
	private String type;
	private String note;

	// Constructors

	/** default constructor */
	public Expert() {
	}

	/** minimal constructor */
	public Expert(String expertId) {
		this.expertId = expertId;
	}

	/** full constructor */
	public Expert(String expertId, String expertName, String password,
			String type, String note) {
		this.expertId = expertId;
		this.expertName = expertName;
		this.password = password;
		this.type = type;
		this.note = note;
	}

	// Property accessors

	public String getExpertId() {
		return this.expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getExpertName() {
		return this.expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}