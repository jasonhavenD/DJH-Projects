package com.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.*;
import com.model.newservice.NewCartdetailService;
import com.model.service.CartService;
import com.model.service.ProductService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.*;

@Entity
@Controller
@Scope("prototype")
public class CartAction extends ActionSupport implements ModelDriven<Cartdetail>{
	@ManyToOne
	@Resource
	private CartService cartService;
	@Resource
	private NewCartdetailService newCartdetailService;
	
	@ManyToOne
	private Cartdetail cart = new Cartdetail();
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
    @ManyToOne
	@Resource
    private ProductService productService;
    private List<List> listmap = new ArrayList<List>();
    private List cartidlist = new ArrayList();
    /* @Resource
    private CompanyService companyService;*/
    
    @SuppressWarnings("unchecked")
	public String purchaseProduct(){
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("purchaseProduct: start");
		String cart1 = request.getParameter("cart1");
		JSONArray array = JSONArray.fromObject(cart1); 
		for(int i = 0 ; i < array.size(); i++){
			JSONObject object = (JSONObject) array.get(i);
			List tmp = new ArrayList();
			tmp.add(object.get("productpicture"));
			tmp.add(object.get("productname"));
			tmp.add(object.get("property"));
			tmp.add(object.get("realprice"));
			tmp.add(object.get("num"));
			tmp.add(object.get("total"));
			tmp.add(object.get("productid"));
			cartidlist.add(object.get("cartdetailid"));
			listmap.add(tmp);
		}
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.setAttribute("cartidlist", cartidlist);
		System.out.println("purchaseProduct:"+listmap);
		return Action.SUCCESS;
	}
    /**
	 * 添加产品
	 * @return
	 */
	public String addOneProduct(){
		try{
			System.out.println("pid"+cart.getProduct().getProductid());
			System.out.println("num"+cart.getNumber());
			if(cart.getProduct().getProductid() == null || cart.getNumber() == null /*|| cart.getSaletype() == null*/){
				hashmap.put("state", "paramError");//参数为空
				return Action.SUCCESS;
			}
			int num = cart.getNumber();
			Userinfo user = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(user == null){
				hashmap.put("state", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			Company company = new Company();
			company.setCompanyid(user.getUserinfoid());
			Product product = productService.findById(cart.getProduct().getProductid());
			boolean flag = cartService.isCartExist(user.getUserinfoid(), cart.getProduct().getProductid());//标识是否添加
			if(flag){//已添加
				cart.setCompany(company);
				cart.setProduct(product);
				Integer prenum = cartService.getCartNum(user.getUserinfoid(),cart.getProduct().getProductid());
				cartService.updateNum(user.getUserinfoid(),cart.getProduct().getProductid(),prenum+num);
			}else{
				cart.setCompany(company);	
				cart.setProduct(product);
				cart.setNumber(cart.getNumber());
				cart.setSaletype(cart.getSaletype());
				cartService.addOneProduct(cart);
				//hashmap.put("state", "success");
			}
			hashmap.put("state", "success");
		}catch(Exception e){
			e.printStackTrace();
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	
	
	/* 改变购物车中的某种商品数量 */
	public String changeProductCount() {
		try {
			System.out.println("in changeProductCount()");
			HttpServletRequest request = ServletActionContext.getRequest();

			Integer cartid = Integer.valueOf(request.getParameter("cartid"));
			Integer num = Integer.valueOf(request.getParameter("cartnum"));
			Integer productprice = Integer.valueOf(request
					.getParameter("productprice"));
			// System.out.println(request.getParameter("productprice"));
			List list = newCartdetailService.getProductbyId(cartid); // 提取原来该条购物车记录中原有的产品数量
			Integer oldnum = Integer.valueOf((list.get(0).toString()));
			Integer Dnum = num - oldnum;

			System.out.println("商品数量差:" + Dnum);

			newCartdetailService.changeProductCount(cartid, num);
			// hashmap.put("state", "success");
			hashmap.put("Dnum", Dnum);
		} catch (NumberFormatException e) {
			hashmap.put("state", "paramError");// 参数为空
			e.printStackTrace();
		} catch (Exception e) {
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		System.out.println("hashmap: " + hashmap);
		return Action.SUCCESS;
	}

	/**
	 * 删除某条购物车记录
	 * 
	 * @return
	 */
	public String deleteCart() {
		System.out.println("in deleteCart()");
		HttpServletRequest request = ServletActionContext.getRequest();

		Integer cartid = Integer.valueOf(request.getParameter("cartid"));
		String str = newCartdetailService.deleteCartById(cartid);
		if (str.equals("success")) {
			hashmap.put("state", "success");
		} else {
			hashmap.put("state", "fail");
		}
		System.out.println("hashmap: " + hashmap);
		return Action.SUCCESS;
	}

	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	public String deleteAllCarts() {
		System.out.println("in deleteAll()");
		Userinfo user = (Userinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("userinfo");
		int userid = user.getUserinfoid();
		String str = newCartdetailService.deleteAll(userid);
		if (str.equals("success")) {
			hashmap.put("state", "success");
		} else {
			hashmap.put("state", "fail");
		}
		System.out.println("hashmap: " + hashmap);
		return Action.SUCCESS;
	}
	
	
	/**
	 * 删除当前用户的购物车中的某个产品
	 * @return
	 */
	public String deleteOneProduct(){
		try
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			String productid = request.getParameter("productid");
			Userinfo user = (Userinfo)request.getSession().getAttribute("userinfo");
			if(productid == null || productid.equals("")){
				hashmap.put("state", "paramError");//参数为空
				return Action.SUCCESS;
			}
			int productid1 = Integer.valueOf(productid);
			cartService.deleteOneProduct(productid1, user.getUserinfoid());
		hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 改变产品数量
	 * @return
	 */
//	public String changeProductCount(){
//		try
//		{
//		HttpServletRequest request = ServletActionContext.getRequest();
//		
//		Integer cartid = Integer.valueOf(request.getParameter("cartid"));
//		Integer num = Integer.valueOf(request.getParameter("number"));
//		cartService.changeProductCount(cartid, num);
//		hashmap.put("state", "success");
//		}catch(NumberFormatException e){
//			hashmap.put("state", "paramError");//参数为空
//			e.printStackTrace();
//		}catch(Exception e){
//			hashmap.put("state", "fail");
//			e.printStackTrace();
//		}
//		return Action.SUCCESS;
//	}
	
	/**
	 * 从获得购物车中用户的产品列表
	 * @return
	 */
	public String getProductList0(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		Userinfo user = (Userinfo)request.getSession().getAttribute("userinfo");
		if(user == null){
			hashmap.put("list", "NoLogin");//该用户未登录
			return Action.SUCCESS;
		}
		/*user.setMembertype(2);
		user.setUserinfoid(74);*/
		List list = null;
		if(user.getMembertype() == 2){
			list = cartService.getProductbylogisticsid(user.getUserinfoid());
		}else if(user.getMembertype() == 3){
			list = cartService.getProductbyCertifiedid(user.getUserinfoid());
		}else if(user.getMembertype() == 4){
			list = cartService.getProductbyGeneralid(user.getUserinfoid());
		}else{
			list = null;
		}
		 
		//System.out.println(list);
		hashmap.put("list", list);
		}catch(Exception e){
			hashmap.put("list", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public String getProductList() {
		//System.out.println("getProductList");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Userinfo user = (Userinfo) request.getSession().getAttribute(
					"userinfo");
			if (user == null) {
				hashmap.put("list", "NoLogin");// 该用户未登录
				return Action.SUCCESS;
			}
			/*
			 * user.setMembertype(2); user.setUserinfoid(74);
			 */
			List list = null;
			if (user.getMembertype() == 2) {
				list = cartService
						.getProductbylogisticsid(user.getUserinfoid());
			} else if (user.getMembertype() == 3) {
				//System.out.println("getMembertype: " + 3 + " user.getUserinfoid(): " + user.getUserinfoid());
				list = cartService
						.getProductbyCertifiedid(user.getUserinfoid());
			} else if (user.getMembertype() == 4) {
				list = cartService.getProductbyGeneralid(user.getUserinfoid());
			} else {
				list = null;
			}

			hashmap.put("list", list);
		} catch (Exception e) {
			hashmap.put("list", "fail");
			e.printStackTrace();
		}

		//System.out.println("hashmap: " + hashmap.size());

		return Action.SUCCESS;
	}
	
	/**
	 * 查找数组id的 产品
	 */
	public String getProList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//String s []= getParams();
		int id[] = {26,12};
		HashMap<Integer,Object> lmap = new HashMap<Integer,Object>();
		for(int i=0; i<id.length; i++){
			List<Map> list = productService.getProductdetailById(id[i]);
			lmap.put(i, list);
		}
		hashmap.put("list", lmap);
		return Action.SUCCESS;
	}
	public Cartdetail getModel() {
		return cart;
	}
	public Cartdetail getCart() {
		return cart;
	}

	public void setCart(Cartdetail cart) {
		this.cart = cart;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
	public List<List> getListmap() {
		return listmap;
	}
	public void setListmap(List<List> listmap) {
		this.listmap = listmap;
	}
	public List getCartidlist() {
		return cartidlist;
	}
	public void setCartidlist(List cartidlist) {
		this.cartidlist = cartidlist;
	}
	
	public NewCartdetailService getNewCartdetailService() {
		return newCartdetailService;
	}

	public void setNewCartdetailService(NewCartdetailService newCartdetailService) {
		this.newCartdetailService = newCartdetailService;
	}
}
