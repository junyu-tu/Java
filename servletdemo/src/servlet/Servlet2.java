package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;
/**
 * 通过web配置的方式实现Servlet2
 * @author 君宇
 *
 */
public class Servlet2 extends HttpServlet {
	
	public Servlet2() {
		System.out.println("Servlet2的构造方法被调用...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet2的初始化方法被调用...");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet2的销毁方法被调用...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Servlet2的doGet方法被调用...");
		PrintWriter pWriter = resp.getWriter();
		resp.setContentType("text/html,charset=utf-8");
		pWriter.print("Servlet2");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Servlet2的doPost方法被调用...");
		PrintWriter pWriter = resp.getWriter();
		resp.setContentType("text/html,charset=utf-8");
		pWriter.print("Servlet2");
	}

	
	

	
}
