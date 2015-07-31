package thing

class ThingDataStore {
    def Map<String, Thing> things = new HashMap<String, Thing>()

    def index = 0

    def list() {
        return things.values()
    }

    def get(String id) {
        return things[id]
    }

    def save(Thing thing) {
        thing.id = "${index++}"
        things.put(thing.id, thing)
    }

    def update(Thing thing) {
        def instance = things[thing.id]
        instance.name = thing.name
        instance.description = thing.description
    }
}
