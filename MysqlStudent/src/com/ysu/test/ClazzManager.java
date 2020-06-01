package com.ysu.test;

import java.util.List;

import com.ysu.dao.ClazzDao;
import com.ysu.entity.Clazz;
import com.ysu.page.Page;

public class ClazzManager {
	
	private ClazzDao clazzDao = new ClazzDao();
	
	/*
	 * 添加班级
	 */
	public boolean addClazz(Clazz student) {
		return clazzDao.add(student);
	}
	
	/*
	 * 更新班级信息
	 */
	public boolean updateClazz(Clazz student) {
		return clazzDao.update(student);
	}
	
	/*
	 * 单个查询班级信息
	 */
	public Clazz find(int id) {
		return clazzDao.find(id);
	}
	
	/*
	 * 获取多个班级信息
	 */
	public List<Clazz> findList(Page<Clazz> page){
		return clazzDao.findList(page).getContent();
	}
	
	/*
	 * 删除,单个或者批量
	 */
	public boolean delete(int... ids) {
		return clazzDao.delete(ids);
	}
}
