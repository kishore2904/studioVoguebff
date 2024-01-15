# Use the official OpenJDK base image for Java 17
FROM gradle:jdk17

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper files and build.gradle for dependency resolution
COPY gradlew .
COPY gradle gradle
COPY build.gradle .

# Copy the project source code
COPY src src

# Build the application using Gradle
RUN ./gradlew build

# Expose the port that the application will run on (adjust as needed)
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "build/libs/studioVogue-0.0.1-SNAPSHOT.jar"]
