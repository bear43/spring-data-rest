Ext.define('AM.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    requires: [
        'AM.controller.ComponentRegistry',
        'AM.controller.Browser'
    ],
    items: [
        {
            xtype: 'component-tree'
        },
        {
            xtype: 'browser'
        }
    ]
});