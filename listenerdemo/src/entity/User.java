package entity;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 实现绑定和解除绑定,钝化和活化
 * @author 君宇
 *
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 绑定
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("valueBound Name:"+arg0.getName());
	}

	/**
	 * 解除绑定
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("valueUnbound Name:"+arg0.getName());
	}
	
	/**
	 * 钝化
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("sessionWillPassivate"+arg0.getSource());
	}

	/**
	 * 活化
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("sessionDidActivate"+arg0.getSource());
		
	}

	
}
