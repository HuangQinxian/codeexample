package com.huangqinxian.codeexample.xml.jDom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.huangqinxian.codeexample.xml.sax.Book;

public class JDomParser {
	
	
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(new File("src/main/resources/books.xml"));
		//获取根节点 Books
		Element rootElement = document.getRootElement();
		//获取子节点 book
		List<Element> books = rootElement.getChildren();
		List<Book> bookList = new ArrayList();
		for(Element ele : books) {
			Book book = new Book();
			
			List<Element> propertys = ele.getChildren();
			
			for(Element e : propertys) {
				if("name".equals(e.getName())) {
					book.setName(e.getValue());
				}else if("author".equals(e.getName())) {
					book.setAuthor(e.getValue());
				}else {
					System.out.println(e.getName()+"----"+e.getValue());
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
