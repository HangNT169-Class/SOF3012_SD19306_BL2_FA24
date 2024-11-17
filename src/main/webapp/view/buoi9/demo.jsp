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
Request: ${message2}
<%--Chi goi duoc truoc tiep ${message} trong jsp ma duoc getRequestDispatcher--%>
<p>Application: ${message3}</p>
<%--Code Java truc tiep rtong jsp: <% code o giua %>--%>
<%
    // Thiep lap gia tri trong pageContext
    pageContext.setAttribute("message1","Test demo scope JSP - page");
    // Lay gia tri tu pageText : getAttribute
    String message1 = (String) pageContext.getAttribute("messsage1");
%>
<p>Page: ${message1}</p>
<p>Session: ${message4}</p>
</body>
</html>
