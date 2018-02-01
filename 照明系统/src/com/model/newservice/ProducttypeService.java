package com.model.newservice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Service;

import com.model.newdao.ProducttypeDAO2;
import com.entity.Producttype;

@Entity
@Service
public class ProducttypeService {
	@ManyToOne
	@Resource
	ProducttypeDAO2 producttypeDAO2;

//	public HashMap<String, List<Producttype>> getProducttype2Levels() {
//		System.out.println("in getProducttype2Levels()");
//		HashMap<String, List<Producttype>> hmNamesL1AndProducttypesL2 = new HashMap<String, List<Producttype>>();
//		List<Producttype> lstProducttypesL1 = producttypeDAO2.findAllProducttypesL1();
//		Iterator<Producttype> itProducttypesL1 = lstProducttypesL1.iterator();
//		while(itProducttypesL1.hasNext()) {
//			Producttype producttype = itProducttypesL1.next();
//			hmNamesL1AndProducttypesL2.put(producttype.getProducttypename(), producttypeDAO2.findProducttypesByParentid(producttype.getProducttypeid()));
//		}
//		if(hmNamesL1AndProducttypesL2 != null)
//			System.out.println(hmNamesL1AndProducttypesL2.size());
//		else
//			System.out.println("hmNamesL1AndProducttypesL2 is null");
//		return hmNamesL1AndProducttypesL2;
//	}
	
	public void deleteProducttype(Producttype type) {
		if (type == null)
			return;
		List<Producttype> list = producttypeDAO2.findByParentproducttypeid(type
				.getProducttypeid());
		producttypeDAO2.delete(type);
		if (list == null)
			return;
		else {
			for (Producttype temp : list) {
				deleteProducttype(temp);
			}
		}
		

	}

	public Producttype getProducttypeByName(String name) {
		List list = producttypeDAO2.findByProducttypename(name);
		if (list.size() > 0)
			return (Producttype) list.get(0);
		return null;
	}

	public Producttype getProducttypeById(int id) {
		Producttype temp = producttypeDAO2.findById(id);
		Producttype type = new Producttype(temp.getProducttypeid(),
				temp.getProducttypename(), temp.getParentproducttypeid(),
				temp.getProducttypepicturepath(), null, temp.getTypecount());
		return type;
	}

	public void updateProducttype(Producttype type) {
		producttypeDAO2.merge(type);
	}

	public List<Producttype> getProducttype(int count, int id) {
		Producttype parent = producttypeDAO2.findById(id);
		if (parent != null) {
			List<Producttype> list = producttypeDAO2.findProducttype(count,
					parent.getProducttypeid());
			for (int i = 0; i < list.size(); i++) {
				//System.out.println("list.get(i).getProducttypepicturepath(): " + list.get(i).getProducttypepicturepath());
				Producttype temp = new Producttype(list.get(i)
						.getProducttypeid(), list.get(i).getProducttypename(),
						list.get(i).getParentproducttypeid(), list.get(i)
								.getProducttypepicturepath(), null, list.get(i)
								.getTypecount());
				list.set(i, temp);

			}
			return list;
		}
		return null;
	}

	public List<Producttype> getProducttype(int count) {

		List<Producttype> list = producttypeDAO2
				.findProducttypeByTypecount(count);
		for (int i = 0; i < list.size(); i++) {
			Producttype temp = new Producttype(list.get(i).getProducttypeid(),
					list.get(i).getProducttypename(), list.get(i)
							.getParentproducttypeid(), list.get(i)
							.getProducttypepicturepath(), null, list.get(i)
							.getTypecount());
			list.set(i, temp);

		}
		return list;

	}
	
	public List<Producttype> getAllProducttypesL1() {
		List<Producttype> lstProducttypesL1 = producttypeDAO2.findAllProducttypesL1();
		if(lstProducttypesL1 != null)
			System.out.println(lstProducttypesL1.size());
		else
			System.out.println("lstProducttypesL1 is null");
		return lstProducttypesL1;
	}
	
	public HashMap<Integer, List<Producttype>> getAllProducttypesL2() {
		System.out.println("in getAllProducttypesL2()");
		HashMap<Integer, List<Producttype>> hmAllProducttypesL2 = new HashMap<Integer, List<Producttype>>();
		List<Producttype> lstProducttypesL1 = producttypeDAO2.findAllProducttypesL1();
		Iterator<Producttype> itProducttypesL1 = lstProducttypesL1.iterator();
		while(itProducttypesL1.hasNext()) {
			Producttype producttype = itProducttypesL1.next();
			hmAllProducttypesL2.put(producttype.getProducttypeid(), producttypeDAO2.findProducttypesByParentid(producttype.getProducttypeid()));
		}
		if(hmAllProducttypesL2 != null)
			System.out.println(hmAllProducttypesL2.size());
		else
			System.out.println("hmAllProducttypesL2 is null");
		return hmAllProducttypesL2;
	}
	
	public HashMap<Integer, List<Producttype>> getAllProducttypesL2Ajax() {
		System.out.println("in getAllProducttypesL2Ajax()");
		HashMap<Integer, List<Producttype>> hmAllProducttypesL2 = new HashMap<Integer, List<Producttype>>();
		List<Producttype> lstProducttypesL1 = producttypeDAO2.findAllProducttypesL1();
		Iterator<Producttype> itProducttypesL1 = lstProducttypesL1.iterator();
		while(itProducttypesL1.hasNext()) {
			Producttype producttype = itProducttypesL1.next();
			hmAllProducttypesL2.put(producttype.getProducttypeid(), producttypeDAO2.findProducttypesByParentid(producttype.getProducttypeid()));
		}
		if(hmAllProducttypesL2 != null)
			System.out.println(hmAllProducttypesL2.size());
		else
			System.out.println("hmAllProducttypesL2 is null");
		return hmAllProducttypesL2;
	}
}
