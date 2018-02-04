package cn.edu.hib.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import cn.edu.entity.json.OnlinetrainJson;
import cn.edu.entity.json.TonlinetrainJson;
import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.dao.TeacherinfoDAO;
import cn.edu.hib.dao.TonlinetrainDAO;
import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.hib.entity.Tonlinetrain;
import cn.edu.hib.entity.TonlinetrainId;
import cn.edu.model.Pager;

public class TonlinetrainService {
	@Resource
	TonlinetrainDAO tonlinetrainDAO;
	@Resource
	OnlinetrainDAO onlinetrainDAO;
	@Resource
	TeacherinfoDAO teacherinfoDAO;

	private int totalRows;

	public TonlinetrainDAO getTonlinetrainDAO() {
		return tonlinetrainDAO;
	}

	public void setTonlinetrainDAO(TonlinetrainDAO tonlinetrainDAO) {
		this.tonlinetrainDAO = tonlinetrainDAO;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public OnlinetrainDAO getOnlinetrainDAO() {
		return onlinetrainDAO;
	}

	public void setOnlinetrainDAO(OnlinetrainDAO onlinetrainDAO) {
		this.onlinetrainDAO = onlinetrainDAO;
	}

	public TeacherinfoDAO getTeacherinfoDAO() {
		return teacherinfoDAO;
	}

	public void setTeacherinfoDAO(TeacherinfoDAO teacherinfoDAO) {
		this.teacherinfoDAO = teacherinfoDAO;
	}

	public List<Tonlinetrain> findAll() {
		return tonlinetrainDAO.findAll();
	}

	public List<Tonlinetrain> findAllByContidtion(String trainno) {
		List<Tonlinetrain> all = tonlinetrainDAO.findAll();
		Iterator iter = all.iterator();
		while (iter.hasNext()) {
			Tonlinetrain temp = (Tonlinetrain) iter.next();
			if (!temp.getOnlinetrain().getTrainno().equals(trainno))
				iter.remove();
		}
		return all;
	}

	public List<Tonlinetrain> getUsersByCondition(Pager pager, String trainno) {
		List<Tonlinetrain> all = findAllByContidtion(trainno);
		return getUsersCommon(pager, all);
	}

	public List<Tonlinetrain> getUsersCommon(Pager pager, List<Tonlinetrain> all) {
		List<Tonlinetrain> tonlinetrains = new ArrayList<Tonlinetrain>();
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
			tonlinetrains.add(all.get(i));
		}
		return tonlinetrains;
	}

	public List<Tonlinetrain> getUsers(Pager pager) {
		List<Tonlinetrain> all = tonlinetrainDAO.findAll();
		return getUsersCommon(pager, all);
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void delTonlinetrains(List<String> rowIds) {
		Iterator<String> iter = rowIds.iterator();
		while (iter.hasNext()) {
			String rowId[] = iter.next().split("-");
			String tno = rowId[0];
			String trainno = rowId[1];
			tonlinetrainDAO.delete(new Tonlinetrain(new TonlinetrainId(tno,
					trainno), new Onlinetrain(trainno), new Teacherinfo(tno),
					"rank"));
		}
	}

	public Tonlinetrain getTonlinetrain(String rowid) {
		String rowId[] = rowid.split("-");
		String tno = rowId[0];
		String trainno = rowId[1];
		return tonlinetrainDAO.findById(new TonlinetrainId(tno, trainno));
	}

	public void addTonlineTrain(TonlinetrainJson addJson) {
		Tonlinetrain tonlinetrain = new Tonlinetrain();
		Onlinetrain onlinetrain = new Onlinetrain(addJson.getTrainno());
		Teacherinfo teacherinfo = new Teacherinfo(addJson.getTno());

		tonlinetrain.setAge(addJson.getAge());
		tonlinetrain.setAuditor(addJson.getAuditor());
		tonlinetrain.setCheckstatus(addJson.getCheckstatus());
		tonlinetrain.setDegree(addJson.getDegree());
		tonlinetrain.setEducation(addJson.getEducation());
		tonlinetrain.setGender(addJson.getGender());
		tonlinetrain.setId(new TonlinetrainId(addJson.getTno(), addJson
				.getTrainno()));
		tonlinetrain.setNote(addJson.getNote());
		tonlinetrain.setOnlinetrain(onlinetrain);
		tonlinetrain.setPeriod(addJson.getPeriod());
		tonlinetrain.setRank(addJson.getRank());
		tonlinetrain.setTeacherinfo(teacherinfo);
		tonlinetrain.setTname(addJson.getTname());
		tonlinetrain.setTunit(addJson.getTunit());

		// 先保存主类，再保存从类
		//onlinetrainDAO.save(onlinetrain);
		//teacherinfoDAO.save(teacherinfo);
		tonlinetrainDAO.save(tonlinetrain);
	}

	public void editTonlineTrain(TonlinetrainJson addJson) {
		Tonlinetrain tonlinetrain = new Tonlinetrain();
		tonlinetrain.setAge(addJson.getAge());
		tonlinetrain.setAuditor(addJson.getAuditor());
		tonlinetrain.setCheckstatus(addJson.getCheckstatus());
		tonlinetrain.setDegree(addJson.getDegree());
		tonlinetrain.setEducation(addJson.getEducation());
		tonlinetrain.setGender(addJson.getGender());
		tonlinetrain.setId(new TonlinetrainId(addJson.getTno(), addJson
				.getTrainno()));
		tonlinetrain.setNote(addJson.getNote());
		tonlinetrain.setOnlinetrain(new Onlinetrain(addJson.getTrainno()));
		tonlinetrain.setPeriod(addJson.getPeriod());
		tonlinetrain.setRank(addJson.getRank());
		tonlinetrain.setTeacherinfo(new Teacherinfo(addJson.getTno()));
		tonlinetrain.setTname(addJson.getTname());
		tonlinetrain.setTunit(addJson.getTunit());
		tonlinetrainDAO.attachDirty(tonlinetrain);
	}

}