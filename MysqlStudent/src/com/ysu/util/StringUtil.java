package com.ysu.util;

import java.util.List;

/*
 * �ַ���ת��
 */
public class StringUtil {
	/*
	 * �ж��ַ����Ƿ�Ϊ��
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str))return false;
		return false;
	}
	/*���շ��������ַ���ת��Ϊ�»����ַ���
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
	 * ����ָ�����ַ�����ָ���ַ���
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
