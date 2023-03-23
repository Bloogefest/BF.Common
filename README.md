# BF.Common

[![RELEASE](https://img.shields.io/github/v/release/Bloogefest/BF.Common?style=for-the-badge)](https://github.com/Bloogefest/BF.Common/releases/latest)
[![CI/CD](https://img.shields.io/github/actions/workflow/status/Bloogefest/BF.Common/master.yml?label=CI%2FCD&style=for-the-badge)](https://github.com/Bloogefest/BF.Common/actions/workflows/master.yml)

### Release Candidate

#### Maven

```xml
<repository>
  <id>ossrh-rc</id>
  <name>OSSRH RC</name>
  <url>https://s01.oss.sonatype.org/content/repositories/releases/</url>
</repository>
```

```xml
<dependency>
  <groupId>com.bloogefest</groupId>
  <artifactId>common</artifactId>
  <version>4.0.0-RC1</version>
</dependency>
```

#### Gradle

```kotlin
repositories {
    maven {
        name = "OSSRH RC"
        url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
    }
}
```

```kotlin
dependencies {
    implementation("com.bloogefest:common:4.0.0-RC1")
}
```

### Snapshot

#### Maven

```xml
<repository>
  <id>ossrh-snapshot</id>
  <name>OSSRH SNAPSHOT</name>
  <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
</repository>
```

```xml
<dependency>
  <groupId>com.bloogefest</groupId>
  <artifactId>common</artifactId>
  <version>4.0.0-SNAPSHOT</version>
</dependency>
```

#### Gradle

```kotlin
repositories {
    maven {
        name = "OSSRH SNAPSHOT"
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
}
```

```kotlin
dependencies {
    implementation("com.bloogefest:common:4.0.0-SNAPSHOT")
}
```