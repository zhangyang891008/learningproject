<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖</title>
</head>

<%
	pageContext.setAttribute("ctp",request.getContextPath());
	pageContext.setAttribute("boards",request.getAttribute("boards"));
%>

<body>
新帖
<form action="${ctp}/addTopic" method="post">
	<table border="1px" width="60%">
		<tr>
			<td width="20%">帖子名称</td>
			<td width="80%">
				<input type="text" name="topicTitle"/>
			</td>
		</tr>
		<tr>
			<td width="20%">
				所属板块
			</td>
			<td width="80%">
				<select name="boardId" >
					<c:forEach items="${boards}" var="b" varStatus="st">
						<option value="${b.boardId}">${b.boardName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td width="20%">topic数量</td>
			<td width="80%">
				<input type="text" name="replies" value="0"/>
			</td>
		</tr>
 		<tr>
			<td colspan="2">
				<input type="submit" value="发帖">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
