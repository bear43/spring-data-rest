Ext.define('AM.controller.ComponentRegistry', {
    extend: 'Ext.app.Controller',
    views: [
        'ComponentRegistry'
    ],
    stores: [
        'Components'
    ],
    controllers: [
        'window.AddComponent',
        'window.AddAttribute'
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
        var addWindow;
        var selection = this.getTree().getSelectionModel().getSelection();
        if(selection && selection.length === 1) {
            var item = selection[0];
            var nodeText = item.get('text');
            if(nodeText === 'Components') {
                addWindow = Ext.widget('add-comp-window');
            } else if(nodeText === 'Attributes') {
                addWindow = Ext.widget('add-attr-window');
            } else {
                throw new Error('Unknown state of root node. Cannot initiate process of addition');
            }
            addWindow.show();
        }
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