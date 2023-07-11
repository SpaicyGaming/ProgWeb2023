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
        <link rel="icon" href="logo.png">
        <meta charset="UTF-8"/>
    </head>
    <body>
        <jsp:include page="intestazione.jsp" />
        <jsp:useBean id="errorMessage" class="it.unitn.progweb.g30.progweb2023.ErrorMessageBean" scope="request"/>

        <form method="POST" action="<%=response.encodeURL("SignUpServlet")%>">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>

            <label for="cognome">Cognome:</label>
            <input type="text" id="cognome" name="cognome" required>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required> <%=errorMessage%>

            <label for="bd">Data di nascita:</label>
            <input type="date" id="bd" name="bd" required>

            <label for="mail">Email:</label>
            <input type="email" id="mail" name="mail" required>

            <label for="numeroDiTelefono">Recapito telefonico:</label>
            <input type="tel" id="numeroDiTelefono" name="numeroDiTelefono" required>

            <div style="padding-top: 2%; padding-bottom: 2%">
                <div>
                    <input type="radio" id="simpatizzante" name="userType" value="simpatizzante" checked required>
                    <label for="simpatizzante">Simpatizzante</label>
                </div>
                <div>
                    <input type="radio" id="aderente" name="userType" value="aderente" required >
                    <label for="aderente">Aderente</label>
                </div>
            </div>


            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confermaPassword">Conferma password:</label>
            <input type="password" id="confermaPassword" name="confermaPassword" required>

            <input type="submit" value="Submit" style="margin-top: 15px; margin-bottom: 3px;">
            <input type="reset" style="margin-top: 15px; margin-bottom: 10vh;">
        </form>

        <jsp:include page="footer.jsp" />
    </body>
</html>
