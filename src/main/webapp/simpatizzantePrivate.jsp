<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="icon" href="logo.png">
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="simpatizzantestyle.css">
    
</head>
<body>
<jsp:include page="intestazionePrivate.jsp" />
    <script src="./javascript/privateSideScripts.js"></script>
<div class="maintext">
    <div id="buttonContainer" class="bc" style="margin: auto; text-align:center">
        <button onclick="displayPersonalData()" style="display: inline">visualizza i dati personali</button>
        <button onclick="activitySubscribeTool()" style="display: inline">iscriviti a un'attività</button>
        <a href="<%=response.encodeURL("DeleteProfileServlet")%>"><button style="display: inline">elimina profilo</button></a>
    </div>
    <div id="resultContainer" class="rc" style="margin: auto; text-align: center"></div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
