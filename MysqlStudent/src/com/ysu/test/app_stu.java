package com.ysu.test;

import java.util.List;

import com.ysu.entity.Student;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/*
 * �����࣬���ڲ���
 */
public class app_stu {
	
	public static void main(String[] args) {
		/*
		 * ���
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		Student student = new Student();
//		student.setAge(18);
//		student.setClazz(clazzManager.find(10));
//		student.setName("������");
//		student.setSex("��");
//		int i = 0;
//		while(i++ < 20) {
//			student.setName(student.getName()+i);
//			student.setAge(student.getAge()+i);
//			log(studentManager.addStudent(student));
//		}
		
		/*
		 * �޸�
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		Student student = new Student();
//		student.setAge(8);
//		student.setClazz(clazzManager.find(10));
//		student.setName("��һ");
//		student.setSex("��");
//		student.setId(10);
//		log(studentManager.updateStudent(student));
		
		/*
		 * ��ȡ����
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		log(studentManager.find(10).getName());
		/*
		 * ��ȡ���
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		Page<Student> page = new Page<Student>(1,10);
//		//page.getSearchProporties().add(new SearchProperty("id","6",Operator.EQ));
//	//	page.getSearchProporties().add(new SearchProperty("id","6",Operator.GTE));
//		List<Student> findList = studentManager.findList(page);
//		log(findList.size());
		
		
		ClazzManager clazzManager = new ClazzManager();
		StudentManager studentManager = new StudentManager();
		Page<Student> page = new Page<Student>(1,4);
		page = studentManager.find(page);
		List<Student> findList = studentManager.findList(page);
		log(page.getContent().size() + "---" + page.getTotal() + "---" + page.getTotalPage());
		/*
		 * ɾ��
		 */
		
	}
	
	public static void log(Object str) {
		System.out.println(str);
	}
}
