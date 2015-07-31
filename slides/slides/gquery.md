### gQuery

    gQuery('#edit').html Templates.applyTemplate('edit.gtpl', model)

    gQuery.onEvent('#cancelEditThing', 'click', cancelEdit)

    gQuery('#thinglist').html Templates.applyTemplate('list.gtpl',
     [list: things])

    gQuery.doRemoteCall(thingsUrl, 'get', {}, handleSuccess, handleError)
