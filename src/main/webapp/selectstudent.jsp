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
    .add_div{
        display: none;
        margin: 0 auto;
        position: relative;
        height: 300px;
        width: 200px;
        background: skyblue;
        cursor: pointer;
        z-Index:5;
        opacity: 0.7;
    }
    .add_div form{
        margin-left: 40px;
        margin-top: 10px;
        position: absolute;
    }
    .add_div .input{
        margin-top: 10px;
        height: 20px;
        width: 60px;
    }

    .update_div{
        display: none;
        margin: 0 auto;
        position: relative;
        height: 300px;
        width: 200px;
        background: skyblue;
        cursor: pointer;
        z-Index:5;
        opacity: 0.7;
    }
    .update_div form{
        margin-left: 40px;
        margin-top: 10px;
        position: absolute;
    }
    .update_div .input{
        margin-top: 10px;
        height: 20px;
        width: 60px;
    }
    #hidebg{
        position:absolute;left:0px;top:0px;
        background-color:#000;
        width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
        height: 100%;
        filter:alpha(opacity=60);  /*设置透明度为60%*/
        opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
        display:none;
        z-Index:4;
    }
</style>
<script>
    $(function () {
        $('.del').mouseleave(function () {
            $(this).children("button").css("background-color","red");
        }).mouseenter(function () {
            $(this).children("button").css("background-color","deepskyblue");
        }).mousedown(function () {
            if (confirm("确定要干掉他？")){
                // location.href("/register.jsp");
                var a = $(this).children().children("a").attr("href");
                location.href=a;
            }
        })
        $('.update').mouseleave(function () {
            $(this).children("button").css("background-color","deepskyblue");
        }).mouseenter(function () {
            $(this).children("button").css("background-color","red");
        }).mousedown(function () {
            $("#sno").attr("value",$(this).siblings(".sno").html())
            $("#name").attr("value",$(this).siblings(".sname").html())
            $("#upage").attr("value",$(this).siblings(".sage").html())
            $("#sdept").attr("value",$(this).siblings(".sdept").html())
            $("#sex").attr("value",$(this).siblings(".ssex").html())
            $("#hidebg").css("display","block");
            $(".update_div").css("display","block");
        })

        $('#add').mousedown(function () {
            // $("#table").css("position",absolute);
            $("#hidebg").css("display","block");
            $(".add_div").css("display","block");
        })
        $("#close").mousedown(function () {
            $("#hidebg").css("display","none")
            $(".add_div").css("display","none")
        })
        $("#shutdown").mousedown(function () {
            $("#hidebg").css("display","none")
            $(".update_div").css("display","none")
        })

    })
</script>
<html>
<head>
<%--<meta http-equiv="Content-Type" content="text/html;charset=GB2312" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>
</head>
<body>
<%@ include file="include.jsp"%>
<form action="/selectstudent" style="margin-left:550px">
    <label>姓名:</label><input type="text" value="${name}" name="name">
    <input type="submit" value="查询">
</form>
<div id="hidebg"></div>
<button id="add" style="background-color: white;margin-left: 450px;margin-top: 5px"><a>添加</a></button>
<table id="table" class="pure-table pure-table-horizontal" style="position: relative;" >
    <thead >
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
            <td class="del"><button style="background-color: red;"><a href="/delete?sno=${list.sno}" style="text-decoration: none;color: white">删除</a></button></td>
            <td class="update"><button style="background-color: deepskyblue;"><a href="#" style="text-decoration: none;color: white">修改</a></button></td>
        </tr>
    </c:forEach>
</table>
<div style="margin-left: 450px">
<a href="/selectstudent?pageCurrent=1&name=${name}">首页</a>
<a href="/selectstudent?pageCurrent=${page.pageCurren-1}&name=${name}" >上一页</a>
<a href="/selectstudent?pageCurrent=${page.pageCurren+1}&name=${name}">下一页</a>
<a href="/selectstudent?pageCurrent=${page.pageTotal}&name=${name}" >尾页</a>
</div>
<div style="margin-left: 450px ">
    <table>
        <tr>
            <td>当前是第${page.pageCurren}页&nbsp</td>
            <td>共${page.pageTotal}页&nbsp</td>
            <td>当前也有${size}页&nbsp</td>
            <td>每页有${page.pageSize}条&nbsp</td>
            <td>共${page.count}条&nbsp</td>
        </tr>
    </table>
</div>
<div class="add_div" >
    <form action="/add">
        <span>学号:</span><input class="input" type="text" name="sno"><br><br>
        <span>姓名:</span><input class="input" type="text" name="sname"><br><br>
        <span>性别:</span><input type="radio" name="ssex" value="1">男
         <input type="radio" name="ssex" value="0">女<br><br>
        <span>年龄:</span><input class="input" id="age" type="text" name="sage"><br><br>
        <span>系部:</span><input class="input" type="text" name="sdept"><br><br>
        <input type="submit"  value="添加" style="margin-left:20px;background-color: #F45B4B">
        <input type="button" id="close" value="关闭" style="margin-left:20px;background-color:skyblue">
    </form>
</div>
<div class="update_div" >
    <form action="/update">
        <span>学号:</span><input id="sno" class="input" type="" disabled  name="sno" style="outline:medium;border:none;background-color: skyblue"><br><br>
        <span>姓名:</span><input id="name" class="input" type="text" name="sname"><br><br>
        <span>性别:</span><input  type="radio" name="ssex" value="1" checked>男
        <input type="radio"  name="ssex" value="0">女<br><br>
        <span>年龄:</span><input class="input" id="upage" type="text" name="sage"><br><br>
        <span>系部:</span><input id="sdept" class="input" type="text" name="sdept"><br><br>
        <input type="submit"  value="修改" style="margin-left:20px;background-color: #F45B4B">
        <input type="button" id="shutdown" value="关闭" style="margin-left:20px;background-color:skyblue">
    </form>
</div>

</body>
</html>
