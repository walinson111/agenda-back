FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/agenda-back
RUN mvn -v
RUN mvn -f /home/app/agenda-back/pom.xml clean package



FROM alpine/java:21-jdk
COPY --from=build /home/app/agenda-back/target/*.jar /usr/local/lib/agenda-back.jar
VOLUME /tmp
EXPOSE 80:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/agenda-back.jar"]

