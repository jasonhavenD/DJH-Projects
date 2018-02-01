package com.model.action;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import com.entity.Producttype;
import com.model.newservice.HomeslidesService;
import com.model.newservice.NewProductService;
import com.model.newservice.ProducttypeService;
import com.newentity.Homeslides;
import com.model.newvoui.CartItem;
import com.model.newvoui.FirstProductPicture;
import com.model.newvoui.SecondProductPicture;
import com.model.newvoui.ThirdProductPicture;


@Entity
@Controller
@Scope("prototype")
public class HomePageAction extends ActionSupport {
	@ManyToOne
	private List<Homeslides> lstHomeslides = new ArrayList<Homeslides>();
	private List<FirstProductPicture> firstProducPictures = new ArrayList<FirstProductPicture>();// 只有三类产品
	private List<SecondProductPicture> secondProductPictures1 = new ArrayList<SecondProductPicture>();// 每月特价
	private List<SecondProductPicture> secondProductPictures2 = new ArrayList<SecondProductPicture>();// 拼单团购
	private List<SecondProductPicture> secondProductPictures3 = new ArrayList<SecondProductPicture>();// 众筹预售

	private List<ThirdProductPicture> thirdProductPictures = new ArrayList<ThirdProductPicture>(
			6);
	private List<CartItem> cartItems = new ArrayList<CartItem>(4);// 我的购物车

	// 一级产品类别的Producttype
	private List<Producttype> lstProducttypesL1;
	// Integer为一级产品类别的Id，List<Producttype>中存放该一级产品类别所对应的二级产品类别Producttype
	private HashMap<Integer, List<Producttype>> hmIdL1AndProducttypesL2;

	@Resource
	private HomeslidesService homeslidesService;
	@Resource
	private NewProductService newProductService;
	@Resource
	private ProducttypeService producttypeService;

	private List<Map> listProductType;// 产品类别
	private List<Map> listSnapupProduct;// 特价
	private List<Map> listGroupProduct;// 团购
	private List<Map> listPresaleProduct;// 众筹
	private List<Map> listHotProduct;

	public void retreiveHomeslides() {
		System.out.println("HomePageAction-retreiveHomeslides()");
		// 首页产品类别（第一层）
		lstProducttypesL1 = producttypeService.getAllProducttypesL1();
		// 首页产品类别（第二层）
		hmIdL1AndProducttypesL2 = producttypeService.getAllProducttypesL2();
		
		ActionContext.getContext().getSession().put("lstProducttypesL1", lstProducttypesL1);
		ActionContext.getContext().getSession().put("hmIdL1AndProducttypesL2", hmIdL1AndProducttypesL2);

		lstHomeslides = homeslidesService.getHomeslides();
	}

	public void retreiveFirstProductPicture() {
		//System.out.println("HomePageAction-retreiveFirstProductPicture()");
		listProductType = newProductService.getProtypePicture();
		Iterator iterator = listProductType.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			if (map.get("parentproducttypeid").toString().equals("-1")) {
				System.out.println("ProducttypeId: " + (Integer)(map.get("producttypeid")));
				//System.out.println(map.get("producttypepicturepath").toString());
				firstProducPictures.add(i++, new FirstProductPicture(
					(Integer)(map.get("producttypeid")),
					map.get("producttypename").toString(), "产品宣传广告词，图片替换为小宣传图片", map.get(
					"producttypepicturepath").toString()));
			}
		}
		System.out.println("firstProducPictures[0]: " + firstProducPictures.get(0).getProducttypeId());
	}

	public void retreiveSecondProductPicture() {
		//System.out.println("HomePageAction-retreiveSecondProductPicture");
		try {
			listSnapupProduct = newProductService.getActiveProduct("snapup");
			listGroupProduct = newProductService.getActiveProduct("group");
			listPresaleProduct = newProductService.getActiveProduct("presale");
			System.out.println("listSnapupProduct: " + listSnapupProduct.size());
			System.out.println("listGroupProduct: " + listGroupProduct.size());
			System.out.println("listPresaleProduct: " + listPresaleProduct.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 每月特价
		Iterator iterator = listSnapupProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			//System.out.println("pictures[0]: " + pictures[0]);
			secondProductPictures1.add(new SecondProductPicture(
				(Integer)(map.get("productid")),
				map.get("productname").toString(), "发光颜色：暂无", pictures[0],
				(Double)map.get("price"),
				map.get("snapupendtime").toString()));
		}// snapupendtime=2016-06-22 05:05:13.0

		// 团购
		iterator = listGroupProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures2.add(new SecondProductPicture(
				(Integer)(map.get("productid")),
				map.get("productname").toString(), "发光颜色：暂无", pictures[0],
				(Double)map.get("price"),
				map.get("grouponendtime").toString()));
		}

		// 众筹
		iterator = listPresaleProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures3.add(new SecondProductPicture(
				(Integer)(map.get("productid")),
				map.get("productname").toString(), "发光颜色：暂无", pictures[0],
				(Double)map.get("price"),
				map.get("crowfundingendtime").toString()));
		}// "December 29, 2016 08:22:01"

	}

	public void retreiveThirdProductPicture() {
		//System.out.println("HomePageAction-retreiveThirdProductPicture");
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
			// /product/621254917626478647651321190377464.png
		}
	}

	public void retreiveCartItems() {
		System.out.println("HomePageAction-retreiveCartItems");
		for (int i = 0; i < 4; i++) {
			cartItems.add(new CartItem(
					"newpages/assets/images/demo/people/300x300/4-min.jpg", "照明产品名称标题",
					12.50, 3));
		}

	}

	public double sum() {
		double sum = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			sum += cartItems.get(i).getPrice() * cartItems.get(i).getCount();
		}
		return sum;
	}

	public String retreiveAll() throws Exception {
		retreiveHomeslides();
		retreiveFirstProductPicture();
		retreiveSecondProductPicture();
		retreiveThirdProductPicture();
		retreiveCartItems();
		return "success2";
	}
	
	@Override
	public String execute() throws Exception {
		retreiveHomeslides();
		retreiveFirstProductPicture();
		retreiveSecondProductPicture();
		retreiveThirdProductPicture();
		retreiveCartItems();
		return SUCCESS;
	}

	public List<Homeslides> getLstHomeslides() {
		return lstHomeslides;
	}

	public void setLstHomeslides(List<Homeslides> lstHomeslides) {
		this.lstHomeslides = lstHomeslides;
	}

	public HomeslidesService getHomeslidesService() {
		return homeslidesService;
	}

	public void setHomeslidesService(HomeslidesService homeslidesService) {
		this.homeslidesService = homeslidesService;
	}

	public List<FirstProductPicture> getFirstProducPictures() {
		return firstProducPictures;
	}

	public void setFirstProducPictures(
			List<FirstProductPicture> firstProducPictures) {
		this.firstProducPictures = firstProducPictures;
	}

	public List<SecondProductPicture> getSecondProductPictures1() {
		return secondProductPictures1;
	}

	public void setSecondProductPictures1(
			List<SecondProductPicture> secondProductPictures1) {
		this.secondProductPictures1 = secondProductPictures1;
	}

	public List<SecondProductPicture> getSecondProductPictures2() {
		return secondProductPictures2;
	}

	public void setSecondProductPictures2(
			List<SecondProductPicture> secondProductPictures2) {
		this.secondProductPictures2 = secondProductPictures2;
	}

	public List<SecondProductPicture> getSecondProductPictures3() {
		return secondProductPictures3;
	}

	public void setSecondProductPictures3(
			List<SecondProductPicture> secondProductPictures3) {
		this.secondProductPictures3 = secondProductPictures3;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public List<ThirdProductPicture> getThirdProductPictures() {
		return thirdProductPictures;
	}

	public void setThirdProductPictures(
			List<ThirdProductPicture> thirdProductPictures) {
		this.thirdProductPictures = thirdProductPictures;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public NewProductService getNewProductService() {
		return newProductService;
	}

	public void setNewProductService(NewProductService newProductService) {
		this.newProductService = newProductService;
	}

	public List<Map> getListProductType() {
		return listProductType;
	}

	public void setListProductType(List<Map> listProductType) {
		this.listProductType = listProductType;
	}

	public List<Map> getListHotProduct() {
		return listHotProduct;
	}

	public void setListHotProduct(List<Map> listHotProduct) {
		this.listHotProduct = listHotProduct;
	}

	public List<Map> getListSnapupProduct() {
		return listSnapupProduct;
	}

	public void setListSnapupProduct(List<Map> listSnapupProduct) {
		this.listSnapupProduct = listSnapupProduct;
	}

	public List<Map> getListGroupProduct() {
		return listGroupProduct;
	}

	public void setListGroupProduct(List<Map> listGroupProduct) {
		this.listGroupProduct = listGroupProduct;
	}

	public List<Map> getListPresaleProduct() {
		return listPresaleProduct;
	}

	public void setListPresaleProduct(List<Map> listPresaleProduct) {
		this.listPresaleProduct = listPresaleProduct;
	}

	public List<Producttype> getLstProducttypesL1() {
		return lstProducttypesL1;
	}

	public void setLstProducttypesL1(List<Producttype> lstProducttypesL1) {
		this.lstProducttypesL1 = lstProducttypesL1;
	}

	public HashMap<Integer, List<Producttype>> getHmIdL1AndProducttypesL2() {
		return hmIdL1AndProducttypesL2;
	}

	public void setHmIdL1AndProducttypesL2(
			HashMap<Integer, List<Producttype>> hmIdL1AndProducttypesL2) {
		this.hmIdL1AndProducttypesL2 = hmIdL1AndProducttypesL2;
	}

	public ProducttypeService getProducttypeService() {
		return producttypeService;
	}

	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
	}

}
