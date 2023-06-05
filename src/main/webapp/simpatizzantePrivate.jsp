<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="intestazionePrivate.html" %>
    <script src="./javascript/privateSideScripts.js"></script>
    <div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
        <button onclick="displayPersonalData()" style="display: inline">visualizza i dati personali</button>
        <button onclick="activitySubscribeTool()" style="display: inline">iscriviti a un'attività</button>
        <a href="DeleteProfileServlet"><button style="display: inline">elimina profilo</button></a>
    </div>
    <div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div>

<%@ include file="footer.html" %>
</body>
</html>
