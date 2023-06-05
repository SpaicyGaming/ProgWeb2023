function displayPersonalData(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "personalData.jsp", true);
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
    xhttp.open("GET", "activitySubscribeTool.jsp", true);
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