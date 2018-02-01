package com.model.newaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Cartdetail;
import com.entity.Company;
import com.entity.Product;
import com.entity.Userinfo;
import com.model.newservice.NewCartdetailService;
import com.model.newservice.NewProductService;
import com.model.service.CartService;
import com.newentity.NewCartdetail;
import com.newentity.NewCompany;
import com.newentity.NewProduct;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewCartAction extends ActionSupport implements
		ModelDriven<NewCartdetail> {

	@Resource
	private CartService cartService;
	@Resource
	private NewCartdetailService newCartdetailService;
	public NewCartdetailService getNewCartdetailService() {
		return newCartdetailService;
	}

	public void setNewCartdetailService(NewCartdetailService newCartdetailService) {
		this.newCartdetailService = newCartdetailService;
	}

	@Resource
	private NewProductService newProductService;

	private NewCartdetail cart = new NewCartdetail();

	private HashMap<String, Object> hashmap = new HashMap<String, Object>();
	private List<List> listmap = new ArrayList<List>();
	private List cartidlist = new ArrayList();

	// ////20161114 for addOneProduct2
	private Integer productId; // To be added to the cart

	// ////20161114 for addOneProduct2

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	/**
	 * 添加产品
	 * 
	 * @return
	 */
	// not from Ajax request but normal Action request
	// public String addOneProductSync() {
	// try {
	// System.out.println("productId: " + productId);
	// if (productId == null)
	// return Action.INPUT;
	// Userinfo user = (Userinfo) ServletActionContext.getRequest()
	// .getSession().getAttribute("userinfo");
	// if (user == null)
	// return Action.INPUT;
	// NewCompany newCompany = new NewCompany();
	// newCompany.setCompanyid(user.getUserinfoid());
	// NewProduct newProduct = newProductService.findById(productId);
	// boolean flag = cartService.isCartExist(user.getUserinfoid(), productId);
	// // 标识该商品是否已经添加到了购物车
	// if (flag) {// 已添加
	// NewCartdetail newCartdetail = new NewCartdetail();
	// newCartdetail.setCompany(newCompany);
	// newCartdetail.setProduct(newProduct);
	// Integer prenum = cartService.getCartNum(user.getUserinfoid(),
	// cart.getProduct().getProductid());
	// cartService.updateNum(user.getUserinfoid(), cart.getProduct()
	// .getProductid(), prenum + 1);
	// } else {
	// cart.setCompany(company);
	// cart.setProduct(product);
	// cart.setNumber(cart.getNumber());
	// cart.setSaletype(cart.getSaletype());
	// cartService.addOneProduct(cart);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return Action.SUCCESS;
	// }

	/**
	 * 添加产品
	 * 
	 * @return
	 */
	public String addOneProduct() {
		try {
			System.out.println("pid" + cart.getProduct().getProductid());
			System.out.println("num" + cart.getNumber());
			if (cart.getProduct().getProductid() == null
					|| cart.getNumber() == null) {
				hashmap.put("state", "paramError");
				return Action.SUCCESS;
			}
			int num = cart.getNumber();

			Userinfo user = (Userinfo) ServletActionContext.getRequest()
					.getSession().getAttribute("userinfo");
			if (user == null) {
				hashmap.put("state", "nologin");// 该用户未登录
				return Action.SUCCESS;
			}

			// cart = (NewCartdetail)
			// newcartdetailService.getCartByUserId(user.getUserinfoid());
			// int num = cart.getNumber();

			NewCompany company = new NewCompany();
			company.setCompanyid(user.getUserinfoid());
			NewProduct product = newProductService.findById(cart.getProduct()
					.getProductid());
			boolean flag = newCartdetailService.isCartExist(
					user.getUserinfoid(), cart.getProduct().getProductid());// 查看是否已经添加
			if (flag) {// 如果已添加
				cart.setCompany(company);
				cart.setProduct(product);
				Integer prenum = newCartdetailService.getCartNum(
						user.getUserinfoid(), cart.getProduct().getProductid());
				newCartdetailService.updateNum(user.getUserinfoid(), cart
						.getProduct().getProductid(), prenum + num);
			} else {
				cart.setCompany(company);
				cart.setProduct(product);
				cart.setNumber(cart.getNumber());
				cart.setSaletype(cart.getSaletype());
				newCartdetailService.addOneProduct(cart);
			}
			hashmap.put("state", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	/* 改变购物车中的某种商品数量 */
	public String changeProductCount() {
		try {
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
		return Action.SUCCESS;
	}

	/**
	 * 删除某条购物车记录
	 * 
	 * @return
	 */
	public String deleteCart() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Integer cartid = Integer.valueOf(request.getParameter("cartid"));
		String str = newCartdetailService.deleteCartById(cartid);
		if (str.equals("success")) {
			hashmap.put("state", "success");
		} else {
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	/**
	 * 清空购物车
	 * 
	 * @return
	 */

	public String deleteAll() {
		Userinfo user = (Userinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("userinfo");
		int userid = user.getUserinfoid();
		String str = newCartdetailService.deleteAll(userid);
		if (str.equals("success")) {
			hashmap.put("state", "success");
		} else {
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}

	public NewCartdetail getModel() {
		// TODO Auto-generated method stub
		return cart;
	}
}
