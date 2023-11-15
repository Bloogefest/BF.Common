# BF.Common

[![RELEASE](https://img.shields.io/github/v/release/Bloogefest/BF.Common?style=for-the-badge)](https://github.com/Bloogefest/BF.Common/releases/latest)
[![CI/CD](https://img.shields.io/github/actions/workflow/status/Bloogefest/BF.Common/master.yml?label=CI%2FCD&style=for-the-badge)](https://github.com/Bloogefest/BF.Common/actions/workflows/master.yml)

### Описание

`BF.Common` — это библиотека общего назначения. Пока что она предоставляет только некоторые общие инструменты для
создания объектов, функционального программирования и валидации значений, однако планируется её расширение и
переработка, введение новых инструментов для создания объектов, функциональных инструментов, переработка старых,
расширение и переработка интерфейса инструментов валидации значений и, может быть, что-нибудь ещё.

В данный момент ведётся активная разработка и отлаживание таких функциональных инструментов, как: `Container`,
`BiContainer`, `TriContainer`, `Optional`, `BiOptional`, `TriOptional`, `Catcher` и `Conveyor`. Некоторые из них
являются экспериментальными и часто изменяются, поэтому рекомендуется воздержаться от их использования хотя бы до выхода
выпуска `4.0.0-RC3`.

### Подключение

#### Выпуск-кандидата

##### Maven

```xml
<repository>
  <id>ossrh-rc</id>
  <url>https://s01.oss.sonatype.org/content/repositories/releases/</url>
</repository>
```

```xml
<dependency>
  <groupId>com.bloogefest</groupId>
  <artifactId>common</artifactId>
  <version>4.0.0-RC2</version>
</dependency>
```

##### Gradle

```kotlin
maven("https://s01.oss.sonatype.org/content/repositories/releases/")
```

```kotlin
implementation("com.bloogefest:common:4.0.0-RC2")
```

#### Снимка

##### Maven

```xml
<repository>
  <id>ossrh-snapshot</id>
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

##### Gradle

```kotlin
maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
```

```kotlin
implementation("com.bloogefest:common:4.0.0-SNAPSHOT")
```
