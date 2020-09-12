Ext.define('AM.controller.ComponentRegistry', {
    extend: 'Ext.app.Controller',
    views: [
        'ComponentRegistry'
    ],
    stores: [
        'Components'
    ],
    controllers: [
        'window.AddComponent'
    ],
    refs: [
        {
            ref: 'tree',
            selector: 'component-tree'
        },
        {
            ref: 'store',
            selector: 'component-tree store'
        }
    ],
    onAddButtonClick: function(button) {
        var addCompWindow = Ext.widget('add-comp-window');
        addCompWindow.show();
    },
    onEnableButtonClick: function(button) {
        var id = this.getTree().getSelectionModel().getSelection()[0].get('id');
        var me = this;
        Ext.Ajax.request({
            url: `/components/set-state/${id}`,
            method: 'PATCH',
            params: {
                enable: true
            },
            success: function() {
                Ext.Msg.alert('Success', 'Status changed');
                me.getTree().getStore().reload();
            }
        });
    },
    onDisableButtonClick: function(button) {
        var id = this.getTree().getSelectionModel().getSelection()[0].get('id');
        var me = this;
        Ext.Ajax.request({
            url: `/components/set-state/${id}`,
            method: 'PATCH',
            params: {
                enable: false
            },
            success: function() {
                Ext.Msg.alert('Success', 'Status changed');
                me.getTree().getStore().reload();
            }
        });
    },

    init: function() {
        this.control({
            'component-tree button[action=add]' : {
                click: this.onAddButtonClick
            },
            'component-tree button[action=enable]' : {
                click: this.onEnableButtonClick
            },
            'component-tree button[action=disable]' : {
                click: this.onDisableButtonClick
            }
        });
    }
});