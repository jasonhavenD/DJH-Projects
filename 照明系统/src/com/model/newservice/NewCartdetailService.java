package com.model.newservice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Cartdetail;
import com.entity.Product;
import com.model.newdao.NewCartdetailDAO;
import com.newentity.NewCartdetail;

@Service
public class NewCartdetailService {
	 @Resource
     private NewCartdetailDAO  newCartdetailDAO;
	 
	// private boolean flag;
	 //3.html
	 /**
	 * 加入购物车
	 * @param cart
	 */
	 public void addOneProduct(NewCartdetail cart){
		newCartdetailDAO.save(cart);
	 }
	 
	 //4.html
	 
	 //获取当前用户购物车
	 public List<Map> getCartByUserId(Integer userid){
		 //////20161114
		 
		 //////20161114
		 return null;
	 }
	 
	 
	 /**
	  * 检查购物车是否重复
	  * @param userinfoid
	  * @param productid
	  * @return
	  */
	public boolean isCartExist(Integer userinfoid, Integer productid) {
		return newCartdetailDAO.isCartExist(userinfoid, productid);
	}
	/**
	 * 获取购物车中已经存在的物品的数量
	 * @param userinfoid
	 * @param productid
	 * @return
	 */
	public Integer getCartNum(Integer userinfoid, Integer productid) {
		// TODO Auto-generated method stub
		List list = newCartdetailDAO.getCartNum(userinfoid,productid);
		System.out.println("数量"+list+"yy"+list.get(0));
		return (Integer) list.get(0);
	}
	
	/**
	 * 更新购物车中已有产品的数量
	 * @param userinfoid
	 * @param productid
	 * @param i
	 */
	public void updateNum(Integer userinfoid, Integer productid, int i) {
		// TODO Auto-generated method stub
		newCartdetailDAO.updateNum(userinfoid,productid,i);
	}
	/**
	 * 更新购物车中某条购物车记录商品数量
	 * @param cartid
	 * @param num
	 */
	public void changeProductCount(Integer cartid, Integer num) {
		// TODO Auto-generated method stub
		newCartdetailDAO.changeProductCount(cartid,num);
	}
	
	/**
	 * 查找某条购物车记录中的商品属性
	 * @param cartid
	 * @return
	 */
	public List getProductbyId(Integer cartid) {
		// TODO Auto-generated method stub
		return newCartdetailDAO.findProductById(cartid);
		//return null;
	}
	 
	public List<NewCartdetail> getCartByUserId2(Integer userid) {
		return newCartdetailDAO.getCartByUserId2(userid);
	}
	
	/**
	 * 删除某条购物车记录
	 * @param cartid
	 * @return
	 */
	public String deleteCartById(Integer cartid) {
		// TODO Auto-generated method stub
		return (String) newCartdetailDAO.deleteCartById(cartid);
		//newCartdetailDAO.delete(persistentInstance);
	}
	/**
	 * 清空购物车
	 * @param userid
	 * @return 
	 */
	public String deleteAll(int userid) {
		// TODO Auto-generated method stub
		return newCartdetailDAO.delAllCart(userid);
	}
	
}
