plugins {
    id("java")
    id("maven-publish")
    id("signing")
}

group = "com.bloogefest"
version = "4.0"
description = "Библиотека общего назначения."

repositories {
    mavenLocal()
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

publishing {
    publications {
        create<MavenPublication>("master") {
            artifactId = "common"

            from(components["java"])

            pom {
                name.set("BF.Common")
                description.set(project.description)
                url.set("https://github.com/Bloogefest/BF.Common")

                licenses {
                    license {
                        name.set("Mozilla Public License Version 2.0")
                        url.set("https://mozilla.org/MPL/2.0/")
                    }
                }

                developers {
                    developer {
                        id.set("Bloogefest")
                        name.set("George Sopin")
                        url.set("https://github.com/Bloogefest")
                        timezone.set("W-SU")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Bloogefest/BF.Common.git")
                    developerConnection.set("scm:git:ssh://github.com/Bloogefest/BF.Common.git")
                    url.set("https://github.com/Bloogefest/BF.Common")
                }

                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/Bloogefest/BF.Common/issues")
                }

                ciManagement {
                    system.set("Github")
                    url.set("https://github.com/Bloogefest/BF.Common/actions")
                }
            }
        }
    }

    repositories {
        maven {
            val version = version.toString()
            url = uri(findProperty(when {
                "-SNAPSHOT" in version -> "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                "-RC" in version -> "https://s01.oss.sonatype.org/content/repositories/releases/"
                else -> "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            }).toString())

            credentials {
                username = findProperty("OSSRH_CREDENTIALS_USERNAME").toString()
                password = findProperty("OSSRH_CREDENTIALS_PASSWORD").toString()
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(findProperty("SINGING_KEY_ID").toString(),
                       findProperty("SINGING_KEY_SECRET").toString(),
                       findProperty("SINGING_KEY_PASSWORD").toString())

    sign(publishing.publications["master"])
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
