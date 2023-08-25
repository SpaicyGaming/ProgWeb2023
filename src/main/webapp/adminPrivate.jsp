<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="WEB-INF/adminstyle.css">
    <title>Tum4World</title>
    <link rel="icon" href="images/logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
<jsp:include page="intestazionePrivate.jsp"/>
<script src="./javascript/adminScripts.js"></script>
<div class="maintext">
    <div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
        <button onclick="displayAllUsers()" style="display: inline">Visualizza tutti gli utenti</button>
        <button onclick="displayAllSimpatizzanti()" style="display: inline">Visualizza tutti i simpatizzanti</button>
        <button onclick="displayAllAderenti()" style="display: inline">Visualizza tutti gli aderenti</button>
        <button onclick="displayViews()" style="display: inline">Visualizza le visualizzazioni per pagina</button>
        <button onclick="displayDonations()" style="display: inline">Visualizza le donazioni mensili</button>
    </div>
    <div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
