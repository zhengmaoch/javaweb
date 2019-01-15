<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body style="text-align: center">
<div style="text-align: center">
<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
    <table>
        <tr>
            <td>
                用户名:<input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                密  码:<input type="text" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" name="register" value="注  册" onclick="window.location.href='${pageContext.request.contextPath}/servlet/RegisterUIServlet';"/>
                <input type="submit" name="login" value="登  录"/>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
