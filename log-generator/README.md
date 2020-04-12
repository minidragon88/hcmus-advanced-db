# Description
This module is a stand alone Java application for generating log and sending data to the destination InfluxDB

# Prerequisite
Java version >= 1.8

Gradle version >= 4.9

# Run
```
./gradlew run --args='host_name ok'
```

Example

```
./gradlew run --args='0.0.0.1 ok'

./gradlew run --args='0.0.0.2 error'
```