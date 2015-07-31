h4 {
    yield 'Edit Thing'
}
div(class: 'row') {
    div(class:"col-xs-3") {
        label(for:"right-label", class:"right") {
            yield 'Name:'
          }
    }
    div(class:"col-xs-9") {
      input(id: 'editNameInput', type:"text", name: 'editName', value: model.name ) {}
    }
}
div(class: 'row') {
    div(class:"col-xs-3") {
        label(for:"right-label", class:"right") {
            yield 'Description:'
        }
    }
    div(class:"col-xs-9") {
        input(id: 'editDescriptionInput', type:"text", name: 'editDescription', value: model.description) {}
    }
}
div(){
    span(id: 'editThing', class:"btn btn-default", onclick: '') {
        yield 'Save'
    }
    span(id: 'cancelEditThing', class:"btn btn-danger", onclick: '') {
        yield 'Cancel'
    }
}