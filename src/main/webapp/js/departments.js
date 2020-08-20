(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'departments',
        gridStyle: 'customers',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'H.O.D',
            dataIndex: 'hod'
        },{
            header: 'No Of Courses',
            dataIndex: 'noOfCourses'
        },{
            header: 'Details',
            dataIndex: 'details'
        }],
        gridButtons: [{
            label: 'Add Department',
            cssClass: 'addButton'
        },{
            label: 'Edit Department',
            cssClass: 'editButton'
        },{
            label: 'Delete Department',
            cssClass: 'deleteButton'
        }]
    });
})();