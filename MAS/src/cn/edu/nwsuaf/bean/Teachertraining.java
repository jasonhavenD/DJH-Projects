package cn.edu.nwsuaf.bean;

/**
 * Teachertraining entity. @author MyEclipse Persistence Tools
 */

public class Teachertraining implements java.io.Serializable {

	// Fields

	private Integer teacherTrainingNo;
	private Teacher teacher;
	private String trainType;
	private String trainingArea;
	private String trainContend;
	private String year;
	private String trainDate;
	private Integer trainTime;
	private String getCertificate;
	private String givenCertificateDepart;
	private String isIndustryTrain;
	private String isPraticeTeachTraining;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Teachertraining() {
	}

	/** full constructor */
	public Teachertraining(Teacher teacher, String trainType,
			String trainingArea, String trainContend, String year,
			String trainDate, Integer trainTime, String getCertificate,
			String givenCertificateDepart, String isIndustryTrain,
			String isPraticeTeachTraining, Integer tag) {
		this.teacher = teacher;
		this.trainType = trainType;
		this.trainingArea = trainingArea;
		this.trainContend = trainContend;
		this.year = year;
		this.trainDate = trainDate;
		this.trainTime = trainTime;
		this.getCertificate = getCertificate;
		this.givenCertificateDepart = givenCertificateDepart;
		this.isIndustryTrain = isIndustryTrain;
		this.isPraticeTeachTraining = isPraticeTeachTraining;
		this.tag = tag;
	}

	// Property accessors

	public Integer getTeacherTrainingNo() {
		return this.teacherTrainingNo;
	}

	public void setTeacherTrainingNo(Integer teacherTrainingNo) {
		this.teacherTrainingNo = teacherTrainingNo;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTrainType() {
		return this.trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public String getTrainingArea() {
		return this.trainingArea;
	}

	public void setTrainingArea(String trainingArea) {
		this.trainingArea = trainingArea;
	}

	public String getTrainContend() {
		return this.trainContend;
	}

	public void setTrainContend(String trainContend) {
		this.trainContend = trainContend;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTrainDate() {
		return this.trainDate;
	}

	public void setTrainDate(String trainDate) {
		this.trainDate = trainDate;
	}

	public Integer getTrainTime() {
		return this.trainTime;
	}

	public void setTrainTime(Integer trainTime) {
		this.trainTime = trainTime;
	}

	public String getGetCertificate() {
		return this.getCertificate;
	}

	public void setGetCertificate(String getCertificate) {
		this.getCertificate = getCertificate;
	}

	public String getGivenCertificateDepart() {
		return this.givenCertificateDepart;
	}

	public void setGivenCertificateDepart(String givenCertificateDepart) {
		this.givenCertificateDepart = givenCertificateDepart;
	}

	public String getIsIndustryTrain() {
		return this.isIndustryTrain;
	}

	public void setIsIndustryTrain(String isIndustryTrain) {
		this.isIndustryTrain = isIndustryTrain;
	}

	public String getIsPraticeTeachTraining() {
		return this.isPraticeTeachTraining;
	}

	public void setIsPraticeTeachTraining(String isPraticeTeachTraining) {
		this.isPraticeTeachTraining = isPraticeTeachTraining;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}