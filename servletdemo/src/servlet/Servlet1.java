package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过注解的方式实现Servlet1
 */
@WebServlet("/servlet/Servlet1")
public class Servlet1 extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        System.out.println("Servlet1构造方法被执行。。。");
    }

	/**
	 * 初始化方法只会被执行一次
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet1初始化方法被执行。。。");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Servlet1销毁方法被执行。。。");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet1的doGet方法被执行。。。");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html,charset=utf-8");
		pw.print("Servlet1");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet1的doPost方法被执行。。。");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html,charset=utf-8");
		pw.print("Servlet1");
	}

}
