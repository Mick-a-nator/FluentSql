import info.solidsoft.gradle.pitest.PitestTask

buildscript {
    repositories {
        mavenCentral()
    }
    configurations.maybeCreate("pitest")
    dependencies {
        "classpath"("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.2.4")
        "pitest"("org.pitest:pitest-junit5-plugin:0.7")
    }
}

plugins {
    `java-library`
    `maven-publish`
    signing
    id("info.solidsoft.pitest") version("1.4.0")
}

group = "io.mikedeakin"
version = "1.0-SNAPSHOT"

tasks.register<Jar>("sourcesJar") {
    classifier = "sources"
    from(sourceSets["main"].allJava)
}

tasks.register<Jar>("javadocJar") {
    classifier = "javadoc"
    from(tasks.getByName("javadoc", Javadoc::class).destinationDir)
}

publishing {
    publications {
        create<MavenPublication>("mavenFluentSql") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
        }
    }

    repositories {
        maven {
            name = "local"
            url = uri("file://$buildDir/repo")
        }
    }
}

signing {
    sign(publishing.publications["mavenFluentSql"])
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    "pitest"(PitestTask::class) {
        testPlugin = "junit5"
    }
    "test"(Test::class) {
        useJUnitPlatform()
    }
}