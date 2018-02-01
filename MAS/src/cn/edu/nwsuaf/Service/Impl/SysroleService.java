package cn.edu.nwsuaf.Service.Impl;

import java.util.List;

import cn.edu.nwsuaf.bean.Sysrole;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class SysroleService extends BaseServiceImpl<Sysrole> {
	//查找所有数据
	@SuppressWarnings("unchecked")
	public List<Sysrole> findallSysroleList(int page, int rows) {

		String hql = "from Sysrole";
		List<Sysrole> list = (List<Sysrole>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}
	
	public int isExist(String tpno) {
		
		int count=0;
		String hql = "select count(*) from Sysrole as role where "
				+ "role.roleCode = '"+ tpno+"'";
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
		return count;
	}
}
