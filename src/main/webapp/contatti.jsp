<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 03/06/2023
  Time: 18:28
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
    </head>
    <body>
        <jsp:include page="intestazione.jsp" />

        <form action="mailto:tum4world@nessunonoluogonoesiste.com" method="post" enctype="text/plain">
            <label for="nomeCognome">Inserire nome e cognome:</label>
            <input type="text" id="nomeCognome" name="nomeCognome" required>

            <label for="Email">Inserire il proprio indirizzo email per essere ricontattati:</label>
            <input type="email" id="Email" name="Email" required>

            <label for="motivazione">Inserire il motivo:</label>
            <select name="motivazione" id="motivazione" required>
                <option value="OpzioneA">OpzioneA</option>
                <option value="OpzioneB">OpzioneB</option>
                <option value="OpzioneC">OpzioneC</option>
                <option value="Altro">Altro</option>
            </select>

            <label for="specifico">Spiegare il problema:</label>
            <textarea id="specifico" name="specifico" rows="4" cols="50"></textarea>


            <input type="submit" name="submission" value="Invia" style="margin-top: 25px; margin-bottom: 3px;">
            <input type="reset" name="reset" value="Resetta i campi" style="margin-top: 15px; margin-bottom: 3px;">
        </form>

        <jsp:include page="footer.jsp" />
    </body>
</html>
