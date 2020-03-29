<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>板块列表</title>
</head>
<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
	<table width="1px" >
		<tr>
			<th width="150px">板块序号</th>
			<th width="150px">板块名称</th>
			<th width="150px">描述</th>
			<th width="150px">topic数量</th>
			<th width="150px">管理员</th>
		</tr>
		<c:forEach items="${boards}" var="b" varStatus="st">
			<tr>
				<td width="150px">${b.boardId}</td>
				<td width="150px">${b.boardName}</td>
				<td width="150px">${b.boardDesc}</td>
				<td width="150px">${b.topicNum}</td>
				<td width="150px">${b.users}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
