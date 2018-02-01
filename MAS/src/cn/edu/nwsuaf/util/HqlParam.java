package cn.edu.nwsuaf.util;

import java.util.Arrays;
import java.util.Map;

public class HqlParam {
	private String hql;
	private String[] param;
	private Map<Object,Object> mapParam = null;
	
public HqlParam() {
		
	}
	public HqlParam(String hql, String[] param) {
		this.hql = hql;
		this.param = param;
	}
	
	public HqlParam(String hql, Map<Object, Object> mapParam) {
		this.hql = hql;
		this.mapParam = mapParam;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public String[] getParam() {
		return param;
	}
	public void setParam(String[] param) {
		this.param = param;
	}
	public Map<Object, Object> getMapParam() {
		return mapParam;
	}
	public void setMapParam(Map<Object, Object> mapParam) {
		this.mapParam = mapParam;
	}
	@Override
	public String toString() {
		return "HqlParam [hql=" + hql + ", param=" + Arrays.toString(param)
				+ "]";
	}
	
}
