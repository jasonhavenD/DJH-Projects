package com.model.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Producttype;
import com.model.newservice.ProducttypeService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ProducttypeAction extends ActionSupport {
	@Resource
	private ProducttypeService producttypeservice;
	private int count;
	private int id;
	private List<Producttype> plist;
	private Producttype ptype;
	private String parenttypename;
	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	public String deleteProducttype() {
		ptype = producttypeservice.getProducttypeById(id);
		producttypeservice.deleteProducttype(ptype);
		return SUCCESS;
	}

	public String findFirstProducttype() {
		plist = producttypeservice.getProducttype(1);

		hashmap.put("plist", plist);
		return SUCCESS;
	}

	public String findOneProducttype() {
		if (id == -1) {
			hashmap.put("ptype", "");
			return SUCCESS;
		}
		ptype = producttypeservice.getProducttypeById(id);
		hashmap.put("ptype", ptype.getProducttypename());
		return SUCCESS;
	}

	public String updateProductType() {
		if (!parenttypename.equals("-1")) {
			Producttype parenttype = producttypeservice
					.getProducttypeByName(parenttypename);
			ptype.setParentproducttypeid(parenttype.getProducttypeid());
			ptype.setTypecount(parenttype.getTypecount() + 1);
		} else {
			ptype.setParentproducttypeid(-1);
			ptype.setTypecount(1);
		}
		producttypeservice.updateProducttype(ptype);
		return SUCCESS;
	}

	public String findProducttype() {
		plist = producttypeservice.getProducttype(count, id);
		hashmap.put("plist", plist);
		return SUCCESS;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Producttype> getPlist() {
		return plist;
	}

	public void setPlist(List<Producttype> plist) {
		this.plist = plist;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producttype getPtype() {
		return ptype;
	}

	public void setPtype(Producttype ptype) {
		this.ptype = ptype;
	}

	public String getParenttypename() {
		return parenttypename;
	}

	public void setParenttypename(String parenttypename) {
		this.parenttypename = parenttypename;
	}

}
