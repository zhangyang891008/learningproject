package com.tag;

public class Student {

	private String name;
	private String school;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public Student(String name, String school) {
		super();
		this.name = name;
		this.school = school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
}
