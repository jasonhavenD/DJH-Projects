package cn.edu.nwsuaf.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.ExpertscoreModel;
import cn.edu.nwsuaf.Model.FileinfoAttachmentModel;
import cn.edu.nwsuaf.Model.FulfillinginstanceModel;
import cn.edu.nwsuaf.bean.Assessingneedtarget;
import cn.edu.nwsuaf.bean.Expertscore;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.bean.Fulfillinginstance;
import cn.edu.nwsuaf.bean.Major;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class ExpertscoreService extends BaseServiceImpl<Expertscore> {
	// 获取年份列表
	public List<String> findYearList() throws ServiceException {
		List list = null;
		try {
			String hql = "SELECT DISTINCT exp.fileinfoAttachment.year FROM Expertscore AS exp where exp.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1'";
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
			Collections.sort(list);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败", e);

		}
		return list;
	}

	// 获取专业列表
	public List<Major> findMajorList(Sysuserinfo sysuserinfo,boolean isExpert) {

		List list = null;
		String hql = null;
		if (isExpert) {
			hql = "select DISTINCT em.major from Expertmajor as em where em.assessingproject.tag = '1' and em.expert.expertId='"
					+ sysuserinfo.getUserCode()+"'";

		} else {
			hql = "select DISTINCT em.major from Expertmajor as em where em.assessingproject.tag = '1'";

		}
		list = this.findByHQL(hql);
		return list;
	}

	// 获取附件列表根据年份和专业-确实是唯一的-------------------------------------youwenti
	public Expertscore findByIdyear(String ExptuserID, String year)
			throws ServiceException {
		Expertscore f = null;
		try {
			String hql = "select * from Expertscore as exp where em.sysuserinfo.userCode='"
					+ ExptuserID
					+ "'"
					+ " and exp.fileinfoAttachment.year= '"
					+ year + "'";
			f = (Expertscore) QueryUtilDaoImpl.executeQuery(hql, null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询附件列表失败", e);

		}
		return f;
	}

	// 获取所有专业评分列表
	@SuppressWarnings("unchecked")
	public List<Expertscore> findallExpertscoreList(int page, int rows,
			Sysuserinfo sysuserinfo,boolean isExpert) {
		String hql = "";
		List<Expertscore> list = null;
		System.out.println(isExpert);
		if (isExpert) {
			hql = "from Expertscore t where  t.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1' and t.expert.expertId=?";
			//hql+= "order by fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			hql+= " order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			String param[] = { sysuserinfo.getUserCode() };
			System.out.println(sysuserinfo.getUserCode());
			System.out.println("hqlz"+hql);
			list = (List<Expertscore>) QueryUtilDaoImpl.executeQueryByPage(hql,
					param, page, rows);
		} else {
			hql = "from Expertscore as exp where exp.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1'";
			//hql+= " order by fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			hql+= " order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			String param[] = null;
			System.out.println("hql"+hql);
			list = (List<Expertscore>) QueryUtilDaoImpl.executeQueryByPage(hql,
					param, page, rows);
		}
		return list;
	}

	// 多条件查询结果获取专业评分列表
	@SuppressWarnings("unchecked")
	public List<Expertscore> findExpertscoreList(
			ExpertscoreModel expertscoreModel, int page, int rows,
			Sysuserinfo sysuserinfo,boolean isExpert) throws ServiceException {

		List<Expertscore> list = null;
		
		if(expertscoreModel.getIndicatorName() == null)
			expertscoreModel.setIndicatorName("");
		
//		String hql = " from Expertscore as es where es.fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName like '%"
//			+ expertscoreModel.getIndicatorName() + "%'";
		
		String hql = "from Expertscore as es where es.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1' and es.fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName like :tpname";
		Map mapParam = new HashMap();
		
		// 指标名

		mapParam.put("tpname", "%" + expertscoreModel.getIndicatorName() + "%");
		
		try {
			// 专业
			if (expertscoreModel.getMajorId() != null
					&& !"".equals(expertscoreModel.getMajorId())&& !"%".equals(expertscoreModel.getMajorId())) {

				hql += " and es.fileinfoAttachment.mas.major.mno='"
						+ expertscoreModel.getMajorId() + "'";
			}
			// 得分
			if (expertscoreModel.getIsScore() != null
					&& !"".equals(expertscoreModel.getIsScore())) {
				if("否".equals(expertscoreModel.getIsScore()))
				{
					hql += " and es.asseisingValue=null";
				}else{
					hql += " and es.asseisingValue<>null";
				}		
			}
			// 专家名字
			if (expertscoreModel.getName() != null && !"".equals(expertscoreModel.getName())) {
				hql += " and es.expert.expertName like '%"
					+ expertscoreModel.getName() + "%'";		
			}
			if (isExpert) {
					hql += " and es.expert.expertId='"
						+ sysuserinfo.getUserCode() + "'";			
			} 
			hql+= " order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
//			hql+= " order by fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
           System.out.println("hql:"+hql);
		   list = (List<Expertscore>) QueryUtilDaoImpl.executeQueryByPage(hql, null, mapParam, page, rows);
//		   list = (List<Expertscore>) QueryUtilDaoImpl.executeQueryByPage(hql, null, page, rows);
		   
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}

		return list;

	}

	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindFia(ExpertscoreModel expertscoreModel,Sysuserinfo sysuserinfo,boolean isExpert)
			throws ServiceException {

		int count = 0;
		String hql = "select count(*) from Expertscore as es where es.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1' and es.fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName like :tpname";
		
		if(expertscoreModel.getIndicatorName() == null)
			expertscoreModel.setIndicatorName("");
		
		Map mapParam = new HashMap();
		// 指标名
		mapParam.put("tpname", "%" + expertscoreModel.getIndicatorName() + "%");
		
		try {
			// 专业
			if (expertscoreModel.getMajorId() != null
					&& !"".equals(expertscoreModel.getMajorId())&& !"%".equals(expertscoreModel.getMajorId())) {

				hql += " and es.fileinfoAttachment.mas.major.mno='"
						+ expertscoreModel.getMajorId() + "'";
			}
			if (expertscoreModel.getName() != null && !"".equals(expertscoreModel.getName())) {
				hql += " and es.expert.expertName like '%"
					+ expertscoreModel.getName() + "%'";		
			}
			
			if (expertscoreModel.getIsScore() != null
					&& !"".equals(expertscoreModel.getIsScore())) {
				if("否".equals(expertscoreModel.getIsScore()))
				{
					hql += " and es.asseisingValue=null";
				}else{
					hql += " and es.asseisingValue<>null";
				}		
			}
			if (isExpert) {
					hql += " and es.expert.expertId='"
						+ sysuserinfo.getUserCode() + "'";			
			} 
			hql+= " order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
            count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
			
		} catch (Exception e) {
			throw new ServiceException("多条件查询失败", e);
		}
     return count;
	}

	public int count(Sysuserinfo sysuserinfo,boolean isExpert) throws ServiceException {
		int count = 0;
		String hql = "select count(*) ";
		if (isExpert) {
			hql += "from Expertscore t where t.fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1' and t.expert.expertId=?";
			hql+= "order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			String param[] = { sysuserinfo.getUserCode() };
			System.out.println("hql"+hql);
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else {
			hql += "from Expertscore where fileinfoAttachment.mas.assessingneedtarget.assessingproject.tag = '1'";
			String param[] = null;
			System.out.println("hql"+hql);
			hql+= " order by fileinfoAttachment.mas.major,fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}
		return count;
	}

}
