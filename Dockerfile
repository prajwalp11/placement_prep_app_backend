#FROM ubuntu:latest
#LABEL authors="prajw"
#
#ENTRYPOINT ["top", "-b"]

# FROM maven:3.8.5-openjdk-17 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
# COPY -- from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 8080
# ENTRYPOINT ["ja%a","-jar","demo.jar"]
# Build stage
# Build stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .           # Copy the pom.xml to resolve dependencies
RUN mvn dependency:go-offline # Download dependencies

COPY src ./src           # Copy the source code
RUN mvn clean package    # Package the project (skip tests if necessary)

# Package stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]

