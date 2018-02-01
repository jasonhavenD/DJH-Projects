package com.model.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;
import com.entity.Cartdetail;
import com.model.dao.CartdetailDAO;

@Entity
@Service
public class CartService {
	@ManyToOne
	@Resource
	private CartdetailDAO cartDAO;
	/**
	 * 向购物车中添加一个产品
	 * @param cart
	 */
	public void addOneProduct(Cartdetail cart){
		cartDAO.save(cart);
	}
	public void deleteOneProduct(int productid,int companyid){
		cartDAO.delete(productid,companyid);
	}
	public void changeProductCount(int id, int number){
		cartDAO.changeProductCount(id, number);
	}
	/**
	 * 普通经销商的购物车产品列表
	 * @return
	 */
	public List getProductbyGeneralid(int id){
		return cartDAO.getProductbyGeneralid(id);
	}
	/**
	 * 认证经销商的购物车产品列表
	 * @return
	 */
	public List getProductbyCertifiedid(int id){
		return cartDAO.getProductbyCertifiedid(id);
	}
	/**
	 * 物流中心的购物车产品列表
	 * @return
	 */
	public List getProductbylogisticsid(int id){
		return cartDAO.getProductbylogisticsid(id);
	}
	
	/**
	 * 检查购物车是否重复
	 * @param companyid
	 * @param productid
	 * @return
	 */
	public boolean isCartExist(Integer companyid,Integer productid){
		List list = cartDAO.isCartExist(companyid);
		if(list.contains(productid)){
			return true;	
		}else 
			return false;
	}
	/**
	 * 获取已存在产品数量
	 * @param companyid
	 * @param productid
	 * @return
	 */
	public Integer getCartNum(Integer companyid,Integer productid){
		List list = cartDAO.getCartNum(companyid,productid);
		System.out.println("数量"+ list+"yy"+list.get(0));
		return (Integer) list.get(0);
	}
	/**
	 * 更新已有产品的数量
	 * @param productid
	 * @param companyid
	 * @param number
	 */
	public void updateNum(int companyid,int productid,int number){
		cartDAO.updateNum( companyid, productid, number);
	}
}
