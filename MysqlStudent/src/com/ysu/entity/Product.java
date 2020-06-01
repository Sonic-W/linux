package com.ysu.entity;

import com.ysu.annotation.Column;

/*
 * 商品分类测试类
 */
public class Product {
	private int id;
	@Column(name="product_category_id")
	private int productCategoryId;
	private String productName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
