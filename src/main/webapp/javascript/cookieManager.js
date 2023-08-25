function allowCookies() {
    manageCookies(true);
}

function denyCookies() {
    manageCookies(false);
}

function manageCookies(isAllow) {
    let strChoice = "";

    if (isAllow) {
        strChoice = "allow";
    } else {
        strChoice = "deny";
    }

    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", encodeMyURL("CookieServlet"), true);
    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhttp.responseType = "text";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            //window.alert("la chiamata ajax dovrebbe aver funzionato"+this.response);
            //let quote = JSON.parse(this.response);
            window.alert(this.response);
            if (this.response === "success") {
                document.getElementById("cb1").style.display = "none";
            }
        }
    }
    xhttp.send("choice=" + strChoice);
}

function encodeMyURL(path) {
    let url = window.location.href;
    let startAt = -1;
    for (let i = 0; i < url.length; i++) {
        if (url[i] === ';') {
            startAt = i;
        }
    }

    if (startAt > -1) {
        return path + url.substring(startAt, url.length);
    } else {
        return path;
    }
}