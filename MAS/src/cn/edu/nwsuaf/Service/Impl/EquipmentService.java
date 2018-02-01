package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.bean.Equipment;

import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class EquipmentService extends BaseServiceImpl<Equipment> {
    
	@SuppressWarnings("unchecked")
	// 查询
	public List<Equipment> findEquipmentList(Equipment Equipment,
			String traNumer) {
		String hql = "from Equipment as sp where sp.trainingvenue.traNumer= '"+traNumer+"'";

		List<Equipment> list = (List<Equipment>) QueryUtilDaoImpl
				.executeQuery(hql, null, null);
		System.out.println(list.toString());
		return list;

	}
	// 查询总条数
	@SuppressWarnings("unchecked")
	public int findEquipment(Equipment Equipment,String traNumer
			)
			{
		int count = 0;
		String hql = "select count(*) from Equipment as sp where sp.trainingvenue.traNumer like :an";

		Map mapParam = new HashMap();
		// 编号
		mapParam.put("an", "%" + traNumer+ "%");
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	
}
