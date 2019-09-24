package com.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 继承SimpleTagSupport实现简单标签功能，table，field为属性，将Uesr信息保存到request中，通过jsp页面展示
 * 对应配置tag/mytag.tld
 * 测试页面tag.jsp
 */
public class QueryInfoSimpleTag extends SimpleTagSupport{
	
	private String table;
	private String field;
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(table == null || !table.equals("student")) {
			getJspContext().setAttribute("state", 1);
			return;
		}
		
		List<Student> studentList = queryDB(table, field);
		getJspContext().setAttribute("students", studentList);
		getJspContext().setAttribute("state", 2);
		
	}
	
	private List<Student> queryDB(String table, String field){
		List students = new ArrayList<Student>();
		Student s1 = new Student("tom","neu");
		Student s2 = new Student("lucy","neuq"); 
		students.add(s1);
		students.add(s2);
		return students;
	}
 
}
