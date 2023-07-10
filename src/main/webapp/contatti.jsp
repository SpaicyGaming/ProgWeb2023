<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 03/06/2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="icon" href="logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
    <%@ include file="intestazione.html" %>

    <form action="mailto:admin@admin.com" method="post" enctype="text/plain">
        <label for="nomeCognome">Inserire nome e cognome:</label><br>
        <input type="text" id="nomeCognome" name="nomeCognome" required><br><br>

        <label for="Email">Inserire il proprio indirizzo email per essere ricontattati:</label><br>
        <input type="email" id="Email" name="Email" required><br><br>

        <label for="motivazione">Inserire il motivo:</label>
        <select name="motivazione" id="motivazione" required>
            <option value="OpzioneA">OpzioneA</option>
            <option value="OpzioneB">OpzioneB</option>
            <option value="OpzioneC">OpzioneC</option>
            <option value="Altro">Altro</option>
        </select><br><br>

        <label for="specifico">Spiegare il problema:</label><br>
        <textarea id="specifico" name="specifico" rows="4" cols="50"></textarea><br><br>


        <input type="submit" name="submission" value="Invia"><br>
        <input type="reset" name="reset" value="Resetta i campi"><br>
    </form>

    <%@ include file="footer.html" %>
</body>
</html>
