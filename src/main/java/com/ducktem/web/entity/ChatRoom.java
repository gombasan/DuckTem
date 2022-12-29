package com.ducktem.web.entity;

public class ChatRoom {
    private Long id;
    private String sellerId;
    private String customerId;
    private Long productId;

    public ChatRoom() {
        this(null, null, null);
    }

    public ChatRoom(String sellerId, String customerId, Long productId) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", sellerId='" + sellerId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productId=" + productId +
                '}';
    }
}
