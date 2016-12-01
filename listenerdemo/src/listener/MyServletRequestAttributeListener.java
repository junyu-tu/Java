package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
/**
 * 属性的增加和删除的事件监听器：ServletRequestAttributeListener
 * @author 君宇
 *
 */
public class MyServletRequestAttributeListener implements
		ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest_attributeAdded:"+arg0.getName());

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest_attributeRemoved:"+arg0.getName());

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest_attributeReplaced:"+arg0.getName());

	}

}
