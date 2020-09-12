function applyFields(modelClass, addFields) {
    var modelPrototype = modelClass.prototype,
        fields = modelPrototype.fields,
        keys = fields.keys,
        ln = addFields.length,
        addField, i;

    for (i = 0; i < ln; i++) {
        addField = addFields[i];
        if (!Ext.Array.contains(keys, addField.name)) {
            fields.add(new Ext.data.Field(addField));
        }
    }

}

Ext.define('AM.model.TreeModel', {
    extend: 'Ext.data.TreeModel',
    fields: [
        {name: 'disabled', type: 'bool'},
        {name: 'parentId', type: 'auto', defaultValue: null, useNull: true},
        {name: 'index', type: 'int', defaultValue: 0, persist: false, convert: null},
        {name: 'depth', type: 'int', defaultValue: 0, persist: false, convert: null},
        {name: 'expanded', type: 'bool', defaultValue: false, persist: false, convert: null},
        {name: 'expandable', type: 'bool', defaultValue: true, persist: false, convert: null},
        {name: 'checked', type: 'auto', defaultValue: null, persist: false, convert: null},
        {name: 'leaf', type: 'bool', defaultValue: false},
        {name: 'cls', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'iconCls', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'icon', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'root', type: 'boolean', defaultValue: false, persist: false, convert: null},
        {name: 'isLast', type: 'boolean', defaultValue: false, persist: false, convert: null},
        {name: 'isFirst', type: 'boolean', defaultValue: false, persist: false, convert: null},
        {name: 'allowDrop', type: 'boolean', defaultValue: true, persist: false, convert: null},
        {name: 'allowDrag', type: 'boolean', defaultValue: true, persist: false, convert: null},
        {name: 'loaded', type: 'boolean', defaultValue: false, persist: false, convert: null},
        {name: 'loading', type: 'boolean', defaultValue: false, persist: false, convert: null},
        {name: 'href', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'hrefTarget', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'qtip', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'qtitle', type: 'string', defaultValue: '', persist: false, convert: null},
        {name: 'qshowDelay', type: 'int', defaultValue: 0, persist: false, convert: null},
        {name: 'children', type: 'auto', defaultValue: null, persist: false, convert: null},
        {name: 'text', type: 'string'},
        {name: 'id', type: 'int'}
    ]
});