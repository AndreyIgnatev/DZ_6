<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artemkropotov
  Date: 27.03.2022
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>

<form:form action="create" modelAttribute="product">
    Product title: <form:input path="title" type="text" />
    <br>
    Cost: <form:input path="cost" type="number"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
