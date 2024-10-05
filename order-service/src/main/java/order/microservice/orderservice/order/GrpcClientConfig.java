package order.microservice.orderservice.order;

import com.microservices.ecommerce.grpc.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {
    @Bean
    public ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub(
            @GrpcClient("product-service") ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub) {
        return productServiceBlockingStub;
    }
}
