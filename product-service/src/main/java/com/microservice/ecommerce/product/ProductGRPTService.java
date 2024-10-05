package com.microservice.ecommerce.product;


import com.microservice.ecommerce.exception.ProductNotFoundException;
import com.microservices.ecommerce.grpc.ProductProto;
import com.microservices.ecommerce.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class ProductGRPTService extends ProductServiceGrpc.ProductServiceImplBase {
    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductGRPTService.class);

    public ProductGRPTService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void getProduct(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {

        Product product = productRepository.findById(request.getProductId()).orElseThrow(()->
                new ProductNotFoundException(request.getProductId()));

        ProductProto.ProductResponse productResponse = ProductProto.ProductResponse
                .newBuilder()
                .setProductId(product.getProductId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setQuantity(product.getAvailableQuantity())
                .setPrice(product.getPrice())
                .build();

        responseObserver.onNext(productResponse);

        logger.info("Order service just requested a product with id {}", product.getProductId());

        responseObserver.onCompleted();
    }
}
