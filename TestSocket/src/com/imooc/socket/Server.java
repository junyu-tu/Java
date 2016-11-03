package com.imooc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用多线程实现多客户端的通信(TCP)
 * 服务器端
 * @author 君宇
 *
 */
public class Server {
	public static void main(String[] args){
		try {
			//1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			//端口尽量用1023以后的端口
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket =null;
			//记录客户端的数量
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的连接***");
			//循环监听等待客户端的连接
			while(true){
				//调用accept()方法(阻塞状态)开始监听，等待客户端的连接
				socket = serverSocket.accept();
				//创建一个新的线程
				ServerThread serverThread = new ServerThread(socket);
				//启动线程
				serverThread.start();
				count++;
				System.out.println("客户端的数量："+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
