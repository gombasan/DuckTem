package com.ducktem.web.entity;

public class SubCategory {
//    private Long id;
//    private int categoryId;
//    private String name;
    
    
    //조인결과
    private int categoryId;	// 대분류+소분류 전체 ID
    private int superCategoryId; //대분류 ID
    private String superCategoryName; //대분류 이름
    private String subCategoryName;//소분류 이름

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
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
}
