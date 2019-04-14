package com.huangqinxian.codeexample.xml.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		MyDefaultHandler myDefaultHandler = new MyDefaultHandler();
		saxParser.parse("src/main/resources/books.xml", myDefaultHandler);
		List<Book> books = myDefaultHandler.getBooks();
		System.out.println("剩余"+books.size()+"本书");
		for(Book book: books) {
			System.out.println(book);
		}
	}

}

class MyDefaultHandler extends DefaultHandler{
	Book book = null;
	String value = null;
	List<Book> books = new ArrayList<Book>();

	@Override
	public void startDocument() throws SAXException {
		System.out.println("SAX 解析开始");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("SAX 解析结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("book".equals(qName)){
			book = new Book();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("book".equals(qName)){
			books.add(book);
		}else if("name".equals(qName)) {
			book.setName(value);
		}else if("author".equals(qName)) {
			book.setAuthor(value);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		value = new String(ch,start,length);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
