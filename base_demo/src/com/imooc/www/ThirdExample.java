package com.imooc.www;

import java.util.Arrays;

/**
 * 编写一个 JAVA 程序，实现输出考试成绩的前三名
 * 要求：
 * 1、 考试成绩已保存在数组 scores 中，数组元素依次为 89 , -23 , 64 , 91 , 119 , 52 , 73
 * 2、 要求通过自定义方法来实现成绩排名并输出操作，将成绩数组作为参数传入
 * 3、 要求判断成绩的有效性（ 0—100 ），如果成绩无效，则忽略此成
 * 
 * @author 君宇
 *
 */

public class ThirdExample {
	
	public static void main(String[] args) {
        int scores[]={89,-23,64,91,119,52,73};
        ThirdExample hello=new ThirdExample();
        hello.sort(scores);     
    }

    //定义方法完成成绩排序并输出前三名的功能
    public void sort(int scores[])
    {
        int n=0;//判断前三名的值是否取满
        Arrays.sort(scores);
        for(int i=scores.length-1;i>=0;i--)
        {
        if(scores[i]>=0&&scores[i]<=100&n<3)
          {
              System.out.println(scores[i]);
              n++;
          }
         else
             continue;
        }  
    }

}
