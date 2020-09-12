Ext.define('AM.model.User', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'login', type: 'string'},
        {name: 'email', type: 'string'}
    ]
});