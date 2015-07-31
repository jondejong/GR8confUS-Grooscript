package thing

import org.grooscript.asts.GsNative
import org.grooscript.jquery.GQuery
import org.grooscript.jquery.GQueryImpl
import org.grooscript.templates.Templates

class Client {

    def name
    def description
    def socket
    def things
    def editThing

    GQuery gQuery

    def cancelEdit = {
        gQuery('#edit').html ''
    }

    def doEdit = {
        def newName = gQuery('#editNameInput').val()
        def newDesc = gQuery('#editDescriptionInput').val()
        socket.emit 'edit', [id: editThing._id, name: newName, description: newDesc]
        editThing.name = newName
        editThing.description = newDesc
        cancelEdit()
        drawList()
    }

    def edit =  {event ->
        cancelEdit()
        gQuery('#edit').html ''
        def index = event.currentTarget.id.split("-")[1]

        editThing = things[index]

        def model = [name: editThing.name, description: editThing.description]

        gQuery('#edit').html Templates.applyTemplate('edit.gtpl', model)
        gQuery.onEvent('#cancelEditThing', 'click', cancelEdit)
        gQuery.onEvent('#editThing', 'click', doEdit)
    }

    def bindEditButton(index) {
        gQuery.onEvent("#edit-${index}", 'click', edit)
    }

    def drawList() {
        gQuery('#thinglist').html Templates.applyTemplate('list.gtpl', [list: things])
        things.eachWithIndex {thing, index ->
            bindEditButton(index)
        }
    }

    def appendThing(thing) {
        gQuery('#thingTableBody').append Templates.applyTemplate('thing.gtpl', [thing: thing, index: things.size() - 1])
        bindEditButton(things.size - 1)
    }

    def handleSuccess = {data ->
        things = data
        drawList()
    }

    def handleError = {->
        console.log "Fail, dood :-("
    }

    def thingsUrl = 'http://localhost:5000/things'

    @GsNative
    void socketInit() {/*
        this.socket = io(window.location.hostname);
    */}

    /**
     * Set up the client. Set up socket listeners.
     * @param jQueryImpl
     */
    Client(jQueryImpl) {
        this.gQuery = jQueryImpl
        this.gQuery.doRemoteCall(thingsUrl, 'get', {}, handleSuccess, handleError)

        socketInit()
        socket.on 'thingadded', { data ->
            addThing(data)
        }
        socket.on 'thingedited', {data ->
            def thing = things.find {
                it._id == data._id
            }
            thing.name = data.name
            thing.description = data.description
            drawList()
        }
        bindEvents()
    }

    private addThing (thing) {
        things.push(thing)
        appendThing(thing)
    }

    def addThingClick() {
        socket.emit 'save', [name: name, description: description]
        setName ''
        setDescription ''
    }

    /**
     * Static init method. Bind everything we need to the dom.
      * @return
     */
    static init() {
        def gQuery = new GQueryImpl()
        gQuery.onReady {
            def client = new Client(gQuery)
            gQuery.bindAllProperties(client)
            gQuery.attachMethodsToDomEvents(client)
        }
    }

    /**
     * Bind click events to the input fields for convenience
     * @return
     */
    private bindEvents() {
        gQuery('#descriptionInput').keypress { event ->
            if (event.which == 13) {
                addThingClick()
            }
        }
        gQuery('#nameInput').keypress { event ->
            if (event.which == 13) {
                addThingClick()
            }
        }
    }
}
