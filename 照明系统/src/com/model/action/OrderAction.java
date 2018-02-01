package com.model.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Company;
import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.entity.Product;
import com.entity.Userinfo;
import com.model.service.OrderService;
import com.model.service.ProductService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@Entity
@Controller
@Scope("prototype")
public class OrderAction implements ModelDriven<Orderinfo>{
	@ManyToOne
	private Orderinfo orderinfo = new Orderinfo();
	@ManyToOne
	private Orderdetail orderdetail = new Orderdetail();
	@OneToMany
	private List<Orderdetail> list = new ArrayList<Orderdetail>();
	@ManyToOne
	private Product product = new Product();
	@ManyToOne
	@Resource
	private OrderService orderservice;
	@ManyToOne
	@Resource
    private ProductService productService;
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	
	public String createOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		List cartdetaillist = (List) request.getSession().getAttribute("cartidlist");
		
		request.getSession().removeAttribute("cartidlist");
		Company company = new Company();
		company.setCompanyid(user.getUserinfoid());
		orderinfo.setCompany(company);
		orderinfo.setCreatedatetime(time);
		orderinfo.setOderstate(1);
		System.out.println(list);
		orderservice.save(orderinfo,list,cartdetaillist);
		
		return Action.SUCCESS;
	}
	public String payment(){
		System.out.println(orderinfo.getOrderid());
		System.out.println(orderinfo.getLastprice());
		return Action.SUCCESS;
	}
	/**
	 * 取消一条订单
	 * @return
	 */
	public String cancelOneOrder(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			Integer orderid = Integer.valueOf(request.getParameter("orderid"));
			System.out.println(orderid);
		    Orderinfo orderinfo = orderservice.getOrderinfo(orderid);
			orderinfo.setOderstate(5);//订单状态(待付款1,待发货2,待收货3，完成4，已取消5)
			orderservice.cancelOrder(orderinfo);
			hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**.................................................................
	 * 根据物流单号获取物流信息
	 * @return
	 */
	public String getDelivery(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer deliveryid = Integer.valueOf(request.getParameter("deliveryid"));
		
		return Action.SUCCESS;
	}
	/**
	 * 根据orderid获取orderdetail
	 * @return
	 */
	public String getOrderdetailByOrderid(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer orderid = Integer.valueOf(request.getParameter("orderid"));
		List list = orderservice.getOrderdetail(orderid);
		hashmap.put("orderdetailList", list);
		System.out.println(list);
		}catch(NumberFormatException e){
			hashmap.put("orderdetailList", "numberFormatError");//数据为空，或者数据格式错误
			e.printStackTrace();
		}catch(Exception e){
			hashmap.put("orderdetailList", "systemError");//系统出现错误
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 根据orderid获取orderinfo
	 * @return
	 */
	public String getOrderinfoByOrderid(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			Integer orderid = Integer.valueOf(request.getParameter("orderid"));
			Orderinfo orderinfo = orderservice.getOrderinfo(orderid);
			hashmap.put("orderdetailList", orderinfo);
			System.out.println(orderinfo);
		}catch(NumberFormatException e){
			hashmap.put("orderdetailList", "numberFormatError");//数据为空，或者数据格式错误
			e.printStackTrace();
		}catch(Exception e){
			hashmap.put("orderdetailList", "systemError");//系统出现错误
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取待付款订单(物流中心和平台内容是不同的)
	 *平台查看所有经销商
	 *物流中心查看该区域所有经销商
	 * @return
	 */
	public String getPendPay(){
		try{

			HttpServletRequest request = ServletActionContext.getRequest();
			Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
			Integer orderstate = Integer.valueOf(request.getParameter("orderstate"));
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer userType = userinfo.getMembertype();
			String province = "";
			if(userType == 2){
				province = getCompanyProvince();
			}
			List list = orderservice.getPendPay(userType,orderstate,province);
			System.out.println(list);
			hashmap.put("orderList", list);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取详细订单(物流中心和平台内容是不同的)
	 *平台查看所有经销商
	 *物流中心查看该区域所有经销商
	 * @return
	 */
	public String getOrderdetail(){
		try{
			
			HttpServletRequest request = ServletActionContext.getRequest();
			Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
			Integer orderid = Integer.valueOf(request.getParameter("orderid"));
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer userType = userinfo.getMembertype();
			String province = "";
			if(userType == 2){
				province = getCompanyProvince();
			}
			List list = orderservice.getOrderdetail(userType,orderid,province);
			System.out.println(list);
			hashmap.put("orderList", list);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 *获取待付款订单(物流中心，经销商获取内容是不同的)
	 *平台查看所有物流中心
	 *物流中心查看该区域所有经销商
	 * @return
	 */
	public String getPendPayForClient(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			String delivername = getCompanyName();
			//System.out.print("物流中心名字："+delivername);
			Integer userType = userinfo.getMembertype();
			List list = orderservice.getPendPayForClient(userType,userinfo.getUserinfoid());
			//System.out.println(list);
			hashmap.put("orderList", list);
			hashmap.put("delivername", delivername);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 获取待发货订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public String getPendDeliveryForClient(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			String delivername = getCompanyName();
			Integer userType = userinfo.getMembertype();
			List<Map> list = orderservice.getPendDelivery(userType,userinfo.getUserinfoid());
			System.out.println(list);
			hashmap.put("orderList", list);
			hashmap.put("delivername", delivername);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取待收货订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public String getPendTakeDeliveryForClient(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer userType = userinfo.getMembertype();
			List list = orderservice.getPendTakeDelivery(userType,userinfo.getUserinfoid());
			System.out.println(list);
			hashmap.put("orderList", list);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取待评价订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public String getPendCommentForClient(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer userType = userinfo.getMembertype();
			List list = orderservice.getPendComment(userType,userinfo.getUserinfoid());
			System.out.println(list);
			hashmap.put("orderList", list);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取已完成成功订单(物流中心和经销商的获取内容是不同的)
	 * @return
	 */
	public String getBookSuccessForClient(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("orderList", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer userType = userinfo.getMembertype();
			List list = orderservice.getBookSuccess(userType,userinfo.getUserinfoid());
			System.out.println(list);
			hashmap.put("orderList", list);
		}catch(Exception e){
			hashmap.put("orderList", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 对订单支付....................................................
	 * @return
	 */
	public String pay(){
		try {
			HttpServletRequest request =  ServletActionContext.getRequest();
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("state", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Integer orderid = Integer.valueOf(request.getParameter("orderid"));
			System.out.println(orderid);
			orderservice.payfinish(orderid);
			hashmap.put("state", "success");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "numError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 确认收货
	 * @return
	 */
	public String affirmTakeDelivery(){
		try{
		HttpServletRequest request =  ServletActionContext.getRequest();
		Userinfo userinfo = (Userinfo)request.getSession().getAttribute("userinfo");
		if(userinfo == null){
			hashmap.put("state", "noLogin");//该用户未登录
			return Action.SUCCESS;
		}
		Integer orderid = Integer.valueOf(request.getParameter("orderid"));
		orderservice.affirmTakeDelivery(orderid);
		hashmap.put("state", "success");
		}catch(NumberFormatException e){
			hashmap.put("state", "numError");
			e.printStackTrace();
		}catch(Exception e){
			hashmap.put("state", "systemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 物流中心操作某个订单发货
	 * @return
	 */
	public String deliver(){
		try{
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(userinfo == null){
			hashmap.put("state", "noLogin");//该用户未登录
			return Action.SUCCESS;
		}
		if(orderinfo.getOrderid() == null || orderinfo.getDeliveryid() == null || orderinfo.getDeliverycompany() == null){
			hashmap.put("state", "null");
			return Action.SUCCESS;
		}
		orderservice.deliver(orderinfo);
		hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 删除订单
	 * @return
	 */
	public String deleteOrder(){
		try{
		HttpServletRequest request =  ServletActionContext.getRequest();
		Integer orderid = Integer.valueOf(request.getParameter("orderid"));
		orderservice.deleteOrder(orderid);
		hashmap.put("state", "success");
		}catch(NumberFormatException e){
			hashmap.put("state", "numberFormatError");//数据为空，或者数据格式错误
			e.printStackTrace();
		}catch(Exception e){
			hashmap.put("state", "systemError");//系统出现错误
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获得本地区物流中心
	 * @return
	 */
	private String getCompanyName(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	/*	Userinfo userinfo = new Userinfo(); 
		userinfo.setUserinfoid(1);*/
		System.out.println(userinfo);
		List list = orderservice.getCompanyName(userinfo.getUserinfoid());
		Map list1 = null;
		if(list == null)
			return null;
		if(list.size() > 0)
			list1 =  (Map) list.get(0);
		else
			return null;
		return list1.get("companyname").toString();
	}
	/**
	 * 获得本地区物流中心所在省份
	 * @return
	 */
	private String getCompanyProvince(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		List list = orderservice.getCompanyName(userinfo.getUserinfoid());
		if(list == null)
			return null;
		Map list1 =  (Map) list.get(0);
		return list1.get("province").toString();
	}
	/*public Orderdetail () { 
		return orderdetail;
	}*/
	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public Orderinfo getModel() {
		return orderinfo;
	}

	public List<Orderdetail> getList() {
		return list;
	}

	public void setList(List<Orderdetail> list) {
		this.list = list;
	}
}
