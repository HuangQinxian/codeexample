package com.huangqinxian.codeexample.xml.xml_javaBean;

public class Account {
	private String accountNo;
	private String accountType;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + "]";
	}
}
