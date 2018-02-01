package com.model.action;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.entity.Company;
import com.entity.Userinfo;
import com.model.dao.CompanyDAO;
import com.model.service.CompanyService;
import com.model.service.OrderService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.IOException;
import java.util.*;

@Entity
@Controller
@Scope("prototype")
public class CompanyAction extends ActionSupport implements ModelDriven<Company>{
	@ManyToOne
	private Company company = new Company();
	@ManyToOne
	@Resource
	private CompanyService companyService;
	@ManyToOne
	@Resource 
	private OrderService orderservice;
	private HashMap<String,Object> hashmap = new HashMap<String,Object>();
	//	传session到前台
	public String sendName(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(userinfo == null){
			hashmap.put("state", "noLogin");//该用户未登录
			return Action.SUCCESS;
		}
		String userName = userinfo.getUsername();		
		int membertype = userinfo.getMembertype();
		int companyid = userinfo.getUserinfoid();
		hashmap.put("userName", userName);
		hashmap.put("membertype", membertype);
		hashmap.put("companyid",companyid);
		return SUCCESS;
	}
	
	/**
	 * 用户填写（普通经销商）完善信息
	 * @return
	 */
	public String changePersonalInfo(){
		try{
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("uploadState", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			company.setCompanyid(userinfo.getUserinfoid());
			//System.out.println("compsnyid"+company.getCompanyid());
			company.setState(1);
			companyService.improveCompanyInfo(company);
			/*companyService.findById(company.getCompanyid());*/
			hashmap.put("uploadState", "success");
			hashmap.put("companyid", company.getCompanyid());
		}catch(RuntimeException re){
			re.printStackTrace();
			hashmap.put("uploadState","fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 该用户是否已经添加，查询是否存在于company表
	 */
	public String isExist(){
		List state;
		try {
			HttpServletRequest request = ServletActionContext.getRequest();		
			Integer companyid = Integer.valueOf(request.getParameter("companyid"));
			state = companyService.isExist(companyid);
			hashmap.put("state", state);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "error");
		}
		
		return Action.SUCCESS;
	}
	/**
	 * 用户（普通经销商）修改信息
	 * @return
	 */
	public String updatePersonal(){
		try {
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("state", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}
			HttpServletRequest request = ServletActionContext.getRequest();		
			Integer companyid = Integer.valueOf(request.getParameter("companyid"));
			String managername = request.getParameter("managername");
			String managerphone = request.getParameter("managerphone");
			String companyname = request.getParameter("companyname");
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String district = request.getParameter("district");
			String detailaddress = request.getParameter("detailaddress");
			Double longitude = Double.valueOf(request.getParameter("longitude"));
			Double latitude = Double.valueOf(request.getParameter("latitude"));
			String email = request.getParameter("email");
			String fixphone = request.getParameter("fixphone");
			String paypassword = request.getParameter("paypassword");
			Integer state = Integer.valueOf(request.getParameter("state"));
			company = companyService.findById(companyid);
			company.setManagername(managername);
			company.setManagerphone(managerphone);
			company.setCompanyname(companyname);
			company.setProvince(province);
			company.setCity(city);
			company.setDistrict(district);
			company.setDetailaddress(detailaddress);
			company.setLongitude(longitude);
			company.setLatitude(latitude);
			company.setEmail(email);
			company.setFixphone(fixphone);
			company.setPaypassword(paypassword);
			company.setState(state);
			companyService.updateCompanyInfo(company);
			//System.out.println(companyid+ managername+ managerphone+ companyname+ province+ city+ district+detailaddress+longitude+ latitude+ email+ fixphone+ paypassword);
			
			hashmap.put("state", "success");
		} catch (NumberFormatException e) {
			System.out.println(e);
			hashmap.put("state", "fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 返回会员状态
	 */
	/*public String getState(){
		//Integer companyid = Integer.valueOf(request.getParameter("companyid"));
		try {
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			List list = companyService.isExist(userinfo.getUserinfoid());
			hashmap.put("state", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "error");
		}
		
		return  Action.SUCCESS;
	}*/
	/**
	 * 删除物流中心
	 * @return
	 */
	public String deleteDelivery(){
		HttpServletRequest request = ServletActionContext.getRequest();
    
    	/*Integer companyid = Integer.valueOf(request.getParameter("companyid"));
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");*/
		
			try {
				Integer companyid = Integer.valueOf(request.getParameter("id"));
				company = companyService.findById(companyid);
				List list = companyService.isExist(companyid);
				if(list.size() == 0){//已经存在于company表  
					hashmap.put("delivery", "null");
				}else{
					//System.out.println(8888);
					companyService.deleteDeliverty(companyid);
					hashmap.put("delivery", "ok");
				}
				System.out.println(list.size());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				hashmap.put("delivery", "no");//参数异常
			}
		
		return  Action.SUCCESS;
	}
	/**
	 * 普通经销商，申请成为认证经销商
	 * @return
	 */
	public String authenticate(){
		
		
		return Action.SUCCESS;
	}
	/**
	 * 获取经销商物流中心或经销商详细信息
	 * 传递参数companyid
	 */
	public String getCompanyInfo(){
		try {
			Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			if(userinfo == null){
				hashmap.put("company", "noLogin");//该用户未登录
				return Action.SUCCESS;
			}else{
				Integer companyid = userinfo.getUserinfoid();		
				//company = companyService.findById(companyid);
				List list = companyService.findByCId(companyid);
				hashmap.put("company", list);
			}			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			hashmap.put("company", "fail");
		}
		return Action.SUCCESS;
	}
	/**
	 * 获得本地区物流中心 同于 order的方法
	 * @return
	 */
	private String getProvince(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	/*	Userinfo userinfo = new Userinfo(); 
		userinfo.setUserinfoid(1);*/
		List list = orderservice.getCompanyName(userinfo.getUserinfoid());
		Map list1 = null;
		if(list.size() > 0)
			list1 =  (Map) list.get(0);
		else
			return null;
		System.out.println((Integer) list1.get("companyid"));
		return (String) list1.get("province");
	}
	/**
     * 获取经销商列表（物流中心和平台的结果是不同的）
     * @return
     */
    public String getAuthenticateCompanyList(){
    	/**
    	 * 获取session中的该用户的信息
    	 */
    	HttpServletRequest request = ServletActionContext.getRequest();
    	Userinfo user = (Userinfo)request.getSession().getAttribute("userinfo");
    	
    		Integer identity = user.getMembertype();//用户身份
    		//System.out.println("identity:"+identity);
    		Integer state = Integer.valueOf(request.getParameter("state"));//要获取的的类型
    		System.out.println(state);
    		List list = null;
    		if(identity == 1){//为平台中心时
    			list = companyService.getAuthenticateInfo(state);
				System.out.println(list.size());
    			Iterator iter = list.iterator();
    			while(iter.hasNext()){
    				List list1 = (List) iter.next();
    				System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2));
    			}
    		}else if(identity == 2){//为物流中心时*/
    			//Company company = companyService.findById(user.getUserinfoid());
    			System.out.println("执行物流中心");
    			
    			if(state == 4){
    				//list= companyService.getAuthenticateInfo3(company.getProvince());
    				list= companyService.getAuthenticateInfo3(getProvince());
    				System.out.println(4);
    			}else{
    				list = companyService.getAuthenticateInfo2(state,getProvince());
    				System.out.println(123);
    			}
				System.out.println(list.size());
    			Iterator iter = list.iterator();
    			while(iter.hasNext()){
    				List list1 = (List) iter.next();
    				System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2));
    		}
    		}
    		hashmap.put("authenticateCompanyList", list);
    	return Action.SUCCESS;
    }
    /**
     *平台查看物流中心
     *@return
     */
    public String getDelivery(){
    	try {
			List list = companyService.checkDeliList();
			hashmap.put("deliveryList", list);
		} catch (Exception e) {
			
		}
    	return Action.SUCCESS;
    }
    /**
     * 物流中心或平台改变经销商认证状态
     * @return
     */
    public String changeState(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	try{//
    	Integer companyid = Integer.valueOf(request.getParameter("companyid"));
    	Integer state = Integer.valueOf(request.getParameter("state"));
    	if(state > 6 || state <= 1){
    		hashmap.put("state", "stateError");
    		return Action.SUCCESS;
    	}
    		companyService.updateState(companyid, state);
    		hashmap.put("state", "success");//更改状态成功
    	}catch(NumberFormatException e){
    		hashmap.put("state","formatError");//数字为空，或者传递参数不正确
    	}catch(RuntimeException re){
    		System.out.println(re);
    		hashmap.put("state", "fail");//更新失败
    	}
    	return Action.SUCCESS;
    }
    //author: wsp 
    public String setDeProVince(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	try {
    		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
			company.setCompanyid(userinfo.getUserinfoid());
			company.setState(0);
			System.out.println(company);
			companyService.improveCompanyInfo(company);
			/*companyService.findById(company.getCompanyid());*/
			hashmap.put("state","success");
		} catch (NumberFormatException e) {
			hashmap.put("state","formatError");//参数不正确
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			hashmap.put("state", "fail");//更新失败
		}
   
    	return Action.SUCCESS;
    }
    /**
     * 获得经销商地图信息
     * 物流中心只能获得本省的经销商地图信息
     * 平台可以获得所有经销商地图信息
     * @return
     */
    public String getMap(){
    	Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
    	Integer memberType = userinfo.getMembertype();
    	List list = null;
    	if(memberType == 1){//平台
    		System.out.println("平台");
    		list = companyService.getMapPlatform();
    		
    	}else if(memberType == 2){//物流中心
    		System.out.println("物流中心");
    		//Company company = companyService.findById(userinfo.getUserinfoid());
    		//list = companyService.getMapLogistics(company.getProvince());
    		list = companyService.getMapLogistics(getProvince());
    	}
    	hashmap.put("companyList", list);
    	return Action.SUCCESS;
    }
    /**
     * 获取省份(物流中心查看本地经销商)
     * @author wsp
     */
    public String province(){
    	String list = getProvince();
    	 hashmap.put("province", list);
    	return Action.SUCCESS;
    }
    /**
     * 获取收货地址
     *  company.companyid
     */
    public String getAddress(){
    	List list = null;
    	Userinfo userinfo = (Userinfo)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
    	System.out.println("问无为谓"+userinfo);
    	/* company.setCompanyid(userinfo.getUserinfoid());
    	 System.out.println("问无地方为谓"+company);*/
    	list = companyService.getAddress(userinfo.getUserinfoid());
    	System.out.println("收货地址"+list.size());
		/*Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2)+":"+list1.get(3)+":"+list1.get(4)+":"+list1.get(5));
		}*/
		hashmap.put("addressList", list);
    	return Action.SUCCESS;
    }
    
    /**
     * 获取积分流水
     * 
     */
    public String getPointInfo(){
    	List list = null;
    	list=companyService.getPoint();
    	System.out.println(list.size());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			List list1 = (List) iter.next();
			System.out.println(list1.get(0)+":"+list1.get(1)+":"+list1.get(2));
		}
		hashmap.put("pointList", list);
    	return Action.SUCCESS;
    }
  //物流中心获取 普通经销商
	public String getNormalByPro(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		//Company company = companyService.findById(userinfo.getUserinfoid());
		List list = companyService.findUserByPro(getProvince());
		//System.out.println(company.getProvince());
		hashmap.put("Normal", list);
		return Action.SUCCESS;
	}
	//物流中心获取认证经销商
	public String getCertifiedByPro(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		//Company company = companyService.findById(userinfo.getUserinfoid());
		List list = companyService.findCertifiedBypro(getProvince());
		hashmap.put("Certified", list);
		return Action.SUCCESS;
	}
	//
	public String getManagerInfo() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String str = request.getParameter("ssh");
		System.out.println(str);
		List list = null;
		/*//当点击的是普通经销商的基本信息时
		if(str.equals("#companyinfo")){			 
			list=companyService.getManagerInfo();
			System.out.println(list);
			hashmap.put("getManagerInfo", list);
		}	
		//当点击的是认证经销商的基本信息时
		else if(str.equals("#companycertifiedinfo")){
			list=companyService.getCertificationManagerInfo();
			hashmap.put("getCertificationManagerInfo", list);
		}
		//当点击的是普通经销商的流水信息时
		else */
		if(str.equals("#companyserial")){
			list=companyService.getNormalManagerWaterInfo();
			System.out.println(list);
			hashmap.put("getNormalManagerWaterInfo", list);
		}
		//当点击的是认证经销商的流水信息时
		else if(str.equals("#companycertifiedserial")){
			list=companyService.getCertificationManagerWaterInfo();
			hashmap.put("getCertificationManagerWaterInfo", list);
		}
		return Action.SUCCESS;
	}
	public Company getModel(){
		return company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
	
}
