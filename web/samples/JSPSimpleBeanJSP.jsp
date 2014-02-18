<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP, работающая с компонентом JavaBeans</title>
</head>
<body>

    <h1>JSP, работающая с компонентом JavaBeans</h1>

    <jsp:useBean id="simpleBean" class="servletsSamples.SimpleBean"/>
    Начальное значение свойства:
    <I><%= simpleBean.getStringProperty()%> </I><br>

    <% simpleBean.setStringProperty("This is a String property");%>
    Значение после установки:
    <I><%= simpleBean.getStringProperty()%></I><br>

</body>
</html>
