package com.ducktem.web.entity;

// 왜 생성자 주입이 아니고 setter 주입인가요?
// toString 만들어주면 디버그 할때 편리할 것 같아요
public class Category {

	private Long id;
	private String name;
	private String regDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
