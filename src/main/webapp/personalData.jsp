<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="loggedUser" class="it.unitn.progweb.g30.progweb2023.User" scope="session"/>
<ul>
    <li>nome: <%=loggedUser.getNome()%>
    </li>
    <li>cognome: <%=loggedUser.getCognome()%>
    </li>
    <li>username: <%=loggedUser.getUsername()%>
    </li>
    <li>data di nascita: <%=loggedUser.getBd()%>
    </li>
    <li>mail: <%=loggedUser.getMail()%>
    </li>
    <li>numero di telefono: <%=loggedUser.getPhoneNumber()%>
    </li>
    <li>tipo di utente: <%=loggedUser.getUserType().toString()%>
    </li>
    <li>password: <%=loggedUser.getPassword()%>
    </li>
</ul>