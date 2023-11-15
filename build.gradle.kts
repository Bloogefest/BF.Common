plugins {
    id("java")
    id("maven-publish")
    id("signing")
}

group = "com.bloogefest"
version = "4.0.0-SNAPSHOT"
description = "Библиотека общего назначения."

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.bloogefest:annotation:3.0.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

publishing {
    publications {
        create<MavenPublication>("master") {
            artifactId = "common"
            from(components["java"])
            pom {
                name = project.name
                description = project.description
                url = "https://github.com/Bloogefest/BF.Common"
                licenses {
                    license {
                        name = "Mozilla Public License 2.0"
                        url = "https://mozilla.org/MPL/2.0/"
                        distribution = "repo"
                    }
                }
                developers {
                    developer {
                        id = "Bloogefest"
                        name = "George Sopin"
                        url = "https://github.com/Bloogefest"
                        timezone = "Europe/Moscow"
                    }
                }
                issueManagement {
                    system = "Github"
                    url = "https://github.com/Bloogefest/BF.Common/issues"
                }
                ciManagement {
                    system = "Github"
                    url = "https://github.com/Bloogefest/BF.Common/actions"
                }
                scm {
                    connection = "scm:git:git://github.com/Bloogefest/BF.Common.git"
                    developerConnection = "scm:git:ssh://github.com/Bloogefest/BF.Common.git"
                    url = "https://github.com/Bloogefest/BF.Common"
                }
                distributionManagement {
                    downloadUrl = "https://github.com/Bloogefest/BF.Common"
                }
            }
        }
    }
    repositories {
        maven {
            name = "OSSRH"
            val version = version.toString()
            url = uri(
                when {
                    "-SNAPSHOT" in version -> "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                    "-RC" in version -> "https://s01.oss.sonatype.org/content/repositories/releases/"
                    else -> "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                }
            )
            credentials {
                username = System.getenv("OSSRH_CREDENTIALS_USERNAME")
                password = System.getenv("OSSRH_CREDENTIALS_PASSWORD")
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("SINGING_KEY_ID"), System.getenv("SINGING_KEY_SECRET"), System.getenv("SINGING_KEY_PASSWORD")
    )

    sign(publishing.publications["master"])
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.javadoc {
    val options = options as CoreJavadocOptions
    options.encoding = "UTF-8"
    options.addStringOption("Xdoclint:none", "-quiet")
    options.addStringOption("tag", "apiNote:a:API Note:")
    options.addStringOption("tag", "implSpec:a:Implementation Requirements:")
    options.addStringOption("tag", "implNote:a:Implementation Note:")
}
