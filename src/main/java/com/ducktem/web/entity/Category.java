package com.ducktem.web.entity;

public class Category {
//    private Long id;
//    private int categoryId;
//    private String name;
    
    
    //조인결과
    private int categoryId;	// 대분류+소분류 전체 ID
    private int superCategoryId; //대분류 ID
    private String superCategoryName; //대분류 이름
    private String categoryName;//소분류 이름
	
    
    
    
    
//    
//    public Category() {
//	
//	}
    
    
//	public Category(int categoryId, int superCategoryId, String superCategoryName, String categoryName) {
//	
//		this.categoryId = categoryId;
//		this.superCategoryId = superCategoryId;
//		this.superCategoryName = superCategoryName;
//		this.categoryName = categoryName;
//	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSuperCategoryId() {
		return superCategoryId;
	}
	public void setSuperCategoryId(int superCategoryId) {
		this.superCategoryId = superCategoryId;
	}
	public String getSuperCategoryName() {
		return superCategoryName;
	}
	public void setSuperCategoryName(String superCategoryName) {
		this.superCategoryName = superCategoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

    
}
