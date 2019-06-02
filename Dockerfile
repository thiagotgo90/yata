FROM openjdk:8-jdk

RUN mkdir -p /app

ADD target/yetanothertodoapplication-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ADD wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT [ "/wait-for-it.sh", "-t", "60", "db:3306", "--", "java", "-jar", "-Dspring.profiles.active=prod", "/app/app.jar"]