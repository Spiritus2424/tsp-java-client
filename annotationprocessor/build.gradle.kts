
version = "v1"
plugins {
     // Apply the java-library plugin for API and implementation separation.
    id("java-library")
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
	annotationProcessor("com.google.auto.service:auto-service:1.0.1")
	compileOnly("com.google.auto.service:auto-service:1.0.1")
	
	// Javapoet
	implementation("com.squareup:javapoet:1.13.0")
}
