Ext.define('AM.view.window.ComponentLinker', {
    extend: 'Ext.window.Window',
    alias: 'widget.comp-linker-window',
    title: 'Link components and attributes',
    layout: 'fit',
    width: 768,
    modal: true,
    items: [
        {
            xtype: 'form',
            bodyPadding: 10,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'combobox',
                    fieldLabel: 'Attribute',
                    store: 'Attributes',
                    valueField: 'id',
                    editable: false,
                    name: 'attribute',
                    tpl: Ext.create('Ext.XTemplate',
                        '<tpl for=".">',
                        '<div class="x-boundlist-item">{name}. {entity} {entityId}</div>',
                        '</tpl>'
                    ),
                    // template for the content inside text field
                    displayTpl: Ext.create('Ext.XTemplate',
                        '<tpl for=".">',
                        '{name}. {entity} {entityId}',
                        '</tpl>'
                    )
                },
                {
                    xtype: 'textfield',
                    name: 'component',
                    fieldLabel: 'Component'
                },
                {
                    xtype: 'grid',
                    title: 'items',
                    store: 'Items',
                    columns: [
                        {
                            text: 'ID',
                            dataIndex: 'id'
                        },
                        {
                            text: 'Component',
                            dataIndex: 'name'
                        },
                        {
                            xtype: 'checkcolumn',
                            text: 'Enabled',
                            dataIndex: 'enabled'
                        }
                    ],
                    tbar: [
                        {
                            xtype: 'button',
                            text: 'add',
                            action: 'add-item'
                        },
                        {
                            xtype: 'button',
                            text: 'delete',
                            action: 'delete-item'
                        }
                    ]
                }
            ],
            buttons: [
                {
                    xtype: 'button',
                    text: 'Add',
                    action: 'add'
                },
                {
                    xtype: 'button',
                    text: 'Cancel',
                    action: 'close'
                }
            ]
        }
    ]
});