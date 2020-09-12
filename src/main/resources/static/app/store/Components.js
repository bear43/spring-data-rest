Ext.define('AM.store.Components', {
    extend: 'Ext.data.TreeStore',
    autoLoad: true,
    model: 'AM.model.TreeModel',
    proxy: {
        type: 'ajax',
        url: '/components',
        reader: {
            type: 'json'
        }
    }
});