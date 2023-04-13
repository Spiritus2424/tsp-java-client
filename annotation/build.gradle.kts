
version = "v1"
plugins {
    // Apply the java-library plugin for API and implementation separation.
    id("java")
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
	// Google - Auto Service
	implementation("com.google.auto.service:auto-service:1.0.1")
}


// sourceSets {
//     main {
//         java {
//             srcDirs("src/main/java", "build/generated/sources/annotationProcessor/java/main")
//         }
//     }
// }

// tasks.withType<JavaCompile> {
//     options.annotationProcessorGeneratedSourcesDirectory = file("build/generated/sources/annotationProcessor/java/main")
// }
