<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QT
  Date: 2020/9/15
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" type='text/css' rel='stylesheet'>
    <script type="text/javascript" src="jq/jquery-1.12.4.min.js"></script>

</head>
<body>
<div class="login">
    <h2>欢迎到来</h2>
    <div class="login-top">
        <h1>登陆界面</h1>
        <form action="/login">
            <c:if test="${msg!=null}">
                ${msg}
            </c:if>
            <input type="text" name="username" class="username" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" ><br>
            <input type="password" name="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}"><br>
            <input type="radio" name="type" value="student" checked="checked" ><span style="color: #F45B4B">学生</span>
            <input type="radio" name="type" value="teacher"><span style="color: #F45B4B">教师</span>
            <input type="radio" name="type" value="admin"><span style="color: #F45B4B">管理员</span>
                <div class="forgot">
                    <input type="submit" value="登陆" >
                </div>
        </form>
    </div>
    <div class="login-bottom">
        <h3>新用户 &nbsp;<a href="register.jsp">注册</a></h3>
    </div>
</div>
</body>
</html>
