package com.ysu.test;

import java.util.List;

import com.ysu.entity.Clazz;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/*
 * �����࣬���ڲ���
 */
public class app2 {
	
	public static void main(String[] args) {
		/*
		 * ���
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Clazz clazz = new Clazz();
//		clazz.setClazzName("��һһ��");
//		clazz.setMaxNumber(10);
//		log(clazzManager.addClazz(clazz));
		
		/*
		 * �޸�
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Clazz clazz = new Clazz();
//		clazz.setClazzName("�������");
//		clazz.setMaxNumber(70);
//		clazz.setId(12);
//		log(clazzManager.updateClazz(clazz));
		
		/*
		 * ��ȡ����
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		log(clazzManager.find(10).getClazzName());
		
		/*
		 * ��ȡ���
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		Page<Clazz> page = new Page<Clazz>(1,2);
//		page.getSearchProporties().add(new SearchProperty("id","6",Operator.GTE));
//		page.getSearchProporties().add(new SearchProperty("clazz_name","%�߶�%",Operator.LIKE));
//		page.getSearchProporties().add(new SearchProperty("max_number","30",Operator.GT));
//		List<Clazz> findList = clazzManager.findList(page);
//		log(findList.size());
		
		/*
		 * ɾ��
		 */
		ClazzManager clazzManager = new ClazzManager();
		log(clazzManager.delete(6,8,12));
	}
	
	public static void log(Object str) {
		System.out.println(str);
	}
}
