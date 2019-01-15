<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-15
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户管理</title>
    <script type="text/javascript">
        function deleteuser(id) {
            var b = window.confirm("您确定要删除吗？")
            if(b){
                window.location.href="${pageContext.request.contextPath}/servlet/DeleteUserServlet?id=" + id;
            }
        }
        function deletealluser() {
            var b = window.confirm("您确定要删除所有用户吗？")
            if(b){
                window.location.href="${pageContext.request.contextPath}/servlet/DeleteAllUserServlet";
            }
        }
    </script>
</head>
<body style="text-align: center">
<div align="right">${user.nikename }，欢迎您! &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/LogoutServlet">退出</a></div>
<div style="text-align: center">
<c:if test="${!empty(user)}">
<table width="70%" border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td>编号</td>
        <td>账号</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>生日</td>
        <td>创建日期</td>
        <td>操作</td>
    </tr>
<c:forEach items="${users }" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.nikename}</td>
        <td>${user.email}</td>
        <td>${user.birthday}</td>
        <td>${user.createdTime}</td>
        <td>
            <a href="${pageContext.request.contextPath}/servlet/EditUserServlet">编辑</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="javascript:void(0)" onclick="deleteuser('${user.id}') ">删除</a>
        </td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="7">
            <a href="javascript:void(0)" onclick="deletealluser() ">删除所有用户</a>
        </td>
    </tr>
</table>
</c:if>
<c:if test="${empty(user)}">
    没有任何用户存在！
</c:if>
</div>
</body>
</html>
