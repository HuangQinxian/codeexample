package com.huangqinxian.codeexample.xml.xml_javaBean;

import com.thoughtworks.xstream.XStream;

public class JavaBeanToXML {
	public static void main(String[] args) {
		Account account = new Account();
		account.setAccountNo("622111");
		account.setAccountType("B");
		
		User user = new User();
		user.setId("001");
		user.setName("one");
		user.setAccount(account);
		
		XStream xStream = new XStream();
		xStream.alias("user", User.class);
		xStream.alias("account", Account.class);
		String xml = xStream.toXML(user);
		System.out.println(xml);
	}
}

