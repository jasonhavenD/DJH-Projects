package com.model.action;

import com.entity.Address;
import com.entity.Company;
import com.entity.Userinfo;
import com.model.service.AddressService;
import com.model.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Entity
@Controller
@Scope("prototype")
public class AddressAction extends ActionSupport implements ModelDriven<Address> {
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	@ManyToOne
	private Address addressinfo;
	@ManyToOne
	@Resource 
	private AddressService addressService;
	@ManyToOne
	@Resource 
	private CompanyService companyService;
	/**
     * 新增地址信息
     * @return
     */
	public String addAddress(){
		try{
		/*	System.out.println(" 新增地址信息");
			System.out.println("comsigneename"+addressinfo.getConsigneename()+" consigneeadress"+addressinfo.getConsigneeaddress()+" consigneephone"
					+addressinfo.getConsigneephone()+" zipcode"+addressinfo.getZipcode()+" isdefault"+addressinfo.getIsdefault());*/
			Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			//Company com=companyService.findById(userinfo.getUserinfoid());
			Company com = new Company();
			com.setCompanyid(userinfo.getUserinfoid());
			addressinfo.setCompany(com);
			addressService.saveAddress(addressinfo);
			hashmap.put("state", "success");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
     * 删除地址信息
     * @return
     */
	public String deleteAddress(){
		System.out.println("addressid"+addressinfo.getAddressid());
		Address addre=addressService.findById(addressinfo.getAddressid());
		System.out.println(addre);
		if(addre!=null)
			addressService.deleteAddress(addre);
		hashmap.put("state", "success");
		return Action.SUCCESS;
	}
	
	/**
     * 设置地址信息为默认
     * @return
     */
	public String setAddressDefault(){
		System.out.println("addressid"+addressinfo.getAddressid());
		Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		//Company com=companyService.findById(userinfo.getUserinfoid());
		Company com = new Company();
		com.setCompanyid(userinfo.getUserinfoid());
		addressinfo.setCompany(com);
		addressService.setAddressDefault(addressinfo);
		hashmap.put("state", "success");
		return Action.SUCCESS;
	}
	
	/**
     * 编辑地址信息
     * @return
     */
	public String editAddress(){
		System.out.println("addressid"+addressinfo.getAddressid()+" comsigneename"+addressinfo.getConsigneename()+" consigneeaddress"+addressinfo.getConsigneeaddress()+" consigneephone"
				+addressinfo.getConsigneephone()+" zipcode"+addressinfo.getZipcode());
		addressService.editAddress(addressinfo);
		hashmap.put("state", "success");
		return Action.SUCCESS;
	}
	public Address getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public Address getAddressinfo() {
		return addressinfo;
	}

	public void setAddressinfo(Address addressinfo) {
		this.addressinfo = addressinfo;
	}


}
