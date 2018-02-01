package com.model.action;

import com.entity.*;
import com.model.service.CompanyService;
import com.model.service.FavoritesService;
import com.model.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Entity
@Controller
@Scope("prototype")
public class FavoritesAction extends ActionSupport implements ModelDriven<Favorite> {
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
    @ManyToOne
	private Favorite favorites=new Favorite();
    @ManyToOne
	@Resource 
	private FavoritesService favoritesService;
    @ManyToOne
	@Resource 
	private CompanyService companyService;
    @ManyToOne
	@Resource
    private ProductService productService;
	/**
     * 获取收藏信息
     * 
     */
	public String getCollect(){
		Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(userinfo == null){
			hashmap.put("state", "noLogin");//该用户未登录
			return Action.SUCCESS;
		}
		try {
			//Company com=companyService.findById(userinfo.getUserinfoid());
			/*if(com == null){
				hashmap.put("collectList", "none");
				return Action.SUCCESS;
			}else{*/
				/*favorites.set
				favorites.setCompany(com);*/
				List list = null;
				list=favoritesService.getCollect(userinfo.getUserinfoid());
				/*if(list.size() == 0){
					
				}*/
				/*System.out.println(list.size());
				Iterator iter = list.iterator();
				while(iter.hasNext()){
					List list1 = (List) iter.next();
					System.out.println(list1.get(0)+" "+list1.get(1)+" "+list1.get(2)+" "+list1.get(3)+" "+list1.get(4)+" "+list1.get(5)+" "+list1.get(6)+" "+list1.get(7));
				}*/
				hashmap.put("collectList", list);
			/*}*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state","fail");
		}
		return Action.SUCCESS;
	}
	/**
     * 删除收藏信息
     * 
     */
	public String deleteOne(){
		Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(userinfo == null){
			hashmap.put("state", "noLogin");//该用户未登录
			return Action.SUCCESS;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer favoriteid  = Integer.valueOf(request.getParameter("favoriteid"));
		System.out.println("删除id"+favoriteid);
		favorites=favoritesService.findById(favoriteid);
		if(favorites!=null)
			favoritesService.delete(favorites);
		hashmap.put("state", "success");
		return Action.SUCCESS;
	}
	/**
     * 新增收藏信息
     * 
     */
	
	public String addOneFavorite(){
		try {
			Timestamp date = new Timestamp(System.currentTimeMillis());
			//System.out.println("productid:"+favorites.getProduct().getProductid()+" collectiontime:"+favorites.getCollectiontime());
			HttpServletRequest request = ServletActionContext.getRequest();
			Integer productid  = Integer.valueOf(request.getParameter("productid"));
			Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			//Company com=companyService.findById(userinfo.getUserinfoid());
			/*if(com == null){
				hashmap.put("state", "none");//该用户未登录
				return Action.SUCCESS;
			}*/
			Company com = new Company();
			com.setCompanyid(userinfo.getUserinfoid());
			Boolean flag = favoritesService.isFavoExist(userinfo.getUserinfoid(),productid);//判断
			if(flag){//已存在
				hashmap.put("state", "repeat");
				System.out.println("repeat");
			}else{
				favorites.setCollectiontime(date);//1
				favorites.setCompany(com);//2
				Product product = productService.findById(productid);
				favorites.setProduct(product);//3
				favoritesService.add(favorites);
				hashmap.put("state", "success");
			}
		} catch (NumberFormatException e) {
			hashmap.put("state","fail");
		}
		return Action.SUCCESS;
	}
	public Favorite getModel() {
		// TODO Auto-generated method stub
		return favorites;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public Favorite getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorite favorites) {
		this.favorites = favorites;
	}
}
