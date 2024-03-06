<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 郑博豪
  Date: 2024/1/25
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<h1>${user.username},欢迎你</h1>

    <input type="button" value="新增" id="add"><br>
    <hr>
    <table border="1" cellspacing="0" width="800">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${brands}" var="brand" varStatus="status">
            <tr align="center">
                <td>${status.count}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status==1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status !=1}">
                    <td>禁用</td>
                </c:if>

                <td><a href="/brand_demo_war/selectbyid?id=${brand.id}">修改</a><a href="#">删除</a> </td>
            </tr>
        </c:forEach>
    </table>

    <hr>
<%--<c:forEach begin="1" end="10" step="1" var="i">
    <a href="#">${i}</a>
</c:forEach>--%>
<script>
    /*document.getElementById("add").onclick=function () {
        location.href="/brand_demo_war/add.jsp"
    }*/
    $('#add').click(function() {
        location.href = "/brand_demo_war/add.jsp";
    });
</script>

</body>
</html>
