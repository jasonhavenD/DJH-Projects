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
public class ProductShowAction1 extends ActionSupport{
	
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
				 listNewProduct = newProductService.getNewProduct();//暂无新货
				//listNewProduct = newProductService.getHotProduct();
				if (listNewProduct == null) {
					System.out.println("listNewProduct==null");
					return;
				}
				Iterator iterator = listNewProduct.iterator();
				while (iterator.hasNext()) {
					Map map = (Map) iterator.next();
					String paths = (String) map.get("productpicture");
					String[] pictures = paths.split("\\|");
					thirdProductPictures2.add(new ThirdProductPicture(
						(Integer)(map.get("productid")),
						map.get("productname").toString(), pictures[1], "发光颜色: 暂无",
						(Double) map.get("price")));
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
					thirdProductPictures.add(new ThirdProductPicture(
						(Integer)(map.get("productid")),
						map.get("productname").toString(), pictures[0], "发光颜色: 暂无",
						(Double) map.get("price")));
				}
	}


	
	/**
	 * 根据productid获取产品详情
	 * @return
	 */
	@Resource
	private ProductService productService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	ProductShowAction1(){}
	
	public void getSameProduct(){
		Integer productid = Integer.valueOf(request.getParameter("productid"));
		List<Map> list = productService.getProductdetailById(productid);
		Map map = (Map)list.get(0);
		String producttypename = (String)map.get("producttypename");
		//String producttype = map.get("producttypename").toString();
	
		List<Map> list1 = newProductService.getProductdetailByType(producttypename);
		System.out.println(list1);
		System.out.println(list1.size());
		for(int i = 0;i < list1.size();i++){
			Map map1 = (Map)list1.get(i);
			String paths = (String)map1.get("productpicture");
			String[] pictures = paths.split("\\|");
			sameProductlist.add(new NewProduct(
					(Integer)map1.get("productid"),
					map1.get("productname").toString(),
					pictures[0],
					map1.get("productdiscribe").toString(),
					(Double)map1.get("price")));
		}
	}
	
	public String getOneProductdetail(){
		
		//System.out.println(productid);
		
		retreiveHotProductPicture2();
		retreiveNewProduct2();
		getSameProduct();
		
		
		Integer productid = Integer.valueOf(request.getParameter("productid"));
		List<Map> list = productService.getProductdetailById(productid);
		
		Map map = (Map)list.get(0);
		//获取图片
		String pictures = (String)map.get("productpicture");
		String[] picture = pictures.split("\\|");
		for(int i=0;i<5;i++)
		{
			picture[i]=picture[i].substring(0, 0)+picture[i].substring(1);
		}
		System.out.println(list);
		request.setAttribute("picture", picture);
		
		//获取标题信息
		String productname = (String)map.get("productname");
		request.setAttribute("productname", productname);
		System.out.println(productname);
		
		//获取功率信息
		String power = (String)map.get("power");
		request.setAttribute("power", power);
		System.out.println(power);
		
		//获得光通量
		String luminousflux = (String)map.get("luminousflux");
		request.setAttribute("luminousflux", luminousflux);
		System.out.println(luminousflux);
		
		//获取色温信息
		String colortemp =(String)map.get("colortemp");
		request.setAttribute("colortemp", colortemp);
		System.out.println(colortemp);
		
		//获取销售类型
		int issnapup = (Integer)map.get("issnapup");//是否限时抢购
		System.out.println(issnapup);
		
		int isgroupon = (Integer)map.get("isgroupon");//是否团购
		System.out.println(isgroupon);
		
		int iscrowdfunding = (Integer)map.get("iscrowdfunding");//是否众筹
		System.out.println(iscrowdfunding);
		
		if(issnapup==1)
		{
			request.setAttribute("activity", "限时促销");
		}else if(isgroupon==1)
		{
			request.setAttribute("activity", "团购");
		}else if(iscrowdfunding==1){
			request.setAttribute("activity", "众筹预售");
		}else{
			request.setAttribute("activity", "无");
		}
		
		//获得各种用户的不同价格
		Double price =(Double) map.get("price");
		request.setAttribute("price", price);
		System.out.println(price);
		//给转发的页面/newpages/ProductShow.jsp传递参数productid
		ActionContext.getContext().put("productid", productid); 
		System.out.println("ActionContext.getContext()");
		
		
		return Action.SUCCESS;
	}
}
