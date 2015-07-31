Slightly more complicated

        class Talker {
            def message;

            def talk() {
                println message
            }
        }

        String name = 'Jon'
        new Talker(message: "Hi ${name}").talk()
