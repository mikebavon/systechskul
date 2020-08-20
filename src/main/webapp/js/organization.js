(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'organization',
        gridStyle: 'customers',
        componentId: 'organization',
        gridColumns:[{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Address',
            dataIndex: 'address'
        }],
        gridButtons: [{
            label: 'Add Organization',
            cssClass: 'addButton',
            handler: 'addButton',
            id: 'org-addButton',
        },{
            label: 'Edit Organization',
            cssClass: 'editButton',
            handler: 'editButton',
            id: 'org-editButton',
        },{
            label: 'Delete Organization',
            cssClass: 'deleteButton',
            handler: 'deleteButton',
            id: 'org-deleteButton',
        }],
        formField: [{
            label: 'Organization Name',
            name: 'name',
            type: 'text',
            id: 'org-name'
        },{
            label: 'Organization Address',
            name: 'address',
            type: 'text',
            id: 'org-address'
        }]
    });
})();