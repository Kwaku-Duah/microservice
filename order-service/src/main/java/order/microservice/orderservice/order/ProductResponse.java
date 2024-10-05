package order.microservice.orderservice.order;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Long productId;
    private String name;
    private String description;
    private double availableQuantity;
    private double price;

}
