package com.microservice.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(@NotNull(message = "Product name is required") String name);
}
