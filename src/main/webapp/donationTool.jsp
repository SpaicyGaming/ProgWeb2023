<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="POST" action="<%=response.encodeURL("DonationServlet")%>">
    <div style="padding-top: 3%">
        <label for="importo">Inserisci l'importo che vuoi donare</label>
        <input id="importo" name="importo" type="number" required>
        <input type="submit" value="dona">
    </div>
</form>
