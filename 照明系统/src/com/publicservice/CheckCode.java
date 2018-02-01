package com.publicservice;

import java.util.Random;
import javax.persistence.Entity;

@Entity
public class CheckCode {
	/**
	 * 获得验证码
	 * @return
	 */
	public static String getValidateCode(int length){
		StringBuffer randCode = new StringBuffer("");
		for(int i = 0; i < length; i++){
			int tmp = (int) (Math.random()*10);
			randCode.append(tmp);
		}
		return randCode.toString();
	}
	
}
