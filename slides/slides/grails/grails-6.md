## Grails 3 Plugin

### Remote Model

    <grooscript:remoteModel domainClass="Receiver"/>
    <grooscript:code>
        import com.jondejong.Receiver

        def sayHi = {
            Receiver.list().then {
                $('#message').html ''
                list.each {
                    $('#message').append("<p>Hello ${it}")
                }
            }
        }

        $(document).ready {sayHi()}
    </grooscript:code>
