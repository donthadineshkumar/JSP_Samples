<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8">
    <title>Очень простая страница JSP</title>
</head>
<body>
    <h1> Очень простая страница JSP </h1>
    <h3> Этот пример показывает, как работать с выражениями JSP</h3>
    Текущая дата: <%=new Date()%>
    <br>
    Значение параметра "param": <%=request.getParameter("param")%>

</body>
</html>
