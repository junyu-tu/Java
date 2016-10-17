package com.imooc.object;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Date 类最主要的作用就是获得当前时间，同时这个类里面也具有设置时间以及一些其他的功能，
 * 但是由于本身设计的问题，这些方法却遭到众多批评，不建议使用，更推荐使用 Calendar 类进行时间和日期的处理。
 * Calendar类处理时间
 * @author 君宇
 *
 */
public class FourthDemo {

	public static void main(String[] args) {
		// 创建Canlendar对象
		Calendar c =Calendar.getInstance(); 
        
		// 将Calendar对象转换为Date对象(Calendar里面的方法getTime（）返回的类型是Date的，但是这里不强转会报错)
		Date date =(Date) c.getTime();

        
		// 创建SimpleDateFormat对象，指定目标格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
		// 将日期转换为指定格式的字符串
		String now = sdf.format(date);
		System.out.println("当前时间：" + now);
	}


}
