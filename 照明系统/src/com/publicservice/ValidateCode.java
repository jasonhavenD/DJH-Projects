package com.publicservice;

import javax.persistence.Entity;

@Entity
public class ValidateCode {
	private long expire;
	private String code;
	public ValidateCode(){
		
	}
	public ValidateCode(long expire, String code){
		this.expire = expire;
		this.code = code;
	}
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
