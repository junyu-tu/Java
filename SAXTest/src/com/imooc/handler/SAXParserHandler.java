package com.imooc.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}
	
	/**
	 * 用来遍历xml文件的开始标签，解析xml元素  (解析每个节点的开始)
	 * 每走到一个开始标签就要调用该方法
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 调用父类的startElement方法
		super.startElement(uri, localName, qName, attributes);
		
		//前提：知道有book节点
		//开始解析book元素的属性
		if(qName.equals("book")){
			
			book= new Book();
			bookIndex++;
			System.out.println("*****开始遍历第"+bookIndex+"本书的内容*****");
			
//			//已知book元素下属性的名称 ，根据属性名称获取属性值
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值是"+value);
			
			//不知道book元素下属性的名称以及个数，如何获取属性名以及属性值
			int num = attributes.getLength();
			for(int i =0;i<num;i++){
				System.out.print("book元素的第"+(i+1)+"个属性名是"+attributes.getQName(i));
				System.out.println("--属性值是"+attributes.getValue(i));
				//当有book对象的时候，对book的id属性进行设置
				if(attributes.getQName(i).equals("id")){
					book.setId(attributes.getValue(i));
				}
			}
		}else if(!qName.equals("book")&&!qName.equals("bookstore")){
			//获取节点名
			System.out.print("节点名是："+qName);
		}
		
		//不知道存在什么属性，那就是一步步进行遍历吗？（问题待解决）
			
	}
	
	@Override
	//重写方法获取节点值
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value =  new String(ch,  start, length);
		//String里面的trim()方法： 返回字符串的副本，忽略前导空白和尾部空白。
		if(!value.trim().equals("")){
			System.out.println("节点值是："+value);	
		}
	}
	
	
	/**
	 * 用来遍历xml文件的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 调用父类的endElement方法
		super.endElement(uri, localName, qName);
		//判断一本书是否遍历结束
		if(qName.equals("book")){
			bookList.add(book);
			book =null;
			System.out.println("*****结束遍历第"+bookIndex+"本书的内容*****");
		}else if(qName.equals("name")){
			book.setName(value); 
		}else if(qName.equals("author")){
			book.setAuthor(value);
		}else if(qName.equals("year")){
			book.setYear(value);
		}else if(qName.equals("price")){
			book.setPrice(value);
		}else if(qName.equals("language")){
			book.setLanguage(value);
		}
		
	}
	
   

}
