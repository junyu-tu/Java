package com.imooc.test;

/**
 * 通过SAX生成XML
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.imooc.entity.Book;
import com.imooc.handler.SAXParserHandler;

public class SAXTest1 {

	// SAX方式解析XML
	public ArrayList<Book> parseXML() {
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParserHandler handler = null;
		try {
			// 通过factory获取SAXParser实例
			SAXParser parser = factory.newSAXParser();
			// 创建SAXParserHandler处理类的一个对象，用来处理xml文件
			handler = new SAXParserHandler();
			parser.parse("books.xml", handler);
			// System.out.println("----------共有" + handler.getBookList().size()
			// + "本书");
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
		return handler.getBookList();
	}

	// 生成XML
	public void createXML() {
		ArrayList<Book> bookList = parseXML();
		// 1.创建一个SAXTransformerFactory类的对象
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		try {
			// 2.通过SAXTransformerFactory对象创建一个TransformerHandler对象
			TransformerHandler handler = tff.newTransformerHandler();
			// 3.通过handler对象创建一个Transformer对象
			Transformer tr = handler.getTransformer();
			// 4.通过Transformer对象对生成的xml文件进行设置
			// 设置xml的编码
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// 设置xml是否换行
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.创建一个Result对象
			File f = new File("src/res/newbooks.xml");
			if (!f.exists()) {
				f.createNewFile();
			}
			// 6.创建Result对象，并且使其与handler关联
			Result result = new StreamResult(new FileOutputStream(f));
			handler.setResult(result);
			// 7.利用handler对象进行xml文件内容的编写
			// 打开document
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookstores", attr);
			for (Book book : bookList) {
				attr.clear();
				//增加节点
				attr.addAttribute("", "", "id", "", "1");
				handler.startElement("", "", "book", attr);
				//创建name节点
				if(book.getName()!=null&&!book.getName().trim().equals("")){
					attr.clear();
					handler.startElement("", "", "name", attr);
					handler.characters(book.getName().toCharArray(), 0, book
							.getName().length());
					handler.endElement("", "", "name");
				}
				//创建year节点
				if(book.getYear()!=null&&!book.getYear().trim().equals("")){
					attr.clear();
					handler.startElement("", "", "year", attr);
					handler.characters(book.getYear().toCharArray(), 0, book
							.getYear().length());
					handler.endElement("", "", "year");		
				}
				//创建author节点
				if(book.getAuthor()!=null&&!book.getAuthor().trim().equals("")){
					attr.clear();
					handler.startElement("", "", "author", attr);
					handler.characters(book.getAuthor().toCharArray(), 0, book
							.getAuthor().length());
					handler.endElement("", "", "author");	
				}
				//创建price节点
				if(book.getPrice()!=null&&!book.getPrice().trim().equals("")){
					attr.clear();
					handler.startElement("", "", "price", attr);
					handler.characters(book.getPrice().toCharArray(), 0, book
							.getPrice().length());
					handler.endElement("", "", "price");	
				}
				//创建language节点
				if(book.getLanguage()!=null&&!book.getLanguage().trim().equals("")){
					attr.clear();
					handler.startElement("", "", "language", attr);
					handler.characters(book.getLanguage().toCharArray(), 0, book
							.getLanguage().length());
					handler.endElement("", "", "language");		
				}
				handler.endElement("", "", "book");
			}
			handler.endElement("", "", "bookstores");

			// 关闭document
			handler.endDocument();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SAXTest1 test1 = new SAXTest1();
		test1.createXML();

	}

}
