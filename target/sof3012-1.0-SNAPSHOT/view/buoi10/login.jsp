<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 18/11/24
  Time: 07:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>
    <form action="/login" method="post">
        Name:
        <input type="text" name="name">
        <br/>
        Pass:
        <input type="text" name="pass">
        <br/>
        <button type="submit">dang nhap</button>
    </form>
</body>
</html>
