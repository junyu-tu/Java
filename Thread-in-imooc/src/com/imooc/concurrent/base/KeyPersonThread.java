package com.imooc.concurrent.base;

/**
 * 关键人物 程咬金
 * @author 君宇
 *
 */
public class KeyPersonThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"开始了战斗！");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"左突右杀，攻击隋军！");
		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}
	
	

}
