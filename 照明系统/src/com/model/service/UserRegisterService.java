package com.model.service;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;
import com.model.dao.*;
import java.util.*;
import com.entity.Userinfo;

@Entity
@Service
public class UserRegisterService {
	@ManyToOne
	@Resource
	private UserinfoDAO infoDao;
	public boolean validateUsername(String username)throws RuntimeException{
		List list = infoDao.findByUsername(username);
		if(list.size() > 0){
			return false;//该用户已存在
		}else
			return true;//可以注册
	}
	/**
	 * 校验手机用户是否存在
	 */
	public boolean validatePhone(String phone)throws RuntimeException{
			List list = infoDao.findByPhone(phone);
			if(list.size() > 0){
				return false;//该用户已存在
			}else
				return true;//可以注册
	}
	/**
	 * 校验邮箱用户是否存在
	 */
	public boolean validateEmail(String email)throws RuntimeException{
		List list = infoDao.findByEmail(email);
		if(list.size() > 0){
			return false;//该用户已存在
		}else
			return true;//可以注册
	}
	
	/**
	 * 将用户 保存
	 */
	public void saveUser(Userinfo userinfo)throws Exception{
		infoDao.save(userinfo);
	}
}
