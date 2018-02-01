package cn.edu.nwsuaf.Model;



public class FulfillinginstanceModel extends BaseModel{

	private Integer fulNumber;
	private Integer stuNumber1;
	private Integer stuNumber2;
	private Integer endNumber;
	private Float openRate;
	private Float finishRate;
	private String fulType;
	private String year;
	private String note;
	
	public Integer getFulNumber() {
		return fulNumber;
	}
	public void setFulNumber(Integer fulNumber) {
		this.fulNumber = fulNumber;
	}
	public Integer getStuNumber1() {
		return stuNumber1;
	}
	public void setStuNumber1(Integer stuNumber1) {
		this.stuNumber1 = stuNumber1;
	}
	public Integer getStuNumber2() {
		return stuNumber2;
	}
	public void setStuNumber2(Integer stuNumber2) {
		this.stuNumber2 = stuNumber2;
	}
	public Integer getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(Integer endNumber) {
		this.endNumber = endNumber;
	}
	public Float getOpenRate() {
		return openRate;
	}
	public void setOpenRate(Float openRate) {
		this.openRate = openRate;
	}
	public Float getFinishRate() {
		return finishRate;
	}
	public void setFinishRate(Float finishRate) {
		this.finishRate = finishRate;
	}
	public String getFulType() {
		return fulType;
	}
	public void setFulType(String fulType) {
		this.fulType = fulType;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
