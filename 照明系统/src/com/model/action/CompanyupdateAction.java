package com.model.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Company;
import com.model.dao.CompanyDAO;

@Entity
public class CompanyupdateAction {//用户的查 改
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@Autowired
	private CompanyDAO companysql;
	private List<Map> comlist;
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private String managername;
	private String managerphone;
	private String idcardpicture;
	private String companylicensepicture;
	private String companypicture;
	private Double longitude;
	private Double latitude;
	private String province;
	private String city;
	private String district;
	private String detaileaddress;
	private String email;
	private String fixphone;
	private Timestamp birthday;

	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyDAO getCompanysql() {
		return companysql;
	}

	public void setCompanysql(CompanyDAO companysql) {
		this.companysql = companysql;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerphone() {
		return managerphone;
	}

	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}

	public String getIdcardpicture() {
		return idcardpicture;
	}

	public void setIdcardpicture(String idcardpicture) {
		this.idcardpicture = idcardpicture;
	}

	public String getCompanylicensepicture() {
		return companylicensepicture;
	}

	public void setCompanylicensepicture(String companylicensepicture) {
		this.companylicensepicture = companylicensepicture;
	}

	public String getCompanypicture() {
		return companypicture;
	}

	public void setCompanypicture(String companypicture) {
		this.companypicture = companypicture;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDetaileaddress() {
		return detaileaddress;
	}

	public void setDetaileaddress(String detaileaddress) {
		this.detaileaddress = detaileaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFixphone() {
		return fixphone;
	}

	public void setFixphone(String fixphone) {
		this.fixphone = fixphone;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public List<Map> getComlist() {
		return comlist;
	}

	/*public void setComlist(List<Company> comlist) {
		this.comlist = comlist;
	}*/

	/* 从数据库中读出company的对象链表 */
	public String ShowCompanys() {
		comlist = companysql.findAll();
		return "success";
	}

	public String UpdateCompany() {
		try {
			Company temp = companysql.findById(id);
			Exception e = null;
			if (birthday != null)
				temp.setBirthday(birthday);
			else
				throw e;
			if (city != null)
				temp.setCity(city);
			else
				throw e;
			if (companylicensepicture != null)
				temp.setCompanylicensepicture(companylicensepicture);
			else
				throw e;
			if (companyname != null)
				temp.setCompanyname(companyname);
			else
				throw e;
			if (companypicture != null)
				temp.setCompanypicture(companypicture);
			else
				throw e;
			if (district != null)
				temp.setDistrict(district);
			else
				throw e;
			if (detaileaddress != null)
				temp.setDetailaddress(detaileaddress);
			else
				throw e;
			if (email != null) {
				Pattern regex = Pattern
						.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
				Matcher matcher = regex.matcher(email);
				if (matcher.matches())
					temp.setEmail(email);
				else
					throw e;
			}// 验证邮箱格式是否合法
			else
				throw e;
			if (fixphone != null) {
				Pattern regex = Pattern
						.compile("^(\\(\\d{3:4}\\)|\\d{3:4}-)?\\d{7:8}$");
				Matcher matcher = regex.matcher(fixphone);
				if (matcher.matches())
					temp.setEmail(fixphone);
				else
					throw e;
			}// 验证手机格式是否合法
			else
				throw e;
			if (idcardpicture != null) {
				Pattern regex = Pattern.compile("^\\d{15}|\\d{}18$");
				Matcher matcher = regex.matcher(idcardpicture);
				if (matcher.matches())
					temp.setIdcardpicture(idcardpicture);
				else
					throw e;
			} // 验证身份证格式是否合法
			else
				throw e;
			if (latitude != null)
				temp.setLatitude(latitude);
			else
				throw e;
			if (longitude != null)
				temp.setLongitude(longitude);
			else
				throw e;
			if (managername != null)
				temp.setManagername(managername);
			else
				throw e;
			if (managerphone != null) {
				Pattern regex = Pattern
						.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
				Matcher matcher = regex.matcher(managerphone);
				if (matcher.matches())
					temp.setEmail(managerphone);
				else
					throw e;
			}// 验证手机格式是否合法
			else
				throw e;
			if (province != null)
				temp.setProvince(province);
			else
				throw e;
			companysql.merge(temp);
			comlist = companysql.findAll();
			hashmap.put("state", "success");
		} catch (Exception e) {
			hashmap.put("state", "updatefail");
		}
		return "success";
	}

}
