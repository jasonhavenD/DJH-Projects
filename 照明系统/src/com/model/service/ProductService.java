package com.model.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Productproperty;
import com.entity.Producttype0;
import com.model.dao.ProductDAO;
import com.model.dao.ProducttypeDAO;
import com.model.newdao.CustomproductDAO2;
import com.opensymphony.xwork2.Action;
@Entity
@Service
public class ProductService {
	@ManyToOne
	@Resource
	ProductDAO productDAO;
	@ManyToOne
	@Resource
	ProducttypeDAO typeDAO;
	@Resource
	CustomproductDAO2 customdao2;
	/**
	 * 
	 */
	/*添加自定义属性*/
	public void addCustomProduct(int id,Map map)
	{
		Iterator iter=map.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry entry=(Entry) iter.next();
			String key=(String)entry.getKey();
			String value=(String)entry.getValue();
			customdao2.add(id, key, value);
			
		}
	}
	
	//根据id查询自定义属性
	public List queryById(int id) {
		return customdao2.findByID(id);
	}
	
	public List<Map> getppt(){
		return productDAO.getRecommendRand(5);
	}
	/**
	 * 根据id查找product对象
	 */
	public Product findById(Integer id){
		return productDAO.findById(id);
	}
	/**
	 * 查找产品
	 */
	public List searchProduct(String condition){
		return productDAO.searchProduct(condition);
	}
	/**
	 * 某一个产品收藏人气
	 */
	public Integer getFavoriteByProductid(Integer productid){
		return productDAO.getFavoritebyProductid(productid).size();
	}
	/**
	 * 物流中心库存
	 */
	public List getInventory(Integer companyid){
		return  productDAO.getInventory(companyid);
	}
	/**
	 * 某一个产品库存量
	 */
	public Integer getInventoryByProductid(Integer productid ,Integer companyid){
	      List list = productDAO.getInventorybyProductid(productid, companyid);
	      if(list.size() > 0)
	      { 
	    	  Map map = (Map) list.get(0);
	    	  return (Integer) map.get("inventoryquantity");
	      }
	      else 
	    	  return 0;
	}
	/**
	 * 某一类产品收藏人气
	 */
	public Integer getFavorite(Integer typeid){
		return productDAO.getFavorite(typeid).size();
	}
	/**
	 * 某一类产品库存量
	 */
	public Integer getInventory(Integer typeid ,Integer companyid){
		return productDAO.getInventory(typeid,companyid).size();
	}
	
	public void updateProduct(Product product,Productproperty property){
		productDAO.updateProduct(product,property);
	}
	public List<Map> getProductdetailById(Integer productid){
		return productDAO.getProductdetailById(productid);
	}
	public void delete(Integer productid){
		Product product = productDAO.findById(productid);
		Productproperty property = productDAO.findPropertyById(productid);
		
		productDAO.delete(product,property);
	}
	/*
	 * 根据产品类别获取产品列表
	 *
	 */
	public List<Map> getProductBytype(Integer typeid){
		return productDAO.getProductByType(typeid);
	}
	public List<Map> getProductDetailBytype(Integer typeid){
		return productDAO.getProductDetailByType(typeid);
	}
	
	//public void saveProduct(Product product,Productproperty property,Map map){
	//	productDAO.save(product,property,map);
	//}
	
	public Integer saveProduct(Product product, Productproperty property,
			Map map) {
		return (Integer) productDAO.save(product, property, map);
	}
	public  boolean findBytypename(String producttypename){
		 List list = typeDAO.findByProducttypename(producttypename);
		 if(list.size() > 0) return false;
		 else return true;
	}
	/**
	 * 增加类型
	 * @param producttypename
	 */
	public void addProductType(String producttypename){
		Producttype0 producttype = new Producttype0();
		producttype.setProducttypename(producttypename);
		typeDAO.save(producttype);
	}
	/**
	 * 热门销售
	 */
	public List<Map> gethot_product(){
		String param = "p.ishot = 1";	
		return productDAO.gethot_product(param);
	}
	/**
	 * 新品推荐
	 */
	public List<Map> getnew_product(){
		String param = "p.isnew = 1";
		return productDAO.getnew_prodcut(param);
	}
	/**
	 * wsp
	 */
	public List<Map> getJian_product(){
		String param = "p.isrecommend = 1";
		return productDAO.getJian_product(param);
	}
	/**
	 * 获得限时抢购产品
	 */
	/**
	 * 获得产品类别
	 * @return
	 */
	public List<Map> getProductType(){
		return typeDAO.findType();
	}
	/**
	 * 全部产品管理
	 * 返回参数：
	 * productList:List({
	product.productname,
	product.inventoryquantity })
	 * @return
	 */
	public List getAll(){
		return productDAO.getAll();
	}
	/**
	 * 首页更多页面显示
	 */
	public List<Map> getMoreShow(String active){
		String param1 = "";
		List <Map> result = null;
		if(active.equals("group")){
			param1 = " p.isgroupon = 1" ;
			result = productDAO.active_common("", param1);
		}else if(active.equals("snapup")){
			param1 = " p.issnapup = 1";
			result = productDAO.active_common("", param1);
		}else if(active.equals("crowd")){
			param1 = " p.iscrowdfunding = 1";
			result = productDAO.active_common("", param1);
		}else if(active.equals("hot")){
			param1 = " p.ishot = 1";
			result = productDAO.active_common("", param1);
		}else if(active.equals("new")){
			param1 = " p.isnew = 1";
			result = productDAO.active_common("", param1);
		}
		return result;
	}
	/**
	 * 限时抢购
	 * @return
	 */
	public List<Map> getSnapUp(){
		String param1 = " p.issnapup = 1";	
		String param = ",p.snapupstarttime as snapupstarttime,p.snapupendtime as snapupendtime," +
				"p.snapupprice as snapupprice,p.snapupcertifiedprice as snapupcertifiedprice," +
				"p.snapuplogisticsprice as snapuplogisticsprice,p.snapupquantity as snapupquantity," +
				"p.grouponstartquantity as grouponstartquantity ";
		return productDAO.active_common(param, param1);
	}
	/**
	 * 团购
	 */
	public List<Map> getgroupon(){
		String param = " p.isgroupon = 1";
		/*String param = ",p.grouponstartquantity as grouponstartquantity,p.grouponstarttime " +
				"as grouponstarttime,p.grouponendtime as grouponendtime,p.grouponprice as grouponprice," +
				"p.grouponcertifiedprice as grouponcertifiedprice,p.grouponlogisticsprice as grouponlogisticsprice" +
				",p.grouponquantity as grouponquantity" ;*/
		return productDAO.common(param);
	}
	/**
	 * 众筹预售
	 */
	public List<Map> getcrowdfunding(){
		String param = " p.iscrowdfunding = 1";
		/*String param = ",p.crowfundingstartquantity as crowfundingstartquantity ,p.crowfundingdepositrate as crowfundingdepositrate" +
				",p.crowfundingstarttime as crowfundingstarttime,p.crowfundingendtime as crowfundingendtime,p.crowfundingprice as " +
				"crowfundingprice,p.crowfundingcertifiedprice as crowfundingcertifiedprice,p.crowfundinglogisticsprice as " +
				"crowfundinglogisticsprice,p.crowfundingquantity as crowfundingquantity";*/
		return productDAO.common(param);
	}
}	
