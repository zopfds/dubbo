# syntax=docker/dockerfile:1

FROM openjdk:8
ADD ./target/provider-0.0.1-SNAPSHOT.jar provider.jar
ENTRYPOINT [ "java", "-jar", "./provider.jar" ]