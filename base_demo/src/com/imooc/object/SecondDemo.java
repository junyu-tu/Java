package com.imooc.object;

/**
 * 基本类型和字符串之间的转换
 * @author 君宇
 *
 */

public class SecondDemo {

	public static void main(String[] args) {
		//将基本类型转换为字符串的三种方法
		double m = 78.5;
		//1.使用包装类的toString()方法
		String str1 = Double.toString(m);
		//2.使用String类的valueOf()方法
//		String str2 = String.valueOf(m);
		//3.和空字符串相加
//		String str3 = m+""; 
		System.out.println("m 转换为String型后与整数20的求和结果为： "+(str1+20));
		
		//将字符串转换为基本类型的两种方法
		String str = "180.20";
	    //1.调用包装类的parseXxx静态方法
		Double a = Double.parseDouble(str);
		//2.调用包装类的valueOf()方法转换为基本类型的包装类，会自动拆箱
//		Double b =   Double.valueOf(str)  ;
		System.out.println("str 转换为double型后与整数20的求和结果为： "+(a+20));

	}

}
