package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序 2.对String泛型的List进行排序
 * 3.对其他类型泛型的List进行排序，以Student为例
 * 
 * @author 君宇
 *
 */
public class CollectionsTest {

	/**
	 * 通过Collections.sort()方法，对Integer泛型的List进行排序
	 * 创建一个Integer泛型的List，插入十个100以内的不重复随机整数 调用Collection.sort()方法对其进行排序
	 * 
	 * @param args
	 */
	public void testSort1() {
		// 不能使用基本类型作为泛型，如果必须要使用，则使用它们的包装类
		List<Integer> integerList = new ArrayList<Integer>();
		// 插入十个100以内的不重复随机整数
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("--------排序前---------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}

		Collections.sort(integerList);
		System.out.println("--------排序后---------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
	}

	/**
	 * 对String泛型的List进行排序 创建String泛型的List,添加三个乱序的String元素 条用sort方法，再次输出排序后的顺序
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("--------排序前---------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}

		Collections.sort(stringList);
		System.out.println("--------排序后---------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}

	}

	/**
	 * 对其他类型泛型的List进行排序，以Student为例
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "", "Mike"));
		studentList.add(new Student(random.nextInt(1000) + "", "Angela"));
		studentList.add(new Student(random.nextInt(1000) + "", "Lucy"));
		studentList.add(new Student(10000 + "", "Beyonce"));
		System.out.println("--------排序前---------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":"
					+ student.getName());
		}

		Collections.sort(studentList);
		System.out.println("--------排序后---------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":"
					+ student.getName());
		}

		Collections.sort(studentList, new StudentComparator());
		System.out.println("--------按照姓名排序后---------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":"
					+ student.getName());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
		// ct.testSort1();
		// ct.testSort2();
		ct.testSort3();

	}

}
