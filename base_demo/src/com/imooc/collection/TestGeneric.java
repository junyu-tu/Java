package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试泛型的方法
 * @author 君宇
 *
 */
public class TestGeneric {
	
	//带有泛型--Course的List类型属性
	public List<Course> courses;
	
	public TestGeneric(){
		this.courses=new ArrayList<Course>();
	}
	
	/**
	 * 测试添加
	 */
	public void testAdd(){
		Course cr1 = new Course("1", "大学语文");
		courses.add(cr1);
		//泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则会报错
//		courses.add("能否添加一些奇怪的东西呢？");
		Course cr2 = new Course("2", "Java基础");
		courses.add(cr2);
	}
	
	/**
	 * 测试循环遍历
	 * @param args
	 */
	public void testForEach(){
		for(Course cr :courses){
			System.out.println(cr.getId()+":"+cr.getName());
		}
	}
	
	/**
	 * 泛型集合可以添加泛型的子类型的对象实例
	 * @param args
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.setId("3");
		ccr.setName("我是子类型的课程对象实例~~");
		courses.add(ccr);
	}
	
	/**
	 * 泛型不能使用基本类型
	 * @param args
	 */
	public void testBasicType(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		System.out.println("基本类型必须使用包装类作为泛型:"+list.get(0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();

	}

}
