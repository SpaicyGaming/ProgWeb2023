<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tum4World</title>
        <link rel="icon" href="logo.png">
        <meta charset="UTF-8"/>
    </head>
    <body>
        <%@ include file="intestazione.html" %>

        <h1>Home Page</h1>
        <p>qui ci andranno:</p>
        <ul>
            <li>logo: <img src="logo.png" width="5%" height="5%"/></li>

            <li>testo descrittivo</li>
            <li>pulsante per scaricare il volantino:
            <a href="volantino.pdf" download>
                <button>Scarica il volantino</button>
            </a>
            </li>
            <li>immagine rappresentativa dell'associazione</li>
        </ul>


        <%@ include file="footer.html" %>

    </body>
</html>