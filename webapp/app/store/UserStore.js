/**
 * Created by jesa on 06.04.2016.
 */
Ext.define('UserStore',{
    extend: 'Ext.data.Store',
    autoLoad: true,
    model: 'User',
    requires: ['Ext.data.proxy.Ajax'],
    proxy: {
        type: 'ajax',
        api: {
            read: "listUsers.action",
            create: "addUser.action",
            destroy: "deleteUser.action",
            update: "updateUser.action"
        },
        reader: {
            successProperty: 'success',
            type: "json"
        },
        writer: {
            type: "json",
            writeAllFields: true
        }
    }
});