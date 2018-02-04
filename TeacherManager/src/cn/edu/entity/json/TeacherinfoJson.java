package cn.edu.entity.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.hib.entity.Teacherinfo;

public class TeacherinfoJson {
	private String tno;
	private String tname;
	private String type;
	private String password;
	private String phone;
	private String mail;
	private String tunit;
	private String gender;
	private String birthday;
	private String education;
	private String degree;
	private String rank;
	private String graduateuniversity;
	private String loginstatus;
	private String note;
	private String age;

	public TeacherinfoJson() {
	}

	public TeacherinfoJson(Teacherinfo teacherinfo) {
		tno = teacherinfo.getTno();
		tname = teacherinfo.getTname();
		type = teacherinfo.getType();
		password = teacherinfo.getPassword();
		phone = teacherinfo.getPhone();
		mail = teacherinfo.getMail();
		tunit = teacherinfo.getTunit();
		gender = teacherinfo.getGender();
		education = teacherinfo.getEducation();
		degree = teacherinfo.getDegree();
		rank = teacherinfo.getRank();
		graduateuniversity = teacherinfo.getGraduateuniversity();
		loginstatus = teacherinfo.getLoginstatus();
		note = teacherinfo.getNote();
		// date type
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		birthday = (form.format(new Date(teacherinfo.getBirthday().getTime())));

		// age
		Date now = new Date();
		age = "" + (now.getYear() - teacherinfo.getBirthday().getYear() + 1);
	}

	public TeacherinfoJson(String tno, String tname, String type,
			String password, String phone, String mail, String tunit,
			String gender, String birthday, String education, String degree,
			String rank, String graduateuniversity, String loginstatus,
			String note) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.type = type;
		this.password = password;
		this.phone = phone;
		this.mail = mail;
		this.tunit = tunit;
		this.gender = gender;
		this.birthday = birthday;
		this.education = education;
		this.degree = degree;
		this.rank = rank;
		this.graduateuniversity = graduateuniversity;
		this.loginstatus = loginstatus;
		this.note = note;
		// age
		Date now = new Date();
		Date birDate = new Date(birthday);
		this.age = "" + (now.getYear() - birDate.getYear() + 1);
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTunit() {
		return tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getGraduateuniversity() {
		return graduateuniversity;
	}

	public void setGraduateuniversity(String graduateuniversity) {
		this.graduateuniversity = graduateuniversity;
	}

	public String getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TeacherinfoJson [tno=" + tno + ", tname=" + tname + ", type="
				+ type + ", password=" + password + ", phone=" + phone
				+ ", mail=" + mail + ", tunit=" + tunit + ", gender=" + gender
				+ ", birthday=" + birthday + ", education=" + education
				+ ", degree=" + degree + ", rank=" + rank
				+ ", graduateuniversity=" + graduateuniversity
				+ ", loginstatus=" + loginstatus + ", note=" + note + "]";
	}

}
