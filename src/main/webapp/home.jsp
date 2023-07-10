<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <title>Tum4World</title>
        <link rel="icon" href="logo.png">
        <meta charset="UTF-8"/>
        <style>
            .container {
                display: flex;
                align-items: center;
            }

            .image {
                width: 200px;
                margin-right: 20px;
            }

            .content {
                display: flex;
                flex-direction: column;
            }

            <!--
            .logo {
                width: 50px;
                margin-bottom: 10px;
            }
            -->

            .description {
                margin-bottom: 10px;
            }

            .button {
                padding: 10px 20px;
                background-color: #333;
                color: #fff;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%@ include file="intestazione.html" %>

        <div class="container">
            <img class="image" src="imgDescrittiva.jpg" alt="Immagine" style="width: 25%">

            <div class="content">
                <img src="logo.png" style="padding-bottom: 5%; padding-left: 3%; width: 20%; height: auto; align-content: center;">

                <p class="description">Benvenuti nella grande famiglia di Tum4World, impegnata a fornire istruzione di qualità ai bambini dei paesi meno sviluppati.
                    Collaboriamo con comunità locali, insegnanti e scuole per creare programmi personalizzati. Utilizziamo tecnologie accessibili e risorse digitali per raggiungere anche le zone remote.
                    Promuoviamo valori come l'empatia e l'ambiente attraverso attività extracurriculari. Il nostro obiettivo è creare un impatto duraturo coinvolgendo le famiglie e gli stakeholder locali.
                    Unisciti a noi nella nostra missione di trasformare la vita dei bambini attraverso l'istruzione.</p>

                <a href="volantino.pdf" download style="padding-top: 2%; padding-left: 3%">
                    <button>Scarica il volantino</button>
                </a>

            </div>
        </div>

        <%@ include file="footer.html" %>

    </body>
</html>