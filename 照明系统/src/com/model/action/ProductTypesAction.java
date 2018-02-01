package com.model.action;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

import com.entity.Cartdetail;
import com.entity.Producttype;
import com.model.newservice.HomeslidesService;
import com.model.newservice.NewProductService;
import com.model.newservice.ProducttypeService;
import com.newentity.Homeslides;
import com.model.newvoui.CartItem;
import com.model.newvoui.FirstProductPicture;

@Entity
@Controller
@Scope("prototype")
public class ProductTypesAction extends ActionSupport implements ModelDriven<Producttype>  {

	@ManyToOne
	private Producttype producttype = new Producttype();
	//private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	//private LinkedHashMap<String, ArrayList<String>> hashmap = new LinkedHashMap<String, ArrayList<String>>();
	private LinkedHashMap<String, LinkedHashMap<String, String>> hashmap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

	@Resource
	private NewProductService newProductService;
	
//public String getAllL2() {
//		System.out.println("in getAllL2() of ProductTypesAction");
//		LinkedHashMap<String, ArrayList<String>> lhmProdTypesL2 = newProductService.findAllProducttypesL2();
//		hashmap.put("prodTypesL2", lhmProdTypesL2);
//		System.out.println("lhmProdTypesL2: " + lhmProdTypesL2.keySet().size());
//		System.out.println("hashmap: " + hashmap.keySet().size());
//		return Action.SUCCESS;
//	}

//public String getAllL2() {
//	System.out.println("in getAllL2() of ProductTypesAction");
//	hashmap = newProductService.findAllProducttypesL2();
//	System.out.println("hashmap: " + hashmap.keySet().size());
//	return Action.SUCCESS;
//}

public String getAllL2New() {
	//System.out.println("in getAllL2() of ProductTypesAction");
	hashmap = newProductService.findAllProducttypesL2New();
	//System.out.println("hashmap: " + hashmap.keySet().size());
	return Action.SUCCESS;
}

public NewProductService getNewProductService() {
	return newProductService;
}

public void setNewProductService(NewProductService newProductService) {
	this.newProductService = newProductService;
}

//public HashMap<String, Object> getHashmap() {
//	return hashmap;
//}
//
//public void setHashmap(HashMap<String, Object> hashmap) {
//	this.hashmap = hashmap;
//}

//public LinkedHashMap<String, ArrayList<String>> getHashmap() {
//	return hashmap;
//}
//
//public void setHashmap(LinkedHashMap<String, ArrayList<String>> hashmap) {
//	this.hashmap = hashmap;
//}

public LinkedHashMap<String, LinkedHashMap<String, String>> getHashmap() {
	return hashmap;
}

public void setHashmap(LinkedHashMap<String, LinkedHashMap<String, String>> hashmap) {
	this.hashmap = hashmap;
}

public Producttype getModel() {
	// TODO Auto-generated method stub
	return producttype;
}
}
