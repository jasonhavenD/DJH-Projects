package cn.edu.nwsuaf.util;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MathUtil {
	public static String getPercent(double rate){
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(1);
		nf.setRoundingMode(RoundingMode.HALF_UP); 
		String percent = nf.format(rate);
		//System.out.println(percent);
		return percent;
	}

	public static String getPercent(Integer num1, Integer num2) {
		if(num1 == 0)
			return getPercent(0);
		double rate = ((double)num1)/((double)num2);
		return getPercent(rate);
	}
}
