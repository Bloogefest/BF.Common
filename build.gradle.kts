plugins {
    id("java")
}

group = "com.bloogefest"
version = "4.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:23.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<Javadoc>("javadoc") {
    val options = options as CoreJavadocOptions

    options.encoding = "UTF-8"

    options.addStringOption("Xdoclint:none", "-quiet")
    options.addStringOption("tag", "apiNote:a:API Note:")
    options.addStringOption("tag", "implSpec:a:Implementation Requirements:")
    options.addStringOption("tag", "implNote:a:Implementation Note:")
}

tasks.getByName<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}

tasks.getByName<JavaCompile>("compileTestJava") {
    options.encoding = "UTF-8"
}
