package cn.edu.nwsuaf.Service.Impl;


import java.util.List;

import cn.edu.nwsuaf.bean.National;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class NationalService extends BaseServiceImpl<National>{
	@SuppressWarnings("unchecked")
	public List<National> findEntityByName(String nationalName){
		String hql="from National as a where a.nationName=?";
		String mapparm[]={nationalName};
		List<National> national=(List<National>) QueryUtilDaoImpl.executeQuery(hql, mapparm);
		return national;
	}
}
