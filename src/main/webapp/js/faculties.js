(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'faculty',
        gridStyle: 'customers',
        componentId: 'faculty',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Organization',
            dataIndex: 'organizationName'
        }],
        gridButtons: [{
            label: 'Add Faculty',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'faculty-addButton',
        }],
        formField: [{
            label: 'Organization Name',
            name: 'organizationId',
            type: 'select',
            id: 'faculty-organizationId',
            storeModel: {
                url: 'organization',
                dataBinding: {
                    display : 'name',
                    id: 'id'
                }
            }
        },{
            label: 'Faculty Name',
            name: 'name',
            type: 'text',
            id: 'faculty-name'
        }]
    });
})();