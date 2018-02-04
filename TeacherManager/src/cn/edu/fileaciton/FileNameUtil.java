package cn.edu.fileaciton;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameUtil {
	/**
	 * 产生字母和数字的随机组合,长度为length
	 * 
	 * @param length
	 * @return 一个字母和数字随机组合的String型数据
	 */
	public static String getRandomNumAndChacters(int length) {
		Random random = new Random();
		String str = null;
		do {
			str = new String();
			for (int i = 0; i < length; i++) {
				boolean b = random.nextBoolean();
				if (b) {
					int choice = random.nextBoolean() ? 65 : 97;// 随机到65：大写字母
																// 97：小写字母
					str += (char) (choice + random.nextInt(26));
				} else {
					str += String.valueOf(random.nextInt(10));
				}
			}
		} while (validate(str));// 验证是否为字母和数字的组合
		return str;
	}

	/**
	 * 验证产生的随机字母数字组合是否是纯数字或者存字母
	 * 
	 * @param str
	 * @return true:纯字母或者纯数字组成；false：不是纯字母或者纯数字组成
	 */
	public static boolean validate(String str) {
		Pattern pattern = Pattern.compile("^([0-9]+)|([A-Za-z]+)$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
