package com.ducktem.web.entity;

public class ProductPreview {
    private String imgName;
    private String price;
    private String name;
    private String regDate;

    public ProductPreview(String imgName, String price, String name, String regDate) {
        this.imgName = imgName;
        this.price = price;
        this.name = name;
        this.regDate = regDate;
    }

    public String getThumbNailImg() {
        return imgName;
    }

    public void setThumbNailImg(String thumbNailImg) {
        this.imgName = imgName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "ProductPreview{" +
                "imgName='" + imgName + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
