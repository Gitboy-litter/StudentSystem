<%--
  Created by IntelliJ IDEA.
<%--
  Created by IntelliJ IDEA.
  User: QT
  Date: 2020/9/15
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>index</title>
    <link href="css/menu.css" type='text/css' rel='stylesheet'>
    <script type="text/javascript" src="jq/jquery-3.4.1.min.js"></script>
    <script src="js/nav.js" type="text/javascript"></script>
</head>
<body>
<!-- 代码 开始 -->
<div class="nav" style="z-index: 3">
    <div class="navmain">
        <ul id="nav_all">
            <li><a href="index.jsp">首页</a>
                <%--<ul style="display: none;">--%>
                <%--<li><a>这里可以写一些用于描述网站的话。</a></li>--%>
                <%--</ul>--%>
            </li>
            <li><a href="http://sc.chinaz.com/">学生管理</a>
                <ul style="display: none;">
                    <li style="width: 30px;"></li>
                    <li><a href="http://sc.chinaz.com/">添加学生</a></li>
                    <li><a href="http://sc.chinaz.com/">删除学生</a></li>
                    <li><a href="http://sc.chinaz.com/">修改学生</a></li>
                    <li><a href="http://sc.chinaz.com/">查询学生</a></li>
                </ul>
            </li>
            <li><a href="http://sc.chinaz.com/">教师管理</a>
                <ul style="display: none;">
                    <li style="width: 30px;"></li>
                    <li><a href="http://sc.chinaz.com/">添加教师</a></li>
                    <li><a href="http://sc.chinaz.com/">删除教师</a></li>
                    <li><a href="http://sc.chinaz.com/">修改教师</a></li>
                    <li><a href="http://sc.chinaz.com/">查询教师</a></li>
                </ul>
            </li>
            <li><a href="http://sc.chinaz.com/">
                <div style="_margin-top: 12px;"></div>
                课程</a>
                <ul style="display: none;">
                    <li style="width: 120px;"></li>
                    <li><a>查看课程</a></li>
                    <li><a>添加课程</a></li>
                    <li><a>修改课程</a></li>
                    <li><a>删除课程</a></li>
                </ul>
            </li>
            <li><a href="http://sc.chinaz.com/">院系</a>
                <ul style="display: none;">
                    <li style="width: 280px;"></li>
                    <li><a href="http://sc.chinaz.com/">查看院系</a></li>
                    <li><a href="http://sc.chinaz.com/">修改院系</a></li>
                    <li><a href="http://sc.chinaz.com/">添加院系</a></li>
                    <li><a href="http://sc.chinaz.com/">删除院系</a></li>
                </ul>
            </li>
            <li><a href="http://sc.chinaz.com/">信息查看</a>
                <ul style="display: none;">
                    <li style="width: 325px;"></li>
                    <li><a href="/selectstudent"><b>查看学生信息</b></a></li>
                    <li><a href="http://sc.chinaz.com/">查看教师信息</a></li>
                    <li><a href="http://sc.chinaz.com/">查看院系信息</a></li>
                    <li><a href="http://sc.chinaz.com/">查看课程信息</a></li>
                    <li><a href="http://sc.chinaz.com/">查看选课信息</a></li>
                </ul>
            </li>
            <li style="margin-left: 200px"><a href="http://sc.chinaz.com/">退出</a>
            </li>
            <li><a href="http://sc.chinaz.com/">注销</a>
            </li>
            <li><a type="text">当前用户:${cookie.username.value}</a>
            </li>
            <li><a type="text">当前人数:${applicationScope.count}</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
