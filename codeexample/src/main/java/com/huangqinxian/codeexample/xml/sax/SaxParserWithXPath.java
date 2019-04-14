package com.huangqinxian.codeexample.xml.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SaxParserWithXPath {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DocumentException {
		//String bookPath = "/Books/book";
		//String bookPath = "//book";
		//String bookPath = "//book[@id='2']";
		//String bookPath = "//book[price > 60]";
		String bookPath = "//book[price > 60 and @id < 4]";
		
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read("src/main/resources/books.xml");
		List<Element> bookNodes = doc.selectNodes(bookPath);
		
		System.out.println(bookNodes.size());
		
		List<Book> bookList = new ArrayList<Book>();
		for(Element element : bookNodes) {
			Iterator elementIterator = element.elementIterator();
			Book book = new Book();
			while(elementIterator.hasNext()) {
				Element childElement = (Element) elementIterator.next();
				String name = childElement.getName();
				if("name".equals(name)) {
					book.setName(childElement.getStringValue());
				}else if("author".equals(name)) {
					book.setAuthor(childElement.getStringValue());
				}
			}
			bookList.add(book);
		}
		
		System.out.println("剩余"+bookList.size()+"本书：");
		for(Book b : bookList) {
			System.out.println(b);
		}
	}
	

}