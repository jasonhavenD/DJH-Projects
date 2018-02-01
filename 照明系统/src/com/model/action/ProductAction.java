package com.model.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.entity.Product;
import com.entity.Productproperty;
import com.entity.Producttype;
import com.entity.Userinfo;
import com.model.newservice.ProductImgService;
import com.model.service.OrderService;
import com.model.service.ProductService;
import com.newentity.Customproduct;
import com.newentity.ProductImg;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@Entity
@Controller
@Scope("prototype")
public class ProductAction implements ModelDriven<Product>{
	private String proImg;
	private List<Customproduct> cplist = new LinkedList<Customproduct>();
	@Resource
	private ProductImgService productimgservice;
	
	@ManyToOne
	private Product product = new Product();
	@ManyToOne
	private Productproperty property = new Productproperty();
	@ManyToOne
	@Resource
	private ProductService productService;
	@ManyToOne
	@Resource 
	private OrderService orderservice;
	
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	private List<List> listmap = new ArrayList<List>();
	private HttpServletRequest request = ServletActionContext.getRequest();
	public ProductAction(){
		
	}
	public String purchaseProduct(){
		String count = request.getParameter("num");
		String total = request.getParameter("total");
		String productid = request.getParameter("productid");
		String productname = request.getParameter("productname");
		String productpicture = request.getParameter("productpicture");
		String property = request.getParameter("property");
		String realprice = request.getParameter("realprice");
		List tmp = new ArrayList();
		tmp.add(productpicture);
		tmp.add(productname);
		tmp.add(property);
		tmp.add(realprice);
		tmp.add(count);
		tmp.add(total);
		tmp.add(productid);
		listmap.add(tmp);
		return Action.SUCCESS;
	}
	/**
	 * 首页查找
	 */
	public  String searchProduct(){
		try{
		String condition = request.getParameter("active");
		condition = "%"+condition+"%";
		List list = productService.searchProduct(condition);
		hashmap.put("morelist", list);
		java.util.Iterator iter =  list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		//System.out.println(list);
		}catch(Exception e){
			hashmap.put("morelist", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	} 
	/**
	 * 某一个产品收藏人气
	 */
	public Integer getFavorite(Integer typeid){
		Integer favorite = 0;
		try{
			favorite = productService.getFavorite(typeid);
			}catch(Exception e){
				e.printStackTrace();
				hashmap.put("inventory", "fail");
			}		
		return favorite;
	}
	/**
	 * 物流中心库存
	 */
	public String getLogInven(){
		try {
			//Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
			List list = productService.getInventory(101);
			hashmap.put("list", list);
		} catch (Exception e) {
			hashmap.put("list", "fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 某一个产品库存量
	 */
	public Integer getInventory(Integer typeid){
		Integer inventory = 0;
		try{
		Integer companyid = getCompanyid();
		if(companyid != null){
			inventory = productService.getInventoryByProductid(typeid, companyid);
		}
		}catch(Exception e){
			e.printStackTrace();
			hashmap.put("inventory", "fail");
		}
		return inventory;
	}
	/**
	 * 根据产品类别id获取产品列表
	 */
	public String getProductByType(){
		try{
		Integer typeid = Integer.valueOf(request.getParameter("typeid"));
		List list = productService.getProductBytype(typeid);
		System.out.println(list);
		hashmap.put("list", list);
		}catch(Exception e){
			e.printStackTrace();
			hashmap.put("list", "fail");
		}
		return Action.SUCCESS;
	}
	
	public String getProductDetailByType(){
		try{
			Integer typeid = Integer.valueOf(request.getParameter("typeid"));
			List list = productService.getProductDetailBytype(typeid);
			hashmap.put("list", list);
			/*Integer favorite = getFavorite(typeid);
			hashmap.put("favorite", favorite);
			Integer inventory = getInventory(typeid);
			hashmap.put("inventory", inventory);*/
			}catch(Exception e){
				e.printStackTrace();
				hashmap.put("list", "fail");
			}
			return Action.SUCCESS;
	}
	/**
	 * 根据productid获取产品详情
	 * @return
	 */
	public String getOneProductdetail(){
		try{
		Integer productid = Integer.valueOf(request.getParameter("productid"));
//		Integer productid = 1;
		List<Map> list = productService.getProductdetailById(productid);
		System.out.println(list);
		hashmap.put("list", list);
		List l=productService.queryById(productid);
		System.out.println("123"+l);
		hashmap.put("l", l);
		Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
		if(userinfo.getMembertype() != 1){
			Integer favorite = productService.getFavoriteByProductid(productid);
			hashmap.put("favorite", favorite);
			Integer companyid = getCompanyid();
			Integer inventory = 0;
			if(companyid != null){
				inventory = productService.getInventoryByProductid(productid, companyid);
			}
			hashmap.put("inventory", inventory);
		}
		}catch(Exception e){
			e.printStackTrace();
			hashmap.put("list", "fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取产品类别
	 * productTypeList:List({
		producttype.producttypeid,
		producttype.producttypename})
	 * @return
	 */
	public String getTypeList(){
		try{
			Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("typelist","noLogin");
				return Action.SUCCESS;
			}
			List<Map> typelist = productService.getProductType();
			hashmap.put("typelist", typelist);
			System.out.println(typelist);
			}catch(Exception e){
				e.printStackTrace();
				hashmap.put("typelist", "fail");//获取失败
			}
		return Action.SUCCESS;
	}
	public String addProductType(){
			try{
				Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
				if(userinfo == null){
					hashmap.put("addResult","noLogin");
					return Action.SUCCESS;
				}
				//
				String producttypename = request.getParameter("producttypename");
				boolean result = productService.findBytypename(producttypename);
				if(result){
					productService.addProductType(producttypename);
					hashmap.put("addResult", "success");
				}
				else
				{
					hashmap.put("addResult", "repeat");
				}
				System.out.println("success");
			}catch(Exception e){
				e.printStackTrace();
				hashmap.put("addResult", "fail");
			}
		return Action.SUCCESS;
	}
	/**
	 * update 更新产品详细信息
	 * @return
	 */
	public String update(){
		try{
		System.out.println("update");
		property.setPower(request.getParameter("power"));
		property.setLampholder(request.getParameter("lampholder"));
		property.setColortemp(request.getParameter("colortemp"));
		property.setVoltage(request.getParameter("voltage"));
		property.setLuminousflux(request.getParameter("luminousflux"));
		property.setLightefficiency(request.getParameter("lightefficiency"));
		property.setColorrendering(request.getParameter("colorrendering"));
		property.setBeamangle(request.getParameter("beamangle"));
		property.setIsemc(request.getParameter("isemc"));
		productService.updateProduct(product,property);
		hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 发布产品(即添加产品)
	 * @return
	 */
	public String release(){
		try{
		
		property.setPower(request.getParameter("power"));
		property.setLampholder(request.getParameter("lampholder"));
		property.setColortemp(request.getParameter("colortemp"));
		property.setVoltage(request.getParameter("voltage"));
		property.setLuminousflux(request.getParameter("luminousflux"));
		property.setLightefficiency(request.getParameter("lightefficiency"));
		property.setColorrendering(request.getParameter("colorrendering"));
		property.setBeamangle(request.getParameter("beamangle"));
		property.setIsemc(request.getParameter("isemc"));
		System.out.print(property);
		System.out.println(request.getParameter("map"));
		String mapJson=request.getParameter("map");
		JSONObject jb = JSONObject.fromObject(mapJson);
		Map map=(Map)jb;
		System.out.print(map);
		
//		System.out.println(property);
		//productService.saveProduct(product, property,map);
		
		String[] prodetailimg = product.getProductpicture().split("\\|");
		product.setProductpicture(proImg);
		int id = productService.saveProduct(product, property, map);
		for (String img : prodetailimg) {
			ProductImg pi = new ProductImg();
			pi.setImgtype(2);
			pi.setImgurl(img);
			pi.setProductid(id);
			productimgservice.saveImg(pi);
		}
	
		hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	public String delete(){
		
		try
		{
		Integer productid = Integer.valueOf(request.getParameter("productid"));
		productService.delete(productid);
		productimgservice.delete(productid);
		hashmap.put("state", "success");
		}catch(Exception e){
			hashmap.put("state", "fail");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获取首页产品
	 * @return
	 */
	public String getIndexProduct(){
		
		List list = productService.gethot_product();
		hashmap.put("hotlist", list);
		List list1 = productService.getnew_product();
		hashmap.put("newlist", list1);
		//
		List list0 = productService.getJian_product();
		hashmap.put("jianlist", list0);
		List list2 = productService.getSnapUp();
		hashmap.put("snaplist", list2);
		System.out.println(list2);
		List list3 = productService.getgroupon();
		hashmap.put("grouplist", list3);
		System.out.println(list3);
		List list4 = productService.getcrowdfunding();
		hashmap.put("crowdlist", list4);
		System.out.println(list4);
		/**
		 * 获得首页幻灯片内容
		 */
		List list5 = productService.getppt();
		System.out.println("list5"+list5);
		hashmap.put("pptlist", list5);
		return Action.SUCCESS;
	}
	/**
	 * 首页更多页面显示
	 */
	public String getMoreShow(){
		String active = request.getParameter("active");
		List<Map> morelist = productService.getMoreShow(active);
		hashmap.put("morelist", morelist);
		return Action.SUCCESS;
	}
	/**
	 * 全部产品管理
	 * 返回参数：
	 * productList:List({
		product.productname,
		product.inventoryquantity })

	 * @return
	 */
	public String getAll(){
		try{
			List list = productService.getAll();
			hashmap.put("List", list);
		}catch(Exception e){
			hashmap.put("List", "SystemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 限时特价产品管理
	 * @return
	 */
	public String getSnapUp(){
		try{
			List list = productService.getSnapUp();
			System.out.println(list);
			hashmap.put("List", list);
		}catch(Exception e){
			hashmap.put("List", "SystemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 团购产品管理
	 * 
	 */
	public String getgroupon(){
		try{
			List list = productService.getgroupon();
			System.out.println(list);
			hashmap.put("List", list);
		}catch(Exception e){
			hashmap.put("List", "SystemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 众筹预售产品管理
	 */
	public String getcrowdfunding(){
		try{
			List list = productService.getcrowdfunding();
			System.out.println(list);
			hashmap.put("List", list);
		}catch(Exception e){
			hashmap.put("List", "SystemError");
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 获得本地区物流中心
	 * @return
	 */
	private Integer getCompanyid(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	/*	Userinfo userinfo = new Userinfo(); 
		userinfo.setUserinfoid(1);*/
		List list = orderservice.getCompanyName(userinfo.getUserinfoid());
		Map list1 = null;
		if(list == null)
			return null;
		if(list.size() > 0)
			list1 =  (Map) list.get(0);
		else
			return null;
		System.out.println((Integer) list1.get("companyid"));
		return (Integer) list1.get("companyid");
	}
	/**
	 * 获得本地区物流中心
	 * @return
	 */
	private String getProvince(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	/*	Userinfo userinfo = new Userinfo(); 
		userinfo.setUserinfoid(1);*/
		List list = orderservice.getCompanyName(userinfo.getUserinfoid());
		Map list1 = null;
		if(list.size() > 0)
			list1 =  (Map) list.get(0);
		else
			return null;
		System.out.println((Integer) list1.get("companyid"));
		return (String) list1.get("province");
	}
	public Productproperty getProperty() {
		return property;
	}
	public void setProperty(Productproperty property) {
		this.property = property;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public Product getModel() {
		return product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	
}
