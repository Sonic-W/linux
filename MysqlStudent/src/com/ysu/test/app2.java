package com.ysu.test;

import java.util.List;

import com.ysu.entity.Clazz;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/*
 * 测试类，用于测试
 */
public class app2 {
	
	public static void main(String[] args) {
		/*
		 * 添加
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Clazz clazz = new Clazz();
//		clazz.setClazzName("大一一班");
//		clazz.setMaxNumber(10);
//		log(clazzManager.addClazz(clazz));
		
		/*
		 * 修改
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Clazz clazz = new Clazz();
//		clazz.setClazzName("高三五班");
//		clazz.setMaxNumber(70);
//		clazz.setId(12);
//		log(clazzManager.updateClazz(clazz));
		
		/*
		 * 获取单个
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		log(clazzManager.find(10).getClazzName());
		
		/*
		 * 获取多个
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Page<Clazz> page = new Page<Clazz>(1,2);
//		page.getSearchProporties().add(new SearchProperty("id","6",Operator.GTE));
//		page.getSearchProporties().add(new SearchProperty("clazz_name","%高二%",Operator.LIKE));
//		page.getSearchProporties().add(new SearchProperty("max_number","30",Operator.GT));
//		List<Clazz> findList = clazzManager.findList(page);
//		log(findList.size());
		
		/*
		 * 删除
		 */
		ClazzManager clazzManager = new ClazzManager();
		log(clazzManager.delete(6,8,12));
	}
	
	public static void log(Object str) {
		System.out.println(str);
	}
}
