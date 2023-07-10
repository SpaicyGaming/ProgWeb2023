<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 03/06/2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <title>Tum4World</title>
        <link rel="icon" href="logo.png">
        <meta charset="UTF-8"/>
    </head>
    <body>
        <%@ include file="intestazione.html" %>

        <style>
            .image-container {
                display: inline-block;
                text-align: center;
                vertical-align: top;
                width: 33%;
                padding: 10px;
                box-sizing: border-box;
            }

            .image-container img {
                max-width: 100%;
                height: auto;
            }

            .image-container figcaption {
                margin-top: 10px;
                font-style: italic;
            }
        </style>

        <div class="image-container">
            <a href="attivita1.html">
                <img src="attivita1.jpg" alt="Attività 1">
            </a>
            <figcaption>
                Creare centri di apprendimento dove i bambini svantaggiati possono ricevere supporto scolastico.
            </figcaption>
        </div>

        <div class="image-container">
            <a href="attivita2.html">
                <img src="attivita2.jpg" alt="Attività 2">
            </a>
            <figcaption>
                Fornire materiale didattico e libri ai bambini provenienti da famiglie a basso reddito.
            </figcaption>
        </div>

        <div class="image-container">
            <a href="attivita3.html">
                <img src="attivita3.jpg" alt="Attività 3">
            </a>
            <figcaption>
                Collaborare con le scuole locali per implementare programmi educativi supplementari e migliorare l'accesso all'istruzione.
            </figcaption>
        </div>


        <%@ include file="footer.html" %>
    </body>
</html>
