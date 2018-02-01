package cn.edu.nwsuaf.Model;

import java.util.Date;

import cn.edu.nwsuaf.bean.Academicdegree;
import cn.edu.nwsuaf.bean.Degree;
import cn.edu.nwsuaf.bean.Jobtype;
import cn.edu.nwsuaf.bean.Learningedge;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Professionaltitle;
import cn.edu.nwsuaf.bean.Subjectcategory;
import cn.edu.nwsuaf.bean.Teacherscategory;

public class TeacherModel extends BaseModel{

	private String tno;
	private Major major;
	private Professionaltitle professionaltitle;
	private Teacherscategory teacherscategory;
	private Learningedge learningedge;
	private Degree degree;
	private Academicdegree academicdegree;
	private Subjectcategory subjectcategory;
	private Jobtype jobtype;
	private Date titleEvaluationTime;
	private String departmentGroup;
	private String tname;
	private String sex;
	private Date birthDay;
	private Date entryDate;
	private String year;
	private String inServiceState;
	private String gratuatdSchool;
	private String graduatedMajor;
	private String getScholarYear;
	private String resrachDirection;
	private String isDoubleTeacher;
	private String isEngineerBackground;
	private String isIndustryBackground;
	private String isPracticeTeachTraining;
	private String tutorType;
	private String isOuterTeacher;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Professionaltitle getProfessionaltitle() {
		return professionaltitle;
	}
	public void setProfessionaltitle(Professionaltitle professionaltitle) {
		this.professionaltitle = professionaltitle;
	}
	public Teacherscategory getTeacherscategory() {
		return teacherscategory;
	}
	public void setTeacherscategory(Teacherscategory teacherscategory) {
		this.teacherscategory = teacherscategory;
	}
	public Learningedge getLearningedge() {
		return learningedge;
	}
	public void setLearningedge(Learningedge learningedge) {
		this.learningedge = learningedge;
	}
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public Academicdegree getAcademicdegree() {
		return academicdegree;
	}
	public void setAcademicdegree(Academicdegree academicdegree) {
		this.academicdegree = academicdegree;
	}
	public Subjectcategory getSubjectcategory() {
		return subjectcategory;
	}
	public void setSubjectcategory(Subjectcategory subjectcategory) {
		this.subjectcategory = subjectcategory;
	}
	public Jobtype getJobtype() {
		return jobtype;
	}
	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}
	public Date getTitleEvaluationTime() {
		return titleEvaluationTime;
	}
	public void setTitleEvaluationTime(Date titleEvaluationTime) {
		this.titleEvaluationTime = titleEvaluationTime;
	}
	public String getDepartmentGroup() {
		return departmentGroup;
	}
	public void setDepartmentGroup(String departmentGroup) {
		this.departmentGroup = departmentGroup;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getInServiceState() {
		return inServiceState;
	}
	public void setInServiceState(String inServiceState) {
		this.inServiceState = inServiceState;
	}
	public String getGratuatdSchool() {
		return gratuatdSchool;
	}
	public void setGratuatdSchool(String gratuatdSchool) {
		this.gratuatdSchool = gratuatdSchool;
	}
	public String getGraduatedMajor() {
		return graduatedMajor;
	}
	public void setGraduatedMajor(String graduatedMajor) {
		this.graduatedMajor = graduatedMajor;
	}
	public String getGetScholarYear() {
		return getScholarYear;
	}
	public void setGetScholarYear(String getScholarYear) {
		this.getScholarYear = getScholarYear;
	}
	public String getResrachDirection() {
		return resrachDirection;
	}
	public void setResrachDirection(String resrachDirection) {
		this.resrachDirection = resrachDirection;
	}
	public String getIsDoubleTeacher() {
		return isDoubleTeacher;
	}
	public void setIsDoubleTeacher(String isDoubleTeacher) {
		this.isDoubleTeacher = isDoubleTeacher;
	}
	public String getIsEngineerBackground() {
		return isEngineerBackground;
	}
	public void setIsEngineerBackground(String isEngineerBackground) {
		this.isEngineerBackground = isEngineerBackground;
	}
	public String getIsIndustryBackground() {
		return isIndustryBackground;
	}
	public void setIsIndustryBackground(String isIndustryBackground) {
		this.isIndustryBackground = isIndustryBackground;
	}
	public String getIsPracticeTeachTraining() {
		return isPracticeTeachTraining;
	}
	public void setIsPracticeTeachTraining(String isPracticeTeachTraining) {
		this.isPracticeTeachTraining = isPracticeTeachTraining;
	}
	public String getTutorType() {
		return tutorType;
	}
	public void setTutorType(String tutorType) {
		this.tutorType = tutorType;
	}
	public String getIsOuterTeacher() {
		return isOuterTeacher;
	}
	public void setIsOuterTeacher(String isOuterTeacher) {
		this.isOuterTeacher = isOuterTeacher;
	}
	@Override
	public String toString() {
		return "TeacherModel [academicdegree=" + academicdegree + ", birthDay="
				+ birthDay + ", degree=" + degree + ", departmentGroup="
				+ departmentGroup + ", entryDate=" + entryDate
				+ ", getScholarYear=" + getScholarYear + ", graduatedMajor="
				+ graduatedMajor + ", gratuatdSchool=" + gratuatdSchool
				+ ", inServiceState=" + inServiceState + ", isDoubleTeacher="
				+ isDoubleTeacher + ", isEngineerBackground="
				+ isEngineerBackground + ", isIndustryBackground="
				+ isIndustryBackground + ", isOuterTeacher=" + isOuterTeacher
				+ ", isPracticeTeachTraining=" + isPracticeTeachTraining
				+ ", jobtype=" + jobtype + ", learningedge=" + learningedge
				+ ", major=" + major + ", professionaltitle="
				+ professionaltitle + ", resrachDirection=" + resrachDirection
				+ ", sex=" + sex + ", subjectcategory=" + subjectcategory
				+ ", teacherscategory=" + teacherscategory
				+ ", titleEvaluationTime=" + titleEvaluationTime + ", tname="
				+ tname + ", tno=" + tno + ", tutorType=" + tutorType
				+ ", year=" + year + "]";
	}
	
	
}
