<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 05/06/2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loggedUser" class="it.unitn.progweb.g30.progweb2023.User" scope="session"/>
<form method="POST" action="IscrivitiAttivitaServlet">
    <br><br>
    <input id="a1submit" name="attivita" type="submit" value="centri di apprendimento"><br><br>

    <input id="a2submit" name="attivita" type="submit" value="donazione materiale scolastico"><br><br>

    <input id="a3submit" name="attivita" type="submit" value="collaborazione con le scuole"><br><br>
</form>