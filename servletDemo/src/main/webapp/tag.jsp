<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.service.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tag/mytag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- validate tag test -->
passwd:123 namezhangyang
<mytag:validate passwd="123" name="zhangyang"/>

passwd:null name:zhangyang
<mytag:validate passwd="" name="zhangyang"/>

<!-- query tag test -->
<mytag:query table="student"/>
<c:choose>
	<c:when test="${state eq 1}">
	<h4> table name cannot be null</h4>
	</c:when>
	<c:when test="${state eq 2}">
		<table>
			<tr>
			<th>name</th>
			<th>school</th>
			</tr>
			<c:forEach items="${students }" var="student">
				<tr>
					<td>${student.name }</td><br/>
					<td>${student.school }</td><br/>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>

</body>

</html>