<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 8/11/24
  Time: 08:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>ID</th>
    <th>Product Code</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Description</th>
    <th>Category Code</th>
    <th>Category Name</th>
    <th colspan="2">Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listProduct}" var="p" varStatus="i">
    <tr>
      <td>${i.index}</td>
      <td>${p.id}</td>
      <td>${p.productCode}</td>
      <td>${p.productName}</td>
      <td>${p.price}</td>
      <td>${p.description}</td>
      <td>${p.cate.categoryCode}</td>
      <td>${p.cate.categoryName}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
