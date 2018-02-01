package cn.edu.nwsuaf.Model;

import java.util.List;

public class ExportModel {

	private String mname;
	private String indicatorName;
	private String indicatorWeight;
	private String indicatorType;
	private String max;
	private String min;
	private String avg;
	private String score;
	private String ranking;
	private String classifyRanking;
	private List<ExportModel> list;
	public String getIndicatorName() {
		return indicatorName;
	}
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	public String getIndicatorWeight() {
		return indicatorWeight;
	}
	public void setIndicatorWeight(String indicatorWeight) {
		this.indicatorWeight = indicatorWeight;
	}
	public String getIndicatorType() {
		return indicatorType;
	}
	public void setIndicatorType(String indicatorType) {
		this.indicatorType = indicatorType;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getClassifyRanking() {
		return classifyRanking;
	}
	public void setClassifyRanking(String classifyRanking) {
		this.classifyRanking = classifyRanking;
	}
	public List<ExportModel> getList() {
		return list;
	}
	public void setList(List<ExportModel> list) {
		this.list = list;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
