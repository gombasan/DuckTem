package com.ducktem.web.form;


import jakarta.validation.constraints.*;

public class MemberForm {

	@NotBlank(message = "아이디를 작성해주세요")
	@Size(max = 10, message = "아이디는 10자 이내로 작성해 주세요.")
	private String userId;
	@NotBlank(message = "이름을 작성해 주세요")
	@Pattern(regexp = "^[가-힣]{2,5}$", message = "이름을 제대로 입력해주세요.")
	@Size(max = 5, message = "이름은 5자 이내로 작성해 주세요.")
	private String name;
	@NotBlank(message = "닉네임을 작성해 주세요")
	@Size(max = 5 , message = "닉네임은 5자 이내로 작성해 주세요")
	private String nickName;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Size(min= 6, max = 10, message = "비밀번호는 6~10자 이내로 작성해 주세요.")
	private String pwd;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String pwdCheck;
	@NotBlank(message = "핸드폰 번호를 입력해 주세요.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식에 맞게 입력해 주세요.")
	private String phoneNumber;
	@NotBlank(message = "이메일을 작성해 주세요.")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞추어 입력해 주세요.")
	private String eMail;
	
	
	public MemberForm(String userId, String nickName, String name, String pwd, String phoneNumber, String eMail) {
		this.userId = userId;
		this.nickName = nickName;
		this.name = name;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public String getPwdCheck() {
		return pwdCheck;
	}

	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck;
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


	@Override
	public String toString() {
		return "MemberForm{" +
				"userId='" + userId + '\'' +
				", nickName='" + nickName + '\'' +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				", pwdCheck='" + pwdCheck + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", eMail='" + eMail + '\'' +
				'}';
	}
}
