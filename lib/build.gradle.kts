/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.5.1/userguide/building_java_projects.html
 */

group = "org.eclipse"
version = "v2.0.3-alpha"


plugins {
    // Apply the java-library plugin for API and implementation separation.
    id("java-library")
	
    // Apply the maven-publish plugin for API and implementation separation. 
    id("maven-publish")
}

java {
	
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    
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

	// Custom Annotation
	// annotationProcessor(files(":tsp-java-client.core.async.AsyncProcessor"))
	compileOnly(project(":annotation"))
	annotationProcessor(project(":annotation"))

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

    // Jcabi-Aspects - Async Decorator
    implementation("com.jcabi:jcabi-aspects:0.24.1")
    runtimeOnly("org.aspectj:aspectjrt:1.9.19")
    implementation("com.jcabi:jcabi-maven-plugin:0.17.0")

	// Stopwatch
	testImplementation("org.apache.commons:commons-lang3:3.12.0")

	// Javapoet
	implementation("com.squareup:javapoet:1.13.0")

	// Google - Auto Service
	implementation("com.google.auto.service:auto-service:1.0.1")
}

// tasks.compileJava {
// 	doFirst {
//         println("AnnotationProcessorPath for $name is ${options.getAnnotationProcessorPath()?.getFiles()}")
//     }
//     // options.annotationProcessorPath += annotationProcessor
//     // options.compilerArgs.addAll(listOf(
//     //     "-proc:only",
//     //     "-processor", "org.eclipse.tsp.java.client.core.async.AsyncProcessor"
//     // ))
// }

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
