import org.grooscript.templates.Templates
import thing.Thing
import thing.ThingDataStore

import static thing.NodeServer.server

/**
 * User: jorgefrancoleza
 *
 * This was originally written by Jorge Francoleza as part of the
 * Grooscript Demos (https://github.com/chiquitinxx/grooscript-demos).
 * It is used here slightly modified to support the needs of this demo.
 *
 * Date: 21/10/14
 * Modified: July, 2015 by Jon DeJong
 */


ThingDataStore dataStore = new ThingDataStore()

dataStore.save(new Thing(name: 'Jon', description: 'Was Here'))
dataStore.save(new Thing(name: 'Bear', description: "A Dog"))

server {
    get('/') {
        render Templates.applyTemplate('index.gtpl')
    }
    get('/things') {
        render dataStore.list()
    }
    on('save') { data, socket ->
        dataStore.save new Thing(name: data.name, description: data.description)
        socket.broadcast.emit 'thingadded', [name: data.name, description: data.description]
    }
    on('edit') { data, socket ->
        dataStore.update new Thing(id: data.id, name: data.name, description: data.description)
        socket.broadcast.emit 'thingedited', [id: data.id, name: data.name, description: data.description]
    }
}.start()
