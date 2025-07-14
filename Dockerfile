# Stage 1: Build the application
FROM eclipse-temurin:21-jdk AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:21-jre

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
#COPY --from=build /app/target/convertNumber-0.0.1-SNAPSHOT.jar app.jar

# Copy the application JAR file to the container
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port (default for Spring Boot is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
