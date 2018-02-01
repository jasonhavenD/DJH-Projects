package cn.edu.nwsuaf.bean;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Integer masCode;
	private String masprojectName;
	private String mno;
	private String mname;
	private String dno;
	private String dname;
	private float firstTarget;
	private float secondTarget;
	private float thirdTarget;
	private float fouthTarget;
	private float fifthTarget;
	private float sixthTarget;
	private float seventhTarget;
	private float eightTarget;
	private float totalScore;
	private Integer firstTargetRanking;
	private Integer secondTargetRanking;
	private Integer thirdTargetRanking;
	private Integer fouthTargetRanking;
	private Integer fifthTargetRanking;
	private Integer sixthTargetRanking;
	private Integer seventhTargetRanking;
	private Integer eightTargetRanking;
	private Integer totalScoreRanking;
	private Integer firstTargetRankingByClass;
	private Integer secondTargetRankingByClass;
	private Integer thirdTargetRankingByClass;
	private Integer fouthTargetRankingByClass;
	private Integer fifthTargetRankingByClass;
	private Integer sixthTargetRankingByClass;
	private Integer seventhTargetRankingByClass;
	private Integer eightTargetRankingByClass;
	private Integer totalTargetRankingByClass;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(Integer masCode) {
		this.masCode = masCode;
	}

	/** full constructor */
	public Score(Integer masCode, String masprojectName, String mno,
			String mname, String dno, String dname, float firstTarget,
			float secondTarget, float thirdTarget, float fouthTarget,
			float fifthTarget, float sixthTarget, float seventhTarget,
			float eightTarget, float totalScore, Integer firstTargetRanking,
			Integer secondTargetRanking, Integer thirdTargetRanking,
			Integer fouthTargetRanking, Integer fifthTargetRanking,
			Integer sixthTargetRanking, Integer seventhTargetRanking,
			Integer eightTargetRanking, Integer totalScoreRanking,
			Integer firstTargetRankingByClass,
			Integer secondTargetRankingByClass,
			Integer thirdTargetRankingByClass,
			Integer fouthTargetRankingByClass,
			Integer fifthTargetRankingByClass,
			Integer sixthTargetRankingByClass,
			Integer seventhTargetRankingByClass,
			Integer eightTargetRankingByClass, Integer totalTargetRankingByClass) {
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
		this.totalScore = totalScore;
		this.firstTargetRanking = firstTargetRanking;
		this.secondTargetRanking = secondTargetRanking;
		this.thirdTargetRanking = thirdTargetRanking;
		this.fouthTargetRanking = fouthTargetRanking;
		this.fifthTargetRanking = fifthTargetRanking;
		this.sixthTargetRanking = sixthTargetRanking;
		this.seventhTargetRanking = seventhTargetRanking;
		this.eightTargetRanking = eightTargetRanking;
		this.totalScoreRanking = totalScoreRanking;
		this.firstTargetRankingByClass = firstTargetRankingByClass;
		this.secondTargetRankingByClass = secondTargetRankingByClass;
		this.thirdTargetRankingByClass = thirdTargetRankingByClass;
		this.fouthTargetRankingByClass = fouthTargetRankingByClass;
		this.fifthTargetRankingByClass = fifthTargetRankingByClass;
		this.sixthTargetRankingByClass = sixthTargetRankingByClass;
		this.seventhTargetRankingByClass = seventhTargetRankingByClass;
		this.eightTargetRankingByClass = eightTargetRankingByClass;
		this.totalTargetRankingByClass = totalTargetRankingByClass;
	}

	// Property accessors

	public Integer getMasCode() {
		return this.masCode;
	}

	public void setMasCode(Integer masCode) {
		this.masCode = masCode;
	}

	public String getMasprojectName() {
		return this.masprojectName;
	}

	public void setMasprojectName(String masprojectName) {
		this.masprojectName = masprojectName;
	}

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDno() {
		return this.dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public float getFirstTarget() {
		return this.firstTarget;
	}

	public void setFirstTarget(float firstTarget) {
		this.firstTarget = firstTarget;
	}

	public float getSecondTarget() {
		return this.secondTarget;
	}

	public void setSecondTarget(float secondTarget) {
		this.secondTarget = secondTarget;
	}

	public float getThirdTarget() {
		return this.thirdTarget;
	}

	public void setThirdTarget(float thirdTarget) {
		this.thirdTarget = thirdTarget;
	}

	public float getFouthTarget() {
		return this.fouthTarget;
	}

	public void setFouthTarget(float fouthTarget) {
		this.fouthTarget = fouthTarget;
	}

	public float getFifthTarget() {
		return this.fifthTarget;
	}

	public void setFifthTarget(float fifthTarget) {
		this.fifthTarget = fifthTarget;
	}

	public float getSixthTarget() {
		return this.sixthTarget;
	}

	public void setSixthTarget(float sixthTarget) {
		this.sixthTarget = sixthTarget;
	}

	public float getSeventhTarget() {
		return this.seventhTarget;
	}

	public void setSeventhTarget(float seventhTarget) {
		this.seventhTarget = seventhTarget;
	}

	public float getEightTarget() {
		return this.eightTarget;
	}

	public void setEightTarget(float eightTarget) {
		this.eightTarget = eightTarget;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getFirstTargetRanking() {
		return this.firstTargetRanking;
	}

	public void setFirstTargetRanking(Integer firstTargetRanking) {
		this.firstTargetRanking = firstTargetRanking;
	}

	public Integer getSecondTargetRanking() {
		return this.secondTargetRanking;
	}

	public void setSecondTargetRanking(Integer secondTargetRanking) {
		this.secondTargetRanking = secondTargetRanking;
	}

	public Integer getThirdTargetRanking() {
		return this.thirdTargetRanking;
	}

	public void setThirdTargetRanking(Integer thirdTargetRanking) {
		this.thirdTargetRanking = thirdTargetRanking;
	}

	public Integer getFouthTargetRanking() {
		return this.fouthTargetRanking;
	}

	public void setFouthTargetRanking(Integer fouthTargetRanking) {
		this.fouthTargetRanking = fouthTargetRanking;
	}

	public Integer getFifthTargetRanking() {
		return this.fifthTargetRanking;
	}

	public void setFifthTargetRanking(Integer fifthTargetRanking) {
		this.fifthTargetRanking = fifthTargetRanking;
	}

	public Integer getSixthTargetRanking() {
		return this.sixthTargetRanking;
	}

	public void setSixthTargetRanking(Integer sixthTargetRanking) {
		this.sixthTargetRanking = sixthTargetRanking;
	}

	public Integer getSeventhTargetRanking() {
		return this.seventhTargetRanking;
	}

	public void setSeventhTargetRanking(Integer seventhTargetRanking) {
		this.seventhTargetRanking = seventhTargetRanking;
	}

	public Integer getEightTargetRanking() {
		return this.eightTargetRanking;
	}

	public void setEightTargetRanking(Integer eightTargetRanking) {
		this.eightTargetRanking = eightTargetRanking;
	}

	public Integer getTotalScoreRanking() {
		return this.totalScoreRanking;
	}

	public void setTotalScoreRanking(Integer totalScoreRanking) {
		this.totalScoreRanking = totalScoreRanking;
	}

	public Integer getFirstTargetRankingByClass() {
		return this.firstTargetRankingByClass;
	}

	public void setFirstTargetRankingByClass(Integer firstTargetRankingByClass) {
		this.firstTargetRankingByClass = firstTargetRankingByClass;
	}

	public Integer getSecondTargetRankingByClass() {
		return this.secondTargetRankingByClass;
	}

	public void setSecondTargetRankingByClass(Integer secondTargetRankingByClass) {
		this.secondTargetRankingByClass = secondTargetRankingByClass;
	}

	public Integer getThirdTargetRankingByClass() {
		return this.thirdTargetRankingByClass;
	}

	public void setThirdTargetRankingByClass(Integer thirdTargetRankingByClass) {
		this.thirdTargetRankingByClass = thirdTargetRankingByClass;
	}

	public Integer getFouthTargetRankingByClass() {
		return this.fouthTargetRankingByClass;
	}

	public void setFouthTargetRankingByClass(Integer fouthTargetRankingByClass) {
		this.fouthTargetRankingByClass = fouthTargetRankingByClass;
	}

	public Integer getFifthTargetRankingByClass() {
		return this.fifthTargetRankingByClass;
	}

	public void setFifthTargetRankingByClass(Integer fifthTargetRankingByClass) {
		this.fifthTargetRankingByClass = fifthTargetRankingByClass;
	}

	public Integer getSixthTargetRankingByClass() {
		return this.sixthTargetRankingByClass;
	}

	public void setSixthTargetRankingByClass(Integer sixthTargetRankingByClass) {
		this.sixthTargetRankingByClass = sixthTargetRankingByClass;
	}

	public Integer getSeventhTargetRankingByClass() {
		return this.seventhTargetRankingByClass;
	}

	public void setSeventhTargetRankingByClass(
			Integer seventhTargetRankingByClass) {
		this.seventhTargetRankingByClass = seventhTargetRankingByClass;
	}

	public Integer getEightTargetRankingByClass() {
		return this.eightTargetRankingByClass;
	}

	public void setEightTargetRankingByClass(Integer eightTargetRankingByClass) {
		this.eightTargetRankingByClass = eightTargetRankingByClass;
	}

	public Integer getTotalTargetRankingByClass() {
		return this.totalTargetRankingByClass;
	}

	public void setTotalTargetRankingByClass(Integer totalTargetRankingByClass) {
		this.totalTargetRankingByClass = totalTargetRankingByClass;
	}

}