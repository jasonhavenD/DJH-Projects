package com.publicservice;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Entity;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Company;
import com.entity.Orderinfo;
import com.entity.Producttype;
import com.entity.Userinfo;
import com.model.action.*;
import com.model.newservice.NewInformationService;
import com.model.newservice.NewProductService;
import com.newentity.NewInformation;
import com.publicentity.Page;

@Entity
public class Test {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@org.junit.Test
	public void test(){
		System.out.println(CheckCode.getValidateCode(6));
	    System.out.println(Integer.valueOf(""));
	}
//	@org.junit.Test
//    public void testValidateCode(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		OrderAction test = (OrderAction) act.getBean("orderAction");
//		test.getPendPayForClient();
//    }
//	@org.junit.Test
//	public void testValidateCodeEmail(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		IdentifyingCodeAction0 test = (IdentifyingCodeAction0) act.getBean("identifyingCodeAction");
//		test.getCodeByEmail();
//	}
//	@org.junit.Test
//	public void testLoginValidate(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		UserAction test = act.getBean("userAction",UserAction.class);
//		Userinfo user = new Userinfo();
//		/*user.setEmail("740842107@qq.com");
//		user.setPassword("123456");
//		test.setUserinfo(user);*/
//		test.login();
//	}
//	@org.junit.Test
//	public void testTime(){
//		Date date = new Date(System.currentTimeMillis());
//		
//		System.out.println(date.getMinutes()+":"+date.toString());
//		Time time0 = new Time(System.currentTimeMillis());
//		System.out.println(time0);
//		Timestamp time = new Timestamp(System.currentTimeMillis());
//		System.out.println(":"+time);
//		
//		java.util.Date utildate = new java.util.Date();
//		System.out.println(utildate.toString());;
//	}
//	@org.junit.Test
//	public void testUserAction(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		UserAction test = (UserAction) act.getBean("userAction");
//		/*Company company = new Company();
//		company.setPaypassword("134577");
//		company.setManagername("fanxiaoyuan");
//		company.setManagerphone("111111111111111");
//		company.setCompanyname("京东");
//		company.setProvince("河南");
//		company.setCity("郑州");
//		company.setDistrict("禹州");
//		company.setDetailaddress("河南省禹州市张得乡");
//		company.setLongitude(1234.5);
//		company.setLatitude(234.5);
//		company.setEmail("heihei");
//		company.setFixphone("11111111111");
//		company.setCompanyid(1);
//		test.setCompany(company);
//		test.changePersonalInfo();*/
//		test.findbyid("123dsfs@qq.com");
//	}
//	@org.junit.Test
//	public void testCompanyAction(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		CompanyAction test = (CompanyAction)act.getBean("companyAction");
//		//test.getAuthenticateCompanyList();
////		test.changeState();
//		test.deleteDelivery();
//	}
//	public void testAuthenticateImgAction(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		AuthenticateImgAction test = (AuthenticateImgAction)act.getBean("authenticateImgAction");
//		test.idcardpictureUpload();
//	}
//	@org.junit.Test
//	public void testNullException(){
//		Integer.valueOf(null);
//	}
//	@org.junit.Test
//	public void testGetOrdertDetail(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		OrderAction test = (OrderAction)act.getBean("orderAction");
//		/*test.getOrderdetailByOrderid();*/
//		/*test.cancelOneOrder();*/
//		/*test.getPendPay();*/
//		/*test.getPendComment();*/
//		/*test.affirmTakeDelivery();*/
//		Orderinfo userinfo = new Orderinfo();
//		userinfo.setOrderid(1);
//		userinfo.setDeliveryid("124ddd555");
//		userinfo.setDeliverycompany("顺丰快递");
//		test.setOrderinfo(userinfo);
//		test.deliver();
//	}
//	@org.junit.Test
//	public void TestProduct(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		ProductAction0 test = (ProductAction0)act.getBean("productAction",ProductAction0.class);
//		test.getLogInven();
//		/*test.getgroupon();*/
//	}
	
//	@org.junit.Test
//	public void TestNewInformationService(){
//		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		NewInformationService test = (NewInformationService)act.getBean("newInformationService", NewInformationService.class);
//		Page page = new Page(1, 12);
//		try {
//			List<NewInformation>list = test.getInfoListByType(1, page);
//			System.out.println("list: " + list.size());
//			NewInformation newinfo = test.getInfoDetailById(1);
//			System.out.println("newinfo: " + newinfo.getInformationtitle());
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		/*test.getgroupon();*/
//	}
	
	@org.junit.Test
	public void TestNewProductService(){
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		NewProductService test = (NewProductService)act.getBean("newProductService", NewProductService.class);
		try {
			LinkedHashMap<String, ArrayList<String>> result = test.findAllProducttypesL2();
			Iterator<String> itPT = result.keySet().iterator();
			while(itPT.hasNext()) {
				String parentPT = (String)itPT.next();
				System.out.println("parentPT: " + parentPT);
				ArrayList<String> lstChildPTs = result.get(parentPT);
				Iterator<String> itPT2 = lstChildPTs.iterator();
				while(itPT2.hasNext()) {
					String childPT = (String)itPT2.next();
					System.out.println("\t\tchildPT: " + childPT);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		/*test.getgroupon();*/
	}
}
