package com.imooc.string;

/**
 * 一些关于String（字符串）的操作
 * string的不变性（当定义一个string后，它的值不可改变；所谓的修改，只是将它的引用修改指向了另外一个地址）
 * ==: 判断两个字符串在内存中首地址是否相同，即判断是否是同一个字符串对象
 * equals(): 比较存储在两个字符串对象中的内容是否一致
 * @author 君宇
 *
 */

public class FirstStringDemo {

	public static void main(String[] args) {
		String s1 = "imooc";
		String s2 = "imooc";
        
        //定义字符串s3，保存“I love”和s1拼接后的内容
		 String s3="I love"+s1;
		
        // 比较字符串s1和s2
		// imooc为常量字符串，多次出现时会被编译器优化，只创建一个对象
		System.out.println("s1和s2内存地址相同吗？" + (s1 == s2));
        
        //比较字符串s1和s3
		System.out.println("s1和s3内存地址相同吗？" +  (s1 ==s3));

		String s4 = "I love " + s1;
         //比较字符串s4和s3
		// s1是变量，s4在运行时才知道具体值，所以s3和s4是不同的对象
		System.out.println("s3和s4内存地址相同吗？" + (s4 == s3));
		
		//每次 new 一个字符串就是产生一个新的对象，即便两个字符串的内容相同,但是内存地址一定不同
		String s5 = new String("Hello World");
		String s6 = new String("Hello World");
		System.out.println("s5和s6内存地址相同吗？" + (s5 == s6));
		System.err.println("s5和s6内容是否相同?"+s5.equals(s6));

	}

}
