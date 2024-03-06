<%--
  Created by IntelliJ IDEA.
  User: 郑博豪
  Date: 2024/1/25
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand_demo_war/addservlet"method="post">
    品牌名称：<input name="brand_name"><br>
    企业名称：<input name="company_name"><br>
    排序：<input name="ordered"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea>
    状态：
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">启用<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
