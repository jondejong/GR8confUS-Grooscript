## Grails 3 Plugin
    <div id="message"></div>
    
    <grooscript:template
        onLoad="false"
        functionName="sayHi" itemSelector="#message">
      ul {
          data.each { receiver ->
              li "Hello ${receiver}"
          }
      }
    </grooscript:template>

    <grooscript:code>
      sayHi ["World", "GR8Conf"]
    </grooscript:code>
