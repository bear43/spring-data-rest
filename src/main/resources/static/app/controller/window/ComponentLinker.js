Ext.define('AM.controller.window.ComponentLinker', {
    extend: 'Ext.app.Controller',
    views: [
        'window.ComponentLinker'
    ],
    stores: [
        'Items'
    ],
    models: [
        'Item'
    ],
    refs: [
        {
            ref: 'window',
            selector: 'comp-linker-window'
        },
        {
            ref: 'form',
            selector: 'comp-linker-window form'
        }
    ],
    init: function() {
        this.control({
            'comp-linker-window button[action=close]' : {
                click: this.onCancelClick
            },
            'comp-linker-window button[action=add]' : {
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
                url: '/registry',
                method: 'POST',
                jsonData: values,
                success: function() {
                    Ext.Msg.alert('Success added');
                    this.getWindow().close();
                },
                failure: function() {
                    Ext.Msg.alert('Error');
                }
            });
        }
    }
});