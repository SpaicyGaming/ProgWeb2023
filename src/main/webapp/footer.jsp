<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 11/07/2023
  Time: 05:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  if(!((Boolean)session.getAttribute("madeChoiceAboutCookies")).booleanValue()){
%>

<!--<script src="./javascript/cookieManager.js"></script>-->
<div class="cookieBanner" id="cb1">
  Acconsenti all'utilizzo dei cookies? <br>
  <!--
  <button onclick="allowCookies()">Allow</button>
  <button onclick="denyCookies()">Deny</button>
  -->
  <form method="post" action="CookieServlet">
    <input type="submit" value="allow" name="choice">
    <input type="submit" value="deny" name="choice">
  </form>
  <br>
  <br>
  <br>
  <br>
  <br>
</div>
<%
  }
%>

<div class="footer">
  <p>
    Tum4World  |  Via Sommarive, 9, 30000 Povo,Trento (TN), Italia
  </p>
</div>
