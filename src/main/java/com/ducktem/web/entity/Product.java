package com.ducktem.web.entity;

import java.time.LocalDate;

public class Product {

    private String title;
    private String content;
    private String img;
    private String price;
    private String category;
    private Tag tag;
    private String condition;
    private String deliveryType;
    private LocalDate regDate;

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Product(String title, String content, String img, String price) {
        this.title = title;
        this.content = content;
        this.img = img;
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String shippingType) {
        this.deliveryType = shippingType;
    }

    public String getProductCategory() {
        return category;
    }

    public void setProductCategory(String category) {
        this.category = category;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", tag=" + tag +
                ", condition='" + condition + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
