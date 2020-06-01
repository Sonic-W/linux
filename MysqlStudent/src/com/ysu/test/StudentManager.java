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
	 * ���ѧ��
	 */
	public boolean addStudent(Student student) {
		return studentDao.add(student);
	}
	
	/*
	 * ����ѧ����Ϣ
	 */
	public boolean updateStudent(Student student) {
		return studentDao.update(student);
	}
	
	/*
	 * ������ѯѧ����Ϣ
	 */
	public Student find(int id) {
		return studentDao.find(id);
	}
	
	/*
	 * ��ȡ���ѧ����Ϣ
	 */
	public List<Student> findList(Page<Student> page){
		return studentDao.findList(page).getContent();
	}
	
	/*
	 * ɾ��,������������
	 */
	public boolean delete(int... ids) {
		return studentDao.delete(ids);
	}
	
	public Page<Student> find(Page<Student> page){
		return studentDao.findList(page);
	}
}
