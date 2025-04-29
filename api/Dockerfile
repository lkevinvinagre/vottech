FROM ubuntu:latest AS build

RUN apt-get update 
RUN apt-get install openjdk-24-jdk -y

COPY pom.xml .
COPY src ./src

RUN apt-get install maven -y
RUN mvn clean package

FROM openjdk:17-jdk-slim@sha256:<latest-secure-digest>


COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]