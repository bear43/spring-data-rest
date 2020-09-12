Ext.define('AM.view.ComponentRegistry', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.component-tree',
    title: 'Components registry',
    collapsible: true,
    flex: 2,
    region: 'west',
    rootVisible: false,
    plugins: [
        Ext.create('Ext.ux.tree.plugin.NodeDisabled')
    ],
    tbar: [
        {
            xtype: 'button',
            text: 'Add',
            action: 'add'
        },
        {
            xtype: 'button',
            text: 'Disable',
            action: 'disable'
        },
        {
            xtype: 'button',
            text: 'Enable',
            action: 'enable'
        }
    ],
    initComponent: function() {
        this.store = 'Components';
        this.callParent(arguments);
    }
});