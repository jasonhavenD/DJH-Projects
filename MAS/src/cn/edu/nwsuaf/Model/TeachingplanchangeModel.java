package cn.edu.nwsuaf.Model;

import java.util.Date;

public class TeachingplanchangeModel extends BaseModel{
      //Id代表课程编号
	//Name代表课程名称
	private String grade;
	private String changeType;
	private String changeMode;
	private Date changeDate;
	private String changeReason;
	private String changeContext;
	private Integer adjustNature;
	
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public String getChangeContext() {
		return changeContext;
	}
	public void setChangeContext(String changeContext) {
		this.changeContext = changeContext;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getChangeMode() {
		return changeMode;
	}
	public void setChangeMode(String changeMode) {
		this.changeMode = changeMode;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public void setAdjustNature(Integer adjustNature) {
		this.adjustNature = adjustNature;
	}
	public Integer getAdjustNature() {
		return adjustNature;
	}
}