Ext.define('AM.view.window.AddAttribute', {
    extend: 'Ext.window.Window',
    alias: 'widget.add-attr-window',
    title: 'Add attribute to registry',
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
                    xtype: 'textfield',
                    name: 'name',
                    fieldLabel: 'Name'
                },
                {
                    xtype: 'numberfield',
                    minValue: 0,
                    name: 'userId',
                    fieldLabel: 'UserId'
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