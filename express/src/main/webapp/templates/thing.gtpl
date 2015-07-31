tr {
    td model.thing.name
    td model.thing.description
    td {
       span(id: "edit-${model.index}", class:"btn btn-success", onclick: '') {
           yield 'Edit'
       }
    }
}