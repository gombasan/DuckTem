package com.ducktem.web.entity;

public class ProductTag {
	
	 private Long id;
	 private String name;
	 private Long productId;
	 private byte ban;
	 
	 
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Long getProductId() {
		return productId;
	}
	public byte getBan() {
		return ban;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setBan(byte ban) {
		this.ban = ban;
	}
	 
	 

}
