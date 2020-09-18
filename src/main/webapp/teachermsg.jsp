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
    #button ul li{
        margin-top: 20px;
        height: 22px;
        width: 60px;
        text-align: center;
        background-color: white;
        float: left;
        margin-left: 5px;
    }
    #button ul li a{
        text-decoration: none;
        color: #818181;
    }
</style>
<script>
    $(function () {
        $("#button").on("mouseenter","li",function () {
            $(this).css({backgroundColor:"#a3b0c9"})
            $(this).animate({"opacity":0.5})
        }).on("mouseleave","li",function () {
            $(this).css({backgroundColor:"white"})
            $(this).animate({"opacity":1})
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
<form action="/selectteacher" style="margin-left:650px;margin-top: 5px">
    <input type="text" value="${name}" placeholder="请输入姓名" name="name" style="width: 200px">
    <input type="submit" value="查询" style="background-color: white;opacity: 0.7; outline: medium;border: 1px solid deepskyblue;border-radius: 15%;color: deepskyblue">
</form>
<table id="table" class="pure-table pure-table-horizontal" style="position: relative;margin-left: 390px" >
    <thead >
    <tr>
        <td>工号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>学历</td>
        <td>职称</td>
        <td>主讲课1</td>
        <td>主讲课2</td>
        <td>主讲课3</td>
    </tr>
    </thead>
    <c:forEach var="list" items="${list}" varStatus="status">
        <c:set var="size" value="${status.count}"></c:set>
        <tr>
            <td class="tno">${list.tno}</td>
            <td class="tname">${list.tname}</td>
            <td class="tsex"><c:if test="${list.tsex==1}">男</c:if><c:if test="${list.tsex==0}">女</c:if></td>
            <td class="tage">${list.tage}</td>
            <td class="teb">${list.teb}</td>
            <td class="tpt">${list.tpt}</td>
            <td class="cno1">${list.cno1}</td>
            <td class="cno2">${list.cno2}</td>
            <td class="cno3">${list.cno3}</td>
        </tr>
    </c:forEach>
</table>
<div id="button" style="margin-left: 600px">
    <ul>
        <li><a href="/selectteacher??id=2&pageCurrent=1&name=${name}">首页</a></li>
        <li><a href="/selectteacher??id=2&pageCurrent=${page.pageCurren-1}&name=${name}" >上一页</a></li>
        <li><a href="/selectteacher??id=2&pageCurrent=${page.pageCurren+1}&name=${name}">下一页</a></li>
        <li><a href="/selectteacher??id=2&pageCurrent=${page.pageTotal}&name=${name}" >尾页</a></li>
    </ul>
</div>
<div style="margin-left: 600px;margin-top: 60px">
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
</body>
</html>
