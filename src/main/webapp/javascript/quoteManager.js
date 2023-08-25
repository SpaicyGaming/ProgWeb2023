let updateQuote = function () {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "GetRandomQuote", true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            //window.alert("la chiamata ajax dovrebbe aver funzionato"+this.response);
            //let quote = JSON.parse(this.response);
            document.getElementById("quoteBox").innerHTML = this.response;
        }
    }
    xhttp.send();
}

setInterval(updateQuote, 20000);
//setInterval(function(){window.alert("setInterval funziona")}, 5);

//document.getElementById("quoteBox").innerHTML = "javascript funziona";

updateQuote();

