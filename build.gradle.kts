plugins {
    java
    application
}

group = "com.github.eosum"
version = "1.0"

application {
    mainClass.set("com.github.eosum.Lab5.App.Main")
}
dependencies {
}
repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

val fatJar = tasks.create<Jar>("fatJar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

tasks["build"].dependsOn(fatJar)

