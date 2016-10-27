package com.imooc.createxml;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.VoiceStatus;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * 通过DOM解析XML与生成XML
 * @author 君宇
 *
 */

public class DOMTest {
	
	/**
	 * 对生成工厂的代码进行封装
	 * @return
	 */
	public DocumentBuilder getDocumentBuilder(){
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocumentBuilder对象
		DocumentBuilder db =null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return db;
	}

	/**
	 * 解析XML文件
	 */
	public  void xmlParser( ) {
		try {
			//.通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下,使用的是相对路径
		    Document document = getDocumentBuilder().parse("books.xml");		//异常不要过多的嵌套
		   //获取所有book节点的集合，此方法返回一个NodeList类型，即节点集合
		    NodeList bookList = document.getElementsByTagName("book");
		    //通过NodeList的getLength()方法获取bookList的长度
		    System.out.println("一共有"+bookList.getLength()+"本书");
		    //遍历book节点集合
		    for(int i=0;i<bookList.getLength();i++){
		    	System.out.println("======下面开始遍历第"+(i+1)+"本书的内容======");
		    	
		    	//以下步骤是不知道相关节点有多少个属性时进行的操作，利用循环依次去遍历每一个节点的属性
		    	//通过item(i)方法 获取一个book节点   item()方法传递的一个索引，从而获取相应的值
		    	Node book =  bookList.item(i); 
		    	//获取book节点中的所有属性，用一个map保存
		    	NamedNodeMap attrs = book.getAttributes();
		    	//获取book节点中所有属性的长度
		    	System.out.println("第"+(i+1)+"本书共有"+attrs.getLength()+"个属性");
		    	//遍历book的属性,
		    	for(int j=0;j<attrs.getLength();j++){
		    		//通过item(j)方法 获取book节点的某一个属性
		    		Node attr = attrs.item(j);
		    		//获取属性名
		    		System.out.print("属性名"+attr.getNodeName());
		    		//获取属性值
		    		System.out.println("属性值"+attr.getNodeValue());
		    	}
		    	
//		    	//前提：已经知道book节点有且只能有一个id属性
		    	//node强转为element
//		    	Element book = (Element)bookList.item(i);
//		    	//使用getAttribute("id")方法获取相应的属性值
//		    	String attrValue = book.getAttribute("id");
//		    	System.out.println("id属性的属性值为"+attrValue);
		    	
		    	//解析book节点的子节点
		    	NodeList childNodes = book.getChildNodes();
		    	//遍历childNodes获取每个节点的节点名和节点值
		    	//空白处认为是一个子节点
		    	System.out.println("第"+(i+1)+"本书共有"+childNodes.getLength()+"个子节点");
		    	for(int k =0;k<childNodes.getLength();k++){
		    		
		    		//区分出text类型的node和element类型的node
		    		//当使用if判断，可以取消空白区域的显示："#text"
		    		if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
		    			Node cn = childNodes.item(k);
			    		//获取element类型节点的节点名
			    		System.out.print("第"+(k+1)+"节点名："+cn.getNodeName()+"--");
			    		//获取element类型节点的节点值：必须访问孙节点；不然显示的结果为null,即element类型的nodeValue值
			    		System.out.println("第"+(k+1)+"节点值："+cn.getFirstChild().getNodeValue());
			    		//还有一种获得节点值的方法：getTextContent()
			    		System.out.println("第"+(k+1)+"节点值："+cn.getTextContent());
			    		/**
			    		 * 注意两种获取节点值的方法
			    		 * childNodes.item(k).getFirstChild().getNodeValue();  获取相关子节点的时候注意一定不能取到element类型的node，否则子节点的值为null
			    		 * getTextContent();  获取到相关子节点，如果相关子节点下面还有子节点，这个方法也会把其下面子节点的值输出显示出来
			    		 *
			    		 */
		    		};
		    		
		    	}
		    	System.out.println("======结束遍历第"+(i+1)+"本书的内容======");	    	
		    }
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成XML
	 */
	public void createXML(){
		DocumentBuilder db = getDocumentBuilder();
		//创建一个新的document，存放需要放在XML文件里面的数据
		Document document = db.newDocument();
		//设置XmlStandalone为true，使其不显示
		document.setXmlStandalone(true);
		
		//增加根节点
		Element bookstore = document.createElement("bookStore");
		//向bookstore根节点中添加子节点book
		Element book = document.createElement("book");
		//添加属性，参数：name,value
		book.setAttribute("id", "1");
		//将book节点添加到bookstore根节点中
		bookstore.appendChild(book);
		//将bookstore节点（已经包含了book）添加到dom树中
		document.appendChild(bookstore);
		
		//生成节点间文本
		Element name = document.createElement("name");
		//这种方式添加文本是不能成功的
//		name.setNodeValue("小王子");
		//这种方式能成功
		name.setTextContent("小王子");
		book.appendChild(name);
		
		//创建XML需要进行的操作
		//创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			//创建Transformer对象
			Transformer tf = tff.newTransformer();
			//设置XML格式：换行
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//将dom树转换成XML
			tf.transform(new DOMSource(document),new StreamResult(new File("books1.xml")));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		//创建DOMTest对象
		DOMTest test= new DOMTest();
		//调用解析方法，解析xml文件
//		test.xmlParser();
		test.createXML();
		
	
	 }

	
}
