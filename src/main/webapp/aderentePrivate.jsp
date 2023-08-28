<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style/aderentestyle.css">
    <title>Tum4World</title>
    <link rel="icon" href="images/logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
<jsp:include page="intestazionePrivate.jsp"/>
<script src="./javascript/privateSideScripts.js"></script>
<script src="./javascript/donationScript.js"></script>
<div class="maintext">
    <div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
        <button onclick="displayPersonalData()" style="display: inline">Visualizza i dati personali</button>
        <button onclick="activitySubscribeTool()" style="display: inline">Iscriviti a un'attività</button>
        <a href="<%=response.encodeURL("DeleteProfileServlet")%>">
            <button style="display: inline">Elimina profilo</button>
        </a>
        <button onclick="donationTool()" style="display: inline">Dona alla causa</button>
    </div>
    <div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
