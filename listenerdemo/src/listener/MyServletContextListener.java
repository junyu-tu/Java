package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 对象自身的创建和销毁的事件监听器
 * 用于监听应用程序环境对象（ServletContext）的事件监听器
 * @author 君宇
 *
 */
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//获取当前的ServletContext对象的初始化参数
		String initParam = arg0.getServletContext().getInitParameter("initParam");
		System.out.println("contextInitialized。。。:initParam="+initParam);

	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed。。。");

	}

}
