plugins {
    application
    java
}

application {
    mainClassName = "pl.marcinnowakowski.CountMuseumVisitorsApplication"
}

configure<JavaPluginConvention> {
    setSourceCompatibility(1.11)
    setTargetCompatibility(1.11)
}

tasks.named<Jar>("jar") {
    manifest.attributes(mapOf(
            "Implementation-Title" to "Mars Rovers Challenge",
            "Main-Class" to "com.websigni.mars.MarsRoversAppMain"
    ))
}

tasks.getByName<Test>("test"){
    testLogging.showStandardStreams = true
}

dependencies {
    compile("org.projectlombok:lombok:1.18.6")
    testCompile("junit:junit:4.12")
    testCompile("org.assertj:assertj-core:3.11.1")
}

repositories {
    jcenter()
}