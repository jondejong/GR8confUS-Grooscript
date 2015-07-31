table(class: 'table') {
    thead {
        tr {
            th 'Name'
            th 'Description'
            th ''
        }
    }

    tbody(id: 'thingTableBody') {
        model.list.eachWithIndex { thing, index ->
            tr {
                td thing.name
                td thing.description
                td {
                   span(id: "edit-${index}", class:"btn btn-success", onclick: '') {
                       yield 'Edit'
                   }
                }
            }
        }
    }
}