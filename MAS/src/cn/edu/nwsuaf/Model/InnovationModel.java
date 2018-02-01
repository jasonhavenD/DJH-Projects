package cn.edu.nwsuaf.Model;



public class InnovationModel extends BaseModel{
	private String level;
	private String type;
	private String cost;
	private String setDate;
	private String endDate;
	private String assessment;
	private String note;
	private Integer tag;
	/**
	 * @param level
	 * @param type
	 * @param cost
	 * @param setDate
	 * @param endDate
	 * @param assessment
	 * @param note
	 * @param tag
	 */
	public InnovationModel(String level, String type, String cost,
			String setDate, String endDate, String assessment, String note,
			Integer tag) {
		super();
		this.level = level;
		this.type = type;
		this.cost = cost;
		this.setDate = setDate;
		this.endDate = endDate;
		this.assessment = assessment;
		this.note = note;
		this.tag = tag;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getSetDate() {
		return setDate;
	}
	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public InnovationModel() {
		super();
	}


}
