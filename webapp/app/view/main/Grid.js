/**
 * Created by jesa on 06.04.2016.
 * таблица для отображения информации о пользователях
 */
Ext.define('Grid',{
    extend: 'Ext.grid.Panel',
    title: 'Пользователи',
    height: 400,
    width: 800,
    plugins: [Ext.create('RowEdit')],
    store: Ext.create('UserStore'),
    id: "MyGrid",
    columns: [{
        header: 'Имя',
        dataIndex: 'firstName',
        editor: {
            allowBlank: false
        }
    }, {
        header: 'Фамилия',
        dataIndex: 'lastName',
        editor: {
            allowBlank: false
        }
    }, {
        header: 'Дата рождения',
        dataIndex: 'dateOfBirth',
        xtype: 'datecolumn',
        format: 'd.m.Y',
        flex: 1,
        editor: {
            allowBlank: false
        }
    }, {
        header: 'E-mail',
        dataIndex: 'email',
        flex: 1,
        editor: {
            allowBlank: false
        }
    }, {
        header: 'Номер паспорта',
        dataIndex: 'passportNumber',
        flex: 1,
        editor: {
            allowBlank: false
        }
    }],
    buttons: [{
        text: 'Add',
        handler: function () {
            var user = Ext.create('User', {
                firstName: "New user",
                lastName: "New User",
                passportNumber: "0000000000",
                dateOfBirth: '01.01.1970',
                email: "default@email.com"
            });
            user.setId(0);
            var grid = Ext.getCmp("MyGrid");
            grid.getStore().add(user);
            grid.getStore().sync();
            grid.getStore().load();
        }
    }, {
        text: 'Delete',
        listeners: {
            click: {
                scope: this,
                fn: function () {
                    var grid = Ext.getCmp("MyGrid");
                    var selection = grid.getView().getSelection()[0];
                    if (selection)
                        grid.getStore().remove(selection);
                    grid.getStore().sync();
                    grid.getStore().load();
                }
            }
        }
    }]
});