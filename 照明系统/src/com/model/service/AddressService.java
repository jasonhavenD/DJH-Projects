package com.model.service;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.model.dao.AddressDAO;
@Entity
@Service
public class AddressService {
	@ManyToOne
	@Resource
	private AddressDAO addressDAO;
	/**
	 * 新增收货地址
	 */
	public void saveAddress(Address address){
		addressDAO.save(address);
	}
	/**
	 * 查询地址
	 */
	public Address findById(int id){
		return addressDAO.findById(id);
	}
	/**
	 * 新增收货地址
	 */
	public void deleteAddress(Address address){
		addressDAO.delete(address);
	}
	/**
	 * 设置地址信息为默认
	 */
	public void setAddressDefault(Address address){
		addressDAO.updateisdefault(address.getAddressid(),address.getCompany().getCompanyid());
	}
	/**
	 * 编辑地址信息
	 */
	public void editAddress(Address address){
		addressDAO.editAddress(address.getAddressid(),address.getConsigneename(),address.getConsigneeaddress(),address.getConsigneephone(),address.getZipcode());
	}

}
