<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 03/06/2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="intestazione.html" %>
<jsp:useBean id="errorMessage" class="it.unitn.progweb.g30.progweb2023.ErrorMessageBean" scope="request"/>

<form method="POST" action="LoginServlet">
    <label for="username">username:</label><br>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">password:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <%=errorMessage%>

    <input type="submit" value="submit"><br>
</form>

<%@ include file="footer.html" %>
</body>
</html>
