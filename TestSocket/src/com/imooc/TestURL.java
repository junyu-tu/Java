package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 关于URL的常用方法
 * 
 * @author 君宇
 *
 */
public class TestURL {

	public static void main(String[] args) {
		// 创建一个URL实例
		try {
			URL imooc = new URL("http://www.imooc.com");
			//根据上面的url来创建一个子url,其中 ?后面表示参数，#后面表示锚点
			URL url = new URL(imooc, "/index.html?username=tom#test");
			//getProtocol() 获取此 URL 的协议名称
			System.out.println("协议：" + url.getProtocol());
			//getHost() 获取此 URL 的主机名（如果适用）
			System.out.println("主机：" + url.getHost());
			//如果未指定端口号，则使用默认的端口号(80)，此时getPort()方法返回值为-1
            System.out.println("端口："+url.getPort());
            
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("查询字符串："+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
