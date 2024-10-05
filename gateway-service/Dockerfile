FROM eclipse-temurin:21-jdk

WORKDIR /app


COPY target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service.jar


EXPOSE 8020

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
