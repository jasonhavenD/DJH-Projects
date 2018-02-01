package com.model.newservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Cartdetail;
import com.entity.Orderdetail;
import com.entity.Orderinfo;
import com.model.newdao.NewOrderinfoDAO;
import com.newentity.NewCartdetail;
import com.newentity.NewOrderdetail;
import com.newentity.NewOrderinfo;

@Service
public class NewOrderService {
   @Resource
   private NewOrderinfoDAO newOrderinfoDAO;
   //4.html
   /**
  	 * 确认订单
  	 * @param orderinfo,cartdetaillist
  	 */
   public void saveOrderInfo(NewOrderinfo orderinfo,List<NewCartdetail> cartdetaillist){
		newOrderinfoDAO.saveOrderInfo(orderinfo,cartdetaillist);
   }
}
