package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
/**
 * 属性的增加和删除的事件监听器：ServletContextAttributeListener
 * @author 君宇
 *
 */
public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext_attributeAdded:"+arg0.getName());

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext_attributeRemoved:"+arg0.getName());

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContext_attributeReplaced:"+arg0.getName());

	}

}
