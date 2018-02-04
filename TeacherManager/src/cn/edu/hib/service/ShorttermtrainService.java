package cn.edu.hib.service;

import static org.hibernate.criterion.Example.create;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import cn.edu.entity.json.ShorttermtrainJson;
import cn.edu.hib.dao.*;
import cn.edu.hib.entity.Shorttermtrain;
import cn.edu.hib.entity.ShorttermtrainId;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.model.Pager;

public class ShorttermtrainService {
	@Resource
	private ShorttermtrainDAO shorttermtrainDAO;
	@Resource
	private TeacherinfoDAO teacherinfoDAO;

	public void deleteShorttermtrain(List<String> idList) {
		// TODO Auto-generated method stub
		for (String string : idList) {
			String[] rowId = string.split("-");
			String trainno = rowId[0];
			String tno = rowId[1];
			shorttermtrainDAO.delete(new Shorttermtrain(new ShorttermtrainId(
					trainno, tno), new Teacherinfo(tno)));
		}

	}

	public void addShorttermtrain(ShorttermtrainJson shorttermtrainJson) {
		// TODO Auto-generated method stub
		// Teacherinfo teacherinfo = new
		// Teacherinfo(shorttermtrainJson.getTno());
		Shorttermtrain shorttermtrain = new Shorttermtrain();

		shorttermtrain.setId(new ShorttermtrainId(shorttermtrainJson
				.getTrainno(), shorttermtrainJson.getTno()));
		shorttermtrain.setTname(shorttermtrainJson.getTname());
		shorttermtrain.setTunit(shorttermtrainJson.getTunit());
		shorttermtrain.setAge(shorttermtrainJson.getAge());
		shorttermtrain.setRank(shorttermtrainJson.getRank());
		shorttermtrain.setEducation(shorttermtrainJson.getEducation());
		shorttermtrain.setDegree(shorttermtrainJson.getDegree());
		shorttermtrain.setTraintopic(shorttermtrainJson.getTraintopic());
		shorttermtrain.setTrainaddr(shorttermtrainJson.getTrainaddr());
		shorttermtrain.setPeriod(shorttermtrainJson.getPeriod());
		Date date = new Date(0);
		shorttermtrain.setStarttime(date.valueOf(shorttermtrainJson
				.getStarttime()));
		shorttermtrain
				.setEndtime(date.valueOf(shorttermtrainJson.getEndtime()));
		shorttermtrain.setNote(shorttermtrainJson.getNote());

		shorttermtrainDAO.save(shorttermtrain);
		// teacherinfoDAO.save(teacherinfo);
	}

	public void editshorttermtrain(ShorttermtrainJson shorttermtrainJson) {
		// TODO Auto-generated method stub
		Shorttermtrain shorttermtrain = new Shorttermtrain();
		shorttermtrain.setId(new ShorttermtrainId(shorttermtrainJson
				.getTrainno(), shorttermtrainJson.getTno()));
		shorttermtrain.setTname(shorttermtrainJson.getTname());
		shorttermtrain.setTunit(shorttermtrainJson.getTunit());
		shorttermtrain.setAge(shorttermtrainJson.getAge());
		shorttermtrain.setRank(shorttermtrainJson.getRank());
		shorttermtrain.setEducation(shorttermtrainJson.getEducation());
		shorttermtrain.setDegree(shorttermtrainJson.getDegree());
		shorttermtrain.setTraintopic(shorttermtrainJson.getTraintopic());
		shorttermtrain.setTrainaddr(shorttermtrainJson.getTrainaddr());
		shorttermtrain.setPeriod(shorttermtrainJson.getPeriod());
		Date date = new Date(0);
		shorttermtrain.setStarttime(date.valueOf(shorttermtrainJson
				.getStarttime()));
		shorttermtrain
				.setEndtime(date.valueOf(shorttermtrainJson.getEndtime()));
		shorttermtrain.setNote(shorttermtrainJson.getNote());

		shorttermtrainDAO.attachDirty(shorttermtrain);

	}

	public Shorttermtrain findById(String trainid) {
		String[] trainids = trainid.split("-");
		String trainno = trainids[0];
		String tno = trainids[1];
		return shorttermtrainDAO.findById(new ShorttermtrainId(trainno, tno));
	}

	public List<Shorttermtrain> findByPager(Pager pager) {
		// TODO Auto-generated method stub\
		System.out.println("findbypager");
		List<Shorttermtrain> shorttermtrains = shorttermtrainDAO.findAll();
		List<Shorttermtrain> result = new ArrayList<Shorttermtrain>();
		int pagerSize = pager.getPageSize();
		int pagerNo = pager.getPageNo();
		int totalRows = shorttermtrains.size();

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

		int startRow = pagerNo * pagerSize;
		pager.setStartRow(startRow);

		for (int i = startRow; i < startRow + pager.getPageSize()
				&& i < shorttermtrains.size(); i++) {
			result.add(shorttermtrains.get(i));
		}

		return result;

	}
	public List<Shorttermtrain> findByTno(Pager pager, Teacherinfo u) {
		// TODO Auto-generated method stub
		System.out.println("service_findbytno"+u.getTno());
		List<Shorttermtrain> temp = shorttermtrainDAO.findAll();
		
		
		List<Shorttermtrain> shorttermtrains = new ArrayList<Shorttermtrain>();

		for(Shorttermtrain iter : temp){
			if(iter.getTeacherinfo().getTno().equals(u.getTno()))
				shorttermtrains.add(iter);
		}
		
		
		
		System.out.println("shorttermtrains"+shorttermtrains);
		
		List<Shorttermtrain> result = new ArrayList<Shorttermtrain>();
		int pagerSize = pager.getPageSize();
		int pagerNo = pager.getPageNo();
		int totalRows = shorttermtrains.size();

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

		int startRow = pagerNo * pagerSize;
		pager.setStartRow(startRow);

		for (int i = startRow; i < startRow + pager.getPageSize()
				&& i < shorttermtrains.size(); i++) {
				result.add(shorttermtrains.get(i));
		}

		return result;
	}

	public ShorttermtrainDAO getShorttermtrainDAO() {
		return shorttermtrainDAO;
	}

	public void setShorttermtrainDAO(ShorttermtrainDAO shorttermtrainDAO) {
		this.shorttermtrainDAO = shorttermtrainDAO;
	}

	

}
