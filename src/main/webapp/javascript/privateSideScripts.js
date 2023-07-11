function displayPersonalData(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("personalData.jsp"), true);
    xhttp.responseType = "text";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            //window.alert("la chiamata ajax dovrebbe aver funzionato"+this.response);
            //let quote = JSON.parse(this.response);
            document.getElementById("resultContainer").innerHTML = this.response;
        }
    }
    xhttp.send();
}

function activitySubscribeTool(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("activitySubscribeTool.jsp"), true);
    xhttp.responseType = "text";
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState === 4 && xhttp.status === 200){
            //window.alert("la chiamata ajax dovrebbe aver funzionato"+this.response);
            //let quote = JSON.parse(this.response);
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