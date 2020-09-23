(function(){
    SystechSkulJsLib.showGrid.call({
        dataUrl: 'organization',
        gridStyle: 'customers',
        componentId: 'organization',
        formContentType: 'application/json',
        //formContentType: 'application/x-www-form-urlencoded',
        gridColumns:[{
            header: 'Id',
            dataIndex: 'id'
        },{
            header: 'Name',
            dataIndex: 'name'
        },{
            header: 'Address',
            dataIndex: 'contact.address'
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
            name: 'contact.address',
            type: 'text',
            id: 'org-address'
        }]
    });
})();