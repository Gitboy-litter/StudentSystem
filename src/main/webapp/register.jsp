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
    <script type="text/javascript">
        $(function () {
            $(".username").blur(function () {
                var username = $(this).val();
                if (username.length > 0) {
                    var url = "SelectUsername";
                    var data = {username: username};
                    var callback = function (result) {
                        if (result.errorMsg) {
                            alert(result.errorMsg);
                        }else {
                            if (result.flag){
                                $("#usernameinfo").css("color","green");
                            }else {
                                $("#usernameinfo").css("color","red");
                            }
                            $("#usernameinfo").html(result.msg)
                        }
                    };
                    var type="json";
                    $.post(url,data,callback,type)
                }
            })
        })
    </script>
</head>
<body>
<div class="login">
    <h2>欢迎到来</h2>
    <div class="login-top">
        <h1>登陆界面</h1>
        <form action="/register">
            <input type="text" name="username" class="username" value="用户名" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = '用户名';}"><br>
            <span id="usernameinfo" style="color: red"></span>
            <input type="password" name="password" value="password" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'password';}"><br>
            <input type="password" name="cpwd" value="password" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'password';}"><br>
            <div class="forgot">
                <input type="submit" value="注册">
            </div>
        </form>
    </div>
    <div class="login-bottom">
        <h3><a href="login.jsp">返回登陆</a></h3>
    </div>
</div>
</body>
</html>
