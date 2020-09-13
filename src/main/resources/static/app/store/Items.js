Ext.define('AM.store.Items', {
    extend: 'Ext.data.Store',
    model: 'AM.model.Item',
    proxy: {
        type: 'memory'
    }
});