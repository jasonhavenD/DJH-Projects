package com.model.action;
import com.entity.*;
import com.model.service.WalletService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Action;

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
public class WalletAction extends ActionSupport {
	
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	@ManyToOne
	@Resource
	private WalletService walletService;
	
	/**
	 * 获取充值流水
	 * 无参数
	 */
	public String getRechargeInfo(){
		
		List list = null;
		list = walletService.getRechargeInfo();
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3));
		}
		hashmap.put("walletRechargeList", list);
		return Action.SUCCESS;
	}
	/**
	 * 获取个人提现流水
	 * 
	 */
	public String getPersonReachargeInfo(){
		List list = null;
		//Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		list = walletService.getPersonRechargeInfo(userinfo.getUserinfoid());
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3));
		}
		hashmap.put("PersonRechargeList", list);
		return Action.SUCCESS;
	}
	/**
     * 获取提现流水
     * @param 
     * @return
     */
	public String getWithdrawInfo(){
		List list = null;
		list = walletService.getWithdrawInfo();
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3));
		}
		hashmap.put("walletWithdrawList", list);
		return Action.SUCCESS;
	
	}
	/**
     * 获取消费流水
     * @param 
     * @return
     */
	public String getConsumeInfo(){
		List list = null;
		System.out.println("begin");
		list = walletService.getConsumeInfo();
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3));
		}
		hashmap.put("walletConsumeList", list);
		return Action.SUCCESS;
	}
	/**
	 * 获取个人消费流水
	 * @param
	 * @return
	 */
	public String getPersonConsumeInfo(){
		List list = null;
		//list = walletService.getConsumeInfo();
		Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		//int companyid = userinfo.getUserinfoid();
		list = walletService.getPersonConsumeInfo(userinfo.getUserinfoid());
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3));
		}
		hashmap.put("PersonConsumeList", list);
		return Action.SUCCESS;
	}
	/**
	 * 充值
	 * @return
	 */
	public String RechargeIn(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer rechargeamount = Integer.valueOf(request.getParameter("rechargeamount"));
		System.out.print(rechargeamount);
    	walletService.RechargeIn(rechargeamount);
    	hashmap.put("state","success");
		return Action.SUCCESS;
	}
	
	/**
	 * 提现
	 * @return
	 */
	public String Withdraw(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer withdrawamount = Integer.valueOf(request.getParameter("withdrawamount"));
		System.out.print(withdrawamount);
    	walletService.Withdraw(withdrawamount);
    	hashmap.put("state","success");
		return Action.SUCCESS;
	}
	/**
     * 获取普通会员流水
     * @param 
     * @return
     */
	public String getOrdinaryInfo(){
		List list = null;
		list=walletService.getOrdinaryInfo();
		System.out.println(list.size());
		Iterator iter = list.iterator();
		/*while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+" "+list1.get(1)+" "+list1.get(2)+" "+list1.get(3)+" "+list1.get(4)+" "+list1.get(5)+" "+list1.get(6));
		}*/
		hashmap.put("walletOrdinaryList", list);
		return Action.SUCCESS;
	}
	/**
     * 获取认证代理商流水
     * @param 
     * @return
     */
	public String getAuthenticateInfo(){
		List list = null;
		list=walletService.getAuthenticateInfo();
		System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+" "+list1.get(1)+" "+list1.get(2)+" "+list1.get(3)+" "+list1.get(4)+" "+list1.get(5)+" "+list1.get(6));
		}
		hashmap.put("walletAuthenticateList", list);
		return Action.SUCCESS;
	}
    public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
	public WalletService getWalletService() {
		return walletService;
	}
	public void setWalletService(WalletService walletService) {
		this.walletService = walletService;
	}
}
