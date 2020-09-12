Ext.define('AM.view.window.AddComponent', {
    extend: 'Ext.window.Window',
    alias: 'widget.add-comp-window',
    title: 'Add component to registry',
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
                    fieldLabel: 'Component',
                    store: 'LocalComponents',
                    queryMode: 'local',
                    valueField: 'className',
                    editable: false,
                    name: 'className',
                    tpl: Ext.create('Ext.XTemplate',
                        '<tpl for=".">',
                        '<div class="x-boundlist-item">{className} - {name}</div>',
                        '</tpl>'
                    ),
                    // template for the content inside text field
                    displayTpl: Ext.create('Ext.XTemplate',
                        '<tpl for=".">',
                        '{className} - {name}',
                        '</tpl>'
                    )
                },
                {
                    xtype: 'textfield',
                    name: 'name',
                    fieldLabel: 'Name'
                },
                {
                    xtype: 'checkbox',
                    name: 'enabled',
                    inputValue: true,
                    checked: true,
                    uncheckedValue: false,
                    fieldLabel: 'Enabled'
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
    ],
    initComponent: function() {
        var localComponentsStore = Ext.data.StoreManager.lookup('LocalComponents');
        localComponentsStore.removeAll();
        var components = Ext.ClassManager.getNamesByExpression('AM.view.*');
        var number = 1;
        Ext.each(components, function(component) {
            localComponentsStore.add(
                Ext.create('AM.model.Component', {
                    className: component,
                    name: 'View component #' + number++
                })
            );
        });
        this.callParent(arguments);
    }
});