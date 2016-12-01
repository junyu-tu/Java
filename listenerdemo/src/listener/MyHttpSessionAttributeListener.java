package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
/**
 * 属性的增加和删除的事件监听器：HttpSessionAttributeListener
 * @author 君宇
 *
 */
public class MyHttpSessionAttributeListener implements
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("HttpSession_attributeAdded:"+arg0.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("HttpSession_attributeRemoved:"+arg0.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("HttpSession_attributeReplaced:"+arg0.getName());
	}

}
