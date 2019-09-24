package com.service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserServlet:web.xml中配置，测试从web.xml中配置ServletContext初始参数，request传递参数两种方式获得参数值。
 *
 */
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("initparam:"+getServletConfig().getInitParameter("key"));
		ServletConfig config = getServletConfig();
		String name2 =(String)getInitParameter("name");
		//String name = (String)req.getAttribute("name");
		String name3 = getServletContext().getInitParameter("name");
		System.out.println("servlet context:"+name3);
		System.out.println("servlet:"+name2);
		System.out.println("get method");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post method");
	}
}
