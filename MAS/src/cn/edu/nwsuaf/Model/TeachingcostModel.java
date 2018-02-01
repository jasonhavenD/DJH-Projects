package cn.edu.nwsuaf.Model;

import cn.edu.nwsuaf.bean.Teachingcosttype;


public class TeachingcostModel extends BaseModel{
	
	private Integer costNumber;
	private Integer stuNumber;
	private Teachingcosttype teachingcosttype=new Teachingcosttype() ;
	
	private Float cost;
	private String useness;
	private Integer tag;
	public TeachingcostModel(Integer costNumber, Integer stuNumber,
			Teachingcosttype teachingcosttype, Float cost, String useness,
			Integer tag) {
		super();
		this.costNumber = costNumber;
		this.stuNumber = stuNumber;
		this.teachingcosttype = teachingcosttype;
		this.cost = cost;
		this.useness = useness;
		this.tag = tag;
	}
	
	
	public TeachingcostModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCostNumber() {
		return costNumber;
	}
	public void setCostNumber(Integer costNumber) {
		this.costNumber = costNumber;
	}
	
	
	public Integer getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(Integer stuNumber) {
		this.stuNumber = stuNumber;
	}
	
	
	
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	
	
	public String getUseness() {
		return useness;
	}
	public void setUseness(String useness) {
		this.useness = useness;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public void setTeachingcosttype(Teachingcosttype teachingcosttype) {
		this.teachingcosttype = teachingcosttype;
	}
	public Teachingcosttype getTeachingcosttype() {
		return teachingcosttype;
	}
	
	
	
}
