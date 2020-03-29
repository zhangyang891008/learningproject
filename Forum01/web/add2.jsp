<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
</head>

<%
	pageContext.setAttribute("ctp",request.getContextPath());
	pageContext.setAttribute("user",session.getAttribute("USER_CONTEXT"));
%>

<body>
	<h1>管理平台</h1> 欢迎，${user==null?"nobody":user.userName}<br>

	<a href="${ctp}/listUser">用户列表</a><br>
	<a href="${ctp}/listBoards">板块列表</a><br>
	<a href="${ctp}/login.jsp">去登陆</a><br>
	<a href="${ctp}/register.jsp">去注册</a><br>
</body>
</html>
