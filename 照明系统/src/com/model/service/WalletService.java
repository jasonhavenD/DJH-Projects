package com.model.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.model.dao.WalletserialDAO;
@Entity
@Service
public class WalletService {
	@ManyToOne
	@Resource
	private WalletserialDAO walletserialDAO;
	 /**
     * 获取充值流水
     * @param 
     * @return
     */
	public List getRechargeInfo(){
		return walletserialDAO.getRechargeInfo();
	}
	/**
     * 获取提现流水
     * @param 
     * @return
     */
	public List getWithdrawInfo(){
		return walletserialDAO.getWithdrawInfo();
	}
	/**
     * 获取消费流水
     * @param 
     * @return
     */
	public List getConsumeInfo(){
		return walletserialDAO.getConsumeInfo();
	}
	/**
     * 获取普通会员流水
     * @param 
     * @return
     */
	public List getOrdinaryInfo(){
		return walletserialDAO.getOrdinaryInfo();
	}
	/**
     * 获取认证代理商流水
     * @param 
     * @return
     */
	public List getAuthenticateInfo(){
		return walletserialDAO.getAuthenticateInfo();
	}
	//sun
	/**
	 * 个人体现流水
	 * @param companyid
	 * @return
	 */
	
	public List getPersonConsumeInfo(int companyid){
		//return walletserialDAO.getConsumeInfo();
		return walletserialDAO.getPersonConsumeInfo(companyid);
	}
	public List getPersonRechargeInfo(int companyid) {
		// TODO Auto-generated method stub
		return walletserialDAO.getPersonRechargeInfo(companyid);
	}
	
	/**
	 * 充值
	 * @param rechargeamount
	 * @return
	 */
	public List RechargeIn(Integer rechargeamount) {
		
			return walletserialDAO.RechargeIn(rechargeamount);
		
	}
	
	/**
	 * 体现
	 * @param withdrawamount
	 * @return
	 */
	public List Withdraw(Integer withdrawamount) {
		// TODO Auto-generated method stub
		return walletserialDAO.Withdraw(withdrawamount);
	}

}
