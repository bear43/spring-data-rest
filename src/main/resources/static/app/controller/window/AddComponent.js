Ext.define('AM.controller.window.AddComponent', {
    extend: 'Ext.app.Controller',
    views: [
        'window.AddComponent'
    ],
    stores: [
        'LocalComponents'
    ],
    refs: [
        {
            ref: 'window',
            selector: 'add-comp-window'
        },
        {
            ref: 'form',
            selector: 'add-comp-window form'
        }
    ],
    init: function() {
        this.control({
            'add-comp-window button[action=close]' : {
                click: this.onCancelClick
            },
            'add-comp-window button[action=add]' : {
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
                url: '/components/add',
                method: 'POST',
                jsonData: values,
                success: function() {
                    Ext.Msg.alert('Success added');
                    Ext.data.StoreManager.lookup('Components').reload();
                },
                failure: function() {
                    Ext.Msg.alert('Error');
                }
            });
        }
    }
});