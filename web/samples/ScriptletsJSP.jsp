<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Страница с декларациями и скриптлетами</title>
</head>
<body>
    <h1>JSP Страница с декларациями и скриптлетами</h1>
    <h3> Этот пример показывает, как работать с декларациями и скриптлетами</h3>

    <!-- Декларируем переменную count-->
    <%! private int count = 0; %>
    <% String outParameter = request.getParameter("param");
        if (outParameter != null){
            out.println(outParameter);
        } else {
            out.println("Значение параметра не установлено");}%>
    Страница была показана <%= ++count %> раз.
</body>
</html>
