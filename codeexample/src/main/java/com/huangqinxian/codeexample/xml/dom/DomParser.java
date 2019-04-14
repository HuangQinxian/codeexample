package com.huangqinxian.codeexample.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document parse = documentBuilder.parse(new File("src\\main\\resources\\country.xml"));
		NodeList arrayOfString = parse.getElementsByTagName("ArrayOfString");
		for(int i = 0; i < arrayOfString.getLength(); i++) {
			Node item = arrayOfString.item(i);
			NodeList childNodes = item.getChildNodes();
			for(int j = 0; j < childNodes.getLength(); j++) {
				Node item2 = childNodes.item(j);
				if(item2.getNodeType() == Node.ELEMENT_NODE) {
					Node firstChild = item2.getFirstChild();
					System.out.println(firstChild.getNodeValue());
				}
			}
		}
	}
}
