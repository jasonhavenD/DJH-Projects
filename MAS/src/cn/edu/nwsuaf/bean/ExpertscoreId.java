package cn.edu.nwsuaf.bean;

/**
 * ExpertscoreId entity. @author MyEclipse Persistence Tools
 */

public class ExpertscoreId implements java.io.Serializable {

	// Fields

	private FileinfoAttachment fileinfoAttachment;
	private String expertId;

	// Constructors

	/** default constructor */
	public ExpertscoreId() {
	}

	/** full constructor */
	public ExpertscoreId(FileinfoAttachment fileinfoAttachment, String expertId) {
		this.fileinfoAttachment = fileinfoAttachment;
		this.expertId = expertId;
	}

	// Property accessors

	public FileinfoAttachment getFileinfoAttachment() {
		return this.fileinfoAttachment;
	}

	public void setFileinfoAttachment(FileinfoAttachment fileinfoAttachment) {
		this.fileinfoAttachment = fileinfoAttachment;
	}

	public String getExpertId() {
		return this.expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExpertscoreId))
			return false;
		ExpertscoreId castOther = (ExpertscoreId) other;

		return ((this.getFileinfoAttachment() == castOther
				.getFileinfoAttachment()) || (this.getFileinfoAttachment() != null
				&& castOther.getFileinfoAttachment() != null && this
				.getFileinfoAttachment().equals(
						castOther.getFileinfoAttachment())))
				&& ((this.getExpertId() == castOther.getExpertId()) || (this
						.getExpertId() != null
						&& castOther.getExpertId() != null && this
						.getExpertId().equals(castOther.getExpertId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFileinfoAttachment() == null ? 0 : this
						.getFileinfoAttachment().hashCode());
		result = 37 * result
				+ (getExpertId() == null ? 0 : this.getExpertId().hashCode());
		return result;
	}

}