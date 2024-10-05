package order.microservice.orderservice.order;

import org.springframework.stereotype.Service;

@Service
public class OrderedProductMapper {

    public OrderedProductResponse convertToOrderedProductResponse(OrderedProduct orderedProduct) {
        return new OrderedProductResponse(
                orderedProduct.getOrderId(),
                orderedProduct.getProductId(),
                orderedProduct.getName(),
                orderedProduct.getDescription(),
                orderedProduct.getAvailableQuantity(),
                orderedProduct.getPrice()
        );
    }

    public ProductResponse convertToProductResponse(OrderedProduct orderedProduct) {
        return ProductResponse.builder()
                .productId(orderedProduct.getProductId())
                .name(orderedProduct.getName())
                .description(orderedProduct.getDescription())
                .availableQuantity(orderedProduct.getAvailableQuantity())
                .price(orderedProduct.getPrice())
                .build();
    }
}
