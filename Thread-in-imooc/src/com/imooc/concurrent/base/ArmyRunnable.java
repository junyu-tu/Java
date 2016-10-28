package com.imooc.concurrent.base;

/**
 * 军队线程 模拟作战双方的行为
 * 
 * @author 君宇
 *
 */
public class ArmyRunnable implements Runnable {

	// volatile保证了线程可以正确的读取其他线程写入的值
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while (keepRunning) {
			// 发动五连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "进攻对方["
						+ i + "]");
				// 当执行上面for()循环后，让出了处理器时间，下次改谁进攻不确定
				Thread.yield();
			}

		}
		System.out.println(Thread.currentThread().getName() + "结束了战斗！！！");

	}

}
