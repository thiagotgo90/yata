FROM openjdk:8-alpine

RUN mkdir -p /app

ADD target/yetanothertodoapplication-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081

ENTRYPOINT [ "/usr/bin/java", "-jar", "/app/app.jar" ]