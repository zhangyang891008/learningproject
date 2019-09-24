package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloServlet:通过注释@WebServlet配置，可以设置属性name,urlPatterns,initParams等属性
 *
 */

@WebServlet(urlPatterns = {"/hello","/bye"})
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().endsWith("/hello")) {
			System.out.println("received a hello request!");
		} else if(req.getRequestURI().endsWith("/bye")) {
			System.out.println("received a bye request!");
		}
		req.getRequestDispatcher( "user.jsp").forward(req, resp);
		//resp.sendRedirect("user.jsp");
		
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
