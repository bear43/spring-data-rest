Ext.define('AM.store.LocalComponents', {
    extend: 'Ext.data.Store',
    model: 'AM.model.Component',
    proxy: {
        type: 'memory'
    }
});