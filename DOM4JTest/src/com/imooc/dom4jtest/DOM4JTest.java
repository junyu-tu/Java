package com.imooc.dom4jtest;

import java.io.File;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 通过DOM4J来解析XML
 * @author 君宇
 *
 */
public class DOM4JTest {

	public static void main(String[] args) {
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

}
