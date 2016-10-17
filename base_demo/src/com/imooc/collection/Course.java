package com.imooc.collection;

/**
 * 课程类
 * @author 君宇
 *
 */
public class Course {
	
	private String id;
	
	private String name;
	
	public Course() {
		
	}
	
	public Course(String id,String name){
		this.id=id;
		this.name=name;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//重写equals方法
//	@Override
//	public boolean equals(Object obj){
//		if(this ==obj){
//			return true;
//		}
//		if(obj==null){
//			return false;
//		}
//		if(!(obj instanceof Course)){
//			return false;
//		}
//		Course course = (Course)obj;
//		if(this.getName()==null){
//			if(course.name==null)
//				return true;
//			else 
//				return false;
//		}else {
//			if(this.getName().equals(course.getName()))
//				return true;
//			else 
//				return false;	
//		}
//
//	}
	
	
	
}
