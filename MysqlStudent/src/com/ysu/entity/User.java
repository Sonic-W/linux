package com.ysu.entity;


import java.io.Serializable;

import com.ysu.annotation.Column;
import com.ysu.annotation.Table;

/*
 * 用户实体
 */

@Table(tableName="user")//表名
public class User implements Serializable{
	@Column(name="id",primaryKey=true,autoIncrease=true)
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="username")//列名
	private String username;
	@Column(name="password")
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
