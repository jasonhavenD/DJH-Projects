package cn.edu.nwsuaf.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtil {

	private static Calendar c = Calendar.getInstance();
	//获取当前时间
	public static String getDate(){
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		return f.format(c.getTime());
	}
	
	//获取当前年份
	public static String getYear(){
		Calendar c= Calendar.getInstance();
		return c.get(Calendar.YEAR)+"";
	}
	
	//获取一个年份列表
	public static List<String> getYearList(int m, int n){
		List<String> yearList = new ArrayList<String>();
		int nowYear = c.get(Calendar.YEAR);
		for(int i = nowYear-m;i < nowYear+n;i++){
			yearList.add(i+"");
		}
		return yearList;
	}
}
