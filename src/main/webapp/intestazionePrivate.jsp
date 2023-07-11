<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 11/07/2023
  Time: 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
  <table>
    <tbody>
    <tr>
      <td style="width: 20%;">
        <img src="images/logo.png"/>
        <div>Tum4World</div>
      </td>
      <td style="width: 80%; height: 100%;">
        <ul>
          <li><a href="<%=response.encodeURL("HomeServlet")%>">Home</a></li>
          <li><a href="<%=response.encodeURL("ChiSiamoServlet")%>">Chi siamo</a></li>
          <li><a href="<%=response.encodeURL("AttivitaServlet")%>">Attivit&agrave</a></li>
          <li><a href="<%=response.encodeURL("ContattiServlet")%>">Contatti</a></li>
          <li><a href="<%=response.encodeURL("SignUpServlet")%>">Sign-Up</a></li>
          <li><a href="<%=response.encodeURL("LoginServlet")%>">Login</a></li>
          <li><a href="<%=response.encodeURL("LogoutServlet")%>">Logout</a></li>
        </ul>
      </td>
    </tr>
    </tbody>
  </table>
</div>
<p id="quoteBox"></p>
<script src="./javascript/quoteManager.js"></script>

