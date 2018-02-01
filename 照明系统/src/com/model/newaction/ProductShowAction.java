package com.model.newaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.newservice.NewProductService;
import com.model.newvoui.ThirdProductPicture;
import com.model.service.ProductService;
import com.newentity.NewProduct;
import com.newentity.NewProductproperty;
import com.newentity.NewProducttype;
import com.newentity.Product2;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Entity
@Controller
@Scope("prototype")
public class ProductShowAction extends ActionSupport {

	@Resource
	private NewProductService newProductService;

	private List<ThirdProductPicture> thirdProductPictures = new ArrayList<ThirdProductPicture>();// 热销推荐
	private List<ThirdProductPicture> thirdProductPictures2 = new ArrayList<ThirdProductPicture>();// 新品上市
	private List<NewProduct> sameProductlist = new ArrayList<NewProduct>();
	private Product2 listproduct2 = new Product2();

	public List<NewProduct> getSameProductlist() {
		return sameProductlist;
	}

	public void setSameProductlist(List<NewProduct> sameProductlist) {
		this.sameProductlist = sameProductlist;
	}

	private List<Map> listHotProduct;
	private List<Map> listNewProduct;

	public NewProductService getNewProductService() {
		return newProductService;
	}

	public void setNewProductService(NewProductService newProductService) {
		this.newProductService = newProductService;
	}

	public Product2 getListproduct2() {
		return listproduct2;
	}

	public void setListproduct2(Product2 listproduct2) {
		this.listproduct2 = listproduct2;
	}

	public List<ThirdProductPicture> getThirdProductPictures() {
		return thirdProductPictures;
	}

	public void setThirdProductPictures(
			List<ThirdProductPicture> thirdProductPictures) {
		this.thirdProductPictures = thirdProductPictures;
	}

	public List<ThirdProductPicture> getThirdProductPictures2() {
		return thirdProductPictures2;
	}

	public void setThirdProductPictures2(
			List<ThirdProductPicture> thirdProductPictures2) {
		this.thirdProductPictures2 = thirdProductPictures2;
	}

	public List<Map> getListHotProduct() {
		return listHotProduct;
	}

	public void setListHotProduct(List<Map> listHotProduct) {
		this.listHotProduct = listHotProduct;
	}

	public List<Map> getListNewProduct() {
		return listNewProduct;
	}

	public void setListNewProduct(List<Map> listNewProduct) {
		this.listNewProduct = listNewProduct;
	}

	public void retreiveNewProduct2() {
		// 新品上市
		listNewProduct = newProductService.getNewProduct();// 暂无新货
		// listNewProduct = newProductService.getHotProduct();
		if (listNewProduct == null) {
			System.out.println("listNewProduct==null");
			return;
		}
		Iterator iterator = listNewProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			thirdProductPictures2.add(new ThirdProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					pictures[1], "发光颜色: 暂无", (Double) map.get("price")));
		}

	}

	public void retreiveHotProductPicture2() {
		// 热销推荐
		listHotProduct = newProductService.getHotProduct();
		Iterator iterator = listHotProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			thirdProductPictures.add(new ThirdProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					pictures[0], "发光颜色: 暂无", (Double) map.get("price")));
		}
	}

	private HttpServletRequest request = ServletActionContext.getRequest();

	ProductShowAction() {
	}

	public void getSameProduct() {
		Integer productid = Integer.valueOf(request.getParameter("productid"));
		List<Map> list = newProductService.getProductdetailById(productid);
		Map map = (Map) list.get(0);
		String producttypename = (String) map.get("producttypename");
		// String producttype = map.get("producttypename").toString();

		List<Map> list1 = newProductService
				.getProductdetailByType(producttypename);
		System.out.println(list1);
		System.out.println(list1.size());
		for (int i = 0; i < list1.size(); i++) {
			Map map1 = (Map) list1.get(i);
			String paths = (String) map1.get("productpicture");
			String[] pictures = paths.split("\\|");
			sameProductlist.add(new NewProduct((Integer) map1.get("productid"),
					map1.get("productname").toString(), pictures[0], map1.get(
							"productdiscribe").toString(), (Double) map1
							.get("price")));
		}
	}

	public String getOneProductdetail() {

		// System.out.println(productid);

		retreiveHotProductPicture2();
		retreiveNewProduct2();
		getSameProduct();

		Integer productid = Integer.valueOf(request.getParameter("productid"));
		List<Map> list = newProductService.getProductdetailById(productid);

		Map map = (Map) list.get(0);
		// 获取图片
		String pictures = (String) map.get("productpicture");
		String[] picture = pictures.split("\\|");
		for (int i = 0; i < 5; i++) {
			picture[i] = picture[i].substring(0, 0) + picture[i].substring(1);
		}

		request.setAttribute("picture", picture);

		NewProduct product1 = new NewProduct(productid,
				(String) map.get("productname"), (Double) map.get("price"));
		NewProductproperty proprety = new NewProductproperty(
				(String) map.get("power"), (String) map.get("luminousflux"),
				(String) map.get("colortemp"));

		// 获取销售类型
		int issnapup = (Integer) map.get("issnapup");// 是否限时抢购
		System.out.println(issnapup);

		int isgroupon = (Integer) map.get("isgroupon");// 是否团购
		System.out.println(isgroupon);

		int iscrowdfunding = (Integer) map.get("iscrowdfunding");// 是否众筹
		System.out.println(iscrowdfunding);
		String activity = "";
		if (issnapup == 1) {
			activity = "每月特价";
			product1.setOpenDatetime(map.get("snapupstarttime").toString());
			product1.setClosingDatetime(map.get("snapupendtime").toString());
		} else if (isgroupon == 1) {
			activity = "拼单团购";
			product1.setOpenDatetime(map.get("grouponstarttime").toString());
			product1.setClosingDatetime(map.get("grouponendtime").toString());
		} else if (iscrowdfunding == 1) {
			activity = "众筹预售";
			product1.setOpenDatetime(map.get("crowfundingstarttime").toString());
			product1.setClosingDatetime(map.get("crowfundingendtime").toString());
		} else {
			activity = "无促销";
		}

		listproduct2.setNewproduct(product1);
		listproduct2.setNewproductproperty(proprety);
		listproduct2.setNewproducttype(new NewProducttype());
		listproduct2.setActivity(activity);
		listproduct2.setPictures(picture);

		request.setAttribute("listproduct2", listproduct2);
		return Action.SUCCESS;
	}
}
