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

# Use Maven image to build and run the application
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download project dependencies
RUN mvn dependency:go-offline -B

# Copy your source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Specify the command to run your application
CMD ["java", "-jar", "target/*.jar"]

