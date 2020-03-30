<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发帖列表</title>
</head>
<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
	<table border="1">
		<tr>
			<th width="150px">帖子编号</th>
			<th width="150px">帖子主题</th>
			<th width="150px">发帖人</th>
			<th width="150px">创建时间</th>
			<th width="150px">回复数量</th>
			<th width="150px">浏览数量</th>
			<th width="150px">是否精华贴</th>
			<th width="150px">否是设置为精华</th>
			<th width="300px">查看回复</th>
			<th width="300px">操作</th>
		</tr>
		<c:forEach items="${topics}" var="t" varStatus="st">
			<tr>
				<td width="150px">${t.topicId}</td>
				<td width="150px">${t.topicTitle}</td>
				<td width="150px">${t.user.userName}</td>
				<td width="150px">${t.createTime}</td>
				<td width="150px">${t.replies}</td>
				<td width="150px">${t.topicViews}</td>
				<td width="150px">${t.digest==0?"否":"是"}</td>
				<td>
					<c:if test="${t.digest==0}">
						<a href="${ctp}/setDigest/${t.topicId}">设置为精华贴</a>
					</c:if>
					<c:if test="${t.digest==1}">
						<a href="${ctp}/setUnDigest/${t.topicId}">撤销精华贴</a>
					</c:if>
				</td>
				<td>
					<a href="${ctp}/listPostByTopicId/${t.topicId}">查看回贴</a>
				</td>
				<td>
					<a href="${ctp}/toAddPost?topicId=${t.topicId}&boardId=${t.boardId}">去回复</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
