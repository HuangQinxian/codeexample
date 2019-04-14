package com.huangqinxian.codeexample.xml.xml_javaBean;

import java.io.File;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class XmlToJavaBean {
	public static void main(String[] args) {
		XStream xStream = new XStream();
		xStream.alias("Users", List.class);
		xStream.alias("user", User.class);
		xStream.alias("account",Account.class);
		List fromXML = (List) xStream.fromXML(new File("src/main/resources/user.xml"));
		System.out.println(fromXML);
	}
}
