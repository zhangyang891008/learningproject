package com.service;

public class User {

	String name;
	String passwd;
	
	public User(String name, String pass) {
		this.name = name;
		this.passwd = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
