<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tum4World</title>
        <link rel="icon" href="logo.png">
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%@ include file="intestazione.html" %>
    <div class="maintext">
        <h1>Home Page</h1>
        <p>qui ci andranno:</p>
        <ul>
            <li>logo: <img src="logo.png" width="5%" height="5%"/></li>

            <li>Benvenuti nella grande famiglia di Tum4World, impegnata a fornire istruzione di qualità ai bambini dei paesi meno sviluppati.
                Collaboriamo con comunità locali, insegnanti e scuole per creare programmi personalizzati. Utilizziamo tecnologie accessibili e risorse digitali per raggiungere anche le zone remote.
                Promuoviamo valori come l'empatia e l'ambiente attraverso attività extracurriculari. Il nostro obiettivo è creare un impatto duraturo coinvolgendo le famiglie e gli stakeholder locali.
                Unisciti a noi nella nostra missione di trasformare la vita dei bambini attraverso l'istruzione.</li>
            <li>pulsante per scaricare il volantino:
            <a href="volantino.pdf" download>
                <button>Scarica il volantino</button>
            </a>
            </li>
            <li>immagine rappresentativa dell'associazione</li>
        </ul>
    </div>

        <%@ include file="footer.html" %>

    </body>
</html>
