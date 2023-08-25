<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 03/06/2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Tum4World</title>
    <link rel="icon" href="images/logo.png">
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="intestazione.jsp"/>
<jsp:useBean id="errorMessage" class="it.unitn.progweb.g30.progweb2023.ErrorMessageBean" scope="request"/>
<div class="maintext">
    <form method="POST" action="<%=response.encodeURL("LoginServlet")%>">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <%=errorMessage%>

        <input type="submit" value="Entra" style="margin-top: 15px; margin-bottom: 3px;">
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
