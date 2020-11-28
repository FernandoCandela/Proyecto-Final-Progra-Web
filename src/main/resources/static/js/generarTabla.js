function generateTable(datos) {

    var dvTable = document.getElementById("tablaGestion");
    var table = document.createElement("table");
    table.setAttribute('class', 'table table-striped media-body');

    var thead = document.createElement("thead");
    var tr = document.createElement("tr");
    var th1 = document.createElement('th');
    var th2 = document.createElement('th');
    var th3 = document.createElement('th');
    var th4 = document.createElement('th');
    var th5 = document.createElement('th');
    th1.setAttribute("scope", "col");
    th1.textContent = "Código";
    th2.setAttribute("scope", "col");
    th2.textContent = "Nombre";
    th3.setAttribute("scope", "col");
    th3.textContent = "Carrera";
    th4.setAttribute("scope", "col");
    th4.textContent = "Género";
    th5.setAttribute("colspan", "2");
    th5.setAttribute("scope", "col");
    th5.textContent = "Operaciones";

    var tbody = document.createElement('tbody');

    for (let item of datos)
    {
        tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    tr.appendChild(th4);
    tr.appendChild(th5);
    thead.appendChild(tr);

        var trT = document.createElement('tr');
        var code = document.createElement('td');
        code.textContent = item.code;

        var name = document.createElement('td');
        name.textContent = item.names + " " + item.last_names;

        var carrera = document.createElement('td');
        carrera.textContent = item.carrer_name;

        var genero = document.createElement('td');
        genero.textContent = item.garden_name;

        table.appendChild(thead);
        trT.appendChild(code);
        trT.appendChild(name);
        trT.appendChild(carrera);
        trT.appendChild(genero);
        tbody.appendChild(trT);
        table.appendChild(tbody);
        dvTable.appendChild(table);
    }

}

function listarAlumnos() {
    const xhttp = new XMLHttpRequest();
    xhttp.open('GET', BASE_URL + '/api/listarAlumno', true);
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == XMLHttpRequest.DONE) {
            switch (xhttp.status) {
                case 200:
                    generateTable(JSON.parse(xhttp.responseText));
                    break;
            }
        }
    }
    xhttp.send();
}

