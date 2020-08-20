(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'faculty',
        gridStyle: 'customers',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Dean',
            dataIndex: 'dean'
        },{
            header: 'No Of Departments',
            dataIndex: 'noOfDepartments'
        },{
            header: 'Details',
            dataIndex: 'details'
        }],
        gridButtons: [{
            label: 'Add Faculty',
            cssClass: 'addButton',
        },{
            label: 'Edit Faculty',
            cssClass: 'editButton'
        },{
            label: 'Delete Faculty',
            cssClass: 'deleteButton'
        }]
    });
})();