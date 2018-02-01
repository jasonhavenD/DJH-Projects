package cn.edu.nwsuaf.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Teachingbooks entity. @author MyEclipse Persistence Tools
 */

public class Teachingbooks implements java.io.Serializable {

	// Fields

	private Integer tbno;
	private String tbname;
	private String isbn;
	private String publisher;
	private String year;
	private Date publishTime;
	private String publishType;
	private String tbookJibie;
	private String tbookClass;
	private String tbookRewardClass;
	private Integer bookWords;
	private String useState;
	private String fininshDepartRate;
	private String beizhu;
	private Integer tag;
	private Set teachbooks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachingbooks() {
	}

	/** full constructor */
	public Teachingbooks(String tbname, String isbn, String publisher,
			String year, Date publishTime, String publishType,
			String tbookJibie, String tbookClass, String tbookRewardClass,
			Integer bookWords, String useState, String fininshDepartRate,
			String beizhu, Integer tag, Set teachbooks) {
		this.tbname = tbname;
		this.isbn = isbn;
		this.publisher = publisher;
		this.year = year;
		this.publishTime = publishTime;
		this.publishType = publishType;
		this.tbookJibie = tbookJibie;
		this.tbookClass = tbookClass;
		this.tbookRewardClass = tbookRewardClass;
		this.bookWords = bookWords;
		this.useState = useState;
		this.fininshDepartRate = fininshDepartRate;
		this.beizhu = beizhu;
		this.tag = tag;
		this.teachbooks = teachbooks;
	}

	// Property accessors

	public Integer getTbno() {
		return this.tbno;
	}

	public void setTbno(Integer tbno) {
		this.tbno = tbno;
	}

	public String getTbname() {
		return this.tbname;
	}

	public void setTbname(String tbname) {
		this.tbname = tbname;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishType() {
		return this.publishType;
	}

	public void setPublishType(String publishType) {
		this.publishType = publishType;
	}

	public String getTbookJibie() {
		return this.tbookJibie;
	}

	public void setTbookJibie(String tbookJibie) {
		this.tbookJibie = tbookJibie;
	}

	public String getTbookClass() {
		return this.tbookClass;
	}

	public void setTbookClass(String tbookClass) {
		this.tbookClass = tbookClass;
	}

	public String getTbookRewardClass() {
		return this.tbookRewardClass;
	}

	public void setTbookRewardClass(String tbookRewardClass) {
		this.tbookRewardClass = tbookRewardClass;
	}

	public Integer getBookWords() {
		return this.bookWords;
	}

	public void setBookWords(Integer bookWords) {
		this.bookWords = bookWords;
	}

	public String getUseState() {
		return this.useState;
	}

	public void setUseState(String useState) {
		this.useState = useState;
	}

	public String getFininshDepartRate() {
		return this.fininshDepartRate;
	}

	public void setFininshDepartRate(String fininshDepartRate) {
		this.fininshDepartRate = fininshDepartRate;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Set getTeachbooks() {
		return this.teachbooks;
	}

	public void setTeachbooks(Set teachbooks) {
		this.teachbooks = teachbooks;
	}

}