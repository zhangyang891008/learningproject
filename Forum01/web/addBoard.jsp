<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加板块</title>
</head>

<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>

<body>
板块信息：
<form action="${ctp}/addBoard" method="post">
	<table border="1px" width="60%" align="center" >
		<tr>
			<td width="20%">板块名称</td>
			<td width="80%">
				<input type="text" name="boardName"/>
			</td>
		</tr>
		<tr>
			<td width="20%">板块描述</td>
			<td width="80%">
				<input type="text" name="boardDesc"/>
			</td>
		</tr>
		<tr>
			<td width="20%">topic数量</td>
			<td width="80%">
				<input type="text" name="topicNum" value="0"/>
			</td>
		</tr>
 		<tr>
			<td colspan="2">
				<input type="submit" value="保存">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
