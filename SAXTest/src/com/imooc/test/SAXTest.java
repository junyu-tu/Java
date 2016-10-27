package com.imooc.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.entity.Book;
import com.imooc.handler.SAXParserHandler;

/**
 * 通过SAX解析XML
 * @author 君宇
 *
 */
public class SAXTest {

	public static void main(String[] args) {
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();   
		try {
			 //通过factory获取SAXParser实例
			SAXParser parser = factory.newSAXParser();
			//创建SAXParserHandler处理类的一个对象，用来处理xml文件
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			System.out.println("----------共有"+handler.getBookList().size()+"本书");
//			for(Book book : handler.getBookList()){
//				System.out.println(book.getId());
//				System.out.println(book.getName());
//				System.out.println(book.getAuthor());
//				System.out.println(book.getYear());
//				System.out.println(book.getPrice());
//				System.out.println(book.getLanguage());
//				System.out.println("----finish------");
//				
//			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
