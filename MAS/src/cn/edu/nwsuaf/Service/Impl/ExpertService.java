package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.ExpertModel;
import cn.edu.nwsuaf.Model.SysuserinfoModel;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class ExpertService extends BaseServiceImpl<Expert> {

	// 初始化查询专家信息
	public List<Expert> findallExpertmanageList(int page, int rows) {
		String hql = "from Expert";
		List<Expert> list = (List<Expert>) QueryUtilDaoImpl.executeQueryByPage(
				hql, null, page, rows);
		System.out.println("list.size()===" + list.size());
		return list;
	}

	// 初始化查询专家记录总数
	public int countExpertmanage() throws ServiceException {
		int count = 0;
		String hql = "select count(*) from Expert";
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}

	// 条件查询专家信息
	@SuppressWarnings("unchecked")
	public List<Expert> findExpertmanageList(ExpertModel expertModel, int page,
			int rows) {
		if (expertModel == null) {
			String hql = "from Expert";
			List<Expert> list = (List<Expert>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, page, rows);
			return list;
		}

		String hql = "from Expert as e where " + "e.expertId like :tpno and "
				+ "e.expertName like :tpn";
		Map mapParam = new HashMap();
		// 专家编号
		mapParam.put("tpno", "%" + expertModel.getId() + "%");
		// 专家名称
		mapParam.put("tpn", "%" + expertModel.getName() + "%");
		// 用户类型
		if (expertModel.getType() != null
				&& !"".endsWith(expertModel.getType())) {

			hql += " and e.type='" + expertModel.getType() + "'";
		}
		System.out.println(hql);
		List<Expert> list = (List<Expert>) QueryUtilDaoImpl.executeQueryByPage(
				hql, null, mapParam, page, rows);
		System.out.println(list.size());
		return list;

	}

	// 条件查询专家记录总数
	public int countFindExpertmanage(ExpertModel expertModel) {
		int count;
		if (expertModel == null) {
			String hql = "select count(*) from Expert";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
			return count;
		}
		
		String hql = "select count(*) from Expert as e where "
				+ "e.expertId like :tpno and " + "e.expertName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		mapParam.put("tpno", "%" + expertModel.getId() + "%");
		// 用户名
		mapParam.put("tpn", "%" + expertModel.getName() + "%");
		// 用户类型
		if (expertModel.getType() != null
				) {

			hql += " and e.type='" + expertModel.getType() + "'";
		}
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;
	}

	public void updatePassword(String userCode, String password) {
		// TODO Auto-generated method stub
		try {
			Expert expert = this.findById(Expert.class, userCode);
			expert.setPassword(password);
			this.update(expert);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
