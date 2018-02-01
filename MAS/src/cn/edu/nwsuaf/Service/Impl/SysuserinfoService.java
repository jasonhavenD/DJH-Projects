package cn.edu.nwsuaf.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.Model.SysuserinfoModel;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class SysuserinfoService extends BaseServiceImpl<Sysuserinfo> {
	//查找所有数据
	@SuppressWarnings("unchecked")
	public List<Sysuserinfo> findallSysuserinfoList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Sysuserinfo> list = null;
		if(!mno.equals("000000")){
			hql="from Sysuserinfo as userinfo where userinfo.major.mno=?";
			String param[]={mno};
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Sysuserinfo as userinfo where userinfo.department.dno=?";
			String param[]={dno};
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Sysuserinfo";
			
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Sysuserinfo> findallExpertmanageList(int page, int rows, String mno,String dno) {
		String hql = "";
		List<Sysuserinfo> list = null;
		if(!mno.equals("000000")){
			hql="from Sysuserinfo as userinfo where userinfo.major.mno=? and userinfo.sysrole=5";
			String param[]={mno};
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="from Sysuserinfo as userinfo where userinfo.department.dno=? and userinfo.sysrole=5";
			String param[]={dno};
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, param, page, rows);
		}else{
			hql="from Sysuserinfo as userinfo where userinfo.sysrole.roleCode='5'";
			
			list = (List<Sysuserinfo>) QueryUtilDaoImpl
			.executeQueryByPage(hql, null, page, rows);
			System.out.println("list.size()==="+list.size());
			
		}
		return list;
	}
	//修改用户密码
	public void modifyPasswd(Sysuserinfo sysuserinfo){
		try {
			this.update(sysuserinfo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	// 多条件查询
	public List<Sysuserinfo> findSysuserinfoList(SysuserinfoModel usermodel,
			int page, int rows) {
		String hql = "from Sysuserinfo as userinfo where "
			+ "userinfo.userCode like :tpno and "
			+ "userinfo.userName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		System.out.println("id="+usermodel.getId()+"name"+usermodel.getName()+"end");
		mapParam.put("tpno", "%" + usermodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + usermodel.getName() + "%");
		// 专业
		if (usermodel.getMajorId() != null && !"".equals(usermodel.getMajorId()) && !"null".equals(usermodel.getMajorId())&& !"%".equals(usermodel.getMajorId())) {

			hql += " and userinfo.major.mno='" + usermodel.getMajorId() + "'";
		}
		// 学院
		if (usermodel.getDepartmentId() != null
				&& !"".endsWith(usermodel.getDepartmentId())) {

			hql += " and userinfo.department.dno='"
					+ usermodel.getDepartmentId() + "'";
		}
		//角色编号
		if (usermodel.getRole() != null
				&& !"".endsWith(usermodel.getRole())) {

			hql += " and userinfo.sysrole.roleCode='"
					+ usermodel.getRole() + "'";
		}
		//用户类型
		if (usermodel.getUserType() != null
				&& !"".endsWith(usermodel.getUserType())) {

			hql += " and userinfo.userType='"
					+ usermodel.getUserType() + "'";
		}
		System.out.println(hql);
		List<Sysuserinfo> list = (List<Sysuserinfo>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.size());
		return list;

	}
	@SuppressWarnings("unchecked")
	public List<Sysuserinfo> findExpertmanageList(SysuserinfoModel usermodel,
			int page, int rows) {
		String hql = "from Sysuserinfo as userinfo where "
			+ "userinfo.userCode like :tpno and "
			+ "userinfo.userName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		System.out.println("id="+usermodel.getId()+"name"+usermodel.getName()+"end");
		mapParam.put("tpno", "%" + usermodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + usermodel.getName() + "%");
		//用户类型
		if (usermodel.getUserType() != null
				&& !"".endsWith(usermodel.getUserType())) {

			hql += " and userinfo.userType='"
					+ usermodel.getUserType() + "'";
		}
		hql += " and userinfo.sysrole.roleCode='5'";
		System.out.println(hql);
		List<Sysuserinfo> list = (List<Sysuserinfo>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		System.out.println(list.size());
		return list;

	}
	// 查询结果条数
	@SuppressWarnings("unchecked")
	public int countFindSysuserinfo(SysuserinfoModel usermodel) {
		int count;
		String hql = "select count(*) from Sysuserinfo as userinfo where "
			+ "userinfo.userCode like :tpno and "
			+ "userinfo.userName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		mapParam.put("tpno", "%" + usermodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + usermodel.getName() + "%");
		// 专业
		if (usermodel.getMajorId() != null && !"".equals(usermodel.getMajorId())&& !"%".equals(usermodel.getMajorId())) {

			hql += " and userinfo.major.mno='" + usermodel.getMajorId() + "'";
		}
		// 学院
		if (usermodel.getDepartmentId() != null
				&& !"".endsWith(usermodel.getDepartmentId())) {

			hql += " and userinfo.major.department.dno='"
					+ usermodel.getDepartmentId() + "'";
		}
		//角色编号
		if (usermodel.getRole() != null
				&& !"".endsWith(usermodel.getRole())) {

			hql += " and userinfo.sysrole.roleCode='"
					+ usermodel.getRole() + "'";
		}
		//用户类型
		if (usermodel.getUserType() != null
				&& !"".endsWith(usermodel.getUserType())) {

			hql += " and userinfo.userType='"
					+ usermodel.getUserType() + "'";
		}
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	@SuppressWarnings("unchecked")
	public int countFindExpertmanage(SysuserinfoModel usermodel) {
		int count;
		String hql = "select count(*) from Sysuserinfo as userinfo where "
			+ "userinfo.userCode like :tpno and "
			+ "userinfo.userName like :tpn";
		Map mapParam = new HashMap();
		// 用户编号
		mapParam.put("tpno", "%" + usermodel.getId() + "%");
		//用户名
		mapParam.put("tpn", "%" + usermodel.getName() + "%");
		//用户类型
		if (usermodel.getUserType() != null
				&& !"".endsWith(usermodel.getUserType())) {

			hql += " and userinfo.userType='"
					+ usermodel.getUserType() + "'";
		}
		hql += " and userinfo.sysrole.roleCode='5'";
		System.out.println(hql);
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=========" + count);
		return count;

	}
	public int isExist(String tpno) {
		
		int count=0;
		String hql = "select count(*) from Sysuserinfo as userinfo where "
				+ "userinfo.userCode = '"+ tpno+"'";
		
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, null);
		return count;
	}
	// 查询结果条数
	public int count(String mno,String dno)
			throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Sysuserinfo as userinfo where userinfo.major.mno=?";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Sysuserinfo as userinfo where userinfo.department.dno=?";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Sysuserinfo";
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}

	
	public int countExpertmanage(String mno,String dno)throws ServiceException {
		int count=0;	
		String hql="";
		if(!mno.equals("000000")){
			hql="select count(*) from Sysuserinfo as userinfo where userinfo.major.mno=? and userinfo.sysrole=5";
			String param[]={mno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
		}else if(!dno.equals("00000")&&mno.equals("000000")){
			hql="select count(*) from Sysuserinfo as userinfo where userinfo.department.dno=? and userinfo.sysrole=5";
			String param[]={dno};
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, param);
			
		}else{
			hql="select count(*) from Sysuserinfo as userinfo where userinfo.sysrole.roleCode='5'";
			count =  QueryUtilDaoImpl.getResultCountForHql(hql, null);
			
		}
		return count;

	}
}
