var SystechSkulJsLib = SystechSkulJsLib || {};

SystechSkulJsLib.showTable = function(){
    var me = this;

    var tableContent = `<table id="customers"><tr><th>Name</th><th>Address</th></tr>`;
    me.data.forEach(row => {
        tableContent += `<tr><td>${row.name}</td><td>${row.address}</td></tr>`;
    });
    tableContent += `</table>`;

    document.getElementById('content').innerHTML = tableContent;

}

SystechSkulJsLib.loadData = function(){
    var me = this;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState == XMLHttpRequest.DONE){
            if (xhr.status == 200){
               SystechSkulJsLib.data = eval('(' + xhr.responseText + ')');
               SystechSkulJsLib.showTable();
            }
        }
    }

    xhr.open('get', me.dataUrl, true);
    xhr.send();

}

