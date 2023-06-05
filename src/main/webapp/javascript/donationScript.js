function donationTool(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "donationTool.jsp", true);
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