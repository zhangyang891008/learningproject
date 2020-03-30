<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>帖子&回复详情</title>
</head>
<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
<h2>标题：${topic.topicTitle}</h2><br>
<h3>发帖用户：${topic.user.userName}</h3>
	<table border="1" >
		<tr>
			<th width="150px">回复编号</th>
			<th width="150px">回复标题</th>
			<th width="150px">回复内容</th>
			<th width="300px">回复用户</th>
			<th width="300px">回复时间</th>
		</tr>
		<c:forEach items="${posts}" var="p" varStatus="st">
			<tr>
				<td width="150px">${p.postId}</td>
				<td width="150px">${p.postTitle}</td>
				<td width="150px">${p.postText}</td>
				<td width="150px">${p.user.userName}</td>
				<td width="150px">${p.createTime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
