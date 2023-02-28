/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.5.1/userguide/building_java_projects.html
 */

group = "org.eclipse"
version = "v1.2.2-alpha"


plugins {
    // Apply the java-library plugin for API and implementation separation.
    id("java-library")

    // Apply the maven-publish plugin for API and implementation separation. 
    id("maven-publish")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()

    mavenLocal()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    // WireMock
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.33.2")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:31.0.1-jre")
    
    
    // Jarkarta - HTTP implementation
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")
    implementation("org.glassfish.jersey.core:jersey-client:3.1.0-M3")
    implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.0-M3")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:3.1.0-M3")  

    // Lombok - Decorator
    compileOnly("org.projectlombok:lombok:1.18.26")
	annotationProcessor("org.projectlombok:lombok:1.18.26")
	
	testCompileOnly("org.projectlombok:lombok:1.18.26")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.26")
}

tasks.test {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.jar {
    archiveBaseName.set("tsp-java-client")
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name, 
            "Implementation-Version" to project.name))
    }
}

publishing {
    publications {
        create<MavenPublication>("tsp-java-client").from(components["java"])
        create<MavenPublication>("tsp-java-client-insiders"){
            artifactId = "tsp-java-client-insiders"
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/spiritus2424/tsp-java-client")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}