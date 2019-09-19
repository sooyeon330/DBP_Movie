package com.movie.VO;

public class CustomerVO {
	String id;
	String name;
	String pw;
	String tel;
	String email;
	
	public CustomerVO() {
		super();
	}
	public CustomerVO(String id, String name, String pw, String tel, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
