package com.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.entity.Producttype;
import com.model.newservice.HomeslidesService;
import com.model.newservice.NewProductService;
import com.model.newservice.ProducttypeService;
import com.model.newvoui.CartItem;
import com.newentity.Homeslides;
import com.model.newvoui.SecondProductPicture;
import com.model.newvoui.ShopItem;
import com.model.newvoui.ThirdProductPicture;
import com.publicentity.Page;

public class ProductCatalogAction extends ActionSupport {

	private List<CartItem> cartItems = new ArrayList<CartItem>(4);// 我的购物车

	@Resource
	private NewProductService newProductService;

	@Resource
	private HomeslidesService homeslidesService;
	@ManyToOne
	private List<Homeslides> lstHomeslides = new ArrayList<Homeslides>();

	@Resource
	private ProducttypeService producttypeService;

	private List<Map> listHotProduct;
	private List<Map> listNewProduct;

	private List<ThirdProductPicture> thirdProductPictures = new ArrayList<ThirdProductPicture>();// 热销推荐
	private List<ThirdProductPicture> thirdProductPictures2 = new ArrayList<ThirdProductPicture>();// 新品上市

	private List<Map> listProductType;// 产品类别
	private List<Map> listSnapupProduct;// 特价
	private List<Map> listGroupProduct;// 团购
	private List<Map> listPresaleProduct;// 众筹
	private List<SecondProductPicture> secondProductPictures1 = new ArrayList<SecondProductPicture>();// 每月特价
	private List<SecondProductPicture> secondProductPictures2 = new ArrayList<SecondProductPicture>();// 拼单团购
	private List<SecondProductPicture> secondProductPictures3 = new ArrayList<SecondProductPicture>();// 众筹预售

	// 一级产品类别的Producttype
	private List<Producttype> lstProducttypesL1;
	// Integer为一级产品类别的Id，List<Producttype>中存放该一级产品类别所对应的二级产品类别Producttype
	private HashMap<Integer, List<Producttype>> hmIdL1AndProducttypesL2;

	private List<Map> listProducttype;

	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	private Page page;

	private int type;// 0,1,2,3->全部，每月特价,拼单团购,众筹预售

	public void retreiveProductType() {
		// 产品分类
		listProducttype = newProductService.getProTypeList();
		if (listProducttype == null)
			System.out.println("listProducttype==null");
		// 首页产品类别（第一层）
		lstProducttypesL1 = producttypeService.getAllProducttypesL1();
		// 首页产品类别（第二层）
		hmIdL1AndProducttypesL2 = producttypeService.getAllProducttypesL2();
	}

	public void retreiveProductByType() {
		// 产品信息
		// productService.getProListByType();

	}

	public void retreiveActiveProduct() {
		// 获取活动产品
		try {
			listSnapupProduct = newProductService.getActiveProduct("snapup");
			listGroupProduct = newProductService.getActiveProduct("group");
			listPresaleProduct = newProductService.getActiveProduct("presale");
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
			secondProductPictures1.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"snapupendtime").toString()));
		}// snapupendtime=2016-06-22 05:05:13.0

		// 团购
		iterator = listGroupProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures2.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"grouponendtime").toString()));
		}

		// 众筹
		iterator = listPresaleProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures3.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"presaleendtime").toString()));
		}// "December 29, 2016 08:22:01"
	}

	public void retreiveActiveProduct2() {
		// 获取活动产品
		try {
			// listSnapupProduct = newProductService.getActiveProduct("snapup");
			listSnapupProduct = newProductService
					.getActiveProductByProducttypeId("snapup",
							this.producttypeId);
			System.out
					.println("listSnapupProduct: " + listSnapupProduct.size());
			// listGroupProduct = newProductService.getActiveProduct("group");
			listGroupProduct = newProductService
					.getActiveProductByProducttypeId("group",
							this.producttypeId);
			System.out.println("listGroupProduct: " + listGroupProduct.size());
			// listPresaleProduct =
			// newProductService.getActiveProduct("presale");
			listPresaleProduct = newProductService
					.getActiveProductByProducttypeId("presale",
							this.producttypeId);
			System.out.println("listPresaleProduct: "
					+ listPresaleProduct.size());
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
			secondProductPictures1.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"snapupendtime").toString()));
		}// snapupendtime=2016-06-22 05:05:13.0

		// 团购
		iterator = listGroupProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures2.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"grouponendtime").toString()));
		}

		// 众筹
		iterator = listPresaleProduct.iterator();
		while (iterator.hasNext()) {
			Map map = (Map) iterator.next();
			String paths = (String) map.get("productpicture");
			String[] pictures = paths.split("\\|");
			secondProductPictures3.add(new SecondProductPicture((Integer) (map
					.get("productid")), map.get("productname").toString(),
					"发光颜色：暂无", pictures[0], (Double) map.get("price"), map.get(
							"crowfundingendtime").toString())); // presaleendtime
		}// "December 29, 2016 08:22:01"
	}

	public void retreiveNewProduct() {
		// 新品上市
		// listNewProduct = newProductService.getNewProduct();//暂无新货
		listNewProduct = newProductService.getHotProduct();
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
					pictures[0], "发光颜色: 暂无", (Double) map.get("price")));
		}

	}

	public void retreiveNewProduct2() {
		// 新品上市
		// listNewProduct = newProductService.getNewProduct();//暂无新货
		listNewProduct = newProductService
				.getNewProductByProducttypeId(this.producttypeId);
		System.out.println("listNewProduct" + listNewProduct.size());
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
					pictures[0], "发光颜色: 暂无", (Double) map.get("price")));
		}

	}

	public void retreiveHotProductPicture() {
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

	public void retreiveHotProductPicture2() {
		// 热销推荐
		listHotProduct = newProductService
				.getHotProductByProducttypeId(this.producttypeId);

		System.out.println("listHotProduct" + listHotProduct.size());

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

	public void retreiveCenterlides() {
		// 幻灯片图片
		System.out.println("CenterPageAction-retreiveCenterlides");
		lstHomeslides = homeslidesService.getHomeslides(); // ???
	}

	public void retreiveCenterlides2() {
		// 幻灯片图片
		System.out.println("CenterPageAction-retreiveCenterlides");
		lstHomeslides = homeslidesService.getHomeslides(); // ???
	}

	// 我的购物车
	public void retreiveCartItems() {
		System.out.println("HomePageAction-retreiveCartItems");
		System.out.println("size() 1 =" + cartItems.size());
		for (int i = 0; i < 4; i++) {
			cartItems.add(new CartItem(
					"newpages/assets/images/demo/people/300x300/4-min.jpg", "照明产品名称标题",
					12.50, 3));
		}
		System.out.println("size() 2 =" + cartItems.size());
	}

	public double sum() {
		double sum = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			sum += cartItems.get(i).getPrice() * cartItems.get(i).getCount();
		}
		return sum;
	}

	public String retreiveAll() throws Exception {
		retreiveCenterlides();
		retreiveHotProductPicture();
		retreiveNewProduct();
		retreiveActiveProduct();
		retreiveProductType();
		retreiveCartItems();
		return "success2";
	}

	public String retreiveAllByProdtypeId() throws Exception {
		System.out.println("in retreiveAllByProdtypeId()");
		retreiveCenterlides2();
		retreiveHotProductPicture2();
		retreiveNewProduct2();
		retreiveActiveProduct2();
		retreiveProductType();
		retreiveCartItems();
		return "success2";
	}

	// 得到分页的活动产品
		// public void retreiveActivityProductsByPage0() {
		// int pageIndex, pageSize, totalCount;
		// pageIndex = page.getPageIndex();
		// pageSize = page.getPageSize();
		// totalCount = page.getTotalCount();
		//
		// System.out.println("得到分页的活动产品");
		// System.out.println(type);
		//
		// if (pageIndex == 0 || pageSize == 0 || totalCount == 0) {
		// System.out.println("ProductCatalogAction-retreiveProductsByPage()");
		// }
		// // 获取活动产品
		// try {
		// listSnapupProduct = newProductService.getActiveProduct("snapup",
		// page);
		// listGroupProduct = newProductService
		// .getActiveProduct("group", page);
		// listPresaleProduct = newProductService.getActiveProduct("presale",
		// page);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// if (type == 0) {
		// getActivitiesSnapupByPage(listSnapupProduct);
		// // getActivitiesPresaleByPage(listPresaleProduct);
		// // getActivitiesPresaleByPage(listPresaleProduct);
		// } else if (type == 1) {
		// getActivitiesSnapupByPage(listSnapupProduct);
		// } else if (type == 2) {
		// getActivitiesPresaleByPage(listPresaleProduct);
		// } else if (type == 3) {
		// getActivitiesPresaleByPage(listPresaleProduct);
		// }
		//
		// }

		// 得到分页的活动产品
		public String retreiveActivityProductsByPage() {
			int pageIndex, pageSize, totalCount;
			pageIndex = page.getPageIndex();
			pageSize = page.getPageSize();
			totalCount = page.getTotalCount();

			System.out.println("得到分页的活动产品");

			if (pageIndex == 0 || pageSize == 0 || totalCount == 0) {
				System.out.println("ProductCatalogAction-retreiveProductsByPage()");
			}
			// 获取活动产品
			try {
				listSnapupProduct = newProductService.getActiveProduct("snapup",
						page);
				listGroupProduct = newProductService
						.getActiveProduct("group", page);
				listPresaleProduct = newProductService.getActiveProduct("presale",
						page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (type == 0) {
				getActivitiesSnapupByPage(listSnapupProduct);
				getActivitiesGroupByPage(listGroupProduct);
				getActivitiesPresaleByPage(listPresaleProduct);
			} else if (type == 1) {
				getActivitiesSnapupByPage(listSnapupProduct);
			} else if (type == 2) {
				getActivitiesGroupByPage(listGroupProduct);
			} else if (type == 3) {
				getActivitiesPresaleByPage(listPresaleProduct);
			}
			
			System.out.println("hashmap:");
			Iterator iterator = hashmap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				System.out.println(key + "::" + hashmap.get(key));
			}
			return Action.SUCCESS;
		}

		public void getActivitiesSnapupByPage(List<Map> listSnapupProduct) {
			System.out.println("getActivitiesSnapupByPage------"
					+ listSnapupProduct.size());
			// 每月特价
			int loopCount = 0;
			int listSize = listSnapupProduct.size();
			Iterator<Map> iterator = listSnapupProduct.iterator();
			while (iterator.hasNext()) {
				Map map = (Map) iterator.next();
				if (++loopCount == listSize) {
					// System.out.println("(x)map=" + map);
					hashmap.putAll(map); // ("totalPage", totalPage)
				} else {
					// System.out.println("(y)map=" + map);
					String paths = (String) map.get("productpicture");
					if (paths == null) {
						System.out.println("paths=null: " + map.get("productid"));
						return;
					}
					String[] pictures = paths.split("\\|");

					secondProductPictures1.add(new SecondProductPicture(
							(Integer) (map.get("productid")), map
									.get("productname").toString(), "发光颜色：暂无",
							pictures[0], (Double) map.get("price"), map.get(
									"snapupendtime").toString()));
				}
			}// snapupendtime=2016-06-22 05:05:13.0
			hashmap.put("secondProductPictures1", secondProductPictures1);
		}

		public void getActivitiesGroupByPage(List<Map> listGroupProduct) {
			System.out.println("getActivitiesGroupByPage------"
					+ listGroupProduct.size());
			// 团购
			int loopCount = 0;
			int listSize = listGroupProduct.size();
			Iterator<Map> iterator = listGroupProduct.iterator();
			while (iterator.hasNext()) {
				Map map = (Map) iterator.next();
				// System.out.println("map=" + map);

				if (++loopCount == listSize) {
					// System.out.println("(x)map=" + map);
					hashmap.putAll(map); // ("totalPage", totalPage)
				} else {
					// System.out.println("(y)map=" + map);
					String paths = (String) map.get("productpicture");
					String[] pictures = paths.split("\\|");
					secondProductPictures2.add(new SecondProductPicture(
							(Integer) (map.get("productid")), map
									.get("productname").toString(), "发光颜色：暂无",
							pictures[0], (Double) map.get("price"), map.get(
									"grouponendtime").toString()));
				}
			}
			hashmap.put("secondProductPictures2", secondProductPictures2);
		}

		public void getActivitiesPresaleByPage(List<Map> listPresaleProduct) {
			System.out.println("getActivitiesPresaleByPage------"
					+ listPresaleProduct.size());
			// 众筹
			int loopCount = 0;
			int listSize = listPresaleProduct.size();
			Iterator<Map> iterator = listPresaleProduct.iterator();
			while (iterator.hasNext()) {
				Map map = (Map) iterator.next();
				if (++loopCount == listSize) {
					// System.out.println("(x3)map=" + map);
					hashmap.putAll(map); // ("totalPage", totalPage)
				} else {
					// System.out.println("(y)map=" + map);
					String paths = (String) map.get("productpicture");
					String[] pictures = paths.split("\\|");
					secondProductPictures3.add(new SecondProductPicture(
							(Integer) (map.get("productid")), map
									.get("productname").toString(), "发光颜色：暂无",
							pictures[0], (Double) map.get("price"), map.get(
									"crowfundingendtime").toString())); // presaleendtime
				}
			}// "December 29, 2016 08:22:01"
			hashmap.put("secondProductPictures3", secondProductPictures3);
		}


	@Override
	public String execute() throws Exception {
		retreiveCenterlides();
		retreiveHotProductPicture();
		retreiveNewProduct();
		retreiveActiveProduct();
		retreiveProductType();
		retreiveCartItems();
		return SUCCESS;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
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

	public List<Map> getListHotProduct() {
		return listHotProduct;
	}

	public void setListHotProduct(List<Map> listHotProduct) {
		this.listHotProduct = listHotProduct;
	}

	public List<ThirdProductPicture> getThirdProductPictures() {
		return thirdProductPictures;
	}

	public void setThirdProductPictures(
			List<ThirdProductPicture> thirdProductPictures) {
		this.thirdProductPictures = thirdProductPictures;
	}

	public List<Map> getListNewProduct() {
		return listNewProduct;
	}

	public void setListNewProduct(List<Map> listNewProduct) {
		this.listNewProduct = listNewProduct;
	}

	public List<ThirdProductPicture> getThirdProductPictures2() {
		return thirdProductPictures2;
	}

	public void setThirdProductPictures2(
			List<ThirdProductPicture> thirdProductPictures2) {
		this.thirdProductPictures2 = thirdProductPictures2;
	}

	public List<Map> getListProductType() {
		return listProductType;
	}

	public void setListProductType(List<Map> listProductType) {
		this.listProductType = listProductType;
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

	public ProducttypeService getProducttypeService() {
		return producttypeService;
	}

	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
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

	public List<Map> getListProducttype() {
		return listProducttype;
	}

	public void setListProducttype(List<Map> listProducttype) {
		this.listProducttype = listProducttype;
	}

	public HomeslidesService getHomeslidesService() {
		return homeslidesService;
	}

	public void setHomeslidesService(HomeslidesService homeslidesService) {
		this.homeslidesService = homeslidesService;
	}

	public List<Homeslides> getLstHomeslides() {
		return lstHomeslides;
	}

	public void setLstHomeslides(List<Homeslides> lstHomeslides) {
		this.lstHomeslides = lstHomeslides;
	}

	// /////
	private Integer producttypeId;// 产品类别id

	public Integer getProducttypeId() {
		return producttypeId;
	}

	public void setProducttypeId(Integer producttypeId) {
		this.producttypeId = producttypeId;
	}

	// ////

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


}
