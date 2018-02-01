package cn.edu.nwsuaf.Model;

import java.util.Date;

import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.National;






public class StudentModel extends BaseModel{

	private Major major;
	private National national;
	private Date birth;
	private String sex;
	private String class_;
	private String grade;
	private Date graduationDate;
	private Integer eductionalSystme;
	private String isRoll;
	private String isInSchool;
	private String status;
	private Integer tag;
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public National getNational() {
		return national;
	}
	public void setNational(National national) {
		this.national = national;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class1) {
		class_ = class1;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	public Integer getEductionalSystme() {
		return eductionalSystme;
	}
	public void setEductionalSystme(Integer eductionalSystme) {
		this.eductionalSystme = eductionalSystme;
	}
	public String getIsRoll() {
		return isRoll;
	}
	public void setIsRoll(String isRoll) {
		this.isRoll = isRoll;
	}
	public String getIsInSchool() {
		return isInSchool;
	}
	public void setIsInSchool(String isInSchool) {
		this.isInSchool = isInSchool;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	
}
