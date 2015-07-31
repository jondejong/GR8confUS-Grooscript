### Gradle Plugin

    plugins {
      id "org.grooscript.conversion" version "1.1.2"
    }

    ...

    grooscript {
      source = ['src/main/groovy/']
      destination = 'js'
      classPath = ['src/main/groovy']
      initialText = "var gs = require('grooscript');"
    }
