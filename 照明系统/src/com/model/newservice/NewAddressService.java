package com.model.newservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.newdao.NewAddressDAO;
import com.newentity.NewAddress;

@Service
public class NewAddressService {
    @Resource
	private NewAddressDAO newAddressDAO;
    
    //4.html
    /**
   	 * 根据用户id获取配送地址
   	 * @param userinfoid
   	 * @return
   	 */
    public List<NewAddress> getAddressByUserId(Integer userinfoid){
    	return newAddressDAO.getAddressByUserId(userinfoid);
    };
}
