<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户登陆历史记录</title>
</head>
<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
	<table width="1px" >
		<tr>
			<th width="150px">用户ID</th>
			<th width="150px">登陆ID</th>
			<th width="150px">IP地址</th>
			<th width="150px">登陆日期</th>
		</tr>
		<c:forEach items="${loginlogs}" var="log" varStatus="st">
			<tr>
				<td width="150px">${log.user.userId}</td>
				<td width="150px">${log.loginLogId}</td>
				<td width="150px">${log.ip}</td>
				<td width="150px">${log.loginDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
