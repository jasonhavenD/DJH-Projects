package cn.edu.hib.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import cn.edu.entity.json.TeacherinfoJson;
import cn.edu.hib.dao.TeacherinfoDAO;
import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.model.LoginStatus;
import cn.edu.model.Pager;

public class TeacherinfoService {

	@Resource
	TeacherinfoDAO teacherinfoDAO;
	private int totalRows;

	public Integer login(Teacherinfo teacherinfo) {
		List<Teacherinfo> list = this.teacherinfoDAO.findByProperty("tno",
				teacherinfo.getTno());
		if (list == null || list.size() == 0) {
			return LoginStatus.NAMENOEXIST;
		} else {
			for (Teacherinfo u : list) {
				if (teacherinfo.getPassword().equals(u.getPassword())) {
					return LoginStatus.LOGINSUCCESS;
				}
			}
			return LoginStatus.PASSWORDERROR;
		}
	}

	public Teacherinfo getUser(Teacherinfo user) {
		List<Teacherinfo> list = this.teacherinfoDAO.findByProperty("tno",
				user.getTno());
		if (list == null || list.size() == 0) {
			return user;
		} else {
			for (Teacherinfo u : list) {
				if (user.getPassword().equals(u.getPassword())) {
					return u;
				}
			}
		}
		return user;
	}

	public List<Teacherinfo> getUsers(Pager pager) {
		List<Teacherinfo> all = teacherinfoDAO.findAll();
		List<Teacherinfo> teacherinfos = new ArrayList<Teacherinfo>();

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
			teacherinfos.add(all.get(i));
		}
		return teacherinfos;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public List<Teacherinfo> findAll() {
		List<Teacherinfo> list = teacherinfoDAO.findAll();
		return list;
	}

	public Teacherinfo findByTno(Teacherinfo teacherinfo) {
		return teacherinfoDAO.findById(teacherinfo.getTno());
	}

	public TeacherinfoDAO getTeacherinfoDAO() {
		return teacherinfoDAO;
	}

	public void setTeacherinfoDAO(TeacherinfoDAO teacherinfoDAO) {
		this.teacherinfoDAO = teacherinfoDAO;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void delTeacherInfos(List<String> idList) {
		Iterator iter = idList.iterator();
		while (iter.hasNext()) {
			String tno = (String) iter.next();
			teacherinfoDAO.delete(new Teacherinfo(tno));
		}
	}

	public void addTeacherInfo(TeacherinfoJson addJson) {
		Teacherinfo teacherinfo = new Teacherinfo();
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addJson
					.getBirthday());
			teacherinfo.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		teacherinfo.setDegree(addJson.getDegree());
		teacherinfo.setEducation(addJson.getEducation());
		teacherinfo.setGender(addJson.getGender());
		teacherinfo.setGraduateuniversity(addJson.getGraduateuniversity());
		teacherinfo.setLoginstatus(addJson.getLoginstatus());
		teacherinfo.setMail(addJson.getMail());
		teacherinfo.setNote(addJson.getNote());
		teacherinfo.setPassword(addJson.getPassword());
		teacherinfo.setPhone(addJson.getPhone());
		teacherinfo.setTname(addJson.getTname());
		teacherinfo.setTno(addJson.getTno());
		teacherinfo.setTunit(addJson.getTunit());
		teacherinfo.setType(addJson.getType());
		teacherinfoDAO.save(teacherinfo);
	}

	public void editOnlineTrain(TeacherinfoJson addJson) {
		Teacherinfo teacherinfo = new Teacherinfo();
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(addJson
					.getBirthday());
			teacherinfo.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		teacherinfo.setDegree(addJson.getDegree());
		teacherinfo.setEducation(addJson.getEducation());
		teacherinfo.setGender(addJson.getGender());
		teacherinfo.setGraduateuniversity(addJson.getGraduateuniversity());
		teacherinfo.setLoginstatus(addJson.getLoginstatus());
		teacherinfo.setMail(addJson.getMail());
		teacherinfo.setNote(addJson.getNote());
		teacherinfo.setPassword(addJson.getPassword());
		teacherinfo.setPhone(addJson.getPhone());
		teacherinfo.setTname(addJson.getTname());
		teacherinfo.setTno(addJson.getTno());
		teacherinfo.setTunit(addJson.getTunit());
		teacherinfo.setType(addJson.getType());
		teacherinfo.setRank(addJson.getRank());
		teacherinfoDAO.attachDirty(teacherinfo);
	}

	public void ChangeloginStatus(Teacherinfo teacherinfo) {
		teacherinfo = getUser(teacherinfo);
		String status = teacherinfo.getLoginstatus();
		if (status != null && (status.equals("在线")||status.equals("1")))
			teacherinfo.setLoginstatus("在线");
		else
			teacherinfo.setLoginstatus("离线");
	}
}