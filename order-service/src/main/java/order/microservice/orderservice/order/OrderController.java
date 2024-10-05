package order.microservice.orderservice.order;

import com.google.protobuf.InvalidProtocolBufferException;
import com.microservices.ecommerce.grpc.ProductProto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/shipping/{orderId}")
    public ResponseEntity<OrderedProductResponse> getOrderById(@PathVariable("orderId") Long orderId) {
        OrderedProductResponse orderedProduct = orderService.getOrderedProduct(orderId);
        return new ResponseEntity<>(orderedProduct, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Long productId) throws InvalidProtocolBufferException {
        ProductResponse productResponse = orderService.getProduct(productId);
       return ResponseEntity.ok(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderedProductResponse>> getAllProducts() {
        List<OrderedProductResponse> orderedProducts = orderService.getOrderedProducts();
        return ResponseEntity.ok(orderedProducts);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrderedProduct(orderId);
        return ResponseEntity.noContent().build();
    }
}
