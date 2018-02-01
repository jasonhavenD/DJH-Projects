package com.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import com.entity.*;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.newservice.NewCartdetailService;
import com.model.newservice.NewProductService;
import com.newentity.NewCartdetail;
import com.newentity.NewCompany;
import com.newentity.NewProduct;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Entity
@Controller
@Scope("prototype")
public class NewCartAction extends ActionSupport implements ModelDriven<NewCartdetail>{
	
	@Resource
	private NewCartdetailService newcartdetailService;
	
	private NewCartdetail cart = new NewCartdetail();
	
	@Resource
	private NewProductService newproductService;
	
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	private List<List> listmap = new ArrayList<List>();
	private List cartidlist = new ArrayList();
	
	/**
	 * 添加产品
	 * @return
	 */
	public String addOneProduct(){
		try {
			System.out.println("pid"+cart.getProduct().getProductid());
			System.out.println("num"+cart.getNumber());
			if(cart.getProduct().getProductid() == null||cart.getNumber() == null){
				hashmap.put("state", "paramError");
				return Action.SUCCESS;
			}
			int num = cart.getNumber();
			
			
			Userinfo user = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(user == null){
				hashmap.put("state", "nologin");//该用户未登录 
				return Action.SUCCESS;
			}
			
	//		cart = (NewCartdetail) newcartdetailService.getCartByUserId(user.getUserinfoid());
	//		int num = cart.getNumber();
			
			NewCompany company = new NewCompany();
			company.setCompanyid(user.getUserinfoid());
			NewProduct product = newproductService.findById(cart.getProduct().getProductid());
			boolean flag = newcartdetailService.isCartExist(user.getUserinfoid(),cart.getProduct().getProductid());//查看是否已经添加
			if(flag){//如果已添加
				cart.setCompany(company);
				cart.setProduct(product);
				Integer prenum = newcartdetailService.getCartNum(user.getUserinfoid(),cart.getProduct().getProductid());
				newcartdetailService.updateNum(user.getUserinfoid(),cart.getProduct().getProductid(),prenum+num);
			}else{
				cart.setCompany(company);
				cart.setProduct(product);
				cart.setNumber(cart.getNumber());
				cart.setSaletype(cart.getSaletype());
				newcartdetailService.addOneProduct(cart);
			}
			hashmap.put("state","success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hashmap.put("state","fail");
		}
		return Action.SUCCESS;
	}
	
	
	/*改变购物车中的某种商品数量*/
	public String changeProductCount(){
		try
		{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Integer cartid = Integer.valueOf(request.getParameter("cartid"));
		Integer num = Integer.valueOf(request.getParameter("cartnum"));
		Integer productprice = Integer.valueOf(request.getParameter("productprice"));
	//	System.out.println(request.getParameter("productprice"));
		List list = newcartdetailService.getProductbyId(cartid); //提取原来该条购物车记录中原有的产品数量
		Integer oldnum = Integer.valueOf((list.get(0).toString()));
		Integer Dnum = num - oldnum;
	
		System.out.println("商品数量差:"+Dnum);
		
		
		newcartdetailService.changeProductCount(cartid, num);
	//	hashmap.put("state", "success");
		hashmap.put("Dnum",Dnum);
		}catch(NumberFormatException e){
			hashmap.put("state", "paramError");//参数为空
			e.printStackTrace();
		}catch(Exception e){
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}


	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}


	public NewCartdetail getModel() {
		// TODO Auto-generated method stub
		return cart;
	}


	public NewCartdetail getCart() {
		return cart;
	}


	public void setCart(NewCartdetail cart) {
		this.cart = cart;
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
	
}
