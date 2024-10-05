# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
