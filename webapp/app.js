Ext.application({
    name: 'useraccountapplication',        
    requires: ['Ext.grid.*'],
    launch: function () {
	    var usersGrid = Ext.create('Grid');
        usersGrid.render(document.body);
        usersGrid.on('edit', function () {
            usersGrid.store.sync();
            usersGrid.store.load();
        });		
    }
});