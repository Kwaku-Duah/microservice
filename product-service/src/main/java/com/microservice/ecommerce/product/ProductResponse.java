package com.microservice.ecommerce.product;

public record ProductResponse(

         Long productId,
         String name,
         String description,
         double availableQuantity,
         double price

){}


