package cn.edu.hib.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TteachingevaluationId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TteachingevaluationId implements java.io.Serializable {

	// Fields

	private String valuationno;
	private String tno;

	// Constructors

	/** default constructor */
	public TteachingevaluationId() {
	}

	/** full constructor */
	public TteachingevaluationId(String valuationno, String tno) {
		this.valuationno = valuationno;
		this.tno = tno;
	}

	// Property accessors

	@Column(name = "valuationno", nullable = false, length = 15)
	public String getValuationno() {
		return this.valuationno;
	}

	public void setValuationno(String valuationno) {
		this.valuationno = valuationno;
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
		if (!(other instanceof TteachingevaluationId))
			return false;
		TteachingevaluationId castOther = (TteachingevaluationId) other;

		return ((this.getValuationno() == castOther.getValuationno()) || (this
				.getValuationno() != null && castOther.getValuationno() != null && this
				.getValuationno().equals(castOther.getValuationno())))
				&& ((this.getTno() == castOther.getTno()) || (this.getTno() != null
						&& castOther.getTno() != null && this.getTno().equals(
						castOther.getTno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getValuationno() == null ? 0 : this.getValuationno()
						.hashCode());
		result = 37 * result
				+ (getTno() == null ? 0 : this.getTno().hashCode());
		return result;
	}

}