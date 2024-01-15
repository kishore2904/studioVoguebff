# Use the official OpenJDK base image for Java 17
FROM gradle:jdk17

# Set the working directory inside the container
WORKDIR /studioVogue

# Copy the Gradle wrapper files and build.gradle for dependency resolution
COPY gradlew .
COPY gradle gradle
COPY build.gradle .

# Copy the project source code
COPY src src

# Build the application using Gradle
RUN ./gradlew build

# Print the path of the build directory
RUN echo "Build directory: /app/build"

# Expose the port that the application will run on (adjust as needed)
EXPOSE 8081

RUN ls -la /app/build/libs/
# Command to run the application
CMD ["java", "-jar", "build/libs/studioVogue-0.0.1-SNAPSHOT.jar"]
