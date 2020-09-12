Ext.application({
    requires: ['Ext.container.Viewport','Ext.ux.tree.plugin.NodeDisabled'],
    name: 'AM',
    appFolder: 'app',
    controllers: [
        'Browser',
        'ComponentRegistry',
        'Users'
    ],
    paths: {
        'Ext.ux.tree.plugin' : '/js/plug/source/tree/plugin'
    },
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [
                {
                    xtype: 'component-tree'
                },
                {
                    xtype: 'browser'
                }
            ]
        });
    }
});