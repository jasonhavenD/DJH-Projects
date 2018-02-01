package com.model.newservice;

import java.util.List;
import javax.annotation.Resource;

import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.model.newdao.HomeslidesDAO;
import com.newentity.Homeslides;

@Service
public class HomeslidesService {
	@Resource
	HomeslidesDAO homeslidesDAO;

	public List<Homeslides> getHomeslides() {
		System.out.println("in getHomeslides()");
		List<Homeslides> lstHomeslides = homeslidesDAO.findAllOrderBySeq();
		if(lstHomeslides != null)
			System.out.println(lstHomeslides.size());
		else
			System.out.println("lstHomeslides is null");
		return lstHomeslides;
	}
}
