package cn.edu.nwsuaf.bean;

/**
 * Stuthesis entity. @author MyEclipse Persistence Tools
 */

public class Stuthesis implements java.io.Serializable {

	// Fields

	private Integer thesisNumber;
	private Student student;
	private String comName;
	private String journal;
	private String journalType;
	private String year;
	private String note;
	private Integer tag;

	// Constructors

	/** default constructor */
	public Stuthesis() {
	}

	/** full constructor */
	public Stuthesis(Student student, String comName, String journal,
			String journalType, String year, String note, Integer tag) {
		this.student = student;
		this.comName = comName;
		this.journal = journal;
		this.journalType = journalType;
		this.year = year;
		this.note = note;
		this.tag = tag;
	}

	// Property accessors

	public Integer getThesisNumber() {
		return this.thesisNumber;
	}

	public void setThesisNumber(Integer thesisNumber) {
		this.thesisNumber = thesisNumber;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getComName() {
		return this.comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getJournalType() {
		return this.journalType;
	}

	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getTag() {
		return this.tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

}