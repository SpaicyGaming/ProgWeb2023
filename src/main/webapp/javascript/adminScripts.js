function removeById(_id) {
    var e = document.getElementById(_id);
    if (e !== null) e.innerHTML = '';
}

function addUsersTable(users) {
    // var table = document.createElement("TABLE");
    var table = document.getElementById("resultTable");
    var rowCount = table.rows.length;
    for (var rowCounter = 1; rowCounter < rowCount; rowCounter++) {
        table.deleteRow(1);
    }
    // document.body.appendChild(table);

    if (rowCount < 1) {
        var headerRow = document.createElement("TR");

        var idCellHeader = document.createElement("TD");
        var usernameCellHeader = document.createElement("TD");
        var mailCellHeader = document.createElement("TD");
        var nomeCellHeader = document.createElement("TD");
        var cognomeCellHeader = document.createElement("TD");
        var bdCellHeader = document.createElement("TD");
        var phoneNumberCellHeader = document.createElement("TD");

        headerRow.appendChild(idCellHeader);
        headerRow.appendChild(usernameCellHeader);
        headerRow.appendChild(mailCellHeader);
        headerRow.appendChild(nomeCellHeader);
        headerRow.appendChild(cognomeCellHeader);
        headerRow.appendChild(bdCellHeader);
        headerRow.appendChild(phoneNumberCellHeader);

        var idHeader = document.createTextNode("ID");
        var usernameHeader = document.createTextNode("USERNAME");
        var mailHeader = document.createTextNode("EMAIL");
        var nomeHeader = document.createTextNode("NOME");
        var cognomeHeader = document.createTextNode("COGNOME");
        var bdHeader = document.createTextNode("DATA DI NASCITA");
        var phoneNumberHeader = document.createTextNode("NUMERO DI TELEFONO");

        idCellHeader.appendChild(idHeader);
        usernameCellHeader.appendChild(usernameHeader);
        mailCellHeader.appendChild(mailHeader);
        nomeCellHeader.appendChild(nomeHeader);
        cognomeCellHeader.appendChild(cognomeHeader);
        bdCellHeader.appendChild(bdHeader);
        phoneNumberCellHeader.appendChild(phoneNumberHeader);

        table.appendChild(headerRow);
        document.body.appendChild(document.createElement('hr'));
    }

    for (var i = 0; i < users.length; i++) {
        var user = JSON.parse(users[i]);
        var row = document.createElement("TR");

        var idCell = document.createElement("TD");
        var usernameCell = document.createElement("TD");
        var mailCell = document.createElement("TD");
        var nomeCell = document.createElement("TD");
        var cognomeCell = document.createElement("TD");
        var bdCell = document.createElement("TD");
        var phoneNumberCell = document.createElement("TD");

        row.appendChild(idCell);
        row.appendChild(usernameCell);
        row.appendChild(mailCell);
        row.appendChild(nomeCell);
        row.appendChild(cognomeCell);
        row.appendChild(bdCell);
        row.appendChild(phoneNumberCell);

        var id = document.createTextNode(user["id"]);
        var username = document.createTextNode(user.username);
        var mail = document.createTextNode(user.mail);
        var nome = document.createTextNode(user.nome);
        var cognome = document.createTextNode(user.cognome);
        var bd = document.createTextNode(user.bd);
        var phoneNumber = document.createTextNode(user.phoneNumber);

        idCell.appendChild(id);
        usernameCell.appendChild(username);
        mailCell.appendChild(mail);
        nomeCell.appendChild(nome);
        cognomeCell.appendChild(cognome);
        bdCell.appendChild(bd);
        phoneNumberCell.appendChild(phoneNumber);

        table.appendChild(row);
        document.body.appendChild(document.createElement('hr'));
    }
}

function displayAllUsers() {
    removeById("resultContainer");
    removeById("graphDiv");
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllUsersServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            addUsersTable(this.response)
        }
    }
    xhttp.send();
}

function displayAllSimpatizzanti() {
    removeById("resultContainer");
    removeById("graphDiv");
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllSimpatizzantiServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            addUsersTable(this.response)
        }
    }
    xhttp.send();
}

function displayAllAderenti() {
    removeById("resultContainer");
    removeById("graphDiv");
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetAllAderentiServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            addUsersTable(this.response)
        }
    }
    xhttp.send();
}

function displayViews() {
    removeById("resultTable");
    document.getElementById("resultContainer").innerHTML = "Loading...";
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetViewsServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var views = JSON.parse(JSON.stringify(this.response));

            const options = {
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'Visualizzazioni Totali: '
                },
                xAxis: {
                    categories: ['Pagina']
                },
                yAxis: {
                    title: {
                        text: 'Visualizzazioni'
                    }
                },
                series: []
            }

            var totalViews = 0;
            for (let i = 0; i < views.length; i++) {
                var view = JSON.parse(views[i]);
                totalViews += view['views'];
                options.series.push({
                    name: view['page'],
                    data: [view['views']]
                })
            }
            options.title.text += totalViews;

            let link = document.createElement("a");
            let btn = document.createElement("button");
            link.setAttribute("href", encodeMyURL("ResetViewsServlet"));
            link.appendChild(btn);
            btn.innerText = "reset visualizzazioni";
            let btnDiv = document.createElement("div");
            let rc = document.getElementById("resultContainer");
            rc.innerHTML = '';
            rc.appendChild(btnDiv);
            btnDiv.appendChild(link);

            new Highcharts.Chart('graphDiv', options);
        }
    }
    xhttp.send();
}

function displayDonations() {
    removeById("resultContainer");
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", encodeMyURL("GetDonationsServlet"), true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var donations = JSON.parse(JSON.stringify(this.response));
            const options = {
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'Donazioni Ricevute'
                },
                xAxis: {
                    categories: ['Mese']
                },
                yAxis: {
                    title: {
                        text: 'Importo'
                    }
                },
                series: []
            }

            var monthlyDonations = [];
            for (let i = 1; i <= 12; i++) {
                monthlyDonations[i] = 0;
            }

            for (let i = 0; i < donations.length; i++) {
                var donation = JSON.parse(donations[i]);
                var date = donation['data'];
                const currentYear = new Date(Date.now()).getFullYear()
                var dateSplit = date.split('-');
                if (dateSplit[0] === currentYear.toString()) {
                    var month = parseInt(dateSplit[1]);
                    monthlyDonations[month] += donation['importo'];
                }
            }

            for (let i = 1; i <= 12; i++) {
                options.series.push({
                    name: i,
                    data: [monthlyDonations[i], 10000]
                })
            }

            new Highcharts.Chart('graphDiv', options);
        }
    }
    xhttp.send();
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