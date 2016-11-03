package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 * @author 君宇
 *
 */
public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		//获取InetAddress实例，获取主机
		InetAddress inetAddress = InetAddress.getLocalHost();
		//可以直接输出主机，主机名+IP
		System.out.println(inetAddress);
		System.out.println("获取主机名："+inetAddress.getHostName());
		System.out.println("获取主机IP："+inetAddress.getHostAddress());
		//获取字节数组形式的IP地址
		byte[] bytes = inetAddress.getAddress();
		System.out.println("数组形式的IP地址："+Arrays.toString(bytes));
		System.out.println();
		
		//通过主机名获取InetAddress实例
		InetAddress inetAddress1 = InetAddress.getByName("Lenovo-PC");
		System.out.println("获取主机名："+inetAddress1.getHostName());
		System.out.println("获取主机IP："+inetAddress1.getHostAddress());
		System.out.println();
		
		//通过IP地址获取InetAddress实例
		InetAddress inetAddress2 = InetAddress.getByName("192.168.1.147");
		System.out.println("获取主机名："+inetAddress2.getHostName());
		System.out.println("获取主机IP："+inetAddress2.getHostAddress());
	}

}
