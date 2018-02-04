package cn.edu.entity.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.hib.entity.Onlinetrain;

public class OnlinetrainJson implements java.io.Serializable {

	private String trainno;
	private String trainname;
	private Integer period;
	private String starttime;
	private String endtime;
	private Integer offstatus;
	private String note;

	public OnlinetrainJson() {
	}

	public OnlinetrainJson(Onlinetrain onlinetrain) {
		trainno = onlinetrain.getTrainno();
		trainname = onlinetrain.getTrainname();
		period = onlinetrain.getPeriod();
		offstatus = onlinetrain.getOffstatus();
		note = onlinetrain.getNote();
		// date type
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		starttime = (form
				.format(new Date(onlinetrain.getStarttime().getTime())));
		endtime = (form.format(new Date(onlinetrain.getEndtime().getTime())));
	}

	public OnlinetrainJson(String trainno, String trainname, Integer period,
			String starttime, String endtime, Integer offstatus, String note) {
		super();
		this.trainno = trainno;
		this.trainname = trainname;
		this.period = period;
		this.starttime = starttime;
		this.endtime = endtime;
		this.offstatus = offstatus;
		this.note = note;
	}

	
	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
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

	public Integer getOffstatus() {
		return offstatus;
	}

	public void setOffstatus(Integer offstatus) {
		this.offstatus = offstatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "OnlinetrainJson [trainno=" + trainno + ", trainname="
				+ trainname + ", period=" + period + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", offstatus=" + offstatus
				+ ", note=" + note + "]";
	}

}