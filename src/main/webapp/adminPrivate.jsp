<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tum4World</title>
    <link rel="icon" href="logo.png">
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="adminstyle.css">
</head>
<body>
<jsp:include page="intestazionePrivate.jsp" />
<script src="./javascript/adminScripts.js"></script>
<div class="maintext">
<div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
    <button onclick="displayAllUsers()" style="display: inline">visualizza tutti gli utenti</button>
    <button onclick="displayAllSimpatizzanti()" style="display: inline">visualizza tutti i simpatizzanti</button>
    <button onclick="displayAllAderenti()" style="display: inline">visualizza tutti gli aderenti</button>
    <button onclick="displayViews()" style="display: inline">visualizza le visualizzazioni per pagina</button>
    <button onclick="displayDonations()" style="display: inline">visualizza le donazioni mensili</button>
</div>
<div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div></div>

<jsp:include page="footer.jsp" />
</body>
</html>
