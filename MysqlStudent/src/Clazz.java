package com.ysu.entity;

import java.io.Serializable;

/*
 * �༶��Ϣʵ��
 */
public class Clazz extends BaseEntity implements Serializable{
	private String clazzName;
	private int maxNumber;
	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
}
