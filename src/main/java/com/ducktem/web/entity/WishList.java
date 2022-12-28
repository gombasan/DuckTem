package com.ducktem.web.entity;

public class WishList {
	private Long productId;
	private String memberId;
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public WishList(Long productId, String memberId) {
		this.productId = productId;
		this.memberId = memberId;
	}

	
	
}
