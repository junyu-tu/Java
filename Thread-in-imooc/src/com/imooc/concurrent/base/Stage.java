package com.imooc.concurrent.base;

/**
 * 隋唐演义的大戏舞台
 * 
 * @author 君宇
 *
 */
public class Stage extends Thread {

	@Override
	public void run() {
		// 隋军
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		// 农民起义军
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

		// 使用Runnable接口创建线程
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

		// 启动线程，让军队开始作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();

		// 舞台线程休眠，大家专心观看军队厮杀
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    System.out.println("半路杀出个程咬金！！！！");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是结束战争，百姓安居乐业！！！");
		
		//停止军队作战
		//停止线程的方法
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;
		
		//停止线程建议用上面的方式，不建议也不能用stop()方法
		//stop()方法有很多问题，已经被JDK弃用
//		armyOfSuiDynasty.stop();
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//历史大戏留给关键人物
		mrCheng.start();
		
		//所有线程等待程先生完成历史使命
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

	public static void main(String[] args) {
		new Stage().start();

	}

}
