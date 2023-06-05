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

    <form method="POST" action="SignUpServlet">
        <label for="nome">nome:</label><br>
        <input type="text" id="nome" name="nome" required><br><br>

        <label for="cognome">cognome:</label><br>
        <input type="text" id="cognome" name="cognome" required><br><br>

        <label for="username">username:</label><br>
        <input type="text" id="username" name="username" required> <%=errorMessage%> <br><br>

        <label for="bd">data di nascita:</label><br>
        <input type="date" id="bd" name="bd" required><br><br>

        <label for="mail">email:</label><br>
        <input type="email" id="mail" name="mail" required><br><br>

        <label for="numeroDiTelefono">Enter your phone number:</label><br>
        <input type="tel" id="numeroDiTelefono" name="numeroDiTelefono" required><br><br>

        <input type="radio" id="simpatizzante" name="userType" value="simpatizzante" checked required>
        <label for="simpatizzante">simpatizzante</label><br>

        <input type="radio" id="aderente" name="userType" value="aderente" required>
        <label for="aderente">aderente</label><br><br>

        <label for="password">password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <label for="confermaPassword">conferma password:</label><br>
        <input type="password" id="confermaPassword" name="confermaPassword" required><br><br>

        <input type="submit" value="submit"><br>
        <input type="reset"><br>
    </form>

    <%@ include file="footer.html" %>
</body>
</html>
