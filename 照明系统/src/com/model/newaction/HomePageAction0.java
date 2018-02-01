package com.model.newaction;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.entity.Company;
import com.entity.Product;
import com.entity.Producttype;
import com.entity.Userinfo;
import com.model.dao.CompanyDAO;
import com.model.newservice.HomeslidesService;
import com.model.newservice.ProducttypeService;
import com.model.service.CompanyService;
import com.model.service.OrderService;
import com.model.service.ProductService;
import com.newentity.Homeslides;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.IOException;
import java.util.*;

@Entity
@Controller
@Scope("prototype")
public class HomePageAction0 extends ActionSupport {
	@ManyToOne
	private List<Homeslides> lstHomeslides;
	//一级产品类别的Producttype
	private List<Producttype> lstProducttypesL1;
	//Integer为一级产品类别的Id，List<Producttype>中存放该一级产品类别所对应的二级产品类别Producttype
	private HashMap<Integer, List<Producttype>> hmIdL1AndProducttypesL2;
	
	
	@Resource
	private HomeslidesService homeslidesService;
	@Resource
	private ProducttypeService producttypeService;

	public String retreiveHomePageData() {
		//首页产品类别（第一层）
		lstProducttypesL1 = producttypeService.getAllProducttypesL1();
		//首页产品类别（第二层）
		hmIdL1AndProducttypesL2 = producttypeService.getAllProducttypesL2();
		//首页幻灯片图片
		lstHomeslides = homeslidesService.getHomeslides();
		return Action.SUCCESS;
	}

	public String retreiveHomeslides() {
		// 首页幻灯片图片
		lstHomeslides = homeslidesService.getHomeslides();
		return Action.SUCCESS;
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
}
