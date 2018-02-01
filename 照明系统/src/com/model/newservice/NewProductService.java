package com.model.newservice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Producttype;
import com.model.newdao.NewProductDAO;
import com.model.newdao.NewProducttypeDAO;
import com.model.newdao.ProducttypeDAO2;
import com.newentity.NewComment;
import com.newentity.NewProduct;
import com.newentity.NewProducttype;
import com.publicentity.Page;

import java.util.*;


@Service
public class NewProductService {
	@Resource
	NewProducttypeDAO typeDAO;
	@Resource
	ProducttypeDAO2 producttypeDAO2; //待整合
			
	@Resource
	NewProductDAO productDAO;
	
	//获取产品类别图片
	@SuppressWarnings("rawtypes")
	public List<Map> getProtypePicture(){
		return typeDAO.getProtypePicture();
	}
	/**
	 * snapup:每月特价
	   group：团购
	   presale:众筹预售
	   //名字描述价格 图片 结束时间
	 * @param activeName
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getActiveProduct(String activeName) throws Exception{
		if(activeName == null || activeName.equals("")){
			throw new Exception("活动名不能为空");
		}
		String param1 = "";//根据不同条件查询出不同的时间
		String param2 = "";//where 条件
		if(activeName.equals("snapup")){
			 param1 = " snapupendtime as snapupendtime, "
			 		+ "snapupprice as snapupprice, "
			 		+ "snapupcertifiedprice as snapupcertifiedprice ,"
			 		+ "snapuplogisticsprice as snapuplogisticsprice,";
			 param2 = " issnapup = 1";
		}else if(activeName.equals("group")){
			 param1 = " grouponendtime as grouponendtime,"
			 		+ "grouponprice as grouponprice,"
			 		+ "grouponcertifiedprice as grouponcertifiedprice,"
			 		+ "grouponlogisticsprice as grouponlogisticsprice,";
			 param2 = " isgroupon = 1";
		}else if(activeName.equals("presale")){
			 param1 = " crowfundingendtime as crowfundingendtime,"
			 		+ "crowfundingprice as crowfundingprice,"
			 		+ "crowfundingcertifiedprice as crowfundingcertifiedprice,"
			 		+ "crowfundinglogisticsprice as crowfundinglogisticsprice,";
			 param2 = " iscrowdfunding = 1";
		}
		return productDAO.getActiveProduct(param1,param2);
	}
	public List<Map> getActiveProductByProducttypeId(String activeName, int producttypeId) throws Exception{
		if(activeName == null || activeName.equals("")){
			throw new Exception("活动名不能为空");
		}
		String param1 = "";//根据不同条件查询出不同的时间
		String param2 = "";//where 条件
		
		String sProducttypeIds = "producttypeid in (" + this.typeDAO.getProtypeIdsByParent(producttypeId) + ")";
		
		if(activeName.equals("snapup")){
			 param1 = " snapupendtime as snapupendtime, "
			 		+ "snapupprice as snapupprice, "
			 		+ "snapupcertifiedprice as snapupcertifiedprice ,"
			 		+ "snapuplogisticsprice as snapuplogisticsprice,";
			 param2 = " issnapup = 1 AND " + sProducttypeIds;
		}else if(activeName.equals("group")){
			 param1 = " grouponendtime as grouponendtime,"
			 		+ "grouponprice as grouponprice,"
			 		+ "grouponcertifiedprice as grouponcertifiedprice,"
			 		+ "grouponlogisticsprice as grouponlogisticsprice,";
			 param2 = " isgroupon = 1 AND " + sProducttypeIds;
		}else if(activeName.equals("presale")){
			 param1 = " crowfundingendtime as crowfundingendtime,"
			 		+ "crowfundingprice as crowfundingprice,"
			 		+ "crowfundingcertifiedprice as crowfundingcertifiedprice,"
			 		+ "crowfundinglogisticsprice as crowfundinglogisticsprice,";
			 param2 = " iscrowdfunding = 1 AND " + sProducttypeIds;
		}
		return productDAO.getActiveProduct(param1, param2);
	}
	
	
	//获取产品类别列表
	public List<Map> getProTypeList(){
		return this.getProtypePicture();
	}
	//根据产品类别，获取产品信息	
	/**
	 * @param typeid 产品类别ID
	 * @param Page page pageIndex 初次加载页面为1，点击某页面时，传入当前页面页码
	 * pageSize 当前页面显示条数 一般设为12。
	 * @return
	 * @throws Exception 
	 */
	public List<Map> getProListByType(Integer typeid,Page page) throws Exception{
		if(page == null || page.getPageIndex() == null || page.getPageSize() == null){
			throw new Exception("请传入分页参数");
		}
		if(page.getPageIndex() < 0 || page.getPageSize() < 0){
			throw new Exception("请传入合法分页参数");
		}
		return productDAO.getProListByType(typeid,page.getFromIndex(),page.getPageSize());
	}
	
	//获取活动产品	
	public List<Map> getActiveProduct(String activeName,Page page) throws Exception{
		if(page == null || page.getPageIndex() == null || page.getPageSize() == null){
			throw new Exception("请传入分页参数");
		}
		if(page.getPageIndex() < 0 || page.getPageSize() < 0){
			throw new Exception("请传入合法分页参数");
		}
		String param1 = "";//根据不同条件查询出不同的时间
		String param2 = "";//where 条件
		if(activeName.equals("snapup")){
			 param1 = " snapupendtime as snapupendtime, "
			 		+ "snapupprice as snapupprice, "
			 		+ "snapupcertifiedprice as snapupcertifiedprice ,"
			 		+ "snapuplogisticsprice as snapuplogisticsprice,";
			 param2 = " issnapup = 1";
		}else if(activeName.equals("group")){
			 param1 = " grouponendtime as grouponendtime,"
			 		+ "grouponprice as grouponprice,"
			 		+ "grouponcertifiedprice as grouponcertifiedprice,"
			 		+ "grouponlogisticsprice as grouponlogisticsprice,";
			 param2 = " isgroupon = 1";
		}else if(activeName.equals("presale")){
			 param1 = " crowfundingendtime as crowfundingendtime,"
			 		+ "crowfundingprice as crowfundingprice,"
			 		+ "crowfundingcertifiedprice as crowfundingcertifiedprice,"
			 		+ "crowfundinglogisticsprice as crowfundinglogisticsprice,";
			 param2 = " iscrowdfunding = 1";
		}
		return productDAO.getActiveProduct(param1,param2,page.getFromIndex(),page.getPageSize());
	}
	public List<Map> getActiveProductByProducttypeId(String activeName, Page page, int producttypeId) throws Exception{
		if(page == null || page.getPageIndex() == null || page.getPageSize() == null){
			throw new Exception("请传入分页参数");
		}
		if(page.getPageIndex() < 0 || page.getPageSize() < 0){
			throw new Exception("请传入合法分页参数");
		}
		String param1 = "";//根据不同条件查询出不同的时间
		String param2 = "";//where 条件
		
		String sProducttypeIds = "producttypeid in (" + this.typeDAO.getProtypeIdsByParent(producttypeId) + ")";
		
		if(activeName.equals("snapup")){
			 param1 = " snapupendtime as snapupendtime, "
			 		+ "snapupprice as snapupprice, "
			 		+ "snapupcertifiedprice as snapupcertifiedprice ,"
			 		+ "snapuplogisticsprice as snapuplogisticsprice,";
			 param2 = " issnapup =  AND " + sProducttypeIds;
		}else if(activeName.equals("group")){
			 param1 = " grouponendtime as grouponendtime,"
			 		+ "grouponprice as grouponprice,"
			 		+ "grouponcertifiedprice as grouponcertifiedprice,"
			 		+ "grouponlogisticsprice as grouponlogisticsprice,";
			 param2 = " isgroupon = 1 AND " + sProducttypeIds;
		}else if(activeName.equals("presale")){
			 param1 = " crowfundingendtime as crowfundingendtime,"
			 		+ "crowfundingprice as crowfundingprice,"
			 		+ "crowfundingcertifiedprice as crowfundingcertifiedprice,"
			 		+ "crowfundinglogisticsprice as crowfundinglogisticsprice,";
			 param2 = " iscrowdfunding = 1 AND " + sProducttypeIds;
		}
		return productDAO.getActiveProduct(param1,param2,page.getFromIndex(),page.getPageSize());
	}
	
	//得新品上市产品	
	public List<Map> getNewProduct(){
		String  param = " isnew = 1";
		return productDAO.getActiveProduct(param);
	}
	public List<Map> getNewProductByProducttypeId(int producttypeId){
		//String  param = " isnew = 1 AND producttypeid = " + producttypeId;
		String  param = " isnew = 1 AND producttypeid in (" + this.typeDAO.getProtypeIdsByParent(producttypeId) + ")";
		return productDAO.getActiveProduct(param);
	}
	
	//获取热卖产品
	@SuppressWarnings("rawtypes")
	public List<Map> getHotProduct(){
		String  param = " ishot = 1";
		return productDAO.getActiveProduct(param);
	}
	@SuppressWarnings("rawtypes")
	public List<Map> getHotProductByProducttypeId(int producttypeId){
		//String  param = " ishot = 1 AND producttypeid = " + producttypeId;
		String  param = " ishot = 1 AND producttypeid in (" + this.typeDAO.getProtypeIdsByParent(producttypeId) + ")";
		return productDAO.getActiveProduct(param);
	}
	
	public NewProducttypeDAO getTypeDAO() {
		return typeDAO;
	}
	public void setTypeDAO(NewProducttypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	public NewProductDAO getProductDAO() {
		return productDAO;
	}
	public void setProductDAO(NewProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
		// for Ajax: LinkedHashMap<String, ArrayList<String>>
		public LinkedHashMap<String, ArrayList<String>> findAllProducttypesL2() {
			LinkedHashMap<String, ArrayList<String>> result = new LinkedHashMap<String, ArrayList<String>>();
			try{
				List<Producttype> lstProdTypesL1 = producttypeDAO2.findAllProducttypesL1();
				Iterator<Producttype> itPT = lstProdTypesL1.iterator();
				while(itPT.hasNext()) {
					Producttype parentPT = (Producttype)itPT.next();
					ArrayList<String> lstChildPTs = new ArrayList<String>();
					List<Producttype> lstProdTypesChildren = producttypeDAO2.findProducttypesByParentid(parentPT.getProducttypeid());
					Iterator<Producttype> itPTChildren = lstProdTypesChildren.iterator();
					while(itPTChildren.hasNext()) {
						Producttype childPT = (Producttype)itPTChildren.next();
						lstChildPTs.add(childPT.getProducttypename());
					}
					result.put(parentPT.getProducttypename(), lstChildPTs);
				}
				return result;
			}catch(RuntimeException e){
				e.printStackTrace();
				throw e;
			}
		}
		
	// for Ajax: LinkedHashMap<String, ArrayList<String>>
	public LinkedHashMap<String, LinkedHashMap<String, String>> findAllProducttypesL2New() {
		LinkedHashMap<String, LinkedHashMap<String, String>> result = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		try {
			List<Producttype> lstProdTypesL1 = producttypeDAO2
					.findAllProducttypesL1();
			Iterator<Producttype> itPT = lstProdTypesL1.iterator();
			while (itPT.hasNext()) {
				Producttype parentPT = (Producttype) itPT.next();
				LinkedHashMap<String, String> lhmChildPTs = new LinkedHashMap<String, String>();
				List<Producttype> lstProdTypesChildren = producttypeDAO2
						.findProducttypesByParentid(parentPT.getProducttypeid());
				Iterator<Producttype> itPTChildren = lstProdTypesChildren
						.iterator();
				while (itPTChildren.hasNext()) {
					Producttype childPT = (Producttype) itPTChildren.next();
					lhmChildPTs.put(childPT.getProducttypeid().toString(), childPT.getProducttypename());
				}
				result.put(parentPT.getProducttypename(), lhmChildPTs);
			}
			return result;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 根据id查找product对象
	 */
	public NewProduct findById(Integer id){
		return productDAO.findById(id);
	}
	
	public List<Map> getProductdetailByType(String producttypename) {
		// TODO Auto-generated method stub
		return productDAO.getProductdetailByType(producttypename);
	}
	
	public List<Map> getProductdetailById(Integer productid){
		return productDAO.getProductdetailById(productid);
	}
}
