<%--
  Created by IntelliJ IDEA.
  User: 郑博豪
  Date: 2024/1/25
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand_demo_war/updateservlet?id=${brand.id}"method="post">
    品牌名称：<input name="brand_name" value="${brand.brandName}"><br>
    企业名称：<input name="company_name" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description"> ${brand.description}</textarea>
    状态：
    <c:if test="${brand.status==1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>

    <c:if test="${brand.status!=1}">
        <input type="radio" name="status" value="0"checked>禁用
        <input type="radio" name="status" value="1" >启用<br>
    </c:if>
    <input type="submit" value="提交">
</form>
</body>
</html>
