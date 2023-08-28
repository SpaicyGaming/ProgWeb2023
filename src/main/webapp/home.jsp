<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <title>Tum4World</title>
    <link rel="icon" href="images/logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
<jsp:include page="intestazione.jsp"/>

<div class="home-container">
    <img class="home-image" src="images/imgDescrittiva.jpg" alt="Immagine bambini locali" style="width: 25%">

    <div class="home-content">
        <img src="images/logo.png"  alt="Logo Tum4World"
             style="padding-bottom: 5%; padding-left: 3%; width: 20%; height: auto; align-content: center;">

        <p class="home-description">Benvenuti nella grande famiglia di Tum4World, impegnata a fornire istruzione di qualità
            ai bambini dei paesi meno sviluppati.
            Collaboriamo con comunità locali, insegnanti e scuole per creare programmi personalizzati. Utilizziamo
            tecnologie accessibili e risorse digitali per raggiungere anche le zone remote.
            Promuoviamo valori come l'empatia e l'ambiente attraverso attività extracurriculari. Il nostro obiettivo è
            creare un impatto duraturo coinvolgendo le famiglie e gli stakeholder locali.
            Unisciti a noi nella nostra missione di trasformare la vita dei bambini attraverso l'istruzione.</p>

        <a href="volantino.pdf" download style="padding-top: 2%; padding-left: 3%">
            <button>Scarica il volantino</button>
        </a>

    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>