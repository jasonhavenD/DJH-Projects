package cn.edu.nwsuaf.view;

import java.math.BigDecimal;

/**
 * TeacherresearchsummaryView entity. @author MyEclipse Persistence Tools
 */

public class TeacherresearchsummaryView implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mno;
	private String year;
	private Integer researchPaperNumber1;
	private Integer researchPaperNumber2;
	private Integer researchPaperNumber3;
	private Integer researchProjectNumber1;
	private Integer researchProjectNumber2;
	private Integer researchProjectNumber3;
	private Integer educationProjectNumber1;
	private Integer educationProjectNumber2;
	private Integer educationProjectNumber3;
	private Integer educationPaperNumber1;
	private Integer educationPaperNumber2;
	private Integer educationPaperNumber3;
	private Integer textbookNumber1;
	private Integer textbookNumber2;
	private Integer textbookNumber3;
	private Integer qualitylEngineeringNumber1;
	private Integer qualitylEngineeringNumber2;
	private Integer qualitylEngineeringNumber3;
	private Integer teachingAchievementNumber11;
	private Integer teachingAchievementNumber12;
	private Integer teachingAchievementNumber13;
	private Integer teachingAchievementNumber21;
	private Integer teachingAchievementNumber22;
	private Integer teachingAchievementNumber23;
	private Integer teachingAchievementNumber31;
	private Integer teachingAchievementNumber32;
	private Integer teachingAchievementNumber33;
	private Integer researchAwardNumber111;
	private Integer researchAwardNumber112;
	private Integer researchAwardNumber113;
	private Integer researchAwardNumber121;
	private Integer researchAwardNumber122;
	private Integer researchAwardNumber123;
	private Integer researchAwardNumber131;
	private Integer researchAwardNumber132;
	private Integer researchAwardNumber133;
	private Integer researchAwardNumber211;
	private Integer researchAwardNumber212;
	private Integer researchAwardNumber213;
	private Integer researchAwardNumber221;
	private Integer researchAwardNumber222;
	private Integer researchAwardNumber223;
	private Integer researchAwardNumber231;
	private Integer researchAwardNumber232;
	private Integer researchAwardNumber233;
	private Integer researchAwardNumber311;
	private Integer researchAwardNumber312;
	private Integer researchAwardNumber313;
	private Integer researchAwardNumber321;
	private Integer researchAwardNumber322;
	private Integer researchAwardNumber323;
	private Integer researchAwardNumber331;
	private Integer researchAwardNumber332;
	private Integer researchAwardNumber333;


	// Constructors

	/** default constructor */
	public TeacherresearchsummaryView() {
	}


	public TeacherresearchsummaryView(Integer id, String mno, String year,
			Integer researchPaperNumber1, Integer researchPaperNumber2,
			Integer researchPaperNumber3, Integer researchProjectNumber1,
			Integer researchProjectNumber2,
			Integer researchProjectNumber3,
			Integer educationProjectNumber1,
			Integer educationProjectNumber2,
			Integer educationProjectNumber3,
			Integer educationPaperNumber1, Integer educationPaperNumber2,
			Integer educationPaperNumber3, Integer textbookNumber1,
			Integer textbookNumber2, Integer textbookNumber3,
			Integer qualitylEngineeringNumber1,
			Integer qualitylEngineeringNumber2,
			Integer qualitylEngineeringNumber3,
			Integer teachingAchievementNumber11,
			Integer teachingAchievementNumber12,
			Integer teachingAchievementNumber13,
			Integer teachingAchievementNumber21,
			Integer teachingAchievementNumber22,
			Integer teachingAchievementNumber23,
			Integer teachingAchievementNumber31,
			Integer teachingAchievementNumber32,
			Integer teachingAchievementNumber33,
			Integer researchAwardNumber111,
			Integer researchAwardNumber112,
			Integer researchAwardNumber113,
			Integer researchAwardNumber121,
			Integer researchAwardNumber122,
			Integer researchAwardNumber123,
			Integer researchAwardNumber131,
			Integer researchAwardNumber132,
			Integer researchAwardNumber133,
			Integer researchAwardNumber211,
			Integer researchAwardNumber212,
			Integer researchAwardNumber213,
			Integer researchAwardNumber221,
			Integer researchAwardNumber222,
			Integer researchAwardNumber223,
			Integer researchAwardNumber231,
			Integer researchAwardNumber232,
			Integer researchAwardNumber233,
			Integer researchAwardNumber311,
			Integer researchAwardNumber312,
			Integer researchAwardNumber313,
			Integer researchAwardNumber321,
			Integer researchAwardNumber322,
			Integer researchAwardNumber323,
			Integer researchAwardNumber331,
			Integer researchAwardNumber332, Integer researchAwardNumber333) {
		super();
		this.id = id;
		this.mno = mno;
		this.year = year;
		this.researchPaperNumber1 = researchPaperNumber1;
		this.researchPaperNumber2 = researchPaperNumber2;
		this.researchPaperNumber3 = researchPaperNumber3;
		this.researchProjectNumber1 = researchProjectNumber1;
		this.researchProjectNumber2 = researchProjectNumber2;
		this.researchProjectNumber3 = researchProjectNumber3;
		this.educationProjectNumber1 = educationProjectNumber1;
		this.educationProjectNumber2 = educationProjectNumber2;
		this.educationProjectNumber3 = educationProjectNumber3;
		this.educationPaperNumber1 = educationPaperNumber1;
		this.educationPaperNumber2 = educationPaperNumber2;
		this.educationPaperNumber3 = educationPaperNumber3;
		this.textbookNumber1 = textbookNumber1;
		this.textbookNumber2 = textbookNumber2;
		this.textbookNumber3 = textbookNumber3;
		this.qualitylEngineeringNumber1 = qualitylEngineeringNumber1;
		this.qualitylEngineeringNumber2 = qualitylEngineeringNumber2;
		this.qualitylEngineeringNumber3 = qualitylEngineeringNumber3;
		this.teachingAchievementNumber11 = teachingAchievementNumber11;
		this.teachingAchievementNumber12 = teachingAchievementNumber12;
		this.teachingAchievementNumber13 = teachingAchievementNumber13;
		this.teachingAchievementNumber21 = teachingAchievementNumber21;
		this.teachingAchievementNumber22 = teachingAchievementNumber22;
		this.teachingAchievementNumber23 = teachingAchievementNumber23;
		this.teachingAchievementNumber31 = teachingAchievementNumber31;
		this.teachingAchievementNumber32 = teachingAchievementNumber32;
		this.teachingAchievementNumber33 = teachingAchievementNumber33;
		this.researchAwardNumber111 = researchAwardNumber111;
		this.researchAwardNumber112 = researchAwardNumber112;
		this.researchAwardNumber113 = researchAwardNumber113;
		this.researchAwardNumber121 = researchAwardNumber121;
		this.researchAwardNumber122 = researchAwardNumber122;
		this.researchAwardNumber123 = researchAwardNumber123;
		this.researchAwardNumber131 = researchAwardNumber131;
		this.researchAwardNumber132 = researchAwardNumber132;
		this.researchAwardNumber133 = researchAwardNumber133;
		this.researchAwardNumber211 = researchAwardNumber211;
		this.researchAwardNumber212 = researchAwardNumber212;
		this.researchAwardNumber213 = researchAwardNumber213;
		this.researchAwardNumber221 = researchAwardNumber221;
		this.researchAwardNumber222 = researchAwardNumber222;
		this.researchAwardNumber223 = researchAwardNumber223;
		this.researchAwardNumber231 = researchAwardNumber231;
		this.researchAwardNumber232 = researchAwardNumber232;
		this.researchAwardNumber233 = researchAwardNumber233;
		this.researchAwardNumber311 = researchAwardNumber311;
		this.researchAwardNumber312 = researchAwardNumber312;
		this.researchAwardNumber313 = researchAwardNumber313;
		this.researchAwardNumber321 = researchAwardNumber321;
		this.researchAwardNumber322 = researchAwardNumber322;
		this.researchAwardNumber323 = researchAwardNumber323;
		this.researchAwardNumber331 = researchAwardNumber331;
		this.researchAwardNumber332 = researchAwardNumber332;
		this.researchAwardNumber333 = researchAwardNumber333;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMno() {
		return mno;
	}


	public void setMno(String mno) {
		this.mno = mno;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public Integer getResearchPaperNumber1() {
		return researchPaperNumber1;
	}


	public void setResearchPaperNumber1(Integer researchPaperNumber1) {
		this.researchPaperNumber1 = researchPaperNumber1;
	}


	public Integer getResearchPaperNumber2() {
		return researchPaperNumber2;
	}


	public void setResearchPaperNumber2(Integer researchPaperNumber2) {
		this.researchPaperNumber2 = researchPaperNumber2;
	}


	public Integer getResearchPaperNumber3() {
		return researchPaperNumber3;
	}


	public void setResearchPaperNumber3(Integer researchPaperNumber3) {
		this.researchPaperNumber3 = researchPaperNumber3;
	}


	public Integer getResearchProjectNumber1() {
		return researchProjectNumber1;
	}


	public void setResearchProjectNumber1(Integer researchProjectNumber1) {
		this.researchProjectNumber1 = researchProjectNumber1;
	}


	public Integer getResearchProjectNumber2() {
		return researchProjectNumber2;
	}


	public void setResearchProjectNumber2(Integer researchProjectNumber2) {
		this.researchProjectNumber2 = researchProjectNumber2;
	}


	public Integer getResearchProjectNumber3() {
		return researchProjectNumber3;
	}


	public void setResearchProjectNumber3(Integer researchProjectNumber3) {
		this.researchProjectNumber3 = researchProjectNumber3;
	}


	public Integer getEducationProjectNumber1() {
		return educationProjectNumber1;
	}


	public void setEducationProjectNumber1(Integer educationProjectNumber1) {
		this.educationProjectNumber1 = educationProjectNumber1;
	}


	public Integer getEducationProjectNumber2() {
		return educationProjectNumber2;
	}


	public void setEducationProjectNumber2(Integer educationProjectNumber2) {
		this.educationProjectNumber2 = educationProjectNumber2;
	}


	public Integer getEducationProjectNumber3() {
		return educationProjectNumber3;
	}


	public void setEducationProjectNumber3(Integer educationProjectNumber3) {
		this.educationProjectNumber3 = educationProjectNumber3;
	}


	public Integer getEducationPaperNumber1() {
		return educationPaperNumber1;
	}


	public void setEducationPaperNumber1(Integer educationPaperNumber1) {
		this.educationPaperNumber1 = educationPaperNumber1;
	}


	public Integer getEducationPaperNumber2() {
		return educationPaperNumber2;
	}


	public void setEducationPaperNumber2(Integer educationPaperNumber2) {
		this.educationPaperNumber2 = educationPaperNumber2;
	}


	public Integer getEducationPaperNumber3() {
		return educationPaperNumber3;
	}


	public void setEducationPaperNumber3(Integer educationPaperNumber3) {
		this.educationPaperNumber3 = educationPaperNumber3;
	}


	public Integer getTextbookNumber1() {
		return textbookNumber1;
	}


	public void setTextbookNumber1(Integer textbookNumber1) {
		this.textbookNumber1 = textbookNumber1;
	}


	public Integer getTextbookNumber2() {
		return textbookNumber2;
	}


	public void setTextbookNumber2(Integer textbookNumber2) {
		this.textbookNumber2 = textbookNumber2;
	}


	public Integer getTextbookNumber3() {
		return textbookNumber3;
	}


	public void setTextbookNumber3(Integer textbookNumber3) {
		this.textbookNumber3 = textbookNumber3;
	}


	public Integer getQualitylEngineeringNumber1() {
		return qualitylEngineeringNumber1;
	}


	public void setQualitylEngineeringNumber1(Integer qualitylEngineeringNumber1) {
		this.qualitylEngineeringNumber1 = qualitylEngineeringNumber1;
	}


	public Integer getQualitylEngineeringNumber2() {
		return qualitylEngineeringNumber2;
	}


	public void setQualitylEngineeringNumber2(Integer qualitylEngineeringNumber2) {
		this.qualitylEngineeringNumber2 = qualitylEngineeringNumber2;
	}


	public Integer getQualitylEngineeringNumber3() {
		return qualitylEngineeringNumber3;
	}


	public void setQualitylEngineeringNumber3(Integer qualitylEngineeringNumber3) {
		this.qualitylEngineeringNumber3 = qualitylEngineeringNumber3;
	}


	public Integer getTeachingAchievementNumber11() {
		return teachingAchievementNumber11;
	}


	public void setTeachingAchievementNumber11(
			Integer teachingAchievementNumber11) {
		this.teachingAchievementNumber11 = teachingAchievementNumber11;
	}


	public Integer getTeachingAchievementNumber12() {
		return teachingAchievementNumber12;
	}


	public void setTeachingAchievementNumber12(
			Integer teachingAchievementNumber12) {
		this.teachingAchievementNumber12 = teachingAchievementNumber12;
	}


	public Integer getTeachingAchievementNumber13() {
		return teachingAchievementNumber13;
	}


	public void setTeachingAchievementNumber13(
			Integer teachingAchievementNumber13) {
		this.teachingAchievementNumber13 = teachingAchievementNumber13;
	}


	public Integer getTeachingAchievementNumber21() {
		return teachingAchievementNumber21;
	}


	public void setTeachingAchievementNumber21(
			Integer teachingAchievementNumber21) {
		this.teachingAchievementNumber21 = teachingAchievementNumber21;
	}


	public Integer getTeachingAchievementNumber22() {
		return teachingAchievementNumber22;
	}


	public void setTeachingAchievementNumber22(
			Integer teachingAchievementNumber22) {
		this.teachingAchievementNumber22 = teachingAchievementNumber22;
	}


	public Integer getTeachingAchievementNumber23() {
		return teachingAchievementNumber23;
	}


	public void setTeachingAchievementNumber23(
			Integer teachingAchievementNumber23) {
		this.teachingAchievementNumber23 = teachingAchievementNumber23;
	}


	public Integer getTeachingAchievementNumber31() {
		return teachingAchievementNumber31;
	}


	public void setTeachingAchievementNumber31(
			Integer teachingAchievementNumber31) {
		this.teachingAchievementNumber31 = teachingAchievementNumber31;
	}


	public Integer getTeachingAchievementNumber32() {
		return teachingAchievementNumber32;
	}


	public void setTeachingAchievementNumber32(
			Integer teachingAchievementNumber32) {
		this.teachingAchievementNumber32 = teachingAchievementNumber32;
	}


	public Integer getTeachingAchievementNumber33() {
		return teachingAchievementNumber33;
	}


	public void setTeachingAchievementNumber33(
			Integer teachingAchievementNumber33) {
		this.teachingAchievementNumber33 = teachingAchievementNumber33;
	}


	public Integer getResearchAwardNumber111() {
		return researchAwardNumber111;
	}


	public void setResearchAwardNumber111(Integer researchAwardNumber111) {
		this.researchAwardNumber111 = researchAwardNumber111;
	}


	public Integer getResearchAwardNumber112() {
		return researchAwardNumber112;
	}


	public void setResearchAwardNumber112(Integer researchAwardNumber112) {
		this.researchAwardNumber112 = researchAwardNumber112;
	}


	public Integer getResearchAwardNumber113() {
		return researchAwardNumber113;
	}


	public void setResearchAwardNumber113(Integer researchAwardNumber113) {
		this.researchAwardNumber113 = researchAwardNumber113;
	}


	public Integer getResearchAwardNumber121() {
		return researchAwardNumber121;
	}


	public void setResearchAwardNumber121(Integer researchAwardNumber121) {
		this.researchAwardNumber121 = researchAwardNumber121;
	}


	public Integer getResearchAwardNumber122() {
		return researchAwardNumber122;
	}


	public void setResearchAwardNumber122(Integer researchAwardNumber122) {
		this.researchAwardNumber122 = researchAwardNumber122;
	}


	public Integer getResearchAwardNumber123() {
		return researchAwardNumber123;
	}


	public void setResearchAwardNumber123(Integer researchAwardNumber123) {
		this.researchAwardNumber123 = researchAwardNumber123;
	}


	public Integer getResearchAwardNumber131() {
		return researchAwardNumber131;
	}


	public void setResearchAwardNumber131(Integer researchAwardNumber131) {
		this.researchAwardNumber131 = researchAwardNumber131;
	}


	public Integer getResearchAwardNumber132() {
		return researchAwardNumber132;
	}


	public void setResearchAwardNumber132(Integer researchAwardNumber132) {
		this.researchAwardNumber132 = researchAwardNumber132;
	}


	public Integer getResearchAwardNumber133() {
		return researchAwardNumber133;
	}


	public void setResearchAwardNumber133(Integer researchAwardNumber133) {
		this.researchAwardNumber133 = researchAwardNumber133;
	}


	public Integer getResearchAwardNumber211() {
		return researchAwardNumber211;
	}


	public void setResearchAwardNumber211(Integer researchAwardNumber211) {
		this.researchAwardNumber211 = researchAwardNumber211;
	}


	public Integer getResearchAwardNumber212() {
		return researchAwardNumber212;
	}


	public void setResearchAwardNumber212(Integer researchAwardNumber212) {
		this.researchAwardNumber212 = researchAwardNumber212;
	}


	public Integer getResearchAwardNumber213() {
		return researchAwardNumber213;
	}


	public void setResearchAwardNumber213(Integer researchAwardNumber213) {
		this.researchAwardNumber213 = researchAwardNumber213;
	}


	public Integer getResearchAwardNumber221() {
		return researchAwardNumber221;
	}


	public void setResearchAwardNumber221(Integer researchAwardNumber221) {
		this.researchAwardNumber221 = researchAwardNumber221;
	}


	public Integer getResearchAwardNumber222() {
		return researchAwardNumber222;
	}


	public void setResearchAwardNumber222(Integer researchAwardNumber222) {
		this.researchAwardNumber222 = researchAwardNumber222;
	}


	public Integer getResearchAwardNumber223() {
		return researchAwardNumber223;
	}


	public void setResearchAwardNumber223(Integer researchAwardNumber223) {
		this.researchAwardNumber223 = researchAwardNumber223;
	}


	public Integer getResearchAwardNumber231() {
		return researchAwardNumber231;
	}


	public void setResearchAwardNumber231(Integer researchAwardNumber231) {
		this.researchAwardNumber231 = researchAwardNumber231;
	}


	public Integer getResearchAwardNumber232() {
		return researchAwardNumber232;
	}


	public void setResearchAwardNumber232(Integer researchAwardNumber232) {
		this.researchAwardNumber232 = researchAwardNumber232;
	}


	public Integer getResearchAwardNumber233() {
		return researchAwardNumber233;
	}


	public void setResearchAwardNumber233(Integer researchAwardNumber233) {
		this.researchAwardNumber233 = researchAwardNumber233;
	}


	public Integer getResearchAwardNumber311() {
		return researchAwardNumber311;
	}


	public void setResearchAwardNumber311(Integer researchAwardNumber311) {
		this.researchAwardNumber311 = researchAwardNumber311;
	}


	public Integer getResearchAwardNumber312() {
		return researchAwardNumber312;
	}


	public void setResearchAwardNumber312(Integer researchAwardNumber312) {
		this.researchAwardNumber312 = researchAwardNumber312;
	}


	public Integer getResearchAwardNumber313() {
		return researchAwardNumber313;
	}


	public void setResearchAwardNumber313(Integer researchAwardNumber313) {
		this.researchAwardNumber313 = researchAwardNumber313;
	}


	public Integer getResearchAwardNumber321() {
		return researchAwardNumber321;
	}


	public void setResearchAwardNumber321(Integer researchAwardNumber321) {
		this.researchAwardNumber321 = researchAwardNumber321;
	}


	public Integer getResearchAwardNumber322() {
		return researchAwardNumber322;
	}


	public void setResearchAwardNumber322(Integer researchAwardNumber322) {
		this.researchAwardNumber322 = researchAwardNumber322;
	}


	public Integer getResearchAwardNumber323() {
		return researchAwardNumber323;
	}


	public void setResearchAwardNumber323(Integer researchAwardNumber323) {
		this.researchAwardNumber323 = researchAwardNumber323;
	}


	public Integer getResearchAwardNumber331() {
		return researchAwardNumber331;
	}


	public void setResearchAwardNumber331(Integer researchAwardNumber331) {
		this.researchAwardNumber331 = researchAwardNumber331;
	}


	public Integer getResearchAwardNumber332() {
		return researchAwardNumber332;
	}


	public void setResearchAwardNumber332(Integer researchAwardNumber332) {
		this.researchAwardNumber332 = researchAwardNumber332;
	}


	public Integer getResearchAwardNumber333() {
		return researchAwardNumber333;
	}


	public void setResearchAwardNumber333(Integer researchAwardNumber333) {
		this.researchAwardNumber333 = researchAwardNumber333;
	}

}