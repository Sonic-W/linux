package com.ysu.test;

import java.util.List;

import com.ysu.entity.Student;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/*
 * 测试类，用于测试
 */
public class app_stu {
	
	public static void main(String[] args) {
		/*
		 * 添加
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		Student student = new Student();
//		student.setAge(18);
//		student.setClazz(clazzManager.find(10));
//		student.setName("张三丰");
//		student.setSex("男");
//		int i = 0;
//		while(i++ < 20) {
//			student.setName(student.getName()+i);
//			student.setAge(student.getAge()+i);
//			log(studentManager.addStudent(student));
//		}
		
		/*
		 * 修改
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		Student student = new Student();
//		student.setAge(8);
//		student.setClazz(clazzManager.find(10));
//		student.setName("王一");
//		student.setSex("男");
//		student.setId(10);
//		log(studentManager.updateStudent(student));
		
		/*
		 * 获取单个
		 */
//		ClazzManager clazzManager = new ClazzManager();
//		StudentManager studentManager = new StudentManager();
//		log(studentManager.find(10).getName());
		/*
		 * 获取多个
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
		 * 删除
		 */
		
	}
	
	public static void log(Object str) {
		System.out.println(str);
	}
}
