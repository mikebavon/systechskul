var SystechSkulJsLib = SystechSkulJsLib || {};

SystechSkulJsLib.showGrid = function(){
    var me = this;

    var xhr = new XMLHttpRequest();

    var requestResponse = [];
    xhr.onreadystatechange = function(){
        if (xhr.readyState == XMLHttpRequest.DONE){
            if (xhr.status == 200){
                requestResponse = eval('(' + xhr.responseText + ')');

            }
        }
    }

    xhr.open('get', me.dataUrl, false);
    xhr.send();

    me.gridData = requestResponse;

    var tableContent = ``;
    me.gridButtons.forEach(button => {
        tableContent += `<button class="button ${button.cssClass}" id="${button.id}">${button.label}</button>`;
    });

   tableContent += `<br/><table class='${me.gridStyle}'><tr>`;

    me.gridColumns.forEach(col => {
        tableContent += `<th>${col.header}</th>`;
    });
    tableContent += `<th></th><th></th>`;

    tableContent += `</tr>`;

    var actionEvents = [];

    me.gridData.forEach(row => {

        tableContent += `<tr>`;

        me.gridColumns.forEach(col => {
            tableContent += `<td>${row[col.dataIndex]}</td>`;
        });

        var editBtnId = me.componentId + '-edit-' + row.id;
        var deleteBtnId = me.componentId + '-del-' + row.id;

        tableContent += `<td><button class="button editButton" id="${editBtnId}">Edit</button></td>`
            + `<td><button class="button deleteButton" id="${deleteBtnId}">Delete</button></td>`;

        tableContent += `</tr>`;

        actionEvents.push({editBtnId: editBtnId, deleteBtnId: deleteBtnId, recordId: row.id});

    });

    tableContent += `</table>`;

    document.getElementById('module-content').innerHTML = tableContent;

    me.gridButtons.forEach(button => {
        if (button.handler == 'addButton')
            document.getElementById(button.id).addEventListener('click', function(){
                SystechSkulJsLib.Form.call(me);
            });

    });

    actionEvents.forEach(button => {

        document.getElementById(button.editBtnId).addEventListener('click', function(){
                alert('We will edit')
        });

        document.getElementById(button.deleteBtnId).addEventListener('click', function(){

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function(){
                    if (xhr.readyState == XMLHttpRequest.DONE){
                        if (xhr.status == 200){
                            console.log(xhr.responseText);
                        }
                    }
                }

                xhr.open('post', me.dataUrl, false);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhr.send("id=" + button.recordId + "&action=delete");

                SystechSkulJsLib.showGrid.call(me);

        });
    });

}

SystechSkulJsLib.Form = function(){
    var me = this;

    var formContent = `<form action="#">`;

    me.formField.forEach(field =>{

        formContent += `<div class="row">`
            + `<div class="col-25">`
                + `<label for="${field.name}">${field.label}</label>`
            + `</div>`
            + `<div class="col-75">`;

        if (field.type == 'select'){
            var selectStore = [];

            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function(){
                if (xhr.readyState == XMLHttpRequest.DONE){
                    if (xhr.status == 200){
                        selectStore = eval('(' + xhr.responseText + ')');
                    }
                }
            }
            xhr.open('get', field.storeModel.url, false);
            xhr.send();

            formContent += `<select id="${field.id}" name="${field.name}">`;
            selectStore.forEach(row => {
                formContent += `<option value="${row[field.storeModel.dataBinding.id]}">${row[field.storeModel.dataBinding.display]}</option>`;
            });

            formContent += `</select>`;

        }else{
            formContent += `<input type="${field.type}" id="${field.id}" name="${field.name}">`
        }

        formContent += `</div>`
            + `</div>`;

    });

    formContent +=  `<div class="row">`
                + `<input type="submit" value="Submit" id="${me.componentId}">`
            + `</div>`
        + ` </form>`;

    document.getElementById('module-content').innerHTML = formContent;

    document.getElementById(me.componentId).addEventListener('click', event => {
        event.preventDefault();

        var formData = '';
        me.formField.forEach(field =>{
            formData += field.name + '=' + document.getElementById(field.id).value + '&';
        });

        var xhr = new XMLHttpRequest();

        var requestResponse = [];
        xhr.onreadystatechange = function(){
            if (xhr.readyState == XMLHttpRequest.DONE){
                if (xhr.status == 200){
                    requestResponse = eval('(' + xhr.responseText + ')');

                }
            }
        }

        console.log(formData);

        xhr.open('post', me.dataUrl, false);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(formData);

        SystechSkulJsLib.showGrid.call(me);

    });
}

