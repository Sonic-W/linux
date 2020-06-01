package com.ysu.test;

import java.util.List;

import com.ysu.dao.ClazzDao;
import com.ysu.dao.StudentDao;
import com.ysu.entity.Student;
import com.ysu.page.Page;

public class StudentManager {
	private StudentDao studentDao = new StudentDao();
	
	private ClazzDao clazzDao = new ClazzDao();
	
	/*
	 * 添加学生
	 */
	public boolean addStudent(Student student) {
		return studentDao.add(student);
	}
	
	/*
	 * 更新学生信息
	 */
	public boolean updateStudent(Student student) {
		return studentDao.update(student);
	}
	
	/*
	 * 单个查询学生信息
	 */
	public Student find(int id) {
		return studentDao.find(id);
	}
	
	/*
	 * 获取多个学生信息
	 */
	public List<Student> findList(Page<Student> page){
		return studentDao.findList(page).getContent();
	}
	
	/*
	 * 删除,单个或者批量
	 */
	public boolean delete(int... ids) {
		return studentDao.delete(ids);
	}
	
	public Page<Student> find(Page<Student> page){
		return studentDao.findList(page);
	}
}
