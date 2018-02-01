package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.Model.SysuserinfoModel;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Expertmajor;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.BaseDaoImpl;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;


public class ExpertmajorService extends BaseServiceImpl<Expertmajor>{
	
	//取消所有分配
	public void deleteAll(){
		BaseDaoImpl b = new BaseDaoImpl();
		String sqlstring = "delete from Expertmajor";
		b.execute(sqlstring);
	}
	
	// 多条件查询
	public List<Expert> findExpertList(BaseModel basemodel,String mno,
			int page, int rows) {
		String hql = "from Expert as e where "
			+ "e.expertId like :tpno and "
			+ "e.expertName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		mapParam.put("tpno", "%" + basemodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + basemodel.getName() + "%");
		//用户类型
		if (basemodel.getYear() != null
				&& !"".endsWith(basemodel.getYear())) {
			if(basemodel.getYear().equals("0")){
				hql += " and e.expertId in(select expert.expertId from Expertmajor em where em.assessingproject.tag = '1' and em.major.mno='"
						+ mno + "')";
			}else{
				hql += " and e.expertId not in(select expert.expertId from Expertmajor em where em.assessingproject.tag = '1' and em.major.mno='"
					+ mno + "')";
			}
		}
		System.out.println(hql);
		List<Expert> list = (List<Expert>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println("----------"+list.size());
		return list;

	}
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindExpert(BaseModel basemodel,String mno) {
		int count;
		String hql = "select count(*) from Expert as e where "
			+ "e.expertId like :tpno and "
			+ "e.expertName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		mapParam.put("tpno", "%" + basemodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + basemodel.getName() + "%");
		//用户类型
		if (basemodel.getYear() != null
				&& !"".endsWith(basemodel.getYear())) {
			System.out.println("1");
			if(basemodel.getYear().equals("0")){
				System.out.println("2");
				hql += " and e.expertId in(select expert.expertId from Expertmajor em where em.assessingproject.tag = '1' and em.major.mno='"
						+ mno + "')";
			}else{
				System.out.println("3");
				hql += " and e.expertId not in(select expert.expertId from Expertmajor em where em.assessingproject.tag = '1' and em.major.mno='"
					+ mno + "')";
			}
		}
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	public List<Expertmajor> findByTag(){
		String hql = "from Expertmajor where assessingproject.tag = '1'";
		List<Expertmajor> list = (List<Expertmajor>) QueryUtilDaoImpl.executeQuery(hql,null);
		return list;
	}
}
