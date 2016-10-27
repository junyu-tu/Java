package com.imooc.dom4jtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 通过DOM4J来生成XML
 * @author 君宇
 *
 */
public class DOM4JTest1 {

	/**
	 * 通过DOM4J解析XML
	 */
	private void parseXML() {
		// 创建SAXReader的对象reader
		SAXReader reader = new SAXReader();
		try {
			// 通过reader对象的read方法加载books.xml文件
			Document document = reader.read(new File("src/res/books.xml"));
			// 通过document对象获取根节点bookStore
			Element bookStore = document.getRootElement();
			// 通过element对象的elementIterator()方法获取迭代器
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器，获取根节点中的信息（书籍）
			while (it.hasNext()) {
				System.out.println("===开始遍历===");
				Element book = (Element) it.next();
				// 获取book的属性名和属性值
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("属性名：" + attr.getName() + "--属性值："
							+ attr.getValue());
				}
				// 遍历book下面的子节点
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("节点名：" + bookChild.getName() + "--节点值："
							+ bookChild.getStringValue());
				}
				System.out.println("===结束遍历===");
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createXML() throws UnsupportedEncodingException, FileNotFoundException {
		//1.创建Document对象，代表整个xml文档
		Document document = DocumentHelper.createDocument();
		//2.创建根节点rss
		Element rss = document.addElement("rss");
		//3.向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		//4.生成子节点以及节点内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
//		title.setText("国内最新新闻");
		title.setText("<![CDATA[上海移动互联网产业]]>");
		//5.设置生成xml格式
		//换行
		OutputFormat format = OutputFormat.createPrettyPrint();
		//字符集
//		format.setEncoding("GBK");
		//6.生成xml文件
		File file = new File("rssnews.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
			//设置是否转义，默认值为true
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) {
		try {
			new DOM4JTest1().createXML();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
}
