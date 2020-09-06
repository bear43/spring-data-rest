Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
    model: 'AM.model.User',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            create: 'api/users',
            read: 'api/users',
            update: 'api/users',
            delete: 'api/users'
        },
        reader: {
            type: 'json',
            root: '_embedded.users',
        }
    },
    listeners: {
        beforeload: function(store, operation) {
            operation.page = operation.page - 1;
            console.log(operation);
        }
    }
});