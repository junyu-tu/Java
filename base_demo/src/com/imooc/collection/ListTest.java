package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 模拟学生选课功能
 * 选择课程（往集合中添加课程）
 * 删除所选的某门课程（删除集合中的元素）
 * 查看所选课程
 * 修改所选课程
 *
 * 备选课程类
 * @author 君宇
 *
 */

public class ListTest {
	
	//用于存放备选课程的lists
	public List coursesToSelect;
	
	public ListTest(){
		//List是一个接口，不能直接实例化，所以借用ArrayList进行实例化
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 * 用于往coursesToSelect中添加备选课程(增)
	 * add(e)：在List尾部添加e元素
	 * add(index,e)：在List中index位置添加e元素
	 * addAll(collection):在List尾部添加一个collection中的所有元素
	 * addAll(index,collection)：在List中index位置添加collection中的所有元素
	 * list中的元素是有序并且可以重复的
	 */
	public void testAdd(){
		//创建一个课程对象,并通过调用add方法，添加到备选课程.add(e)：在List尾部添加e元素
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("添加的课程为："+temp.getId()+":"+temp.getName());
	    
		//add(index,e)：在List中index位置添加e元素
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course)coursesToSelect.get(0);
		System.out.println("添加的课程为："+temp2.getId()+":"+temp2.getName());	
		
		//list中的元素是有序并且可以重复的,这里增加一个重复的数据
		coursesToSelect.add(cr1);
		Course temp0 = (Course)coursesToSelect.get(2);
	
		//addAll(collection):在List尾部添加一个collection中的所有元素
		Course[] course = {new Course("3", "离散数学"),new Course("4", "汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)coursesToSelect.get(3);
		Course temp4 = (Course)coursesToSelect.get(4);
		System.out.println("添加两门课程为："+temp3.getId()+":"+temp3.getName()+";"+
				temp4.getId()+":"+temp4.getName());
	    
		//addAll(index,collection)：在List中index位置添加collection中的所有元素
		Course[] course2 = {new Course("5", "高等数学"),new Course("6", "大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("添加两门课程为："+temp5.getId()+":"+temp5.getName()+";"+
				temp6.getId()+":"+temp6.getName());
		
	}
	
	/**
	 * 获取List中的元素的方法(查)
	 * @param args
	 */
	public void testGet(){
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i = 0; i<size;i++){
			Course cr = (Course)coursesToSelect.get(i);
			System.out.println("课程："+cr.getId()+":"+cr.getName());
		}		
	}
	
	/**
	 * 通过迭代器来遍历List(查)
	 * @param args
	 */
	public void testIterator(){
		//通过集合的Iterator方法，获取迭代器的实例
		Iterator it = coursesToSelect.iterator();
		System.out.println("有如下课程待选(通过 迭代器访问)：");
		//hasNext()方法:如果还有元素的话，就返回一个真值
		while(it.hasNext()){
			Course cr = (Course)it.next();
			System.out.println("课程："+cr.getId()+":"+cr.getName());
		}
	}
	
	/**
	 * 通过for each方法访问集合元素(查)
	 * @param args
	 */
	public void testForEach(){
		System.out.println("有如下课程待选(通过foreach访问)：");
		for(Object obj : coursesToSelect){
			Course cr = (Course)obj;
			System.out.println("课程："+cr.getId()+":"+cr.getName());
		}
	}

	/**
	 * 修改List中的元素（改）
	 * set(index,element);
	 * 在相应的位置修改元素
	 * @param args
	 */
	public void testModify(){
		coursesToSelect.set(4, new Course("7", "毛概"));	
	}
	
	/**
	 * 删除List中的元素（删）
	 * Remove(e)：输入要被删除的元素
	 * Remove(index):输入要被删除的元素的位置
	 * RemoveAll:从某个集合中将另一个集合中的元素完全删除
	 * @param args
	 */
	public void testRemove(){
		//Remove(e)
//		Course cr = (Course)coursesToSelect.get(4);
//		System.out.println("课程："+cr.getId()+":"+cr.getName()+" 即将被删除！");
//		coursesToSelect.remove(cr);
		
		//Remove(index)
//		System.out.println("即将删除4位置上的课程！");
//		coursesToSelect.remove(4);
//		System.out.println("成功删除课程！");
		
		//RemoveAll(collection<>)
		System.out.println("即将删除4位置和5位置上的课程！");
		Course[] courses ={(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("成功删除课程！");
		testForEach();
	}
	
	/**
	 * 往List中添加一些奇怪的东西
	 * @param args
	 */
	public void testType(){
		System.out.println("能否往List中添加一些奇怪的东西呢？");
		coursesToSelect.add("我不是课程，只是一个无辜的字符串！");
	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();	
		lt.testType();
		//会报异常，string不能转换为Course
		lt.testForEach();
//		lt.testGet();
//		lt.testIterator();
//		lt.testModify();
//		lt.testForEach();
//		lt.testRemove();
	}

}
