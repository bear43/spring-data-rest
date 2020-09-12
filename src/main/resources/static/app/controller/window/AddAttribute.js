Ext.define('AM.controller.window.AddAttribute', {
    extend: 'Ext.app.Controller',
    views: [
        'window.AddAttribute'
    ],
    refs: [
        {
            ref: 'window',
            selector: 'add-attr-window'
        },
        {
            ref: 'form',
            selector: 'add-attr-window form'
        }
    ],
    init: function() {
        this.control({
            'add-attr-window button[action=close]' : {
                click: this.onCancelClick
            },
            'add-attr-window button[action=add]' : {
                click: this.onAddClick
            }
        });
    },
    onCancelClick: function(button) {
        var window = this.getWindow();
        window.close();
    },
    onAddClick: function(button) {
        var form = this.getForm();
        var values = form.getValues();
        if(form.isValid()) {
            Ext.Ajax.request({
                url: '/attributes/add',
                method: 'POST',
                jsonData: values,
                success: function() {
                    Ext.Msg.alert('Success added');
                    Ext.data.StoreManager.lookup('Attributes').reload();
                    this.getWindow().close();
                },
                failure: function() {
                    Ext.Msg.alert('Error');
                }
            });
        }
    }
});