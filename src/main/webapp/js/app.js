var SystechSkulJsLib = SystechSkulJsLib || {};

//By default show table on clicking the to navbar buttons
SystechSkulJsLib.showGrid = function(){

    /*puts the scope of this in another variable me to avoid confusing,
    basically know the exact this that is being referred to.*/
    var me = this;

    //store for the request response for the data table
    var requestResponse = [];

    //ajax request to load table data from servlet
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState == XMLHttpRequest.DONE){
            if (xhr.status == 200){
                requestResponse = eval('(' + xhr.responseText + ')');
            }
        }
    }

    //its a get method hence calls servlet doGet method
    xhr.open('get', me.dataUrl, false);
    xhr.send();

    //append the ajax response to the current object gridData, that later populates the table
    me.gridData = requestResponse;

    var tableContent = ``;

    //add buttons on top of the table, that is add button
    me.gridButtons.forEach(button => {
        tableContent += `<button class="${button.cssClass}" id="${button.id}"><i class="fa ${button.fontAwesomeIcon}"></i> ${button.label}</button>`;
    });

   //beginning of creating the table html
   tableContent += `<br/><table class='${me.gridStyle}'><tr>`;

    //Creating the table headers from gridColumns property 'header'
    me.gridColumns.forEach(col => {
        tableContent += `<th>${col.header}</th>`;
    });
    tableContent += `<th></th><th></th>`;

    tableContent += `</tr>`;

    /*store for row action details, for which to append row action event of edit and delete,
    we are storing it because we will need to add the events listener later after rendering the table*/
    var actionEvents = [];

    /* loop through the gridData, which was assign from the table ajax request, to create
    the table rows */
    me.gridData.forEach(row => {

        tableContent += `<tr>`;

            ///finding out which data row belongs to which header or column and appending it
            me.gridColumns.forEach(col => {
                tableContent += `<td>${row[col.dataIndex]}</td>`;
            });

            /*Creating the row edit and delete buttons id for which to append event listeners for editing
            and deleting respectively, the ids needs to be unique for each row*/
            var editBtnId = me.componentId + '-edit-' + row.id;
            var deleteBtnId = me.componentId + '-del-' + row.id;

            /* adding the edit and delete buttons in each row for which the unique button id created above will be append
            in order to attach and event listener for either editing or deleting*/
            tableContent += `<td><button class="btn" id="${editBtnId}"><i class="fa fa-edit"></i></button></td>`
                + `<td><button class="btn" id="${deleteBtnId}"><i class="fa fa-trash"></button></td>`;

        tableContent += `</tr>`;

        /*Storing then edit and delete button in action event so that we can attach event listener to the row
        edit and delete button once the table is rendered*/
        actionEvents.push({editBtnId: editBtnId, deleteBtnId: deleteBtnId, recordId: row.id});

    });

    tableContent += `</table>`;

    //rendering the table
    document.getElementById('module-content').innerHTML = tableContent;

    //adding events listeners to the button on top of the table, that is add button
    me.gridButtons.forEach(button => {
        if (button.handler == 'addButton')
            document.getElementById(button.id).addEventListener('click', function(){
                SystechSkulJsLib.Form.call(me);
            });

    });

    //adding events listeners to each row of the table, from actionEvents store
    actionEvents.forEach(button => {

        //row edit event listeners
        document.getElementById(button.editBtnId).addEventListener('click', function(){
            alert('We will edit')
        });

        //row delete event listeners
        document.getElementById(button.deleteBtnId).addEventListener('click', function(){

                //make ajax request to delete record
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

                //show the module table once done, this will auto refresh the table
                SystechSkulJsLib.showGrid.call(me);

        });
    });

}


//Form creation function
SystechSkulJsLib.Form = function(){
    var me = this;

    var formContent = `<form action="#">`;

    //loop through the form field to know the type and details of form input types to render
    me.formField.forEach(field =>{

        formContent += `<div class="row">`
            + `<div class="col-25">`
                + `<label for="${field.name}">${field.label}</label>`
            + `</div>`
            + `<div class="col-75">`;

        if (field.type == 'select'){ //in case the form field is a select box the requires other data from ajax
                                    //load the data and create the options of the select box

            //store the select options, once the data is loaded from servlet for later use on populating the select box options
            var selectStore = [];

            //load the select box options from the servlet url provided through ajax
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

            //open the select box html element and give id and name value
            formContent += `<select id="${field.id}" name="${field.name}">`;

            //loop through ajax response to create select box options with the id value and display text
            selectStore.forEach(row => {
                formContent += `<option value="${row[field.storeModel.dataBinding.id]}">${row[field.storeModel.dataBinding.display]}</option>`;
            });

            //close the select box html element
            formContent += `</select>`;

        }else{
            //for any other form input just create input with the type
            formContent += `<input type="${field.type}" id="${field.id}" name="${field.name}">`
        }

        formContent += `</div></div>`;

    });

    formContent +=  `<div class="row">`
                + `<input type="submit" class="button addButton" value="Submit" id="${me.componentId}">` //the form submit button
            + `</div>`
        + ` </form>`;

    //render the form to html
    document.getElementById('module-content').innerHTML = formContent;

    //create the form submit button event, that is add event to the form submit button to be able to send data to servlet
    document.getElementById(me.componentId).addEventListener('click', event => {
        event.preventDefault();

        //variable to hold the form data to be sent to the servlet for saving
        var formData = '';

        //loop through the form fields to get the form input field name and value and append with an equal sign
        me.formField.forEach(field =>{
            formData += field.name + '=' + document.getElementById(field.id).value + '&';
        });

        //send the form data to servlet through ajax
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if (xhr.readyState == XMLHttpRequest.DONE){
                if (xhr.status == 200){
                    console.log(xhr.responseText)
                }
            }
        }

        xhr.open('post', me.dataUrl, false);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //add this to submit the data sent through ajax as form
        xhr.send(formData);

        //auto render the grid table to auto load the table store and show all the added records
        SystechSkulJsLib.showGrid.call(me);

    });
}

