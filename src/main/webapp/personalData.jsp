<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 05/06/2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
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
    <li>tipo di utente: <%=loggedUser.getStringifiedType()%>
    </li>
    <li>password: <%=loggedUser.getPassword()%>
    </li>
</ul>