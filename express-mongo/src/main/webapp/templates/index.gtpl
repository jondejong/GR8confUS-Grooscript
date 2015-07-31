yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title 'The Things'
        ['js/jquery-2.1.3.js',
          'js/grooscript.min.js',
          'js/grooscript-tools.js',
          'js/Client.js',
          'js/gstemplates.js',
          'js/socketio.js',
          'js/bootstrap.min.js'].each {
            script(type: 'text/javascript', src: it) {}
        }
        link(rel: 'stylesheet', type: 'text/css', href: 'css/application.css')
        link(rel: 'stylesheet', type: 'text/css', href: 'css/bootstrap.min.css')
    }

    body {
        header {
            h2 {
                yield 'Things App'
            }
        }
        div (class: 'row'){
            div (class: 'col-md-8', id: 'thinglist') {

            }

            div(class: 'col-md-4') {
                h4 {
                    yield 'Add Thing'
                }
                div(class: 'row') {
                    div(class:"col-xs-3") {
                        label(for:"right-label", class:"right") {
                            yield 'Name:'
                          }
                    }
                    div(class:"col-xs-9") {
                      input(id: 'nameInput', type:"text", name: 'name') {}
                    }
                }
                div(class: 'row') {
                    div(class:"col-xs-3") {
                        label(for:"right-label", class:"right") {
                            yield 'Description:'
                        }
                    }
                    div(class:"col-xs-9") {
                        input(id: 'descriptionInput', type:"text", name: 'description') {}
                    }
                }
                div(){
                    span(id: 'addThing', class:"btn btn-default", onclick: '') {
                        yield 'Add'
                    }
                }

            }
        }

        div(id: 'edit') {

        }
        script {
            yield 'Client.init();'
        }

    }
}