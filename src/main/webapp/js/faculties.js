(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'faculty',
        gridStyle: 'customers',
        componentId: 'faculty',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        }],
        gridButtons: [{
            label: 'Add Faculty',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'faculty-addButton',
        },{
            label: 'Edit Faculty',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'faculty-editButton',
        },{
            label: 'Delete Faculty',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'faculty-deleteButton',
        }],
        formField: [{
            label: 'Faculty Name',
            name: 'name',
            type: 'text',
            id: 'faculty-name'
        }]
    });
})();