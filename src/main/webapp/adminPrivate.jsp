<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="icon" href="logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
<%@ include file="intestazionePrivate.html" %>
<script src="./javascript/adminScripts.js"></script>
<div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
    <button onclick="displayAllUsers()" style="display: inline">visualizza tutti gli utenti</button>
    <button onclick="displayAllSimpatizzanti()" style="display: inline">visualizza tutti i simpatizzanti</button>
    <button onclick="displayAllAderenti()" style="display: inline">visualizza tutti gli aderenti</button>
    <button onclick="displayViews()" style="display: inline">visualizza le visualizzazioni per pagina</button>
    <button onclick="displayDonations()" style="display: inline">visualizza le donazioni mensili</button>
</div>
<div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div>

<%@ include file="footer.html" %>
</body>
</html>
