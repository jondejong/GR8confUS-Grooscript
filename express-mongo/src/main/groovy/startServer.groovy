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

import org.grooscript.templates.Templates
import thing.Thing

import static thing.NodeServer.server

def nodeServer

Thing.initMongoose()
def model = Thing.thingModel
model.find({err, list->
    if(list.size() < 1) {
        def thing = Thing.newMongoThing()
        thing.name = "jon"
        thing.description = "is in mongo"
        thing.save()
    }
})

nodeServer = server {
    get('/') {
        render Templates.applyTemplate('index.gtpl')
    }
    get('/things') {req, resp ->
        model.find({err, list ->
            resp.json list
        })
    }
    on('save') { data, socket ->
        def thing = Thing.newMongoThing()
        thing.name = data.name
        thing.description = data.description
        thing.save({err, saved->
            console.log "Thing saved", nodeServer
            nodeServer.broadCast('thingadded', [_id: saved._id, name: data.name, description: data.description])
        })
    }
    on('edit') { data, socket ->
        model.findById(data.id, {err, thing ->
            thing.name = data.name
            thing.description = data.description
            thing.save()
        })
        socket.broadcast.emit 'thingedited', [_id: data.id, name: data.name, description: data.description]
    }
}.start()
