<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("cookiesEnabled") == null) {
%>

<script src="./javascript/cookieManager.js"></script>
<div class="cookieBanner" id="cb1"
     style="position: fixed; bottom: 5vh; left: 0; width: 100%; padding: 15px; background-color: #f5f5f5">
    <p style="padding-left: 1%">
        Questo sito utilizza i cookie per migliorare l'esperienza di navigazione.
    </p>

    <form method="post" action="CookieServlet" style="padding-top: 1%; float: left; padding-left: 2%">
        <div>
            <div style="float: left">
                <input type="submit" value="Accetta" name="choice">
                <input type="submit" value="Rifiuta" name="choice">
            </div>
        </div>
    </form>
</div>
<%
    }
%>

<div class="footer">
    <p>
        Tum4World | Via Sommarive, 9, 30000 Povo,Trento (TN), Italia
    </p>
</div>
