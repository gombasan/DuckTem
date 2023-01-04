package com.ducktem.web.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private Long id;
    private String name;
    private String price;
    private String description;
    private Date regDate;

    private String condition;
    private int categoryId;
    private String regMemberId;
    private String deliveryType;
    private int salesStatusId;
    private int hit;
    private String nTimeAgo;


    
    
    public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Long getId() {
        return id;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getRegMemberId() {
        return regMemberId;
    }

    public void setRegMemberId(String regMemberId) {
        this.regMemberId = regMemberId;
    }

    public int getSalesStatusId() {
        return salesStatusId;
    }

    public void setSalesStatusId(int salesStatusId) {
        this.salesStatusId = salesStatusId;
    }

    public String getNTimeAgo() {
        return nTimeAgo;
    }

    public void setNTimeAgo(String nTimeAgo) {
        this.nTimeAgo = nTimeAgo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", regDate=" + regDate +
                ", condition='" + condition + '\'' +
                ", categoryId=" + categoryId +
                ", regMemberId='" + regMemberId + '\'' +
                ", salesStatusId=" + salesStatusId +
                ", deliveryType='" + deliveryType + '\'' +
                ", hit=" + hit +
                '}';
    }
}
