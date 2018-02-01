package com.model.newservice;

import java.util.List;

import javax.annotation.Resource;

import com.entity.Userinfo;
import com.model.dao.UserinfoDAO;

public class ThirdLoginService {
	@Resource
	private UserinfoDAO infoDao;
	public boolean validateQQ(String qq)throws RuntimeException{
		List list = infoDao.findByQq(qq);
		if(list.size() > 0){
			return false;//该用户已存在
		}else
			return true;//可以注册
	}
	
	//获得qq登录用户的信息
	public Userinfo getQQuserinfo(String qq)throws RuntimeException{
		List list = infoDao.findByQq(qq);
		Userinfo userinfo = (Userinfo)list.get(0);
		return userinfo;
	}
	
	public void saveUser(Userinfo userinfo)throws Exception{
		infoDao.save(userinfo);
	}
}
