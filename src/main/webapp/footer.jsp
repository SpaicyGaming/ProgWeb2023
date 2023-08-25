<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 11/07/2023
  Time: 05:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (((Boolean) session.getAttribute("isSessionNew")).booleanValue()) {
%>

<!--<script src="./javascript/cookieManager.js"></script>-->
<div class="cookieBanner" id="cb1"
     style="position: fixed; bottom: 5vh; left: 0; width: 100%; padding: 15px; background-color: #f5f5f5">
    <p style="padding-left: 1%">Il sito non utilizza cookies al di fuori di jsessionid, che viene utilizzato per tenere
        traccia della sessione.
        Il sito supporta la navigazione anche con i cookies disabilitati</p>
    <!--
    <button onclick="allowCookies()">Allow</button>
    <button onclick="denyCookies()">Deny</button>
    -->
    <!--
    <form method="post" action="CookieServlet" style="padding-top: 1%; float: left; padding-left: 2%">
        <div>
            <div style="float: left">
                <input type="submit" value="Accetta" name="choice">
            </div>
            <div style="padding-top: 1%">
                <input type="submit" value="Rifiuta" name="choice">
            </div>
        </div>
    </form>
    -->
</div>
<%
    }
%>

<div class="footer">
    <p>
        Tum4World | Via Sommarive, 9, 30000 Povo,Trento (TN), Italia
    </p>
</div>
