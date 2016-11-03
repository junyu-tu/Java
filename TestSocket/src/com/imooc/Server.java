package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
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
			//2.调用accept()方法(阻塞状态)开始监听，等待客户端的连接
			System.out.println("***服务器即将启动，等待客户端的连接***");
			Socket socket = serverSocket.accept();
			//3.创建输入流，并读取客户端信息
			//字节输入流
			InputStream is = socket.getInputStream();
			//将字节流转换为字符流
			InputStreamReader  isr = new InputStreamReader(is);
			//为输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			//循环读取客户端信息
			while((info=br.readLine())!=null){
				System.out.println("我是服务器，客户端说："+info);
			}
			//关闭输入流
			socket.shutdownInput();
			
			//4.获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			//包装成打印流
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
			
			//5.关闭资源
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
