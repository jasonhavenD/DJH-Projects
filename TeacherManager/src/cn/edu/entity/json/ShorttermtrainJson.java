package cn.edu.entity.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.hib.entity.Shorttermtrain;


public class ShorttermtrainJson implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String trainno;
	private String tno;
	private String tname;
	private String tunit;
	private Integer age;
	private String rank;
	private String education;
	private String degree;
	private String traintopic;
	private String trainaddr;
	private Integer period;
	private String starttime;
	private String endtime;
	private String note;
	
	public ShorttermtrainJson() {
		super();
	}
	
	public ShorttermtrainJson(Shorttermtrain shorttermtrain) {
		super();
		this.trainno = shorttermtrain.getId().getTrainno();
		this.tno = shorttermtrain.getId().getTno();
		this.tname = shorttermtrain.getTname();
		this.tunit = shorttermtrain.getTunit();
		this.age = shorttermtrain.getAge();
		this.rank = shorttermtrain.getRank();
		this.education = shorttermtrain.getEducation();
		this.degree = shorttermtrain.getDegree();
		this.traintopic = shorttermtrain.getTraintopic();
		this.trainaddr = shorttermtrain.getTrainaddr();
		this.period = shorttermtrain.getPeriod();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.starttime = format.format(new Date(shorttermtrain.getStarttime().getTime()));
		this.endtime = format.format(new Date(shorttermtrain.getEndtime().getTime()));
		this.note = shorttermtrain.getNote();
		
	}
	
	

	public ShorttermtrainJson(String trainno, String tno, String tname,
			String tunit, Integer age, String rank, String education,
			String degree, String traintopic, String trainaddr, Integer period,
			String starttime, String endtime, String note) {
		super();
		this.trainno = trainno;
		this.tno = tno;
		this.tname = tname;
		this.tunit = tunit;
		this.age = age;
		this.rank = rank;
		this.education = education;
		this.degree = degree;
		this.traintopic = traintopic;
		this.trainaddr = trainaddr;
		this.period = period;
		this.starttime = starttime;
		this.endtime = endtime;
		this.note = note;
	}

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

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

	public String getTunit() {
		return tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTraintopic() {
		return traintopic;
	}

	public void setTraintopic(String traintopic) {
		this.traintopic = traintopic;
	}

	public String getTrainaddr() {
		return trainaddr;
	}

	public void setTrainaddr(String trainaddr) {
		this.trainaddr = trainaddr;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ShorttermtrainJson [trainno=" + trainno + ", tno=" + tno
				+ ", tname=" + tname + ", tunit=" + tunit + ", age=" + age
				+ ", rank=" + rank + ", education=" + education + ", degree="
				+ degree + ", traintopic=" + traintopic + ", trainaddr="
				+ trainaddr + ", period=" + period + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", note=" + note + "]";
	}


	

}
