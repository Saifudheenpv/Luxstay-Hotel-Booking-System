# ===========================================
# BUILD STAGE: Build the Spring Boot JAR
# ===========================================
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only pom.xml first for better build caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the actual source code
COPY src ./src

# Package the application (skip tests for CI speed)
RUN mvn clean package -DskipTests


# ===========================================
# RUNTIME STAGE: Run the built JAR
# ===========================================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Install curl & wget for health checks (Debian base → use apt)
RUN apt-get update && apt-get install -y curl wget && rm -rf /var/lib/apt/lists/*

# Create a non-root user for better container security
RUN useradd -ms /bin/bash spring
USER spring

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Add a health check for Kubernetes liveness/readiness probes
HEALTHCHECK --interval=30s --timeout=5s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application with optimized JVM settings for containers
ENTRYPOINT ["java", "-jar", \
  "-Dspring.profiles.active=prod", \
  "-Djava.security.egd=file:/dev/./urandom", \
  "-XX:+UseContainerSupport", \
  "-XX:MaxRAMPercentage=75.0", \
  "app.jar"]
