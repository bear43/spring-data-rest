Ext.define('AM.model.Component', {
    extend: 'Ext.data.Model',
    autoLoad: false,
    fields: [
        {name: 'className', type: 'string'},
        {name: 'name', type: 'string'}
    ]
});