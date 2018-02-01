package com.model.newservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.newdao.ProductImgDAO;
import com.newentity.ProductImg;

@Service
public class ProductImgService {
	@Resource
	private ProductImgDAO productimgdao;
	public List<ProductImg> findByProId(int id){
		return (List<ProductImg>)productimgdao.findByProductid(id);
	}

	public void saveImg(ProductImg img) {
		productimgdao.save(img);
	}

	public void delete(Integer productid) {
		// TODO Auto-generated method stub
		productimgdao.delete(productid);
	}
}
