<%--
  Created by IntelliJ IDEA.
  User: zhangyang
  Date: 2020/3/30
  Time: 6:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
<form action="${ctp}/modifyPassword" method="post">
    <table border="1px" width="60%">
        <tr>
            <td width="80%">
                <input type="hidden" name="userId" value="${userId}"/>
            </td>
        </tr>
        <tr>
            <td width="20%">旧密码</td>
            <td width="80%"><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td width="20%">新密码</td>
            <td width="80%"><input type="password" name="newPassword"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
