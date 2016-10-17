package com.imooc.exception;

/**
 * 异常链
 * @author 君宇
 *
 */

public class ChainTest {

	/**
	 * test1():抛出“喝大了”异常
	 * test2():调用test1(),捕获了“喝大了”异常，并且包装成运行时异常，继续抛出
	 * main()方法中，调用test2（），尝试捕获test2（）方法抛出的异常
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainTest cTest = new ChainTest();
		try {
			cTest.test2();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void test1() throws DrunkException{
		throw new DrunkException("喝酒别开车");
	}
	
	public void test2(){
		try {
			test1();
		} catch (Exception e) {
			//运行时异常实例调用initCasue方法将编译异常实例引用作为参数传入，就可以将编译异常包装为运行时异常。
			RuntimeException newExc = new RuntimeException("司机一滴酒，亲人两行泪..");
			newExc.initCause(e);
			throw newExc;		
		}
	}
}
