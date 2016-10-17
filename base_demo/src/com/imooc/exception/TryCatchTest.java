package com.imooc.exception;


/**
 * 学习try-catch-finally
 * @author 君宇
 *
 */

public class TryCatchTest {

	public static void main(String[] args) {
		TryCatchTest tct=new TryCatchTest();
//		int result =tct.test();
//		System.out.println("test()方法执行完毕！返回值为："+result);
//	    int result2 = tct.test2();
//	    System.out.println("test2()方法执行完毕！");
	    int result3 = tct.test3();
	    System.out.println("test3()方法执行完毕！"+result3);
		
	}
	
	/**
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result+100/divider
	 * 如果,捕获异常，打印输出“抛出异常了！！！”，返回-1
	 * 否则，返回result
	 * @return
	 */
	public int test(){
		int divider =10;
		int result = 100;
		try {
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了！！！");
			return -1;
		}
		return 0;
	}
	
	/**
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result+100/divider
	 * 如果,捕获异常，打印输出“抛出异常了！！！”，返回result=999
	 * 否则，返回result
	 * finally:打印输出“这是finally!!哈哈！！”同时打印输出result的值
	 * 
	 * try { //执行的代码，其中可能有异常。一旦发现异常，则立即跳到catch执行。否则不会执行catch里面的内容 }
     * catch { //除非try里面执行代码发生了异常，否则这里的代码不会执行 }
     * finally { //不管什么情况都会执行，包括try catch 里面用了return ,可以理解为只要执行了try或者catch，就一定会执行 finally }
	 * @return
	 */
	public int test2(){
		
		int divider =10;
		int result = 100;
		try {
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了！！！");
			return result=999;
		}finally{
			System.out.println("这是finally!!哈哈！！");
			//此处的result输出的是try模块中执行的result
			System.out.println("result:"+result);
		}
	}
	
	/**
	 * divider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result+100/divider
	 * 如果,捕获异常，打印输出“抛出异常了！！！”
	 * 否则，返回result
	 * finally:打印输出“这是finally!!哈哈！！”同时打印输出result的值
	 * 最后，返回1111作为结果
	 * @return
	 */
	public int test3(){
		int divider =10;
		int result = 100;
		try {
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了！！！");

		}finally{
			System.out.println("这是finally!!哈哈！！");
			//此处的result输出的是try模块中执行的result
			System.out.println("result:"+result);
		}
		System.out.println("我是test3，我运行完了！！！");
		return 1111;
		
	}

}
