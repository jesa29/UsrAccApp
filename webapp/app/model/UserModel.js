/**
 * Created by jesa on 06.04.2016.
 * модель данных
 */
Ext.define('User', {
    extend: 'Ext.data.Model',
    idProperty: 'ID',
    fields: [{
        name: 'ID',
        type: 'float',
        persist: 'true'
    }, {
        name: 'firstName',
        type: 'string',
        persist: 'true'
    }, {
        name: 'lastName',
        type: 'string',
        persist: 'true'
    }, {
        name: 'dateOfBirth',
        type: 'string',
        persist: 'true'
    }, {
        name: 'email',
        type: 'string',
        persist: 'true'
    }, {
        name: 'passportNumber',
        type: 'string',
        persist: 'true'
    }]
});