FROM ubuntu:latest AS build

RUN apt-get update 
RUN apt-get install openjdk-17-jdk -y

COPY pom.xml /app/pom.xml
COPY src /app/src
WORKDIR /app


RUN apt-get install maven -y
RUN mvn clean package

FROM openjdk:17-jdk-slim


COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]