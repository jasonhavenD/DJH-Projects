package com.model.service;


import com.entity.Favorite;
import com.model.dao.FavoriteDAO;
import java.util.*;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;
@Entity
@Service
public class FavoritesService {
	@ManyToOne
	@Resource
	private FavoriteDAO favoriteDAO;
	/**
	 * 获得收藏信息
	 */
	/*public List getCollect(Favorite favorite){
		return favoriteDAO.getCollect(favorite.getCompany().getCompanyid());
		
		
	}*/
	public List getCollect(Integer companyid){
		return favoriteDAO.getCollect(companyid);
	}
	/**
	 * 获得收藏详细信息
	 * @param id
	 */
	public Favorite findById(Integer favoriteid){
		Favorite fav=favoriteDAO.findById(favoriteid);
		System.out.println(fav);
		return fav;
	}
	/**
	 * 删除收藏详细信息
	 * @param id
	 */
	public void delete(Favorite favorite){
		favoriteDAO.delete(favorite);
		return;
	}
	/**
	 * 新增收藏信息
	 * @param 
	 */
	public void add(Favorite favorite){
		favoriteDAO.save(favorite);
		return;
	}
	/**
	 * 检查收藏夹是否重复收藏
	 * @param companyid
	 * @param productid
	 * @return
	 */
	public boolean isFavoExist(Integer companyid,Integer productid){
		List list = favoriteDAO.isFavoExist(companyid);
		if(list.contains(productid)){
			return true;	
		}else 
			return false;
	}

}
