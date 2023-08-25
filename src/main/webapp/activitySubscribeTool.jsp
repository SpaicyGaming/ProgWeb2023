<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loggedUser" class="it.unitn.progweb.g30.progweb2023.User" scope="session"/>
<form method="POST" action="<%=response.encodeURL("IscrivitiAttivitaServlet")%>">
    <div style="padding-top: 3%">
        <input id="a1submit" name="attivita" type="submit" value="Centri di apprendimento">

        <input id="a2submit" name="attivita" type="submit" value="Donazione materiale scolastico">

        <input id="a3submit" name="attivita" type="submit" value="Collaborazione con le scuole">
    </div>
</form>