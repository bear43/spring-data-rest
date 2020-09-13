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
        'window.AddAttribute',
        'window.ComponentLinker'
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
    onAddButtonClick: function (button) {
        var addWindow;
        var selection = this.getTree().getSelectionModel().getSelection();
        if (selection && selection.length === 1) {
            var item = selection[0];
            var nodeText = item.get('text');
            if (nodeText === 'Components') {
                addWindow = Ext.widget('add-comp-window');
            } else if (nodeText === 'Attributes') {
                addWindow = Ext.widget('add-attr-window');
            } else if (nodeText === 'Links') {
                addWindow = Ext.widget('comp-linker-window');
            } else {
                throw new Error('Unknown state of root node. Cannot initiate process of addition');
            }
            addWindow.show();
        }
    },
    onEnableButtonClick: function (button) {
        var id = this.getTree().getSelectionModel().getSelection()[0].get('id');
        var me = this;
        Ext.Ajax.request({
            url: `/components/set-state/${id}`,
            method: 'PATCH',
            params: {
                enable: true
            },
            success: function () {
                Ext.Msg.alert('Success', 'Status changed');
                me.getTree().getStore().reload();
            }
        });
    },
    onDisableButtonClick: function (button) {
        var id = this.getTree().getSelectionModel().getSelection()[0].get('id');
        var me = this;
        Ext.Ajax.request({
            url: `/components/set-state/${id}`,
            method: 'PATCH',
            params: {
                enable: false
            },
            success: function () {
                Ext.Msg.alert('Success', 'Status changed');
                me.getTree().getStore().reload();
            }
        });
    },

    onNodeDoubleClick: function (self, record, item, index, e, eOpts) {
        var metadata = record.get('metadata');
        var me = this;
        if (metadata) {
            var className = metadata.className;
            if (className) {
                Ext.Msg.show({
                    title: 'Component demonstrating',
                    msg: 'This is simple component. Wanna see it in browser?',
                    buttons: Ext.Msg.YESNO,
                    icon: Ext.Msg.QUESTION,
                    fn: function (buttonId) {
                        if (buttonId === 'yes') {
                            me.fireEvent('browserClear');
                            me.fireEvent('browserAddComponent', className);
                        }
                    }
                });
            }
        }
    },

    init: function () {
        this.control({
            'component-tree button[action=add]': {
                click: this.onAddButtonClick
            },
            'component-tree button[action=enable]': {
                click: this.onEnableButtonClick
            },
            'component-tree button[action=disable]': {
                click: this.onDisableButtonClick
            },
            'component-tree': {
                itemdblclick: this.onNodeDoubleClick
            }
        });
    }
});