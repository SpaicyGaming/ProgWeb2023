function displayAllUsers(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllUsersServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            document.getElementById("resultContainer").innerHTML = this.response;
        }
    }
    xhttp.send();
}

function displayAllSimpatizzanti(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllSimpatizzantiServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            document.getElementById("resultContainer").innerHTML = this.response;
        }
    }
    xhttp.send();
}

function displayAllAderenti(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllAderentiServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            document.getElementById("resultContainer").innerHTML = this.response;
        }
    }
    xhttp.send();
}

function displayViews(){
    document.getElementById("resultContainer").innerHTML = "Loading...";
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetViewsServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            let link = document.createElement("a");
            let btn = document.createElement("button");
            link.setAttribute("href", encodeMyURL("ResetViewsServlet"));
            link.appendChild(btn);
            btn.innerText = "reset";
            let btnDiv = document.createElement("div");
            let dataDiv = document.createElement("div");
            let rc = document.getElementById("resultContainer");
            rc.innerHTML = '';
            /*
            while (rc.firstChild) {
                rc.removeChild(rc.lastChild);
            }
            */
            rc.appendChild(btnDiv);
            rc.appendChild(dataDiv);
            btnDiv.appendChild(link);
            dataDiv.innerHTML = this.response;
        }
    }
    xhttp.send();
}

function displayDonations(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetDonationsServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            document.getElementById("resultContainer").innerHTML = this.response;
        }
    }
    xhttp.send();
}

function encodeMyURL(path){
    let url = window.location.href;
    let startAt = -1;
    for(let i = 0; i < url.length; i++){
        if(url[i] === ';'){
            startAt = i;
        }
    }

    if(startAt > -1) {
        return path + url.substring(startAt, url.length);
    }else{
        return path;
    }
}