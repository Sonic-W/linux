package com.ysu.test;

import java.util.List;

import com.ysu.dao.ClazzDao;
import com.ysu.entity.Clazz;
import com.ysu.page.Page;

public class ClazzManager {
	
	private ClazzDao clazzDao = new ClazzDao();
	
	/*
	 * ��Ӱ༶
	 */
	public boolean addClazz(Clazz student) {
		return clazzDao.add(student);
	}
	
	/*
	 * ���°༶��Ϣ
	 */
	public boolean updateClazz(Clazz student) {
		return clazzDao.update(student);
	}
	
	/*
	 * ������ѯ�༶��Ϣ
	 */
	public Clazz find(int id) {
		return clazzDao.find(id);
	}
	
	/*
	 * ��ȡ����༶��Ϣ
	 */
	public List<Clazz> findList(Page<Clazz> page){
		return clazzDao.findList(page).getContent();
	}
	
	/*
	 * ɾ��,������������
	 */
	public boolean delete(int... ids) {
		return clazzDao.delete(ids);
	}
}
