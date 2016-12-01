package com.imooc.entity;

/**
 * 统计在线人数的demo
 * 用户对象
 * @author 君宇
 *
 */
public class User {

	private String sessionIdString;

	private String ipString;

	private String firstTimeString;

	public String getSessionIdString() {
		return sessionIdString;
	}

	public void setSessionIdString(String sessionIdString) {
		this.sessionIdString = sessionIdString;
	}

	public String getIpString() {
		return ipString;
	}

	public void setIpString(String ipString) {
		this.ipString = ipString;
	}

	public String getFirstTimeString() {
		return firstTimeString;
	}

	public void setFirstTimeString(String firstTimeString) {
		this.firstTimeString = firstTimeString;
	}

}
