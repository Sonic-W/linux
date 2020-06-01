package com.ysu.page;

/*
 * 搜索字段
 */
public class SearchProperty {
	private String key;//搜索字段名，需要与数据库字段名保持一致
	private Object value;//搜索值
	private Operator operator;//操作符
	
	public SearchProperty(String key,String value,Operator operator) {
		this.key = key;
		this.value = value;
		this.operator = operator;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}
