<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户锁定及解锁</title>
</head>
<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
	<table border="1">
		<tr>
			<th width="150px">用户序号</th>
			<th width="150px">用户名称</th>
			<th width="150px">密码</th>
			<th width="150px">是否锁定</th>
			<th width="150px">操作</th>
		</tr>
		<c:forEach items="${users}" var="c" varStatus="st">
			<tr>
				<td width="150px">${c.userId}</td>
				<td width="150px">${c.userName}</td>
				<td width="150px">${c.password}</td>
				<td width="150px">${c.locked==0?"lock":"unlock"}</td>
				<td width="150px">
					<c:if test="${c.locked ==0}">
						<a href="${ctp}/lockUser?username=${c.userName}">锁定</a>
					</c:if>
					<c:if test="${c.locked ==1}">
						<a href="${ctp}/unlockUser?username=${c.userName}">解锁</a>
					</c:if>

					<a href="${ctp}/toModifyPassword/${c.userId}">修改密码</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
