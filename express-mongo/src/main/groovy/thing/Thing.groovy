package thing

import org.grooscript.asts.GsNative

class Thing {

    static mongoose
    static model

    @GsNative
    static initMongoose() {/*
        mongoose = require('mongoose');
        mongoose.connect('mongodb://localhost::27017/things');
        var thingSchema = new mongoose.Schema({
              name: String,
              description: String
            });

        model = mongoose.model('thing', thingSchema);
    */}

    @GsNative
    static newMongoThing () {/*
        return new model()
    */}

    @GsNative
    static getThingModel () {/*
        return model;
    */}


}
