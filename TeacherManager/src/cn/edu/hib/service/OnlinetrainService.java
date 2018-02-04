package cn.edu.hib.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.edu.entity.json.OnlinetrainJson;
import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.dao.TeacherinfoDAO;
import cn.edu.hib.dao.TonlinetrainDAO;
import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.hib.entity.Tonlinetrain;
import cn.edu.hib.entity.TonlinetrainId;
import cn.edu.model.Pager;

public class OnlinetrainService {
	@Resource
	public OnlinetrainDAO onlinetrainDAO;
	@Resource
	public TonlinetrainDAO tonlinetrainDAO;
	@Resource
	public TeacherinfoDAO teacherinfoDAO;

	private int totalRows;
	private List<Boolean> enrollFlags;

	public List<Onlinetrain> getUsers(Pager pager) {
		enrollFlags = new ArrayList<Boolean>();
		// 获取当前登录对象
		Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("loginedUser");

		List<Onlinetrain> all = onlinetrainDAO.findAll();
		List<Onlinetrain> onlinetrains = new ArrayList<Onlinetrain>();

		Integer pagerSize = pager.getPageSize();
		Integer pagerNo = pager.getPageNo();
		totalRows = all.size();
		pager.setTotalRows(totalRows);
		if (totalRows == 0) {
			pager.setPageNo(0);
			pagerNo = 0;
		} else {
			if (totalRows / pagerSize == 0) {
				pager.setPageNo(0);
				pagerNo = 0;
			} else {
				int totalPager = totalRows / pagerSize;
				if (totalRows % pagerSize > 0) {
					totalPager += 1;
				}
				pager.setTotalPages(totalPager);
			}
		}
		int start = pagerNo * pagerSize;
		pager.setStartRow(start + 1);
		for (int i = start; i < start + pager.getPageSize() && i < all.size(); i++) {
			Onlinetrain temp = all.get(i);
			onlinetrains.add(temp);
			// 查询是否已经报名
			Tonlinetrain temp2 = tonlinetrainDAO.findById(new TonlinetrainId(u
					.getTno(), temp.getTrainno()));
			if (temp2 != null) {
				enrollFlags.add(true);
			} else
				enrollFlags.add(false);
		}
		return onlinetrains;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public List findAll() {
		return onlinetrainDAO.findAll();
	}

	public void delOnlineTrains(List<String> trainnos) {
		Iterator iter = trainnos.iterator();
		while (iter.hasNext()) {
			String trainno = (String) iter.next();
			onlinetrainDAO.delete(new Onlinetrain(trainno));
		}
	}

	public void editOnlineTrain(OnlinetrainJson editJson) {
		Onlinetrain onlinetrain = new Onlinetrain();
		onlinetrain.setTrainno(editJson.getTrainno());
		onlinetrain.setNote(editJson.getNote());
		onlinetrain.setOffstatus(editJson.getOffstatus());
		onlinetrain.setPeriod(Integer.valueOf(editJson.getPeriod()));
		onlinetrain.setTrainname(editJson.getTrainname());
		// date type
		java.sql.Date time = new java.sql.Date(0);
		onlinetrain.setStarttime(time.valueOf(editJson.getStarttime()));
		onlinetrain.setEndtime(time.valueOf(editJson.getEndtime()));
		onlinetrainDAO.attachDirty(onlinetrain);
	}

	public void addOnlineTrain(OnlinetrainJson addJson) {
		Onlinetrain onlinetrain = new Onlinetrain();
		onlinetrain.setTrainno(addJson.getTrainno());
		onlinetrain.setNote(addJson.getNote());
		onlinetrain.setOffstatus(addJson.getOffstatus());
		onlinetrain.setPeriod(Integer.valueOf(addJson.getPeriod()));
		onlinetrain.setTrainname(addJson.getTrainname());
		java.sql.Date time = new java.sql.Date(0);
		onlinetrain.setStarttime(time.valueOf(addJson.getStarttime()));
		onlinetrain.setEndtime(time.valueOf(addJson.getEndtime()));
		onlinetrainDAO.save(onlinetrain);
	}

	public Onlinetrain getOnlinetrain(String trainno) {
		List<Onlinetrain> onlinetrains = onlinetrainDAO.findAll();
		Iterator<Onlinetrain> iterator = onlinetrains.iterator();
		while (iterator.hasNext()) {
			Onlinetrain onlinetrain = iterator.next();
			if (onlinetrain.getTrainno().contains(trainno)) {
				return onlinetrain;
			}
		}
		return null;
	}

	public OnlinetrainDAO getOnlinetrainDAO() {
		return onlinetrainDAO;
	}

	public void setOnlinetrainDAO(OnlinetrainDAO onlinetrainDAO) {
		this.onlinetrainDAO = onlinetrainDAO;
	}

	public TonlinetrainDAO getTonlinetrainDAO() {
		return tonlinetrainDAO;
	}

	public void setTonlinetrainDAO(TonlinetrainDAO tonlinetrainDAO) {
		this.tonlinetrainDAO = tonlinetrainDAO;
	}

	public List<Boolean> getEnrollFlags() {
		return enrollFlags;
	}

	public void enroll(Teacherinfo u, String trainno) {
		Teacherinfo teacherinfo = teacherinfoDAO.findById(u.getTno());
		Onlinetrain onlinetrain = onlinetrainDAO.findById(trainno);
		// date type
		Date birthday = teacherinfo.getBirthday();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		int age = now.getYear() - birthday.getYear() + 1;
		tonlinetrainDAO.save(new Tonlinetrain(new TonlinetrainId(u.getTno(),
				trainno), onlinetrain, teacherinfo, teacherinfo.getTname(),
				teacherinfo.getGender(), teacherinfo.getTunit(), age,
				teacherinfo.getRank(), teacherinfo.getEducation(), teacherinfo
						.getDegree(), onlinetrain.getPeriod(), "", onlinetrain
						.getOffstatus(), onlinetrain.getNote()));
	}

	public void cancel(Teacherinfo u, String trainno) {
		Teacherinfo teacherinfo = teacherinfoDAO.findById(u.getTno());
		Onlinetrain onlinetrain = onlinetrainDAO.findById(trainno);
		// date type
		Date birthday = teacherinfo.getBirthday();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		int age = now.getYear() - birthday.getYear() + 1;
		tonlinetrainDAO.delete(new Tonlinetrain(new TonlinetrainId(u.getTno(),
				trainno), onlinetrain, teacherinfo, teacherinfo.getTname(),
				teacherinfo.getGender(), teacherinfo.getTunit(), age,
				teacherinfo.getRank(), teacherinfo.getEducation(), teacherinfo
						.getDegree(), onlinetrain.getPeriod(), "", onlinetrain
						.getOffstatus(), onlinetrain.getNote()));
	}

}