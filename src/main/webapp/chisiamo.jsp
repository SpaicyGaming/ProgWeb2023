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
    <link rel="icon" href="images/logo.png">
    <meta charset="UTF-8"/>
</head>
<body>
<jsp:include page="intestazione.jsp"/>

<h1 style="padding-top: 2%; padding-left: 3%">Chi è Tum4Wordls ?</h1>
<div style="padding-top: 2%">
    <p class="description">
        Siamo un'organizzazione impegnata a migliorare la vita delle comunità dei paesi meno sviluppati attraverso
        l'educazione dei bambini. Da oltre un decennio, abbiamo lavorato instancabilmente per portare speranza e
        opportunità di apprendimento a coloro che ne hanno bisogno.
    </p>
    <p class="description">
        La nostra storia ha inizio nel 2010, quando un gruppo di individui appassionati si è unito con l'obiettivo
        comune di creare un impatto duraturo nelle comunità svantaggiate. Abbiamo iniziato con piccoli progetti
        educativi locali e, col passare del tempo, siamo cresciuti ed estesi le nostre operazioni.
    </p>
    <p class="description">
        Oggi, abbiamo sedi in diverse parti del mondo, dalle zone rurali alle comunità urbane, dove collaboriamo a
        stretto contatto con le scuole locali, gli insegnanti e le famiglie. Questa stretta collaborazione ci permette
        di comprendere le specifiche sfide e necessità di ogni comunità, consentendoci di creare programmi educativi su
        misura.
    </p>
    <p class="description">
        Riconosciamo l'importanza di un approccio olistico all'educazione. Oltre all'insegnamento accademico, mettiamo
        l'accento sull'educazione pratica e sulla promozione delle competenze vitali, come la creatività, la
        collaborazione e la leadership. Utilizziamo risorse digitali e tecnologie accessibili per raggiungere anche le
        comunità più remote, offrendo opportunità di apprendimento a bambini che altrimenti non avrebbero accesso a
        un'istruzione di qualità.
    </p>
    <p class="description">
        Negli anni, la nostra associazione ha ricevuto riconoscimenti per il nostro impegno nel campo dell'educazione.
        Questi riconoscimenti ci spronano a continuare a fare la differenza nella vita dei bambini e delle loro
        comunità.
    </p>
    <p class="description">
        Tuttavia, l'aspetto più gratificante del nostro lavoro è vedere i sorrisi e la speranza nei volti dei bambini
        che beneficiano dei nostri programmi. Siamo fermamente convinti che l'educazione possa trasformare le vite e, di
        conseguenza, stiamo costruendo un futuro più luminoso per tutti.
    </p>
    <p class="description">
        La nostra associazione è aperta a tutti coloro che condividono la nostra visione e vogliono contribuire a
        portare luce e speranza nelle comunità più bisognose. Unisciti a noi in questa missione di dare alle future
        generazioni il dono dell'educazione e costruire insieme un mondo migliore.
    </p>
</div>

<div style="padding-left: 2%; padding-top: 3%">
    <div class="image-container">
        <img src="images/img1.jpg">
    </div>
    <div class="image-container">
        <img src="images/img2.jpg">
    </div>
    <div class="image-container">
        <img src="images/img3.jpg">
    </div>
    <div class="image-container">
        <img src="images/img4.jpg">
    </div>
    <div class="image-container">
        <img src="images/img5.jpg">
    </div>
    <div class="image-container">
        <img src="images/img6.jpg">
    </div>
</div>

<style>
    .image-container {
        display: inline-block;
        text-align: center;
        vertical-align: top;
        width: 15vw;
        padding: 1vw;
        box-sizing: border-box;
    }

    .image-container img {
        max-width: 100%;
        height: auto;
    }
</style>

<jsp:include page="footer.jsp"/>
</body>
</html>
