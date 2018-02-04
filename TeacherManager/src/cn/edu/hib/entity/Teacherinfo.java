package cn.edu.hib.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Teacherinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacherinfo", catalog = "teachermanager")
public class Teacherinfo implements java.io.Serializable {

	// Fields

	private String tno;
	private String tname;
	private String type;
	private String password;
	private String phone;
	private String mail;
	private String tunit;
	private String gender;
	private Date birthday;
	private String education;
	private String degree;
	private String rank;
	private String graduateuniversity;
	private String loginstatus;
	private String note;
	private Set<Tteachingevaluation> tteachingevaluations = new HashSet<Tteachingevaluation>(
			0);
	private Set<Shorttermtrain> shorttermtrains = new HashSet<Shorttermtrain>(0);
	private Set<Tonlinetrain> tonlinetrains = new HashSet<Tonlinetrain>(0);
	private Inductiontrain inductiontrain;
	private Set<Tsinglestudy> tsinglestudies = new HashSet<Tsinglestudy>(0);
	private Set<Tpromotetrain> tpromotetrains = new HashSet<Tpromotetrain>(0);

	// Constructors

	/** default constructor */
	public Teacherinfo() {
	}

	/** minimal constructor */
	public Teacherinfo(String tno) {
		this.tno = tno;
		this.tname = "";
		this.type = "";
		this.password = "";
		this.phone = "";
		this.mail = "";
		this.tunit = "";
		this.gender = "";
		this.birthday = new Date(0);
		this.education = "";
		this.degree = "";
		this.rank = "";
		this.graduateuniversity = "";
		this.loginstatus = "";
		this.note = note="暂无";
	}

	/** full constructor */
	public Teacherinfo(String tno, String tname, String type, String password,
			String phone, String mail, String tunit, String gender,
			Date birthday, String education, String degree, String rank,
			String graduateuniversity, String loginstatus, String note,
			Set<Tteachingevaluation> tteachingevaluations,
			Set<Shorttermtrain> shorttermtrains,
			Set<Tonlinetrain> tonlinetrains, Inductiontrain inductiontrain,
			Set<Tsinglestudy> tsinglestudies, Set<Tpromotetrain> tpromotetrains) {
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
		this.tteachingevaluations = tteachingevaluations;
		this.shorttermtrains = shorttermtrains;
		this.tonlinetrains = tonlinetrains;
		this.inductiontrain = inductiontrain;
		this.tsinglestudies = tsinglestudies;
		this.tpromotetrains = tpromotetrains;
	}

	// Property accessors
	@Id
	@Column(name = "tno", unique = true, nullable = false, length = 10)
	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	@Column(name = "tname", length = 100)
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "password", length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "mail", length = 30)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "tunit", length = 100)
	public String getTunit() {
		return this.tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "education", length = 20)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "degree", length = 20)
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "rank", length = 20)
	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Column(name = "graduateuniversity", length = 60)
	public String getGraduateuniversity() {
		return this.graduateuniversity;
	}

	public void setGraduateuniversity(String graduateuniversity) {
		this.graduateuniversity = graduateuniversity;
	}

	@Column(name = "loginstatus", length = 20)
	public String getLoginstatus() {
		return this.loginstatus;
	}

	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Set<Tteachingevaluation> getTteachingevaluations() {
		return this.tteachingevaluations;
	}

	public void setTteachingevaluations(
			Set<Tteachingevaluation> tteachingevaluations) {
		this.tteachingevaluations = tteachingevaluations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Set<Shorttermtrain> getShorttermtrains() {
		return this.shorttermtrains;
	}

	public void setShorttermtrains(Set<Shorttermtrain> shorttermtrains) {
		this.shorttermtrains = shorttermtrains;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Set<Tonlinetrain> getTonlinetrains() {
		return this.tonlinetrains;
	}

	public void setTonlinetrains(Set<Tonlinetrain> tonlinetrains) {
		this.tonlinetrains = tonlinetrains;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Inductiontrain getInductiontrain() {
		return this.inductiontrain;
	}

	public void setInductiontrain(Inductiontrain inductiontrain) {
		this.inductiontrain = inductiontrain;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Set<Tsinglestudy> getTsinglestudies() {
		return this.tsinglestudies;
	}

	public void setTsinglestudies(Set<Tsinglestudy> tsinglestudies) {
		this.tsinglestudies = tsinglestudies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherinfo")
	public Set<Tpromotetrain> getTpromotetrains() {
		return this.tpromotetrains;
	}

	public void setTpromotetrains(Set<Tpromotetrain> tpromotetrains) {
		this.tpromotetrains = tpromotetrains;
	}

	@Override
	public String toString() {
		return "Teacherinfo [tno=" + tno + ", tname=" + tname + ", type="
				+ type + ", password=" + password + ", phone=" + phone
				+ ", mail=" + mail + ", tunit=" + tunit + ", gender=" + gender
				+ ", birthday=" + birthday + ", education=" + education
				+ ", degree=" + degree + ", rank=" + rank
				+ ", graduateuniversity=" + graduateuniversity
				+ ", loginstatus=" + loginstatus + ", note=" + note
				+ ", tteachingevaluations=" + tteachingevaluations
				+ ", shorttermtrains=" + shorttermtrains + ", tonlinetrains="
				+ tonlinetrains + ", inductiontrain=" + inductiontrain
				+ ", tsinglestudies=" + tsinglestudies + ", tpromotetrains="
				+ tpromotetrains + "]";
	}

}