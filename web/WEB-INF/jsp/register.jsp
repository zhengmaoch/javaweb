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
    <title>用户注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
    <table>
        <tr>
            <td>账号</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="text" name="birthday">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="nikename">
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" name="reset" value="重  置">
            </td>
            <td>
                <input type="submit" name="submit" value="注  册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>