package cn.edu.nwsuaf.Model;

import cn.edu.nwsuaf.bean.Trainingvenue;

public class EquipmentModel extends BaseModel{
	private Integer equipNumber;
	private Trainingvenue trainingvenue;
	private String equipName;
	private Float ervValue;
	private Integer count;
	private Double allValue;
	private String useingStatus;
	private String year;
	public Integer getEquipNumber() {
		return equipNumber;
	}
	public void setEquipNumber(Integer equipNumber) {
		this.equipNumber = equipNumber;
	}
	public Trainingvenue getTrainingvenue() {
		return trainingvenue;
	}
	public void setTrainingvenue(Trainingvenue trainingvenue) {
		this.trainingvenue = trainingvenue;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public Float getErvValue() {
		return ervValue;
	}
	public void setErvValue(Float ervValue) {
		this.ervValue = ervValue;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAllValue() {
		return allValue;
	}
	public void setAllValue(Double allValue) {
		this.allValue = allValue;
	}
	public String getUseingStatus() {
		return useingStatus;
	}
	public void setUseingStatus(String useingStatus) {
		this.useingStatus = useingStatus;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
