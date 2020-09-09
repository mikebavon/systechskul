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
            cssClass: 'action-btn',
            fontAwesomeIcon: 'fa-plus',
            handler: 'addButton',
            id: 'org-addButton',
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