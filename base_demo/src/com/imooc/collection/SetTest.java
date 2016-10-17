package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 通过Set集合管理课程
 * 
 * @author 君宇
 *
 */
public class SetTest {

	public List<Course> coursesToSelect;

	private Scanner console;

	public Student student;

	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}

	public void testAdd() {
		// 创建一个课程对象,并通过调用add方法，添加到备选课程.add(e)：在List尾部添加e元素
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);

		// add(index,e)：在List中index位置添加e元素
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course) coursesToSelect.get(0);

		// addAll(collection):在List尾部添加一个collection中的所有元素
		Course[] course = { new Course("3", "离散数学"), new Course("4", "汇编语言") };
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);

		// addAll(index,collection)：在List中index位置添加collection中的所有元素
		Course[] course2 = { new Course("5", "高等数学"), new Course("6", "大学英语") };
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);

	}

	/**
	 * 通过for each方法访问集合元素(查)
	 * 
	 * @param args
	 */
	public void testForEach() {
		System.out.println("有如下课程待选(通过foreach访问)：");
		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("课程：" + cr.getId() + ":" + cr.getName());
		}
	}

	/**
	 * 测试List的contains方法:查找序列是否包含某个对象（元素）；包含返回true,否则返回false
	 * 
	 * @param args
	 */
	public void testListContains() {
		// 取得备选课程序列的第0个元素
		Course course = coursesToSelect.get(0);
		// 打印输出coursesToSelect是否包含course对象
		System.out.println("取得课程：" + course.getName());
		System.out.println("备选课程中是否包含课程：" + course.getName() + ","
				+ coursesToSelect.contains(course));
		// 提示输入课程名称
		System.out.println("请输入课程名称：");
		String name = console.next();
		// 创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2 = new Course();
		course2.setName(name);
		System.out.println("新创建课程：" + course2.getName());
		System.out.println("备选课程中是否包含课程：" + course2.getName() + ","
				+ coursesToSelect.contains(course2));

		// 通过indexOf方法获取某元素的索引位置
		if (coursesToSelect.contains(course2)) {
			System.out.println("课程：" + course2.getName() + "的索引位置："
					+ coursesToSelect.indexOf(course2));
		}

		// //创建一个新的课程对象，ID和名称，与course对象完全一样
		// //下面的contains会返回false;尽管ID和name是相同的，但是和前者属于两个不同的对象;前提是不重写equals方法
		// Course course2 = new Course(course.getId(), course.getName());
		// System.out.println("新创建课程："+course2.getName());
		// System.out.println("备选课程中是否包含课程："+course2.getName()+","+
		// coursesToSelect.contains(course2));
	}

	/**
	 * 创建学生对象并选课
	 */
	public void createStudentAndSelectCours() {
		// 创建一个学生对象
		student = new Student("1", "小明");
		System.out.println("欢迎" + student.getName() + "同学选课!");
		// 创建一个Scanner对象
		Scanner console = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("请输入课程ID:");
			String courseId = console.next();
			for (Course cr : coursesToSelect) {
				if (cr.getId().equals(courseId)) {
					student.getCourses().add(cr);
				}
			}
		}
	}

	/**
	 * 测试Set的contains方法：判断Set中某门课程是否存在
	 * 
	 * @param args
	 */
	public void testSetContains() {
		// 提示输入课程名称
		System.out.println("请输入学生已选的课程名称：");
		String name = console.next();
		// 创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2 = new Course();
		course2.setName(name);
		System.out.println("新创建课程：" + course2.getName());
		System.out.println("备选课程中是否包含课程：" + course2.getName() + ","
				+ student.getCourses().contains(course2));
	}

	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();
        

//		st.createStudentAndSelectCours();
//		st.testSetContains();
		
//	    st.testForEachForSet(student);

	}

	public void testForEachForSet(Student student) {
		// 打印输出，学生所选的课程
		System.out.println("共选择了：" + student.getCourses().size() + "门课程！");
		for (Course cr : student.getCourses()) {
			System.out.println("选择了课程：" + cr.getId() + ":" + cr.getName());
		}
	}

}
