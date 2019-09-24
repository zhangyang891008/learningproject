<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.service.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- demo 01 map-->
<%
Map<String, String> map = new HashMap<String, String>();
map.put("A", "a");
map.put("B", "b");
map.put("C", "c");
request.setAttribute("map", map);
User user = new User("zhangyang","123");
pageContext.setAttribute("user", user);

List<String> list = new ArrayList<String>();
list.add("hello");
list.add("world");
request.setAttribute("list", list);

pageContext.setAttribute("val", 1);
session.setAttribute("val", 2);

session.setAttribute("num", 5);
%>

${val}<br/>
<c:if test="${val == 1}">
equal<br/>
</c:if>

<c:choose>
<c:when test="${num gt 6 }">greater than 6<br/></c:when>
<c:when test="${num lt 6 }">less than 6<br/></c:when>
</c:choose>

<c:forEach var="entry" items="${map}">
    entry.key : <c:out value="${entry.key }"/><br/>
    entry.value : <c:out value="${entry.value }" /><br/>
    user.name:<c:out value="${user.name}" /><br/>
</c:forEach>

<c:out value="${user.name }"></c:out><br/>

<c:forEach var="index" items="${list}">
<c:out value="${index }"></c:out><br/>
</c:forEach>

</body>

</html>