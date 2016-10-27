package com.imooc.xmlparser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 应用 DOM 方式解析 XML
 * 
 * @author 君宇
 *
 */
public class DOMTest {

	public static void main(String[] args) {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder的对象
		try {
			// 创建DocumentBuilder的对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("books.xml");

			// 获取所有book节点的集合(getElementsByTagName()方法按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList)
			NodeList bookList = document.getElementsByTagName("book");
			// ͨ通过nodelist的getLength()方法可以获取bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("=================下面开始遍历第" + (i + 1)
						+ "本书的内容=================");
				/**
				 * 当不知道xml文件存在哪些属性的时候，就进行如下操作获取xml的节点属性
				 */
				// ͨ通过nodelist的 item(i)方法获取一个book节点，nodelist的索引值从0开始(Node表示该文档树中的单个节点)
				Node book = bookList.item(i);
				// 获取book节点的所有属性集合(NamedNodeMap表示可以通过名称访问的节点的集合)
				NamedNodeMap attrs = book.getAttributes();
				// 遍历book的属性
				System.out.println("第 " + (i + 1) + "本书共有" + attrs.getLength()
						+ "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ通过item(index)方法获取book节点的某一属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值ֵ
					System.out.println("--属性值" + attr.getNodeValue());
				}
				/**
				 * 前提：已经知道book节点有且只能有1个id属性，就可通过如下操作获得节点属性
				 */
				// //将book节点进行强制类型转换，转换成Element类型
				// Element book = (Element) bookList.item(i);
				// //ͨ通过getAttribute("id")方法获取属性值ֵ
				// String attrValue = book.getAttribute("id");
				// System.out.println("id属性的属性值为" + attrValue);

				/**
				 * java程序在解析xml文档的时候，会把book标签之间所有的内容看做子节点
				 * 文字类型(指的就是空白的区域)的就看做TextNode;带标签的看做ElementNode
				 */
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "本书共有"
						+ childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分出text类型的node以及element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型节点的节点名
						System.out.print("第" + (k + 1) + "个节点的节点名："
								+ childNodes.item(k).getNodeName());
						// 获取了element类型节点的节点值（注意此处获取子节点内容的方法）
						System.out.println("--节点值是："
								+ childNodes.item(k).getFirstChild()
										.getNodeValue());
						// 获取了element类型节点的节点值，能够获取该节点下面子节点的内容，上面获取节点值的方法则不行
//						System.out.println("--节点值是："
//								+ childNodes.item(k).getTextContent());
					}
				}
				System.out.println("=================结束遍历第" + (i + 1)
						+ "本书的内容=================");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
