package cn.edu.nwsuaf.Model;



public class PublicshedaacademicpapersModel extends BaseModel{
	private String tno;
	private String tname;
	private String paperName;
	private String periodicalInfo;
	private String periodicalType;
	private Float influenceFactors;
	private String beizhu;

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
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPeriodicalInfo() {
		return periodicalInfo;
	}
	public void setPeriodicalInfo(String periodicalInfo) {
		this.periodicalInfo = periodicalInfo;
	}
	public String getPeriodicalType() {
		return periodicalType;
	}
	public void setPeriodicalType(String periodicalType) {
		this.periodicalType = periodicalType;
	}
	public Float getInfluenceFactors() {
		return influenceFactors;
	}
	public void setInfluenceFactors(Float influenceFactors) {
		this.influenceFactors = influenceFactors;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
