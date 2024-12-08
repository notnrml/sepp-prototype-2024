plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    //implementation("info.picocli:picocli:4.7.6")
    //implementation("io.javalin:javalin:6.3.0")
    //implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("org.bham.Main")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
