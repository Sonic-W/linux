package com.ysu.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

import com.ysu.annotation.Column;
import com.ysu.annotation.Table;
import com.ysu.dao.ArticleDao;
import com.ysu.dao.ClazzDao;
import com.ysu.dao.ProductDao;
import com.ysu.dao.StudentDao;
import com.ysu.dao.UserDao;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;
import com.ysu.entity.*;


/*
 * 测试类，用于测试
 */
public class app {
	
	public static void main(String[] args) {
		/*
		 * 插入操作insert
		 */
//		User user = new User();
//		user.setName("柳柳a");
//		user.setPassword("123");
//		user.setBirthday(new Date(System.currentTimeMillis()));
//		UserDao userDao = new UserDao();
//		System.out.println(userDao.add(user));
//		userDao.closeConnection();
		
//		Product product = new Product();
//		product.setProductCategoryId(2);
//		product.setProductName("商品a");
//		ProductDao productDao = new ProductDao();
//		System.out.println(productDao.add(product));
//		productDao.closeConnection();
		
		
//		Article article = new Article();
//		article.setArticleName("hello");
//		ArticleDao articleDao = new ArticleDao();
//		System.out.println(articleDao.add(article));
//		articleDao.closeConnection();
		
//		try {
//			Field declaredMethod = User.class.getDeclaredField("name");
//			Column annotation = declaredMethod.getAnnotation(Column.class);
//			System.out.println(annotation.autoIncrease());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Table annotation = User.class.getAnnotation(Table.class);
//			System.out.println(annotation.tableName());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		/*
		 * 更新操作
		 */
//		User user = new User();
//		user.setName("柳柳4");
//		user.setPassword("1112");
//		user.setBirthday(new Date(System.currentTimeMillis()));
//		UserDao userDao = new UserDao();
//		user.setId(27);
//		System.out.println(userDao.update(user));
//		userDao.closeConnection();
		
//		Product product = new Product();
//		product.setProductCategoryId(2);
//		product.setProductName("商品20-");
//		product.setId(11);
//		ProductDao productDao = new ProductDao();
//		System.out.println(productDao.update(product));
//		productDao.closeConnection();
		
		/*
		 * 查询单个
		 */
//		User user = new User();
//		UserDao userDao = new UserDao();
//		User user2 = userDao.find(20);
//		System.out.println(user2.getName());
//	
//		Product product = new Product();
//		ProductDao productDao = new ProductDao();
//		Product p = productDao.find(10);
//		System.out.println(p.getProductName());
		
		
//		

//		Student student = new Student();
//		student.setStuname("lily");
//		StudentDao studentDao = new StudentDao();
//		student.setId(21);
//		System.out.println(studentDao.update(student));
		
		
		/*
		 * 多查
		 */
//		User user = new User();
//		UserDao userDao = new UserDao();
//		Page<User> page = new Page<User>(1,10);
//		//page.getSearchProporties().add(new SearchProperty("id","21",Operator.IN));
//		//page.getSearchProporties().add(new SearchProperty("user_name","柳柳1",Operator.GT));
//		//page.getSearchProporties().add(new SearchProperty("birthday",new Date(时间戳),Operator.GT));
//		//page.getSearchProporties().add(new SearchProperty("id","%21%",Operator.LIKE));
//		List<User> content = userDao.findList(page).getContent();
//		System.out.println(content.get(0).getPassword());
//		
//		Student student = new Student();
//		StudentDao studentDao = new StudentDao();
//		Page<Student> page = new Page<Student>(1,10);
//		List<Student> content = studentDao.findList(page).getContent();
//		System.out.println(content.get(0).getStuno());
		
		/*
		 * 删除
		 */
//		User user = new User();
//		UserDao userDao = new UserDao();
//		int[] ids = new int[] {31,32,23,24};
//		System.out.println(userDao.delete(ids));
//		userDao.closeConnection();
		
//		ClazzDao clazzDao = new ClazzDao();
//		Clazz clazz = new Clazz();
//		clazz.setName("软件三班");
//		System.out.println(clazzDao.add(clazz));
		
//		Page<Clazz> page = clazzDao.findList(new Page<Clazz>(1,10));
//		System.out.println(page.getContent().size());
		
//		ClazzDao clazzDao = new ClazzDao();
//		Clazz clazz = clazzDao.find(3);
//		StudentDao studentDao = new StudentDao();
//		Student student = new Student();
//		student.setName("王三");
//		student.setAge(30);
//		student.setSex("男");
//		student.setClazz(clazz);
//		System.out.println(studentDao.add(student));
		
//		StudentDao studentDao = new StudentDao();
//		Page<Student> page = studentDao.findList(new Page<Student>(1,10));
//		System.out.println(page.getContent().size());
		
//		ClazzDao clazzDao = new ClazzDao();
//		StudentDao studentDao = new StudentDao();
//		Page<Student> page = studentDao.findList(new Page<Student>(1,10));
//		List<Student> content = page.getContent();
//		for(Student s:content) {
//			System.out.println(s.getName() + "---" + s.getClazz().getName() + "---" + s.getClazz().getCreateTime());
//		}
		
	}
}
