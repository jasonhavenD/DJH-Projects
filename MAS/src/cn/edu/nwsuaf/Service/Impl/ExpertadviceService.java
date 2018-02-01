package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import cn.edu.nwsuaf.bean.Expertadvice;
import cn.edu.nwsuaf.bean.Expertmajor;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.BaseDaoImpl;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.util.QueryUtil;

public class ExpertadviceService extends BaseServiceImpl<Expertadvice> {

	// 通过mno获取expertmajor实体
	public List<Expertmajor> findexpertmajor(String mno) {
		// Expertmajor em = null;
		List list = null;
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		String hql = "FROM Expertmajor em WHERE em.assessingproject.tag = '1' and em.expert.expertId = '"
				+ sysuserinfo.getUserCode() + "' AND em.major.mno = '" + mno
				+ "'";
		System.out.println(hql);
		list = (List<Expertmajor>) QueryUtilDaoImpl.executeQuery(hql, null);
		return list;
	}

	public void updateEA(int emc, String question, String advice) {
		System.out.println("sdadsaf");
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		System.out.println("..." + sysuserinfo.getUserCode());
		String hql = "update Expertadvice set question = '" + question
				+ "',advice = '" + advice
				+ "' where expertmajor.expertMajorCode='" + emc + "'";
		System.out.println(hql);
		QueryUtilDaoImpl.executeUpdate(hql, null);
	}

	public Expertadvice findEA(int emc) {
		List list = null;
		Sysuserinfo sysuserinfo = QueryUtil.getUserMno();
		String hql = "from Expertadvice where expertmajor.assessingproject.tag = '1' and expertmajor.expertMajorCode='"
				+ emc + "'";
		list = (List<Expertmajor>) QueryUtilDaoImpl.executeQuery(hql, null);
		return (Expertadvice) list.get(0);
	}

	public List<Expertadvice> searchByModel(String mno, String expertName) {
		
		String hql = "from Expertadvice as ea where  ea.expertmajor.assessingproject.tag = '1' and ea.expertmajor.major.mno='"
				+ mno + "'" + " and ea.expertmajor.expert.expertName like '%"
				+ expertName + "%' order by ea.expertmajor.major.mname asc";

		if (("".equals(mno) && "".equals(expertName))
				|| (mno == null && expertName == null)) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1'order by ea.expertmajor.major.mname asc";
		}

		else if ("".equals(mno)||mno == null) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1' and ea.expertmajor.expert.expertName like '%"
					+ expertName + "%' order by ea.expertmajor.major.mname asc";

		} else if ("".equals(expertName)||expertName == null) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1' and ea.expertmajor.major.mno = '"
					+ mno + "'order by ea.expertmajor.major.mname asc";
		}
		System.out.println(hql);
		return (List<Expertadvice>) QueryUtilDaoImpl.executeQuery(hql, null);
	}
	

	public List<Expertadvice> searchByModelPage(String mno, String expertName,
			int page, int rows) {
		String hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1' and  ea.expertmajor.major.mno='"
				+ mno + "'" + " and ea.expertmajor.expert.expertName like '%"
				+ expertName + "%' order by ea.expertmajor.major.mname asc";

		if (("".equals(mno) && "".equals(expertName))
				|| (mno == null && expertName == null)) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1'  order by ea.expertmajor.major.mname asc";
		}

		else if ("".equals(mno)||mno == null) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1' and ea.expertmajor.expert.expertName like '%"
					+ expertName + "%' order by ea.expertmajor.major.mname asc";

		} else if ("".equals(expertName)||expertName == null) {
			hql = "from Expertadvice as ea where ea.expertmajor.assessingproject.tag = '1' and ea.expertmajor.major.mno = '"
					+ mno + "'order by ea.expertmajor.major.mname asc";
		}
		System.out.println(hql);
		return (List<Expertadvice>) QueryUtilDaoImpl.executeQueryByPage(hql,
				null, null, page, rows);
	}
	public String findByIdName(Class<Major> c, String id) {
		// TODO Auto-generated method stub
		BaseDaoImpl bdi=new BaseDaoImpl();
		Major m = null;
		m=(Major)bdi.findById(c,id);
		return m.getMname();
	}

}
