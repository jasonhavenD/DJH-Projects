package cn.edu.nwsuaf.Model;

public class StuthesisModel extends BaseModel{
	//Id代表学生学号
	//Name代表学生姓名
	private String comName;
	private String journal;
	private String journalType;
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getJournalType() {
		return journalType;
	}
	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}
	
}
