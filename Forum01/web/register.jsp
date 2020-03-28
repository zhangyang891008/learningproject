<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>

<%
	pageContext.setAttribute("ctp",request.getContextPath());
%>

<body>
用户注册信息：
<form action="${ctp}/register" method="post">
	<table border="1px" width="60%">
		<tr>
			<td width="20%">用户名</td>
			<td width="80%">
				<input type="text" name="username"/>
			</td>
		</tr>
		<tr>
			<td width="20%">密码</td>
			<td width="80%"><input type="password" name="password"/></td>
		</tr>
 		<tr>
			<td colspan="2">
				<input type="submit" value="注册">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
