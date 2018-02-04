package cn.edu.entity.json;

import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.hib.entity.Tonlinetrain;

public class TonlinetrainJson implements java.io.Serializable {

	private String tno;
	private String trainno;
	private String tname;
	private String gender;
	private String tunit;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private Integer period;
	private String auditor;
	private Integer checkstatus;
	private String note;

	public TonlinetrainJson() {
	}
	public TonlinetrainJson(Tonlinetrain iter) {
		tno = iter.getTeacherinfo().getTno();
		trainno = iter.getOnlinetrain().getTrainno();
		tname = iter.getTname();
		gender = iter.getGender();
		tunit = iter.getTunit();
		age = iter.getAge();
		rank = iter.getRank();
		education = iter.getEducation();
		degree = iter.getDegree();
		period = iter.getPeriod();
		auditor = iter.getAuditor();
		checkstatus = iter.getCheckstatus();
		note = iter.getNote();
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTrainno() {
		return trainno;
	}
	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTunit() {
		return tunit;
	}
	public void setTunit(String tunit) {
		this.tunit = tunit;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public Integer getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(Integer checkstatus) {
		this.checkstatus = checkstatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "TonlinetrainJson [tno=" + tno + ", trainno=" + trainno
				+ ", tname=" + tname + ", gender=" + gender + ", tunit="
				+ tunit + ", age=" + age + ", rank=" + rank + ", education="
				+ education + ", degree=" + degree + ", period=" + period
				+ ", auditor=" + auditor + ", checkstatus=" + checkstatus
				+ ", note=" + note + "]";
	}
	
}