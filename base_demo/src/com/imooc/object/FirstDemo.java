package com.imooc.object;

/**
 * 认识包装类
 * 基本类型和包装类的转换
 * @author 君宇
 *
 */
public class FirstDemo {

	public static void main(String[] args) {
		// 定义int类型变量，值为86
		int score1 = 86; 
		        
		// 创建Integer包装类对象，表示变量score1的值
		Integer score2=new Integer(score1);
		        
		// 将Integer包装类转换为double类型
		double score3=score2.doubleValue();
		        
		// 将Integer包装类转换为float类型
		float score4=score2.floatValue();
		        
		// 将Integer包装类转换为int类型
		int score5 =score2.intValue();

		System.out.println("Integer包装类：" + score2);
		System.out.println("double类型：" + score3);
		System.out.println("float类型：" + score4);
		System.out.println("int类型：" + score5);
		
		System.out.println("------------------分割线！-------------------------");
		//包装类和基本数据类型的转换（以double为例）
		// 定义double类型变量
	    double a = 91.5;
		        
		// 手动装箱
		Double b = new Double(a);               
		// 自动装箱
		Double c = a;    
		System.out.println("装箱后的结果为：" + b + "和" + c);
		        
		// 定义一个Double包装类对象，值为8
		Double d = new Double(87.0);
		        
		// 手动拆箱
		double e = d.doubleValue();
		        
		// 自动拆箱
		double f = d ;
		        
		System.out.println("拆箱后的结果为：" + e + "和" + f);
	}

}
