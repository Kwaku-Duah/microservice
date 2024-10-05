package samuel.gateway_service.gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/api/v1/products/**")
                        .uri("http://localhost:8050"))
                .route("order-service", r -> r.path("/api/v1/orders/**")
                        .uri("http://localhost:8030"))
                .build();
    }
}
