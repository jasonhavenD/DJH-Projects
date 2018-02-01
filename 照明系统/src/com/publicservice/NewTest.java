package com.publicservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.action.OrderAction;
import com.model.newservice.NewProductService0;

import java.util.*;

import com.entity.Address;
import com.entity.Userinfo;
import com.model.newservice.NewAddressService;
import com.model.newservice.NewCartdetailService;
import com.model.newservice.NewOrderService;
import com.model.newservice.NewProductService;
import com.newentity.NewAddress;
import com.newentity.NewCartdetail;
import com.newentity.NewOrderinfo;
import com.newentity.NewUserinfo;
import com.publicentity.Page;

public class NewTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	// 活动测试
	@Test
	public void testActiveProduct() {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		NewProductService test1 = (NewProductService) act
				.getBean("newProductService");
		List<Map> list = test1.getProtypePicture();
		
		NewOrderService test2 = (NewOrderService) act
				.getBean("newProductService");
		for (Map map : list) {
			System.out.println(map);	
		}
		
		NewOrderinfo orderinfo = new NewOrderinfo();
		orderinfo.setComments("你好");
		orderinfo.setLastprice(12.0);
		List<NewCartdetail> cartdetaillist = new ArrayList<NewCartdetail>();
		NewCartdetail newCartdetail1 = new NewCartdetail();
		newCartdetail1.setCartdetailid(12);
		cartdetaillist.add(newCartdetail1);
		test2.saveOrderInfo(orderinfo, cartdetaillist);

		// list = test.getActiveProduct("presale");
		// for(Map map:list){
		// System.out.println(map);
		// }

		// test.getHotProduct();
	}
}
