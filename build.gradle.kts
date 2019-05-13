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
    java
    id("info.solidsoft.pitest") version("1.4.0")
}

group = "me.mikedeakin"
version = "1.0-SNAPSHOT"

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