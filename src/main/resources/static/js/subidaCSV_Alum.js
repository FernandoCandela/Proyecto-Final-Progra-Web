function leerCsv(e) {
    var file = document.getElementById('file-input').files[0];
    console.log(file);
    if (!file) {
        return;
    }
    var reader = new FileReader();
    reader.onload = function (e) {
        var contents = e.target.result;
        enviarAlServer(contents);
    };
    reader.readAsText(file);
}

function enviarAlServer(contents) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            console.log(xhr.responseText)
        }
    };
    xhr.open('POST', BASE_URL + '/leerArchivoAlumn', false);
    xhr.send(contents);
    window.location.reload();
    ;
}

document.getElementById('btnSubirData')
        .addEventListener('click', leerCsv, false);