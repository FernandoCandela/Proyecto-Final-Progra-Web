   function readSingleFile(e) {
      var file = document.getElementById('file-input').files[0];
      console.log(file)
      if (!file) {
        return;
      }
      var reader = new FileReader();
      reader.onload = function(e) {
        var contents = e.target.result;
        sendDataToServer(contents);
      };
      reader.readAsText(file);
    }

    function sendDataToServer(contents) {
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
          console.log(xhr.responseText)
        }
      };
      xhr.open('POST', BASE_URL + 'read-file', false);
      xhr.send(contents)
    }

    document.getElementById('btnSubirData')
      .addEventListener('click', readSingleFile, false);