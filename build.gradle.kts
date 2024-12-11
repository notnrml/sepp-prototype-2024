import org.gradle.api.file.DuplicatesStrategy // Required for Kotlin DSL

plugins {
    id("application")
    id ("org.openjfx.javafxplugin") version ("0.0.12")

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
    implementation ("org.openjfx:javafx-controls:17.0.1")
    implementation ("org.openjfx:javafx-base:17.0.1")
    implementation ("org.openjfx:javafx-graphics:17.0.1")
    implementation("org.openjfx:javafx-fxml:17.0.1")
}
sourceSets {
    main {
        resources {
            srcDir("src/main/resources")
            include("**/*.fxml","**/*.png")
        }
    }
}
javafx {
    version ="17.0.1"
    modules=listOf("javafx.controls","javafx.fxml")
}

application {
    mainModule.set("org.bham")
    mainClass.set("org.bham.HelloApplication")
    applicationDefaultJvmArgs = mutableListOf(
        "--module-path",  sourceSets.main.get().runtimeClasspath.asPath,
        "--add-modules", "javafx.controls,javafx.fxml"
    )
}

java {
    modularity.inferModulePath = true
}


tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Copy>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}


