FROM eclipse-temurin:21-jdk

WORKDIR /app


COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar


EXPOSE 8050


ENTRYPOINT ["java", "-jar", "product-service.jar"]