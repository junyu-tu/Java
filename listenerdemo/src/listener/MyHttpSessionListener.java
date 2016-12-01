package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 对象自身的创建和销毁的事件监听器
 * 用于监听用户会话对象（HttpSession）的事件监听器
 * @author 君宇
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	// 用户打开浏览器第一次访问时进行创建session
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated。。。。。。");
	}

	// 关闭服务器；关闭浏览器一段时间直到session过期；不关闭浏览器，session超时；以上三种情况进行销毁
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed。。。。。。。");
	}

}
