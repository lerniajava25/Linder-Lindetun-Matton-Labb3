package org.example.linderlindetunmattonlabb3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class WarehouseController {
    Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @GetMapping("/products")
    public void getProducts() {
        logger.info("get products called");
        // anropa get-metod i servicen
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody String body, String id) {
        logger.info("created product with id {}, name {}", id, body);
        // anropa post-metod i servicen
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody String body, @PathVariable String id) {
        logger.info("updated product with id {}, name {}", id, body);
        // anropa put-metod i servicen
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable String id) {
        logger.info("deleted product with id {}", id);
        // anropa delete-metod i servicen
    }
}

