package com.ysu.entity;

import java.io.Serializable;

import com.ysu.annotation.Column;
import com.ysu.annotation.Table;

/*
 * 学生实体
 */
@Table(tableName="student")
public class Student implements Serializable{
	@Column(name="id",primaryKey=true,autoIncrease=true)
	private int id;
	@Column(name="stuname")
	private String stuname;
	@Column(name="stusex")
	private String stusex;
	@Column(name="stuno")
	private String stuno;
	@Column(name="stumajor")
	private String stumajor;
	@Column(name="stupic")
	private String stupic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStumajor() {
		return stumajor;
	}
	public void setStumajor(String stumajor) {
		this.stumajor = stumajor;
	}
	public String getStupic() {
		return stupic;
	}
	public void setStupic(String stupic) {
		this.stupic = stupic;
	}
	
	
}
