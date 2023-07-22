# BF.Common

[![RELEASE](https://img.shields.io/github/v/release/Bloogefest/BF.Common?style=for-the-badge)](https://github.com/Bloogefest/BF.Common/releases/latest)
[![CI/CD](https://img.shields.io/github/actions/workflow/status/Bloogefest/BF.Common/master.yml?label=CI%2FCD&style=for-the-badge)](https://github.com/Bloogefest/BF.Common/actions/workflows/master.yml)

### Описание

`BF.Common` — это библиотека общего назначения. Пока что она предоставляет только некоторые общие инструменты для
создания объектов, функционального программирования и валидации значений, однако планируется её расширение и
переработка, введение новых инструментов для создания объектов, функциональных инструментов, переработка старых,
расширение и переработка интерфейса инструментов валидации значений и, может быть, что-нибудь ещё.

### Подключение

#### Выпуск-кандидата

С помощью `Maven`.

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
  <version>4.0.0-RC2</version>
</dependency>
```

С помощью `Gradle`.

```kotlin
maven {
    name = "OSSRH RC"
    url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
}
```

```kotlin
implementation("com.bloogefest:common:4.0.0-RC2")
```

#### Снимка

С помощью `Maven`.

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

C помощью `Gradle`.

```kotlin
maven {
    name = "OSSRH SNAPSHOT"
    url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}
```

```kotlin
implementation("com.bloogefest:common:4.0.0-SNAPSHOT")
```

### Краткий обзор

#### Работа с инструментами создания объектов

...

#### Работа с функциональными инструментами

...

#### Работа с инструментами валидации значений

Гарантирует, что внутренний объект является нулевым.

```java
Validator.isNull(object, "The internal object");
```

Гарантирует, что переданный объект не является нулевым.

```java
Validator.notNull(object, "The passed object");
```

Гарантирует, что переданный и внутренний объекты равны.

```java
Validator.equals(object1, object2, "The passed object", "The internal object");
```

Гарантирует, что переданный первый и второй объекты неравны.

```java
Validator.notEquals(object1, object2, "The first passed object", "The second passed object");
```