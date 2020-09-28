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

document.getElementById("saveDepartment").addEventListener('click', event => {
    event.preventDefault();

    var name = document.getElementById('name');
    var phoneNo = document.getElementById('phoneNo');

    var formData = {
        name:name,
        contact: {
            phoneNo: phoneNo;
        }
    }

    submitForm(formData, 'application/json');
});



