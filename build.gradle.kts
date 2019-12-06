plugins {
    kotlin("jvm") version "1.3.61"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.20")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.6")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.6")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("au.com.dius:pact-jvm-consumer-junit:4.0.0-beta.6")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}