<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<table border="1">
		<tr>
			<th width="150px">板块序号</th>
			<th width="150px">板块名称</th>
			<th width="150px">描述</th>
			<th width="150px">topic数量</th>
			<th width="900px">管理员</th>
			<th width="150px">添加管理员</th>
			<th width="150px">移除管理员</th>
			<th width="150px">浏览本板块帖子</th>
		</tr>
		<c:forEach items="${boards}" var="b" varStatus="st">
			<tr>
				<td width="150px">${b.boardId}</td>
				<td width="150px">${b.boardName}</td>
				<td width="150px">${b.boardDesc}</td>
				<td width="150px">${b.topicNum}</td>
				<td width="900px">

					<c:forEach items="${b.users}" var="c" varStatus="st">
						${c.userName}、
					</c:forEach>
				</td>
				<td width="150px" >
					<form action="${ctp}/addBoardManager">
					<input type="hidden" name="boardId" value="${b.boardId}">
					<input type="text" name="username"/>
					<input type="submit" value="添加">
					</form>
				</td>
				<td width="150px" >
					<form action="${ctp}/deleteBoardManager">
						<input type="hidden" name="boardId" value="${b.boardId}">
						<input type="text" name="username"/>
						<input type="submit" value="移除">
					</form>
				</td>

				<td width="150px" >
					<a href="${ctp}/listTopics/${b.boardId}">发帖详情</a>
				</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>
