package com.ducktem.web.entity;

public class Member {
	private String userId;
	private String nickName;
	private String name;
	private String pwd;
	private String phoneNumber;
	private String eMail;
	
	
	public Member(String userId, String nickName, String name, String pwd, String phoneNumber, String eMail) {
		this.userId = userId;
		this.nickName = nickName;
		this.name = name;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}


	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}


	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}


	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
	
}
