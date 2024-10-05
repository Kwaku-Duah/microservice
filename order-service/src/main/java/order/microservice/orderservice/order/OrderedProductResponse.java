package order.microservice.orderservice.order;

public record OrderedProductResponse(
         Long orderId,
         Long productId,
         String name,
         String description,
         double availableQuantity,
         double price
) {}
