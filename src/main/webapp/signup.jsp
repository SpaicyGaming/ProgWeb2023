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
    <script>
        function validateForm() {
            let x = new Date(document.getElementById("bdinput").value);
            let now = new Date(Date.now());
            now.setFullYear(now.getFullYear()-18);
            if (now.getTime() < x.getTime()) {
                document.getElementById("bddiv").innerHTML = "Non puoi iscriverti: non sei maggiorenne";
                return false;
            }else document.getElementById("bddiv").innerHTML = "";


            let a = document.getElementById("password").value;
            let b = document.getElementById("confermaPassword").value;
            if (a.length < 8) {
                document.getElementById("pass").innerHTML = "La password scelta non ha almeno 8 caratteri";
                return false;
            }else document.getElementById("pass").innerHTML = "";

            if (a != b) {
                document.getElementById("pass").innerHTML = "Le due password non coincidono";
                return false;
            }else document.getElementById("pass").innerHTML = "";

            let lower=false;
            let upper=false;
            let special=false //special tra $!?

            lower = /[a-z]/.test(a);
            upper = /[A-Z]/.test(a);
            special = /[$!?]/.test(a);
            if (! (lower && upper && special)) {
                document.getElementById("pass").innerHTML = "Bisogna avere nella password almeno una maiuscola, minuscola e uno tra $!?";
                return false;
            }else document.getElementById("pass").innerHTML = "";

            return true;
        }
    </script>
    </head>
    <body>
        <jsp:include page="intestazione.jsp" />
        <jsp:useBean id="errorMessage" class="it.unitn.progweb.g30.progweb2023.ErrorMessageBean" scope="request"/>

<form name="signUpForm" method="POST" action="<%=response.encodeURL("SignUpServlet")%>" onsubmit="return validateForm();">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required> <%=errorMessage%>

        <div id="bddiv" style="color: red; font-size: medium;"></div>
        <label for="bdinput">Data di nascita:</label>
        <input type="date" id="bdinput" name="bdinput" required>

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


            <div id="pass" style="color: red; font-size: medium;"></div>
          <label for="password">password:</label>
          <input type="password" id="password" name="password" required>

          <label for="confermaPassword">conferma password:</label>
          <input type="password" id="confermaPassword" name="confermaPassword" required>

            <input type="submit" value="Submit" style="margin-top: 15px; margin-bottom: 3px;">
            <input type="reset" style="margin-top: 15px; margin-bottom: 10vh;">
        </form>

        <jsp:include page="footer.jsp" />
    </body>
</html>
