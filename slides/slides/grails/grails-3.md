## Grails 3 Plugin

### grooscript:template tag

    <grooscript:template>
      ul {
          ["world", "GR8Conf"].each { receiver ->
              li "Hello ${receiver}"
          }
      }
    </grooscript:template>
