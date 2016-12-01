package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 对象自身的创建和销毁的事件监听器
 * 用于监听请求消息对象（ServletRequest）的事件监听器
 * @author 君宇
 *
 */
public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("requestInitialized。。。。。。");
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed。。。。。。");
	}

}
