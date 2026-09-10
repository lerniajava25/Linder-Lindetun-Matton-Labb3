package org.example.linderlindetunmattonlabb3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.List;

@RestController
public class WarehouseController {
    Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    private final ProductService productService;

    public WarehouseController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer maxStock,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) Integer limit) {

        if (category != null && !category.isBlank()) {
            logger.info("get products with category {} called", category);
            return productService.getProductsInCategory(category);
        }

        if (maxStock != null) {
            logger.info("get products with stock below {} called", maxStock);
            return productService.getProductsBelowStockThreshold(maxStock);
        }

        if ("price".equalsIgnoreCase(sort)) {
            if (limit == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Limit is required when sorting by price"
                );
            }
            if (limit < 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Limit can not be negative"
                );
            }
            logger.info("get {} most expensive products called", limit);
            return productService.getMostExpensiveProducts(limit);
        }
        logger.info("get products called");
        return productService.getProducts();
    }
    @GetMapping("/analysis/stock-value")
    public Map<String, Double> getTotalStockValueByCategory() {
        return productService.getTotalStockValueByCategory();
    }
    @GetMapping("/analysis/average-price")
    public Map<String, Double> getAveragePriceByCategory() {
        return productService.getAveragePriceByCategory();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product body) {
        logger.info("created product with name {}", body.getName());
        productService.addProduct(body);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product body, @PathVariable String id) {
        logger.info("updated product with id {}, name {}", id, body);
        productService.updateProduct(body);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable String id) {
        logger.info("deleted product with id {}", id);
        productService.deleteProduct(id);
    }
}

