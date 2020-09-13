Ext.define('AM.controller.Browser', {
    extend: 'Ext.app.Controller',
    views: [
        'Browser'
    ],
    refs: [
        {
            ref: 'browser',
            selector: 'browser'
        }
    ],
    addComponent: function(componentClassName) {
        var browser = this.getBrowser();
        browser.add(Ext.create(componentClassName));
    },

    clear: function() {
        var browser = this.getBrowser();
        browser.removeAll();
    },

    init: function() {
        this.listen({
            // We are using Controller event domain here
            controller: {
                // This selector matches any originating Controller
                '*': {
                    browserAddComponent: 'addComponent',
                    browserClear: 'clear'
                }
            }
        });
    }
});