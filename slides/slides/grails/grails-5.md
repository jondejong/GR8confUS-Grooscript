## Grails 3 Plugin

### Websockets

    <grooscript:initSpringWebsocket/>

    <grooscript:onServerEvent path="/hello">
      $("#message").append '<p>'+data+'</p>'
    </grooscript:onServerEvent>
