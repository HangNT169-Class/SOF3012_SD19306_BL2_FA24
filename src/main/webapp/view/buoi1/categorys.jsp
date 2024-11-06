<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/category/view-add">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%-- Hien thi stt => varStatus     --%>
    <c:forEach items="${a1}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.id1}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                <%--Chi co duy nhat tham so dau tien la dau ?.
                TS 2 tro di la dau &
                VD: /category/delete?a=${cate.id1}&name=${cate.categoryName}--%>
                <a href="/category/delete?a1=${cate.id1}">Delete</a>
                <a href="/category/view-update?b=${cate.id1}">Update</a>
                <a href="/category/detail?c=${cate.id1}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
