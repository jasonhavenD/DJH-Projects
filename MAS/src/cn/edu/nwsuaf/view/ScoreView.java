package cn.edu.nwsuaf.view;

/**
 * ScoreView entity. @author MyEclipse Persistence Tools
 */

public class ScoreView implements java.io.Serializable {

	// Fields

	private Integer masCode;
	private String masprojectName;
	private String mno;
	private String mname;
	private String dno;
	private String dname;
	private Double firstTarget;
	private Double secondTarget;
	private Double thirdTarget;
	private Double fouthTarget;
	private Double fifthTarget;
	private Double sixthTarget;
	private Double seventhTarget;
	private Double eightTarget;

	// Constructors

	/** default constructor */
	public ScoreView() {
	}

	public ScoreView(Integer masCode, String masprojectName, String mno,
			String mname, String dno, String dname, Double firstTarget,
			Double secondTarget, Double thirdTarget, Double fouthTarget,
			Double fifthTarget, Double sixthTarget, Double seventhTarget,
			Double eightTarget) {
		super();
		this.masCode = masCode;
		this.masprojectName = masprojectName;
		this.mno = mno;
		this.mname = mname;
		this.dno = dno;
		this.dname = dname;
		this.firstTarget = firstTarget;
		this.secondTarget = secondTarget;
		this.thirdTarget = thirdTarget;
		this.fouthTarget = fouthTarget;
		this.fifthTarget = fifthTarget;
		this.sixthTarget = sixthTarget;
		this.seventhTarget = seventhTarget;
		this.eightTarget = eightTarget;
	}

	public Integer getMasCode() {
		return masCode;
	}

	public void setMasCode(Integer masCode) {
		this.masCode = masCode;
	}

	public String getMasprojectName() {
		return masprojectName;
	}

	public void setMasprojectName(String masprojectName) {
		this.masprojectName = masprojectName;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Double getFirstTarget() {
		return firstTarget;
	}

	public void setFirstTarget(Double firstTarget) {
		this.firstTarget = firstTarget;
	}

	public Double getSecondTarget() {
		return secondTarget;
	}

	public void setSecondTarget(Double secondTarget) {
		this.secondTarget = secondTarget;
	}

	public Double getThirdTarget() {
		return thirdTarget;
	}

	public void setThirdTarget(Double thirdTarget) {
		this.thirdTarget = thirdTarget;
	}

	public Double getFouthTarget() {
		return fouthTarget;
	}

	public void setFouthTarget(Double fouthTarget) {
		this.fouthTarget = fouthTarget;
	}

	public Double getFifthTarget() {
		return fifthTarget;
	}

	public void setFifthTarget(Double fifthTarget) {
		this.fifthTarget = fifthTarget;
	}

	public Double getSixthTarget() {
		return sixthTarget;
	}

	public void setSixthTarget(Double sixthTarget) {
		this.sixthTarget = sixthTarget;
	}

	public Double getSeventhTarget() {
		return seventhTarget;
	}

	public void setSeventhTarget(Double seventhTarget) {
		this.seventhTarget = seventhTarget;
	}

	public Double getEightTarget() {
		return eightTarget;
	}

	public void setEightTarget(Double eightTarget) {
		this.eightTarget = eightTarget;
	}

}