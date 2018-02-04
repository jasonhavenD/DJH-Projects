package cn.edu.hib.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TonlinetrainId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TonlinetrainId implements java.io.Serializable {

	// Fields

	private String tno;
	private String trainno;

	// Constructors

	/** default constructor */
	public TonlinetrainId() {
	}

	/** full constructor */
	public TonlinetrainId(String tno, String trainno) {
		this.tno = tno;
		this.trainno = trainno;
	}

	// Property accessors

	@Column(name = "tno", nullable = false, length = 10)
	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	@Column(name = "trainno", nullable = false, length = 15)
	public String getTrainno() {
		return this.trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TonlinetrainId))
			return false;
		TonlinetrainId castOther = (TonlinetrainId) other;

		return ((this.getTno() == castOther.getTno()) || (this.getTno() != null
				&& castOther.getTno() != null && this.getTno().equals(
				castOther.getTno())))
				&& ((this.getTrainno() == castOther.getTrainno()) || (this
						.getTrainno() != null && castOther.getTrainno() != null && this
						.getTrainno().equals(castOther.getTrainno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTno() == null ? 0 : this.getTno().hashCode());
		result = 37 * result
				+ (getTrainno() == null ? 0 : this.getTrainno().hashCode());
		return result;
	}

}