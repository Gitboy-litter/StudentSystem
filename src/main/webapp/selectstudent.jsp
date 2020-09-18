<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QT
  Date: 2020/9/15
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="jq/jquery-3.4.1.min.js" charset="UTF-8"></script>
<link href="css/sel.css" type='text/css' rel='stylesheet'>
<%--<script type="text/javascript" src="js/sel.js" charset="GB2312" language="javascript"></script>--%>
<style>
    .add_div {
        display: none;
        margin: 0 auto;
        position: relative;
        height: 300px;
        width: 200px;
        background: skyblue;
        cursor: pointer;
        z-Index: 5;
        opacity: 0.7;
    }

    .add_div form {
        margin-left: 40px;
        margin-top: 10px;
        position: absolute;
    }

    .add_div .input {
        margin-top: 10px;
        height: 20px;
        width: 60px;
    }

    .update_div {
        display: none;
        margin: 0 auto;
        position: relative;
        height: 300px;
        width: 200px;
        background: skyblue;
        cursor: pointer;
        z-Index: 5;
        opacity: 0.7;
    }

    .update_div form {
        margin-left: 40px;
        margin-top: 10px;
        position: absolute;
    }

    .update_div .input {
        margin-top: 10px;
        height: 20px;
        width: 60px;
    }

    #hidebg {
        position: absolute;
        left: 0px;
        top: 0px;
        background-color: #000;
        width: 100%; /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
        height: 100%;
        filter: alpha(opacity=60); /*设置透明度为60%*/
        opacity: 0.6; /*非IE浏览器下设置透明度为60%*/
        display: none;
        z-Index: 4;
    }

    #button ul li {
        margin-top: 20px;
        height: 22px;
        width: 60px;
        text-align: center;
        background-color: white;
        float: left;
        margin-left: 5px;
    }

    #button ul li a {
        text-decoration: none;
        color: #818181;
    }
</style>
<script>
    $(function () {
        $('.del').mouseleave(function () {
            $(this).children("button").css("background-color","white").children().css("color","deepskyblue");
        }).mouseenter(function () {
            $(this).children("button").css("background-color","red").children().css("color","white");
        }).mousedown(function () {
            if (confirm("确定要干掉他？")){
                var a = $(this).children().children("a").attr("href");
                location.href=a;
            }
        })
        $('.update').mouseleave(function () {
            $(this).children("button").css("background-color","white").children().css("color","deepskyblue");
        }).mouseenter(function () {
            $(this).children("button").css("background-color","red").children().css("color","white");
        }).mouseenter(function () {
            $(this).children("button").css("background-color", "red");
        }).mousedown(function () {
            $(".input1").attr("value", $(this).siblings(".sno").html())
            $("#name").attr("value", $(this).siblings(".sname").html())
            $("#upage").attr("value", $(this).siblings(".sage").html())
            $("#sdept").attr("value", $(this).siblings(".sdept").html())
            $("#sex").attr("value", $(this).siblings(".ssex").html())
            $("#hidebg").css("display", "block");
            $(".update_div").css("display", "block");
        })

        $('#add').mousedown(function () {
            $("#hidebg").css("display", "block");
            $(".add_div").css("display", "block");
        }).mouseenter(function () {
            $(this).css({backgroundColor: "skyblue"}).children().css("color", "white")
            $(this).animate({"opacity": 0.5})
        }).mouseleave(function () {
            $(this).css({backgroundColor: "white"}).children().css("color", "skyblue")
            $(this).animate({"opacity": 1})
        })
        $("#close").mousedown(function () {
            $("#hidebg").css("display", "none")
            $(".add_div").css("display", "none")
        })
        $("#shutdown").mousedown(function () {
            $("#hidebg").css("display", "none")
            $(".update_div").css("display", "none")
        })
        $("#button").on("mouseenter", "li", function () {
            $(this).css({backgroundColor: "deepskyblue"})
            $(this).animate({"opacity": 0.5})
        }).on("mouseleave", "li", function () {
            $(this).css({backgroundColor: "white"})
            $(this).animate({"opacity": 1})
        })
    })
</script>
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html;charset=GB2312" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
<%@ include file="include.jsp" %>
<form action="/selectstudent" style="margin-left:650px;margin-top: 5px">
    <input type="text" value="${name}" placeholder="请输入姓名" name="name" style="width: 200px">
    <input type="submit" value="查询" style="background-color: skyblue;opacity: 0.7; outline: medium;border: none">
</form>
<div id="hidebg"></div>
<div id="add"
     style="background-color: white; opacity: 0.7;border: 1px solid deepskyblue;border-radius: 15%; text-align: center;width: 50px;height: 25px; margin-left: 450px;margin-top: -40px;position: absolute">
    <a href="" style="text-decoration: none;color:deepskyblue;margin-top: 3px">添加</a></div>
<table id="table" class="pure-table pure-table-horizontal" style="position: relative;">
    <thead>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>系部</td>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <c:forEach var="list" items="${list}" varStatus="status">
        <c:set var="size" value="${status.count}"></c:set>
        <tr>
            <td class="sno">${list.sno}</td>
            <td class="sname">${list.sname}</td>
            <td class="ssex"><c:if test="${list.ssex==1}">男</c:if><c:if test="${list.ssex==0}">女</c:if></td>
            <td class="sage">${list.sage}</td>
            <td class="sdept">${list.sdept}</td>
            <td class="del">
                <button style="border: 1px solid deepskyblue;background-color: white;border-radius: 15%;"><a
                        href="/deletestudent?sno=${list.sno}" style="text-decoration: none;color: deepskyblue">删除</a>
                </button>
            </td>
            <td class="update">
                <button style="border: 1px solid deepskyblue;background-color: white; border-radius: 15%;"><a href="#"
                                                                                                              style="text-decoration: none;color: deepskyblue">修改</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<div id="button" style="margin-left: 450px">
    <ul>
        <li><a href="/selectstudent?pageCurrent=1&name=${name}">首页</a></li>
        <li><a href="/selectstudent?pageCurrent=${page.pageCurren-1}&name=${name}">上一页</a></li>
        <li><a href="/selectstudent?pageCurrent=${page.pageCurren+1}&name=${name}">下一页</a></li>
        <li><a href="/selectstudent?pageCurrent=${page.pageTotal}&name=${name}">尾页</a></li>
    </ul>
</div>
<div style="margin-left: 450px;margin-top: 60px">
    <table>
        <tr>
            <td>当前${page.pageCurren}页&nbsp</td>
            <td>共${page.pageTotal}页&nbsp</td>
            <td>当前${size}条&nbsp</td>
            <td>每页有${page.pageSize}条&nbsp</td>
            <td>共${page.count}条&nbsp</td>
        </tr>
    </table>
</div>
<div class="add_div">
    <form action="/studentadd">
        <span>学号:</span><input class="input" type="text" name="sno"><br><br>
        <span>姓名:</span><input class="input" type="text" name="sname"><br><br>
        <span>性别:</span><input type="radio" name="ssex" value="1">男
        <input type="radio" name="ssex" value="0">女<br><br>
        <span>年龄:</span><input class="input" id="age" type="text" name="sage"><br><br>
        <span>系部:</span><input class="input" type="text" name="sdept"><br><br>
        <input type="submit" value="添加" style="margin-left:20px;background-color: #F45B4B">
        <input type="button" id="close" value="关闭" style="margin-left:20px;background-color:skyblue">
    </form>
</div>
<div class="update_div">
    <form action="/studentupdate">
        <%--style="outline:medium;border:none;background-color: skyblue"--%>
        <span>学号:</span><input id="sno" class="input1" type="" disabled
                               style="border:none;background-color: skyblue;width: 60px;">
        <input id="sno" class="input1" type="hidden" name="sno"
               style="border:none;background-color: skyblue;width: 20px"><br><br>
        <span>姓名:</span><input id="name" class="input" type="text" name="sname"><br><br>
        <span>性别:</span><input type="radio" name="ssex" value="1" checked>男
        <input type="radio" name="ssex" value="0">女<br><br>
        <span>年龄:</span><input class="input" id="upage" type="text" name="sage"><br><br>
        <span>系部:</span><input id="sdept" class="input" type="text" name="sdept"><br><br>
        <input type="submit" value="修改" style="margin-left:20px;background-color: #F45B4B">
        <input type="button" id="shutdown" value="关闭" style="margin-left:20px;background-color:skyblue">
    </form>
</div>

</body>
</html>
