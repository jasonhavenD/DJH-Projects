package cn.edu.hib.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TpromotetrainId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TpromotetrainId implements java.io.Serializable {

	// Fields

	private String trainno;
	private String tno;

	// Constructors

	/** default constructor */
	public TpromotetrainId() {
	}

	/** full constructor */
	public TpromotetrainId(String trainno, String tno) {
		this.trainno = trainno;
		this.tno = tno;
	}

	// Property accessors

	@Column(name = "trainno", nullable = false, length = 15)
	public String getTrainno() {
		return this.trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	@Column(name = "tno", nullable = false, length = 10)
	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TpromotetrainId))
			return false;
		TpromotetrainId castOther = (TpromotetrainId) other;

		return ((this.getTrainno() == castOther.getTrainno()) || (this
				.getTrainno() != null && castOther.getTrainno() != null && this
				.getTrainno().equals(castOther.getTrainno())))
				&& ((this.getTno() == castOther.getTno()) || (this.getTno() != null
						&& castOther.getTno() != null && this.getTno().equals(
						castOther.getTno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTrainno() == null ? 0 : this.getTrainno().hashCode());
		result = 37 * result
				+ (getTno() == null ? 0 : this.getTno().hashCode());
		return result;
	}

}