Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.userlist',

    title: 'All Users',

    initComponent: function() {
        this.store = 'Users';

        this.columns = [
            {header: 'Name',  dataIndex: 'login',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }
});