package com.model.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.entity.Company;
import com.entity.Userinfo;
import com.model.dao.UserinfoDAO;

@Entity
@Service
public class UserLoginService {
	@ManyToOne
	@Resource
	private UserinfoDAO infoDao;
	/**用户登录验证
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String loginValidateByUsername(int type ,String username,String password){
		try{
		Userinfo userinfo = null;
		System.out.println("username: " + username);
		List list = infoDao.findByUsername(username);
		if(list.size() > 0){
			userinfo = (Userinfo) list.get(0);
			System.out.println(userinfo.getMembertype());
			System.out.println(userinfo.getUsername());
    		System.out.println(userinfo.getPassword());
			if(userinfo.getPassword().equals(password)){
				if(type == 1){
					if(userinfo.getMembertype() == 1)
					{
						//登陆成功将用户信息放在session中
						ServletActionContext.getRequest().getSession().setAttribute("userinfo", userinfo);
						userinfo.setLastdatetime(new Timestamp(System.currentTimeMillis()));//设置最后登陆时间
						infoDao.updateUserinfo(userinfo);
						return "success";//验证成功
					}else
						return "noright";
				}else if(type == 2){
					if(userinfo.getMembertype() == 2)
					{
						//登陆成功将用户信息放在session中
						ServletActionContext.getRequest().getSession().setAttribute("userinfo", userinfo);
						userinfo.setLastdatetime(new Timestamp(System.currentTimeMillis()));//设置最后登陆时间
						infoDao.updateUserinfo(userinfo);
						return "success";//验证成功
					}else
						return "noright";
				} else if(type == 3){
					if(userinfo.getMembertype() == 3 || userinfo.getMembertype() == 4)
					{
						//登陆成功将用户信息放在session中
						ServletActionContext.getRequest().getSession().setAttribute("userinfo", userinfo);
						userinfo.setLastdatetime(new Timestamp(System.currentTimeMillis()));//设置最后登陆时间
						infoDao.updateUserinfo(userinfo);
						return "success";//验证成功
					}else
						return "noright";
				}
				
			}else{
				return "passwordError";//密码错误
			}
		}else{
			return "unregistered";//未注册的
		}
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return "fail";
	}
	public String loginValidateByPhone(String phone,String password){
		try{
		Userinfo userinfo = null;
		List list = infoDao.findByPhone(phone);
		if(list.size() > 0){
			userinfo = (Userinfo) list.get(0);
			if(userinfo.getPassword().equals(password)){
				if(userinfo.getMembertype() == 3 || userinfo.getMembertype() == 4)
				{
				//登陆成功将用户信息放在session中
					ServletActionContext.getRequest().getSession().setAttribute("userinfo", userinfo);
					userinfo.setLastdatetime(new Timestamp(System.currentTimeMillis()));//设置最后登陆时间
					infoDao.updateUserinfo(userinfo);
					return "success";//验证成功
				}else
					return "noright";
			}else{
				return "passwordError";//密码错误
			}
		}else{
			return "unregistered";//未注册的
		}
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	public String loginValidateByEmail(String email,String password){
		try{
			Userinfo userinfo = null;
			List list = infoDao.findByEmail(email);
			if(list.size() > 0){
				userinfo = (Userinfo) list.get(0);
				if(userinfo.getPassword().equals(password)){
					if(userinfo.getMembertype() == 3 || userinfo.getMembertype() == 4)
					{
					//登陆成功将用户信息放在session中
						ServletActionContext.getRequest().getSession().setAttribute("userinfo", userinfo);
						userinfo.setLastdatetime(new Timestamp(System.currentTimeMillis()));//设置最后登陆时间
						infoDao.updateUserinfo(userinfo);
						return "success";//验证成功
					}else
						return "noright";
				}else{
					return "passwordError";//密码错误
				}
			}else{
				return "unregistered";//未注册的
			}
	}catch(Exception e){
		e.printStackTrace();
		return "fail";
	}
	}

	public Userinfo findById(Integer id){
		return infoDao.findById(id);
	}
	public void changePassword(Userinfo userinfo){
		infoDao.updatePassword(userinfo.getPassword(),userinfo.getUserinfoid());
	}
	public void changeState(Integer id, Integer state){
    	infoDao.updateState(id, state);
    }
	/**test**/
	public List<Userinfo> findbyEmail(String email){
		List<Userinfo>infoList = infoDao.findByEmail(email);
		for(int i = 0 ; i < infoList.size(); i++){
			System.out.println(infoList.get(i)+"："+infoList.size());
		}
		return null;
	}
	//平台获取普通经销商
	public List findNormal(){
		return infoDao.FindAllNormalUser();
	}
	//平台获取认证经销商
	public List findCertified(){
		return infoDao.FindAllCompanyUser();
	}
	
}
