# FluentSQL

FluentSQL is an embedded DSL/fluent API for creating SQL query strings with compile-time syntax checking.

## Installation

### Gradle
```groovy
repositories {
    maven {
        url 'https://oss.sonatype.org/content/repositories/snapshots'
    }
}

dependencies {
    implementation 'io.mikedeakin:FluentSql:1.0-SNAPSHOT'
}
```

## Usage

```java
String selectStatement = SqlBuilders
    .select("*")
    .from("table_name")
    .where("integer_column > 6")
    .build();

String updateStatement = SqlBuliders
    .update("table_name")
    .set("varchar_column", "'New Value'")
    .build();
```

## License
[MIT](https://choosealicense.com/licenses/mit/)