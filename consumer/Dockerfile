# syntax=docker/dockerfile:1

FROM openjdk:8
ADD ./target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
ENTRYPOINT [ "java", "-jar", "./consumer.jar" ]