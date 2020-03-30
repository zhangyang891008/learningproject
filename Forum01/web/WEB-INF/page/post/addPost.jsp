<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回帖</title>
</head>

<%
	pageContext.setAttribute("ctp",request.getContextPath());
	pageContext.setAttribute("user",session.getAttribute("USER_CONTEXT"));
%>

<body>
新帖
<form action="${ctp}/addPost" method="post">
	<table border="1px" width="60%">

		<tr>
			<td width="20%">回帖标题</td>
			<td width="80%">
				<input type="text" name="postTitle"/>
			</td>
		</tr>
		<tr>
			<td width="20%">回帖内容</td>
			<td width="80%">
				<input type="text" name="postText"/>
			</td>
		</tr>
		<td><input type="hidden" name="boardId" value="${boardId}"/> </td>
		<td><input type="hidden" name="topicId" value="${topicId}"/> </td>
 		<tr>
			<td colspan="2">
				<input type="submit" value="提交回贴">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
