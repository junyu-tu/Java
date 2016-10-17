package com.imooc.string;

/**
 * 
 * 功能：统计指定字符串中字符 ‘a’ 出现的次数
 * 分析：可以通过循环遍历字符串中的每一个字符，判断是否是字符 a ，如果是，则累加统计出现的次数
 * @author 君宇
 *
 */

public class ThirdStringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 定义一个字符串
		String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";
		        
		// 出现次数
		int num = 0;
		        
		// 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
		for (int i=0;i<s.length();i++)                  
		{
		    // 获取每个字符，判断是否是字符a
			if (s.charAt(i)=='a'){
		          // 累加统计次数
				num++; 
			}
		}
		System.out.println("字符a出现的次数：" + num);
	}
}
