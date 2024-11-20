<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 17/11/24
  Time: 08:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Request: ${message}--%>
<%--Muon goi gia tri cua session/application o jsp khac:--%>
<p>Application - C2(Goi o JSP): ${applicationScope.message3}</p>
<p>Session - C2(Goi o JSP): ${sessionScope.message4}</p>
<p>Session - Cach goi tu servlet: truyen request -> jsp: ${str1}</p>
</body>
</html>
