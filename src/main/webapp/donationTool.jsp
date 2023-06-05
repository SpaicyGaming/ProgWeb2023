<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 05/06/2023
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="POST" action="DonationServlet">
    <label for="importo">Inserisci l'importo che vuoi donare</label>
    <input id="importo" name="importo" type="number" required><br><br>
    <input type="submit" value="dona">
</form>
