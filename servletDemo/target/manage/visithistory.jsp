<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/9/2019
  Time: 下午 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>visithistory</title>
</head>
<body>

<h5>IP访问情况统计</h5>
<table border="1">
<tr>
    <th colspan="10">IP</th>
    <th colspan="10">访问次数</th><br>
</tr>

<c:forEach items="${visithistory}" var="entry">

    <tr>
        <td colspan="10">${entry.key}</td>
        <td colspan="10">${entry.value}</td> <br>
    </tr>

</c:forEach>
</table>
</body>
</html>

<html>
<head>
    <title>visithistory</title>
</head>
<body>


</body>
</html>
