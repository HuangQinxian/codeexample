package com.huangqinxian.codeexample.xml.xml_javaBean;

public class User {
	private String id;
	private String name;
	private Account account;
	
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
}
