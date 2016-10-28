package com.immoc.concurrent;

/**
 * 线程的交互
 * 
 * @author 君宇
 *
 */
public class Actor extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(getName() + "登台表演" + (++count));

			if (count == 100) {
				keepRunning = false;
			}

			// 线程休眠
			if (count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(getName() + "演出结束！！！");
	}

	public static void main(String[] args) {
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		// actor.run();
		actor.start();

		/**
		 * 注意继承Runnable的类创建线程的方式 查看api可知道 Runnable 接口，只提供了run()方法。所以只实现了
		 * Runnable 接口的类并不能启动线程
		 * 当你再查看Thread的api时，有多个重载的构造函数比如这个： 
         * public Thread(Runnable target, String name)；
         * 
		 * 启动线程只能用Thread里面的start() 方法。 
		 * Thread actressThread = new Thread(newActress(),"MsRunnable"); 
		 * 可写成 
		 * Actress actress = new Actress(); 
		 * Thread actressThread = new Thread(actress, "MsRunnable"); 
		 * 此时 actreeThread调用的 start() 方法时，也就调用了 actress 中的 run() 方法. 
		 * actressThread.start();
		 */
		Thread actressThread = new Thread(new Actress(), "Ms.Runnable");
		actressThread.start();

	}

}

class Actress implements Runnable {

	@Override
	public void run() {
		// 在Runnable里面不存在getName()方法，通过Thread.currentThread()方法获得当前的线程引用，再调用其getName()方法
		System.out.println(Thread.currentThread().getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "登台表演"
					+ (++count));

			if (count == 100) {
				keepRunning = false;
			}

			// 线程休眠
			if (count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(Thread.currentThread().getName() + "演出结束！！！");
	}

}
