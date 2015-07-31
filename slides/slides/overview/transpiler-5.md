Slightly more complicated

        function Talker() {
          var gSobject = gs.inherit(gs.baseClass,'Talker');

          gSobject.clazz =
          { name: 'Talker', simpleName: 'Talker'};

          gSobject.clazz.superclass =
          { name: 'java.lang.Object', simpleName: 'Object'};

          gSobject.message = null;
          gSobject['talk'] = function(it) {
            return gs.println(gSobject.message);
          }

          if (arguments.length == 1)
            {gs.passMapToObject(arguments[0],gSobject);
          };

          return gSobject;
        };

        var name = "Jon";
        gs.mc(
          Talker(gs.map().add(
            "message","Hi " + (name) + "")),
            "talk",[]
            );
