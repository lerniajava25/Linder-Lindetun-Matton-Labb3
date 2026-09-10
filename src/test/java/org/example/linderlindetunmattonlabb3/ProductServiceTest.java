package org.example.linderlindetunmattonlabb3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();

        Product laptop = new Product(
                "1",
                "Laptop",
                12000.0,
                "Electronics",
                10,
                LocalDate.of(2027, 12, 31),
                LocalDate.now()
        );

        Product mouse = new Product(
                "2",
                "Mouse",
                500.0,
                "Electronics",
                25,
                LocalDate.of(2028, 1, 31),
                LocalDate.now()
        );

        Product monitor = new Product(
                "3",
                "Monitor",
                4000.0,
                "Electronics",
                8,
                LocalDate.of(2028,6,15),
                LocalDate.now()
        );

        Product keyboard = new Product(
                "4",
                "Keyboard",
                1000.0,
                "Electronics",
                15,
                LocalDate.of(2028,7,17),
                LocalDate.now()
        );

        Product coffee = new Product(
                "5",
                "Coffee",
                30,
                "Drinks",
                20,
                LocalDate.of(2028, 3, 28),
                LocalDate.now()
        );

        productService.addProduct(laptop);
        productService.addProduct(mouse);
        productService.addProduct(monitor);
        productService.addProduct(keyboard);
        productService.addProduct(coffee);
    }

    @Test
    void shouldReturnProductsInCategory() {
        List<Product> categoryProducts = productService.getProductsInCategory("Electronics");

        assertThat(categoryProducts)
                .hasSize(4)
                .doesNotContain(productService.getProduct("5"));
    }

    @Test
    void shouldReturnProductsBelowStockThreshold() {
        List<Product> productsBelowStock = productService.getProductsBelowStockThreshold(11);

        assertThat(productsBelowStock).hasSize(2).doesNotContain(
                productService.getProduct("2"),
                productService.getProduct("4"),
                productService.getProduct("5")
        );
    }

    @Test
    void shouldReturnMostExpensiveProductsInDescendingOrder(){
        List<Product> result = productService.getMostExpensiveProducts(3);

        assertEquals(3, result.size());
        assertEquals("Laptop", result.get(0).getName());
        assertEquals("Monitor", result.get(1).getName());
        assertEquals("Keyboard", result.get(2).getName());
    }

    @Test
    void shouldReturnEmptyListIfLimitEqualsZero(){
        List<Product> result = productService.getMostExpensiveProducts(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfLimitIsLessThanZero(){
        assertThrows(
            IllegalArgumentException.class,
                ()-> productService.getMostExpensiveProducts(-3)
        );
    }

    @Test
    void shouldReturnAllProductsIfLimitIsGreaterThanNumberOfProducts(){
        List<Product> result = productService.getMostExpensiveProducts(12);
        assertEquals(4, result.size());
    }

    @Test
    void shouldReturnEmptyListIfNoProductsExists(){
        ProductService emptyProductService = new ProductService();

        List<Product> result = emptyProductService.getMostExpensiveProducts(5);

        assertTrue(result.isEmpty());
    }
    @Test
    void shouldCalculateTotalStockValueByCategory(){
        Map<String, Double> result = productService.getTotalStockValueByCategory();

        assertEquals(179500.0, result.get("Electronics"), 0.0001);
    }
    @Test
    void shouldCalculateAveragePriceByCategory(){
        Map<String, Double> result = productService.getAveragePriceByCategory();

        assertEquals(4375.0, result.get("Electronics"), 0.0001);
    }

}
