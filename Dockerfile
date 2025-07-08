FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/agenda-back
RUN mvn -v
RUN mvn -f /home/app/agenda-back/pom.xml clean package



FROM alpine/java:21-jdk
COPY COPY --from=build /home/app/agenda-back/target/agenda-back-0.0.1-SNAPSHOT.jar agenda-back.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/agenda-back.jar"]