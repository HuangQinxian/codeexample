package com.huangqinxian.codeexample.xml.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huangqinxian.codeexample.xml.sax.Book;

public class Dom4jParser {
	public static void main(String[] args) throws DocumentException {
		List<Book> bookList = new ArrayList<Book>();
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("src/main/resources/books.xml"));
		Element rootElement = document.getRootElement();
		Iterator elementIterator = rootElement.elementIterator();
		//得到所有的book节点
		while(elementIterator.hasNext()) {
			Book book = new Book();
			Element ele = (Element) elementIterator.next();
			Iterator propertyIterator = ele.elementIterator();
			while(propertyIterator.hasNext()) {
				Element propertyEle = (Element)propertyIterator.next();
				if("name".equals(propertyEle.getName())) {
					book.setName(propertyEle.getStringValue());
				}else if("author".equals(propertyEle.getName())) {
					book.setAuthor(propertyEle.getStringValue());
				}
			}
			bookList.add(book);
		}
		
		System.out.println("剩余"+bookList.size()+"本书");
		for(Book b : bookList) {
			System.out.println(b);
		}
	}
}

