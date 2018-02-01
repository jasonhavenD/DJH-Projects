package com.model.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.model.dao.OrderdetailDAO;
import com.model.dao.OrderinfoDAO;
import com.opensymphony.xwork2.Action;

@Entity
@Service
public class OrderService {
	@ManyToOne
	@Resource
	private OrderinfoDAO orderDAO;
	@ManyToOne
	@Resource
	private OrderdetailDAO orderdetailDAO;
	/**
	 * 添加一个新的订单
	**/
	public Integer save(Orderinfo order,List<Orderdetail> list,List cartdetaillist){
		return orderDAO.save(order,list,cartdetaillist);
	}
	/**
	 * 添加一个新的订单详情
	 * @param orderdetail
	 * @return
	 */
	public void save(Orderdetail orderdetail){
		orderdetailDAO.save(orderdetail);
	}
	/**
	 * 取消一条订单
	 * @param order
	 */
	public void cancelOrder(Orderinfo order){
		orderDAO.cancelOrder(order);
	}
	/**
	 * 根据orderid获取orderdetail
	 */
	public List getOrderdetail(Integer orderid){
		return orderdetailDAO.getOrderdetail(orderid);
	}
	/**
	 * 根据orderid获取订单
	 * @param orderid
	 * @return
	 */
	public Orderinfo getOrderinfo(Integer orderid){
		return orderDAO.findById(orderid);
	}
	/**
	 * 获取待付款订单(物流中心和平台的获取内容是不同的)
	 *平台查看所有物流中心
	 *物流中心查看该区域所有经销商
	 * @return
	 */
	public List getPendPay(Integer userType,Integer orderstate,String province){
		return orderDAO.getPendPay(userType, orderstate, province);
	}
	/**
	 * 获取订单详情(物流中心和平台的获取内容是不同的)
	 *平台查看所有物流中心
	 *物流中心查看该区域所有经销商
	 * @return
	 */
	public List getOrderdetail(Integer userType,Integer orderid,String province){
		return orderDAO.getOrderdetail(userType, orderid, province);
	}
	/**
	 * 完善物流信息
	 * unuse
	 */
	public void updateOrder(Integer orderid,String deliveryid,String deliverycompany,Timestamp startdeliverytime){
		orderDAO.updateOrder(orderid, deliveryid, deliverycompany, startdeliverytime);
	}
	//=======================================================
	/**
	*待付款订单
	 * @return
	 */
	public List getPendPayForClient(Integer userType,Integer userid){
		return orderDAO.getPendPayForClient(userType,userid);
	}
	/**
	 * 获取待发货订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public List<Map> getPendDelivery(Integer userType,Integer userid){
		return orderDAO.getPendDelivery(userType, userid);
	}
	/**
	 * 获取待收货订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public List getPendTakeDelivery(Integer userType,Integer userid){
		return orderDAO.getPendTakeDelivery(userType,userid);
	}
	/**
	 * 获取待评价订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public List getPendComment(Integer userType,Integer userid){
		return orderDAO.getPendComment(userType,userid);
	}
	/**
	 * 获取已完成成功订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public List getBookSuccess(Integer userType,Integer userid){
		return orderDAO.getBookSuccess(userType,userid);
	}
	
	
	//========================================================
	/**
	 * 对订单支付
	 * @return
	 */
	public List pay(Integer userType){
		return null;
	}
	/**
	 * 对订单付款
	 * @param orderid
	 */
	public void payfinish(Integer orderid){
		orderDAO.payfinish(orderid);
	}
	/**
	 * 确认收货
	 * @return
	 */
	public void affirmTakeDelivery(Integer orderid){
		orderDAO.affirmTakeDelivery(orderid);
	}
	/**
	 * 评价完 状态的改变
	 * @return
	 */
	public void finish(Integer orderid){
		orderDAO.finish(orderid);
	}
	/**
	 * 物流中心操作某个订单发货
	 * @return
	 */
	public void deliver(Orderinfo orderinfo){
		orderDAO.deliver(orderinfo);
	}
	/**
	 * 删除订单
	 * @return
	 */
	public void deleteOrder(Integer orderid){
		Orderinfo orderinfo = new Orderinfo();
		orderinfo.setOrderid(orderid);
		orderDAO.delete(orderinfo);
	}
	/**
	 * 获得本地区物流中心
	 */
	public List getCompanyName(int id){
		return orderDAO.getCompanyName(id);
	}
}

