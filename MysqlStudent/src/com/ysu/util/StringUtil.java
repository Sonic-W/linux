package com.ysu.util;

import java.util.List;

/*
 * 字符串转换
 */
public class StringUtil {
	/*
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str))return false;
		return false;
	}
	/*将驼峰命名的字符串转化为下划线字符串
	 * 
	 */
	public static String convertToUnderline(String str) {
		if(isEmpty(str))return null;
		String ret = "";
		for(int i = 0; i < str.length();i++) {
			char charAt = str.charAt(i);
			if(Character.isUpperCase(charAt)) {
				if(i == 0) {
					ret += String.valueOf(charAt).toLowerCase();
					continue;
				}
				ret += "_" + String.valueOf(charAt).toLowerCase();
				continue;
				
			}
			ret += charAt;
		}
		return ret;
	}
	
	/*
	 * 按照指定的字符数组分割成字符串
	 */
	public static String join(List<String> list,String split) {
		String ret = "";
		/*
		 * for(Object object : list) { ret += object + split; }
		 */
		for(int i = 0;i<list.size();i++) {
			ret += list.get(i) + split;
		}
		ret = ret.substring(0,ret.lastIndexOf(split));
		return ret;
	}
}
