package com.microservice.ecommerce.product;


import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public  Product convertToEntity(ProductRequest request) {
        return Product.builder()
                .productId(request.productId())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .build();
    }

    public  ProductResponse ConvertToResponse(Product product) {
        return new  ProductResponse(
                 product.getProductId(),
                 product.getName(),
                 product.getDescription(),
                 product.getAvailableQuantity(),
                 product.getPrice()

        );
    }


}
