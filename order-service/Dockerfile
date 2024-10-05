FROM eclipse-temurin:21-jdk

WORKDIR /app


COPY target/order-service-0.0.1-SNAPSHOT.jar order-service.jar


EXPOSE 8030

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "order-service.jar"]