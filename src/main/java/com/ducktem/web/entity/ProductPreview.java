package com.ducktem.web.entity;

public class ProductPreview {
    private String thumbNailImg;
    private String price;
    private String name;
    private String regDate;

    public ProductPreview(String thumbNailImg, String price, String name, String regDate) {
        this.thumbNailImg = thumbNailImg;
        this.price = price;
        this.name = name;
        this.regDate = regDate;
    }

    public String getThumbNailImg() {
        return thumbNailImg;
    }

    public void setThumbNailImg(String thumbNailImg) {
        this.thumbNailImg = thumbNailImg;
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
                "thumbNailImg='" + thumbNailImg + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
