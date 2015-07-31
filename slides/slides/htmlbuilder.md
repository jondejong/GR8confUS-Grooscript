### HtmlBuilder
    HtmlBuilder.build {
        body {
            ul(class: 'list', id: 'hellos') {
                ['Groovy', 'Grails', 'Grooscript'] { tool ->
                    li tool + 'is GR8!'
                }
            }
        }
    }
