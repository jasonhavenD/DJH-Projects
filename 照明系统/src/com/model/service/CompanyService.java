package com.model.service;

import javax.annotation.Resource;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;
import com.entity.Company;
import com.model.dao.CompanyDAO;
import com.model.dao.PointDAO;

@Entity
@Service
public class CompanyService {
	@ManyToOne
	@Resource
	private CompanyDAO companyDAO;
	@ManyToOne
	@Resource
	private PointDAO pointDAO;
	/**
	 * 获得添加company信息
	 * @param company
	 * @throws RuntimeException
	 */
	public void improveCompanyInfo(Company company)throws RuntimeException{
		companyDAO.save(company);
	}
	/**
	 * 查看该会员是否存在于company表
	 * @param id
	 * @return
	 */
	public List isExist(Integer id){
		return companyDAO.isExist(id);
	}
	/**
	 * 
	 * @param companyid
	 * @param managername
	 * @param managerphone
	 * @param companyname
	 * @param province
	 * @param city
	 * @param district
	 * @param detailaddress
	 * @param longitude
	 * @param latitude
	 * @param email
	 * @param fixphone
	 * @param paypassword
	 * @param state
	 */
	public void updateCompanyInfo(Company company){
		companyDAO.update(company);
	}
	/**
	 * 获得经销商详细信息
	 * @param id
	 */
	public Company findById(Integer id){
		Company company = companyDAO.findById(id);
		//System.out.println(company);
		return company;
	}
	public List findByCId(Integer id){
		return companyDAO.findByCId(id);
	}
	public void deleteDeliverty(Integer companyid){
		//System.out.println(companyid);
		companyDAO.deleteByDelivery(companyid);
	}
	public List getState(Integer id){
		return companyDAO.isExist(id);
	}
	/**
	 * 平台获得经销商信息
	 * @param state
	 * @return
	 */
	public List getAuthenticateInfo(Integer state){
		return companyDAO.findByState(state);
	}
	/**
	 * 物流中心获得经销商信息
	 * @param state
	 * @param province以省为单位
	 * @return
	 */
	public List getAuthenticateInfo2(Integer state, String province){
		return companyDAO.findByStateProvince(state, province);
	}
	//物流中心查看state>=4
	public List getAuthenticateInfo3(String province){
		return companyDAO.findYesCompany(province);
	}
	/**
	 * 平台查看物流中心
	 */
	public List checkDeliList(){
		return companyDAO.checkDelivery();
	}
	/**
	 * 认证经销商上传凭证
	 */
	public void updateIdcardpicture(String picture, int id){
		companyDAO.updateIdcardpicture(picture, id);
	}
	public void updateCompanypicture(String picture, int id){
		companyDAO.updateCompanypicture( picture,  id);
	}
	public void updateCompanylicensepicture(String picture, int id){
		companyDAO.updateCompanylicensepicture(picture, id);
	}
	/**
	 * 更改经销商的状态，即审核过程
	 */
	public void updateState(Integer companyid , Integer state)throws RuntimeException{
		companyDAO.updateState(companyid, state);
	}
	
	/**
	 * 获得经销商位置
	 * 物流中心获得
	 */
	public List getMapLogistics(String province){
		return companyDAO.getMap(province);
	}
	/**
	 * 获得经销商位置
	 * 平台中心获得
	 */
	public List getMapPlatform(){
		return companyDAO.getMap("");
	}
	
	/**
	 * 获取收货地址
	 * @return
	 */
	public List getAddress(Integer companyid){
		//System.out.println(company);
		return companyDAO.getAddress(companyid);
	}
	/**
	 * 获取积分流水
	 * @return
	 */
	public List getPoint(){
		return pointDAO.findPoint();
	}
	
	//物流中心 获取普通经销商
	public List findUserByPro(String province){
		return companyDAO.findUserByProvince(province);
	}
	//物流中心获取认证经销商
	public List findCertifiedBypro(String province){
		return companyDAO.findCetiUserByProvince(province);
	}
	//
	/**
	 * 获普通经销商流水信息
	 * 
	 */
	public List getNormalManagerWaterInfo(){
		return companyDAO.GetNormalManagerWaterInfo();
	}
	/**
	 * 获认证经销商流水信息
	 * 
	 */
	public List getCertificationManagerWaterInfo(){
		return companyDAO.GetCertificationManagerWaterInfo();
	}
	
	
}
