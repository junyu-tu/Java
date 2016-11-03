package com.imooc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 使用多线程实现多客户端的通信(TCP)
 * 客户端
 * @author 君宇
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.创建客户端Socket,指定服务器地址和端口
			Socket socket = new Socket("localhost",8888);
			//2.获取输出流，向服务器端发送信息
			//字节输出流
			OutputStream os = socket.getOutputStream();
			//将输出流包装为打印流
			PrintWriter pw = new PrintWriter(os);
			//pw.write("用户：admin;密码：123");
			pw.write("用户：tom;密码：456");
			pw.flush();
			//关闭输出流
			socket.shutdownOutput();
			//3.获取输入流，并读取服务器端的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			//循环读取服务器端信息
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器端说："+info);
			}	

			//4.关闭其他资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
