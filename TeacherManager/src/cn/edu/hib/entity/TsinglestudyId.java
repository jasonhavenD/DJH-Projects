package cn.edu.hib.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TsinglestudyId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TsinglestudyId implements java.io.Serializable {

	// Fields

	private String tno;
	private String studyno;

	// Constructors

	/** default constructor */
	public TsinglestudyId() {
	}

	/** full constructor */
	public TsinglestudyId(String tno, String studyno) {
		this.tno = tno;
		this.studyno = studyno;
	}

	// Property accessors

	@Column(name = "tno", nullable = false, length = 10)
	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	@Column(name = "studyno", nullable = false, length = 10)
	public String getStudyno() {
		return this.studyno;
	}

	public void setStudyno(String studyno) {
		this.studyno = studyno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TsinglestudyId))
			return false;
		TsinglestudyId castOther = (TsinglestudyId) other;

		return ((this.getTno() == castOther.getTno()) || (this.getTno() != null
				&& castOther.getTno() != null && this.getTno().equals(
				castOther.getTno())))
				&& ((this.getStudyno() == castOther.getStudyno()) || (this
						.getStudyno() != null && castOther.getStudyno() != null && this
						.getStudyno().equals(castOther.getStudyno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTno() == null ? 0 : this.getTno().hashCode());
		result = 37 * result
				+ (getStudyno() == null ? 0 : this.getStudyno().hashCode());
		return result;
	}

}