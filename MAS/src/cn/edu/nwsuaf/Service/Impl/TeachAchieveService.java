package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.bean.Teacherachievements;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class TeachAchieveService extends BaseServiceImpl<Teacherachievements> {

	@SuppressWarnings("unchecked")
	// 查询
	public List<Teacherachievements> findTeachAchiList(
			Teacherachievements teacherachievements, int page, int rows,
			String certificateNo) {
		String hql = "from Teacherachievements as sp where sp.achievements.certificateNo like :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", "%" + certificateNo + "%");
		List<Teacherachievements> list = (List<Teacherachievements>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.toString());
		return list;

	}

	// 查询总条数
	@SuppressWarnings("unchecked")
	public int findTeachAchi(Teacherachievements teacherachievements,
			String certificateNo) {
		int count = 0;
		String hql = "select count(*) from Teacherachievements as sp where sp.achievements.certificateNo like :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", "%" + certificateNo + "%");

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}

	// 导出
	@SuppressWarnings("unchecked")
	public List<Teacherachievements> exportTeachAchiList(
			Teacherachievements teacherachievements, String certificateNo) {
		String hql = "from Teacherachievements as sp where sp.achievements.certificateNo like :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", "%" + certificateNo + "%");
		List<Teacherachievements> list = (List<Teacherachievements>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		System.out.println("list=========" + list.toString());
		return list;

	}

}
