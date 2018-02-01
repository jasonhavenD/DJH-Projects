package cn.edu.nwsuaf.bean;

/**
 * Expertadvice entity. @author MyEclipse Persistence Tools
 */

public class Expertadvice implements java.io.Serializable {

	// Fields

	private Integer adviceId;
	private Expertmajor expertmajor;
	private String question;
	private String advice;

	// Constructors

	/** default constructor */
	public Expertadvice() {
	}

	/** minimal constructor */
	public Expertadvice(Expertmajor expertmajor) {
		this.expertmajor = expertmajor;
	}

	/** full constructor */
	public Expertadvice(Expertmajor expertmajor, String question, String advice) {
		this.expertmajor = expertmajor;
		this.question = question;
		this.advice = advice;
	}

	// Property accessors

	public Integer getAdviceId() {
		return this.adviceId;
	}

	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}

	public Expertmajor getExpertmajor() {
		return this.expertmajor;
	}

	public void setExpertmajor(Expertmajor expertmajor) {
		this.expertmajor = expertmajor;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}